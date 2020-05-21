package pl.valvar.servlets;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import pl.valvar.models.User;
import pl.valvar.dao.UsersDao;
import pl.valvar.dao.UsersDaoJdbcTemplateImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Properties;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {
    private UsersDao usersDao;

    @Override
    public void init() throws ServletException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Properties properties = new Properties();
        DriverManagerDataSource dataSource =
                new DriverManagerDataSource();

        try {
            properties.load(new FileInputStream(getServletContext().getRealPath("/WEB-INF/classes/db.properties")));
            String dbUrl = properties.getProperty("db.url");
            String dbUsername = properties.getProperty("db.username");
            String dbPassword = properties.getProperty("db.password");
            String driverClassName = properties.getProperty("db.driverClassName");
            dataSource.setUsername(dbUsername);
            dataSource.setPassword(dbPassword);
            dataSource.setUrl(dbUrl);
            dataSource.setDriverClassName(driverClassName);

            usersDao = new UsersDaoJdbcTemplateImpl(dataSource);
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession(false);
        if (session!=null){
            String nickname = (String) session.getAttribute("user");
            List<User> users = null;
            users = usersDao.findProfileByFirstName(nickname);
            if(users.isEmpty()){
            }
            else{
                for (User item: users) {
                    req.setAttribute("nickname",nickname);
                    req.setAttribute("email",item.getEmail());
                    if (item.getCity().equals("")){
                        req.setAttribute("city","");
                    }else{
                        req.setAttribute("city",item.getCity());
                    }

                    if (item.getUniversity().equals("")){
                        req.setAttribute("university","");
                    }else{
                        req.setAttribute("university",item.getUniversity());
                    }

                    if (item.getKilometers()==0){
                        req.setAttribute("kilometers","0");
                    }else{
                        req.setAttribute("kilometers",item.getKilometers());
                    }
                }
            }
            req.setAttribute("reg",users.get(0).getUniversity());
        }
        req.getServletContext().getRequestDispatcher("/jsp/profile.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nickname = req.getParameter("name");
        String university = req.getParameter("uni");
        String city = req.getParameter("city");
        int error = usersDao.updateUser(nickname,university,city);
        HttpSession session = req.getSession();
        session.setAttribute("user", nickname);
        req.getServletContext().getRequestDispatcher("/main").forward(req, resp);
    }
}
