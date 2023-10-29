
import SwingWindow.BackGroundPanel;
import SwingWindow.LoginWindow;
import  FilmSys.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import java.io.IOException;
import java.sql.*;






 class TestClass {





     //客户端入口
    public static void main(String[] args){

        LoginWindow loginWindow=new LoginWindow();
        try {
            loginWindow.init();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
String user_name= loginWindow.username;
System.out.println(user_name);
//声明connection连接对象
Connection connection=null;

String driver="com.mysql.cj.jdbc.Driver";
try{
    Class.forName(driver);
}catch(ClassNotFoundException e){
    e.printStackTrace();
}
//提供连接数据库的URL
        String url="jdbc:mysql://localhost:3306/film";
        String username="root";
        String password="Xx122166@";
try{
    connection=DriverManager.getConnection(url,username,password);
}
catch (SQLException e){
    e.printStackTrace();
}
//创建statement
Statement statement=null;
PreparedStatement preparedStatement=null;
try{
    statement=connection.createStatement();
}catch (SQLException e){
    e.printStackTrace();
}

//创建一个preparedStatement对象来将参数sql语句发送到数据库。
String sql="select *from user_List";
try{
    preparedStatement=connection.prepareStatement(sql);
} catch(SQLException e){
   e.printStackTrace();
}

//执行SQL语句
ResultSet resultSet=null;
try{
    resultSet=statement.executeQuery("select *from user_List  ");
}catch (SQLException e){
    e.printStackTrace();
}
try{
    resultSet.next();
}catch (SQLException e){
    e.printStackTrace();
}

String num=null;
try{
     num= resultSet.getString("user_name");
}catch(SQLException e){
    e.printStackTrace();
}
System.out.println(num);

ResultSet resultSet1=null;
try{
    resultSet1=preparedStatement.executeQuery("select *from user_List  ");
}catch (SQLException e){
            e.printStackTrace();
        }

        int id=0;
try{
    while(resultSet1.next()){
        id= resultSet1.getInt("id");
        System.out.println(id);

    }
}catch (SQLException e){
    e.printStackTrace();
}

//关闭数据库
        try{
            resultSet1.close();
            resultSet.close();
            preparedStatement.close();
            statement.close();
            connection.close();
            System.out.println("关闭成功");
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("关闭失败");
        }

/*


        //测试账号和密码；
        User user=new User();
        user.getAccount("111111");
        user.getPassword("123456");
        System.out.println(user.findIt());
        //测试a的账号和密码
        AdminUser a=new AdminUser();
        a.getAccount("a111111");
        a.getPassword("a123456");
        System.out.println(a.findIt());



        //创建管理员，用户，经理和前台
       Administrator administrator =new Administrator();
       Manager manager=new Manager();
       Receptionist receptionist=new Receptionist();
       User user=new User();
       //FilmOperator filmOperator=new FilmOperator();

        //用户测试
        //
        //注册  用户名长度不少于5个字符；
        // 密码长度大于8个字符，必须是大小写字母、数字和标点符号的组合。

       //user.registerNewUser();

        //登入 密码连续输入错误5次就锁定账户，可以正常退出登录界面

        //user.login();

        //密码管理
        //修改密码 密码长度大于8个字符，密码要求同上（大小写、数字..）

       // user.changPassword();

        //忘记密码 模拟重置密码，让用户输入用户名和注册所使用的邮箱地址，系统会将一个随机生成的密码发到指定的邮箱

        //user.forgetPassword();

        //购票功能
        //查看所有电影放映信息:执行该功能，显示所有近期上映的电影的信息：片名、导演、主演、类型、剧情简介和时长（片长时间）。

       filmOperator.look();

        //查看指定电影放映信息：执行该功能，显示指定电影的信息：片名、场次（放映厅和时段）
        //场次：放映厅有1、2、3、4、5  时间段有8点；11点；14点；17点；20点。

       // filmOperator.selectFilm();

        //选座购票 选定场次以后，显示座位信息（“O”表示空闲，“X”表示占用），用键盘输入座位号后

      // filmOperator.selectSession();
      // filmOperator.p_vote();
      // filmOperator.vote();
       //filmOperator.p_vote();

        //付款 模拟支付操作，不调用实际的支付宝、微信、银行卡。只是表明进行了相关的操作，操作成功以后，生成电影票的电子ID编号，凭此编号可以取票。

      // filmOperator.payment();

        //取票  输入电影票的电子ID编号，取票。如果票已被取出，提示用户票已被取，不能重复取票。

      //  filmOperator.getp();
      //  filmOperator.getp();

        //查看购票历史 时间、购买的电影票信息。

      // filmOperator.lookp();



        //管理员测试
        //登入 管理员账户可以预先设定一个admin，密码为ynuadmin。可以正常退出登录界面

        //administrator.login();

        //密码管理
        //修改自身密码 修改管理员的密码。

        //administrator.changPassword();

        //重置指定用户的密码 管理员可以重置普通用户的密码，但不能查看普通用户的密码。

        //用户管理
        //列出所有用户信息 用户信息包括：用户ID、用户名、用户级别（金牌用户、银牌用户、铜牌用户）、用户注册时间、用户累计消费总金额、用户累计消费次数、用户手机号、用户邮箱；

        //删除用户信息  删除用户信息之前要给出警告提示，请用户确认是否继续删除操作。

        //查询用户信息 可以根据用户ID或者用户的用户名进行查询，也可以一次查询所有用户的信息。

        //退出登入

        //经理测试
        //影片管理
        //列出所有正在上映影片的信息：片名、导演、主演、类型、剧情简介、时长(片长时间)。

        //添加即将上映的影片的信息： 片名、导演、主演、类型、剧情简介、时长(片长时间)。

        //修改已经/即将上映影片的信息：可以对上述的影片的信息进行修改，比如价格。

        //删除影片的信息 可以删除影片，删除之前必须给出警告提示：删除后无法恢复，请经理确认是否继续删除操作。

        //排片管理
        //增加场次：将上映的影片安排在指定的放映厅和指定的时间段、价格，允许提前安排一周的电影场次。注意：不同场次的价格不同。不同电影的定价不同。

        //修改场次：修改场次信息，例如：原来安排放映影片A的放映厅和时段、价格，安排放映电影B，或者空场（不进行安排）。

        //删除场次：删除指定的片场信息，例如：原来放映影片A的放映厅，时段22:00的场次，后续不再安排上映，删除该场次。

        //列出所有场次信息：列出所有场次的信息，默认是最近一周。

        //登录管理
        //登录和退出

        //前台测试
        //售片管理
        //列出所有正在上映影片的信息：片名、导演、主演、类型、剧情简介、时长(片长时间)。
        //filmOperator.look();
        //列出所有影片的场次信息：列出所有场次的信息，默认是最近一周。

        //列出指定电影和场次信息：输入片名和场次，列出该场次座位信息，包括总座位数、空闲座位数和座位信息（示例如下，可以自行美化）：

        //售票功能 输入片名和场次、用户名/手机号、支付金额，输出电影票信息（包括电影票的电子ID编号）。

*/



    }

}
//额外要求
//对于用户操作有一定的容错能力，比如输入电影票数（整数）的时候，不小心输入了非整数，程序不会退出（try catch）。
//符合基本的编码规范、类名、方法名、变量名不用简单的字母、无意义的单词、字母组合。
//因为没有学习过GUI开发方面的内容，可以只用终端Console的方式来实现整个程序。学有余力的，可以使用Java的GUI来实现图形化。
//尽可能把提到的项目要求都实现了，允许扩展更多的功能。例如：经理和前台管理和销售零食的功能。

//作业要求
//项目代码中尽可能用到抽象类、继承、接口、多态、集合框架类、异常处理等知识。
//提供完整的项目工程文件夹，可以上传github附加说明或者本地网页录屏演示最佳。
//参考本课程的软件开发和维护规范，在实验报告中画出UML用例图、顺序图和类图。
//必须使用模版撰写实验报告，除开发流程外附加心得体会，正文6页含封面不少于7页。

//考核要求
//符合面向对象程序设计方法，有合理的类的设计，程序结构清晰；
//符合基本的编码规范，类名、方法名、变量名不用简单的字母、无意义的单词、字母组合，代码整洁有注释
//最终软件实现的功能基本完备，提供了项目源代码打包上传和软件运行视频。
//除额外要求为最终实现的功能超额完成，并有亮点

