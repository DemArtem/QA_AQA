package Task6;
import java.util.HashSet;
import java.util.Set;
import static Task6.StudentManager.*;
import static Task6.StudentManager.printStudents;
public class MainStudent {
    public static void main(String[] args) {
        Set<Student> students = new HashSet<>();

        students.add(new Student("Иванов И.K.", "Группа 1", 1, new int[]{4, 5, 3}));
        students.add(new Student("Петров O.П.", "Группа 2", 1, new int[]{2, 3, 4}));
        students.add(new Student("Сидоров Д.С.", "Группа 1", 2, new int[]{2, 3, 2}));
        students.add(new Student("Кузнецов К.З.", "Группа 2", 2, new int[]{5, 4, 3}));

        removeLowPerformingStudents(students);
        promoteStudents(students);
        printStudents(students, 1);
        printStudents(students, 2);
    }
}
