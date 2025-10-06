package AssignemtQuestion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class program9{
    public static void main(String[] args) {
        // Database credentials
        String url = "jdbc:mysql://localhost:3306/schooldb"; // replace 'schooldb' with your DB name
        String user = "root"; // your MySQL username
        String password = "2001"; // your MySQL password

        try {
            // 1. Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Establish Connection
            Connection con = DriverManager.getConnection(url, user, password);

            // 3. Create Statement
            Statement stmt = con.createStatement();

            // 4. Execute Query
            String query = "SELECT * FROM students";
            ResultSet rs = stmt.executeQuery(query);

            // 5. Process ResultSet
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                System.out.println(id + " | " + name + " | " + age);
            }

            // 6. Close connections
            rs.close();
            stmt.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
