package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FilterAll implements Filter {
 
     public void init(FilterConfig filterConfig) throws ServletException {
         // TODO Auto-generated method stub
 
     }
 
     public void doFilter(ServletRequest request, ServletResponse response,
             FilterChain chain) throws IOException, ServletException {
         // ��������������Ҫ�õ�request,response,session����
         HttpServletRequest servletRequest = (HttpServletRequest) request;
         HttpServletResponse servletResponse = (HttpServletResponse) response;
         HttpSession session = servletRequest.getSession();
 
         // ����û������URI
         String path = servletRequest.getRequestURI();
         //System.out.println(path);
         
         // ��session��ȡԱ��������Ϣ
         String userid = (String) session.getAttribute("userid");
 
         /*������Constants.java������д����������˵�ҳ��
         for (int i = 0; i < Constants.NoFilter_Pages.length; i++) {
 
             if (path.indexOf(Constants.NoFilter_Pages[i]) > -1) {
                 chain.doFilter(servletRequest, servletResponse);
                 return;
             }
         }*/
         
         // ��½ҳ���������
         if(path.indexOf("/login.jsp") > -1) {
             chain.doFilter(servletRequest, servletResponse);
             return;
         }
         if(path.indexOf("/index.jsp") > -1) {
             chain.doFilter(servletRequest, servletResponse);
             return;
         }
 
         // �ж����û��ȡ��Ա����Ϣ,����ת����½ҳ��
         if (userid == null || "".equals(userid)) {
             // ��ת����½ҳ��
             servletResponse.sendRedirect("/html/sessionloss.html");
         } else {
             // �Ѿ���½,�����˴�����
             chain.doFilter(request, response);
         }
 
     }
 
     public void destroy() {
         // TODO Auto-generated method stub
 
     }
 
}