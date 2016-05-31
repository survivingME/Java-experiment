package client;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.net.*;

/*
 * 聊天客户端的主框架类
 */
public class ChatClient extends JFrame implements ActionListener{

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    String ip = "127.0.0.1";//连接到服务端的ip地址
    int port = 8888;//连接到服务端的端口号
    String userName = "匿名用户";//用户名
    int type = 0;//0表示未连接，1表示已连接

    JComboBox combobox;//选择发送消息的接受者
    JTextArea messageShow;//客户端的信息显示
    JScrollPane messageScrollPane;//信息显示的滚动条

    JLabel express,sendToLabel,messageLabel ;

    JTextField clientMessage;//客户端消息的发送
    JCheckBox checkbox;//悄悄话
    JComboBox actionlist;//表情选择
    JButton clientMessageButton;//发送消息
    JTextField showStatus;//显示用户连接状态

    Socket socket;
    ObjectOutputStream output;//socket输出流
    ObjectInputStream input;//socket输入流

    ClientReceive recvThread;

    //建立菜单栏
    JMenuBar jMenuBar = new JMenuBar();
    //建立菜单组
    JMenu operateMenu = new JMenu ("操作(O)");
    //建立菜单项
    JMenuItem loginItem = new JMenuItem ("用户登录(I)");
    JMenuItem logoffItem = new JMenuItem ("用户注销(L)");
    JMenuItem exitItem=new JMenuItem ("退出(X)");

    JMenu conMenu=new JMenu ("设置(C)");
    JMenuItem userItem=new JMenuItem ("用户设置(U)");
    JMenuItem connectItem=new JMenuItem ("连接设置(C)");


    JMenu helpMenu=new JMenu ("帮助(H)");
    JMenuItem helpItem=new JMenuItem ("帮助(H)");

    //建立工具栏
    JToolBar toolBar = new JToolBar();
    //建立工具栏中的按钮组件
    JButton loginButton;//用户登录
    JButton logoffButton;//用户注销
    JButton userButton;//用户信息的设置
    JButton connectButton;//连接设置
    JButton exitButton;//退出按钮

    //窗口的大小
    Dimension faceSize = new Dimension(400, 600);

    JPanel downPanel ;
    GridBagLayout girdBag;
    GridBagConstraints girdBagCon;

