import java.util.Scanner;

public class Main{
    public static void main(String args[]){
        University university = new University("Politecnico di Torino");
        boolean run = true;
        int choice = 0, studentID, courseID;

        Scanner scanner = new Scanner(System.in);

        university.readStudentsFromFile();

        while(run){
            System.out.println("\n1) Operation on students;\n2) Operation on Courses;\n3) Exit;");
            System.out.print("Insert the integer number associated to the kind of operation you want to perform: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // to get rid of the \n left behind by nextInt

            switch(choice){
                case 1:
                    System.out.println("1) To enroll a new student;\n2) To see all the student ordered by ID;\n3) To write the students on a File;");
                    System.out.println("4) Enroll a student in a Course;\n5) See courses of a student;");
                    System.out.print("Insert the integer number associated to the kind of operation you want to perform: ");
                    choice = scanner.nextInt();
                    scanner.nextLine(); // to get rid of the \n left behind by nextInt

                    switch(choice){
                        case 1:
                            String name, surname;

                            System.out.print("Insert the name of the student to enroll: ");
                            name = scanner.nextLine();

                            System.out.print("Insert the surname of the student to enroll: ");
                            surname = scanner.nextLine();

                            university.enroll(name, surname);
                            break;
                        case 2:
                            university.getStudentsOrderedByID().stream().forEach(System.out::println);
                            break;
                        case 3:
                            university.registerStudentsOnFile();
                            break;
                        case 4:
                            System.out.print("Insert the ID of the student you want to enroll in a course: ");
                            studentID = scanner.nextInt();
                            scanner.nextLine(); // to get rid of the \n left behind by nextInt
                            System.out.print("Insert the ID of the course you want to enroll the student in: ");
                            courseID = scanner.nextInt();
                            scanner.nextLine(); // to get rid of the \n left behind by nextInt
                            university.addACourseToAStudent(studentID, courseID);

                            break;
                        case 5:
                            System.out.print("Insert the ID of the student you want the see the courses of: ");
                            studentID = scanner.nextInt();
                            scanner.nextLine(); // to get rid of the \n left behind by nextInt
                            university.getCoursesOfAStudentByID(studentID).stream().forEach(System.out::println);
                            break;
                        default:
                            System.out.println("\n\nNessun azione corrispondente al codice inserito\n");
                            break;
                    }

                    break;
                case 2:
                    System.out.println("1) To activate a new Course;\n2) To see the active courses ordered by ID;");
                    System.out.print("Insert the integer number associated to the kind of operation you want to perform: ");
                    choice = scanner.nextInt();
                    scanner.nextLine(); // to get rid of the \n left behind by nextInt

                    switch(choice){
                        case 1:
                            String name;

                            System.out.print("Insert the name of the course to activate: ");
                            name = scanner.nextLine();

                            university.activateCourse(name);

                            break;
                        case 2:
                            university.getCoursesOrderedByID().stream().forEach(System.out::println);
                            break;
                        default:
                            System.out.println("\n\nNessun azione corrispondente al codice inserito\n");
                            break;
                    }

                    break;
                case 3:
                    run = false;
                    break;
                default:
                    System.out.println("\n\nNessun azione corrispondente al codice inserito\n");
                    break;
            }
        }

        scanner.close();
    }
}