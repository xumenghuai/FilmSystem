package SwingWindow;

import javax.swing.*;
import java.awt.*;

public class FilmShowBox extends JPanel{


 public    FilmShowBox (ImageIcon icon,String filmName){

     JPanel jPanelPhton=new JPanel();//创建图片面板
     jPanelPhton.setSize(20,80);
     jPanelPhton.setBackground(Color.GRAY);
     JLabel filmPhoto =new JLabel(icon);
     jPanelPhton.add(filmPhoto);
     //创建一个box
     Box filmBox=Box.createVerticalBox();
     //电影名字：用JLabel
     JLabel filmNamelable=new JLabel(filmName);
     filmNamelable.setFont(new Font("PingFang",Font.BOLD,17));
     filmNamelable.setForeground(Color.BLACK);
     //电影购票按钮：
     JButton buy=new  JButton("购票");
     //将其全部放入盒子中
     filmBox.add(jPanelPhton);
     filmBox.add(filmNamelable);
     filmBox.add(buy);
     add(filmBox);
    }
}
