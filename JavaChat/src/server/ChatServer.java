package server;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;

/*
 * 聊天服务端的主框架类
 */
public class ChatServer extends JFrame implements ActionListener{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public static int port = 8888;//服务端的侦听端口

    ServerSocket serverSocket;//服务端Socket
    JComboBox combobox;//选择发送消息的接受者
    JTextArea messageShow;//服务端的信息显示
    JScrollPane messageScrollPane;//信息显示的滚动条
    JTextField showStatus;//显示用户连接状态
    JLabel sendToLabel,messageLabel;
    JTextField sysMessage;//服务端消息的发送
    JButton sysMessageButton;//服务端消息的发送按钮
    UserLinkList userLinkList;//用户链表

    //建立菜单栏
    JMenuBar jMenuBar = new JMenuBar();
    //建立菜单组
    JMenu serviceMenu = new JMenu ("服务(V)");
    //建立菜单项
    JMenuItem portItem = new JMenuItem ("端口设置(P)");
    JMenuItem startItem = new JMenuItem ("启动服务(S)");
    JMenuItem stopItem=new JMenuItem ("停止服务(T)");
    JMenuItem exitItem=new JMenuItem ("退出(X)");

    JMenu helpMenu=new JMenu ("帮助(H)");
    JMenuItem helpItem=new JMenuItem ("帮助(H)");

    //建立工具栏
    JToolBar toolBar = new JToolBar();

    //建立工具栏中的按钮组件
    JButton portSet;//启动服务端侦听
    JButton startServer;//启动服务端侦听
    JButton stopServer;//关闭服务端侦听
    JButton exitButton;//退出按钮

    //框架的大小
    Dimension faceSize = new Dimension(400, 600);

    ServerListen listenThread;

    JPanel downPanel ;
    GridBagLayout girdBag;
    GridBagConstraints girdBagCon;


    /**
     * 服务端构造函数
     */
    public ChatServer(){
        init();//初始化程序

        //添加框架的关闭事件处理
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        //设置框架的大小
        this.setSize(faceSize);
        //设置程序图标
        this.setWindowIcon();

        //设置运行时窗口的位置
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation( (int) (screenSize.width - faceSize.getWidth()) / 2,
                (int) (screenSize.height - faceSize.getHeight()) / 2);
        this.setResizable(false);

        this.setTitle("聊天室服务端"); //设置标题

        setVisible(true);

        //为服务菜单栏设置热键'V'
        serviceMenu.setMnemonic('V');

        //为端口设置快捷键为ctrl+p
        portItem.setMnemonic ('P');
        portItem.setAccelerator (KeyStroke.getKeyStroke (KeyEvent.VK_P,InputEvent.CTRL_MASK));

        //为启动服务快捷键为ctrl+s
        startItem.setMnemonic ('S');
        startItem.setAccelerator (KeyStroke.getKeyStroke (KeyEvent.VK_S,InputEvent.CTRL_MASK));

        //为端口设置快捷键为ctrl+T
        stopItem.setMnemonic ('T');
        stopItem.setAccelerator (KeyStroke.getKeyStroke (KeyEvent.VK_T,InputEvent.CTRL_MASK));

        //为退出设置快捷键为ctrl+x
        exitItem.setMnemonic ('X');
        exitItem.setAccelerator (KeyStroke.getKeyStroke (KeyEvent.VK_X,InputEvent.CTRL_MASK));

        //为帮助菜单栏设置热键'H'
        helpMenu.setMnemonic('H');

        //为帮助设置快捷键为ctrl+p
        helpItem.setMnemonic ('H');
        helpItem.setAccelerator (KeyStroke.getKeyStroke (KeyEvent.VK_H,InputEvent.CTRL_MASK));

    }

