package person;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DBUtils {
    private static final Properties PROPERTIES=new Properties();

    static{
        InputStream inputStream=DBUtils.class.getResourceAsStream("/db.properties");
        try {
            PROPERTIES.load(inputStream);
            Class.forName(PROPERTIES.getProperty("driver"));
            System.out.println("driver:"+PROPERTIES.getProperty("driver"));
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        Connection connection=null;
        try {
            connection= DriverManager.getConnection(PROPERTIES.getProperty("url"),PROPERTIES.getProperty("username"),PROPERTIES.getProperty("password"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }


    public static void closeAll(Connection connection, Statement statement,ResultSet resultSet){
        try {
            if(resultSet!=null){
                resultSet.close();
            }
            if (statement!=null){
                statement.close();
            }
            if (connection!=null){
                connection.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }



}
