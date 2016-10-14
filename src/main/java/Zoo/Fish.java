package Zoo;

/**
 * Created by lennyhicks on 10/13/16.
 */
public class Fish extends Animal {
    public Fish(String name, String exhibit) {
        super(name, exhibit);
    }

    public Fish gor() {
    try {
        debug("What is your Fishs name");
        name = input.nextLine();
        Fish gor = new Fish(name, ENUMIMALS.FISH.getHabitat());
        return gor;
    }catch (Exception e){
        debug("Please try again");
        gor();
        return null;
    }
    }

    public void addFish(){
        Fish g = gor();
        animal.add(g);
        debug("Fish Created");
    }
}
