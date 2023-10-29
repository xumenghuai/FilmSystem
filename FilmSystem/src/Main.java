import FilmSys.FilmOperator;
import FilmSys.User;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        User user=new User();
        FilmOperator filmOperator=new FilmOperator();
        int dete;
        Scanner sc=new Scanner(System.in);
        System.out.println("");
        System.out.println("====================电影管理系统=========================");
        System.out.println("---------------------用户系统--------------------------");
        System.out.println("#####################登入界面##########################");
while (true){
    System.out.println("——————————————————————功能————————————————————————");
    System.out.println("\t\t\t\t\t1.注册 ");
    System.out.println("\t\t\t\t\t2.登入");
    System.out.println("\t\t\t\t\t3.忘记密码");
    System.out.println("\t\t\t\t\t0.退出");
    System.out.println("请输入你要查询的功能序号：");
    System.out.println("----------------------------------------------------------------");
    dete=sc.nextInt();
try{
    if(dete==1){
        System.out.println("-------------------------注册--------------------------------");
        user.registerNewUser();
    } else if (dete==2) {
        System.out.println("---------------------------登入-------------------------");
        user.login();
        while(true){
            System.out.println("——————————————————————用户功能查询——————————————————————");
            System.out.println("\t\t\t\t\t1.修改密码");
            System.out.println("\t\t\t\t\t2.查看所有电影放映信息");
            System.out.println("\t\t\t\t\t3.选座购票");
            System.out.println("\t\t\t\t\t4.取票");
            System.out.println("\t\t\t\t\t5.查看购票历史 时间、购买的电影票信息。");
            System.out.println("\t\t\t\t\t0.退出");
            System.out.println("请输入你要查询的功能序号：");
            System.out.println("----------------------------------------------------------------");
            dete=sc.nextInt();
            if(dete==1){
                System.out.println("--------------------修改密码-----------------");
                user.changPassword();
            } else if (dete==2) {
                System.out.println("--------------------查看所有电影放映信息--------------------");
                filmOperator.look();
            } else if (dete==3) {
                System.out.println("-------------------所有电影放映信息--------------------");
                filmOperator.look();
                System.out.println("-------------------选座购票------------------------");
                filmOperator.selectFilm();
                filmOperator.selectSession();
                filmOperator.p_vote();
                filmOperator.vote();
                filmOperator.p_vote();
                System.out.println("--------------------------付款------------------------");
                filmOperator.payment();

            } else if (dete==4) {
                System.out.println("------------------取票--------------------------");
                filmOperator.getp();
            } else if (dete==5) {
                System.out.println("-------------------查看购票历史 时间、购买的电影票信息------------------");
                filmOperator.lookp();
            } else if (dete==0) {
                System.out.println("是否真的要退出1（是）/0（否）");
                dete=sc.nextInt();
                if(dete==1){
                    break;
                }else if(dete==0){
                }else{
                    System.out.println("你输错了");
                }
            }

        }

    } else if (dete==3) {
        System.out.println("-----------------------------忘记密码-----------------------------");
        user.forgetPassword();
    } else if (dete==0) {
        System.out.println("是否真的要退出1（是）/0（否）");
        dete=sc.nextInt();
        if(dete==1){
            break;
        }else if(dete==0){
        }else{
            System.out.println("你输错了");
        }
    }


}
catch (NumberFormatException e){

}

}

    }
}