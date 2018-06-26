package com.crm.util;

import java.sql.Connection;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * JDBC������
 */
public class JDBCUtils {
	/** druid���ӳ� */
	private static DruidDataSource dataSource = new DruidDataSource();
	/*
	 * ��̬����� ������ʼ�� ִֻ��һ��
	 */
	static{
		Properties props = new Properties();
		try {
			props.load(JDBCUtils.class.getClassLoader().getResourceAsStream("db.properties"));
		} catch (Exception e) {
			throw new RuntimeException("��ȡdb.properties����",e);
		}
		dataSource.setDriverClassName(props.getProperty("jdbc.driverClassName"));
		dataSource.setUrl(props.getProperty("jdbc.url"));
		dataSource.setUsername(props.getProperty("jdbc.username"));
		dataSource.setPassword(props.getProperty("jdbc.password"));
	}
	/**
	 * �õ����ӳ�
	 */
	public static DataSource getDataSource(){
		return dataSource;
	}
	/**
	 * �õ�����
	 */
	public static Connection getConnection() throws Exception{
		Connection conn = dataSource.getConnection();
		
		return conn;
	}

}