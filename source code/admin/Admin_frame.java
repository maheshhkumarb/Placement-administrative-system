/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

/**
 *
 * @author kumar
 * 
 */

import java.sql.*;
import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.table.*;
import login.Logins;
import login.validation;
public class Admin_frame extends JFrame implements ActionListener,MouseListener, Runnable{
	
        String main_user_name;
        String main_name;
        String username;
	String msg_send;
	String msg_get;
	String name;
	String message;
	Thread thread=new Thread();
	String spin1;
	String spin2;
	String spin3;
	String spin4;
	String spin5;
	String spin6;
	String spin7;
	String spin8;
	JPanel p1=new JPanel();
	JPanel p3=new JPanel();
	JPanel p4=new JPanel();
	JPanel p5=new JPanel();
	JPanel p6=new JPanel();
	JPanel p7=new JPanel();
        
	ArrayList<String> al;
        JLabel lx1=new JLabel("Students Details :");
        JLabel lx2=new JLabel("Announcement :");
        JLabel lx3=new JLabel("Assign Test Details :");
        JLabel lx4=new JLabel("Result Details :");
        JLabel lx5=new JLabel("All the Query :");
        JLabel lx6=new JLabel("Remove Student :");
        JLabel lx7=new JLabel("Enter Roll No. :");
        JLabel lx8=new JLabel("Enter Valid Roll No.");
        
        JLabel lx=new JLabel("Test Assigned Successfully");
        
	JLabel l1=new JLabel("Classroom");
	JLabel l2=new JLabel("Admin");
	JLabel l3=new JLabel();
	JLabel l4=new JLabel("Start Date : ");
	JLabel l5=new JLabel("Start time : ");
	JLabel l6=new JLabel("End date   : ");
	JLabel l7=new JLabel("End time   : ");
	JLabel l8=new JLabel("Test Link  : ");
//	JLabel l9=new JLabel("Results : ");
	JLabel l10=new JLabel("Enter the test values for all students : ");
        
        JLabel main_user_name_disJLabel,main_name_disJLabel;
    
        JLabel Line=new JLabel("_________________________________");

        JLabel background=new JLabel(new ImageIcon(loadImage("/Image/Admin.jpg")));

        JLabel user=new JLabel(new ImageIcon(loadImage("/Image/user.png")));

        JLabel forum=new JLabel(new ImageIcon(loadImage("/Image/conversation (1).png")));
	JLabel assessment=new JLabel(new ImageIcon(loadImage("/Image/book (1).png")));
	JLabel admin=new JLabel(new ImageIcon(loadImage("/Image/shield (1).png")));
	JLabel logout=new JLabel(new ImageIcon(loadImage("/Image/logout (1).png")));
	
        JLabel forum1=new JLabel(new ImageIcon(loadImage("/Image/conversation.png")));
	JLabel assessment1=new JLabel(new ImageIcon(loadImage("/Image/book.png")));
	JLabel admin1=new JLabel(new ImageIcon(loadImage("/Image/shield.png")));
	JLabel logout1=new JLabel(new ImageIcon(loadImage("/Image/logout (2).png")));
	
        SpinnerModel sm1=new SpinnerNumberModel(15,01,31,1);
	SpinnerModel sm2=new SpinnerNumberModel(06,01,12,1);
	String[] year= {"2020","2021","2022","2023","2024","2025"};
	JComboBox<String> cb1=new JComboBox<String>(year);
	SpinnerModel sm5=new SpinnerNumberModel(15,01,31,1);
	SpinnerModel sm6=new SpinnerNumberModel(06,01,12,1);
	String[] year1= {"2020","2021","2022","2023","2024","2025"};
	JComboBox<String> cb3=new JComboBox<String>(year1);
	SpinnerModel sm3=new SpinnerNumberModel(6,1,12,1);
	SpinnerModel sm4=new SpinnerNumberModel(30,1,60,1);
	SpinnerModel sm7=new SpinnerNumberModel(6,1,12,1);
	SpinnerModel sm8=new SpinnerNumberModel(30,1,60,1);
	String[] time1= {"AM","PM"};
	String[] time= {"AM","PM"};
        
	JComboBox<String> cb2=new JComboBox<String>(time);
	JComboBox<String> cb4=new JComboBox<String>(time1);
	
        JSpinner spinner1=new JSpinner(sm1);
	JSpinner spinner2=new JSpinner(sm2);
	JSpinner spinner3=new JSpinner(sm3);
	JSpinner spinner4=new JSpinner(sm4);
	JSpinner spinner5=new JSpinner(sm5);
	JSpinner spinner6=new JSpinner(sm6);
	JSpinner spinner7=new JSpinner(sm7);
	JSpinner spinner8=new JSpinner(sm8);
	
        JButton b1=new JButton("Student Details");
	JButton b2=new JButton("Announcements");
	JButton b3=new JButton("Assigning Test");
	JButton b4=new JButton("Post Results");
	JButton b5=new JButton("Queries");
        
