package FilmSys;
import java.util.Locale;
import java.util.Scanner;
import java.util.Random;
import java.time.*;
public class FilmOperator {
    String []filmName=new String[5];
    String []director=new String[5];
    String []str=new String[5];
    String []type=new String[5];
    String []imformation=new String[5];
    String []time=new String[5];

    int [][]Session=new int[5][5];
    Scanner sc=new Scanner(System.in);
    String tempString;

    int [][]status=new int[7][12];

    int index;
    int sessionIndex;
    int sessionTime;
    int x,y;
    int tempInt;
    Random r = new Random();

    int codep;
    boolean codes;

    LocalDate tempDate;
    public  FilmOperator(){

        filmName[0]="八角笼中 ";director[0]="王宝强";str[0]="王宝强、王迅";type[0]="动作、励志 ";imformation[0]="讲述了失意的中年男人向腾辉带领一群孩子突出命运重围，探寻人生出路的故事。";time[0]="1:57:01";
        filmName[1]="消失的她";director[1]="崔睿、刘翔 ";str[1]="，朱一龙、倪妮、文咏珊";type[1]="悬疑、犯罪";imformation[1]="讲述了何非的妻子李木子在结婚周年旅行中离奇消失，失踪多天后一个陌生女人突然闯入，并坚称是何非妻子，从而牵扯出一个惊天大案的故事";time[1]="2:01:43 ";
        filmName[2]="超能一家人";director[2]="宋阳";str[2]="艾伦、沈腾、陶慧、张琪、韩彦博、白丽娜";type[2]="喜剧";imformation[2]="讲述了主人公郑前（艾伦 饰）离家出走漂泊多年，开发了一款“理财神器”APP，不料却被家乡喀西契克市邪恶狡猾的市长乞乞科夫（沈腾 饰）盯上。而此时郑前一家人竟遇到天降陨石获得了超能力，但只要有人离开，超能力便会消失。郑前被迫和不靠谱的家人团结起来，共同抵抗乞乞科夫，上演一场超能力VS钞能力的爆笑故事。";time[2]="1:52:15";
        filmName[3]="流浪地球2";director[3]="郭帆";str[3]="吴京、李雪健、沙溢、宁理、王智、朱颜曼滋";type[3]="科幻冒险";imformation[3]="以提出计划将建造1万座行星发动机的时代为故事背景，讲述了“太阳危机”即将来袭，世界陷入一片恐慌之中，人类将面临末日灾难与生命存续的双重挑战故事。";time[3]="2:53:11";
        filmName[4]="长津湖之水门桥";director[4]="陈凯歌、徐克、林超贤监制，徐克";str[4]="吴京、易烊千玺";type[4]="历史战争";imformation[4]="讲述了以抗美援朝战争第二次战役中的长津湖战役为背景，志愿军第七穿插连战士们在结束新兴里和下碣隅里的战斗之后，在美国海军陆战队第1师撤离长津湖路线上的咽喉之处——水门桥展开殊死搏斗的故事。";time[4]="2:29:02";
        Session[0][0]=1;Session[0][1]=2;Session[0][2]=3;Session[0][3]=4;Session[0][4]=5;
        Session[1][0]=2;Session[1][1]=3;Session[1][2]=4;Session[1][3]=5;Session[1][4]=1;
        Session[2][0]=3;Session[2][1]=4;Session[2][2]=5;Session[2][3]=1;Session[2][4]=2;
        Session[3][0]=4;Session[3][1]=5;Session[3][2]=1;Session[3][3]=2;Session[3][4]=3;
        Session[4][0]=5;Session[4][1]=1;Session[4][2]=2;Session[4][3]=3;Session[4][4]=4;
        status[4][3]=1;status[4][4]=1;status[4][5]=1;status[4][6]=1;status[4][7]=1;
        status[5][3]=1;status[5][4]=1;status[5][5]=1;status[5][6]=1;status[5][7]=1;status[5][8]=1;
        status[3][3]=1;status[3][4]=1;status[3][5]=1;status[3][6]=1;
        status[1][6]=1;status[1][7]=1;status[2][5]=1;status[2][6]=1;status[2][7]=1;

    }

    public void selectSession(){
        System.out.println("请输入电影场次");
        tempInt=sc.nextInt();
        for (int i = 0; i < 5; i++) {
            if(tempInt==Session[index][i]){
                this.sessionIndex=i;
                this.sessionTime=(i*3+8);
            }
        }


    }


public void look(){
        for(int i=0;i<5;i++){
            System.out.println("\n\n片名:"+filmName[i]+"\n导演:"+director[i]+"\n主演:"+str[i]+"\n类型:"+type[i]+"\n剧情简介:"+imformation[i]+"\n时长（片长时间）"+time[i]);
        }
}


public void selectFilm(){
        System.out.println("请输入电影的名字：");
        this.tempString=sc.next();
    for(int i=0;i<5;i++){
        if(tempString.equals(filmName[i])){
            this.index=i;
        }
    }

    System.out.println("片名："+filmName[index]+"场次：");
    for (int i = 0; i < 5; i++) {
        if(Session[index][i]==0){

        }else {
            System.out.println("放映厅"+Session[index][i]+"\t开始时间:"+(i*3+8)+":00");
        }

    }

    }


    public void p_vote(){
        for (int i = 0; i <7 ; i++) {
            System.out.printf("第%d排:",i+1);
            for (int j = 0; j < 12; j++) {
                if(status[i][j]==1){
                    System.out.print("x");
                }else {
                    System.out.print("O");
                }
            }
            System.out.println();

        }


    }
 public void vote(){

     System.out.println("请输入你选择座位的位置：");
     System.out.println("第几排：");
     x=sc.nextInt();
     System.out.println("第几个：");
     y=sc.nextInt();
     this.status[x-1][y-1]=1;
 }

 public  void getp(){
     System.out.println("请输入电子票的ID编号");
        tempInt= sc.nextInt();

        if(tempInt==codep){
            if(codes){
                System.out.println("取票成功");
                this.codes=false;
            }
            else {
                System.out.println("您已经取票了");
            }

        }

 }
public  void payment(){
    System.out.println("是否支付1/0：");
    tempInt=sc.nextInt();
    if(tempInt==1){
        System.out.println("支付成功");
        LocalDate date=LocalDate.now();
        this.tempDate=date;
        this.codep=r.nextInt(89999)+10000;
        this.codes=true;
        System.out.println("电影票的电子ID编号："+codep);

    }


}

public  void lookp(){
    System.out.println("购票时间："+tempDate+"\tID编码："+codep+"\t片名："+filmName[index]+"\t场次："+Session[index][sessionIndex]+"\t开始时间："+sessionTime+":00"+"\t位置:"+"第"+x+"排"+"第"+y+"个位置");

}
}





