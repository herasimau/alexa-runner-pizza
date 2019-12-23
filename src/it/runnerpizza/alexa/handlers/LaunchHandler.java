package it.runnerpizza.alexa.handlers;

import it.runnerpizza.alexa.utils.MessagesData;
import it.runnerpizza.alexa.utils.SkillUtils;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.impl.LaunchRequestHandler;
import com.amazon.ask.model.LaunchRequest;
import com.amazon.ask.model.Response;

import java.util.Optional;
import java.util.ResourceBundle;

public class LaunchHandler implements LaunchRequestHandler {

	@Override
	public boolean canHandle(HandlerInput handlerInput, LaunchRequest launchRequest) {
		return true;
	}

	@Override
	public Optional<Response> handle(HandlerInput handlerInput, LaunchRequest launchRequest) {
		final ResourceBundle messages = SkillUtils.getResourceBundle(handlerInput, MessagesData.BUNDLE_NAME);
		final String speechText = String.format("%s %s", messages.getString(MessagesData.WELCOME), messages.getString(MessagesData.HELP));
		return handlerInput.getResponseBuilder()
				.withSpeech(speechText)
				.withReprompt(speechText)
				.withShouldEndSession(false)
				.build();
	}
}
