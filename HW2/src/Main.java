import java.io.IOException;
import java.util.Scanner;

public class Main {
    static Group group;

    public static void main(String[] args) throws IOException {
        group = new Group("HW2/src/group.txt");
        int command;
        do {
            printMenu();
            command = getCommand(3, "команду");
            switch (command) {
                case 1 -> setMarkToRandomStudent();
                case 2 -> printStudentWithMark();
            }
        } while (command != 3);
        group.save();
    }

    private static void printStudentWithMark() {
        System.out.println("Список студентов с оценками:");
        for (Student student : group.getStudentsWithMark()) {
            System.out.println(student);
        }
        System.out.println();
    }

    private static void setMarkToRandomStudent() {
        Student randomStudent = group.randomNotMissingStudent();
        System.out.printf("Случайный студент: %s\n\n", randomStudent);
        System.out.print(
                """
                Присутсвует ли на паре?
                1. Да
                2. Нет
                
                """);
        int command = getCommand(2, "команду");
        if (command == 1) {
            int mark = getCommand(10, "оценку");
            randomStudent.isPresent = true;
            randomStudent.setMark(mark);
            System.out.println();
        } else {
            randomStudent.isPresent = false;
            System.out.println();
        }
    }

    private static int getCommand(Integer commandCount, String whatToAsk) {
        int command = -1;
        Scanner in = new Scanner(System.in);
        System.out.printf("Введите %s(число от 1 до %d):\n> ", whatToAsk, commandCount);
        command = in.nextInt();
        while (command > commandCount || command < 1) {
            System.out.println("Неправильный формат входных данных!");
            System.out.printf("Введите %s(число от 1 до %d):\n> ", whatToAsk, commandCount);
            command = in.nextInt();
        }
        return command;
    }

    private static void printMenu() {
        System.out.println(
                """
                Меню:
                1. Поставить оценку случайному студенту
                2. Показать список студентов с оценками
                3. Выход
                """);
    }
}