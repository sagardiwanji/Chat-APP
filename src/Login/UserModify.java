package Login; 
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.PreparedStatement; 
import java.sql.ResultSet; 
import java.sql.SQLException; 
import java.util.ArrayList; 
import java.util.List; 
import java.util.logging.Level; 
import java.util.logging.Logger; 
public class UserModify { 
    public static List<Users> findAll() { 
        List<Users> dataList = new ArrayList<>(); 
        try (Connection connection = DriverManager.getConnection(config.DB_URL, config.DB_USER, config.DB_PASSWORD); 
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM users")) { 
            ResultSet resultSet = statement.executeQuery(); 
            while (resultSet.next()) { 
                Users us = new Users( 
                        resultSet.getString("username"), 
                        resultSet.getString("email"), 
                        resultSet.getString("password"), 
                        resultSet.getInt("role_id"), 
                        resultSet.getInt("active") 
                ); 
                dataList.add(us); 
            } 
        } catch (SQLException | RuntimeException ex) { 
            Logger.getLogger(UserModify.class.getName()).log(Level.SEVERE, "Error finding all users", ex); 
        } 
        return dataList; 
    } 
    public static void insert(Users us) { 
        try (Connection connection = DriverManager.getConnection(config.DB_URL, config.DB_USER, config.DB_PASSWORD); 
             PreparedStatement preparedstatement = connection.prepareStatement(""" 
                 INSERT INTO users (username, email, password, role_id, active) 
                 VALUES (?, ?, ?, ?, ?) 
                 """)) { 
            preparedstatement.setString(1, us.getUsername()); 
            preparedstatement.setString(2, us.getEmail()); 
            preparedstatement.setString(3, us.getPassword()); 
            preparedstatement.setInt(4, us.getRole_id()); 
            preparedstatement.setInt(5, us.getActive()); 
            preparedstatement.execute(); 
        } catch (SQLException | RuntimeException ex) { 
            Logger.getLogger(UserModify.class.getName()).log(Level.SEVERE, "Error inserting user", ex); 
        } 
    } 
    public static Users Login(String username, String password) { 
        Users us = null; 
        try (Connection connection = DriverManager.getConnection(config.DB_URL, config.DB_USER, config.DB_PASSWORD); 
             PreparedStatement preparedstatement = connection.prepareStatement(""" 
                 SELECT * FROM users WHERE username = ? AND password = ? 
                 """)) { 
            preparedstatement.setString(1, username); 
            preparedstatement.setString(2, password); 
            ResultSet resultSet = preparedstatement.executeQuery(); 
            if (resultSet.next()) { 
                us = new Users(resultSet.getString("username"), 
                        resultSet.getString("email"), 
                        resultSet.getString("password"), 
                        resultSet.getInt("role_id"), 
                        resultSet.getInt("active")); 
            } 
        } catch (SQLException | RuntimeException ex) { 
            Logger.getLogger(UserModify.class.getName()).log(Level.SEVERE, "Error during login", ex); 
        } 
        return us; 
    } 
    public static void UpdateActive(String username, int active) { 
        try (Connection connection = DriverManager.getConnection(config.DB_URL, config.DB_USER, config.DB_PASSWORD); 
             PreparedStatement preparedstatement = connection.prepareStatement(""" 
                 UPDATE users SET active = ? WHERE username = ? 
                 """)) { 
            preparedstatement.setInt(1, active); 
            preparedstatement.setString(2, username); 
            preparedstatement.execute(); 
        } catch (SQLException | RuntimeException ex) { 
            Logger.getLogger(UserModify.class.getName()).log(Level.SEVERE, "Error updating user active status", ex); 
        } 
    } 
}