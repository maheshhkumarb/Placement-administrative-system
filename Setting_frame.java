
package login;


import assessment.Assessment_frame;
import dashboard.Dashboard_frame;
import forum.Forum_frame;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import query.Query_frame;

public class Setting_frame extends JFrame implements MouseListener,ActionListener {
	//JPanel p1=new JPanel();
	//JPanel p2=new JPanel();
	
        JPanel settingpanel=new JPanel();
	JLabel Setting=new JLabel("Setting");
//	
        JLabel l2=new JLabel("Bootcamp");
	JLabel l3=new JLabel("Name");
	JLabel l4=new JLabel("Roll No");
	JLabel l5=new JLabel("Mobile No");
	JLabel l6=new JLabel("Password");
	JLabel l7=new JLabel("Confirm Password");
	JLabel l8=new JLabel("Invalid mobile no");
	JLabel l9=new JLabel("Invalid password");
	JLabel l10=new JLabel("Password match failed");
	JButton b1=new JButton("edit");
	JButton b2=new JButton("edit");
	JButton b3=new JButton("submit");
//	
        JButton b7=new JButton("Dashboard");
//	JButton b8=new JButton("Forum");
//	JButton b9=new JButton("Assessment");
//	JButton b10=new JButton("Admin");
//	JButton b11=new JButton("Setting");
//	JButton b12=new JButton("Log out");
	
        JTextField t1=new JTextField();
	JTextField t2=new JTextField();
	JTextField t3=new JTextField();
	JPasswordField password1=new JPasswordField();
	JPasswordField password2=new JPasswordField();
	JPanel navigationpanel=new JPanel();
	JPanel forumpanel=new JPanel();
	
        JLabel background=new JLabel(new ImageIcon(loadImage("/Image/Settings.jpg")));
        
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
	
        JLabel percentage=new JLabel("%");
	JLabel Bootcamp=new JLabel("Classroom");
	JLabel Forum=new JLabel("Forum");
	JLabel Line=new JLabel("_________________________________");
	
        JButton dashboardbtn=new JButton("Dashboard");
	JButton assessmentbtn=new JButton("Assessment");
	JButton forumbtn=new JButton("Forum");
	JButton querybtn=new JButton("Query");
	//JButton adminbtn=new JButton("Admin");
	JButton settingbtn=new JButton("Setting");
	JButton logoutbtn=new JButton("Logout");
	
        Color c1=new Color(58,64,82);
	Color c2=new Color(255,102,0);
	Border border=BorderFactory.createLineBorder(Color.black);
//	Color c1=new Color(0,116,217);
//	Color c2=new Color(255,102,0);
        JLabel main_user_name_disJLabel,main_name_disJLabel;
        
        static String main_user_name;
        static String main_name;
        
