package SwingWindow;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;
import java.awt.Font;
import SqlOperation.JdbcUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.*;
public class RegisterWindow extends JFrame {
    private static final Integer WIDTH=600;
    private static final Integer HEIGHT=400;

    public RegisterWindow(){
        setTitle("注册界面");
        setSize(WIDTH,HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        try{
            setIconImage(ImageIO.read(new File("src\\Photo\\图层 10.png")));
        }catch (Exception e){
            e.printStackTrace();
        }

        ImageIcon imgBg= new ImageIcon("src\\Photo\\注册背景.jpg");
        JLabel jlable = new JLabel(imgBg);//可插入背景图片
        jlable.setBounds(0,0,WIDTH,HEIGHT);
        jlable.setLayout(null);
        this.add(jlable);

        //手机号
        JLabel telephone_number = new JLabel("手机号：");
        telephone_number.setBounds(150, 120, 110, 30);
        telephone_number.setFont(new Font("PingFang SC", Font.BOLD, 17));
        telephone_number.setForeground(Color.BLACK);
        jlable.add(telephone_number);
        //手机号输入框
        JTextField userInputTN = new JTextField();
        userInputTN.setBounds(260, 120, 180, 30);
        jlable.add(userInputTN);

        //密码
        JLabel new_password =new JLabel("密码  ：");
        new_password.setBounds(150, 180, 110, 30);
        new_password.setFont(new Font("PingFang SC", Font.BOLD, 17));
        new_password.setForeground(Color.BLACK);
        jlable.add(new_password);

        //密码输入框
        JPasswordField passwordInput = new JPasswordField();
        passwordInput.setBounds(260, 180, 180, 30);
        jlable.add(passwordInput);

        //注册按钮
        JButton registerButton =new JButton("注册");
        registerButton.setBounds(170, 250, 110, 40);
        registerButton.setBackground(Color.PINK);
        registerButton.setForeground(Color.WHITE);
        registerButton.setFont(new Font("PingFang SC", Font.BOLD, 17));
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String getUserInputTN = userInputTN.getText();
                String getPasswordInput = passwordInput.getText();

                Connection conn=null;
                PreparedStatement pstmt=null;
                ResultSet rs=null;
                //创建弹窗
                JDialog dialog = new JDialog();
                dialog.setLocationRelativeTo(null);
                dialog.setSize(200,200);

                if(getUserInputTN.matches("[1][0-9]{10}")&&getPasswordInput.matches("\\w{6,16}")){
                    try {
                        //判断是否有重复的账号
                        conn= JdbcUtils.getConnection();
                        String sql="select * from user_list where telephone_number =? and password =?";
                        pstmt=conn.prepareStatement(sql);
                        pstmt.setString(1, getUserInputTN);
                        pstmt.setString(2, getPasswordInput);
                        rs= pstmt.executeQuery();

                        if(rs.next()){
                            dialog.add(new JLabel("账号已经有了！"));
                        }else {


                            //获得注册时间
                            PreparedStatement preparedStatement;
                            Date date = new Date();
                            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                            String time = simpleDateFormat.format(date);
                            String sql1 = "insert into user_list(telephone_number,password,register_time) values (?,?,?)";
                            preparedStatement = conn.prepareStatement(sql1);
                            preparedStatement.setString(1, getUserInputTN);
                            preparedStatement.setString(2, getPasswordInput);
                            preparedStatement.setString(3, time);


                            int i = preparedStatement.executeUpdate();
                            if (i > 0) {
                                dialog.add(new JLabel("注册成功！"));
                            }
                        }




                        dialog.setVisible(true);
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }finally {
                        JdbcUtils.release(conn,pstmt,rs);
                    }

                }else{
                    dialog.add(new JLabel("输入错误！"));
                    dialog.setVisible(true);
                }

            }
        });
        JButton backButton =new JButton("返回");
        backButton.setFont(new Font("PingFang SC", Font.BOLD, 17));
        backButton.setBounds(300,250,110,40);
        backButton.setBackground(Color.PINK);
        backButton.setForeground(Color.WHITE);

        //点击返回按钮
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                LoginWindow loginWindow=new LoginWindow();
                try {
                    loginWindow.init();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                setVisible(false);
            }
        });
        //将注册按钮和返回按钮放入jlable；
        jlable.add(registerButton);
        jlable.add(backButton);
        setVisible(true);

    }



}
