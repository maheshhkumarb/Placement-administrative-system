
package dashboard;



import assessment.Assessment_frame;
import forum.Forum_frame;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import login.Logins;
import login.Setting_frame;
import query.Query_frame;



public class Dashboard_frame extends JFrame implements ActionListener,MouseListener {
	String inboxdb="";
	int inboxc=0;
	int announcementcount=0;
	int updateannouncementcount=0;
	int inboxco=0;
	int assessment_count=0;
	String rankno="";
	int average_count=0;
	int rank_count=0;
        int column=0;
        int test[]=new int[100];
	String inboxcou;
	static String main_name;
	static String main_user_name;
        
     //   final String Driver="oracle.jdbc.driver.OracleDriver";
     //   final String connect="jdbc:oracle:thin:@127.0.0.1:1521:XE";
        
	JPanel navigationpanel=new JPanel();
	JPanel dashboardpanel=new JPanel();
        JPanel p3;
	JLabel background=new JLabel(new ImageIcon(loadImage("/Image/Dashboard_1.jpg")));
    
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

        JLabel progress_bar;
	JLabel averagecount_display;
	JLabel percentage=new JLabel("%");
	JLabel Bootcamp=new JLabel("Classroom");
	JLabel Dashboard=new JLabel("Dashboard");
	JLabel Line=new JLabel("__________________________________");
	JLabel mainname_display;
	JLabel username_display;
	JLabel inbox=new JLabel("Inbox");
	JLabel inboxcount;
	JLabel assessmentdisplay=new JLabel("Assessment");
	JLabel assessmentcount;
	JLabel rank=new JLabel("Rank");
	JLabel rankcount;
	JLabel band=new JLabel("Band");
	JLabel bandcount;
        JLabel lx=new JLabel("Performance Analysis :");
	JButton dashboardbtn=new JButton("Dashboard");
	JButton assessmentbtn=new JButton("Assessment");
	JButton forumbtn=new JButton("Forum");
	JButton querybtn=new JButton("Query");
	//JButton adminbtn=new JButton("Admin");
	JButton settingbtn=new JButton("Setting");
	JButton logoutbtn=new JButton("Logout");
	Color c1=new Color(58,64,82);
	Color c2=new Color(255,102,0);
	
