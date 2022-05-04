package com.sev.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sev.biz.SEVBoardBiz;
import com.sev.bizImpl.SEVBoardBizImpl;
import com.sev.dto.SEVBoardDto;

/**
 * Servlet implementation class SEVBoardServlet
 */
@WebServlet("/SEVBoardServlet")
public class SEVBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SEVBoardServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("=====Served at: ").append(request.getContextPath());
		//인코딩
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		//요청받을 변수 선언
		String command = request.getParameter("command");
		
		SEVBoardBiz biz= new SEVBoardBizImpl();
		
		//만약 요청이 main 이라면?
		if(command.equals("main")){
			List<SEVBoardDto> list = biz.selectAll();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
