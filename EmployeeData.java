import java.sql.*;
class Employee2
{
    public static void main(String[] args) 
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306","root", "aviral08");
            System.out.println("Connection Successful");
            Statement smt=conn.createStatement();
            smt.execute("use employees");
            smt.executeUpdate("insert into employee1 values('12345','Aman','Mehra','50000')");
            smt.executeUpdate("insert into employee1 values('123456','Tulika','Mehra','50000')");
            System.out.println("Value is Updated");
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
