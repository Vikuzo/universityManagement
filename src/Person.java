import java.io.Serializable;

public class Person extends Object implements Serializable{
    /*  variables */
    private String name, surname;

    /* constructors */
    public Person(String name, String surname){
        this.name = name;
        this.surname = surname;
    }

    /* operative methods */

    /* overridden methods */

    /* getters and setters */
    public String getName(){return name;}
    public String getSurname(){return surname;}

    public void setName(String name){this.name = name;}
    public void setSurname(String surname){this.surname = surname;}
}