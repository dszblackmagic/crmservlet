package com.crm.util;
import java.sql.*;

public class ConnDB {
private Statement stmt=null;
private Connection conn=null;
ResultSet rs=null;
int result=0;
public ConnDB(){}
public void OpenConn() throws Exception{
	try{
		Class.forName("org.gjt.mm.mysql.Driver");
		String url="jdbc:mysql://localhost/crm?user=root&password=123456&useUnicode=true&characterEncoding=utf-8";
	  conn=DriverManager.getConnection(url);
	  stmt=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
	  }
	catch(SQLException e)
	{
		System.err.println("data.executeQuery:"+e.getMessage());
	}
}



public Connection getConn()
{
	return conn;
}



public ResultSet Query(String sql)
{
	rs=null;
	try{
		rs=stmt.executeQuery(sql);
	}catch(SQLException e)
	{
		System.err.println("data.executeQuery:"+e.getMessage());
	}
	return rs;
}
 
public static ResultSet doQuery(String sql, Object... paras) {
	
	
	ConnDB DB=new ConnDB();
	Connection conn=DB.getConn();
	ResultSet rs = null;
	
	java.sql.PreparedStatement pstmt=null;
	
	try {
		pstmt = (java.sql.PreparedStatement) conn.prepareStatement(sql);
		// 动态设置参数
		if (paras != null) {
			for (int i = 0; i < paras.length; i++) {
				pstmt.setObject(i + 1, paras[i]);
			}
			
		}
		rs = pstmt.executeQuery();
	
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	return rs;

}

public int Update(String sql){
	try{
		result=stmt.executeUpdate(sql);
	}catch(SQLException e)
	{
		System.err.println("data.executeUpdate:"+e.getMessage());
	}
	return result;
}


public void closeStmt(){
	try{
		stmt.close();
	}catch(SQLException e){
		System.err.println("closeStmt:"+e.getMessage());
}
}	
	
public void closeConn()
{
	try{
		conn.close();
	}catch(SQLException e)
	{
		System.err.println("closeConn:"+e.getMessage());
	}
}
}
