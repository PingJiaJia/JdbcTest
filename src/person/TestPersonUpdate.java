package person;

public class TestPersonUpdate {
    public static void main(String[] args) {
        PersonDaoImpl personDao=new PersonDaoImpl();
        Person person=new Person(2,"胡金灿",19, DateUtils.strToUtil("2020-01-30"),"hujc@qq.com","湖北省武汉市");
        int result = personDao.update(person);
        if(result==1){
            System.out.println("修改成功！");
        }else {
            System.out.println("修改失败！");
        }

    }
}
