package com.cos.blog.test;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;

import org.junit.Test;

import com.cos.blog.config.DB;

public class DBTest {

	//여기서 못함
	@Test
	public void DB연결() {
		Connection conn = DB.getConnection();
		assertNotNull(conn);
	}
}
