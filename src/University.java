import java.util.*;
import java.util.function.Predicate;
import java.io.*;
import java.nio.file.Path;

// import java.util.stream.Collectors;

public class University {
    /*  variables */
    public static final int STUDENT_ID = 1000;
    public static final int COURSE_ID = 100;

    private String name;

    private Set<Student> students = new HashSet<>();
    private Set<Course> courses = new HashSet<>();

    /* constructors */
    public University(String name){
        this.name = name;
    }

    /* operative methods */
    public Student enroll(String name, String surname){
        Student s = new Student(name, surname, STUDENT_ID + students.size());
        students.add(s);

        return s;
    }

    public Optional<Student> searchStudentByID(int studentID){
        Predicate<Student> p = o -> studentID == o.getStudentID();
        Optional<Student> s = students.stream().filter(p).findAny();

        return s;
    }

    public Collection<Student> getStudents(){return students;}

    public Collection<Student> searchStudentByName(String name){
        Predicate<Student> p = o -> o.getName().equals(name);
        Collection<Student> s = students.stream().filter(p).toList();

        return s;
    }

    public Collection<Student> searchByStudentSurame(String surname){
        Predicate<Student> p = o -> o.getSurname().equals(surname);
        Collection<Student> s = students.stream().filter(p).toList();

        return s;
    }

    public Collection<Student> getStudentsOrderedByID(){
        Comparator<Student> c = (a, b) -> {return a.getStudentID() - b.getStudentID();};
        return students.stream().sorted(c).toList();
    }

    public Collection<Student> getStudentsOrderedBySurname(){
        Comparator<Student> c = (a, b) -> {
            if(a.getSurname().equals(b.getSurname()))
                return a.getName().compareTo(b.getName());
            return a.getSurname().compareTo(b.getSurname());
        };
        return students.stream().sorted(c).toList();
    }

    public void addACourseToAStudent(int studentID, int courseID) throws NoSuchElementException{
        searchStudentByID(studentID).get().enroll(searchCourseByID(courseID).get());
    }

    public void registerStudentsOnFile(){
        Path path = Path.of("universityManagement/resources/files/students.ser");

        try{
            ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(path.toString()));
            for(Student s: students){writer.writeObject(s);}
            writer.close();

        }catch(IOException ioe){
            System.out.println("Not able to open such file. Cause: " + ioe.toString());
        }
    }

    public void readStudentsFromFile(){
        Path path = Path.of("universityManagement/resources/files/students.ser");

        try{
            ObjectInputStream reader = new ObjectInputStream(new FileInputStream(path.toString()));
            Student s;
            while((s = (Student)reader.readObject()) != null){students.add(s);}
            reader.close();
        }catch(EOFException eof){
        }catch(IOException ioe){
            System.out.println("Not able to open such file. Cause: " + ioe.toString());
        }catch(ClassNotFoundException cn){
            System.out.println("Not able to operate on the objects. Cause: " + cn.toString());
        }
    }

    public Course activateCourse(String name){
        Course c = new Course(name, COURSE_ID + courses.size());
        courses.add(c);

        return c;
    }

    public Optional<Course> searchCourseByID(int courseID){
        Predicate<Course> p = o -> o.getCourseID() == courseID;
        return courses.stream().filter(p).findAny();
    }

    public Collection<Course> getCourses(){return courses;}

    public Collection<Course> searchCourseByName(String name){
        Predicate<Course> p = o -> o.getName().equals(name);
        return courses.stream().filter(p).toList();
    }

    public Collection<Course> getCoursesOrderedByID(){
        Comparator<Course> c = (a,b) -> {return a.getCourseID() - b.getCourseID();};
        return courses.stream().sorted(c).toList();
    }

    public Collection<Course> getCoursesOrderedByName(){
        Comparator<Course> c = (a,b) -> {return a.getName().compareTo(b.getName());};
        return courses.stream().sorted(c).toList();
    }

    public Collection<Course> getCoursesOfAStudentByID(int studentID) throws NoSuchElementException{
        try{
            return searchStudentByID(studentID).get().getCourses();
        }catch(NoSuchElementException e){
            throw e;
        }
    }

    /* overridden methods */
    @Override
    public String toString(){return "University of " + name;}

    /* getters and setters */
    public String getName(){return name;}

    public void setName(String name){this.name = name;}
}
