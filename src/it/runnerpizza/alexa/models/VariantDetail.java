package it.runnerpizza.alexa.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class VariantDetail {

	private Long id;
	@JsonProperty("descrizioneIt")
	private String descriptionIt;
	@JsonProperty("descrizioneEn")
	private String descriptionEn;
	private Integer price;
	private Boolean varianteDefault;
	private Integer sortOrder;
	@JsonProperty("varianteId")
	private Long variantId;
	@JsonProperty("varianteLabelIt")
	private String variantLabelIt;
	@JsonProperty("varianteLabelEn")
	private String variantLabelEn;
	@JsonProperty("varianteOrder")
	private Integer variantOrder;
	private Boolean visibile;

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

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Boolean getVarianteDefault() {
		return varianteDefault;
	}

	public void setVarianteDefault(Boolean varianteDefault) {
		this.varianteDefault = varianteDefault;
	}

	public Boolean getVisibile() {
		return visibile;
	}

	public void setVisibile(Boolean visibile) {
		this.visibile = visibile;
	}

	public Integer getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
	}

	public Long getVariantId() {
		return variantId;
	}

	public void setVariantId(Long variantId) {
		this.variantId = variantId;
	}

	public String getVariantLabelIt() {
		return variantLabelIt;
	}

	public void setVariantLabelIt(String variantLabelIt) {
		this.variantLabelIt = variantLabelIt;
	}

	public String getVariantLabelEn() {
		return variantLabelEn;
	}

	public void setVariantLabelEn(String variantLabelEn) {
		this.variantLabelEn = variantLabelEn;
	}

	public Integer getVariantOrder() {
		return variantOrder;
	}

	public void setVariantOrder(Integer variantOrder) {
		this.variantOrder = variantOrder;
	}

}
