package com.java.util;

import java.sql.Connection;
import java.sql.SQLException;

public class DBUtil {
    private static final String jdbcUrl = "jdbc:mysql://localhost:3306/market?useUnicode=true&characterEncoding=UTF-8";
    private static final String dbUser = "root";
    private static final String dbPwd = "root";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
    	Connection con=java.sql.DriverManager.getConnection(jdbcUrl, dbUser, dbPwd);
        return con;
    }
    
    public void closeCon(Connection con) throws Exception{
    	if(con!=null) {
    		con.close();
    	}
    }
    
    public static void main(String[] args) {
    	DBUtil dbutil=new DBUtil();
    	try {
			dbutil.getConnection();
			System.out.println("数据库连接成功..");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("数据库连接失败..");
		}
    	
    }
}