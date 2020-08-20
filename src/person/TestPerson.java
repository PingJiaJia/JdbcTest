package person;

public class TestPerson {
    public static void main(String[] args) {
        PersonDaoImpl personDao = new PersonDaoImpl();
        Person person = new Person("Marry",23,DateUtils.strToUtil("2000-06-02"),"Marry@qq.com","江苏省南通市");
        int result=personDao.insert(person);
        if(result==1){
            System.out.println("插入成功");
        }else {
            System.out.println("插入失败");
        }
    }

}
