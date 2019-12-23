package it.runnerpizza.alexa.utils;

import it.runnerpizza.alexa.models.Auth;
import it.runnerpizza.alexa.service.AuthService;
import it.runnerpizza.alexa.service.ServiceGenerator;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class RunnerPizzaAuthUtils {

	private static final String AUTH_PROPERTIES = "auth.properties";
	private static final String USERNAME = "username";
	private static final String PASSWORD = "password";
	private static final String GRANT_TYPE = "grantType";
	private static final String SCOPE = "scope";
	private static final String CLIENT_SECRET = "clientSecret";
	private static final String CLIENT_ID = "clientId";

	public static Auth getAuth() throws IOException {
		AuthService service = ServiceGenerator.createAuthService(AuthService.class);
		Map<String, String> authParams = buildAuthParams();
		return service.getAuth(authParams.get(USERNAME), authParams.get(PASSWORD), authParams.get(GRANT_TYPE),
								authParams.get(SCOPE), authParams.get(CLIENT_SECRET), authParams.get(CLIENT_ID)).execute().body();
	}

	private static Map<String, String> buildAuthParams() throws IOException{
		Map<String, String> params = new HashMap<>();
		Properties authProperties =  new Properties();
		authProperties.load(RunnerPizzaAuthUtils.class.getClassLoader().getResourceAsStream(AUTH_PROPERTIES));
		params.put(USERNAME, authProperties.getProperty(USERNAME));
		params.put(PASSWORD, authProperties.getProperty(PASSWORD));
		params.put(GRANT_TYPE, authProperties.getProperty(GRANT_TYPE));
		params.put(SCOPE, authProperties.getProperty(SCOPE));
		params.put(CLIENT_SECRET, authProperties.getProperty(CLIENT_SECRET));
		params.put(CLIENT_ID, authProperties.getProperty(CLIENT_ID));
		return params;
	}


}
