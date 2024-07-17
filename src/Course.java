import java.io.Serializable;

public class Course implements Comparable<Course>, Serializable{
    /*  variables */
    private String name;
    private int courseID;

    /* constructors */
    public Course(String name, int courseID){
        this.name = name;
        this.courseID = courseID;
    }

    /* operative methods */

    /* overridden methods */
    @Override
    public String toString(){return "Name: " + name + "\n" + "Course identificator: " + courseID + "\n";}

    @Override
    public boolean equals(Object course){
        if(course instanceof Course){
            return ((Course)course).getCourseID() == courseID ? true : false;
        }

        return false;
    }

    @Override
    public int compareTo(Course o){return courseID - o.getCourseID();}

    /* getters and setters */
    public int getCourseID(){return courseID;}
    public String getName(){return name;}

    public void setName(String name){this.name = name;}
}
