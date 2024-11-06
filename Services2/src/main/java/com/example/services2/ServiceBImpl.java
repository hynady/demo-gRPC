package com.example.services2;

import com.example.grpc.services2.*;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class ServiceBImpl extends ServiceBGrpc.ServiceBImplBase {

    @Override
    public void sayHelloB(ServiceBProto.HelloRequest request, StreamObserver<ServiceBProto.HelloResponse> responseObserver) {
        String name = request.getName();
        String message = "Hello from Service B, " + name;
        ServiceBProto.HelloResponse response = ServiceBProto.HelloResponse.newBuilder().setMessage(message).build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}