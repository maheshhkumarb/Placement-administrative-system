/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

/**
 *
 * @author kumar
 */

    import java.util.Scanner;
    import java.util.regex.*; 
public class validation { 
    
    
    public static boolean IsMatch(String s) {
        String regexString = "^[0-9]{2}(EU|eu)*[A-Za-z]{2}[0-9]{3}@?skcet\\.ac\\.in$";
        Pattern r = Pattern.compile(regexString);
        if(s==null)
            return false;
        Matcher m = r.matcher(s);
        return true;
    }
    
    public static boolean isValidUserLastName(String lname)
    {
        String regex = "[a-zA-Z\\s]{1,20}";
        Pattern p = Pattern.compile(regex);
        if(lname==null)
            return false;
        Matcher m = p.matcher(lname);
        return m.matches();
    }
    
    public static boolean isValidUserFirstName(String fname)
    {
        String regex1 = "[a-zA-Z\\s]{1,20}";
        Pattern p1 = Pattern.compile(regex1);
        if(fname==null)
            return false;
        Matcher m1 = p1.matcher(fname);
        return m1.matches();
    }
    
    public static boolean isValidemail(String email)
    {
        String regex2 ="^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        Pattern p2 = Pattern.compile(regex2);
        if(email==null)
            return false;
        Matcher m2 = p2.matcher(email);
        return m2.matches();
    }
    
    public static boolean isValidRollno(String rollno)
    {
        String regex3 = "[a-zA-z0-9]{1,}";
        Pattern p3 = Pattern.compile(regex3);
        if(rollno==null)
            return false;
        Matcher m3 = p3.matcher(rollno);
        return m3.matches();
    }
    
    public static boolean isValidDept(String dept)
    {
        String regex4 = "[a-zA-Z]";
        Pattern p4 = Pattern.compile(regex4);
        if(dept==null)
            return false;
        Matcher m4 = p4.matcher(dept);
        return m4.matches();
    }
    
    public static boolean isValidSec(String sec)
    {
        String regex5 = "[a-zA-Z]";
        Pattern p5 = Pattern.compile(regex5);
        if(sec==null)
            return false;
        Matcher m5 = p5.matcher(sec);
        return m5.matches();
    }
    
    public static boolean isValidClg(String clg)
    {
        String regex6 = "[a-zA-Z]";
        Pattern p6 = Pattern.compile(regex6);
        if(clg==null)
            return false;
        Matcher m6 = p6.matcher(clg);
        return m6.matches();
    }
    
    public static boolean isValidPhno(String phno)
    {
        String regex7 = "[0-9]{10}";
        Pattern p7 = Pattern.compile(regex7);
        if(phno==null)
            return false;
        Matcher m7 = p7.matcher(phno);
        return m7.matches();
    }
  
    public static boolean isValidPassword(String password) 
    { 
        String regex = "^(?=.*[0-9])"
                       + "(?=.*[a-z])(?=.*[A-Z])"
                       + "(?=.*[@#$%^&+=])"
                       + "(?=\\S+$).{8,20}$"; 
  
        Pattern p = Pattern.compile(regex); 
        if (password == null) 
            return false; 
        Matcher m3 = p.matcher(password);  
        return m3.matches(); 
    } 
   public static void main(String[] args) {
        validation s1=new validation();
        System.out.println(s1.isValidUserFirstName("kumaran "));
        System.out.println(s1.isValidUserLastName("s"));
        System.out.println(s1.isValidRollno("18eumc071"));
        System.out.println(s1.isValidemail("18eumc071@skcet.ac.in"));
        System.out.println(s1.isValidPassword("bdkfbHHBDFJ7687@#"));
        System.out.println(s1.IsMatch("https://github.com/Aravindha1234u/college-complaint-management-system/blob/master/regexValidation.java"));
    }
} 
    



