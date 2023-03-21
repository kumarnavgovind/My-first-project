

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class welcome extends HttpServlet {

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         HttpSession scx= request.getSession();
       String pass= (String)scx.getAttribute( "pas");
        String name=(String)scx.getAttribute( "nam");
         response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Welcome to project</title>");            
            out.println("</head>");
            out.println("<body><table border=1 width=100% height=600>");
            
            out.println("<tr height=20%><th colspan=100%><p align=right  > Welcome: "+name+"  "+pass+"</p>"
                    + "<p align=right><input type=submit value=LogOut name=logout></p></th></tr>");
            
                   out.println("<tr height=70%><td  > "
                    + "<p align=center><a href=inbox.html>Inbox</a></p>"
                    + "<p align=center><a href=compose.html>Compose</p>"
                    + "<p align=center><a href=draft.html>Draft</p>"
                    + "<p align=center><a href=sent.html>Sent</p>"
                    + "<p align=center><a href=trash.html>Trash</p>"
                    + "</td><td width=75%></td></tr>"
                    + "<tr height=10%><th colspan=100%><marquee>अब जो बिछडे हैं, तो बिछडने की शिकायत कैसी ।\n" +
"मौत के दरिया में उतरे तो जीने की इजाजत कैसी ।।\n" +
"\n" +
"जलाए हैं खुद ने दीप जो राह में तूफानों के\n" +
"तो मांगे फिर हवाओं से बचने की रियायत कैसी ।।\n" +
"\n" +
"फैसले रहे फासलों के हम दोनों के गर\n" +
"तो इन्तकाम कैसा और दरमियां सियासत कैसी ।।\n" +
"\n" +
"ना उतावले हो सुर्ख पत्ते टूटने को साख से\n" +
"तो क्या तूफान, फिर आंधियो की हिमाकत कैसी ।।\n" +
"\n" +
"वीरां हुई कहानी जो सपनों की तेरी मेरी\n" +
"उजडी पड़ी है अब तलक जर्जर इमारत जैसी ।।\n" +
"\n" +
"अब जो बिछडे हैं, तो बिछडने की शिकायत कैसी ।\n" +
"मौत के दरिया में उतरे तो जीने की इजाजत कैसी ।।</marquee></th></tr>");
            
            out.println("</table>" );
            out.println("</html>");
            
        }
    }

   

}
