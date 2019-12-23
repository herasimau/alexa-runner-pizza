package it.runnerpizza.alexa.service;

import it.runnerpizza.alexa.models.Address;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.List;

public interface AddressService {

	@GET("indirizzi")
	Call<List<Address>> getAddresses(@Query("cacheBuster") String timestamp);

}
