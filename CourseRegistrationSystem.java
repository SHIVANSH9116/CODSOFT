import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Course {
    private String code;
    private String title;
    private String description;
    private int capacity;
    private int enrolled;

    public Course(String code, String title, String description, int capacity) {
        this.code = code;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.enrolled = 0;
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getEnrolled() {
        return enrolled;
    }

    public boolean isFull() {
        return enrolled >= capacity;
    }

    public void enrollStudent() {
        if (!isFull()) {
            enrolled++;
        }
    }

    public void dropStudent() {
        if (enrolled > 0) {
            enrolled--;
        }
    }
}

class Student {
    private int id;
    private String name;
    private List<Course> courses;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
        this.courses = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void registerCourse(Course course) {
        if (!courses.contains(course)) {
            courses.add(course);
            course.enrollStudent();
        }
    }

    public void dropCourse(Course course) {
        if (courses.contains(course)) {
            courses.remove(course);
            course.dropStudent();
        }
    }
}

public class CourseRegistrationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Course> courses = new ArrayList<>();
        List<Student> students = new ArrayList<>();
        
        courses.add(new Course("CSCI101", "Java Programming", "object-oriented programming   ",   30));
        courses.add(new Course("MATH202", "Calculus II", "        Advanced calculus topics", 25));
        courses.add(new Course("PHYS101", "Physics Fundamentals", "Introductory physics course", 40));
        
        int studentId = 1;
        
        while (true) {
            System.out.println("\nStudent Course Registration System");
            System.out.println("1. View Course Listing");
            System.out.println("2. Register for a Course");
            System.out.println("3. Drop a Course");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    displayCourseListing(courses);
                    break;
                case 2:
                    System.out.print("Enter your name: ");
                    scanner.nextLine();  
                    String studentName = scanner.nextLine();
                    Student student = new Student(studentId, studentName);
                    studentId++;
                    
                    displayCourseListing(courses);
                    
                    System.out.print("Enter the course code you want to register for: ");
                    String courseCode = scanner.next();
                    
                    Course selectedCourse = findCourseByCode(courses, courseCode);
                    if (selectedCourse != null) {
                        student.registerCourse(selectedCourse);
                        students.add(student);
                        System.out.println("Registration successful!");
                    } else {
                        System.out.println("Invalid course code.");
                    }
                    break;
                case 3:
                    System.out.print("Enter your student ID: ");
                    int studentID = scanner.nextInt();
                    Student selectedStudent = findStudentById(students, studentID);
                    
                    if (selectedStudent != null) {
                        displayStudentCourses(selectedStudent);
                        
                        System.out.print("Enter the course code you want to drop: ");
                        courseCode = scanner.next();
                        
                        selectedCourse = findCourseByCode(selectedStudent.getCourses(), courseCode);
                        
                        if (selectedCourse != null) {
                            selectedStudent.dropCourse(selectedCourse);
                            System.out.println("Course dropped successfully.");
                        } else {
                            System.out.println("Invalid course code.");
                        }
                    } else {
                        System.out.println("Invalid student ID.");
                    }
                    break;
                case 4:
                    System.out.println("Thank you for using the Course Registration System. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }

    private static void displayCourseListing(List<Course> courses) {
        System.out.println("\nCourse Listing:");
        System.out.println("Code\tTitle\t\t        Description\t\t  Capacity\tEnrolled");
        for (Course course : courses) {
            System.out.println(course.getCode() + "\t" + course.getTitle() + "\t" + course.getDescription() + "\t" + course.getCapacity() + "\t\t" + course.getEnrolled());
        }
    }

    private static Course findCourseByCode(List<Course> courses, String code) {
        for (Course course : courses) {
            if (course.getCode().equals(code)) {
                return course;
            }
        }
        return null;
    }

    private static void displayStudentCourses(Student student) {
        System.out.println("\nYour Registered Courses:");
        System.out.println("Code\tTitle\t\tDescription\t\tCapacity\tEnrolled");
        for (Course course : student.getCourses()) {
            System.out.println(course.getCode() + "\t" + course.getTitle() + "\t" + course.getDescription() + "\t" + course.getCapacity() + "\t\t" + course.getEnrolled());
        }
    }

    private static Student findStudentById(List<Student> students, int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }
}
