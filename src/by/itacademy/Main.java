package by.itacademy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        String url = "jdbc:mysql://127.0.0.1:3307/app";
        String username = "root";
        String password = "root";
        Class.forName("com.mysql.jdbc.Driver");

        try(Connection conn = DriverManager.getConnection(url, username, password)){
            System.out.println("successful");
            //PreparedStatement stmt = conn.prepareStatement("UPDATE user SET login=?, password=? WHERE id=?");
            //PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users");
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO users (login, password) VALUES (?,?)");
            //PreparedStatement stmt = conn.prepareStatement("DELETE FROM user WHERE");
            stmt.setString(1, "Roman");
            stmt.setString(2, "232323");
            //stmt.setInt(3, 3);
            stmt.execute();
            //String name;
            /*while(rs.next()){
                name = rs.getString("password");
                System.out.println("--------------------");
                System.out.println("name+"/n);
            }*/
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
/*



* */