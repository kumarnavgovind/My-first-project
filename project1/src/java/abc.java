import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class abc extends HttpServlet {
    Connection co;
    Statement st;
    ResultSet rs;
    PrintWriter pw;
  
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
    //response.setContentType("text/html");
     ServletContext sc=getServletContext();
     
     String s1=request.getParameter("nam");
     String s2=request.getParameter("pas");
      HttpSession scx= request.getSession();
        scx.setAttribute( "pas",s2);
        scx.setAttribute( "nam",s1);
     String s3=request.getParameter("but");
     try{
     co=(Connection) sc.getAttribute("conc");
      if(s3.equals("signup"))
     {
                
                    st=co.createStatement();
                    st.executeUpdate("insert into user values("+" ' "+s1+" ' "+","+" ' "+s2+" ' "+")");
                     response.sendRedirect("index.html");  
                    st.close();
                
     }
     else if(s3.equals("signin"))
     {
                   
                    st=co.createStatement();
                    rs=st.executeQuery("Select * from user where Name=' "+s1+" ' and Pass="+" ' "+s2+" ' ");
                    int c=0;
                    while(rs.next()){
                        c=c+1;
                    }
                    if(c==0)
                    {
                     response.sendRedirect("index.html");  
                       
                      System.out.print("invalid user");
                    }
                    else
                    {
                     response.sendRedirect("welcome");  
                     System.out.print("valid user");
                    }
                    
                    st.close();

                       
     }
         
     }catch(Exception e)
     {
         System.out.print("Exception"+e);
     }
    }
        
    }

   
  

