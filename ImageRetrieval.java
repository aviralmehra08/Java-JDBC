import java.sql.*;
import java.io.*;
class ImageOut
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
            File f=new File("C:\\Users\\avira\\Downloads\\mainjava.jpg");
            FileOutputStream fs=new FileOutputStream(f);
            ResultSet rs=smt.executeQuery("select * from storedb.gallery");
            Blob blob;
            byte b[];
            while(rs.next())
            {
                String eid=rs.getString(1);
                String eproduct=rs.getString(2);
                String eprice=rs.getString(3);
                blob=rs.getBlob("SavePic");
                b=blob.getBytes(1, (int)blob.length());
                fs.write(b);
            }
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
