package it.runnerpizza.alexa.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Order {

	private Long id;
	@JsonProperty("statoOrdine")
	private String orderStatus;
	@JsonProperty("dataOrdine")
	private String orderDate;
	@JsonProperty("importoOrdine")
	private Double orderAmount;
	@JsonProperty("importoOrdineSenzaSconti")
	private Double orderAmountWithoutDiscount;
	@JsonProperty("importoSpedizione")
	private Integer deliveryAmount;
	@JsonProperty("dataConsegna")
	private String deliveryDate;
	@JsonProperty("dataUltimaModifica")
	private String lastModifiedDate;
	@JsonProperty("dataPagamento")
	private String paymentDate;
	@JsonProperty("tipoOrarioConsegna")
	private String deliveryTimeType;
	@JsonProperty("orarioConsegna")
	private String deliveryTime;
	@JsonProperty("ritiroAlLocale")
	private Boolean pickupInStore;
	@JsonProperty("dataDownload")
	private String downloadDate;
	@JsonProperty("tempCustomerUUID")
	private String tempUUID;
	@JsonProperty("feedbackId")
	private String feedbackId;
	@JsonProperty("clienteId")
	private Long clientId;
	@JsonProperty("localeId")
	private Long localeId;
	@JsonProperty("indirizzoId")
	private Long addressId;
	@JsonProperty("zona")
	private String zona;
	@JsonProperty("datiFatturazioneId")
	private Long invoiceId;
	@JsonProperty("scontoPromoziones")
	private List<Object> promotions;
	@JsonProperty("locale")
	private Object locale;
	@JsonProperty("device")
	private String device;
	@JsonProperty("ordineCongelato")
	private Boolean freezeOrder;
	@JsonProperty("dettaglioOrdine")
	private Object orderDetails;
	@JsonProperty("codiceCoupon")
	private String couponCode;
	@JsonProperty("scontoCoupon")
	private String couponDiscount;
	@JsonProperty("creditoUtilizzato")
	private String usedCredit;
	@JsonProperty("messaggi")
	private List<Object> messages;
	@JsonProperty("rigaOrdines")
	private List<CartItem> cartItems;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public Double getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(Double orderAmount) {
		this.orderAmount = orderAmount;
	}

	public Double getOrderAmountWithoutDiscount() {
		return orderAmountWithoutDiscount;
	}

	public void setOrderAmountWithoutDiscount(Double orderAmountWithoutDiscount) {
		this.orderAmountWithoutDiscount = orderAmountWithoutDiscount;
	}

	public Integer getDeliveryAmount() {
		return deliveryAmount;
	}

	public void setDeliveryAmount(Integer deliveryAmount) {
		this.deliveryAmount = deliveryAmount;
	}

	public String getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public String getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(String lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public String getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String getDeliveryTimeType() {
		return deliveryTimeType;
	}

	public void setDeliveryTimeType(String deliveryTimeType) {
		this.deliveryTimeType = deliveryTimeType;
	}

	public String getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(String deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	public Boolean getPickupInStore() {
		return pickupInStore;
	}

	public void setPickupInStore(Boolean pickupInStore) {
		this.pickupInStore = pickupInStore;
	}

	public String getDownloadDate() {
		return downloadDate;
	}

	public void setDownloadDate(String downloadDate) {
		this.downloadDate = downloadDate;
	}

	public String getTempUUID() {
		return tempUUID;
	}

	public void setTempUUID(String tempUUID) {
		this.tempUUID = tempUUID;
	}

	public String getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(String feedbackId) {
		this.feedbackId = feedbackId;
	}

	public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	public Long getLocaleId() {
		return localeId;
	}

	public void setLocaleId(Long localeId) {
		this.localeId = localeId;
	}

	public Long getAddressId() {
		return addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

	public String getZona() {
		return zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}

	public Long getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(Long invoiceId) {
		this.invoiceId = invoiceId;
	}

	public List<Object> getPromotions() {
		return promotions;
	}

	public void setPromotions(List<Object> promotions) {
		this.promotions = promotions;
	}

	public Object getLocale() {
		return locale;
	}

	public void setLocale(Object locale) {
		this.locale = locale;
	}

	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	public Boolean getFreezeOrder() {
		return freezeOrder;
	}

	public void setFreezeOrder(Boolean freezeOrder) {
		this.freezeOrder = freezeOrder;
	}

	public Object getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(Object orderDetails) {
		this.orderDetails = orderDetails;
	}

	public String getCouponCode() {
		return couponCode;
	}

	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}

	public String getCouponDiscount() {
		return couponDiscount;
	}

	public void setCouponDiscount(String couponDiscount) {
		this.couponDiscount = couponDiscount;
	}

	public String getUsedCredit() {
		return usedCredit;
	}

	public void setUsedCredit(String usedCredit) {
		this.usedCredit = usedCredit;
	}

	public List<Object> getMessages() {
		return messages;
	}

	public void setMessages(List<Object> messages) {
		this.messages = messages;
	}

	public List<CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}
}