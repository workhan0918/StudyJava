package com.varxyz.jv250.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCExample2 {
   public static void main(String[] args) {
      String driver = "com.mysql.cj.jdbc.Driver";
      String url = "jdbc:mysql://localhost:3306/jv250?serverTimezone=Asia/Seoul";   // 서버주소
      String id = "jv250";
      String passwd = "jv250";
      
      try {
         Class.forName(driver);
         System.out.println("LOAD DRIVER --->" + driver);
         
         Connection con = DriverManager.getConnection(url, id, passwd);   // sql쪽 exception은 checked exception이기 때문에 무조건 try catch로 잡아줘야 한다
         System.out.println("CONNECTED TO --->" + url);
         
         String sql = "SELECT * FROM Customer WHERE name=?";
         PreparedStatement stmt = con.prepareStatement(sql);
         stmt.setString(1, "조조"); // 한개만해야함

         ResultSet rs = stmt.executeQuery();   // 입력된 결과 값이 rs로 저장
         while(rs.next()) {   // next() --> 현재값이 있으면 true 없으면 false while은 참일때만 동작
            long cid = rs.getLong("cid");
            String customerId = rs.getString("customerId");
            String name = rs.getString("name");
            String phone = rs.getString("phone");
            System.out.println(cid);
            System.out.println(customerId);
            System.out.println(name);
            System.out.println(phone);
            System.out.println("---------------");
         }
         rs.close();
         stmt.close();
         con.close();
         
      } catch (Exception e) {
         e.printStackTrace();
      }
      finally {
         
      }
   }
}