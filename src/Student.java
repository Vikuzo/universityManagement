import java.util.Collection;
import java.util.SortedSet;
import java.util.TreeSet;

class Student extends Person{
    /*  variables */
    private int studentID;

    private SortedSet<Course> courses = new TreeSet<>();

    /* constructors */
    public Student(String name, String surname, int studentID){
        super(name, surname);

        this.studentID = studentID;
    }

    /* operative methods */
    public Course enroll(Course c){
        courses.add(c);
        return c;
    }

    /* overridden methods */
    @Override
    public String toString(){return "Name: " + getName() + "\nSurname: " + getSurname() + "\nMatricola: " + studentID + "\n";}

    @Override
    public boolean equals(Object student){
        if(student instanceof Student){
            return ((Student)student).getStudentID() == studentID ? true : false;
        }

        return false;
    }

    /* getters and setters */
    public Collection<Course> getCourses(){return courses;}
    public int getStudentID(){return studentID;}
    
}