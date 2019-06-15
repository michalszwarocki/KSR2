package Data;

import java.sql.*;

public class DatabaseConnector {

    private final String url = "jdbc:postgresql://localhost:5432/FifaPlayers";
    private final String user = "postgres";
    private final String password = "javajestspoko";

    public Connection connect()
    {
        Connection conn = null;
        try
        {
            conn = DriverManager.getConnection(url, user, password);
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

        return conn;
    }
}