	public Setting_frame(String main_user_name,String main_name)
	{
            this.main_user_name=main_user_name;
            this.main_name=main_name;
            
            t1.setText(main_name);
            t2.setText(main_user_name);
            
            t1.setEditable(false);
            t2.setEditable(false);
            
            main_user_name_disJLabel=new JLabel(""+main_user_name+"");
            main_name_disJLabel=new JLabel(""+main_name+"");
            
		//p1.setBounds(5, 5, 250, 800);
		//p2.setBounds(258, 5, 727, 205);
		settingpanel.setBounds(270, 210, 700, 535);
		Setting.setBounds(270, 20, 150, 30);
//		l2.setBounds(10, 20, 250, 30);
		l3.setBounds(40, 30, 250, 30);
		l4.setBounds(40, 115, 250, 30);
		l5.setBounds(40, 220, 250, 20);
		l6.setBounds(40, 300, 250, 40);
		l7.setBounds(40, 390, 250, 40);
		l8.setBounds(40, 270, 300, 30);
		l9.setBounds(40, 370, 300, 30);
		l10.setBounds(40, 460, 300, 30);
		b1.setBounds(370, 245, 70, 30);
		b2.setBounds(370, 342, 70, 30);
		b3.setBounds(320, 475, 100, 30);
		
                user.setBounds(245, 40, 200,200);
        
                main_name_disJLabel.setBounds(450, 100, 200,50);
                main_user_name_disJLabel.setBounds(450, 150, 200,50);
                main_name_disJLabel.setForeground(Color.black);
                main_user_name_disJLabel.setForeground(Color.black);
                main_name_disJLabel.setFont(new Font("TimesRoman",Font.PLAIN,20));
                main_user_name_disJLabel.setFont(new Font("TimesRoman",Font.PLAIN,20));
                main_name_disJLabel.setForeground(Color.WHITE);
                main_user_name_disJLabel.setForeground(Color.WHITE);
                
		t1.setBounds(40, 70, 300, 30);
		t2.setBounds(40, 155, 300, 30);
		t3.setBounds(40, 245, 300, 30);
		password1.setBounds(40, 342, 300, 30);
		password2.setBounds(40, 430, 300, 30);
//		p1.setBackground(c1);
//	    p2.setBackground(c2);
	    Setting.setFont(new Font("TimesRoman",Font.BOLD,25));
//		l2.setFont(new Font("Verdana",Font.PLAIN,30));
		l3.setFont(new Font("Verdana",Font.PLAIN,15));
		l4.setFont(new Font("Verdana",Font.PLAIN,15));
		l5.setFont(new Font("Verdana",Font.PLAIN,15));
		l6.setFont(new Font("Verdana",Font.PLAIN,15));
		l7.setFont(new Font("Verdana",Font.PLAIN,15));
		//l7.setFont(new Font("Verdana",Font.PLAIN,15));
		Setting.setForeground(Color.white);
//		l2.setForeground(Color.white);
		l8.setForeground(Color.red);
		l9.setForeground(Color.red);
		l10.setForeground(Color.red);
		t1.setBorder(border);
		t2.setBorder(border);
		t3.setBorder(border);
		password1.setBorder(border);
		password2.setBorder(border);
		b1.setFont(new Font("Verdana",Font.PLAIN,15));
		b2.setFont(new Font("Verdana",Font.PLAIN,15));
		b3.setFont(new Font("Verdana",Font.PLAIN,15));
		
		b1.setBorderPainted(false);
		b2.setBorderPainted(false);
		b3.setBorderPainted(false);
		
		b1.setFocusPainted(false);
		b2.setFocusPainted(false);
		b3.setFocusPainted(false);
		
		
		b1.setForeground(Color.white);
		b2.setForeground(Color.white);
		b3.setForeground(Color.white);
		
                settingpanel.setBackground(Color.white);
                b1.setBackground(c1);
                b2.setBackground(c1);
                b3.setBackground(c1);
	    
//		add(l1);
//	    add(l2);
                navigationpanel.setBounds(10, 20, 250, 725);
                forumpanel.setBounds(270, 210, 700, 535);
		background.setBounds(0, 0, 1000, 210);
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
		dashboardbtn.setBounds(45, 80, 200,30);
		assessmentbtn.setBounds(45, 140, 200,30);
		forumbtn.setBounds(45, 200, 200,30);
		querybtn.setBounds(45, 260, 200,30);
		settingbtn.setBounds(45, 520, 200,30);
		logoutbtn.setBounds(45, 600, 200,30);
                Bootcamp.setBounds(10,10,150,30);
		Forum.setBounds(270,20,150,30);
		Line.setBounds(8, 430, 240,20);
                
		Bootcamp.setFont(new Font("TimesRoman",Font.PLAIN,25));
		Forum.setFont(new Font("TimesRoman",Font.PLAIN,25));
		dashboardbtn.setFont(new Font("TimesRoman",Font.PLAIN,20));
		assessmentbtn.setFont(new Font("TimesRoman",Font.PLAIN,20));
		forumbtn.setFont(new Font("TimesRoman",Font.PLAIN,20));
		querybtn.setFont(new Font("TimesRoman",Font.PLAIN,20));
		settingbtn.setFont(new Font("TimesRoman",Font.PLAIN,20));
		logoutbtn.setFont(new Font("TimesRoman",Font.PLAIN,20));
		
                Bootcamp.setForeground(Color.white);
		Forum.setForeground(Color.white);
		Line.setForeground(Color.white);
		navigationpanel.setBackground(c1);
		forumpanel.setBackground(Color.white);
		dashboardbtn.setBackground(c1);
		assessmentbtn.setBackground(c1);
		forumbtn.setBackground(c1);
		querybtn.setBackground(c1);
		settingbtn.setBackground(Color.WHITE);
		logoutbtn.setBackground(c1);
		dashboardbtn.setForeground(Color.white);
		assessmentbtn.setForeground(Color.white);
		forumbtn.setForeground(Color.white);
		querybtn.setForeground(Color.white);
		settingbtn.setForeground(c1);
		logoutbtn.setForeground(Color.white);
		
                dashboardbtn.setBorderPainted(false);
		assessmentbtn.setBorderPainted(false);
		forumbtn.setBorderPainted(false);
		querybtn.setBorderPainted(false);
		settingbtn.setBorderPainted(false);
		logoutbtn.setBorderPainted(false);
		dashboardbtn.setFocusPainted(false);
		assessmentbtn.setFocusPainted(false);
		forumbtn.setFocusPainted(false);
		querybtn.setFocusPainted(false);
		settingbtn.setFocusPainted(false);
		logoutbtn.setFocusPainted(false);
		
                navigationpanel.add(Bootcamp);
		navigationpanel.add(dashboard);
		navigationpanel.add(forum);
		navigationpanel.add(assessment);
		navigationpanel.add(query);
		navigationpanel.add(setting);
		navigationpanel.add(logout);
		navigationpanel.add(dashboard1);
		navigationpanel.add(forum1);
		navigationpanel.add(assessment1);
		navigationpanel.add(query1);
		navigationpanel.add(setting1);
		navigationpanel.add(logout1);
		navigationpanel.add(Line);
		navigationpanel.add(dashboardbtn);
		navigationpanel.add(assessmentbtn);
		navigationpanel.add(forumbtn);
		navigationpanel.add(querybtn);
		navigationpanel.add(settingbtn);
		navigationpanel.add(logoutbtn);
		
                dashboard.setVisible(false);
		assessment.setVisible(false);
		forum.setVisible(false);
		query.setVisible(false);
		setting.setVisible(false);
		logout.setVisible(false);
                
		dashboardbtn.addMouseListener(this);
		assessmentbtn.addMouseListener(this);
		forumbtn.addMouseListener(this);
		querybtn.addMouseListener(this);
		settingbtn.addMouseListener(this);
		logoutbtn.addMouseListener(this);
		
                navigationpanel.setLayout(null);
		forumpanel.setLayout(null);
		
                settingpanel.add(l3);
		settingpanel.add(l4);
		settingpanel.add(l5);
		settingpanel.add(l6);
		settingpanel.add(l7);
		settingpanel.add(l8);
		settingpanel.add(l9);
		settingpanel.add(l10);
		settingpanel.add(t1);
		settingpanel.add(t2);
		settingpanel.add(t3);
		settingpanel.add(b1);
		settingpanel.add(b2);
		settingpanel.add(b3);
		settingpanel.add(password1);
		settingpanel.add(password2);

                settingpanel.setLayout(null);
                
                get_values();
                
                l8.setVisible(false);
	    l9.setVisible(false);
	    l10.setVisible(false);
            add(user);
	    add(navigationpanel);
		add(settingpanel);
		add(Setting);
                add(main_name_disJLabel);
                add(main_user_name_disJLabel);
		add(background);
	    //add(settingpanel);
            
            setting.setVisible(true);
            setting1.setVisible(false);
            
	    b1.addActionListener(this);
	    b2.addActionListener(this);
	    b3.addActionListener(this);
//	    b7.addMouseListener(this);
//	    b8.addMouseListener(this);
//	    b9.addMouseListener(this);
//	    b10.addMouseListener(this);
//	    b11.addMouseListener(this);
//	    b12.addMouseListener(this);
	    this.getContentPane().setBackground(Color.white);
	    setSize(1000,800);
	    setLocationRelativeTo(null);
	    setLayout(null);
            
            logoutbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                logoutbtn.setBackground(Color.white);
                settingbtn.setBackground(c1);
            
                logoutbtn.setForeground(Color.black);
                settingbtn.setForeground(Color.white);

                logout.setVisible(true);
                setting.setVisible(false);

                logout1.setVisible(false);
                setting1.setVisible(true);
                
                int a=JOptionPane.showConfirmDialog(new JFrame(),"Are you sure?");  

                if(a==JOptionPane.YES_OPTION){  
                    dispose();
                    new Logins();
                } 
                else{
                    settingbtn.setBackground(Color.white);
                    logoutbtn.setBackground(c1);

                    settingbtn.setForeground(Color.black);
                    logoutbtn.setForeground(Color.white);

                    setting.setVisible(true);
                    logout.setVisible(false);

                    setting1.setVisible(false);
                    logout1.setVisible(true);
                }
            }});
            
	    addWindowListener(new WindowAdapter() {
                    public void windowClosing(WindowEvent e) {  
                        int a=JOptionPane.showConfirmDialog(new JFrame(),"Are you sure?");  
                        if(a==JOptionPane.YES_OPTION){  
                            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
                        } 
                    }
                });
                setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	    
                setVisible(true);
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Setting_frame(main_user_name, main_name);
                
	}
	
        void get_values(){
     //       final String Driver="oracle.jdbc.driver.OracleDriver";
     //       final String connect="jdbc:oracle:thin:@127.0.0.1:1521:XE";
            try {
       //         Class.forName(Driver);
         //       Connection con2=DriverManager.getConnection(connect,"bootathon","admin");
            	Connection con2=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\MAHESH KUMAR B\\Downloads\\SQLiteStudio-3.2.1\\mahi\\studentsdetails.db");
            	Statement st2=con2.createStatement();
                String sql="select * from registers";
                ResultSet rs=st2.executeQuery(sql);
                while(rs.next()){
                    if(main_user_name.equals(rs.getString("rollno"))){
                        t3.setText(rs.getString("mobileno"));
                        password1.setText(rs.getString("password"));
			password2.setText(rs.getString("password"));
                        t3.setEditable(false);
                        password1.setEditable(false);
                        password2.setEditable(false);
                        break;
                    }
                }
            } 
            catch (Exception e1) {
                System.out.println(e1);
            }
        }
        
        @Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==b1)
		{
			t3.setText("");
                        t3.setEditable(true);
		}
		if(e.getSource()==b2)
		{
			password1.setText("");
			password2.setText("");
                        password1.setEditable(true);
                        password2.setEditable(true);
		}
		if(e.getSource()==b3)
		{
			String mobileno=t3.getText();
			String password=new String(password1.getPassword());
			String repassword=new String(password2.getPassword());
			
			if(validation.isValidPhno(mobileno)==true && validation.isValidPassword(password)==true && password.equals(repassword))
			{
                            l8.setVisible(false);
			    l9.setVisible(false);
			    l10.setVisible(false);
                          //  final String Driver="oracle.jdbc.driver.OracleDriver";
                          //  final String connect="jdbc:oracle:thin:@127.0.0.1:1521:XE";
                            try {
                            //    Class.forName(Driver);
                              //  Connection con2=DriverManager.getConnection(connect,"bootathon","admin");
                            	Connection con2=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\MAHESH KUMAR B\\Downloads\\SQLiteStudio-3.2.1\\mahi\\studentsdetails.db");
                            	Statement st2=con2.createStatement();
                                String sql="update registers set password='"+password+"', mobileno='"+mobileno+"' where rollno='"+main_user_name+"'";
                                st2.executeUpdate(sql);
                                con2.getAutoCommit();
                                JOptionPane.showMessageDialog(new JFrame(),"Updated Successfully");
                                t3.setEditable(false);
                                password1.setEditable(false);
                                password2.setEditable(false);
                                con2.close();
                            } 
                            catch (Exception e1) {
                                System.out.println(e1);
                            }
			}
                        
                        else{
                            if(validation.isValidPhno(mobileno)==false)
                            {
				l8.setVisible(true);
                            }
                            if(validation.isValidPassword(password)==false )
                            {
                                l9.setVisible(true);
                            }
                            if(!password.equals(repassword))
                            {
                                l10.setVisible(true);
                            }
                            if(validation.isValidPhno(mobileno)==true)
                            {
				l8.setVisible(false);
                            }
                            if(validation.isValidPassword(password)==true)
                            {
                                l9.setVisible(false);
                            }
                            else if(password.equals(repassword))
                            {
                                l10.setVisible(true);
                            }
                        }
		}
		
	}
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getSource()==dashboardbtn)
		{
			dashboardbtn.setBackground(Color.white);
                        settingbtn.setBackground(c1);

                        dashboardbtn.setForeground(Color.black);
                        settingbtn.setForeground(Color.white);

                        dashboard.setVisible(true);
                        setting.setVisible(false);

                        dashboard1.setVisible(false);
                        setting1.setVisible(true);
                        dispose();
                        new Dashboard_frame(main_user_name, main_name);

			
		}
		if(e.getSource()==assessmentbtn)
		{
		
                    assessmentbtn.setBackground(Color.white);
                    settingbtn.setBackground(c1);

                    assessmentbtn.setForeground(Color.black);
                    settingbtn.setForeground(Color.white);

                    assessment.setVisible(true);
                    setting.setVisible(false);

                    assessment1.setVisible(false);
                    setting1.setVisible(true);

                    dispose();
                    new Assessment_frame(main_user_name, main_name);

		}
		if(e.getSource()==forumbtn)
		{
                    forumbtn.setBackground(Color.white);
                    settingbtn.setBackground(c1);

                    forumbtn.setForeground(Color.black);
                    settingbtn.setForeground(Color.white);

                    forum.setVisible(true);
                    setting.setVisible(false);

                    forum1.setVisible(false);
                    setting1.setVisible(true);

                    dispose();
                    new Forum_frame(main_user_name, main_name).StartThread();

		}
		if(e.getSource()==querybtn)
		{
                    querybtn.setBackground(Color.white);
                    settingbtn.setBackground(c1);

                    querybtn.setForeground(Color.black);
                    settingbtn.setForeground(Color.white);

                    query.setVisible(true);
                    setting.setVisible(false);

                    query1.setVisible(false);
                    setting1.setVisible(true);

                    dispose();
                    new Query_frame(main_user_name, main_name).StartThread();

		}
		
		
	}
		
		
	
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	/*@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}*/


}



