
package assessment;



import admin.Admin_frame;
import dashboard.Dashboard_frame;
import forum.Forum_frame;
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
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import static javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER;
import javax.swing.border.Border;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;
import login.Logins;
import login.Setting_frame;
import query.Query_frame;



public class Assessment_frame extends JFrame implements ActionListener,MouseListener,Runnable{
    JFrame f=new JFrame();
    JPanel p1,p3,p4,p5,p6;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
    JButton b1,b2,b3,b4,b5,b6,b10,b11,b12,b13,b15,b16;
    JTable t1;
    JTextArea tf1,tf3;
    JTextField tf2;
    JScrollPane sp1,sp2,sp3;
    Color c1=new Color(58,64,82);
    Color c3=new Color(255, 255, 255);
    
    JLabel main_user_name_disJLabel,main_name_disJLabel;
    
    DefaultMutableTreeNode TestDocuments=new DefaultMutableTreeNode("TestDocuments");
    JTree jt=new JTree(TestDocuments);
    
    JLabel Line=new JLabel("_________________________________");
    
    JLabel background=new JLabel(new ImageIcon(loadImage("/Image/Assessment.jpg")));
    
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
    String msg_send;
    
    String start_date;
    String start_time;
    String end_date;
    String end_time;
     
    String test_link;
    String testdetails;
    
    ArrayList<String> fileName=new ArrayList<String>();
    
    int fileCount=0;
    