	JButton b6=new JButton("send");
        
	JButton b7=new JButton("Admin");
	JButton b8=new JButton("Assessment");
	JButton b9=new JButton("Forum");
	JButton b10=new JButton("Logout");
        
        JButton b11=new JButton("Delete");
	JButton b13=new JButton("Assign Test");
	JButton b14=new JButton("Upload");
	JTable t1=new JTable();
	JTable t2=new JTable();
	
        JTextField tf1=new JTextField();
	JTextField tf2=new JTextField();
        JTextField tf3=new JTextField();
	JTextArea ta1=new JTextArea();
	JTextArea textarea=new JTextArea();
	JTextArea textarea1=new JTextArea();
        
        JScrollPane sp1=new JScrollPane(t1);
	JScrollPane sp2=new JScrollPane(textarea);
	JScrollPane sp3=new JScrollPane(ta1);
	JScrollPane sp4=new JScrollPane(t2);
	JScrollPane sp5=new JScrollPane(textarea1);
        
	Border border=BorderFactory.createLineBorder(Color.black);
	
        Color c1=new Color(58,64,82);
	Color c3=new Color(255,255,255);
        
        int column=0;
        
  //      final String Driver="oracle.jdbc.driver.OracleDriver";
   //     final String connect="jdbc:oracle:thin:@127.0.0.1:1521:XE";
        
