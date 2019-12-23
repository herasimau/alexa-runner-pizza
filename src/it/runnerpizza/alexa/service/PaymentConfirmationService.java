package it.runnerpizza.alexa.service;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PaymentConfirmationService {

	@GET("payments/cashOnDeliveryOk")
	Call<Object> confirmPayment(@Query("transactionId") String transactionId);

}
