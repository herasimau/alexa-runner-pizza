package it.runnerpizza.alexa.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DeliveryInfo {

	private Long id;
	@JsonProperty("orarioPrimaConsegna")
	private String minDeliveryTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMinDeliveryTime() {
		return minDeliveryTime;
	}

	public void setMinDeliveryTime(String minDeliveryTime) {
		this.minDeliveryTime = minDeliveryTime;
	}
}