	public Admin_frame(String main_user_name,String main_name)
	{
            this.main_user_name="Ashwinth";
            this.main_name=main_name;
            al=new ArrayList<String>();

            main_user_name_disJLabel=new JLabel(""+main_user_name+"");
            main_name_disJLabel=new JLabel(""+main_name+"");

            user.setBounds(245, 40, 200,200);

            main_name_disJLabel.setBounds(450, 100, 200,50);
            main_user_name_disJLabel.setBounds(450, 150, 200,50);
            main_name_disJLabel.setForeground(Color.black);
            main_user_name_disJLabel.setForeground(Color.black);
            main_name_disJLabel.setFont(new Font("TimesRoman",Font.PLAIN,20));
            main_user_name_disJLabel.setFont(new Font("TimesRoman",Font.PLAIN,20));
            main_name_disJLabel.setForeground(Color.WHITE);
            main_user_name_disJLabel.setForeground(Color.WHITE);

            p1.setBounds(10, 20, 250, 725);
            p3.setBounds(270, 230, 700, 515);
            p4.setBounds(270, 230, 700, 515);
            p5.setBounds(270, 230, 700, 515);
            p6.setBounds(270, 230, 700, 515);
            p7.setBounds(270, 230, 700, 515);

            l1.setBounds(10,10,150,30);
            l2.setBounds(270,20,150,30);

            l3.setBounds(50, 30, 100, 40);
            l4.setBounds(50, 70, 100, 40);
            l5.setBounds(50, 110, 100, 40);
            l6.setBounds(50, 155, 100, 40);
            l7.setBounds(50, 200, 100, 40);
            l8.setBounds(50, 250, 100, 40);
//            l9.setBounds(10, 20, 100, 40);
            l10.setBounds(10, 300, 350, 40);
            
            lx1.setBounds(5, 10, 400, 30);
            lx2.setBounds(5, 10, 400, 30);
            lx3.setBounds(5, 10, 400, 30);
            lx4.setBounds(5, 10, 400, 30);
            lx5.setBounds(5, 10, 400, 30);

            lx.setBounds(50, 350, 400, 40);
            
            b1.setBounds(258, 205, 145, 30);
            b2.setBounds(403, 205, 145, 30);
            b3.setBounds(548, 205, 145, 30);
            b4.setBounds(693, 205, 145, 30);
            b5.setBounds(838, 205, 147, 30);

            b7.setBounds(45, 80, 200,30);
            b8.setBounds(45, 140, 200,30);
            b9.setBounds(45, 200, 200,30);
            b10.setBounds(45, 600, 200,30);

            b11.setBounds(400, 435, 220, 30);
            b13.setBounds(180, 310, 220, 30);

            assessment.setBounds(10, 140, 30,30);
            forum.setBounds(10, 200, 30,30); 
            admin.setBounds(10, 80, 30,30);
            logout.setBounds(10, 600, 30,30);

            assessment1.setBounds(10, 140, 30,30);
            forum1.setBounds(10, 200, 30,30); 
            admin1.setBounds(10, 80, 30,30);
            logout1.setBounds(10, 600, 30,30);
            
            sp1.setBounds(10, 50, 690, 355);
            sp2.setBounds(30, 70, 600, 370);
            sp3.setBounds(10, 350, 500, 150);
            sp4.setBounds(10, 50, 680, 250);
            sp5.setBounds(10, 50, 680, 420);

            tf1.setBounds(30, 460, 500, 30);
            tf2.setBounds(170, 260, 300, 25);   
            tf3.setBounds(150, 435, 200, 30);
            lx6.setBounds(5, 405, 300, 30);
            lx7.setBounds(20, 435, 200, 30);
            lx8.setBounds(50, 475, 400, 30);
            
            b14.setBounds(520, 425, 100, 30);

            spinner1.setBounds(170, 75, 45, 28);
            spinner2.setBounds(230, 75, 45, 28);
            spinner3.setBounds(170, 120, 45, 28);
            spinner4.setBounds(230, 120, 45, 28);
            spinner5.setBounds(170, 165, 45, 28);
            spinner6.setBounds(230, 165, 45, 28);
            spinner7.setBounds(170, 210, 45, 28);
            spinner8.setBounds(230, 210, 45, 28);
            cb1.setBounds(290, 75, 70, 28);
            cb2.setBounds(290, 120, 70, 28);
            cb3.setBounds(290, 165, 70, 28);
            cb4.setBounds(290, 210, 70, 28);

            b6.setBounds(592, 460, 100, 30);
            
            background.setBounds(0, 0, 1000, 210);
            
            Line.setBounds(8, 500, 250,20);
            Line.setForeground(Color.white);

            l1.setFont(new Font("TimesRoman",Font.PLAIN,25));
            l2.setFont(new Font("TimesRoman",Font.BOLD,25));
            l3.setFont(new Font("TimesRoman",Font.PLAIN,17));
            l4.setFont(new Font("TimesRoman",Font.PLAIN,17));
            l5.setFont(new Font("TimesRoman",Font.PLAIN,17));
            l6.setFont(new Font("TimesRoman",Font.PLAIN,17));
            l7.setFont(new Font("TimesRoman",Font.PLAIN,17));
            l8.setFont(new Font("TimesRoman",Font.PLAIN,17));
//            l9.setFont(new Font("TimesRoman",Font.PLAIN,17));
            l10.setFont(new Font("TimesRoman",Font.PLAIN,17));

            lx1.setFont(new Font("TimesRoman",Font.PLAIN,18));
            lx2.setFont(new Font("TimesRoman",Font.PLAIN,18));
            lx3.setFont(new Font("TimesRoman",Font.PLAIN,18));
            lx4.setFont(new Font("TimesRoman",Font.PLAIN,18));
            lx5.setFont(new Font("TimesRoman",Font.PLAIN,18));
            
            lx6.setFont(new Font("TimesRoman",Font.PLAIN,18));
            lx7.setFont(new Font("TimesRoman",Font.PLAIN,16));
            lx8.setFont(new Font("TimesRoman",Font.PLAIN,17));
            
            lx.setFont(new Font("TimesRoman",Font.PLAIN,17));
            
            b1.setFont(new Font("TimesRoman",Font.PLAIN,16));
            b2.setFont(new Font("TimesRoman",Font.PLAIN,16));
            b3.setFont(new Font("TimesRoman",Font.PLAIN,16));
            b4.setFont(new Font("TimesRoman",Font.PLAIN,16));
            b5.setFont(new Font("TimesRoman",Font.PLAIN,16));
            b6.setFont(new Font("TimesRoman",Font.PLAIN,16));
            b7.setFont(new Font("TimesRoman",Font.PLAIN,20));
            b8.setFont(new Font("TimesRoman",Font.PLAIN,20));
            b9.setFont(new Font("TimesRoman",Font.PLAIN,20));
            b10.setFont(new Font("TimesRoman",Font.PLAIN,20));
            b11.setFont(new Font("TimesRoman",Font.PLAIN,16));
            b13.setFont(new Font("TimesRoman",Font.PLAIN,16));
            b14.setFont(new Font("TimesRoman",Font.PLAIN,16));
            
            t1.setFont(new Font("TimesRoman",Font.PLAIN,14));
            t2.setFont(new Font("TimesRoman",Font.PLAIN,14));
            tf3.setFont(new Font("TimesRoman",Font.PLAIN,14));
            
            textarea.setFont(new Font("TimesRoman",Font.PLAIN,14));
            textarea1.setFont(new Font("TimesRoman",Font.PLAIN,14));

            color_button();

            b7.setBorderPainted(false);
            b8.setBorderPainted(false);
            b9.setBorderPainted(false);
            b10.setBorderPainted(false);

            b1.setFocusPainted(false);
            b2.setFocusPainted(false);
            b3.setFocusPainted(false);
            b4.setFocusPainted(false);
            b5.setFocusPainted(false);
            b6.setFocusPainted(false);
            b7.setFocusPainted(false);
            b8.setFocusPainted(false);
            b9.setFocusPainted(false);
            b10.setFocusPainted(false);

            b11.setFocusPainted(false);
            b13.setFocusPainted(false);
            b14.setFocusPainted(false);

            lx1.setBackground(c3);
            lx1.setForeground(c1);
            lx2.setBackground(c3);
            lx2.setForeground(c1);
            lx3.setBackground(c3);
            lx3.setForeground(c1);
            lx4.setBackground(c3);
            lx4.setForeground(c1);
            lx5.setBackground(c3);
            lx5.setForeground(c1);
            lx6.setBackground(c3);
            lx6.setForeground(c1);
            lx7.setBackground(c3);
            lx7.setForeground(c1);
            
            lx.setBackground(c3);
            lx.setForeground(Color.BLUE);
            
            lx8.setBackground(c3);
            lx8.setForeground(Color.BLUE);
            
            l1.setForeground(Color.white);
            l2.setForeground(Color.white);

            l3.setForeground(Color.black);
            l4.setForeground(Color.black);
            l5.setForeground(Color.black);
            l6.setForeground(Color.black);
            l7.setForeground(Color.black);
            l8.setForeground(Color.black);
//            l9.setForeground(Color.black);
            l10.setForeground(Color.black);

            b7.setBackground(c3);
            b8.setBackground(c1);
            b9.setBackground(c1);
            b10.setBackground(c1);
            b11.setBackground(c1);
            b13.setBackground(c1);
            b14.setBackground(c1);

            b7.setForeground(c1);
            b8.setForeground(Color.white);
            b9.setForeground(Color.white);
            b10.setForeground(Color.white);

            b11.setForeground(Color.white);
            b13.setForeground(Color.white);
            b14.setForeground(Color.white);

            p1.setBackground(c1);
            ta1.setBorder(border);
            
            p3.setBackground(Color.white);
            p4.setBackground(Color.white);
            p5.setBackground(Color.white);
            p6.setBackground(Color.white);
            p7.setBackground(Color.white);
            
            textarea.setLineWrap(true);
            textarea.setWrapStyleWord(true);
            textarea1.setLineWrap(true);
            textarea1.setWrapStyleWord(true);
            
            b1.addActionListener(this);
	    b2.addActionListener(this);
	    b3.addActionListener(this);
	    b4.addActionListener(this);
	    b5.addActionListener(this);
	    b6.addActionListener(this);
            b11.addActionListener(this);
	    b13.addActionListener(this);
            b14.addActionListener(this);
            
            b7.addMouseListener(this);
	    b8.addMouseListener(this);
	    b9.addMouseListener(this);
	
            p1.add(l1);
            
            p1.add(forum1);
            p1.add(admin1);
            p1.add(assessment1);
            p1.add(logout1);

            p1.add(forum);
            p1.add(admin);
            p1.add(assessment);
            p1.add(logout);
            
            p1.add(Line);
            
            p1.add(b7);
            p1.add(b8);
            p1.add(b9);
            p1.add(b10);
            
            p3.add(sp1);
            p3.add(tf3);
            p3.add(lx1);
            p3.add(lx6);
            p3.add(lx7);
            p3.add(b11);
            
            p4.add(sp2);
            p4.add(tf1);
            p4.add(b6);
            p4.add(lx2);
            
            p6.add(l3);
	    p6.add(l4);
	    p6.add(l5);
	    p6.add(l6);
	    p6.add(l7);
	    p6.add(l8);
	    p6.add(spinner1);
	    p6.add(spinner2);
	    p6.add(spinner3);
	    p6.add(spinner4);
	    p6.add(spinner5);
	    p6.add(spinner6);
	    p6.add(spinner7);
	    p6.add(spinner8);
	    p6.add(cb1);
	    p6.add(cb2);
	    p6.add(cb3);
	    p6.add(cb4);
	    p6.add(tf2);
	    p6.add(b13);
            p6.add(lx3);
            p6.add(lx);
            
            p5.add(sp4);
            p5.add(sp3);
            p5.add(b14);
//            p5.add(l9);
	    p5.add(l10);
            p5.add(lx4);
            
            p7.add(sp5);
            p7.add(lx5);
            
            add(l2);
	    add(b1);
	    add(b2);
	    add(b3);
	    add(b4);
	    add(b5);
	    
	    add(p1);
	    add(p3);
            add(p4);
            add(p5);
	    add(p6);
            add(p7);
            add(user);
            add(main_name_disJLabel);
            add(main_user_name_disJLabel);
            add(background);
            
            p1.setLayout(null);
            p3.setLayout(null);
	    p4.setLayout(null);
            p5.setLayout(null);
	    p6.setLayout(null);
	    p7.setLayout(null);
            
            visibility();
            color_button();
            b1.setBackground(Color.white);
            b1.setForeground(c1);
            p3.setVisible(true);
            students_details();
	    
            admin.setVisible(true);
            admin1.setVisible(false);
            
	    spinner1.addChangeListener(new ChangeListener()
	    {
	    	public void stateChanged(ChangeEvent e) {
	    		if(e.getSource()==spinner1)
	    		{
	    			Integer spins1=(Integer)spinner1.getValue();
	    			spin1=spins1.toString();
	    			System.out.print(spin1);
	    		}
	    	}
	    });
	    spinner2.addChangeListener(new ChangeListener()
	    {
	    	public void stateChanged(ChangeEvent e) {
	    		if(e.getSource()==spinner2)
	    		{
	    			Integer spins2=(Integer)spinner2.getValue();
	    			spin2=spins2.toString();
	    			//System.out.print(spin1);
	    		}
	    	}
	    });
	    spinner3.addChangeListener(new ChangeListener()
	    {
	    	public void stateChanged(ChangeEvent e) {
	    		if(e.getSource()==spinner3)
	    		{
	    			Integer spins3=(Integer)spinner3.getValue();
	    			spin3=spins3.toString();
	    			//System.out.print(spin1);
	    		}
	    	}
	    });
	    spinner4.addChangeListener(new ChangeListener()
	    {
	    	public void stateChanged(ChangeEvent e) {
	    		if(e.getSource()==spinner4)
	    		{
	    			Integer spins4=(Integer)spinner4.getValue();
	    			spin4=spins4.toString();
	    			//System.out.print(spin1);
	    		}
	    	}
	    });
	    spinner5.addChangeListener(new ChangeListener()
	    {
	    	public void stateChanged(ChangeEvent e) {
	    		if(e.getSource()==spinner5)
	    		{
	    			Integer spins5=(Integer)spinner5.getValue();
	    			spin5=spins5.toString();
	    			//System.out.print(spin1);
	    		}
	    	}
	    });
	    spinner6.addChangeListener(new ChangeListener()
	    {
	    	public void stateChanged(ChangeEvent e) {
	    		if(e.getSource()==spinner6)
	    		{
	    			Integer spins6=(Integer)spinner6.getValue();
	    			spin6=spins6.toString();
	    			//System.out.print(spin1);
	    		}
	    	}
	    });
	    spinner7.addChangeListener(new ChangeListener()
	    {
	    	public void stateChanged(ChangeEvent e) {
	    		if(e.getSource()==spinner7)
	    		{
	    			Integer spins7=(Integer)spinner7.getValue();
	    			spin7=spins7.toString();
	    			//System.out.print(spin1);
	    		}
	    	}
	    });
	    spinner8.addChangeListener(new ChangeListener()
	    {
	    	public void stateChanged(ChangeEvent e) {
	    		if(e.getSource()==spinner8)
	    		{
	    			Integer spins8=(Integer)spinner8.getValue();
	    			spin8=spins8.toString();
	    			//System.out.print(spin1);
	    		}
	    	}
	    });
	    
	    //this.getContentPane().setBackground(Color.gray);
            setBackground(Color.gray);
            setSize(1000,800);
	    setLocationRelativeTo(null);
	    setLayout(null);
	    setVisible(true);
            
            b10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                b10.setBackground(Color.white);
                b7.setBackground(c1);
            
                b10.setForeground(Color.black);
                b7.setForeground(Color.white);

                logout.setVisible(true);
                admin.setVisible(false);

                logout1.setVisible(false);
                admin1.setVisible(true);
                
                int a=JOptionPane.showConfirmDialog(new JFrame(),"Are you sure?");  

                if(a==JOptionPane.YES_OPTION){  
                    dispose();
                    new Logins();
                }
                else{
                    b7.setBackground(Color.white);
                    b10.setBackground(c1);

                    b7.setForeground(c1);
                    b10.setForeground(Color.white);

                    admin.setVisible(true);
                    logout.setVisible(false);

                    admin1.setVisible(false);
                    logout1.setVisible(true);
                }
            }
        });
            
            addWindowListener(new WindowAdapter() {
                    public void windowClosing(WindowEvent e) {  
                        int a=JOptionPane.showConfirmDialog(new JFrame(),"Are you sure?");  
                        if(a==JOptionPane.YES_OPTION){  
                            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
                        } 
                    }
                });
                setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	}
	
	void visibility(){
            p3.setVisible(false);
            p4.setVisible(false);
            p5.setVisible(false);
            p6.setVisible(false);
            p7.setVisible(false);
        }
	void students_details(){
            String[] s1= {"First Name","Last Name","Email","Roll No","Department","Section","college","Mobile No"};
            DefaultTableModel model=new DefaultTableModel();
            model.setColumnIdentifiers(s1);
            t1.setModel(model);
            t1.setFillsViewportHeight(true);
            t1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
            String fname="";
            String lname="";
            String email="";
            String rollno="";
            String dept="";
            String sec="";
            String clge="";
            String phno="";
            try{ 
            //    Class.forName(Driver);
              //  Connection con=DriverManager.getConnection(connect,"bootathon","admin");
            	Connection con=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\MAHESH KUMAR B\\Downloads\\SQLiteStudio-3.2.1\\mahi\\studentsdetails.db");
            	Statement st=con.createStatement();
                con.setAutoCommit(true);
                String query="select * from registers";
                ResultSet rs=st.executeQuery(query);
                while(rs.next())
                {
                    fname=rs.getString("firstname");
                    lname=rs.getString("lastname");			     
                    email=rs.getString("email");
                    rollno=rs.getString("rollno");
                    dept=rs.getString("department");
                    sec=rs.getString("section");
                    clge=rs.getString("college");
                    phno=rs.getString("mobileno");
                    model.addRow(new Object[] {fname,lname,email,rollno,dept,sec,clge,phno});
                 }
                 con.close();
            }
            catch(Exception E){
                System.out.println(E);
            }
        }
	@Override
	public void actionPerformed(ActionEvent e) {
            lx.setVisible(false);
            if(e.getSource()==b1)
            {
                visibility();
                color_button();
                b1.setBackground(Color.white);
                b1.setForeground(c1);
                lx8.setVisible(false);
                p3.setVisible(true);
                students_details();
            }
            if(e.getSource()==b11){
                delete_detail();
                students_details();
            }
            if(e.getSource()==b2)
            {
                visibility();
                color_button();
                b2.setBackground(Color.white);
                b2.setForeground(c1);
                p4.setVisible(true);
		StartThread();
            }
		
            if(e.getSource()==b6){
                msg_send=tf1.getText();
	        tf1.setText(null);
	        sendMsg();
            }
		
            if(e.getSource()==b3){
                
                visibility();
                color_button();
                b3.setBackground(Color.white);
                b3.setForeground(c1);
                p6.setVisible(true);
                lx.setVisible(false);
            }
            
            if(e.getSource()==b13){
                assigning_test();
            }
            
            if(e.getSource()==b4){
	
                visibility();
                color_button();
                b4.setBackground(Color.white);
                b4.setForeground(c1);
                p5.setVisible(true);
                Results();
            }
            if(e.getSource()==b14){
                
                upload();
                Results();
            }
            
            
            if(e.getSource()==b5){
	
                visibility();
                color_button();
                b5.setBackground(Color.white);
                b5.setForeground(c1);
                p7.setVisible(true);
		String usermsg="";
		try{ 
		
              //      Class.forName(Driver);
                //    Connection con=DriverManager.getConnection(connect,"bootathon","admin");
			Connection con=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\MAHESH KUMAR B\\Downloads\\SQLiteStudio-3.2.1\\mahi\\studentsdetails.db");        
			Statement st=con.createStatement();
                    con.setAutoCommit(true);
                    String query="select * from query_forum";
                    ResultSet rs=st.executeQuery(query);
                    while(rs.next()){
                        username=rs.getString("user_name");
			name=rs.getString("name");
			message=rs.getString("msg_send");
			usermsg=usermsg+"\n "+(username)+" "+name+" "+"\n\t"+message+".\n";
                    }
                    textarea1.setText(usermsg);
                    
                    con.close();
		}
		catch(Exception E){ 
                    System.out.println(E);
		}
            }
				
	}

        void delete_detail(){
            String rollno=tf3.getText();
            p3.add(lx8);
            lx8.setVisible(false);
            int x=0;
            if(validation.isValidRollno(rollno)==false){
                lx8.setText("Enter Valid Roll No.");
                lx8.setVisible(true);
            }
            
            else{
                try{ 
		
               //     Class.forName(Driver);
                 //   Connection con=DriverManager.getConnection(connect,"bootathon","admin");
                	Connection con=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\MAHESH KUMAR B\\Downloads\\SQLiteStudio-3.2.1\\mahi\\studentsdetails.db");
                	Statement st=con.createStatement();
                    con.setAutoCommit(true);
                    String query="delete from registers where rollno='"+rollno+"'";
                    String query1="delete from student_results where user_name='"+rollno+"'";
                    x=st.executeUpdate(query);
                    x=st.executeUpdate(query1);
                    System.out.println(x);
                    con.getAutoCommit();
                    x=1;
                    lx8.setText("Deleted Successfully");
                    lx8.setVisible(true);
                    con.close();
		}

                catch(Exception E){ 
                    
                    System.out.println(E);
		}
                if(x==1){
                    lx8.setText("Deleted Successfully");
                    lx8.setVisible(true);
                }
                else{
                    lx8.setText("Wrong Roll No.");
                    lx8.setVisible(true);
                }
            }
            
        }
        
        void assigning_test(){
            String combo1=cb1.getItemAt(cb1.getSelectedIndex());
                String combo2=cb2.getItemAt(cb2.getSelectedIndex());
                String combo3=cb3.getItemAt(cb3.getSelectedIndex());
                String combo4=cb4.getItemAt(cb4.getSelectedIndex());
                
                Integer spins1=(Integer)spinner1.getValue();
                spin1=spins1.toString();
                Integer spins2=(Integer)spinner2.getValue();
                spin2=spins2.toString();
                Integer spins3=(Integer)spinner3.getValue();
                if(combo2=="PM"){
                    spins3+=12;
                }
                spin3=spins3.toString();
                Integer spins4=(Integer)spinner4.getValue();
                spin4=spins4.toString();
                Integer spins5=(Integer)spinner5.getValue();
                spin5=spins5.toString();
                Integer spins6=(Integer)spinner6.getValue();
                spin6=spins6.toString();
                Integer spins7=(Integer)spinner7.getValue();
                if(combo4=="PM"){
                    spins7+=12;
                }
                spin7=spins7.toString();
                Integer spins8=(Integer)spinner8.getValue();
                spin8=spins8.toString();
                    
                String startdate=combo1+"-"+spin2+"-"+spin1; 
                String starttime=spin3+":"+spin4;
                String enddate=combo3+"-"+spin6+"-"+spin5;
                String endtime=spin7+":"+spin8;
                String testlink=tf2.getText();
                int statusnumber=0;
                
		if(!Timestamp.valueOf(startdate+" "+starttime+":00").after(new java.util.Date()) &&
                   !Timestamp.valueOf(enddate+" "+endtime+":00").after(new java.util.Date())  &&
                   !Timestamp.valueOf(startdate+" "+starttime+":00").after(Timestamp.valueOf(enddate+" "+endtime+":00"))  ){
                        lx.setText("Invalid Date and Time");
                        lx.setVisible(true);
                }
                else if(validation.IsMatch(testlink)==false){
                    lx.setText("Invalid Test Link");
                    lx.setVisible(true);
                }
                else{
                    try{  
                    	


                        //java.sql.Date start_date1=null;
                      //  java.sql.Date end_date1=null;

                     //   System.out.println(start_date1+" "+startdate+" "+starttime);
                       // System.out.println(start_date1+" "+enddate+" "+endtime);
                  //      Class.forName(Driver);
                    //    Connection con=DriverManager.getConnection(connect,"bootathon","admin");
                        Connection con=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\MAHESH KUMAR B\\Downloads\\SQLiteStudio-3.2.1\\mahi\\studentsdetails.db");
                        con.setAutoCommit(true);
                        String query="insert into test_details values (?,?,?,?,?,?) ";
                        PreparedStatement st=con.prepareStatement(query);
                        st.setString(1, startdate);
                        st.setString(2,starttime);
                        st.setString(3, enddate);
                        st.setString(4,endtime);
                        st.setString(5,testlink);
                        st.setInt(6, statusnumber);

                        st.executeUpdate();
                        st.close();
                        con.close();
                        lx.setText("Test Assigned Successfully");
                        lx.setVisible(true);
                        System.out.println("Success");
                    }
                    catch(Exception E){
                        System.out.println("admin.Admin_frame.actionPerformed()");
                        E.printStackTrace();
                    }
                }
        }
        
        void Results(){
            int average[]=new int[1000];
            int sno=0,x=0;
            String user_name[]=new String[1000];
            String name;
            int test[]=new int[100];
         //   final String Driver="oracle.jdbc.driver.OracleDriver";
           // final String connect="jdbc:oracle:thin:@127.0.0.1:1521:XE";
            try {
             //   Class.forName(Driver);
               // Connection con=DriverManager.getConnection(connect,"bootathon","admin");
            	Connection con=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\MAHESH KUMAR B\\Downloads\\SQLiteStudio-3.2.1\\mahi\\studentsdetails.db");
            	Statement st=con.createStatement();

                String query="Select * from Student_Results";
                ResultSet rs=st.executeQuery(query);
                ResultSetMetaData rsmd=rs.getMetaData(); 
                column =rsmd.getColumnCount()-3;
                
                DefaultTableModel model=new DefaultTableModel();
                ArrayList <String> sa1=new ArrayList<String>();
                sa1.add("User Name");
                sa1.add("Name");

                for (int i = 1; i <= column; i++) {
                    sa1.add("Test"+i);
                }
                sa1.add("Average");
                String s1[]=new String[sa1.size()];
                for (int j = 0; j < sa1.size(); j++) { 
                    s1[j] = sa1.get(j); 
                }    
                
                model.setColumnIdentifiers(s1);
                t2.setModel(model);
                t2.setFillsViewportHeight(true);
                t2.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
                
                while(rs.next()){
                    average[x]=0;
                    user_name[x]=rs.getString("user_name");
                    name=rs.getString("name");
                    for (int i = 1; i <= column; i++) {
                        test[i]=rs.getInt("test"+i);
                        average[x]+=test[i];

                    }
                    average[x]/=column;
                    sno++;
                    
                    ArrayList<Object> values=new ArrayList<Object>();
                    values.add(user_name[x]);
                    values.add(name);
                    for (int i = 1; i <=column; i++) {
                        values.add(test[i]);
                    }
                    values.add(average[x]);
                    model.addRow(values.toArray());
                    x++;
                }
                
                for(int i=0;i<x;i++){
                    String query2="update student_results set average='"+average[i]+"' where user_name='"+user_name[i]+"'";
                    st.executeUpdate(query2);
                }
              /*    if(sno==0){
                    for (int i = 1; i <=column; i++) {
                        String query2="ALTER TABLE student_results DROP COLUMN test"+i+"";
                        st.executeUpdate(query2);
                    }
                    
                }*/
                con.getAutoCommit();
                con.close();
            }
            catch(Exception e)
            {
                System.out.println(e+"Error Displaying Table");
            }    
            
        }
        
        public void upload() {
		String s1=ta1.getText();
                ta1.setText("");
		String[] a=s1.split("\\s");
                try
                {

                  //      Class.forName(Driver);
                   //     Connection con1=DriverManager.getConnection(connect,"bootathon","admin");
                	Connection con1=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\MAHESH KUMAR B\\Downloads\\SQLiteStudio-3.2.1\\mahi\\studentsdetails.db");    
                	Statement st1=con1.createStatement();
                        String sql="select * from student_results";
                        ResultSet rs=st1.executeQuery(sql);
                        while(rs.next())
                        {
                                al.add(rs.getString("user_name"));
                        }
                        con1.close();

                     //   Class.forName(Driver);
                       // Connection con=DriverManager.getConnection(connect,"bootathon","admin");
                        Connection con=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\MAHESH KUMAR B\\Downloads\\SQLiteStudio-3.2.1\\mahi\\studentsdetails.db");
                        Statement st=con.createStatement();
                        String queryADD="ALTER TABLE student_results ADD test"+(column+1)+" varchar(255)";
                        st.executeUpdate(queryADD);
                        int i=0;
                        for(String w:a)
                        {

                                String query="update student_results set test"+(column+1)+"='"+w+"' where user_name='"+al.get(i)+"'";
                                st.executeUpdate(query);
                                i++;
                        }
                        con.setAutoCommit(true);
                    con.close();
                }
                catch(Exception E)
                {
                        System.out.print(E);
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
        
	@Override
	public void mousePressed(MouseEvent e) {

            
            if(e.getSource()==b8){
                b8.setBackground(Color.white);
                b7.setBackground(c1);

                b8.setForeground(Color.black);
                b7.setForeground(Color.white);

                assessment1.setVisible(true);
                admin1.setVisible(false);

                assessment.setVisible(false);
                admin.setVisible(true);
                dispose();
                new Assessment_frame(main_user_name, main_name);
	    }

            if(e.getSource()==b9){
                b9.setBackground(Color.white);
                b7.setBackground(c1);

                b9.setForeground(Color.black);
                b7.setForeground(Color.white);

                forum1.setVisible(true);
                admin1.setVisible(false);

                forum.setVisible(false);
                admin.setVisible(true);
                dispose();
                new Forum_frame(main_user_name, main_name).StartThread();
            }
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
        
        @Override
	public void mouseClicked(MouseEvent e) {
	}
	@Override
	public void mouseReleased(MouseEvent e) {
	}
	@Override
	public void mouseEntered(MouseEvent e) {
	}
	@Override
	public void mouseExited(MouseEvent e) {
	}
        
	void sendMsg(){
            int sno=1;
            try{  
              //  Class.forName(Driver);
                ///Connection con=DriverManager.getConnection(connect,"bootathon","admin");
            	Connection con=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\MAHESH KUMAR B\\Downloads\\SQLiteStudio-3.2.1\\mahi\\studentsdetails.db");
            	Statement st=con.createStatement();
		     
                String query="insert into admin_forum values('"+msg_send+"')";
                con.setAutoCommit(true);
                st.executeUpdate(query);
                st.close();
                con.close();
            }
            catch(Exception E)
            {
                E.printStackTrace();
            }
        }

        void getMsg(){
            try {
	
                String AdminMsg="";
               // Class.forName(Driver);
                //Connection con1=DriverManager.getConnection(connect,"bootathon","admin");
                Connection con1=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\MAHESH KUMAR B\\Downloads\\SQLiteStudio-3.2.1\\mahi\\studentsdetails.db");
                Statement st1=con1.createStatement();
                con1.setAutoCommit(true);
                String query1="select * from admin_forum";
                ResultSet rs=st1.executeQuery(query1); 
                int i=1;
                while(rs.next()){
                    msg_get=rs.getString("msg_admin");
                    AdminMsg=AdminMsg+" "+i+". "+msg_get+".\n\n";
                    i++;
                }
                textarea.setText(AdminMsg);
                con1.close();
            }
            catch(Exception e)
            {
                System.out.println(e+" Error Displaying Table");
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
	
        public static void main(String[] args) {
            new Admin_frame("Admin","SKCET");
        }

}
