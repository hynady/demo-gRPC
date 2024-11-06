package com.example.services1;

import com.example.grpc.services1.*;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class ServiceAImpl extends ServiceAGrpc.ServiceAImplBase {

    @Override
    public void sayHelloA(ServiceAProto.HelloRequest request, StreamObserver<ServiceAProto.HelloResponse> responseObserver) {
        String name = request.getName();
        String message = "Hello from Service A, " + name;
        ServiceAProto.HelloResponse response = ServiceAProto.HelloResponse.newBuilder().setMessage(message).build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
