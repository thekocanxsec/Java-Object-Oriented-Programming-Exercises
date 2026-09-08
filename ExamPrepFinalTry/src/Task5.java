import java.sql.*;

public class Task5 {
}

class Database{
    private static final String CONNECTION_STRING = "jdbc:mysql://oop.ibu.edu.ba:3306/oopgroup1?allowPublicKeyRetrieval=true";
    private static final String USERNAME = "oopuser";
    private static final String PASSWORD = "ooppassWD";
    private Connection connection = null;

    public Database(){
        try{
            connection = DriverManager.getConnection(CONNECTION_STRING, USERNAME,PASSWORD);
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void getUsers(String name, int id){
        String query = "SELECT * FROM users WHERE name != ? AND id <= ?";

        try(PreparedStatement stmt = this.connection.prepareStatement(query)){
            stmt.setString(1, name);
            stmt.setInt(2,id);

            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                System.out.println(rs.getInt("id") + " - " + rs.getString("name"));
            }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
}
