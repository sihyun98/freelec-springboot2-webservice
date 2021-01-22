package com.hackathon3.back_server.member.repository.stockquery;

import com.querydsl.jpa.impl.JPAQueryFactory;

import java.util.List;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import com.hackathon3.back_server.member.domain.stock.Stock;

@Repository
public class StockRepositorySupport extends QuerydslRepositorySupport {

	private final JPAQueryFactory queryFactory;
	
	// ������
    public StockRepositorySupport(JPAQueryFactory queryFactory) {
        super(Stock.class);
        this.queryFactory = queryFactory;
    }

    // ���ǿ� �ش��ϴ� ������ �˻�
    public Stock searchStock(String userId){

        // ���ǿ� �ش��ϴ� stock row ��ȯ
        List<Stock> stocks = queryFactory.selectFrom(stock)
                .where(stockUserIdEq(userId))
                .fetch();
        
    }
    
    
    public BooleanExpression stockUserIdEq(String userId){
        return userId == null ? null : stock.userId.eq(userId);
    }
    
}
