package com.hackathon3.back_server.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/api/test")
    public TestResponseDto test() {
        return TestResponseDto.builder()
                .code("OK")
                .message("테스트성공!")
                .build();
    }

}
