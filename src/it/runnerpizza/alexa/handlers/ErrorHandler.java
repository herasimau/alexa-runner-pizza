package it.runnerpizza.alexa.handlers;

import it.runnerpizza.alexa.utils.MessagesData;
import it.runnerpizza.alexa.utils.SkillUtils;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;

import java.util.Optional;

public class ErrorHandler implements RequestHandler {

	@Override
	public boolean canHandle(HandlerInput handlerInput) {
		return true;
	}

	@Override
	public Optional<Response> handle(HandlerInput handlerInput) {
		final String speechOutput = SkillUtils.getResourceBundle(handlerInput, MessagesData.BUNDLE_NAME).getString(MessagesData.ERROR_SPEECH);
		return handlerInput.getResponseBuilder()
				.withSpeech(speechOutput)
				.withReprompt(speechOutput)
				.build();
	}
}
