package Student;
import java.sql.*;

public class StudentDAO {

    public void addStudent(Student s) {
        try {
            Connection con = DBConnection.getConnection();

            String sql =
                    "INSERT INTO student VALUES(?,?,?,?)";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setInt(1, s.getId());
            ps.setString(2, s.getName());
            ps.setString(3, s.getEmail());
            ps.setString(4, s.getCourse());

            ps.executeUpdate();

            System.out.println("Student Added");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void viewStudents() {
        try {
            Connection con = DBConnection.getConnection();

            Statement st = con.createStatement();

            ResultSet rs =
                    st.executeQuery("SELECT * FROM student");

            while(rs.next()) {
                System.out.println(
                    rs.getInt("id") + " " +
                    rs.getString("name") + " " +
                    rs.getString("email") + " " +
                    rs.getString("course")
                );
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void updateStudent(int id, String course) {
        try {
            Connection con = DBConnection.getConnection();

            String sql =
                "UPDATE student SET course=? WHERE id=?";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setString(1, course);
            ps.setInt(2, id);

            int rows = ps.executeUpdate();

            if(rows > 0)
                System.out.println("Updated");

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteStudent(int id) {
        try {
            Connection con = DBConnection.getConnection();

            String sql =
                    "DELETE FROM student WHERE id=?";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if(rows > 0)
                System.out.println("Deleted");

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}