    public Assessment_frame(String main_user_name, String main_name) throws HeadlessException {
        this.main_user_name = main_user_name;
        this.main_name = main_name;
        
        p1=new JPanel();    //notification panel
        p3=new JPanel();    //upcoming test panel
        p4=new JPanel();    //completed test panel
        p5=new JPanel();    //test Documents
        p6=new JPanel();    //QnA forum
        
        main_user_name_disJLabel=new JLabel(""+main_user_name+"");
        main_name_disJLabel=new JLabel(""+main_name+"");
        
        l1=new JLabel("Classroom");
        l2=new JLabel("Assessment");
        l3=new JLabel("QnA Forum :");
        l4=new JLabel("Test Details (Join the test when started) :");
        l5=new JLabel("Test Documents (Click to open) :");
        l6=new JLabel("Performance Based on Results :");
        l7=new JLabel("");
        l8=new JLabel("");
        l9=new JLabel("");
        
        tf1=new JTextArea();
        tf2=new JTextField();
        tf3=new JTextArea();
        
        b1=new JButton("Upcoming Test");
        b2=new JButton("Completed Test");
        b3=new JButton("Test Documents");
        b4=new JButton("QnA Forum");
        b5=new JButton("Results");
        b6=new JButton("Send");
        
        b10=new JButton("Dashboard");
        b11=new JButton("Assessment");
        b12=new JButton("Forum");
        b13=new JButton("Query");
//        b14=new JButton("Admin");
        b15=new JButton("Setting");
        b16=new JButton("Logout");
        
        t1=new JTable();
        //t1.setFont(new Font("Verdana",Font.PLAIN,15));
        sp1 =new JScrollPane(t1);
        sp2 =new JScrollPane(tf1);
        sp3 =new JScrollPane(tf3);
        
        user.setBounds(245, 40, 200,200);
        
        main_name_disJLabel.setBounds(450, 100, 200,50);
        main_user_name_disJLabel.setBounds(450, 150, 200,50);
        main_name_disJLabel.setForeground(Color.black);
        main_user_name_disJLabel.setForeground(Color.black);
        main_name_disJLabel.setFont(new Font("TimesRoman",Font.PLAIN,20));
        main_user_name_disJLabel.setFont(new Font("TimesRoman",Font.PLAIN,20));
        main_name_disJLabel.setForeground(Color.WHITE);
        main_user_name_disJLabel.setForeground(Color.WHITE);
                
        p1.setBounds(10, 20, 250, 735);
        p3.setBounds(270, 230, 700, 525);
        p4.setBounds(270, 265,  700, 490);
        p5.setBounds(270, 265,  700, 490);
        p6.setBounds(270, 265,  700, 490);
        
        background.setBounds(0, 0, 1000, 210);
       
        l1.setBounds(10,10,150,30);
        l2.setBounds(270,20,150,30);
        l3.setBounds(50, 15, 300, 30);
        l4.setBounds(50, 20, 400, 30);
        l5.setBounds(50, 15, 400, 30);
        l6.setBounds(50, 15, 400, 30);
        l7.setBounds(40, 65, 400, 30);
        l8.setBounds(40, 100, 400, 30);
        l9.setBounds(40, 135, 400, 30);
        
        sp1.setBounds(150, 200, 400, 250);
        
        jt.setBounds(20, 60, 400, 400);
                
        b1.setBounds(260, 205, 366, 30);
        b2.setBounds(626, 205, 365, 30);
        b3.setBounds(262, 240, 241, 30);
        b4.setBounds(505, 240, 241, 30);
        b5.setBounds(750, 240, 241, 30);
        b6.setBounds(592, 425, 100, 30);
        
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
        
        Line.setBounds(8, 430, 250,20);
        Line.setForeground(Color.white);
        
        sp2.setBounds(50, 60, 627, 345);
        tf2.setBounds(50, 425, 500, 30);
        
        sp3.setBounds(10, 70, 680, 420);
        tf1.setLineWrap(true);
        tf1.setWrapStyleWord(true);
        tf3.setLineWrap(true);
        tf3.setWrapStyleWord(true);
        
        sp1.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);
        sp2.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);
        sp3.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);
        
        b1.setFocusPainted(false);
        b2.setFocusPainted(false);
        b3.setFocusPainted(false);
        b4.setFocusPainted(false);
        b5.setFocusPainted(false);
        b6.setFocusPainted(false);
        
        b10.setFocusPainted(false);
        b11.setFocusPainted(false);
        b12.setFocusPainted(false);
        b13.setFocusPainted(false);
        b15.setFocusPainted(false);
        b16.setFocusPainted(false);
        b10.setBorderPainted(false);
        b11.setBorderPainted(false);
        b12.setBorderPainted(false);
        b13.setBorderPainted(false);
        b15.setBorderPainted(false);
        b16.setBorderPainted(false);
        
        p1.setBackground(c1);
        p3.setBackground(c3);
        p4.setBackground(c3);
        p5.setBackground(c3);
        p6.setBackground(c3);
        
        color_button();
       
        b10.setBackground(c1);
        b11.setBackground(c3);
        b12.setBackground(c1);
        b13.setBackground(c1);
        b15.setBackground(c1);
        b16.setBackground(c1);
        
        l1.setForeground(c3);
        l2.setForeground(c3);
        b10.setForeground(c3);
        b11.setForeground(c1);
        b12.setForeground(c3);
        b13.setForeground(c3);
        b15.setForeground(c3);
        b16.setForeground(c3);
        
        l1.setFont(new Font("TimesRoman",Font.PLAIN,25));
        l2.setFont(new Font("TimesRoman",Font.BOLD,25));
        l3.setFont(new Font("TimesRoman",Font.BOLD,17));
        l4.setFont(new Font("TimesRoman",Font.BOLD,17));
        l5.setFont(new Font("TimesRoman",Font.BOLD,17));
        l6.setFont(new Font("TimesRoman",Font.BOLD,17));
        l7.setFont(new Font("TimesRoman",Font.BOLD,15));
        l8.setFont(new Font("TimesRoman",Font.BOLD,15));
        l9.setFont(new Font("TimesRoman",Font.BOLD,15));
        
        t1.setFont(new Font("TimesRoman",Font.PLAIN,18));
        
        tf1.setFont(new Font("TimesRoman",Font.PLAIN,14));
        tf2.setFont(new Font("TimesRoman",Font.PLAIN,14));
        tf3.setFont(new Font("TimesRoman",Font.BOLD,14));
        
        b1.setFont(new Font("TimesRoman",Font.PLAIN,17));
        b2.setFont(new Font("TimesRoman",Font.PLAIN,17));
        b3.setFont(new Font("TimesRoman",Font.PLAIN,16));
        b4.setFont(new Font("TimesRoman",Font.PLAIN,16));
        b5.setFont(new Font("TimesRoman",Font.PLAIN,16));
        b6.setFont(new Font("TimesRoman",Font.PLAIN,16));
        
        b10.setFont(new Font("TimesRoman",Font.PLAIN,20));
        b11.setFont(new Font("TimesRoman",Font.PLAIN,20));
        b12.setFont(new Font("TimesRoman",Font.PLAIN,20));
        b13.setFont(new Font("TimesRoman",Font.PLAIN,20));
        b15.setFont(new Font("TimesRoman",Font.PLAIN,20));
        b16.setFont(new Font("TimesRoman",Font.PLAIN,20));
        
        jt.setFont(new Font("TimesRoman",Font.PLAIN,16));
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        
        b10.addMouseListener(this);
        b11.addMouseListener(this);
        b12.addMouseListener(this);
        b13.addMouseListener(this);
        b15.addMouseListener(this);
        
        jt.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                TreeSelectionModel model=jt.getSelectionModel();
               // File file=new File("C:\\Users\\MAHESH KUMAR B\\Downloads\\documents");
                String s1="C:\\Users\\MAHESH KUMAR B\\Downloads\\documents\\";
                int x=model.getSelectionRows()[0];
                String s2=fileName.get(x-1);
                s1=s1+s2;
                //System.out.println(s1);
                File file=new File(s1);
               // System.out.println(x);
