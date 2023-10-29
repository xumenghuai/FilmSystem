package FilmSys;
import java.util.Scanner;
public class User extends Operator {
    boolean bug=true;





    public User() {
        //表单为：给账户和密码赋值
        //accountList[]="";passwordList[]="";
        accountList[0]="u111111";passwordList[0]="u123456";
        accountList[1]="u222222";passwordList[1]="u223456";
        accountList[2]="u333333";passwordList[2]="u323456";

    }
   public boolean registerNewUser(){
        //账户注册

        String newUser;
        String newpass;
        System.out.println("账户注册");
        System.out.println("输入您的账户");
        Scanner sc=new Scanner(System.in);
        newUser=sc.next();
        //System.out.println(accountList[4]);

       for(int i=0;i<size;i++){
           if(newUser.equals(accountList[i])){
               System.out.println("账户已存在");
               this.bug=false;
               return false;
           }
       }
       if(this.bug){
           this.size=size+1;
           accountList[size-1]=newUser;
           System.out.println("请输入你的密码：");
           newpass=sc.next();
           passwordList[size-1]=newpass;

       }

        return true;
   }







}
