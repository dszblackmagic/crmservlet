package com.crm.util;

import java.sql.Connection;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * JDBC工具类
 */
public class JDBCUtils {
	/** druid连接池 */
	private static DruidDataSource dataSource = new DruidDataSource();
	/*
	 * 静态代码块 用来初始化 只执行一次
	 */
	static{
		Properties props = new Properties();
		try {
			props.load(JDBCUtils.class.getClassLoader().getResourceAsStream("db.properties"));
		} catch (Exception e) {
			throw new RuntimeException("读取db.properties出错",e);
		}
		dataSource.setDriverClassName(props.getProperty("jdbc.driverClassName"));
		dataSource.setUrl(props.getProperty("jdbc.url"));
		dataSource.setUsername(props.getProperty("jdbc.username"));
		dataSource.setPassword(props.getProperty("jdbc.password"));
	}
	/**
	 * 得到连接池
	 */
	public static DataSource getDataSource(){
		return dataSource;
	}
	/**
	 * 得到连接
	 */
	public static Connection getConnection() throws Exception{
		Connection conn = dataSource.getConnection();
		
		return conn;
	}

}