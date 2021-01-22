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

        // ���ǿ� �ش��ϴ� stock ��ü ��������
    	Stock stock = stockRepositorySupport.searchStock(condition);
    	
        // ���ǿ� �ش��ϴ� stock ��ü�� ������,
        if(stock == null){
            throw new IllegalArgumentException("�ش� �ֽ��� �������� �ʽ��ϴ�.");
        }
        // ���ǿ� �ش��ϴ� account ��ü�� ������,
        else{
            Long id = stockRepository.save(stock).getId();

            StockSearchResponseDto dto = new StockSearchResponseDto();
            
            dto.setCode("OK");
            
            return dto;
                    
        }
    }
}
