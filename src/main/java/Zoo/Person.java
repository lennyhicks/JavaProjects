package Zoo;

/**
 * Created by lennyhicks on 10/13/16.
 */
public class Person extends Zoo {
    int age;
    String gender;

    public Person(String name, int age, String gender) {
        super(name);
        this.age = age;
        this.gender = gender;

    }
}

