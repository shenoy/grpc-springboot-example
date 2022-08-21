package com.techprimers.grpc.service;

import com.techprimers.grpc.GreetingRequest;
import com.techprimers.grpc.GreetingResponse;
import com.techprimers.grpc.GreetingServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;


@GrpcService
public class GreetingServiceImpl extends GreetingServiceGrpc.GreetingServiceImplBase {

    @Override
    public void greeting(GreetingRequest request, StreamObserver<GreetingResponse> responseObserver){

        String message = request.getMessage();
        System.out.println("Received message "+ message);

        GreetingResponse greetingResponse = GreetingResponse.newBuilder()
                .setMessage("Hello from server. Received your " +  message)
                .build();

        responseObserver.onNext(greetingResponse);
        responseObserver.onCompleted();
    }
}
