import java.sql.*;
class College
{
    public static void main(String args[])
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "aviral08");
            System.out.println("Connection Successful");
            Statement smt=conn.createStatement();
            smt.execute("use employees");
            smt.executeUpdate("create table college(empid varchar(50), empname varchar(50), course varchar(50))");
            System.out.println("Table created Successfully");
            smt.executeUpdate("insert into college values ('31','Aviral','CSE')");
            smt.executeUpdate("insert into college values ('32','Akansh','CSE')");
            System.out.println("Values Inserted");
            ResultSet rs=smt.executeQuery("select * from employees.college");
            while(rs.next())
            {
                String id=rs.getString(1);
                String name=rs.getString(2);
                String course=rs.getString(3);
                System.out.println(id+" "+name+" "+course);
            }
            conn.close();
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
