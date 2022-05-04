package com.db.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.db.dto.BoardDto;

public class BoardDao {
	Connection con = null;
	
	public BoardDao(){
		//driver 연결
		try {
			//연결전엔 반드시 jdbc6.jar 라이브러리를 추가하자! 
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("드라이버 못가져옴");
		}
	}
	
	//게시글 전체출력 -> 목록
	public List<BoardDto> selectAll(){
		//db계정연결
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "scott");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("db연결 에러");
		}
		
		Statement stmt = null;
		ResultSet rs = null;
		List<BoardDto> res = new ArrayList<BoardDto>();
		
		String sql = "select * from board";
		
		//sql쿼리 실행
		try {
			stmt=con.createStatement();
			rs=stmt.executeQuery(sql); //sql injection 발생 (보안위험)
			
			//rs 순서대로 저장
			while(rs.next()){
				BoardDto dto= new BoardDto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5));
				res.add(dto);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				stmt.close();
				con.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		return res;
	}
	
	public BoardDto selectOne(int bd_no){
		//db계정연결
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "scott");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("db연결 에러");
		}
		
		PreparedStatement pstm = null;
		ResultSet rs = null;
		BoardDto res = null; 
		
		String sql = "select * from board where bd_no=?";
		//sql쿼리 실행
		try {
			pstm=con.prepareStatement(sql); //쿼리문 미리 생성 
			pstm.setInt(1,bd_no);
			
			rs=pstm.executeQuery(); //sql injection 발생 안함 (good) 
			
			//rs 순서대로 저장
			while(rs.next()){
				res = new BoardDto();
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
	
	public int insert(BoardDto dto){
		//db계정연결
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "scott");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("db연결 에러");
		}
		
		PreparedStatement pstm = null;
		int res=0;
		
		String sql = "insert into board values(BD_SEQ.NEXTVAL,?,?,?,SYSDATE)";
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
	
	public int update(BoardDto dto){
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "scott");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("db연결 에러");
		}
		
		PreparedStatement pstm = null;
		int res=0;
		
		String sql = "update board set "
				+ "bd_title= ?, "
				+ "bd_content= ?, "
				+ "bd_date= SYSDATE "
				+ "where bd_no=?";
		//sql쿼리 실행
		try {
			System.out.printf("들어옴? no:%d, title: %s, content: %s%n", dto.getBd_no(), dto.getBd_title(), dto.getBd_content());
			pstm=con.prepareStatement(sql); //쿼리문 미리 생성 
			pstm.setString(1,dto.getBd_title());
			pstm.setString(2,dto.getBd_content());
			pstm.setInt(3,dto.getBd_no());
			
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
	
	public int delete(int bd_no){
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "scott");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("db연결 에러");
		}
		
		PreparedStatement pstm = null;
		int res=0;
		
		String sql = "delete from board where bd_no=?";
		
		//sql쿼리 실행
		try {
			pstm=con.prepareStatement(sql); //쿼리문 미리 생성 
			pstm.setInt(1,bd_no);
			
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
	
	public int multiDelete(String[] bd_no){
		
		try {
			con = DriverManager.getConnection("jdbc:oracle:@localhost:1521:xe", "scott", "scott");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		PreparedStatement pstm = null;
		int res=0;
		int[] cnt =null;
		
		String sql = "DELETE FROM BOARD WHERE BD_NO=?";
		try {
			for(int i=0; i<bd_no.length; i++){
				pstm=con.prepareStatement(sql);
				pstm.setString(1, bd_no[i]);
				
				//쿼리문 pstm에 모두 쌓아 배치처리
				pstm.addBatch();
			}
			cnt = pstm.executeBatch();
			
			for(int i=0; i<cnt.length; i++){
				if(cnt[i]==-2){
					res++;
				}
			}
			
			//모아둔 쿼리 실행 끝나면 커밋
			if(bd_no.length==res){
				con.commit();
			}else {
				con.rollback();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstm.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return res; 
	}
} 
