package com.item.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.eclipse.jdt.internal.compiler.ast.TypeParameter;

import com.item.utils.JDBCUtils;
import com.item.utils.Simple;

public class Dao<T> {
	QueryRunner qr = new QueryRunner();
	Class<T> clazz=null;
	{
		Type genericSuperclass = this.getClass().getGenericSuperclass();
		ParameterizedType type1 = (ParameterizedType) genericSuperclass;
		Type[] type = type1.getActualTypeArguments();
		clazz=(Class<T>) type[0];
	}
	public T getOne(String sql,Object...obj) throws SQLException {
		T t=null;
//		Connection conn = Simple.getSimple().getConnection();
		Connection conn=JDBCUtils.getConnection();
		t = qr.query(conn, sql, new BeanHandler<>(clazz), obj);
		JDBCUtils.closeCon(conn);
		return t;
	}
	public List<T> getMore(String sql,Object...obj) throws SQLException{
		List<T> list = null;
//		Connection conn = Simple.getSimple().getConnection();
		Connection conn=JDBCUtils.getConnection();
		list = qr.query(conn, sql, new BeanListHandler<>(clazz), obj);
		JDBCUtils.closeCon(conn);
		return list;
	}
	public void update(String sql,Object...obj) throws SQLException {
//		Connection conn = Simple.getSimple().getConnection();
		Connection conn=JDBCUtils.getConnection();
		int update = qr.update(conn, sql, obj);
		JDBCUtils.closeCon(conn);
	}
	public <E> E getValue(String sql,Object...obj) throws SQLException {
//		Connection conn = Simple.getSimple().getConnection();
		Connection conn=JDBCUtils.getConnection();
		E e = qr.query(conn, sql, new ScalarHandler<>(), obj);
		JDBCUtils.closeCon(conn);
		return e;
	}
}
