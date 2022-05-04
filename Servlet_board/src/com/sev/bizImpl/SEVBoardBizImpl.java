package com.sev.bizImpl;

import java.sql.Connection;
import java.util.List;

import com.sev.biz.SEVBoardBiz;
import com.sev.dao.SEVBoardDao;
import com.sev.daoImpl.SEVBoardDaoImpl;
import com.sev.dto.SEVBoardDto;
import com.sev.jdbc.JDBCTemplate;

public class SEVBoardBizImpl extends JDBCTemplate implements SEVBoardBiz{
	private SEVBoardDao dao = new SEVBoardDaoImpl();
	
	@Override
	public List<SEVBoardDto> selectAll() {
		Connection con = getConnection();
		List<SEVBoardDto> res = dao.selectAll(con);
		return null;
	}

	@Override
	public SEVBoardDto selectOne(int bd_no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(SEVBoardDto dto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(SEVBoardDto dto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(SEVBoardDto dto) {
		// TODO Auto-generated method stub
		return false;
	}

}
