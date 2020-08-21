package person;

public class TestRegister {
    public static void main(String[] args) {
        PersonServiceImpl personService = new PersonServiceImpl();
        Person person=new Person("Marry1",12,DateUtils.strToUtil("1997-07-07"),"Marry@qq.com","北京市海淀区");
        personService.register(person);

    }
}
