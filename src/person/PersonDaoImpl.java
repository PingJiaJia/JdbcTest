package person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 *只做数据库访问操作！不参与逻辑判断
 */
public class PersonDaoImpl {

    public int insert(Person person){
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        String sql="insert into person(name,age,bornDate,email,address) values(?,?,?,?,?)";

        connection=DBUtils.getConnection();
        try {
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,person.getName());
            preparedStatement.setInt(2,person.getAge());
            preparedStatement.setString(3,null);
            preparedStatement.setString(4,person.getEmail());
            preparedStatement.setString(5,person.getAddress());
            int result=preparedStatement.executeUpdate();
            return result;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    public int update(Person person){
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        String sql="update person set name=?,age=?,bornDate=?,email=?,address=? where id=?";

        connection=DBUtils.getConnection();
        try {
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,person.getName());
            preparedStatement.setInt(2,person.getAge());
            preparedStatement.setString(3,null);
            preparedStatement.setString(4,person.getEmail());
            preparedStatement.setString(5,person.getAddress());
            preparedStatement.setInt(6,person.getId());
            int result=preparedStatement.executeUpdate();
            return result;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return 0;
    }

    public int delete(int id){
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        String sql="delete from person where id=?";

        connection=DBUtils.getConnection();
        try {
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            int result=preparedStatement.executeUpdate();
            return result;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    public Person select(int id){
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        String sql="select * from person where id=?";
        Person person=null;
        try {
            connection=DBUtils.getConnection();
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                person=new Person();
                int pid=resultSet.getInt("id");
                String name=resultSet.getString("name");
                int age=resultSet.getInt("age");
                Date bornDate=resultSet.getDate("bornDate");
                String email=resultSet.getString("email");
                String address=resultSet.getString("address");
                person.setId(pid);
                person.setName(name);
                person.setAge(age);
                person.setBornDate(bornDate);
                person.setEmail(email);
                person.setAddress(address);
            }
            return person;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DBUtils.closeAll(connection,preparedStatement,resultSet);
        }
        return null;
    }

    //查询 所有
    public List<Person> selectAll(){
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        String sql="select * from person";
        connection=DBUtils.getConnection();
        List<Person> personList = new ArrayList<>();
        try {
            preparedStatement=connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int pid=resultSet.getInt("id");
                String name=resultSet.getString("name");
                int age=resultSet.getInt("age");
                Date bornDate=resultSet.getDate("bornDate");
                String email=resultSet.getString("email");
                String address=resultSet.getString("address");
                Person person=new Person(pid,name,age,bornDate,email,address);
                personList.add(person);
            }
            return  personList;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }




}
