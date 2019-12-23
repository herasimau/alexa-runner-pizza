package it.runnerpizza.alexa.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Variant {

	private Long id;
	@JsonProperty("descrizioneIt")
	private String descriptionIt;
	@JsonProperty("descrizioneEn")
	private String descriptionEn;
	private Integer sortOrder;
	private Boolean visibile;
	@JsonProperty("dettaglioVariantes")
	private List<VariantDetail> variantDetails;

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

	public Integer getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
	}

	public Boolean getVisible() {
		return visibile;
	}

	public void setVisible(Boolean visible) {
		this.visibile = visible;
	}

	public List<VariantDetail> getVariantDetails() {
		return variantDetails;
	}

	public void setVariantDetails(List<VariantDetail> variantDetails) {
		this.variantDetails = variantDetails;
	}
}
