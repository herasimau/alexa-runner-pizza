package it.runnerpizza.alexa.handlers;

import it.runnerpizza.alexa.utils.IntentData;
import it.runnerpizza.alexa.utils.MessagesData;
import it.runnerpizza.alexa.utils.SkillUtils;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.impl.IntentRequestHandler;
import com.amazon.ask.model.IntentRequest;
import com.amazon.ask.model.Response;

import java.util.Optional;

public class HelpIntentHandler implements IntentRequestHandler {

	@Override
	public boolean canHandle(HandlerInput input, IntentRequest intentRequest) {
		return intentRequest.getIntent().getName().equals(IntentData.AMAZON_HELP);
	}

	@Override
	public Optional<Response> handle(HandlerInput handlerInput, IntentRequest intentRequest) {
		final String speechText = SkillUtils.getResourceBundle(handlerInput, MessagesData.BUNDLE_NAME).getString(MessagesData.HELP);
		return handlerInput.getResponseBuilder()
				.withSpeech(speechText)
				.withReprompt(speechText)
				.build();
	}
}
