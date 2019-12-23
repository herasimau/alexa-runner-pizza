package it.runnerpizza.alexa.service;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class ServiceGenerator {

	private static final String BASE_AUTH_URL = "https://www.runnerpizza.it/";
	private static final String BASE_API_URL = "https://www.runnerpizza.it/api/v1/";
	private static final String BASE_PUBLIC_API_URL = "https://www.runnerpizza.it/api/public/v1/";

	private static Retrofit.Builder authBuilder = new Retrofit.Builder()
		.baseUrl(BASE_AUTH_URL)
		.addConverterFactory(JacksonConverterFactory.create());

	private static Retrofit.Builder apiBuilder = new Retrofit.Builder()
		.baseUrl(BASE_API_URL)
		.addConverterFactory(JacksonConverterFactory.create());

	private static Retrofit.Builder apiPublicBuilder = new Retrofit.Builder()
		.baseUrl(BASE_PUBLIC_API_URL)
		.addConverterFactory(JacksonConverterFactory.create());

	private static Retrofit authRetrofit = authBuilder.build();

	private static Retrofit apiRetrofit = apiBuilder.build();

	private static Retrofit apiPublicRetrofit = apiPublicBuilder.build();

	private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

	public static <S> S createAuthService(Class<S> serviceClass) {
		return authRetrofit.create(serviceClass);
	}

	public static <S> S createService(Class<S> serviceClass, final String token, final boolean isPublic) {
	   if (token != null) {
		   httpClient.interceptors().clear();
		   httpClient.addInterceptor( chain -> {
				Request original = chain.request();
				Request request = original.newBuilder()
				 .header("Authorization", "Bearer " + token)
				 .build();
				return chain.proceed(request);
			});

			if (isPublic) {
				apiPublicBuilder.client(httpClient.build());
				apiPublicRetrofit = apiPublicBuilder.build();
				return apiPublicRetrofit.create(serviceClass);
			} else {
				apiBuilder.client(httpClient.build());
				apiRetrofit = apiBuilder.build();
				return apiRetrofit.create(serviceClass);
			}

		}
		return null;
	}
}
