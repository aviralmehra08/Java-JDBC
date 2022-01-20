import java.sql.*;
import java.io.*;
class Image
{
    public static void main(String args[]) throws Exception, IOException, SQLException, FileNotFoundException
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306","root","aviral08");
            System.out.println("Connection Successful");
            Statement smt=conn.createStatement();
            smt.execute("use storedb");
            smt.executeUpdate("create table img(id varchar(10), product varchar (50), price varchar(50), SavePic BLOB)");
            System.out.println("Table Created Successfully");
            File f=new File("C:\\Users\\avira\\Downloads\\mainjava.jpg");
            FileInputStream fs=new FileInputStream(f);
            smt.executeUpdate("insert into img values('1','MainJava','900000','fs,(int)f.lenth()')");
            System.out.println("Image stored Successfully");
            conn.close();
            fs.close();
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
        catch(ClassNotFoundException e)
        {
            System.out.println(e);
        }
    }
}
