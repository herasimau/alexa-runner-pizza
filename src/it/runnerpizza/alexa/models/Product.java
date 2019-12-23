package it.runnerpizza.alexa.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Product {

	private Long id;
	@JsonProperty("descrizioneIt")
	private String descriptionIt;
	@JsonProperty("descrizioneEn")
	private String descriptionEn;
	@JsonProperty("descrizioneEstesaIt")
	private String descriptionFullIt;
	@JsonProperty("descrizioneEstesaEn")
	private String descriptionFullEn;
	private String sortOrder;
	private String sortOrderCart;
	@JsonProperty("prezzoAsporto")
	private Integer pickupPrice;
	@JsonProperty("prezzoDomicilio")
	private Double deliveryPrice;
	@JsonProperty("visibile")
	private Boolean visible;
	@JsonProperty("lineaId")
	private Long lineId;
	@JsonProperty("variantes")
	private List<Variant> variants;
	@JsonProperty("attributos")
	private List<Object> attributes;
	@JsonProperty("menus")
	private List<Object> menuList;
	@JsonProperty("aggiunteDisponibili")
	private Object availableAdditions;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescriptionIt() {
		return descriptionIt;
	}

	public void setDescriptionIt(String descriptionIt) {
		this.descriptionIt = descriptionIt;
	}

	public String getDescriptionEn() {
		return descriptionEn;
	}

	public void setDescriptionEn(String descriptionEn) {
		this.descriptionEn = descriptionEn;
	}

	public String getDescriptionFullIt() {
		return descriptionFullIt;
	}

	public void setDescriptionFullIt(String descriptionFullIt) {
		this.descriptionFullIt = descriptionFullIt;
	}

	public String getDescriptionFullEn() {
		return descriptionFullEn;
	}

	public void setDescriptionFullEn(String descriptionFullEn) {
		this.descriptionFullEn = descriptionFullEn;
	}

	public String getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}

	public String getSortOrderCart() {
		return sortOrderCart;
	}

	public void setSortOrderCart(String sortOrderCart) {
		this.sortOrderCart = sortOrderCart;
	}

	public Integer getPickupPrice() {
		return pickupPrice;
	}

	public void setPickupPrice(Integer pickupPrice) {
		this.pickupPrice = pickupPrice;
	}

	public Double getDeliveryPrice() {
		return deliveryPrice;
	}

	public void setDeliveryPrice(Double deliveryPrice) {
		this.deliveryPrice = deliveryPrice;
	}

	public Boolean getVisible() {
		return visible;
	}

	public void setVisible(Boolean visible) {
		this.visible = visible;
	}

	public Long getLineId() {
		return lineId;
	}

	public void setLineId(Long lineId) {
		this.lineId = lineId;
	}

	public List<Variant> getVariants() {
		return variants;
	}

	public void setVariants(List<Variant> variants) {
		this.variants = variants;
	}

	public List<Object> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<Object> attributes) {
		this.attributes = attributes;
	}

	public List<Object> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<Object> menuList) {
		this.menuList = menuList;
	}

	public Object getAvailableAdditions() {
		return availableAdditions;
	}

	public void setAvailableAdditions(Object availableAdditions) {
		this.availableAdditions = availableAdditions;
	}
}
