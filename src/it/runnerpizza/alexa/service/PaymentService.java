package it.runnerpizza.alexa.service;

import it.runnerpizza.alexa.models.PaymentRequest;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface PaymentService {

	@GET("pagamento/request/{orderId}")
	Call<PaymentRequest> requestPayment(@Path("orderId") Long orderId, @Query("issuer") String issuer, @Query("couponCode") String couponCode, @Query("useCredit") boolean useCredit,
										@Query("cacheBuster") String cacheBuster, @Query("device") String device);

}
