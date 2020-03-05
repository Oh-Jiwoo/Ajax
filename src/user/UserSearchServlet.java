package user;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/UserSearchServlet")
public class UserSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
						throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		String userName = request.getParameter("userName");
		response.getWriter().write(getJSON(userName));
	}

	
	public String getJSON(String userName) {
		//파싱하기 쉬운 하나의 형태 특정한 회원을 검색했을때 검색한 정보가 JSON형태로 출력되고 그것을 다시 파싱해서 우리에게 보여줌
		//서버역할을 하는 서블릿은 JSON을 만들어내는 역할을 함
		//index페이지않에서 요청을 하여 결과를 불러올때 그 결과가 JSON형태로 나옴
		if(userName == null) userName = "";
		StringBuffer result = new StringBuffer();
		result.append("{\"result\":[");
		UserDAO userDAO = new UserDAO();
		ArrayList<user> userList = userDAO.search(userName);
		for(int i=0; i<userList.size(); i++) {
			result.append("[{\"value\":\""+userList.get(i).getUserName()+"\"},");
			result.append("{\"value\":\""+userList.get(i).getUserAge()+"\"},");
			result.append("{\"value\":\""+userList.get(i).getUserGender()+"\"},");
			result.append("{\"value\":\""+userList.get(i).getUserEmail()+"\"}],");
		}
		result.append("]}");
		
		return result.toString();
	}
}
