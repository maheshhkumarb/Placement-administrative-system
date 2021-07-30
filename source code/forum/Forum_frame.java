
package forum;



import assessment.Assessment_frame;
import dashboard.Dashboard_frame;
import java.awt.*;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import static javax.swing.ScrollPaneConstants.*;
import login.*;
import query.Query_frame;



public class Forum_frame extends JFrame implements ActionListener,MouseListener,Runnable{
    JFrame f=new JFrame();
    JPanel p1,p3;
    JLabel l1,l2,l3,l4;
    JButton b1,b10,b11,b12,b13,b15,b16;
    JTextArea tf1,tf2;
    JScrollPane sp1,sp2;
    JTextField tf3;
    Color c1=new Color(58,64,82);
    Color c3=new Color(255, 255, 255);
    
    JLabel main_user_name_disJLabel,main_name_disJLabel;
    
    JLabel Line=new JLabel("_________________________________");
    
    JLabel background=new JLabel(new ImageIcon(loadImage("/Image/Forum.jpg")));
    
    JLabel user=new JLabel(new ImageIcon(loadImage("/Image/user.png")));
    
    JLabel dashboard=new JLabel(new ImageIcon(loadImage("/Image/home-run (1).png")));
    JLabel forum=new JLabel(new ImageIcon(loadImage("/Image/conversation (1).png")));
    JLabel assessment=new JLabel(new ImageIcon(loadImage("/Image/book (1).png")));
    JLabel query=new JLabel(new ImageIcon(loadImage("/Image/question (1).png")));
    JLabel setting=new JLabel(new ImageIcon(loadImage("/Image/gear (1).png")));
    JLabel logout=new JLabel(new ImageIcon(loadImage("/Image/logout (1).png")));

    JLabel dashboard1=new JLabel(new ImageIcon(loadImage("/Image/home-run.png")));
    JLabel forum1=new JLabel(new ImageIcon(loadImage("/Image/conversation.png")));
    JLabel assessment1=new JLabel(new ImageIcon(loadImage("/Image/book.png")));
    JLabel query1=new JLabel(new ImageIcon(loadImage("/Image/question.png")));
    JLabel setting1=new JLabel(new ImageIcon(loadImage("/Image/gear.png")));
    JLabel logout1=new JLabel(new ImageIcon(loadImage("/Image/logout (2).png")));
    
    static String main_user_name;  //rollno of the user
    static String main_name;   //name of the user 
    
    String name;
    String user_name;
    String msg_user;
    String msg_admin;
    String msg_send;

    Thread thread;
    
    int admin_forum_count=0;
    
