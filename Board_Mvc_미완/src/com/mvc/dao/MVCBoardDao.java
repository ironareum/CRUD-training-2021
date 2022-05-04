package com.mvc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jdbcTemplete.JDBCTemplate;

import com.mvc.dto.MVCBoardDto;

public class MVCBoardDao extends JDBCTemplate{
	
	public List<MVCBoardDto> selectAll() {
		//db연결
		Connection con = getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		List<MVCBoardDto> res=new ArrayList<MVCBoardDto>();
		
		String sql = "select * from mvcboard";
		
		//sql쿼리 실행
		try {
			stmt=con.createStatement();
			rs=stmt.executeQuery(sql); //sql injection 발생 (보안위험)
			
			//rs 순서대로 저장
			while(rs.next()){
				MVCBoardDto dto= new MVCBoardDto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5));
				res.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
				close(rs);
				close(stmt);
				close(con);
		}
		return res;
	}
	
	public MVCBoardDto selectOne(int bd_no){
		//db연결
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		MVCBoardDto res = null; 
		
		String sql = "select * from mvcboard where bd_no=?";
		//sql쿼리 실행
		try {
			pstm=con.prepareStatement(sql); //쿼리문 미리 생성 
			pstm.setInt(1,bd_no);
			
			rs=pstm.executeQuery(); //sql injection 발생 안함 (good) 
			
			//rs 순서대로 저장
			while(rs.next()){
				res = new MVCBoardDto();
				res.setBd_no(rs.getInt(1));
				res.setBd_name(rs.getString(2));
				res.setBd_title(rs.getString(3));
				res.setBd_content(rs.getString(4));
				res.setBd_date(rs.getDate(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				pstm.close();
				con.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return res;
	}
	
	public int insert(MVCBoardDto dto){
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res=0;
		
		String sql = "insert into mvcboard values(BD_SEQ.NEXTVAL,?,?,?,SYSDATE)";
		//sql쿼리 실행
		try {
			pstm=con.prepareStatement(sql); //쿼리문 미리 생성 
			
			pstm.setString(1,dto.getBd_name());
			pstm.setString(2,dto.getBd_title());
			pstm.setString(3,dto.getBd_content());
			
			res=pstm.executeUpdate(); 
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				pstm.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
		return res;
	}
	
	public int update(MVCBoardDto dto){
		return 0;
	}
	
	public int delete(int bd_no){
		return 0;
	}
	
	public int multiDelete(String[] bd_no){
		return 0;
	}

}
