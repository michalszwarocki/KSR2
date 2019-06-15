package Data;

import java.sql.*;
import java.util.List;

public class DataReader {
    private DatabaseConnector databaseConnector;

    public DataReader(DatabaseConnector databaseConnector){
        this.databaseConnector = databaseConnector;
    }

    public void readData(List<Player> playersList){

        String SQL = "SELECT * FROM players";
        try
        {
            Connection connection = databaseConnector.connect();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next())
            {
                int id = Integer.parseInt(rs.getString("id"));
                String name = rs.getString("name");
                int age = Integer.parseInt(rs.getString("age"));
                int wage = Integer.parseInt(rs.getString("wage"));
                int weight = Integer.parseInt(rs.getString("weight"));
                int crossing = Integer.parseInt(rs.getString("crossing"));
                int finishing = Integer.parseInt(rs.getString("finishing"));
                int dribbling = Integer.parseInt(rs.getString("dribbling"));
                int reactions = Integer.parseInt(rs.getString("reactions"));
                int shotpower = Integer.parseInt(rs.getString("shotpower"));
                int jumping = Integer.parseInt(rs.getString("jumping"));
                int interceptions = Integer.parseInt(rs.getString("interceptions"));
                Player player = new Player(id, name, age, wage, weight, interceptions,
                        crossing, finishing, dribbling, shotpower, jumping, reactions);
                playersList.add(player);
            }
            rs.close();
        }
        catch (SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
    }
}
