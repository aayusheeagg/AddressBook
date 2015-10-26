
import java.io.FileInputStream;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class DBManager {

    private static String DBUrl = "jdbc:mysql://localhost:3306/address_book";
    private static String DBUser = "root";
    private static String DBPassword = "toor";

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception ex) {
        }
    }

    public static ArrayList<Category> getAllCategory() {
        ArrayList<Category> list = new ArrayList<Category>();
        try {
            Connection con = DriverManager.getConnection(DBUrl, DBUser, DBPassword);
            PreparedStatement st = con.prepareStatement("Select Category from category");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Category c = new Category();
                c.setCategory(rs.getString(1));
                list.add(c);
            }
            rs.close();
            st.close();
            con.close();
        } catch (Exception ex) {
        }
        return list;
    }

    public static boolean registeruser(String Username1,String LoginId1, String Passwd1) {
        
        try {
            Connection con = DriverManager.getConnection(DBUrl, DBUser, DBPassword);
            PreparedStatement st = con.prepareStatement("Select * from login");
            ResultSet rs = st.executeQuery();
            String LoginId2,Username2;
            while (rs.next()) {
                LoginId2=rs.getString(1);
                Username2=rs.getString(3);
            if(Username2.equals(Username1) && LoginId2.equals(LoginId1))
            {
                return false;
            }
            }
            
            PreparedStatement stt = con.prepareStatement("insert into login values(?,password(?),?)");
            stt.setString(1, LoginId1);
            stt.setString(2, Passwd1);
            stt.setString(3, Username1);
            stt.executeUpdate();
            con.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return true;
       
    }
    public static LoginInfo loginuser(String ContactId, String Passwd) {
        LoginInfo info = null;
        try {
            Connection con = DriverManager.getConnection(DBUrl, DBUser, DBPassword);
            PreparedStatement st = con.prepareStatement("Select * from login where ContactId=? and Passwd=password(?)");
            st.setString(1, ContactId);
            st.setString(2, Passwd);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                info = new LoginInfo();
                info.setContactId(rs.getString(1));
                info.setName(rs.getString(3));
            }
            con.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return info;
    }

    public static boolean insertContact(Contacts s) {
        boolean status = false;
        try {
            Connection con = DriverManager.getConnection(DBUrl, DBUser, DBPassword);
            PreparedStatement st = con.prepareStatement("insert into contacts values(?,?,?,?,?,?,?,?,?)");
            st.setString(1, s.getUsername());
            st.setString(2, s.getName());
            st.setString(3, s.getMobileNumber());
            st.setString(4, s.getEmail());
            st.setDate(5, new Date(s.getDOB().getTime()));
            st.setString(6, s.getCity());
            st.setString(7, s.getGender());
            st.setString(8, s.getCategory());
            try {
                FileInputStream fi = new FileInputStream(s.getPhoto());
                st.setBinaryStream(9, fi, fi.available());
            } catch (Exception ex) {
                st.setNull(9, java.sql.Types.BLOB);
            }
            st.executeUpdate();
            con.close();
            status = true;
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return status;
    }

    public static boolean updateContact(String UserName, String Name1, String Name2, String mobile, String email, String city, String category) {
        boolean status = false;
        try {

            Connection con = DriverManager.getConnection(DBUrl, DBUser, DBPassword);
            PreparedStatement st = con.prepareStatement("update contacts set Name=?, MobileNumber=?, Email=?, City=?, Category=? where Name=? AND Username=? ");

            st.setString(1, Name1);
            st.setString(2, mobile);
            st.setString(3, email);
            st.setString(4, city);
            st.setString(5, category);
            st.setString(6, Name2);
            st.setString(7, UserName);
            st.executeUpdate();
            con.close();
            status = true;
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return status;
    }

    public static boolean updatepasswd(String UserName,String passwdold,String passwdnew) {
        boolean status = false;
        try {

            Connection con = DriverManager.getConnection(DBUrl, DBUser, DBPassword);
            PreparedStatement st = con.prepareStatement("update login set Passwd=password(?) where Name=? AND Passwd=password(?) ");

            st.setString(1, passwdnew);
            st.setString(2, UserName);
            st.setString(3, passwdold);
            st.executeUpdate();
            con.close();
            status = true;
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return status;
    }

    public static ArrayList<Contacts> getAllContacts(String UserName) {
        ArrayList<Contacts> list = new ArrayList<>();
        try {
            Connection con = DriverManager.getConnection(DBUrl, DBUser, DBPassword);
            PreparedStatement st = con.prepareStatement("Select Name,MobileNumber,DOB,Category from contacts where Username=?");
            st.setString(1, UserName);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Contacts s = new Contacts();
                s.setName(rs.getString(1));
                s.setMobileNumber(rs.getString(2));
                s.setDOB(rs.getDate(3));
                s.setCategory(rs.getString(4));
                list.add(s);
            }
            con.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return list;
    }

    public static ArrayList<Contacts> getAllStudentsByName(String UserName, String name) {
        ArrayList<Contacts> list = new ArrayList<>();
        try {
            Connection con = DriverManager.getConnection(DBUrl, DBUser, DBPassword);
            PreparedStatement st = con.prepareStatement("Select * from contacts where (Name like '" + name + "%' OR MobileNumber like '" + name + "%') AND Username=?");
            st.setString(1, UserName);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Contacts s = new Contacts();
                s.setName(rs.getString(2));
                s.setMobileNumber(rs.getString(3));
                s.setDOB(rs.getDate(5));
                s.setCategory(rs.getString(8));
                list.add(s);
            }
            con.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return list;
    }

    public static ArrayList<Contacts> getByDate(String UserName, Date date1, Date date2) {
        ArrayList<Contacts> list = new ArrayList<>();
        try {
            Connection con = DriverManager.getConnection(DBUrl, DBUser, DBPassword);
            PreparedStatement st = con.prepareStatement("Select * from contacts where DOB between ? and ?  AND Username=? ");
            st.setDate(1, new java.sql.Date(date1.getTime()));
            st.setDate(2, new java.sql.Date(date2.getTime()));
            st.setString(3, UserName);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Contacts s = new Contacts();
                s.setName(rs.getString(2));
                s.setMobileNumber(rs.getString(3));
                s.setDOB(rs.getDate(5));
                s.setCategory(rs.getString(8));
                list.add(s);
            }
            con.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return list;
    }

    public static ArrayList<Contacts> getByCategory(String UserName, String Category) {
        ArrayList<Contacts> list = new ArrayList<>();
        try {
            Connection con = DriverManager.getConnection(DBUrl, DBUser, DBPassword);
            PreparedStatement st = con.prepareStatement("Select * from contacts where Category=? AND Username=? ");
            st.setString(1, Category);
            st.setString(2, UserName);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Contacts s = new Contacts();
                s.setName(rs.getString(2));
                s.setMobileNumber(rs.getString(3));
                s.setDOB(rs.getDate(5));
                s.setCategory(rs.getString(8));
                list.add(s);
            }
            con.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return list;
    }

    public static Contacts getContact(String UserName, String Name1) {
        Contacts s = null;
        try {
            Connection con = DriverManager.getConnection(DBUrl, DBUser, DBPassword);
            PreparedStatement st = con.prepareStatement("Select * from contacts where UserName=? AND Name=?");
            st.setString(1, UserName);
            st.setString(2, Name1);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                s = new Contacts();
                s.setName(rs.getString(2));
                s.setCity(rs.getString(6));
                s.setEmail(rs.getString(4));
                s.setMobileNumber(rs.getString(3));
                s.setDOB(rs.getDate(5));
                s.setCategory(rs.getString(8));
                try {
                    ImageIcon icon = new ImageIcon(rs.getBytes(9));
                    s.setIcon(icon);
                } catch (Exception ex) {
                    s.setIcon(null);
                }
            }
            con.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return s;
    }

    public static boolean deleteContact(String UserName, String Name1) {
        boolean status = false;
        try {
            Connection con = DriverManager.getConnection(DBUrl, DBUser, DBPassword);
            PreparedStatement st = con.prepareStatement("Delete from contacts where Username=? AND Name=?");
            st.setString(1, UserName);
            st.setString(2, Name1);
            st.executeUpdate();
            con.close();
            status = true;
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return status;
    }

}
