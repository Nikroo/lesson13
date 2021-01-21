package by.itacademy;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        String url = "jdbc:mysql://127.0.0.1:3307/app";
        String username = "root";                                                                                             //Это драйвер в оттдельном классе
        String password = "root";
        Class.forName("com.mysql.jdbc.Driver");

        try(Connection conn = DriverManager.getConnection(url, username, password)){
            System.out.println("successful");
            //PreparedStatement stmt = conn.prepareStatement("UPDATE user SET login=?, password=? WHERE id=?");                   Это реализация
            PreparedStatement stmt = conn.prepareStatement("SELECT password FROM users where  login=?");
            //PreparedStatement stmt = conn.prepareStatement("INSERT INTO users (login, password) VALUES (?,?)");
            //PreparedStatement stmt = conn.prepareStatement("DELETE FROM user WHERE");
            //stmt.setString(1, "Roman");
            //stmt.setString(2, "232323");
            //stmt.setInt(3, 3);


            //Для SELECT
            ResultSet rs = stmt.executeQuery();
            String name;
            while(rs.next()){
                name = rs.getString("password");
                System.out.println("--------------------");
                System.out.println(name+"\n");
            }
            //Для SELECT
            stmt.execute();

        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
/*



* */