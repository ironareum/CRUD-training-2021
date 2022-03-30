package com.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dto.LibDto;


public class Dao_form {
	Connection con =null;
	
	//생성자
	public Dao_form(){
		//driver 연결
		try {
			Class.forName("orcl.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<LibDto> selectAll(){
		//db 계정 연결
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","apitest","apitest");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Statement stmt = null;
		ResultSet rs = null;
		List<LibDto> res = new ArrayList<LibDto>();
		
		String sql = "SELECT * FROM SEOUL_LIB";
		
		//sql 실행
		try {
			stmt = con.createStatement();
			
			//쿼리 실행결과 rs에 저장
			rs = stmt.executeQuery(sql);
			
			//rs dto에 순서대로 저장
			while(rs.next()){
				LibDto dto = new LibDto(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
				res.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				stmt.close();
				con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return res;
	}
}
