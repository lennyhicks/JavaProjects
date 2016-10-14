package Zoo;

/**
 * Created by lennyhicks on 10/13/16.
 */
public class Animal extends Zoo {
    String exhibit;
    public Animal(String name, String exhibit) {
        super(name);
        this.exhibit = exhibit;
    }

    public void listAnimals(){
        for (int i = 0; i < animal.size(); i++){
            Animal v = animal.get(i);
            String ex = "";
            if(v.exhibit.contains("Tiger")){
                ex = "[TIGER]";
            } else if(v.exhibit.contains("Aquarium")){
                ex = "[FISH]";
            } else if(v.exhibit.contains("Behind")){
                ex = "[GORILLA]";
            }
            debug(ex+" Name: "+ v.name+" Exhibit: "+v.exhibit);

        }
    }
}
