import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.HTML;

public class LoginServlet extends HttpServlet{
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		System.out.println("name:"+name);
		System.out.println("password:"+password);
		
		System.out.println("�������������ʱ������URL������Э�� ������ �˿�(�����): " +request.getRequestURI());
		System.out.println("����������������Դ�����֣�ȥ����Э���������: "+request.getRequestURI());
		System.out.println("�������еĲ�������: "+request.getQueryString());
		System.out.println("����������ڵĿͻ�����IP��ַ: " +request.getRemoteAddr());
		System.out.println("����������ڵĿͻ�����������: "+request.getRemoteHost());
		System.out.println("����������ڵĿͻ���ʹ�õ�����˿�:"+request.getRemotePort());
		System.out.println("��������IP��ַ: " +request.getLocalAddr());
		System.out.println("��������������: "+request.getLocalName());
		System.out.println("�õ��ͻ�������ʽ: " +request.getMethod());
		if ("admin".equals(name)&&"123".equals(password)) {
			request.getRequestDispatcher("success.html").forward(request, response);
		}else{
			response.sendRedirect("fail.html");
		}

	}
	
}
