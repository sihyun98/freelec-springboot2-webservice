package com.hackathon3.back_server.member.service.stocksservice;

import org.springframework.transaction.annotation.Transactional;

import com.hackathon3.back_server.member.controller.dto.stock.StockSearchRequestDto;
import com.hackathon3.back_server.member.controller.dto.stock.StockSearchResponseDto;
import com.hackathon3.back_server.member.domain.stock.Stock;
import com.hackathon3.back_server.web.TestResponseDto;

public class StockService {
	
	// GET
    @Transactional(readOnly = true)
    public StockSearchResponseDto search(StockSearchCondition condition){

        // 조건에 해당하는 stock 객체 가져오기
    	Stock stock = stockRepositorySupport.searchStock(condition);
    	
        // 조건에 해당하는 stock 객체가 없으면,
        if(stock == null){
            throw new IllegalArgumentException("해당 주식이 존재하지 않습니다.");
        }
        // 조건에 해당하는 account 객체가 있으면,
        else{
            Long id = stockRepository.save(stock).getId();

            StockSearchResponseDto dto = new StockSearchResponseDto();
            
            dto.setCode("OK");
            
            return dto;
                    
        }
    }
}
