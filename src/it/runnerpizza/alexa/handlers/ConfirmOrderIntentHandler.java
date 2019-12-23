package it.runnerpizza.alexa.handlers;

import it.runnerpizza.alexa.utils.IntentData;
import it.runnerpizza.alexa.utils.MessagesData;
import it.runnerpizza.alexa.utils.SkillUtils;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.impl.IntentRequestHandler;
import com.amazon.ask.model.IntentRequest;
import com.amazon.ask.model.Response;

import java.util.Optional;

public class ConfirmOrderIntentHandler implements IntentRequestHandler {

	@Override
	public boolean canHandle(HandlerInput handlerInput, IntentRequest intentRequest) {
		return intentRequest.getIntent().getName().equals(IntentData.CONFIRM_ORDER);
	}

	@Override
	public Optional<Response> handle(HandlerInput handlerInput, IntentRequest intentRequest) {
		return SkillUtils.confirmOrderResponse(handlerInput, MessagesData.BUNDLE_NAME, MessagesData.ORDER_CONFIRMED_SPEECH);
	}
}

