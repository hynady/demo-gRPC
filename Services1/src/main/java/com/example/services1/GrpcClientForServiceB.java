package com.example.services1;

import com.example.grpc.services2.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.stereotype.Service;

@Service
public class GrpcClientForServiceB {

    private final ServiceBGrpc.ServiceBBlockingStub stub;

    public GrpcClientForServiceB() {
        // IP và port của Service B
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 6566) // IP và port của Service B
                .usePlaintext()
                .build();
        this.stub = ServiceBGrpc.newBlockingStub(channel);
    }

    public String callServiceB(String name) {
        ServiceBProto.HelloRequest request = ServiceBProto.HelloRequest.newBuilder().setName(name).build();
        ServiceBProto.HelloResponse response = stub.sayHelloB(request);
        return response.getMessage();
    }
}