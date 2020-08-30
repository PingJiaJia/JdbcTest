package account;



import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DBUtils {
     private static final Properties PROPERTIES=new Properties();
     private static final ThreadLocal<Connection> threadLocal=new ThreadLocal<>();
     static {
         InputStream inputStream=DBUtils.class.getResourceAsStream("/db.properties");
         try {
             PROPERTIES.load(inputStream);
             Class.forName(PROPERTIES.getProperty("driver"));
         } catch (IOException e) {
             e.printStackTrace();
         } catch (ClassNotFoundException e) {
             e.printStackTrace();
         }
     }

     public static Connection getConnection(){
         Connection connection=threadLocal.get();   //将当前线程中绑定的Connection对象，赋值给connection
         try {
             if (connection==null){
                 connection= DriverManager.getConnection(PROPERTIES.getProperty("url"),PROPERTIES.getProperty("username"),PROPERTIES.getProperty("password"));
                 threadLocal.set(connection);    //把连接存在当前线程共享中
             }

             return connection;
         } catch (SQLException throwables) {
             throwables.printStackTrace();
         }
         return null;
     }

     public static void closeAll(Connection connection, Statement statement, ResultSet resultSet){
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
