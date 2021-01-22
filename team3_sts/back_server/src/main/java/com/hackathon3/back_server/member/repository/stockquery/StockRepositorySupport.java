package com.hackathon3.back_server.member.repository.stockquery;

import com.querydsl.jpa.impl.JPAQueryFactory;

import java.util.List;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import com.hackathon3.back_server.member.domain.stock.Stock;

@Repository
public class StockRepositorySupport extends QuerydslRepositorySupport {

	private final JPAQueryFactory queryFactory;
	
	// 생성자
    public StockRepositorySupport(JPAQueryFactory queryFactory) {
        super(Stock.class);
        this.queryFactory = queryFactory;
    }

    // 조건에 해당하는 쿼리문 검색
    public Stock searchStock(String userId){

        // 조건에 해당하는 stock row 반환
        List<Stock> stocks = queryFactory.selectFrom(stock)
                .where(stockUserIdEq(userId))
                .fetch();
        
    }
    
    
    public BooleanExpression stockUserIdEq(String userId){
        return userId == null ? null : stock.userId.eq(userId);
    }
    
}
