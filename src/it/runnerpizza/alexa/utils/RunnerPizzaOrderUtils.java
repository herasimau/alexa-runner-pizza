package it.runnerpizza.alexa.utils;

import com.amazonaws.util.CollectionUtils;
import it.runnerpizza.alexa.enumeration.Pizza;
import it.runnerpizza.alexa.models.*;
import it.runnerpizza.alexa.service.*;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.util.*;

public class RunnerPizzaOrderUtils {

	private static final String APP_PROPERTIES = "application.properties";
	private static final String DELIVERY_TIME_TYPE = "PRIMA_POSSIBILE";
	private static final String DELIVERY_TIME_TYPE_STANDARD = "STANDARD";
	private static final String CLIENT_ID = "clientId";
	private static final String ZONE_ID = "zoneId";
	private static final String TIMESTAMP = "timestamp";
	private static final String DEVICE = "device";

	public static boolean confirmOrder(Long orderId) throws IOException {
		Map<String, String> cartParams = buildCartParams();

		Auth auth = RunnerPizzaAuthUtils.getAuth();
		PaymentService paymentService = ServiceGenerator.createService(PaymentService.class, auth.getAccessToken(), false);
		PaymentConfirmationService paymentConfirmationService = ServiceGenerator.createService(PaymentConfirmationService.class, auth.getAccessToken(), true);
		PaymentRequest response = paymentService.requestPayment(orderId,"CashOnDelivery", null, false, cartParams.get(TIMESTAMP), cartParams.get(DEVICE)).execute().body();

		if (response != null && response.getTransactionId() != null) {
			paymentConfirmationService.confirmPayment(response.getTransactionId()).execute();
			return true;
		} else {
			return false;
		}
	}

	public static OrderConfirmation order(Pizza pizza) throws IOException{
		Map<String, String> cartParams = buildCartParams();

		Auth auth = RunnerPizzaAuthUtils.getAuth();
		CartService cartService = ServiceGenerator.createService(CartService.class, auth.getAccessToken() , true);

		verifyCart(cartService, cartParams);
		addToCart(cartService, cartParams, pizza);
		return buildOrderConfirmation(auth, cartParams, pizza);
	}

	private static OrderConfirmation buildOrderConfirmation(Auth auth, Map<String, String> cartParams, Pizza pizza) throws IOException {
		AddressService addressService = ServiceGenerator.createService(AddressService.class, auth.getAccessToken(), false);
		DeliveryService deliveryService = ServiceGenerator.createService(DeliveryService.class, auth.getAccessToken(), true);
		OrderService orderService = ServiceGenerator.createService(OrderService.class, auth.getAccessToken(), false);

		List<Address> addressList = addressService.getAddresses(cartParams.get(TIMESTAMP)).execute().body();
		Address address = addressList.stream().findFirst().get();
		DeliveryInfo deliveryInfo = deliveryService.getDeliveryInfo(cartParams.get(ZONE_ID), cartParams.get(TIMESTAMP)).execute().body();

		OrderConfirmation orderConfirmation = new OrderConfirmation();
		orderConfirmation.setPizzaName(pizza.name);
		orderConfirmation.setAddress(address.getAddressAsText());
		orderConfirmation.setDeliveryTime(deliveryInfo.getMinDeliveryTime());

		Order order = createOrder(orderService, cartParams, address, deliveryInfo.getMinDeliveryTime());

		Order updatedOrder = orderService.updateOrder(cartParams.get(TIMESTAMP), order).execute().body();
		Double total = order.getOrderAmount() + order.getDeliveryAmount();
		orderConfirmation.setOrderAmount(total.toString());
		orderConfirmation.setOrder(updatedOrder);

		return orderConfirmation;
	}

	private static Order createOrder(OrderService orderService, Map<String, String> cartParams, Address address, String deliveryTime) throws IOException {
		Order order = orderService.getOrder(cartParams.get(TIMESTAMP), "1").execute().body();
		order.setAddressId(address.getId());
		order.setOrderDate(order.getOrderDate().replace("+01:00", "Z"));
		order.setDeliveryAmount(2);
		order.setDeliveryDate(LocalDate.now().toString());
		order.setDeliveryTimeType(DELIVERY_TIME_TYPE_STANDARD);
		order.setDeliveryTime(deliveryTime);
		order.setPickupInStore(false);
		order.setZona(cartParams.get(ZONE_ID));
		return order;
	}

	private static void addToCart(CartService cartService, Map<String, String> cartParams, Pizza pizza) throws IOException {
		AddToCart addToCart = new AddToCart();
		addToCart.setProductId(pizza.id);
		cartService.addToCart(cartParams.get(CLIENT_ID), cartParams.get(ZONE_ID), cartParams.get(TIMESTAMP), cartParams.get(DEVICE), addToCart).execute();
	}

	private static void verifyCart(CartService cartService, Map<String, String> cartParams) throws IOException {
		Cart cart = cartService.getCart(cartParams.get(CLIENT_ID), cartParams.get(ZONE_ID), cartParams.get(TIMESTAMP), cartParams.get(DEVICE)).execute().body();

		if (cart != null && cart.getOrder() != null && !CollectionUtils.isNullOrEmpty(cart.getOrder().getCartItems())) {
			cartService.emptyCart(cartParams.get(CLIENT_ID), cartParams.get(ZONE_ID), cartParams.get(TIMESTAMP), cartParams.get(DEVICE)).execute();
		}
	}



	private static Map<String, String> buildCartParams() throws IOException {
		Map<String, String> params = new HashMap<>();
		String timestamp = ((Long) Instant.now().toEpochMilli()).toString();
		Properties appProperties =  new Properties();
		appProperties.load(RunnerPizzaAuthUtils.class.getClassLoader().getResourceAsStream(APP_PROPERTIES));
		params.put(CLIENT_ID, appProperties.getProperty(CLIENT_ID));
		params.put(ZONE_ID, appProperties.getProperty(ZONE_ID));
		params.put(TIMESTAMP, timestamp);
		params.put(DEVICE, appProperties.getProperty(DEVICE));
		return params;
	}
}
