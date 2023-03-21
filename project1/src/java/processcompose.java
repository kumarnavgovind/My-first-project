

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class processcompose extends HttpServlet {
    
    Connection co;
    PreparedStatement st;
    ResultSet rs;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      ServletContext sc=request.getServletContext();
      co=(Connection) sc.getAttribute("conc");
      HttpSession scx=request.getSession();
      
      String too=request.getParameter("too");
      String frm=(String) scx.getAttribute("nam");
      String sub=request.getParameter("sub");
      String msg=request.getParameter("msg");
      String sbut=request.getParameter("sbut");
      try
      {
          if(sbut.equals("SAVE"))
          {
             st= co.prepareStatement("insert into save( too,frm,sub,msg) values(?,?,?,?)");
             st.setString(1,frm);
             st.setString(2,frm);
             st.setString(3, sub);
             st.setString(4,msg);
             st.executeUpdate();
             System.out.print("massage save in your save");
             st.close();
             
              
              
          }
            else if(sbut.equals("SEND"))
        {
            int c=0;
            st=co.prepareStatement("select * from user where Name=?");
            st.setString(1,too);
           rs=st.executeQuery();
            
            while(rs.next())
            {
                c=c+1;
                
            }
            st.close();
            
            if(c==0)
            {
                sub="Failed_"+sub;
            st=co.prepareStatement("insert into draft(too,frm,sub,msg) values(?,?,?,?)");
            st.setString(1,too);
            st.setString(2,frm);
            st.setString(3,sub);
            st.setString(4,msg);
            st.executeUpdate();
            st.close();
            st=co.prepareStatement("insert into send(too,frm,sub,msg) values(?,?,?,?)");
            st.setString(1,too);
            st.setString(2,frm);
            st.setString(3,sub);
            st.setString(4,msg);
            st.executeUpdate();
            st.close();
            System.out.print("mail sending failed");
            }
            else
            {
            st=co.prepareStatement("insert into inbox(too,frm,sub,msg) values(?,?,?,?)");
            st.setString(1,too);
            st.setString(2,frm);
            st.setString(3,sub);
            st.setString(4,msg);
            st.executeUpdate();
            st.close();
            st=co.prepareStatement("insert into send(too,frm,sub,msg) values(?,?,?,?)");
            st.setString(1,too);
            st.setString(2,frm);
            st.setString(3,sub);
            st.setString(4,msg);
            st.executeUpdate();
            st.close();
            System.out.print("mail sending sucessfully");    
            }
            
        }
      }catch(Exception e)
      {
          System.out.print("SQLException"+e);
      }
    }

  
}