    public ChatClient(){
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
        this.setTitle("聊天室客户端"); //设置标题

        setVisible(true);

        //为操作菜单栏设置热键'V'
        operateMenu.setMnemonic('O');

        //为用户登录设置快捷键为ctrl+i
        loginItem.setMnemonic ('I');
        loginItem.setAccelerator (KeyStroke.getKeyStroke (KeyEvent.VK_I,InputEvent.CTRL_MASK));

        //为用户注销快捷键为ctrl+l
        logoffItem.setMnemonic ('L');
        logoffItem.setAccelerator (KeyStroke.getKeyStroke (KeyEvent.VK_L,InputEvent.CTRL_MASK));

        //为退出快捷键为ctrl+x
        exitItem.setMnemonic ('X');
        exitItem.setAccelerator (KeyStroke.getKeyStroke (KeyEvent.VK_X,InputEvent.CTRL_MASK));

        //为设置菜单栏设置热键'C'
        conMenu.setMnemonic('C');

        //为用户设置设置快捷键为ctrl+u
        userItem.setMnemonic ('U');
        userItem.setAccelerator (KeyStroke.getKeyStroke (KeyEvent.VK_U,InputEvent.CTRL_MASK));

        //为连接设置设置快捷键为ctrl+c
        connectItem.setMnemonic ('C');
        connectItem.setAccelerator (KeyStroke.getKeyStroke (KeyEvent.VK_C,InputEvent.CTRL_MASK));

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
        operateMenu.add (loginItem);
        operateMenu.add (logoffItem);
        operateMenu.add (exitItem);
        jMenuBar.add (operateMenu);
        conMenu.add (userItem);
        conMenu.add (connectItem);
        jMenuBar.add (conMenu);
        helpMenu.add (helpItem);
        jMenuBar.add (helpMenu);
        setJMenuBar (jMenuBar);

        //初始化按钮
        loginButton = new JButton("登录");
        logoffButton = new JButton("注销");
        userButton  = new JButton("用户设置" );
        connectButton  = new JButton("连接设置" );
        exitButton = new JButton("退出" );
        //当鼠标放上显示信息
        loginButton.setToolTipText("连接到指定的服务器");
        logoffButton.setToolTipText("与服务器断开连接");
        userButton.setToolTipText("设置用户信息");
        connectButton.setToolTipText("设置所要连接到的服务器信息");
        //将按钮添加到工具栏
        toolBar.add(userButton);
        toolBar.add(connectButton);
        toolBar.addSeparator();//添加分隔栏
        toolBar.add(loginButton);
        toolBar.add(logoffButton);
        toolBar.addSeparator();//添加分隔栏
        toolBar.add(exitButton);
        contentPane.add(toolBar,BorderLayout.NORTH);

        checkbox = new JCheckBox("悄悄话");
        checkbox.setSelected(false);

        actionlist = new JComboBox();
        actionlist.addItem("");
        actionlist.addItem("微笑地");
        actionlist.addItem("呵呵地");
        actionlist.addItem("生气地");
        actionlist.addItem("神经病地");
        actionlist.addItem("悲伤地");
        actionlist.setSelectedIndex(0);

        //初始时
        loginButton.setEnabled(true);
        logoffButton.setEnabled(false);

        //为菜单栏添加事件监听
        loginItem.addActionListener(this);
        logoffItem.addActionListener(this);
        exitItem.addActionListener(this);
        userItem.addActionListener(this);
        connectItem.addActionListener(this);
        helpItem.addActionListener(this);

        //添加按钮的事件侦听
        loginButton.addActionListener(this);
        logoffButton.addActionListener(this);
        userButton.addActionListener(this);
        connectButton.addActionListener(this);
        exitButton.addActionListener(this);

        //添加发送对象
        combobox = new JComboBox();
        combobox.insertItemAt("所有人",0);
        combobox.setSelectedIndex(0);

        //添加消息显示框
        messageShow = new JTextArea();
        messageShow.setEditable(false);

        //添加滚动条
        messageScrollPane = new JScrollPane(messageShow,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        messageScrollPane.setPreferredSize(new Dimension(400,400));
        messageScrollPane.revalidate();

        //添加发送消息框与发送按钮
        clientMessage = new JTextField(23);
        clientMessage.setEnabled(false);
        clientMessageButton = new JButton();
        clientMessageButton.setText("发送");

        //添加系统消息的事件侦听
        clientMessage.addActionListener(this);
        clientMessageButton.addActionListener(this);

        sendToLabel = new JLabel("发送至:");
        express = new JLabel("表情:");
        messageLabel = new JLabel("发送消息:");
        downPanel = new JPanel();
        girdBag = new GridBagLayout();
        downPanel.setLayout(girdBag);

        girdBagCon = new GridBagConstraints();
        girdBagCon.gridx = 0;
        girdBagCon.gridy = 0;
        girdBagCon.gridwidth = 5;
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
        //girdBagCon.ipadx = 5;
        //girdBagCon.ipady = 5;
        girdBag.setConstraints(sendToLabel,girdBagCon);
        downPanel.add(sendToLabel);

        girdBagCon = new GridBagConstraints();
        girdBagCon.gridx =1;
        girdBagCon.gridy = 2;
        girdBagCon.anchor = GridBagConstraints.LINE_START;
        girdBag.setConstraints(combobox,girdBagCon);
        downPanel.add(combobox);

        girdBagCon = new GridBagConstraints();
        girdBagCon.gridx =2;
        girdBagCon.gridy = 2;
        girdBagCon.anchor = GridBagConstraints.LINE_END;
        girdBag.setConstraints(express,girdBagCon);
        downPanel.add(express);

        girdBagCon = new GridBagConstraints();
        girdBagCon.gridx = 3;
        girdBagCon.gridy = 2;
        girdBagCon.anchor = GridBagConstraints.LINE_START;
        //girdBagCon.insets = new Insets(1,0,0,0);
        //girdBagCon.ipadx = 5;
        //girdBagCon.ipady = 5;
        girdBag.setConstraints(actionlist,girdBagCon);
        downPanel.add(actionlist);

        girdBagCon = new GridBagConstraints();
        girdBagCon.gridx = 4;
        girdBagCon.gridy = 2;
        girdBagCon.insets = new Insets(1,0,0,0);
        //girdBagCon.ipadx = 5;
        //girdBagCon.ipady = 5;
        girdBag.setConstraints(checkbox,girdBagCon);
        downPanel.add(checkbox);

        girdBagCon = new GridBagConstraints();
        girdBagCon.gridx = 0;
        girdBagCon.gridy = 3;
        girdBag.setConstraints(messageLabel,girdBagCon);
        downPanel.add(messageLabel);

        girdBagCon = new GridBagConstraints();
        girdBagCon.gridx = 1;
        girdBagCon.gridy = 3;
        girdBagCon.gridwidth = 3;
        girdBagCon.gridheight = 1;
        girdBag.setConstraints(clientMessage,girdBagCon);
        downPanel.add(clientMessage);

        girdBagCon = new GridBagConstraints();
        girdBagCon.gridx = 4;
        girdBagCon.gridy = 3;
        girdBag.setConstraints(clientMessageButton,girdBagCon);
        downPanel.add(clientMessageButton);

        showStatus = new JTextField(35);
        showStatus.setEditable(false);
        girdBagCon = new GridBagConstraints();
        girdBagCon.gridx = 0;
        girdBagCon.gridy = 5;
        girdBagCon.gridwidth = 5;
        girdBag.setConstraints(showStatus,girdBagCon);
        downPanel.add(showStatus);

        contentPane.add(messageScrollPane,BorderLayout.CENTER);
        contentPane.add(downPanel,BorderLayout.SOUTH);

        //关闭程序时的操作
        this.addWindowListener(
                new WindowAdapter(){
                    public void windowClosing(WindowEvent e){
                        if(type == 1){
                            DisConnect();
                        }
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

        if (obj == userItem || obj == userButton) { //用户信息设置
            //调出用户信息设置对话框
            UserConf userConf = new UserConf(this,userName);
            userConf.setVisible(true);
            userName = userConf.userInputName;
        }
        else if (obj == connectItem || obj == connectButton) { //连接服务端设置
            //调出连接设置对话框
            ConnectConf conConf = new ConnectConf(this,ip,port);
            conConf.setVisible(true);
            ip = conConf.userInputIp;
            port = conConf.userInputPort;
        }
        else if (obj == loginItem || obj == loginButton) { //登录
            Connect();
        }
        else if (obj == logoffItem || obj == logoffButton) { //注销
            DisConnect();
            showStatus.setText("");
        }
        else if (obj == clientMessage || obj == clientMessageButton) { //发送消息
            SendMessage();
            clientMessage.setText("");
        }
        else if (obj == exitButton || obj == exitItem) { //退出
            int j=JOptionPane.showConfirmDialog(
                    this,"真的要退出吗?","退出",
                    JOptionPane.YES_OPTION,JOptionPane.QUESTION_MESSAGE);

            if (j == JOptionPane.YES_OPTION){
                if(type == 1){
                    DisConnect();
                }
                System.exit(0);
            }
        }
        else if (obj == helpItem) { //菜单栏中的帮助
            //调出帮助对话框
            Help helpDialog = new Help(this);
            helpDialog.setVisible(true);
        }
    }


    public void Connect(){
        try{
            socket = new Socket(ip,port);
        }
        catch (Exception e){
            JOptionPane.showConfirmDialog(
                    this,"不能连接到指定的服务器。\n请确认连接设置是否正确。","提示",
                    JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE);
            return;
        }

        try{
            output = new ObjectOutputStream(socket.getOutputStream());
            output.flush();
            input  = new ObjectInputStream(socket.getInputStream() );

            output.writeObject(userName);
            output.flush();

            recvThread = new ClientReceive(socket,output,input,combobox,messageShow,showStatus);
            recvThread.start();

            loginButton.setEnabled(false);
            loginItem.setEnabled(false);
            userButton.setEnabled(false);
            userItem.setEnabled(false);
            connectButton.setEnabled(false);
            connectItem.setEnabled(false);
            logoffButton.setEnabled(true);
            logoffItem.setEnabled(true);
            clientMessage.setEnabled(true);
            messageShow.append("连接服务器 "+ip+":"+port+" 成功...\n");
            type = 1;//标志位设为已连接
        }
        catch (Exception e){
            System.out.println(e);
            return;
        }
    }

    public void DisConnect(){
        loginButton.setEnabled(true);
        loginItem.setEnabled(true);
        userButton.setEnabled(true);
        userItem.setEnabled(true);
        connectButton.setEnabled(true);
        connectItem.setEnabled(true);
        logoffButton.setEnabled(false);
        logoffItem.setEnabled(false);
        clientMessage.setEnabled(false);

        if(socket.isClosed()){
            return ;
        }

        try{
            output.writeObject("用户下线");
            output.flush();

            input.close();
            output.close();
            socket.close();
            messageShow.append("已经与服务器断开连接...\n");
            type = 0;//标志位设为未连接
        }
        catch (Exception e){
            //
        }
    }

    public void SendMessage(){
        String toSomebody = combobox.getSelectedItem().toString();
        String status  = "";
        if(checkbox.isSelected()){
            status = "悄悄话";
        }

        String action = actionlist.getSelectedItem().toString();
        String message = clientMessage.getText();

        if(socket.isClosed()){
            return ;
        }

        try{
            output.writeObject("聊天信息");
            output.flush();
            output.writeObject(toSomebody);
            output.flush();
            output.writeObject(status);
            output.flush();
            output.writeObject(action);
            output.flush();
            output.writeObject(message);
            output.flush();
        }
        catch (Exception e){
            //
        }
    }
    public void setWindowIcon()
    {
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/img/clienticon.png"));
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
        new ChatClient();

    }
}

