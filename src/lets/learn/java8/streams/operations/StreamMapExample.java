package lets.learn.java8.streams.operations;

import lets.learn.java8.data.Student;
import lets.learn.java8.data.StudentDatabase;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toSet;

// map() : convert one form to another

public class StreamMapExample {

    public static void main(String[] args){

        List<String> studentNameList = StudentDatabase.getAllStudents().stream(). // Stream<Student>
                map(Student::getName). // Take input as a Student convert into String
                                      // Stream<Student>
                map(String::toUpperCase).   // convert each string to upper case
                collect(Collectors.toList()); // List<String>

        System.out.println(studentNameList);

        Set<String> studentNameSet = StudentDatabase.getAllStudents().stream(). // Stream<Student>
                map(Student::getName). // Take input as a Student convert into String
                                      // Stream<Student>
                        map(String::toUpperCase).   // convert each string to upper case
                collect(toSet()); // Set<String>

        System.out.println(studentNameSet);

    }
}
