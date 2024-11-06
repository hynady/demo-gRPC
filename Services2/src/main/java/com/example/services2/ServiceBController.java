package com.example.services2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceBController {

    private final GrpcClientForServiceA grpcClientForServiceA;

    public ServiceBController(GrpcClientForServiceA grpcClientForServiceA) {
        this.grpcClientForServiceA = grpcClientForServiceA;
    }

    @GetMapping("/call-serviceA")
    public String callServiceA(@RequestParam String name) {
        // Gọi Service A thông qua client
        return grpcClientForServiceA.callServiceA(name);
    }
}