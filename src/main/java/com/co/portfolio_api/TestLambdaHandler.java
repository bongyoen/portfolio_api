package com.co.portfolio_api;

import com.amazonaws.serverless.exceptions.ContainerInitializationException;
import com.amazonaws.serverless.proxy.model.AwsProxyRequest;
import com.amazonaws.serverless.proxy.model.AwsProxyResponse;
import com.amazonaws.serverless.proxy.spring.SpringBootLambdaContainerHandler;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class TestLambdaHandler implements RequestHandler<Object, Object> {

    private SpringBootLambdaContainerHandler<AwsProxyRequest, AwsProxyResponse> handler;
    public TestLambdaHandler() throws ContainerInitializationException {
        handler = SpringBootLambdaContainerHandler.getAwsProxyHandler(Appendable.class);
    }

    @Override
    public Object handleRequest(Object input, Context context) {
        return handler.proxy((AwsProxyRequest) input, context);
    }
}
