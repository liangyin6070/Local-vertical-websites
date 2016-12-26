package com.framwork.core.mybatis;

import java.sql.Connection;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Signature;
/**
 * 实现mysql的分页和统计sql语句拼写
 * @author ldw
 *
 */
@Intercepts(@Signature(type = StatementHandler.class, method = "query", args = { Connection.class }))
public class MySqlPagingInterceptor extends AbstractPagingInterceptor {
	/**
	 * 改造sql变成查询总数的sql
	 * @param targetSql 正常查询数据的sql: select id, name from user where name = ?
	 * 
	 * @return 改造后的查询语句sql: select count(1) from user where name = ?
	 */
	@Override
	protected String getSelectTotalSql(String targetSql) {
		String sql = targetSql.toLowerCase();
		StringBuilder sqlBuilder = new StringBuilder(sql);

		int orderByPos = 0;
		if ((orderByPos = sqlBuilder.lastIndexOf(ORDER_BY)) != -1) {
			//去掉order by
			sqlBuilder.delete(orderByPos, sqlBuilder.length());
		}

//		if (sqlBuilder.indexOf(UNION) != -1) {
//			sqlBuilder.insert(0, "select count(1) as _count from ( ").append(" ) as _alias");
//			return sqlBuilder.toString();
//		}

		int fromPos = sqlBuilder.indexOf(FROM);
		if (fromPos != -1) {
			sqlBuilder.delete(0, fromPos);
			sqlBuilder.insert(0, "select count(1) as _count ");
		}

		return sqlBuilder.toString();
	}
	/**
	 * 改造sql变成支持分页的sql
	 * @param targetSql 正常查询数据的sql: select id, name from user where name = ?
	 * @return select id, name from user where name = ? limit ?, ?
	 */
	@Override
	protected String getSelectPagingSql(String targetSql, PagingBounds pagingBounds) {
		String sql = targetSql.toLowerCase();
		StringBuilder sqlBuilder = new StringBuilder(sql);
		
		sqlBuilder.append(" LIMIT ").append(pagingBounds.getOffset()).append(",").append(pagingBounds.getLimit());
		return sqlBuilder.toString();
	}

}
