package person;

import java.util.ArrayList;
import java.util.List;

public class TestPersonSelectAll {
    public static void main(String[] args) {
        PersonDaoImpl personDao=new PersonDaoImpl();
        List<Person> personList=personDao.selectAll();
        System.out.println("-----------------");

        for(Person person:personList){
            System.out.println(person);
        }

    }
}
