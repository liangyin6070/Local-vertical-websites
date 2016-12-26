package com.framwork.core.mybatis;

import java.sql.Connection;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Signature;
/**
 * oracle分页拦截器实现
 * @author ldw
 *
 */
@Intercepts(@Signature(type = StatementHandler.class, method = "query", args = { Connection.class }))
public class OraclePagingInterceptor extends AbstractPagingInterceptor {
	/**
	 * 改造sql变成查询总数的sql
	 */
	@Override
	protected String getSelectTotalSql(String targetSql) {
		String sql = targetSql.toLowerCase();
        StringBuilder sqlBuilder = new StringBuilder(sql);
        
        int orderByPos = 0;
        if((orderByPos = sqlBuilder.lastIndexOf(ORDER_BY)) != -1) {
            sqlBuilder.delete(orderByPos, sqlBuilder.length());
        }
        sqlBuilder.insert(0, "select count(1) as _count from ( ").append(" )");
        
        return sqlBuilder.toString();
	}
	/**
	 * 改造sql变成支持分页的sql
	 */
	@Override
	protected String getSelectPagingSql(String targetSql,
			PagingBounds pagingBounds) {
		// TODO Auto-generated method stub
		return null;
	}

}
