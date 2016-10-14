package Zoo;

/**
 * Created by lennyhicks on 10/12/16.
 */
public enum ENUMIMALS {
    TIGER("Tiger's Den"),
    FISH("Aquarium."),
    GORILLA("Behind the stick fence.");



    String getHabitat;

    ENUMIMALS(String getHabitat) {
        this.getHabitat = getHabitat;

    }

    public String getHabitat(){
        return getHabitat;
    }
}
