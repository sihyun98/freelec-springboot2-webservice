package com.hackathon3.back_server.member.controller.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import com.hackathon3.back_server.member.controller.dto.stock.StockSearchRequestDto;
import com.hackathon3.back_server.member.controller.dto.stock.StockSearchResponseDto;

@RestController
@RequiredArgsConstructor
public class StockApiController {

	// GET
    @GetMapping("/api/home/mystock")
    public StockSearchResponseDto search(@RequestBody StockSearchRequestDto requestDto){
        return stockService.search(requestDto);
    }
}