    /**
     * 程序初始化函数
     */
    public void init(){

        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //添加菜单栏
        serviceMenu.add (portItem);
        serviceMenu.add (startItem);
        serviceMenu.add (stopItem);
        serviceMenu.add (exitItem);
        jMenuBar.add (serviceMenu);
        helpMenu.add (helpItem);
        jMenuBar.add (helpMenu);
        setJMenuBar (jMenuBar);

        //初始化按钮
        portSet = new JButton("端口设置");
        startServer = new JButton("启动服务");
        stopServer = new JButton("停止服务" );
        exitButton = new JButton("退出" );
        //将按钮添加到工具栏
        toolBar.add(portSet);
        toolBar.addSeparator();//添加分隔栏
        toolBar.add(startServer);
        toolBar.add(stopServer);
        toolBar.addSeparator();//添加分隔栏
        toolBar.add(exitButton);
        contentPane.add(toolBar,BorderLayout.NORTH);

        //初始时，令停止服务按钮不可用
        stopServer.setEnabled(false);
        stopItem .setEnabled(false);

        //为菜单栏添加事件监听
        portItem.addActionListener(this);
        startItem.addActionListener(this);
        stopItem.addActionListener(this);
        exitItem.addActionListener(this);
        helpItem.addActionListener(this);

        //添加按钮的事件侦听
        portSet.addActionListener(this);
        startServer.addActionListener(this);
        stopServer.addActionListener(this);
        exitButton.addActionListener(this);

        combobox = new JComboBox();
        combobox.insertItemAt("所有人",0);
        combobox.setSelectedIndex(0);

        messageShow = new JTextArea();
        messageShow.setEditable(false);
        //添加滚动条
        messageScrollPane = new JScrollPane(messageShow,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        messageScrollPane.setPreferredSize(new Dimension(400,400));
        messageScrollPane.revalidate();

        showStatus = new JTextField(35);
        showStatus.setEditable(false);

        sysMessage = new JTextField(24);
        sysMessage.setEnabled(false);
        sysMessageButton = new JButton();
        sysMessageButton.setText("发送");

        //添加系统消息的事件侦听
        sysMessage.addActionListener(this);
        sysMessageButton.addActionListener(this);

        sendToLabel = new JLabel("发送至:");
        messageLabel = new JLabel("发送消息:");
        downPanel = new JPanel();
        girdBag = new GridBagLayout();
        downPanel.setLayout(girdBag);

        girdBagCon = new GridBagConstraints();
        girdBagCon.gridx = 0;
        girdBagCon.gridy = 0;
        girdBagCon.gridwidth = 3;
        girdBagCon.gridheight = 2;
        girdBagCon.ipadx = 5;
        girdBagCon.ipady = 5;
        JLabel none = new JLabel("    ");
        girdBag.setConstraints(none,girdBagCon);
        downPanel.add(none);

        girdBagCon = new GridBagConstraints();
        girdBagCon.gridx = 0;
        girdBagCon.gridy = 2;
        girdBagCon.insets = new Insets(1,0,0,0);
        girdBagCon.ipadx = 5;
        girdBagCon.ipady = 5;
        girdBag.setConstraints(sendToLabel,girdBagCon);
        downPanel.add(sendToLabel);

        girdBagCon = new GridBagConstraints();
        girdBagCon.gridx =1;
        girdBagCon.gridy = 2;
        girdBagCon.anchor = GridBagConstraints.LINE_START;
        girdBag.setConstraints(combobox,girdBagCon);
        downPanel.add(combobox);

        girdBagCon = new GridBagConstraints();
        girdBagCon.gridx = 0;
        girdBagCon.gridy = 3;
        girdBag.setConstraints(messageLabel,girdBagCon);
        downPanel.add(messageLabel);

        girdBagCon = new GridBagConstraints();
        girdBagCon.gridx = 1;
        girdBagCon.gridy = 3;
        girdBag.setConstraints(sysMessage,girdBagCon);
        downPanel.add(sysMessage);

        girdBagCon = new GridBagConstraints();
        girdBagCon.gridx = 2;
        girdBagCon.gridy = 3;
        girdBag.setConstraints(sysMessageButton,girdBagCon);
        downPanel.add(sysMessageButton);

        girdBagCon = new GridBagConstraints();
        girdBagCon.gridx = 0;
        girdBagCon.gridy = 4;
        girdBagCon.gridwidth = 3;
        girdBag.setConstraints(showStatus,girdBagCon);
        downPanel.add(showStatus);

        contentPane.add(messageScrollPane,BorderLayout.CENTER);
        contentPane.add(downPanel,BorderLayout.SOUTH);

        //关闭程序时的操作
        this.addWindowListener(
                new WindowAdapter(){
                    public void windowClosing(WindowEvent e){
                        stopService();
                        System.exit(0);
                    }
                }
        );
    }

    /**
     * 事件处理
     */
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj == startServer || obj == startItem) { //启动服务端
            startService();
        }
        else if (obj == stopServer || obj == stopItem) { //停止服务端
            int j=JOptionPane.showConfirmDialog(
                    this,"真的停止服务吗?","停止服务",
                    JOptionPane.YES_OPTION,JOptionPane.QUESTION_MESSAGE);

            if (j == JOptionPane.YES_OPTION){
                stopService();
            }
        }
        else if (obj == portSet || obj == portItem) { //端口设置
            //调出端口设置的对话框
            PortConf portConf = new PortConf(this);
            portConf.setVisible(true);
        }
        else if (obj == exitButton || obj == exitItem) { //退出程序
            int j=JOptionPane.showConfirmDialog(
                    this,"真的要退出吗?","退出",
                    JOptionPane.YES_OPTION,JOptionPane.QUESTION_MESSAGE);

            if (j == JOptionPane.YES_OPTION){
                stopService();
                System.exit(0);
            }
        }
        else if (obj == helpItem) { //菜单栏中的帮助
            //调出帮助对话框
            Help helpDialog = new Help(this);
            helpDialog.setVisible(true);
        }
        else if (obj == sysMessage || obj == sysMessageButton) { //发送系统消息
            sendSystemMessage();
        }
    }

    /**
     * 启动服务端
     */
    public void startService(){
        try{
            serverSocket = new ServerSocket(port,10);
            messageShow.append("服务端已经启动，在"+port+"端口侦听...\n");

            startServer.setEnabled(false);
            startItem.setEnabled(false);
            portSet.setEnabled(false);
            portItem.setEnabled(false);

            stopServer .setEnabled(true);
            stopItem .setEnabled(true);
            sysMessage.setEnabled(true);
        }
        catch (Exception e){
            //System.out.println(e);
        }
        userLinkList = new UserLinkList();

        listenThread = new ServerListen(serverSocket,combobox,
                messageShow,showStatus,userLinkList);
        listenThread.start();
    }

    /**
     * 关闭服务端
     */
    public void stopService(){
        try{
            //向所有人发送服务器关闭的消息
            sendStopToAll();
            listenThread.isStop = true;
            serverSocket.close();

            int count = userLinkList.getCount();

            int i =0;
            while( i < count){
                Node node = userLinkList.findUser(i);

                node.input .close();
                node.output.close();
                node.socket.close();

                i ++;
            }

            stopServer .setEnabled(false);
            stopItem .setEnabled(false);
            startServer.setEnabled(true);
            startItem.setEnabled(true);
            portSet.setEnabled(true);
            portItem.setEnabled(true);
            sysMessage.setEnabled(false);

            messageShow.append("服务端已经关闭\n");

            combobox.removeAllItems();
            combobox.addItem("所有人");
        }
        catch(Exception e){
            //System.out.println(e);
        }
    }

    /**
     * 向所有人发送服务器关闭的消息
     */
    public void sendStopToAll(){
        int count = userLinkList.getCount();

        int i = 0;
        while(i < count){
            Node node = userLinkList.findUser(i);
            if(node == null) {
                i ++;
                continue;
            }

            try{
                node.output.writeObject("服务关闭");
                node.output.flush();
            }
            catch (Exception e){
                //System.out.println("$$$"+e);
            }

            i++;
        }
    }

    /**
     * 向所有人发送消息
     */
    public void sendMsgToAll(String msg){
        int count = userLinkList.getCount();//用户总数

        int i = 0;
        while(i < count){
            Node node = userLinkList.findUser(i);
            if(node == null) {
                i ++;
                continue;
            }

            try{
                node.output.writeObject("系统信息");
                node.output.flush();
                node.output.writeObject(msg);
                node.output.flush();
            }
            catch (Exception e){
                //System.out.println("@@@"+e);
            }

            i++;
        }

        sysMessage.setText("");
    }

    /**
     * 向客户端用户发送消息
     */
    public void sendSystemMessage(){
        String toSomebody = combobox.getSelectedItem().toString();
        String message = sysMessage.getText() + "\n";

        messageShow.append(message);

        //向所有人发送消息
        if(toSomebody.equalsIgnoreCase("所有人")){
            sendMsgToAll(message);
        }
        else{
            //向某个用户发送消息
            Node node = userLinkList.findUser(toSomebody);

            try{
                node.output.writeObject("系统信息");
                node.output.flush();
                node.output.writeObject(message);
                node.output.flush();
            }
            catch(Exception e){
                //System.out.println("!!!"+e);
            }
            sysMessage.setText("");//将发送消息栏的消息清空
        }
    }
    public void setWindowIcon()
    {
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/img/servericon.png"));
        this.setIconImage(imageIcon.getImage());
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        new ChatServer();
    }
}