 //   final String Driver="oracle.jdbc.driver.OracleDriver";
   // final String connect="jdbc:oracle:thin:@127.0.0.1:1521:XE";    
      
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==b1){
            msg_send=tf3.getText();
            tf3.setText(null);
            sendMsg();
            
        }
    }
    
    public void run(){
        while(true){
            try {
                getMsg();
                getAdminMsg();
                Thread.sleep(1000);
            } catch (Exception e) {
            }
        }
    }
    
    public void StartThread(){
       thread=new Thread(this);
       thread.start();
    }
    
    
    void sendMsg(){
        try {
        //    Class.forName(Driver);
          //  Connection con=DriverManager.getConnection(connect,"bootathon","admin");
        	Connection con=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\MAHESH KUMAR B\\Downloads\\SQLiteStudio-3.2.1\\mahi\\studentsdetails.db");
        	Statement st=con.createStatement();
            String query="insert into students_forum values ('"+main_user_name+"','"+main_name+"','"+msg_send+"') ";
            st.executeUpdate(query);
                                   
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e+" Error Insering msg");
        }
    }
    
    void getMsg(){
        String UserMsg="";
       // final String Driver="oracle.jdbc.driver.OracleDriver";
      //  final String connect="jdbc:oracle:thin:@127.0.0.1:1521:XE";
        try {
        //    Class.forName(Driver);
          //  Connection con=DriverManager.getConnection(connect,"bootathon","admin");
        	Connection con=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\MAHESH KUMAR B\\Downloads\\SQLiteStudio-3.2.1\\mahi\\studentsdetails.db");
        	Statement st=con.createStatement();
            String query="Select * from students_forum";
            ResultSet rs=st.executeQuery(query);
            
            while(rs.next()){
                user_name=rs.getString("user_name");
                name=rs.getString("name");
                msg_user=rs.getString("msg_send");
                UserMsg=UserMsg +" "+ name+" ("+user_name+") : "+msg_user+".\n\n";
            }
            tf2.setText(UserMsg);
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e+" Error Displaying Table");
        }
    }
    
    void getAdminMsg(){
        int sno=1;
        String UserMsg="";
        
        try {
         //   Class.forName(Driver);
           // Connection con=DriverManager.getConnection(connect,"bootathon","admin");
        	Connection con=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\MAHESH KUMAR B\\Downloads\\SQLiteStudio-3.2.1\\mahi\\studentsdetails.db");
        	Statement st=con.createStatement();
            String query="Select * from admin_forum";
            ResultSet rs=st.executeQuery(query);
            
            while(rs.next()){
                msg_admin=rs.getString("msg_admin");
                UserMsg=UserMsg +" "+sno+". "+msg_admin+".\n\n";
                sno++;
            }
            tf1.setText(UserMsg);
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e+" Error Displaying Table");
        }
    }
     
    public BufferedImage loadImage(String fileName){
        BufferedImage buff = null;
        try {
            buff = ImageIO.read(getClass().getResourceAsStream(fileName));
        } catch (IOException e) {
                // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
        return buff;
    }
    
    void admin_forum_count_update(){
        try
        {
        //    Class.forName(Driver);
          //  Connection con=DriverManager.getConnection(connect,"bootathon","admin");	
        	Connection con=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\MAHESH KUMAR B\\Downloads\\SQLiteStudio-3.2.1\\mahi\\studentsdetails.db");
        	Statement st=con.createStatement();
            String query="select count(*) from admin_forum";
            ResultSet rs=st.executeQuery(query);
            rs.next();
            admin_forum_count=rs.getInt("count(*)");
            con.close();

          //  Class.forName(Driver);
            //Connection con1=DriverManager.getConnection(connect,"bootathon","admin");
            Connection con1=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\MAHESH KUMAR B\\Downloads\\SQLiteStudio-3.2.1\\mahi\\studentsdetails.db");
            Statement st1=con1.createStatement();
            String query1="update registers set index_count='"+admin_forum_count+"' where rollno='"+main_user_name+"' ";
            st1.executeUpdate(query1);
            con1.close();

        }
        catch(Exception a)
        {
                System.out.print(a);
        }
    }
    
    public static void main(String[] args) {
        new Forum_frame(main_user_name, main_name);
    }
    
    public Forum_frame(String main_user_name,String main_name) throws HeadlessException {
        this.main_user_name=main_user_name;  //rollno
        this.main_name=main_name;   //name
        
        p1=new JPanel();    //notification panel
        p3=new JPanel();    //forum
        
        l1=new JLabel("Classroom");
        l2=new JLabel("Forum");
        l3=new JLabel("Announcement (by Admin):");
        l4=new JLabel("Forum (General conversation) :");
        
        tf1=new JTextArea("");
        tf2=new JTextArea("");
        tf3=new JTextField("");
        
        main_user_name_disJLabel=new JLabel(""+main_user_name+"");
        main_name_disJLabel=new JLabel(""+main_name+"");
        
        sp1=new JScrollPane(tf1);
        sp2=new JScrollPane(tf2);
        
        b1=new JButton("Send");
        
        b10=new JButton("Dashboard");
        b11=new JButton("Assessment");
        b12=new JButton("Forum");
        b13=new JButton("Query");
        b15=new JButton("Setting");
        b16=new JButton("Logout");
                
        p1.setBounds(10, 20, 250, 735);
        p3.setBounds(270, 210, 700, 545);
       
        background.setBounds(0, 0, 1000, 210);
        
        user.setBounds(245, 40, 200,200);
        
        main_name_disJLabel.setBounds(450, 100, 200,50);
        main_user_name_disJLabel.setBounds(450, 150, 200,50);
        main_name_disJLabel.setForeground(Color.black);
        main_user_name_disJLabel.setForeground(Color.black);
        main_name_disJLabel.setFont(new Font("TimesRoman",Font.PLAIN,20));
        main_user_name_disJLabel.setFont(new Font("TimesRoman",Font.PLAIN,20));
        main_name_disJLabel.setForeground(Color.WHITE);
        main_user_name_disJLabel.setForeground(Color.WHITE);
        
        l1.setBounds(10,10,150,30);
        l2.setBounds(270,20,150,30);
        
        l3.setBounds(30, 10, 300, 30);
        l4.setBounds(30, 130, 300, 30);
       
        b1.setBounds(580, 490, 100, 30);

        tf3.setBounds(30, 490, 500, 30);
        
        sp1.setBounds(30, 50, 600, 70);
        sp2.setBounds(30, 170, 600, 300);
        sp1.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);
        sp2.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);
        
        Line.setBounds(8, 430, 250,20);
        Line.setForeground(Color.white);
        
        dashboard.setBounds(5, 80, 30,30);
        assessment.setBounds(10, 140, 30,30);
        forum.setBounds(10, 200, 30,30);
        query.setBounds(10, 260, 30,30);
        setting.setBounds(10, 520, 30,30);
        logout.setBounds(10, 600, 30,30);
        
        dashboard1.setBounds(5, 80, 30,30);
        assessment1.setBounds(10, 140, 30,30);
        forum1.setBounds(10, 200, 30,30);
        query1.setBounds(10, 260, 30,30);
        setting1.setBounds(10, 520, 30,30);
        logout1.setBounds(10, 600, 30,30);
        
        b10.setBounds(45, 80, 200,30);
        b11.setBounds(45, 140, 200,30);
        b12.setBounds(45, 200, 200,30);
        b13.setBounds(45, 260, 200,30);
        b15.setBounds(45, 520, 200,30);
        b16.setBounds(45, 600, 200,30);
        
        b1.setFocusPainted(false);
        
        b10.setBorderPainted(false);
        b11.setBorderPainted(false);
        b12.setBorderPainted(false);
        b13.setBorderPainted(false);
        b15.setBorderPainted(false);
        b16.setBorderPainted(false);
        
        b10.setFocusPainted(false);
        b11.setFocusPainted(false);
        b12.setFocusPainted(false);
        b13.setFocusPainted(false);
        b15.setFocusPainted(false);
        b16.setFocusPainted(false);
        
        
        p1.setBackground(c1);
        p3.setBackground(c3);

        b1.setBackground(c1);
        b1.setForeground(c3);
           
        b10.setBackground(c1);
        b11.setBackground(c1);
        b12.setBackground(c3);
        b13.setBackground(c1);
        b15.setBackground(c1);
        b16.setBackground(c1);
        
        l1.setForeground(c3);
        l2.setForeground(c3);
        b10.setForeground(c3);
        b11.setForeground(c3);
        b12.setForeground(c1);
        b13.setForeground(c3);
        b15.setForeground(c3);
        b16.setForeground(c3);
        
        tf1.setLineWrap(true);
        tf1.setWrapStyleWord(true);
        tf2.setLineWrap(true);
        tf2.setWrapStyleWord(true);
        
        l1.setFont(new Font("TimesRoman",Font.PLAIN,25));
        l2.setFont(new Font("TimesRoman",Font.BOLD,25));
        l3.setFont(new Font("TimesRoman",Font.BOLD,18));
        l4.setFont(new Font("TimesRoman",Font.BOLD,18));
        b1.setFont(new Font("TimesRoman",Font.PLAIN,16));
        
        tf1.setFont(new Font("TimesRoman",Font.BOLD,14));
        tf2.setFont(new Font("TimesRoman",Font.PLAIN,14));
        tf3.setFont(new Font("TimesRoman",Font.PLAIN,14));
                
        b10.setFont(new Font("TimesRoman",Font.PLAIN,20));
        b11.setFont(new Font("TimesRoman",Font.PLAIN,20));
        b12.setFont(new Font("TimesRoman",Font.PLAIN,20));
        b13.setFont(new Font("TimesRoman",Font.PLAIN,20));
        b15.setFont(new Font("TimesRoman",Font.PLAIN,20));
        b16.setFont(new Font("TimesRoman",Font.PLAIN,20));
        
        b1.addActionListener(this);
                
        b10.addMouseListener(this);
        b11.addMouseListener(this);
        b12.addMouseListener(this);
        b13.addMouseListener(this);
        b15.addMouseListener(this);
        
        p1.add(dashboard1);
        p1.add(forum1);
        p1.add(assessment1);
        p1.add(query1);
        p1.add(setting1);
        p1.add(logout1);
        
        p1.add(l1);
        p1.add(dashboard);
        p1.add(forum);
        p1.add(assessment);
        p1.add(query);
        p1.add(setting);
        p1.add(logout);
                
        p1.add(Line);
        
        p1.add(b10);
        p1.add(b11);
        p1.add(b12);
        p1.add(b13);
        p1.add(b15);
        p1.add(b16);
        
        p3.add(l2);
        p3.add(b1);
        p3.add(l3);
        p3.add(l4);
        p3.add(sp1);
        p3.add(sp2);
        p3.add(tf3);
        
        p1.setLayout(null);
        p3.setLayout(null);
        
        f.add(user);        
        f.add(p1);
        f.add(p3);
        f.add(l2);
        f.add(main_name_disJLabel);
        f.add(main_user_name_disJLabel);
        f.add(background);
        
        forum.setVisible(true);
        forum1.setVisible(false);
        
        f.setLayout(null);
        f.setResizable(false);
        f.setSize(1000,800);
	f.setLocationRelativeTo(null);
        f.setBackground(Color.gray);
        f.setVisible(true);
        
        admin_forum_count_update();
        
        b16.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                b16.setBackground(Color.white);
                b12.setBackground(c1);
            
                b16.setForeground(Color.black);
                b12.setForeground(Color.white);

                logout.setVisible(true);
                forum.setVisible(false);

                logout1.setVisible(false);
                forum1.setVisible(true);

                int a=JOptionPane.showConfirmDialog(f,"Are you sure?");  

                if(a==JOptionPane.YES_OPTION){  
                    thread.stop();
                    f.dispose();
                    
                    new Logins();
                } 
                else{
                    b12.setBackground(Color.white);
                    b16.setBackground(c1);

                    b12.setForeground(Color.black);
                    b16.setForeground(Color.white);

                    forum.setVisible(true);
                    logout.setVisible(false);

                    forum1.setVisible(false);
                    logout1.setVisible(true);
                }
            }
        });
        
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {  
                int a=JOptionPane.showConfirmDialog(f,"Are you sure?");  
                if(a==JOptionPane.YES_OPTION){  
                    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
                } 
            }
        });
        f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }
    
    public void mouseClicked(MouseEvent e){
        thread.stop();
        if(e.getSource()==b10){

            b10.setBackground(Color.white);
            b12.setBackground(c1);
            
            b10.setForeground(Color.black);
            b12.setForeground(Color.white);
            
            dashboard1.setVisible(true);
            forum1.setVisible(false);
            
            dashboard.setVisible(false);
            forum.setVisible(true);
            f.dispose();
            new Dashboard_frame(main_user_name, main_name);
        }

        else if(e.getSource()==b11){
            
            b11.setBackground(Color.white);
            b12.setBackground(c1);
            
            b11.setForeground(Color.black);
            b12.setForeground(Color.white);
            
            assessment1.setVisible(true);
            forum1.setVisible(false);
            
            assessment.setVisible(false);
            forum.setVisible(true);
            
            new Assessment_frame(main_user_name, main_name);
            f.dispose();
        }

        else if(e.getSource()==b13){

            b13.setBackground(Color.white);
            b12.setBackground(c1);
            
            b13.setForeground(Color.black);
            b12.setForeground(Color.white);
            
            query1.setVisible(true);
            forum1.setVisible(false);
            
            query.setVisible(false);
            forum.setVisible(true);
            
            f.dispose();
            new Query_frame(main_user_name, main_name).StartThread();
            
        }

        else if(e.getSource()==b15){
            
            b15.setBackground(Color.white);
            b12.setBackground(c1);
            
            b15.setForeground(Color.black);
            b12.setForeground(Color.white);
            
            setting1.setVisible(true);
            forum1.setVisible(false);
            
            setting.setVisible(false);
            forum.setVisible(true);
            
            f.dispose();
            new Setting_frame(main_user_name, main_name);
        }
    }
        
    @Override
    public void mouseEntered(MouseEvent e) {  
        }  
    public void mouseExited(MouseEvent e) {  
        }  
    public void mousePressed(MouseEvent e) {  
        }  
    public void mouseReleased(MouseEvent e) {  
        }
    
}
