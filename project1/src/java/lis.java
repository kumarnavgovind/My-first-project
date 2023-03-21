
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


public class lis implements ServletContextListener {
    
    Connection co;
    @Override
    public void contextInitialized(ServletContextEvent sce) 
    {
        try
        {
            ServletContext sc=sce.getServletContext();
          Class.forName("com.mysql.jdbc.Driver");
          co=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", null);
          sc.setAttribute("conc", co);
            
        }catch(Exception e)
        {
            System.out.print("connection"+e);
        }
     
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
