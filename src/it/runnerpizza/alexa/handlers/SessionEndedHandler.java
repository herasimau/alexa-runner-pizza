package it.runnerpizza.alexa.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.impl.SessionEndedRequestHandler;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.SessionEndedRequest;

import java.util.Optional;

public class SessionEndedHandler implements SessionEndedRequestHandler {

	@Override
	public boolean canHandle(HandlerInput input, SessionEndedRequest request) {
		return true;
	}

	@Override
	public Optional<Response> handle(HandlerInput handlerInput, SessionEndedRequest request) {
		return handlerInput.getResponseBuilder().build();
	}
}
