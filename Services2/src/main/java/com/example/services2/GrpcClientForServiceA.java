package com.example.services2;

import com.example.grpc.services1.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.stereotype.Service;

@Service
public class GrpcClientForServiceA {

    private final ManagedChannel channel;
    private final ServiceAGrpc.ServiceABlockingStub stub;

    public GrpcClientForServiceA() {
        this.channel = ManagedChannelBuilder.forAddress("localhost", 6565) // IP và port của Service A
                .usePlaintext()
                .build();
        this.stub = ServiceAGrpc.newBlockingStub(channel);
    }

    public String callServiceA(String name) {
        ServiceAProto.HelloRequest request = ServiceAProto.HelloRequest.newBuilder().setName(name).build();
        ServiceAProto.HelloResponse response = stub.sayHelloA(request);
        return response.getMessage();
    }
}
