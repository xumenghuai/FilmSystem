package FilmSys;
import java.util.Scanner;
import java.util.Random;
public class Operator {
    //private static final int Operator_SIZE = 20;
    public  int Operator_SIZE=100;
    protected String[] accountList = new String[Operator_SIZE];

    protected String[] passwordList = new String[Operator_SIZE];
    protected String account;
    protected String password;

    protected int index=0;

    protected int size=3;
    boolean bug0=false;
    Scanner sc=new Scanner(System.in);
    long code;
    Long tempCode;
    String tempString;


    //找到账号在表的位置
    public void findIndex(){
        for(int i=0;i<size;i++){
            if(account.equals(accountList[i])){
                this.index=i;
            }
        }

    }

    //实现账号和密码的操作（这里存储账号和密码）

    public Operator() {
        //表单为：给账户和密码赋值
        //accountList[]="";passwordList[]="";
        accountList[0]="111111";passwordList[0]="123456";
        accountList[1]="222222";passwordList[1]="223456";
        accountList[2]="333333";passwordList[2]="323456";

    }

    public int getOperator_SIZE(){
        //得到人数；
        for(int i=0;;i++){
            if(accountList[i]==null){
                this.size=i;
                if(i>100){
                    System.out.println("账户已满");
                }
                break;
            }
        }
        return size;
    }

    public void getAccount(int n) {
        //获得账户
        System.out.println(accountList[n-1]);
    }

    public void getAccount() {
        //获得账户
        System.out.println("请输入你的账号：");
        this.account=sc.next();
    }

    public void getPassword(int m) {
        //获得密码
        System.out.println(passwordList[m-1]);
    }
    public void getPassword() {
        //获得密码
        System.out.println("请输入你的密码：");
        this.password=sc.next();
    }

    public boolean findIt() {
        //查询账号和密码是否匹对

        for (int i = 0; i < size; i++) {
            if (account.equals(accountList[i]) ) {
                if (password.equals(passwordList[i])) {
                    bug0=true;
                }

            }

        }
        return bug0;
    }

    public void printImformation(){
        System.out.println("欢迎来到使用者界面");
        System.out.println("请输入一下你身份的编号");
        System.out.println("普通用户：A");
        System.out.println("管理员：B");
        System.out.println("前台：C");
        System.out.println("总经理：D");
    }

    public boolean login(){
        for(int i=0;i<5;i++){
            getAccount();
            getPassword();
           if(findIt()){
               System.out.println("登入成功");
               return true;
           }else {
               System.out.println("账号或密码错误");
           }
        }
        System.out.println("登入失败");
        return false;

    }



    public  void changPassword(){
        System.out.println("请输入以前的密码：");
        String password1;
        password1= sc.next();
        if(password1.equals(password)){
            System.out.println("请输入新的密码：");
            tempString= sc.next();
            findIndex();
            this.passwordList[index]=tempString;
        }

    }
    public  void forgetPassword(){
        System.out.println("请输入你的账号：");
        tempString=sc.next();
        if(tempString.equals(account)){
            System.out.println("请输入你绑定的邮箱：");
            tempString=sc.next();
            Random r = new Random();
            this.code=r.nextLong(89999)+10000;
            System.out.println("验证码为："+code);
            System.out.println("请输入验证码：");
            tempCode=sc.nextLong();
            if(tempCode==code){
                System.out.println("请输入新的密码：");
                tempString= sc.next();
                findIndex();
                this.passwordList[index]=tempString;
            }

        }


    }




}
