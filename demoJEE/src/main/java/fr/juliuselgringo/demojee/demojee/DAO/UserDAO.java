package fr.juliuselgringo.demojee.demojee.DAO;

import fr.juliuselgringo.demojee.demojee.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends DAO<User> {

    public UserDAO() throws SQLException {
        super();
    }

    @Override
    public User create(User entity) throws SQLException {
        return null;
    }

    @Override
    public boolean update(User entity) throws SQLException {
        return false;
    }

    @Override
    public boolean deleteById(Integer pId) throws SQLException {
        return false;
    }

    @Override
    public User findById(Integer pId) throws SQLException {
        return null;
    }

    @Override
    public List<User> findAll(Connection conn) throws SQLException {
        List<User> list = new ArrayList<User>();

        String sql = "SELECT * FROM customers";

        try{
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                 String firstName = rs.getString("first_name");
                 String lastName = rs.getString("last_name");
                 Integer age = rs.getInt("age");
                 list.add(new User(firstName, lastName, age));

            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return list;
    }
}
