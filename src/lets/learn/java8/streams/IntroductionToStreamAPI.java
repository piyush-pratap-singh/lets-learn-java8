package lets.learn.java8.streams;

// Introduced as part of java 8
// Main purpose is to perform some operations on collections and arrays
// Stream is a sequence of elements which can be created out of collections such as List, Arrays.

import lets.learn.java8.data.Student;
import lets.learn.java8.data.StudentDatabase;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class IntroductionToStreamAPI {

    public static void main(String[] args){

        // Student name and their activities in a map
        Map<String, List<String>> map1 = StudentDatabase.getAllStudents().stream().
                collect(Collectors.toMap(student -> { // using lambda expressions
                    return student.getName();
                }, student->{
                    return student.getActivities();
                }));
        System.out.println(map1);

        Map<String, List<String>> map2 = StudentDatabase.getAllStudents().stream().
                collect(Collectors.
                        toMap(Student::getName, Student::getActivities)); // using method references
        System.out.println(map2);

        // implement filter() use case
        Predicate<Student> predicate1 = student -> student.getGradeLevel() >=3;
        Predicate<Student> predicate2 = student -> student.getGpa() >= 3.9;

        Map<String, List<String>> map3 = StudentDatabase.getAllStudents().stream().
                filter(predicate1). // using filter() which is taking predicate as a parameters
                filter(predicate2). //  this will give Stream<Student>
                collect(Collectors. // this will give desired results
                        toMap(Student::getName, Student::getActivities)); // using method references which
                                                                          // is taking functions as a parameter
        System.out.println(map3);

        Map<String, List<String>> map4 = StudentDatabase.getAllStudents().stream().
                peek(student -> {   // peek() will take consumer as a parameter
                    System.out.println("Before any filter() method" + student); // it will give all students
                }).
                filter(predicate1). // using filter() which is taking predicate as a parameters
                peek(student -> {   // peek() will take consumer as a parameter
                    System.out.println("After first filter() method" + student);
               }).
                filter(predicate2). //  this will give Stream<Student>
                peek(student -> {   // peek() will take consumer as a parameter
                     System.out.println("After second filter() method" + student);
               }).
                collect(Collectors. // this will give desired results
                toMap(Student::getName, Student::getActivities)); // using method references which
                                                                 // is taking functions as a parameter
        System.out.println(map4);
    }
}
