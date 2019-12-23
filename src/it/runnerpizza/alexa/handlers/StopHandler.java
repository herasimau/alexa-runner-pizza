package it.runnerpizza.alexa.handlers;

import it.runnerpizza.alexa.utils.IntentData;
import it.runnerpizza.alexa.utils.MessagesData;
import it.runnerpizza.alexa.utils.SkillUtils;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.impl.IntentRequestHandler;
import com.amazon.ask.model.IntentRequest;
import com.amazon.ask.model.Response;

import java.util.Optional;
import java.util.ResourceBundle;

public class StopHandler implements IntentRequestHandler {

	@Override
	public boolean canHandle(HandlerInput handlerInput, IntentRequest intentRequest) {
		return intentRequest.getIntent().getName().equals(IntentData.AMAZON_STOP) ||
				intentRequest.getIntent().getName().equals(IntentData.AMAZON_CANCEL) ||
				intentRequest.getIntent().getName().equals(IntentData.AMAZON_NO_INTENT);
	}

	@Override
	public Optional<Response> handle(HandlerInput handlerInput, IntentRequest intentRequest) {
		final ResourceBundle messages = SkillUtils.getResourceBundle(handlerInput, MessagesData.BUNDLE_NAME);
		return handlerInput.getResponseBuilder()
				.withSpeech(messages.getString(MessagesData.STOP))
				.build();
	}
}
