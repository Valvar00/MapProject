package pl.valvar.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import pl.valvar.models.User;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.util.*;

public class UsersDaoJdbcTemplateImpl implements UsersDao {

    private JdbcTemplate template;

    private final String SQL_SELECT_ALL =
            "SELECT * FROM test";

    //SQL Update statement
    private final String SQL_UPDATE_USER_nickname = "UPDATE customers SET nickname=?WHERE id = 1";
    private final String SQL_UPDATE_USER_city = "UPDATE customers SET City = ? WHERE id = 1";
    private final String SQL_UPDATE_USER_university = "UPDATE customers SET University = ? WHERE id = 1";

    private Map<Integer, User> usersMap = new HashMap<>();

    //language=SQL
    private final String SQL_SELECT_ALL_BY_FIRST_NAME =
            "SELECT * FROM customers WHERE nickname = ?";

    private final String SQL_INSERT_INTO_TEST =
            "INSERT INTO customers(nickname,email,Pass) VALUES(?,?,?)";

    public UsersDaoJdbcTemplateImpl(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }

    private RowMapper<User> userRowMapper
            = (ResultSet resultSet, int i) -> {
       Integer id = resultSet.getInt("id");

       if (!usersMap.containsKey(id)) {
           String nickName = resultSet.getString("nickname");
           String email = resultSet.getString("email");
           String pass = resultSet.getString("Pass");
           User user = new User(id, nickName, email, pass);
           usersMap.put(id, user);
       }

       return usersMap.get(id);
    };

    private RowMapper<User> fulluserRowMapper
            = (ResultSet resultSet, int i) -> {
        Integer id = resultSet.getInt("id");

        if (!usersMap.containsKey(id)) {
            String nickName = resultSet.getString("nickname");
            String email = resultSet.getString("email");
            String pass = resultSet.getString("Pass");
            String University = resultSet.getString("University");
            String City= resultSet.getString("City");
            String Kilometers = resultSet.getString("Kilometers");
            User user = new User(id, nickName, email, pass, University, City,Integer.parseInt(Kilometers));
            usersMap.put(id, user);
        }
        return usersMap.get(id);
    };

    @Override
        public int insertUser(String name,String password, String email){
            if(template.query(SQL_SELECT_ALL_BY_FIRST_NAME, userRowMapper, name).isEmpty()){
                template.update(SQL_INSERT_INTO_TEST,name,email,password);
                return 0;
            }
            return 2;
        }

    @Override
    public int updateUser(String nickname,String uni, String city){
        if(template.query(SQL_SELECT_ALL_BY_FIRST_NAME, userRowMapper, nickname).isEmpty()){
            template.update(SQL_UPDATE_USER_nickname,nickname);
            template.update(SQL_UPDATE_USER_city,city);
            template.update(SQL_UPDATE_USER_university,uni);
            return 0;
        }
        return 1;
    }

        @Override
        public List<User> findAllByFirstName(String firstName) {
            for(User item : template.query(SQL_SELECT_ALL_BY_FIRST_NAME, userRowMapper, firstName)){
            }
            return template.query(SQL_SELECT_ALL_BY_FIRST_NAME, userRowMapper, firstName);
        }

        public List<User> findProfileByFirstName(String firstName) {
            for(User item : template.query(SQL_SELECT_ALL_BY_FIRST_NAME, fulluserRowMapper, firstName)){
            }
            return template.query(SQL_SELECT_ALL_BY_FIRST_NAME, fulluserRowMapper, firstName);
    }

        @Override
        public void find(Integer id) {
        }

        @Override
        public void save(User model) {

        }

        @Override
        public void update(User model) {

    }

    @Override
    public void delete(Integer id) {

    }
}