        public Dashboard_frame(String main_user_name,String main_name)
	{
            p3 = new RoundedPanel(100,Color.GRAY);
            this.main_name=main_name;
            this.main_user_name=main_user_name;
            
            navigationpanel.setBounds(10, 20, 250, 725);
            dashboardpanel.setBounds(270, 225, 700, 520);
            
            background.setBounds(0, 0, 1000, 210);
            dashboard.setBounds(5, 80, 30,30);
            assessment.setBounds(10, 140, 30,30);
            forum.setBounds(10, 200, 30,30);
            query.setBounds(10, 260, 30,30);
            setting.setBounds(10, 520, 30,30);
            user.setBounds(245, 40, 200,200);
            logout.setBounds(10, 600, 30,30);
            
            dashboard1.setBounds(5, 80, 30,30);
            assessment1.setBounds(10, 140, 30,30);
            forum1.setBounds(10, 200, 30,30);
            query1.setBounds(10, 260, 30,30);
            setting1.setBounds(10, 520, 30,30);
            logout1.setBounds(10, 600, 30,30);
            
            user.setBounds(245, 40, 200,200);
            
            dashboardbtn.setBounds(45, 80, 200,30);
            assessmentbtn.setBounds(45, 140, 200,30);
            forumbtn.setBounds(45, 200, 200,30);
            querybtn.setBounds(45, 260, 200,30);
            settingbtn.setBounds(45, 520, 200,30);
            logoutbtn.setBounds(45, 600, 200,30);
                                              
            Bootcamp.setBounds(10,10,150,30);
            Dashboard.setBounds(270,20,150,30);
            Line.setBounds(8, 430, 250,20);
            
            Bootcamp.setFont(new Font("TimesRoman",Font.PLAIN,25));
            Dashboard.setFont(new Font("TimesRoman",Font.BOLD,25));
            
            inbox.setFont(new Font("TimesRoman",Font.PLAIN,23));
            assessmentdisplay.setFont(new Font("TimesRoman",Font.PLAIN,23));
            rank.setFont(new Font("TimesRoman",Font.PLAIN,23));
            band.setFont(new Font("TimesRoman",Font.PLAIN,23));
            lx.setFont(new Font("TimesRoman",Font.PLAIN,22));
            
            dashboardbtn.setFont(new Font("TimesRoman",Font.PLAIN,20));
            assessmentbtn.setFont(new Font("TimesRoman",Font.PLAIN,20));
            forumbtn.setFont(new Font("TimesRoman",Font.PLAIN,20));
            querybtn.setFont(new Font("TimesRoman",Font.PLAIN,20));
            settingbtn.setFont(new Font("TimesRoman",Font.PLAIN,20));
            logoutbtn.setFont(new Font("TimesRoman",Font.PLAIN,20));
            
            Bootcamp.setForeground(Color.white);
            Dashboard.setForeground(Color.white);
            
            inbox.setForeground(Color.WHITE);
            assessmentdisplay.setForeground(Color.white);
            rank.setForeground(Color.white);
            band.setForeground(Color.white);
            lx.setForeground(c1);
            
            Line.setForeground(Color.white);
            navigationpanel.setBackground(c1);
            dashboardpanel.setBackground(Color.white);
            dashboardbtn.setBackground(Color.WHITE);
            assessmentbtn.setBackground(c1);
            forumbtn.setBackground(c1);
            querybtn.setBackground(c1);
            settingbtn.setBackground(c1);
            logoutbtn.setBackground(c1);
            
            dashboardbtn.setForeground(c1);
            assessmentbtn.setForeground(Color.white);
            forumbtn.setForeground(Color.white);
            querybtn.setForeground(Color.white);
            settingbtn.setForeground(Color.white);
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
            dashboardpanel.add(inbox);
            
            dashboardpanel.add(assessmentdisplay);
            dashboardpanel.add(rank);
            dashboardpanel.add(band);
            
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
            dashboardpanel.setLayout(null);
            
            try{
     //           Class.forName(Driver);
       //         Connection con=DriverManager.getConnection(connect,"bootathon","admin");
            	Connection con=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\MAHESH KUMAR B\\Downloads\\SQLiteStudio-3.2.1\\mahi\\studentsdetails.db");
            	Statement st=con.createStatement();
		String query="select count(*) from admin_forum";
	        ResultSet rs=st.executeQuery(query);
	        rs.next();
	        announcementcount=rs.getInt("count(*)");
	        con.close();
		}
		catch(Exception a)
		{
			System.out.print(a+"0");
		}
	    try
	    {
          //      Class.forName(Driver);
            //    Connection con=DriverManager.getConnection(connect,"bootathon","admin");
	    	Connection con=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\MAHESH KUMAR B\\Downloads\\SQLiteStudio-3.2.1\\mahi\\studentsdetails.db");    
	    	Statement st=con.createStatement();
		String query="select * from registers";
		ResultSet rs=st.executeQuery(query);
		while(rs.next())
		{
                    if(rs.getString("rollno").equals(main_user_name))
                    {
                        inboxc=rs.getInt("index_count");
                        break;
                    }
                }
                con.close();
	    }
	    catch(Exception a)
	    {
	    	System.out.print(a+"1");
	    }
	    try{
        //        Class.forName(Driver);
          //      Connection con=DriverManager.getConnection(connect,"bootathon","admin");
	    	Connection con=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\MAHESH KUMAR B\\Downloads\\SQLiteStudio-3.2.1\\mahi\\studentsdetails.db");	
	    	Statement st=con.createStatement();
		String query="select count(*) from test_details";
	        ResultSet rs=st.executeQuery(query);
	        rs.next();
	        assessment_count=rs.getInt("count(*)");
	        con.close();
            }
            catch(Exception a)
            {
                System.out.print(a+"2");
            }
	    try
            {
            //    Class.forName(Driver);
              //  Connection con=DriverManager.getConnection(connect,"bootathon","admin");
	    	Connection con=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\MAHESH KUMAR B\\Downloads\\SQLiteStudio-3.2.1\\mahi\\studentsdetails.db");
	    	Statement st=con.createStatement();
		String query="select * from student_results order by average desc";
	        ResultSet rs=st.executeQuery(query);
                ResultSetMetaData rsmd=rs.getMetaData(); 
                column =rsmd.getColumnCount()-3;
                
	        rank_count=1;
	        while(rs.next())
	        {
                    if(rs.getString("user_name").equals(main_user_name))
                    {
                        for (int i = 1; i <= column; i++) {
                            average_count+=rs.getInt("test"+i);
                            
                        }
                        average_count=average_count/column;
                        break;
                    }
                    rank_count++;
	        }
	        con.close();
            }
            catch(Exception a)
            {
                System.out.print(a+"3");
            }
	    inboxco=announcementcount-inboxc;
	    inboxcou=String.valueOf(inboxco);
	    
            image();
	    
            p3.setBounds(20, 10, 660, 210);
            p3.setBackground(Color.WHITE);
            
            inbox.setBounds(60, 100, 155, 100);
            assessmentdisplay.setBounds(215, 100, 155, 100);
            rank.setBounds(425, 100, 155, 100);
            band.setBounds(585, 100, 155, 100);
            
	    inboxcount=new JLabel(""+inboxcou+"");
	    mainname_display=new JLabel(""+main_name+"");
	    username_display=new JLabel(""+main_user_name+"");
	    assessmentcount=new JLabel(""+assessment_count+"");
	    rankcount=new JLabel(""+rank_count+"");
            
	    inboxcount.setBounds(71, 30, 155, 100);
	    assessmentcount.setBounds(260, 30, 155, 100);
	    rankcount.setBounds(435, 30, 155, 100);
	    bandcount.setBounds(590, 30, 155, 100);
	    progress_bar.setBounds(200, 270, 250, 250);
	    averagecount_display.setBounds(290, 315, 100, 150);
	    percentage.setBounds(370, 350, 100, 100);
            lx.setBounds(30, 230,300,30);
            
            rankcount.setForeground(Color.BLACK);
            averagecount_display.setForeground(Color.BLACK);
            percentage.setForeground(Color.BLACK);

            mainname_display.setBounds(450, 100, 200,50);
            username_display.setBounds(450, 150, 200,50);
            mainname_display.setForeground(Color.black);
            username_display.setForeground(Color.black);
            mainname_display.setFont(new Font("TimesRoman",Font.PLAIN,20));
            username_display.setFont(new Font("TimesRoman",Font.PLAIN,20));
            username_display.setForeground(Color.WHITE);
            mainname_display.setForeground(Color.WHITE);
            inboxcount.setFont(new Font("Verdana",Font.PLAIN,40));
            assessmentcount.setFont(new Font("Verdana",Font.PLAIN,40));
            rankcount.setFont(new Font("Verdana",Font.PLAIN,40));
            bandcount.setFont(new Font("Verdana",Font.PLAIN,40));
            averagecount_display.setFont(new Font("Verdana",Font.PLAIN,55));
            percentage.setFont(new Font("Verdana",Font.PLAIN,25));
            
            if(inboxco==0){
                inboxcount.setForeground(Color.BLACK);
            }
            else{
                inboxcount.setForeground(Color.cyan);
            }
            if(assessment_count==0){
                assessmentcount.setForeground(Color.BLACK);
            }
            else{
                assessmentcount.setForeground(Color.cyan);
            }
            dashboardpanel.add(inboxcount);
            dashboardpanel.add(assessmentcount);
            dashboardpanel.add(rankcount);
            dashboardpanel.add(bandcount);
            dashboardpanel.add(averagecount_display);
            dashboardpanel.add(percentage);
            dashboardpanel.add(progress_bar);
            dashboardpanel.add(p3);
            dashboardpanel.add(lx);
            add(mainname_display);
            add(username_display);
            add(navigationpanel);
            add(dashboardpanel);
            add(user);
            add(Dashboard);
            add(background);
            
            dashboard.setVisible(true);
            dashboard1.setVisible(false);
            
            this.getContentPane().setBackground(Color.white);
	    setSize(1000,800);
	    setLocationRelativeTo(null);
	    setLayout(null);
	    logoutbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                logoutbtn.setBackground(Color.white);
                dashboardbtn.setBackground(c1);
            
                logoutbtn.setForeground(Color.black);
                dashboardbtn.setForeground(Color.white);

                logout.setVisible(true);
                dashboard.setVisible(false);

                logout1.setVisible(false);
                dashboard1.setVisible(true);
                
                int a=JOptionPane.showConfirmDialog(new JFrame(),"Are you sure?");  

                if(a==JOptionPane.YES_OPTION){  
                    dispose();
                    new Logins();
                } 
                else{
                    dashboardbtn.setBackground(Color.white);
                    logoutbtn.setBackground(c1);

                    dashboardbtn.setForeground(Color.black);
                    logoutbtn.setForeground(Color.white);

                    dashboard.setVisible(true);
                    logout.setVisible(false);

                    dashboard.setVisible(false);
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
        
        void image(){
            if(average_count>90)
	    {
	    	bandcount=new JLabel("A");
                bandcount.setForeground(new Color(128,255,0));
                
	    }
	    else if(average_count<90 && average_count>80)
	    {
	    	bandcount=new JLabel("B");
                bandcount.setForeground(Color.cyan);
	    }
	    else if(average_count<80 && average_count>50)
	    {
	    	bandcount=new JLabel("C");
                bandcount.setForeground(Color.ORANGE);
	    }
	    else if(average_count<50 && average_count>30)
	    {
	    	bandcount=new JLabel("D");
                bandcount.setForeground(Color.RED);
	    }
	    else
	    {
	    	bandcount=new JLabel("-");
                bandcount.setForeground(Color.RED);
	    }
	    if(average_count==100)
	    {
	    	progress_bar=new JLabel(new ImageIcon(loadImage("/Image/progress_bar_100.png")));
	    	averagecount_display=new JLabel(""+average_count+"");
	    }
	    else if(average_count<100 && average_count>90)
	    {
	    	progress_bar=new JLabel(new ImageIcon(loadImage("/Image/progress_bar_90.png")));
	    	averagecount_display=new JLabel(""+average_count+"");
	    }
	    else if(average_count<=90 && average_count>80)
	    {
	    	progress_bar=new JLabel(new ImageIcon(loadImage("/Image/progress_bar_80.png")));
	    	averagecount_display=new JLabel(""+average_count+"");
	    }
	    else if(average_count<=80 && average_count>70)
	    {
	    	progress_bar=new JLabel(new ImageIcon(loadImage("/Image/progress_bar_70.png")));
	    	averagecount_display=new JLabel(""+average_count+"");
	    }
	    else if(average_count<=70 && average_count>60)
	    {
	    	progress_bar=new JLabel(new ImageIcon(loadImage("/Image/progress_bar_60.png")));
	    	averagecount_display=new JLabel(""+average_count+"");
	    }
	    else if(average_count<=60 && average_count>50)
	    {
	    	progress_bar=new JLabel(new ImageIcon(loadImage("/Image/progress_bar_50.png")));
	    	averagecount_display=new JLabel(""+average_count+"");
	    }
	    else if(average_count<=50 && average_count>40)
	    {
	    	progress_bar=new JLabel(new ImageIcon(loadImage("/Image/progress_bar_40.png")));
	    	averagecount_display=new JLabel(""+average_count+"");
	    }
	    else if(average_count<=40 && average_count>30)
	    {
	    	progress_bar=new JLabel(new ImageIcon(loadImage("/Image/progress_bar_30.png")));
	    	averagecount_display=new JLabel(""+average_count+"");
	    }
	    else if(average_count<=30 && average_count>20)
	    {
	    	progress_bar=new JLabel(new ImageIcon(loadImage("/Image/progress_bar_20.png")));
	    	averagecount_display=new JLabel(""+average_count+"");
	    }
	    else if(average_count<=20 && average_count>10)
	    {
	    	progress_bar=new JLabel(new ImageIcon(loadImage("/Image/progress_bar_10.png")));
	    	averagecount_display=new JLabel(""+average_count+"");
	    }
	    else if(average_count<=5)
	    {
	    	progress_bar=new JLabel(new ImageIcon(loadImage("/Image/progress_bar_5.png")));
	    	averagecount_display=new JLabel(""+average_count+"");
	    }
        }
        
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		
		if(e.getSource()==assessmentbtn)
		{
			assessmentbtn.setBackground(Color.white);
                    dashboardbtn.setBackground(c1);

                    assessmentbtn.setForeground(Color.black);
                    dashboardbtn.setForeground(Color.white);

                    assessment.setVisible(true);
                    dashboard.setVisible(false);

                    assessment1.setVisible(false);
                    dashboard1.setVisible(true);

                    dispose();
                    new Assessment_frame(main_user_name, main_name);
			
		}
		if(e.getSource()==forumbtn)
		{
                    forumbtn.setBackground(Color.white);
                    dashboardbtn.setBackground(c1);

                    forumbtn.setForeground(Color.black);
                    dashboardbtn.setForeground(Color.white);

                    forum.setVisible(true);
                    dashboard.setVisible(false);

                    forum1.setVisible(false);
                    dashboard1.setVisible(true);

                    dispose();
                    new Forum_frame(main_user_name, main_name).StartThread();
		}
		if(e.getSource()==querybtn)
		{
                    querybtn.setBackground(Color.white);
                    settingbtn.setBackground(c1);

                    querybtn.setForeground(Color.black);
                    dashboardbtn.setForeground(Color.white);

                    query.setVisible(true);
                    dashboard.setVisible(false);

                    query1.setVisible(false);
                    dashboard1.setVisible(true);

                    dispose();
                    new Query_frame(main_user_name, main_name).StartThread();
			
		}
		if(e.getSource()==settingbtn)
		{
                    settingbtn.setBackground(Color.white);
                    dashboardbtn.setBackground(c1);

                    settingbtn.setForeground(Color.black);
                    dashboardbtn.setForeground(Color.white);

                    setting.setVisible(true);
                    dashboard.setVisible(false);

                    setting1.setVisible(false);
                    dashboard1.setVisible(true);

                    dispose();
                    new Setting_frame(main_user_name, main_name);
			
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
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

        public static void main(String[] args) {
            new Dashboard_frame(main_user_name, main_name);
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
        
        class RoundedPanel extends JPanel{
        private Color backgroundColor;
        private int cornerRadius = 15;
        public RoundedPanel(LayoutManager layout, int radius) {
            super(layout);
            cornerRadius = radius;
        }
        public RoundedPanel(LayoutManager layout, int radius, Color bgColor) {
            super(layout);
            cornerRadius = radius;
            backgroundColor = bgColor;
        }
        public RoundedPanel(int radius) {
            super();
            cornerRadius = radius;
            
        }
        public RoundedPanel(int radius, Color bgColor) {
            super();
            cornerRadius = radius;
            backgroundColor = bgColor;
        }
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Dimension arcs = new Dimension(cornerRadius, cornerRadius);
            int width = getWidth();
            int height = getHeight();
            Graphics2D graphics = (Graphics2D) g;
            graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            //Draws the rounded panel with borders.
            if (backgroundColor != null) {
                graphics.setColor(backgroundColor);
            } else {
                graphics.setColor(getBackground());
            }
            graphics.fillRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height); //paint background
            graphics.setColor(getForeground());
//            graphics.drawRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height); //paint border
//            
        }
    }
}


