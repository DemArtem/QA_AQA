package Task6;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import static Task6.StudentManager.*;
import static Task6.StudentManager.printStudents;
/*
Создайте класс Student, содержащий следующие характеристики – имя, группа, курс, оценки по предметам.
Создайте коллекцию, содержащую объекты класса Student. Следует написать метод, который удаляет студентов со средним баллом < 3,
а также отдельный метод, который переводит студента на следующий курс, если средний балл >= 3.
Напишите метод printStudents(Set<Student> students, int course), который получает список студентов и номер курса.
Метод печатает на консоль имена тех студентов, которые обучаются на данном курсе.
 */
class Student {
    private String name;
    private String group;
    private int course;
    private int[] grades;

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

    public Student(String name, String group, int course, int[] grades) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.grades = grades;
    }

    public String getName() {
        return name;
    }

    public String getGroup() {
        return group;
    }

    public int getCourse() {
        return course;
    }

    public int[] getGrades() {
        return grades;
    }

    public double getAverageGrade() {
        double sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return sum / grades.length;
    }

    public void promote() {
        this.course++;
    }
}

public class StudentManager {
    public static void removeLowPerformingStudents(Set<Student> students) {
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getAverageGrade() < 3) {
                iterator.remove();
            }
        }
    }

    public static void promoteStudents(Set<Student> students) {
        for (Student student : students) {
            if (student.getAverageGrade() >= 3) {
                student.promote();
            }
        }
    }

    public static void printStudents(Set<Student> students, int course) {
        System.out.println("Студенты на курсе " + course + ":");
        for (Student student : students) {
            if (student.getCourse() == course) {
                System.out.println(student.getName());
            }
        }
    }
}