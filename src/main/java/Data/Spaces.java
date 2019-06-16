package Data;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Spaces {
    private List<Player> listOfPlayers;

    private List<String> listOfNames;
    private List<Double> listOfAges;
    private List<Double> listOfWages;
    private List<Double> listOfWeights;
    private List<Double> listOfInterceptions;
    private List<Double> listOfCrossings;
    private List<Double> listOfFinishing;
    private List<Double> listOfDribbling;
    private List<Double> listOfShotPowers;
    private List<Double> listOfJumpings;
    private List<Double> listOfReactions;


    public Spaces(){
        this.listOfPlayers = new ArrayList<>();

        DatabaseConnector databaseConnector = new DatabaseConnector();
        DataReader dataReader = new DataReader(databaseConnector);
        dataReader.readData(this.listOfPlayers);

        this.listOfNames = new ArrayList<>();
        this.listOfAges = new ArrayList<>();
        this.listOfWages = new ArrayList<>();
        this.listOfWeights = new ArrayList<>();
        this.listOfInterceptions = new ArrayList<>();
        this.listOfCrossings = new ArrayList<>();
        this.listOfFinishing = new ArrayList<>();
        this.listOfDribbling = new ArrayList<>();
        this.listOfShotPowers = new ArrayList<>();
        this.listOfJumpings = new ArrayList<>();
        this.listOfReactions = new ArrayList<>();

        splitToLists();
    }

    public void splitToLists(){
        for(Player player : listOfPlayers)
        {
            this.listOfNames.add(player.getName());
            this.listOfAges.add((double) player.getAge());
            this.listOfWages.add((double) player.getWage());
            this.listOfWeights.add((double) player.getWeight());
            this.listOfInterceptions.add((double) player.getInterceptions());
            this.listOfCrossings.add((double) player.getCrossing());
            this.listOfFinishing.add((double) player.getFinishing());
            this.listOfDribbling.add((double) player.getDribbling());
            this.listOfShotPowers.add((double) player.getShotPower());
            this.listOfJumpings.add((double) player.getJumping());
            this.listOfReactions.add((double) player.getReactions());
        }
    }
}
