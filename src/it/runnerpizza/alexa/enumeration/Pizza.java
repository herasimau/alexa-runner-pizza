package it.runnerpizza.alexa.enumeration;

import java.util.Arrays;
import java.util.Optional;

public enum Pizza {
	MARGHERITA(42740L, "MARGHERITA"), DIAVOLA(42757L, "DIAVOLA");

	public Long id;
	public String name;

	Pizza(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public static Optional<Pizza> fromName(String name) {
		return Arrays.stream(Pizza.values()).filter(pizza -> pizza.name.toLowerCase().equals(name.toLowerCase())).findFirst();
	}
}
