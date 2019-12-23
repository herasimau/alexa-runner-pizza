package it.runnerpizza.alexa.service;

import it.runnerpizza.alexa.models.Order;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface OrderService {

	@GET("ordini/ordine-cliente")
	Call<Order> getOrder(@Query("cacheBuster") String timestamp, @Query("localeId") String localeId);

	@PUT("ordini")
	Call<Order> updateOrder(@Query("cacheBuster") String timestamp, @Body Order order);

}
