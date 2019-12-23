package it.runnerpizza.alexa.service;

import it.runnerpizza.alexa.models.AddToCart;
import it.runnerpizza.alexa.models.Cart;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

public interface CartService {

	@DELETE("carrello/1/svuota-carrello")
	Call<ResponseBody> emptyCart(@Query("clienteId") String clientId, @Query("zonaId") String zoneId, @Query("cacheBuster") String timestamp,
								 @Query("device") String device);

	@GET("carrello/1")
	Call<Cart> getCart(@Query("clienteId") String clientId, @Query("zonaId") String zoneId, @Query("cacheBuster") String timestamp,
					   @Query("device") String device);

	@POST("carrello/1/articoli")
	Call<Cart> addToCart(@Query("clienteId") String clientId, @Query("zonaId") String zoneId, @Query("cacheBuster") String timestamp,
						 @Query("device") String device, @Body AddToCart addToCart);
}
