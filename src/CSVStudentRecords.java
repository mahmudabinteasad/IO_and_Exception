import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student {
    String name;
    int rollNumber;
    double marks;

    public Student(String name, int rollNumber, double marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks;
    }
    @Override
    public String toString() {
        return rollNumber + ", " + name + ", " + marks;
    }
}
public class CSVStudentRecords {
    public static void main(String[] args) {
        String filename = "students.csv";
        List<Student> students = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                String name = values[0];
                int rollNumber = Integer.parseInt(values[1]);
                double marks = Double.parseDouble(values[2]);
                students.add(new Student(name, rollNumber, marks));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Student student : students) {
            System.out.println(student);
        }

    }
}
