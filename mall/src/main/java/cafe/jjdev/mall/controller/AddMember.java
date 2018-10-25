package cafe.jjdev.mall.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cafe.jjdev.mall.service.Member;
import cafe.jjdev.mall.service.MemberDao;

 @WebServlet("/AddMember")
public class AddMember extends HttpServlet {
	MemberDao memberDao;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/addMember.jsp").forward(request, response);
		System.out.println("doGet add실행");
	}
 	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		System.out.println("doPost add실행");
 		memberDao = new MemberDao();
		Member member = new Member();
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		member.setId(id);
		member.setPw(pw);

		memberDao.insertMember(member);
		
		response.sendRedirect(request.getContextPath()+"/login");
	}
 }