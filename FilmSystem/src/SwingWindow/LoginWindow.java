package SwingWindow;

import SqlOperation.JdbcUtils;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.*;

public class LoginWindow {
    JFrame jFrame = new JFrame("电影院管理系统");

    final int WIDTH = 500;
    final int HEIGHT = 300;

    public String username;
    public String password;
    //主装视图
    public void init() throws Exception {
        //设置窗口的相关属性
        jFrame.setBounds((Toolkit.getDefaultToolkit().getScreenSize().width - WIDTH) / 2, (Toolkit.getDefaultToolkit().getScreenSize().height - HEIGHT) / 2, WIDTH, HEIGHT);
        jFrame.setResizable(false);//让窗口不能移动；
        jFrame.setIconImage(ImageIO.read(new File("src\\Photo\\图层 10.png")));

        //设置窗口的内容
        BackGroundPanel backGroundPanel = new BackGroundPanel(ImageIO.read(new File("src\\Photo\\电影院图片.jpg")));


        Box ubox = Box.createHorizontalBox();
        JLabel uLabel = new JLabel("用户名：");
        uLabel.setFont(new Font("PingFang",Font.BOLD,17));
        uLabel.setForeground(Color.BLACK);
        JTextField uTextField = new JTextField(15);

        ubox.add(uLabel);
        ubox.add(Box.createHorizontalStrut(20));
        ubox.add(uTextField);

        Box pbox = Box.createHorizontalBox();
        JLabel pLabel = new JLabel("密    码：");
        pLabel.setFont(new Font("PingFang",Font.BOLD,17));
        pLabel.setForeground(Color.BLACK);
        JPasswordField pTextField = new JPasswordField(15);

        pbox.add(pLabel);
        pbox.add(Box.createHorizontalStrut(20));
        pbox.add(pTextField);

        Box btnbox = Box.createHorizontalBox();
        JButton loginBtn = new JButton("登入 ");
        loginBtn.setFont(new Font("PingFang",Font.BOLD,17));
        loginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //获取用户输入的数据
                String userName = uTextField.getText().trim();
                String passWord = pTextField.getText().trim();

               // String url="jdbc:mysql://localhost:3306/film";
                //String username="root";
                //String password="Xx122166@";
                Connection con=null;
                PreparedStatement pstm=null;
                ResultSet rs=null;


                JDialog dialog=new JDialog();
                dialog.setLocationRelativeTo(null);
                dialog.setSize(200,80);
                dialog.setLocation(600,400);

                   // dialog.setIconImage(new ImageIcon("FilmSystem\\src\\Photo\\图层 10.png").getImage());
                try {
                    dialog.setIconImage(ImageIO.read(new File("src\\Photo\\图层 10.png")));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }


                try{
                    String sql="select *from user_List";
                    con= JdbcUtils.getConnection();
                    pstm=con.prepareStatement(sql);
                   // Connection connection=DriverManager.getConnection(url,username,password);
                    //Statement statement=connection.createStatement();
                    //ResultSet resultSet=statement.executeQuery(sql);
                    rs=pstm.executeQuery();
                    boolean b=true;
                    while(rs.next()){
                        String name=rs.getString("telephone_number");
                        System.out.println(name);
                        String pass=rs.getString("password");
                        System.out.println(pass);
                        if(userName.equals(name)&&passWord.equals(pass)){
                            new UserOperator();
                            b=false;
                            break;
                            //dialog.setVisible(false);
                        }

                    }
                    if(b){
                        dialog.add(new JLabel("登入失败！"));
                        dialog.setVisible(true);

                    }


                }catch (SQLException e){
                    e.printStackTrace();
                }finally {
                    JdbcUtils.release(con,pstm,rs);
                }



            }
        });


        JButton registBtn = new JButton("注册");
        registBtn .setFont(new Font("PingFang",Font.BOLD,17));
        btnbox.add(loginBtn);
        btnbox.add(Box.createHorizontalStrut(100));
        btnbox.add(registBtn);

        Box andBox = Box.createVerticalBox();
        andBox.add(Box.createVerticalStrut(20));
        andBox.add(ubox);
        andBox.add(Box.createVerticalStrut(40));
        andBox.add(pbox);
        andBox.add(Box.createVerticalStrut(50));
        andBox.add(btnbox);
//点击注册按钮的后的状态
registBtn.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        new RegisterWindow();
        jFrame.setVisible(false);
    }
});
        backGroundPanel.add(andBox);
        jFrame.add(backGroundPanel);
        jFrame.setVisible(true);


    }
}