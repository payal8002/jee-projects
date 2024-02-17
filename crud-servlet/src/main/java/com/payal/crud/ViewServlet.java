package com.payal.crud;
import java.io.IOException;  
import java.io.PrintWriter;  
import java.util.List;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/ViewServlet")  

public class ViewServlet extends HttpServlet{
	 protected void doGet(HttpServletRequest request, HttpServletResponse response)   
             throws ServletException, IOException {  
      response.setContentType("text/html");  
      PrintWriter writer=response.getWriter();  
      writer.println("<a href='index.html'>Add New Employee</a>");  
      writer.println("<h1>Employees List</h1>");  
        
      List<Emp> list=EmpDao.getAllEmployees();  
        
      writer.print("<table border='1' width='100%'");  
      writer.print("<tr><th>Id</th><th>Name</th><th>Password</th><th>Email</th><th>Country</th>   <th>Edit</th><th>Delete</th></tr>");  
        
      for(Emp e:list){  
       writer.print("<tr><td>"+e.getId()+"</td><td>"+e.getName()+"</td><td>"+e.getPassword()+"</td> <td>\"+e.getEmail()+\"</td><td>\"+e.getCountry()+\"</td><td><a href='EditServlet?id=\"+e.getId()+\"'>edit</a></td>  \r\n"
       		+ "<td><a href='DeleteServlet?id=\"+e.getId()+\"'>delete</a></td></tr>");    
              
      }  
      writer.print("</table>");  
        
      writer.close();  
  }  
}  


