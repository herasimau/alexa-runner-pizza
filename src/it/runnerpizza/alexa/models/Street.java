package it.runnerpizza.alexa.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Street {

	private Long id;
	@JsonProperty("descrizione")
	private String description;
	@JsonProperty("descrizioneComune")
	private String cityDescrtiption;
	@JsonProperty("comuneId")
	private Long cityId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCityDescrtiption() {
		return cityDescrtiption;
	}

	public void setCityDescrtiption(String cityDescrtiption) {
		this.cityDescrtiption = cityDescrtiption;
	}

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}
}
