package com.phongvdoan.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.impl.LaunchRequestHandler;
import com.amazon.ask.model.LaunchRequest;
import com.amazon.ask.model.Response;
import org.apache.logging.log4j.Logger;

import java.util.Optional;

import static com.amazon.ask.request.Predicates.requestType;
import static org.apache.logging.log4j.LogManager.getLogger;

public class CustomLaunchRequestHandler implements LaunchRequestHandler {


    @Override
    public boolean canHandle(HandlerInput input, LaunchRequest launchRequest) {
        return input.matches(requestType(LaunchRequest.class));
    }

    private static Logger logger = getLogger(CustomLaunchRequestHandler.class);

    @Override
    public Optional<Response> handle(HandlerInput input, LaunchRequest launchRequest) {
        logger.info("Received unrecognized request: " + input.getRequestEnvelopeJson());
        return input.getResponseBuilder()
                .withSpeech("This is a simple Alexa Skill example")
                .build();
    }
}