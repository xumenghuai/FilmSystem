package SwingWindow;

import SqlOperation.JdbcUtils;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.sql.*;

public class FilmImformation extends JFrame {
    //设置窗口的大小
    private static final Integer WIDTH=1000;
    private static final Integer HEIGHT=800;
    private JTextArea textArea;
    public FilmImformation(int i){
        //设置窗口的名称，大小，窗口关闭
        setTitle("电影");
        setSize(WIDTH,HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //调节窗口是否可以放缩。
        setResizable(false);
        setLocationRelativeTo(null);
        //设置窗口图标
        try{
            setIconImage(ImageIO.read(new File("src\\Photo\\图层 10.png")));
        }catch (Exception e){
            e.printStackTrace();
        }
        //将窗口的布局管理器关掉，需要设置每个容器的大小
        setLayout(null);

        //创建图片面板
        JPanel jPanelPhton=new JPanel();
        jPanelPhton.setBounds(40,40,200,300);

        jPanelPhton.setBackground(Color.GRAY);

        //创建一个标签展示图片
        if(i==1){
            JLabel filmPhoto =new JLabel(new ImageIcon("src\\Photo\\长津湖.jpg"));
            jPanelPhton.add(filmPhoto);
        }else if(i==2){
            JLabel filmPhoto =new JLabel(new ImageIcon("src\\Photo\\消失的她.jpg"));
            jPanelPhton.add(filmPhoto);

        }else if(i==3){
            JLabel filmPhoto =new JLabel(new ImageIcon("src\\Photo\\封神.jpg"));
            jPanelPhton.add(filmPhoto);

        }else if(i==4){
            JLabel filmPhoto =new JLabel(new ImageIcon("src\\Photo\\大圣归来.jpg"));
            jPanelPhton.add(filmPhoto);

        }else if(i==5){
            JLabel filmPhoto =new JLabel(new ImageIcon("src\\Photo\\变形金刚.jpg"));
            jPanelPhton.add(filmPhoto);

        }



        String name =null;
        String director =null;
        String star =null;
        String imformation =null;
        Time time=null;
        //连接数据库
        try{
            Connection conn=null;
            PreparedStatement pstmt=null;
            ResultSet rs=null;

            conn= JdbcUtils.getConnection();

            String sql="select * from film_name where ID =? ";
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1, i);
            rs= pstmt.executeQuery();
            while(rs.next()){
                name=rs.getString("FilmName");
                director=rs.getString("director");
                star=rs.getString("star");
                imformation=rs.getString("imformation");
                time=rs.getTime("time");
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

//左边放电影的图片，右边放电影院的信息，下面放两个按钮，一个是购买电影票，进入购票界面


        //电影名
        JLabel filmName=new JLabel("电影名:"+name);
        //设置字的类型
        filmName.setFont(new Font("PingFang",Font.BOLD,17));
        filmName.setForeground(Color.BLACK);

        //导演
        JLabel directorName=new JLabel("导演:"+director);
        directorName.setFont(new Font("PingFang",Font.BOLD,17));
        directorName.setForeground(Color.BLACK);

        //演员
        JLabel starName=new JLabel("演员:"+star);
        starName.setFont(new Font("PingFang",Font.BOLD,17));
        starName.setForeground(Color.BLACK);
        //简介

        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setFont(new Font("PingFang",Font.BOLD,17));
        textArea.setForeground(Color.BLACK);
        textArea.setBackground(Color.PINK);
        formatString(imformation, 30);

        JLabel imformationAbout=new JLabel("简介:");
        imformationAbout.setFont(new Font("PingFang",Font.BOLD,17));
        imformationAbout.setForeground(Color.BLACK);
        //时长
        JLabel timeAbout=new JLabel("时长:"+time);
        timeAbout.setFont(new Font("PingFang",Font.BOLD,17));
        timeAbout.setForeground(Color.BLACK);


        //创建一个面板
        JPanel boxInjPanel=new JPanel();
        boxInjPanel.setBounds(300,40,600,300);
        boxInjPanel.setBackground(Color.PINK);

        //创建一个box来装电影信息
        Box filmBox=Box.createVerticalBox();
        filmBox.add(filmName);
        filmBox.add(Box.createVerticalStrut(10));
        filmBox.add(directorName);
        filmBox.add(Box.createVerticalStrut(10));
        filmBox.add(starName);
        filmBox.add(Box.createVerticalStrut(10));
        filmBox.add(imformationAbout);
        filmBox.add(textArea);
        filmBox.add(Box.createVerticalStrut(10));
        filmBox.add(timeAbout);
       boxInjPanel.add(filmBox);


       Box buttonBox=Box.createHorizontalBox();

       JButton buyButton=new JButton("购买");
       JButton back=new JButton("返回");


        buttonBox.add(buyButton);
        buttonBox.add(Box.createHorizontalStrut(100));
        buttonBox.add(back);

        buttonBox.setBounds(300,500,300,20);


       add(buttonBox);
      add(jPanelPhton);
      add(boxInjPanel);


        //将窗口可见
        setVisible(true);
    }


    private void formatString(String longString, int lineLength) {
        StringBuilder formattedString = new StringBuilder();

        for (int i = 0; i < longString.length(); i += lineLength) {
            int endIndex = Math.min(i + lineLength, longString.length());
            String line = longString.substring(i, endIndex);
            formattedString.append(line).append("\n");
        }

        textArea.setText(formattedString.toString());
    }



}

/*
        //创建一个box来装电影信息
        Box filmBox=Box.createVerticalBox();
        filmBox.add(filmName);
        filmBox.add(Box.createVerticalStrut(10));
        filmBox.add(directorName);
        filmBox.add(Box.createVerticalStrut(10));
        filmBox.add(starName);
        filmBox.add(Box.createVerticalStrut(10));
        filmBox.add(imformationAbout);
        filmBox.add(Box.createVerticalStrut(10));
        filmBox.add(timeAbout);
*/
