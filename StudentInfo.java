import java.sql.*;
class Student
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
            smt.executeUpdate("create table students(id varchar(10), name varchar(20), course varchar(50), city varchar(50))");
            System.out.println("Table is created");
            smt.executeUpdate("insert into students values('10','Aviral','Computer Science','Allahabad')");
            smt.executeUpdate("insert into students values('11','Akansh','Computer Science','Dehradun')");
            smt.executeUpdate("insert into students values('12','Anant','Computer Science','Delhi')");
            System.out.println("Value is Updated");
            ResultSet rs=smt.executeQuery("select * from employees.student");
            while(rs.next())
            {
                String id=rs.getString(1);
                String name=rs.getString(2);
                String course=rs.getString(3);
                String city=rs.getString(4);
                System.out.println(id+" "+name+" "+course+" "+city);
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
