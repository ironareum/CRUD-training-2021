package com.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import jdbcTemplete.JDBCTemplate;

import com.mvc.dto.BDMemberDto;

public class BDMemberDao extends JDBCTemplate{
	//관리자 기능 admin
	//회원 전체정보 출력(탈퇴회원 포함)
	public List<BDMemberDto> selectAll(){
		return null;
	}
	
	//가입 회원 정보 출력
	public List<BDMemberDto> selectEnabled(){
		return null;
	}
	
	//회원 등급 조정
	public int updateRole(int bm_no, String bm_role){
		return 0;
	}
	
	//사용자 기능 user
	//로그인
	public BDMemberDto login(String id, String pw){
		Connection con = getConnection();
		PreparedStatement pstm =null;
		ResultSet rs =null;
		BDMemberDto res = new BDMemberDto();
		
		String sql = "select * from bdmember where bm_id=? and bm_pw=? and bm_enabled=?";
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, id);
			pstm.setString(2, pw);
			pstm.setString(3, "Y");
			
			rs= pstm.executeQuery();
			
			while(rs.next()){
				res.setBm_no(rs.getInt(1));
				res.setBm_id(rs.getString(2));
				res.setBm_pw(rs.getString(3));
				res.setBm_name(rs.getString(4));
				res.setBm_addr(rs.getString(5));
				res.setBm_phone(rs.getString(6));
				res.setBm_email(rs.getString(7));
				res.setBm_enabled(rs.getString(8));
				res.setBm_role(rs.getString(9));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(rs);
			close(pstm);
			close(con);
		}
		
		return res;
	}
	
	//회원가입
	public int inserUser(BDMemberDto dto){
		Connection con = getConnection();
		
		PreparedStatement pstm =null;
		int res=0;
		
		String sql = "insert into bdmember values(BDNO_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, 'Y', 'USER')";
		
		try {
			pstm=con.prepareStatement(sql);
			pstm.setString(1, dto.getBm_id());
			pstm.setString(2, dto.getBm_pw());
			pstm.setString(3, dto.getBm_name());
			pstm.setString(4, dto.getBm_addr());
			pstm.setString(5, dto.getBm_phone());
			pstm.setString(6, dto.getBm_email());
			
			res=pstm.executeUpdate();
			
			if(res >0){
				commit(con);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return res;
	}
	
	//정보조회
	public BDMemberDto selectUser(int bm_no){
		return null;
	}
	
	public String idChk(String bm_id){
		Connection con = getConnection();
		
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String res = null;
		String sql ="select * from bdmember where bm_id=?";
		try {
			pstm=con.prepareStatement(sql);
			pstm.setString(1, bm_id);
			
			rs=pstm.executeQuery();
			
			while(rs.next()){
				res = rs.getString(2);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(rs);
			close(pstm);
			close(con);
		}
		return res;
	}
}
