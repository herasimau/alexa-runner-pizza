package it.runnerpizza.alexa.utils;

import com.amazon.ask.attributes.AttributesManager;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.model.Response;
import it.runnerpizza.alexa.enumeration.Pizza;
import it.runnerpizza.alexa.models.OrderConfirmation;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SkillUtils {

	public static ResourceBundle getResourceBundle(HandlerInput handlerInput, String bundleName) {
		final Locale locale = new Locale(handlerInput.getRequestEnvelope().getRequest().getLocale());
		return ResourceBundle.getBundle(MessagesData.BUNDLE_NAME, locale);
	}

	 public static Optional<Response> confirmOrderResponse(HandlerInput handlerInput, String bundleName, String messageKey) {
		final ResourceBundle messages = getResourceBundle(handlerInput, bundleName);
		final Map<String, Object> sessionAttributes = handlerInput.getAttributesManager().getSessionAttributes();
		Long orderId = Long.parseLong((String) sessionAttributes.get("orderId"));
		boolean result = false;
		try {
			 result = RunnerPizzaOrderUtils.confirmOrder(orderId);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		final String speechOutput = result ? messages.getString(messageKey) :  messages.getString(MessagesData.ORDER_ERROR_SPEECH);

		return handlerInput.getResponseBuilder()
				.withSpeech(speechOutput)
				.withShouldEndSession(true)
				.withReprompt(speechOutput)
				.build();
	}

	 public static Optional<Response> orderPizzaResponse(HandlerInput handlerInput, String pizzaName, String bundleName, String messageKey) {
		final ResourceBundle messages = getResourceBundle(handlerInput, bundleName);
		Pizza pizza = Pizza.fromName(pizzaName).get();
		OrderConfirmation orderConfirmation = null;
		try {
			AttributesManager attributesManager = handlerInput.getAttributesManager();
			Map<String,Object> attributes = attributesManager.getSessionAttributes();
			orderConfirmation = RunnerPizzaOrderUtils.order(pizza);
			attributes.put("orderId", orderConfirmation.getOrder().getId().toString());
			attributesManager.setSessionAttributes(attributes);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		final String speechOutput = String.format(messages.getString(messageKey), orderConfirmation.getPizzaName(), orderConfirmation.getAddress(), orderConfirmation.getDeliveryTime());
		return handlerInput.getResponseBuilder()
				.withSpeech(speechOutput)
				.withShouldEndSession(false)
				.withReprompt(speechOutput)
				.build();
	}

	public static Optional<Response> pizzaListResponse(HandlerInput handlerInput, String bundleName, String messageKey) {
		final String pizzaList = Stream.of(Pizza.MARGHERITA, Pizza.DIAVOLA).map(Pizza::name).collect(Collectors.joining(", "));
		final ResourceBundle messages = getResourceBundle(handlerInput, bundleName);
		final String speechOutput = String.format(messages.getString(messageKey), pizzaList);
		return handlerInput.getResponseBuilder()
				.withSpeech(speechOutput)
				.withShouldEndSession(false)
				.withReprompt(speechOutput)
				.build();
	}

}