//                for (int i = 0; i < fileName.size(); i++) {
//                    System.out.println(fileName.get(i));
//                }
                try {
                	//System.out.println(x);
                    Desktop.getDesktop().open(file);
                    
                } 
                catch (Exception e2) {
                	System.out.println("mahesh");
                }
                    
            }
        });
      
        f.add(l2);
        f.add(b1);
        f.add(b2);
        f.add(b3);
        f.add(b4);
        f.add(b5);
        f.add(p1);
        f.add(p3);
        f.add(p4);
        f.add(p5);
        f.add(p6);
        f.add(user);
        f.add(main_name_disJLabel);
        f.add(main_user_name_disJLabel);
        f.add(background);
        
        p1.add(dashboard1);
        p1.add(forum1);
        p1.add(assessment1);
        p1.add(query1);
        p1.add(setting1);
        p1.add(logout1);
        p1.add(dashboard);
        p1.add(forum);
        p1.add(assessment);
        p1.add(query);
        p1.add(setting);
        p1.add(logout);
        p1.add(l1);
        p1.add(Line);
        p1.add(b10);
        p1.add(b11);
        p1.add(b12);
        p1.add(b13);
        p1.add(b15);
        p1.add(b16);        
        
        b3.setVisible(false);
        b4.setVisible(false);
        b5.setVisible(false);
                       
        TestDetails_result();
        b1.setBackground(c3);
        b1.setForeground(c1);
        p3.add(sp3);
        p3.add(l4);
        
        p4.add(l5);
        p4.add(jt);
        
        p5.add(l3);
        p5.add(sp2);
        p5.add(tf2);
        p5.add(b6);
        
        p6.add(sp1);
        p6.add(l6);
        p6.add(l7);
        p6.add(l8);
        p6.add(l9);
        
        p3.setVisible(true);
        p4.setVisible(false);
        p5.setVisible(false);
        p6.setVisible(false);
        
        f.setLayout (null);
        p1.setLayout(null);
        p3.setLayout(null);
        p4.setLayout(null);
        p5.setLayout(null);
        p6.setLayout(null);
        //p7.setLayout(null);
        
        assessment1.setVisible(false);
        assessment.setVisible(true);
        
        Results();
        
        f.setResizable(false);
        f.setSize(1000,800);
	f.setLocationRelativeTo(null);
        f.setBackground(Color.gray);
        f.setVisible(true);
        
        b16.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                b16.setBackground(Color.white);
                b11.setBackground(c1);
            
                b16.setForeground(Color.black);
                b11.setForeground(Color.white);

                logout.setVisible(true);
                assessment.setVisible(false);

                logout1.setVisible(false);
                assessment1.setVisible(true);
                
                int a=JOptionPane.showConfirmDialog(f,"Are you sure?");  

                if(a==JOptionPane.YES_OPTION){  
                    f.dispose();
                    new Logins();
                }
                else{
                    b11.setBackground(Color.white);
                    b16.setBackground(c1);

                    b11.setForeground(Color.black);
                    b16.setForeground(Color.white);

                    assessment.setVisible(true);
                    logout.setVisible(false);

                    assessment1.setVisible(false);
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

    void color_button(){
        b1.setBackground(c1);
        b2.setBackground(c1);
        b3.setBackground(c1);
        b4.setBackground(c1);
        b5.setBackground(c1);
        b6.setBackground(c1);
        
        b1.setForeground(c3);
        b2.setForeground(c3);
        b3.setForeground(c3);
        b4.setForeground(c3);
        b5.setForeground(c3);
        b6.setForeground(c3);
    }
    
    public void mouseClicked(MouseEvent e){
        if(e.getSource()==b10){
            b10.setBackground(Color.white);
            b11.setBackground(c1);
            
            b10.setForeground(Color.black);
            b11.setForeground(Color.white);
            
            dashboard.setVisible(true);
            assessment.setVisible(false);
            
            dashboard1.setVisible(false);
            assessment1.setVisible(true);
            f.dispose();
            new Dashboard_frame(main_user_name, main_name);
        }
        
        else if(e.getSource()==b12){
            b12.setBackground(Color.white);
            b11.setBackground(c1);
            
            b12.setForeground(Color.black);
            b11.setForeground(Color.white);
            
            forum.setVisible(true);
            assessment1.setVisible(false);
            
            forum1.setVisible(false);
            assessment1.setVisible(true);
            
            f.dispose();
            new Forum_frame(main_user_name, main_name).StartThread();
        }
        else if(e.getSource()==b13){
            b13.setBackground(Color.white);
            b11.setBackground(c1);
            
            b13.setForeground(Color.black);
            b11.setForeground(Color.white);
            
            query.setVisible(true);
            assessment.setVisible(false);
            
            query1.setVisible(false);
            assessment1.setVisible(true);
            
            f.dispose();
            new Query_frame(main_user_name, main_name).StartThread();
            
        }
//       
        else if(e.getSource()==b15){
            b15.setBackground(Color.white);
            b11.setBackground(c1);
            
            b15.setForeground(Color.black);
            b11.setForeground(Color.white);
            
            setting.setVisible(true);
            assessment.setVisible(false);
            
            setting1.setVisible(false);
            assessment1.setVisible(true);
            
            f.dispose();
            new Setting_frame(main_user_name, main_name);
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
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==b1)
        {
            color_button();
            p4.setVisible(false);
            p5.setVisible(false);
            p6.setVisible(false);
            p3.setVisible(true);
            b3.setVisible(false);
            b4.setVisible(false);
            b5.setVisible(false);
            b1.setBackground(c3);
            b1.setForeground(c1);
            TestDetails_result();
            
        }
        else if(e.getSource()==b2)
        {
            TestDocumnets();
            color_button();
            b2.setBackground(c3);
            b2.setForeground(c1);
            b3.setBackground(c3);
            b3.setForeground(c1);
            b3.setVisible(true);
            b4.setVisible(true);
            b5.setVisible(true);
            p4.setVisible(true);
            p5.setVisible(false);
            p6.setVisible(false);
            p3.setVisible(false);
        }
        
        else if(e.getSource()==b3){
            TestDocumnets();
            color_button();
            b2.setBackground(c3);
            b2.setForeground(c1);
            b3.setBackground(c3);
            b3.setForeground(c1);
            p3.setVisible(false);
            p4.setVisible(true);
            p5.setVisible(false);
            p6.setVisible(false);
        }
        
        else if(e.getSource()==b4){
            QnAForum();
            color_button();
            b2.setBackground(c3);
            b2.setForeground(c1);
            b4.setBackground(c3);
            b4.setForeground(c1);
            p3.setVisible(false);
            p4.setVisible(false);
            p5.setVisible(true);
            p6.setVisible(false);
        }
        else if(e.getSource()==b5){
            Results();
            color_button();
            b2.setBackground(c3);
            b2.setForeground(c1);
            b5.setBackground(c3);
            b5.setForeground(c1);
            p3.setVisible(false);
            p4.setVisible(false);
            p5.setVisible(false);
            p6.setVisible(true);
        }
        else if(e.getSource()==b6){
            msg_send=tf2.getText();
            tf2.setText(null);
            sendMsg();
        }
    }
    
    
    void TestDetails_result(){
        int sno=1;
        testdetails="";
        ArrayList<String> x=new ArrayList<String>();
     //   final String Driver="oracle.jdbc.driver.OracleDriver";
      //  final String connect="jdbc:oracle:thin:@127.0.0.1:1521:XE";
        try {
        //    Class.forName(Driver);
         //   Connection con=DriverManager.getConnection(connect,"bootathon","admin");
        	Connection con=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\MAHESH KUMAR B\\Downloads\\SQLiteStudio-3.2.1\\mahi\\studentsdetails.db");
        	Statement st=con.createStatement();
            String query="Select * from Test_Details";
            ResultSet rs=st.executeQuery(query);
            

            
            while(rs.next()){
            	start_time=rs.getString("start_time");			     
                end_time=rs.getString("end_time");
                start_date=rs.getString("start_date");			     
                end_date=rs.getString("end_date");
                test_link=rs.getString("test_link");
                testdetails=testdetails+" "+sno+". Starts at: "+start_date+" "+start_time+"\n" +
                        "    Ends at: "+end_date+" "+end_time+"\n" +
                        "    Test Link: "+test_link+"\n\n";

               /* if(end_time.after(new Date())){
                    start_date=new Date(start_time.getTime());
                    end_date=new Date(end_time.getTime());
                    testdetails=testdetails+" "+sno+". Starts at: "+String.valueOf(start_date)+"\n" +
                                    "    Ends at: "+String.valueOf(end_date)+"\n" +
                                    "    Test Link: "+test_link+"\n\n";*/
                    //System.out.println(sno);
                    sno++;
            //    }
               /* if(!end_time.after(new Date())){
                    x.add(test_link);
                }*/
                tf3.setText(testdetails);
            }
//            System.out.println(x);
            for (String string : x) {
                String queryDelete="Delete from test_details where test_link='"+string+"'";
                System.out.println(queryDelete);
                st.executeUpdate(queryDelete);
            }
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e+" Error Displaying Table");
        }
    }
    
    void RecursivePrint(File[] arr,int index,int level){ 
         // terminate condition 
         if(index == arr.length) 
             return; 
           
         // tabs for internal levels 
         for (int i = 0; i < level; i++) 
             System.out.print("\t"); 
           
         // for files 
         if(arr[index].isFile()) {
             //System.out.println(arr[index].getName());
                     fileName.add(arr[index].getName()); 
                     fileCount++;
         }
           
         // for sub-directories 
         else if(arr[index].isDirectory()) 
         { 
             //System.out.println("[" + arr[index].getName() + "]"); 
             
             fileName.add(arr[index].getName());
             fileCount++;
             
             // recursion for sub-directories 
             RecursivePrint(arr[index].listFiles(), 0, level + 1); 
         } 
            
         // recursion for main directory 
         RecursivePrint(arr,++index, level); 
    }
    
    void TestDocumnets(){
        String maindirpath = "C:\\Users\\MAHESH KUMAR B\\Downloads\\documents"; 
                  
        File maindir = new File(maindirpath); 
           
        if(maindir.exists() && maindir.isDirectory()) 
        { 
            File arr[] = maindir.listFiles(); 
              
            RecursivePrint(arr,0,0);  
       }
        
        
        Iterator xyz=fileName.iterator();
        while(xyz.hasNext()){
            TestDocuments.add(new DefaultMutableTreeNode((String)xyz.next()));
        }
//        for (int i = 0; i <fileCount; i++) {
//            System.out.println(fileName[i]);
//            TestDocuments.add(new DefaultMutableTreeNode(fileName[i]));
//        }
        
        
        //JLabel lt=new JLabel();
        //lt.setBounds(20, 20, 300, 300);
        jt.expandRow(0);
        //p4.add(lt);
    }
       
    void QnAForum(){
        StartThread();
    }
    
    void Results(){
        int column,average=0,rank=1;
        int test[]=new int[100];
   //     final String Driver="oracle.jdbc.driver.OracleDriver";
    //    final String connect="jdbc:oracle:thin:@127.0.0.1:1521:XE";
        try {
      //      Class.forName(Driver);
         //   Connection con=DriverManager.getConnection(connect,"bootathon","admin");
            
        	Connection con=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\MAHESH KUMAR B\\Downloads\\SQLiteStudio-3.2.1\\mahi\\studentsdetails.db");
        	Statement st=con.createStatement();
            
            String query="Select * from Student_Results order by average desc";
            ResultSet rs=st.executeQuery(query);
            ResultSetMetaData rsmd=rs.getMetaData(); 
            column =rsmd.getColumnCount()-3;

            DefaultTableModel model=new DefaultTableModel();
            String s1[]={"Test","Mark"};
            model.setColumnIdentifiers(s1);
            t1.setModel(model);
            t1.setFillsViewportHeight(true);
            t1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
            
            while(rs.next()){
              if(rs.getString("user_name").equals(main_user_name)){
                  for (int i = 1; i <= column; i++) {
                      test[i]=rs.getInt("test"+i);
                      model.addRow(new Object[] {"test"+i,test[i]});
                  }
                  average=rs.getInt("average");
                  break;
              }
              rank++;
            }
            l7.setText("Rank :"+rank);
            l8.setText("Average Mark :"+average);
            if(average>90)
	    {
	    	l9.setText("Band : A");
	    }
	    else if(average>80)
	    {
	    	l9.setText("Band : B");
	    }
	    else if(average>50)
	    {
	    	l9.setText("Band : C");
	    }
	    else if(average>30)
	    {
	    	l9.setText("Band : D");
	    }
	    else
	    {
	    	l9.setText("Band : NULL");
	    }
            p6.add(l7);
            p6.add(l8);
            p6.add(l9);
            p6.add(sp1);
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e+"Error Displaying Table");
        }    
    }
        
    public void run(){
        while(true){
            try {
                getMsg();
                Thread.sleep(1000);
            } catch (Exception e) {
            }
        }
    }
    
    void StartThread(){
        new Thread(this).start();
    }
    
    void sendMsg(){
       // final String Driver="oracle.jdbc.driver.OracleDriver";
      //  final String connect="jdbc:oracle:thin:@127.0.0.1:1521:XE";
        try {
        //    Class.forName(Driver);
          //  Connection con=DriverManager.getConnection(connect,"bootathon","admin");
        	Connection con=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\MAHESH KUMAR B\\Downloads\\SQLiteStudio-3.2.1\\mahi\\studentsdetails.db");
        	Statement st=con.createStatement();
            String query="insert into qna_forum values ('"+main_user_name+"','"+main_name+"','"+msg_send+"') ";
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
      //  final String Driver="oracle.jdbc.driver.OracleDriver";
        //final String connect="jdbc:oracle:thin:@127.0.0.1:1521:XE";
        try {
          //  Class.forName(Driver);
            //Connection con=DriverManager.getConnection(connect,"bootathon","admin");
        	Connection con=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\MAHESH KUMAR B\\Downloads\\SQLiteStudio-3.2.1\\mahi\\studentsdetails.db");
        	Statement st=con.createStatement();
            String query="Select * from qna_forum";
            ResultSet rs=st.executeQuery(query);
            
            while(rs.next()){
                user_name=rs.getString("user_name");
                name=rs.getString("name");
                msg_user=rs.getString("msg_send");
                UserMsg=UserMsg +" "+ name+" ("+user_name+") : "+msg_user+".\n\n";
            }
            tf1.setText(UserMsg);
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e+" Error Displaying Table");
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
    
    
    public static void main(String[] args) {
        new Assessment_frame(main_user_name, main_name);
    }
}
