package it.runnerpizza.alexa.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CartItem {

	private Long id;
	@JsonProperty("ordineId")
	private Long orderId;
	@JsonProperty("totaleRiga")
	private Double totalAmount;
	@JsonProperty("prodotto")
	private Product product;
	@JsonProperty("dettaglioVariantes")
	private List<VariantDetail> variants;
	@JsonProperty("aggiuntas")
	private List<Object> additions;
	@JsonProperty("scontoPromoziones")
	private List<Object> promotions;
	@JsonProperty("dettaglioMenus")
	private List<Object> menus;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public List<VariantDetail> getVariants() {
		return variants;
	}

	public void setVariants(List<VariantDetail> variants) {
		this.variants = variants;
	}

	public List<Object> getAdditions() {
		return additions;
	}

	public void setAdditions(List<Object> additions) {
		this.additions = additions;
	}

	public List<Object> getPromotions() {
		return promotions;
	}

	public void setPromotions(List<Object> promotions) {
		this.promotions = promotions;
	}

	public List<Object> getMenus() {
		return menus;
	}

	public void setMenus(List<Object> menus) {
		this.menus = menus;
	}
}
