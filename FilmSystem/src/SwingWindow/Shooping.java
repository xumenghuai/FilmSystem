package SwingWindow;

import javax.swing.*;
import java.awt.*;

public class Shooping extends JFrame {


    private static final Integer WIDTH=1000;


    private static final Integer HEIGHT=800;
    public Shooping(){

        setTitle("购物界面");
        setSize(WIDTH,HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //调节窗口是否可以放缩。
        setResizable(false);
        setLocationRelativeTo(null);

        //连接数据库





        setVisible(true);


    }


}
