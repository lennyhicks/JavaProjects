package Zoo;

/**
 * Created by lennyhicks on 10/13/16.
 */
public class Tiger extends Animal {
    public Tiger(String name, String exhibit) {
        super(name, exhibit);
    }



    public Tiger gor() {
try {
    debug("What is your Tigers name");
    name = input.nextLine();
    Tiger gor = new Tiger(name, ENUMIMALS.TIGER.getHabitat());
    return gor;
}catch (Exception e){
    debug("Please try again");
    gor();
    return null;
}
    }

    public void addTiger(){
        Tiger g = gor();
        animal.add(g);
        debug("Tiger Created");
    }
}
