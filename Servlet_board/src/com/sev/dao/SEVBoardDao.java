package com.sev.dao;

import java.sql.Connection;
import java.util.List;

import com.sev.dto.SEVBoardDto;

public interface SEVBoardDao {
	public List<SEVBoardDto> selectAll( Connection con);
	
	public SEVBoardDto selectOne(Connection con, int bd_no);
	
	public boolean insert(Connection con, SEVBoardDto dto);
	
	public boolean update(Connection con, SEVBoardDto dto);

	public boolean delete(Connection con, SEVBoardDto dto);
}
