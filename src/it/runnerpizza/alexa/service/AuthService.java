package it.runnerpizza.alexa.service;

import it.runnerpizza.alexa.models.Auth;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface AuthService {

	@FormUrlEncoded
	@Headers("Authorization: Basic VGhlRm9vZGFwcDpteS1zZWNyZXQtdG9rZW4tdG8tY2hhbmdlLWluLXByb2R1Y3Rpb24=")
	@POST("oauth/token")
	Call<Auth> getAuth(@Field("username") String username, @Field("password") String password, @Field("grant_type") String grantType,
				@Field("scope") String scope, @Field("client_secret") String clientSecret, @Field("clientId") String clientId);

}
