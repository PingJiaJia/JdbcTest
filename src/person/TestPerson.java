package person;

public class TestPerson {
    public static void main(String[] args) {
        PersonDaoImpl personDao = new PersonDaoImpl();
        Person person = new Person("胡某灿",23,null,"pingjiacheng@rongzi.com","江苏省南通市");
        int result=personDao.insert(person);
        if(result==1){
            System.out.println("插入成功");
        }else {
            System.out.println("插入失败");
        }
    }

}
