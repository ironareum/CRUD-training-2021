package com.sev.biz;

import java.util.List;

import javax.sql.rowset.JdbcRowSet;

import com.sev.jdbc.JDBCTemplate;

import com.sev.dto.SEVBoardDto;

//model 
public interface SEVBoardBiz {
	
	public List<SEVBoardDto> selectAll();
	
	public SEVBoardDto selectOne(int bd_no);
	
	public boolean insert(SEVBoardDto dto);
	
	public boolean update(SEVBoardDto dto);

	public boolean delete(SEVBoardDto dto);
}
