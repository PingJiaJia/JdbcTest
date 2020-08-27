package account;

public class AccountServiceImpl {
    public void transfer(String fromNo,String pwd,String toNo,double money){   //收参
        try {
            AccountDaoImpl accountDao = new AccountDaoImpl();
            //2.组织完善业务功能
            //2.1 验证fromNo是否存在
            Account account = accountDao.select(fromNo);
            if (account==null){
                throw new RuntimeException("卡号不存在！");
            }
            //2.2 验证fromNo的密码是否正确
            if (!account.getPassword().equals(pwd)){
                throw new RuntimeException("密码错误！");
            }

            //2.3 验证余额是否充足
            if(account.getBalance()<money){
                throw new RuntimeException("余额不足！");
            }

            //2.4 验证toNo是否存在
            Account toAccount = accountDao.select(toNo);
            if (toAccount==null){
                throw new RuntimeException("对方卡号不存在！");
            }

            //2.5 减少fromNo的余额
            account.setBalance(account.getBalance()-money);
            accountDao.update(account);

            //2.6 增加toNo的余额
            account.setBalance(account.getBalance()+money);
            accountDao.update(toAccount);
            System.out.println("转账成功！");

        } catch (RuntimeException e) {
            System.out.println("转账失败！");
            e.printStackTrace();
        }


    }
}
