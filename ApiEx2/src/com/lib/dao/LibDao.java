package com.lib.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import com.dto.LibDto;
import com.jdbc.JDBCTemplate;

public class LibDao extends JDBCTemplate{
	
	public int delete(){
		Connection con = getConnection();
		System.out.println("con 연결 ");
		
		PreparedStatement pstm = null;
		int res = 0;
		
		String sql = "DELETE FROM SEOUL_LIB"; 
		
		try {
			pstm = con.prepareStatement(sql);
			res = pstm.executeUpdate();
			
			if(res>0){ //update 한 row 반환 개수 
				commit(con);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstm);
			close(con);
		}
		return res;
	}
	
	public int insert(List<LibDto> dtos){
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		
		String sql = "INSERT INTO SEOUL_LIB VALUES(?,?,?,?,?,?)"; 
		
		try {
			pstm = con.prepareStatement(sql);
			
			for(int i=0; i<dtos.size(); i++){
				LibDto dto = dtos.get(i);
				pstm.setString(1,dto.getGU_CODE());
				pstm.setString(2,dto.getLIB_SEQ());
				pstm.setString(3,dto.getLIB_NAME());
				pstm.setString(4,dto.getADDR());
				pstm.setString(5,dto.getTEL());
				pstm.setString(6,dto.getHPG());
				
				pstm.addBatch(); //메모리에 대기
			}
			
			int[] result = pstm.executeBatch(); //실행결과 건수 저장된 배열 반환 -> result에 저장
			
			for(int i=0; i<result.length; i++){
//				System.out.println("배치"+i+"번째 요소 값: "+result[i]);
				if(result[i]==-2){ //성공. Oracle 기준으로 exeuteBatch( )에서 성공이면 -2 실패면 -3의 값이 리턴된다.
					res++;
				}
			}
			
			if(res==result.length){ //update 한 row 반환 개수 
				commit(con);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstm);
			close(con);
		}
		return res;
	}
}
