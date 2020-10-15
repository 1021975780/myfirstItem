package com.item.test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.AfterEach;

import com.item.beans.Admin;
import com.item.beans.Gclass;
import com.item.beans.Goods;
import com.item.dao.AdminDao;
import com.item.dao.GclassDao;
import com.item.dao.GoodsDao;
import com.item.dao.impl.AdminDaoimpl;
import com.item.dao.impl.GclassDaoimpl;
import com.item.dao.impl.GoodsDaoimpl;
import com.item.utils.GetipAddress;
import com.item.utils.JDBCUtils;

class Test {

	@AfterEach
	void tearDown() throws Exception {
	}

	@org.junit.jupiter.api.Test
	void test() throws SQLException {
		Connection connection = JDBCUtils.getConnection();
		System.out.println(connection);
	}
	@org.junit.jupiter.api.Test
	void test1() {
		AdminDao dao = new AdminDaoimpl();
		Admin admin = dao.getAdmin("1021975780@qq.com");
		System.out.println(admin);
	}
	@org.junit.jupiter.api.Test
	void test2() {
		AdminDao dao = new AdminDaoimpl();
		Admin admin = new Admin("1021975780@qq.com", "wq64531525..", null);
		dao.updateInfo(admin);
		
	}
	@org.junit.jupiter.api.Test
	void test3() {
		String date = GetipAddress.getDate();
		System.out.println(date);
		
	}
	@org.junit.jupiter.api.Test
	void test4() {
		GoodsDao dao = new GoodsDaoimpl();
		Goods goods = new Goods("Î÷¹Ï", "3", null);
		//dao.addGoods(goods,"Ë®¹û");
	}
	@org.junit.jupiter.api.Test
	void test5() {
		GoodsDaoimpl dao = new GoodsDaoimpl();
		String sql="select id from gclass where name=?";
		//int value = dao.getValue(sql);
		//System.out.println(value);
	}
	@org.junit.jupiter.api.Test
	void test6() {
		GoodsDaoimpl dao = new GoodsDaoimpl();
		//Goods good = dao.getGood("Æ»¹û");
		//System.out.println(good);
		List<Goods> goods = dao.getGoods("Æ»");
		System.out.println(goods);
	}
	@org.junit.jupiter.api.Test
	void test7() {
		GclassDao dao = new GclassDaoimpl();
		List<Gclass> list = dao.getList("¹û");
		System.out.println(list);
	}
	@org.junit.jupiter.api.Test
	void test8() {
		GclassDao dao = new GclassDaoimpl();
		dao.updateGclass(new Gclass(26, "¶ùÍ¯ãåÔ¡Â¶"));
		
	}
	@org.junit.jupiter.api.Test
	void test9() {
		GclassDao dao = new GclassDaoimpl();
		dao.removeGclass(25);
		
	}

}
