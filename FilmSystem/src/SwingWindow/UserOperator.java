package SwingWindow;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class UserOperator extends JFrame {
    private static final Integer WIDTH=1000;
    private static final Integer HEIGHT=800;

    public UserOperator(){
        setTitle("用户界面");
        setSize(WIDTH,HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //调节窗口是否可以放缩。
        setResizable(false);
        setLocationRelativeTo(null);
        try{
            setIconImage(ImageIO.read(new File("src\\Photo\\图层 10.png")));
        }catch (Exception e){
            e.printStackTrace();
        }

        //将窗口的布局管理器关掉，需要设置每个容器的大小
        setLayout(null);


       // ImageIcon imgBg= new ImageIcon("src\\Photo\\用户界面.jpg");
        //JLabel jblBg = new JLabel(imgBg);//可插入背景图片
        //jblBg.setBounds(0,0,WIDTH,HEIGHT);
        //jblBg.setLayout(null);
        //this.add(jblBg);

        //创建菜单条
        JMenuBar jMenuBar=new JMenuBar();
        //创建菜单
        JMenu helpMeue=new JMenu("帮助");
        JMenu setting=new JMenu("设置");

        //创建菜单项
        JMenuItem about=new JMenuItem("关于");
        JMenuItem shopping=new JMenuItem("购物情况");
        JMenuItem exitout=new JMenuItem("退出");
        JMenuItem changeAcount=new JMenuItem("切换账号");

        shopping.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                new Shooping();
            }
        });






        about.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                JDialog jDialog=new JDialog();
                jDialog.setSize(200,100);
                jDialog.setLocation(600,400);
                JLabel jLabel=new JLabel("这是一个购买电影票的系统");
                jDialog.add(jLabel);
                jDialog.setVisible(true);
            }
        });
        exitout.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                System.exit(0);
            }
        });

        changeAcount.addMouseListener(new MouseAdapter() {

            //鼠标放开
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                setVisible(false);
                LoginWindow loginWindow=new LoginWindow();
                try {
                    loginWindow.init();
                } catch (Exception n) {
                    throw new RuntimeException(n);
                }
            }
        });


        //组装菜单
        helpMeue.add(about);
        helpMeue.add(shopping);
        setting.add(exitout);
        setting.add(changeAcount);
        jMenuBar.add(helpMeue);
        jMenuBar.add(setting);
        setJMenuBar(jMenuBar);

        //创建面板
        JPanel jPanelSouth=new JPanel(new FlowLayout());//创建一个面板放入南部
        jPanelSouth.setBounds(0,700,1000,700);
        jPanelSouth.setBackground(Color.PINK);
        //创建按钮
        JButton my=new JButton("我的");


        JButton homepage=new JButton("主页");
        //组装按钮
        jPanelSouth.add(homepage);
        jPanelSouth.add(my);
        //将面板放入窗口南部
        add(jPanelSouth,BorderLayout.SOUTH);

        //创建主页面板
        JPanel homeJPanel=new JPanel();
        homeJPanel.setBackground(Color.blue);

        //创建我的面板
        JPanel myJPanel=new JPanel();
        myJPanel.setBackground(Color.red);
         //

        //创建滚动jScrollPane；
        JPanel jScrollPaneInPane =new JPanel();
         //将滚动面板放到主页面板

        //创建图片面板
        JPanel jPanelPhton1=new JPanel();
        jPanelPhton1.setSize(20,80);
        jPanelPhton1.setBackground(Color.GRAY);

        //创建一个标签展示图片
        JLabel filmPhoto1 =new JLabel(new ImageIcon("src\\Photo\\长津湖.jpg"));
        jPanelPhton1.add(filmPhoto1);

        //创建一个box来装电影信息
        Box filmBox1=Box.createVerticalBox();

        //用JLabel表示电影名字：
        JLabel filmName1=new JLabel("长津湖");
        filmName1.setFont(new Font("PingFang",Font.BOLD,17));
        filmName1.setForeground(Color.BLACK);
        //电影购票按钮：
        JButton buy1=new  JButton("购票");
        buy1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new FilmImformation(1);
            }
        });
        //将其全部放入盒子中
        filmBox1.add(jPanelPhton1);
        filmBox1.add(filmName1);
        filmBox1.add(buy1);



        //创建图片面板
        JPanel jPanelPhton=new JPanel();
        jPanelPhton.setSize(20,80);
        jPanelPhton.setBackground(Color.GRAY);

        //创建一个标签展示图片
        JLabel filmPhoto =new JLabel(new ImageIcon("src\\Photo\\大圣归来.jpg"));
        jPanelPhton.add(filmPhoto);

        //创建一个box来装电影信息
        Box filmBox=Box.createVerticalBox();

        //用JLabel表示电影名字：
        JLabel filmName=new JLabel("大圣归来");
        filmName.setFont(new Font("PingFang",Font.BOLD,17));
        filmName.setForeground(Color.BLACK);
        //电影购票按钮：
        JButton buy=new  JButton("购票");
        buy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new FilmImformation(4);
            }
        });
        //将其全部放入盒子中
        filmBox.add(jPanelPhton);
        filmBox.add(filmName);
        filmBox.add(buy);




        //创建图片面板
        JPanel jPanelPhton2=new JPanel();
        jPanelPhton2.setSize(20,80);
        jPanelPhton2.setBackground(Color.GRAY);

        //创建一个标签展示图片
        JLabel filmPhoto2 =new JLabel(new ImageIcon("src\\Photo\\消失的她.jpg"));
        jPanelPhton2.add(filmPhoto2);

        //创建一个box来装电影信息
        Box filmBox2=Box.createVerticalBox();

        //用JLabel表示电影名字：
        JLabel filmName2=new JLabel("消失的她");
        filmName2.setFont(new Font("PingFang",Font.BOLD,17));
        filmName2.setForeground(Color.BLACK);
        //电影购票按钮：
        JButton buy2=new  JButton("购票");
        buy2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new FilmImformation(2);
            }
        });
        //将其全部放入盒子中
        filmBox2.add(jPanelPhton2);
        filmBox2.add(filmName2);
        filmBox2.add(buy2);


        //创建图片面板
        JPanel jPanelPhton3=new JPanel();
        jPanelPhton3.setSize(20,80);
        jPanelPhton3.setBackground(Color.GRAY);

        //创建一个标签展示图片
        JLabel filmPhoto3 =new JLabel(new ImageIcon("src\\Photo\\变形金刚.jpg"));
        jPanelPhton3.add(filmPhoto3);

        //创建一个box来装电影信息
        Box filmBox3=Box.createVerticalBox();

        //用JLabel表示电影名字：
        JLabel filmName3=new JLabel("变形金刚");
        filmName3.setFont(new Font("PingFang",Font.BOLD,17));
        filmName3.setForeground(Color.BLACK);
        //电影购票按钮：
        JButton buy3=new  JButton("购票");
        buy3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new FilmImformation(5);
            }
        });
        //将其全部放入盒子中
        filmBox3.add(jPanelPhton3);
        filmBox3.add(filmName3);
        filmBox3.add(buy3);



        //创建图片面板
        JPanel jPanelPhton4=new JPanel();
        jPanelPhton4.setSize(20,80);
        jPanelPhton4.setBackground(Color.GRAY);

        //创建一个标签展示图片
        JLabel filmPhoto4 =new JLabel(new ImageIcon("src\\Photo\\封神.jpg"));
        jPanelPhton4.add(filmPhoto4);

        //创建一个box来装电影信息
        Box filmBox4=Box.createVerticalBox();

        //用JLabel表示电影名字：
        JLabel filmName4=new JLabel("封神");
        filmName4.setFont(new Font("PingFang",Font.BOLD,17));
        filmName4.setForeground(Color.BLACK);
        //电影购票按钮：
        JButton buy4=new  JButton("购票");
        buy4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new FilmImformation(3);
            }
        });
        //将其全部放入盒子中
        filmBox4.add(jPanelPhton4);
        filmBox4.add(filmName4);
        filmBox4.add(buy4);


        //将盒子放到滚动条里
        jScrollPaneInPane.add(filmBox);
        jScrollPaneInPane.add(filmBox1);
        jScrollPaneInPane.add(filmBox2);
        jScrollPaneInPane.add(filmBox3);
        jScrollPaneInPane.add(filmBox4);

        //homeJPanel.setPreferredSize(new Dimension(500,800));
        jScrollPaneInPane.setPreferredSize(new Dimension(1500,370));
        JScrollPane  jScrollPane=new JScrollPane(jScrollPaneInPane,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane.setBounds(0,0,1000,400);
        this.getContentPane().add(jScrollPane);
        //homeJPanel.add(jScrollPane);
       // add(homeJPanel);


        //建立分割面板
        JSplitPane jSplitPane=new JSplitPane();
        jSplitPane.setContinuousLayout(true);
        jSplitPane.setDividerLocation(150);
        jSplitPane.setDividerSize(5);
        jSplitPane.setSize(1000,600);
        add(jSplitPane);
        jSplitPane.setVisible(false);


        my.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                jScrollPane.setVisible(false);
                jSplitPane.setVisible(true);
            }
        });

        homepage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                jScrollPane.setVisible(true);
                jSplitPane.setVisible(false);
            }
        });

        setVisible(true);



        //将面板放到界面南部
        //setLayout(new BorderLayout(20,40));
        //将面板放在中间


        /*
        JPanel jPanelPhton=new JPanel();//创建图片面板
        jPanelPhton.setSize(20,80);
        jPanelPhton.setBackground(Color.GRAY);
        ImageIcon icon= new ImageIcon("src\\Photo\\长津湖.jpg");
        JLabel filmPhoto =new JLabel(icon);
        jPanelPhton.add(filmPhoto);
        //创建一个box
        Box filmBox=Box.createVerticalBox();
        //电影名字：用JLabel
        JLabel filmName=new JLabel("长津湖");
        filmName.setFont(new Font("PingFang",Font.BOLD,17));
        filmName.setForeground(Color.BLACK);
        //电影购票按钮：
        JButton buy=new  JButton("购票");
        //将其全部放入盒子中
       filmBox.add(jPanelPhton);
        filmBox.add(filmName);
        filmBox.add(buy);
        jScrollPane.add(filmBox);


        JPanel jPanelPhton1=new JPanel();//创建图片面板
        jPanelPhton1.setSize(20,80);
        jPanelPhton1.setBackground(Color.GRAY);
        ImageIcon icon1= new ImageIcon("src\\Photo\\消失的她.jpg");
        JLabel filmPhoto1 =new JLabel(icon1);
        jPanelPhton.add(filmPhoto1);
        //创建一个box
        Box filmBox1=Box.createVerticalBox();
        //电影名字：用JLabel
        JLabel filmName1=new JLabel("消失的她");
        filmName1.setFont(new Font("PingFang",Font.BOLD,17));
        filmName1.setForeground(Color.BLACK);
        //电影购票按钮：
        JButton buy1=new  JButton("购票");
        //将其全部放入盒子中
        filmBox1.add(jPanelPhton1);
        filmBox1.add(filmName1);
        filmBox1.add(buy1);
        jScrollPane.add(filmBox1);

        //FilmShowBox filmBox1=new FilmShowBox(new ImageIcon("src\\Photo\\长津湖.jpg"),"长津湖");
        jScrollPane.add(filmBox);

*/
    }
}
