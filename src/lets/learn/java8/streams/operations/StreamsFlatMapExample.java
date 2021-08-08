package lets.learn.java8.streams.operations;

import lets.learn.java8.data.Student;
import lets.learn.java8.data.StudentDatabase;

import java.util.List;

import static java.util.stream.Collectors.toList;

// flatMap() : convert one form to another : used with Stream<List>
public class StreamsFlatMapExample {

    public static void main(String[] args){

        List<String> list = StudentDatabase.getAllStudents().stream(). // Stream<Student>
                map(Student::getActivities) // Stream<List<String>>
                .flatMap(List::stream). // Stream<String>
                distinct(). // it will give unique activities
                sorted().   // it will sort in ascending order
                collect(toList());

        System.out.println(list);

        // count operations
        long count = StudentDatabase.getAllStudents().stream(). // Stream<Student>
                map(Student::getActivities) // Stream<List<String>>
                .flatMap(List::stream). // Stream<String>
                distinct(). // it will give unique activities
                count();

        System.out.println(count);

    }

}
