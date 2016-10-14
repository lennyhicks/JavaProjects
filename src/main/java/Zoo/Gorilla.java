package Zoo;

/**
 * Created by lennyhicks on 10/13/16.
 */
public class Gorilla extends Animal {
    public Gorilla(String name, String exhibit) {
        super(name, exhibit);
    }


    public Gorilla gor() {
try {
    debug("What is your Gorillas name");
    name = input.nextLine();
    Gorilla gor = new Gorilla(name, ENUMIMALS.GORILLA.getHabitat());
    if (name.equalsIgnoreCase("harambe")) {
        name = "SHOT";

        gor = new Gorilla(name, "DONE DEAD");
    }
    return gor;
}catch (Exception e){
    debug("Please try again.");
    gor();
    return null;
}
    }

    public void addGorilla(){
        Gorilla g = gor();
        animal.add(g);
        debug("Gorilla Created");
    }
}
