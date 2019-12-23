package it.runnerpizza.alexa.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Address {

	private Long id;
	@JsonProperty("civico")
	private String civicNumber;
	@JsonProperty("nomeSulCampanello")
	private String nameOnTheBell;
	@JsonProperty("zona")
	private String zone;
	@JsonProperty("strada")
	private Street street;
	@JsonProperty("telefono")
	private String phone;
	@JsonProperty("piano")
	private String floor;
	@JsonProperty("indirizzoAsText")
	private String addressAsText;
	@JsonProperty("tipoIndirizzo")
	private AddressType addressType;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCivicNumber() {
		return civicNumber;
	}

	public void setCivicNumber(String civicNumber) {
		this.civicNumber = civicNumber;
	}

	public String getNameOnTheBell() {
		return nameOnTheBell;
	}

	public void setNameOnTheBell(String nameOnTheBell) {
		this.nameOnTheBell = nameOnTheBell;
	}

	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

	public Street getStreet() {
		return street;
	}

	public void setStreet(Street street) {
		this.street = street;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public String getAddressAsText() {
		return addressAsText;
	}

	public void setAddressAsText(String addressAsText) {
		this.addressAsText = addressAsText;
	}

	public AddressType getAddressType() {
		return addressType;
	}

	public void setAddressType(AddressType addressType) {
		this.addressType = addressType;
	}
}
