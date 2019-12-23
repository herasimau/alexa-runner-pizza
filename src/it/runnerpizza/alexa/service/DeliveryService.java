package it.runnerpizza.alexa.service;

import it.runnerpizza.alexa.models.DeliveryInfo;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface DeliveryService {

	@GET("consegne/{zoneId}/insegne/999")
	Call<DeliveryInfo> getDeliveryInfo(@Path("zoneId") String zoneId, @Query("cacheBuster") String timestamp);

}
