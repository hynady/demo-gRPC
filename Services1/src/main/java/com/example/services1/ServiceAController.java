package com.example.services1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceAController {

    private final GrpcClientForServiceB grpcClientForServiceB;

    public ServiceAController(GrpcClientForServiceB grpcClientForServiceB) {
        this.grpcClientForServiceB = grpcClientForServiceB;
    }

    @GetMapping("/call-serviceB")
    public String callServiceB(@RequestParam String name) {
        // Gọi Service B thông qua client
        return grpcClientForServiceB.callServiceB(name);
    }
}
