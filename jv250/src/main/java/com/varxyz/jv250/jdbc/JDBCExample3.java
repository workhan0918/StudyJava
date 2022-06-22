package com.varxyz.jv250.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.xdevapi.PreparableStatement;

public class JDBCExample3 {
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
         
         String sql = "INSERT INTO Customer(name, ssn, phone, customerId, passwd)" + " VALUES (?, ?, ?, ?, ?)";
         PreparedStatement stmt = con.prepareStatement(sql);   // statment 생성
         stmt.setString(1,"조조");
         stmt.setString(2,"871011-1234567");
         stmt.setString(3,"010-1577-4482");
         stmt.setString(4,"jojo");
         stmt.setString(5,"goodjojo1234");
         stmt.executeUpdate();   // 입력된 결과 값이 rs로 저장
        
         System.out.println("INSERTED......");
         stmt.close();
         con.close();
         
      } catch (Exception e) {
         e.printStackTrace();
      }
      finally {
         
      }
   }
}