package com.example.springcloudaddress.controller;

import com.example.springcloudaddress.entity.Address;
import com.example.springcloudaddress.feign.NumberFeign;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("address")
@RequiredArgsConstructor
public class AddressRestController {

    private final NumberFeign numberFeign;

    @Value("${name.service}")
    private String service;

    @GetMapping
    public Address getAddress() {
        System.out.println(numberFeign.getNumber());
        return Address.builder()
                .address(String.format("%s Minsk", service))
                .build();
    }
}
