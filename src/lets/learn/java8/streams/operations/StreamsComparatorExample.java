package lets.learn.java8.streams.operations;

import lets.learn.java8.data.Student;
import lets.learn.java8.data.StudentDatabase;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsComparatorExample {

    public static void main(String[] args){

       List<Student> studentNames = StudentDatabase.getAllStudents().stream()
                .sorted(Comparator.comparing(Student::getName)
                        .reversed()) // it will sort in reverse order
                .collect(Collectors.toList());

       System.out.println("Students sorted by name" + studentNames);

    }
}
