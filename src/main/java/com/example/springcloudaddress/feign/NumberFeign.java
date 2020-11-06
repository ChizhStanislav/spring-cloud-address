package com.example.springcloudaddress.feign;

import com.example.springcloudaddress.entity.Number;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(
        name = "spring-cloud-number",
        fallback = NumberFeign.NumberFeignFallback.class
)
public interface NumberFeign {

    @GetMapping(value = "number")
    Number getNumber();

    @Component
    class NumberFeignFallback implements NumberFeign {

        @Override
        public Number getNumber() {
            return Number.builder()
                    .name("fallback")
                    .build();
        }
    }
}
