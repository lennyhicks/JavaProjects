package Zoo;

/**
 * Created by lennyhicks on 10/13/16.
 */
public class Visistor extends Person {
    public Visistor(String name, int age, String gender) {
        super(name, age, gender);
        this.name = name;
        this.age = age;

    }



    public Visistor vis() {
try {
    debug("What is your persons name");
    name = input.nextLine();
    debug("What is the age?");
    age = input.nextInt();
    input.nextLine();
    debug("What is the gender?");
    debug("1.) Male");
    debug("2.) Female");
    int genderc = input.nextInt();
    input.nextLine();
    switch (genderc) {
        case 1:
            gender = "Male";
            break;
        case 2:
            gender = "Female";
            break;
        default:
            debug("Please try again");
            vis();
            break;
    }
    Visistor vis = new Visistor(name, age, gender);
    return vis;
}catch (Exception e){
    debug("Error Please Try again");
    input.nextLine();
    vis();
    return null;
}
    }

    public void addVisitor(){
        Visistor p = vis();
        visistor.add(p);
        debug("Visitor Created");
        listVisitor();
    }

    public void listVisitor(){
        for (int i = 0; i < visistor.size(); i++){
            Visistor v = visistor.get(i);
            debug("[Visitor] Name: "+ v.name+" Age: "+ v.age+" Gender: "+v.gender);

        }
    }
}
