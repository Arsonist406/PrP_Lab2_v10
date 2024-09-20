package main;

import model.Train;
import java.time.LocalTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Train[] TrainArr = createArray(scanner);
        printArray(TrainArr);

        taskA(TrainArr, scanner);
        taskB(TrainArr, scanner);
        taskC(TrainArr, scanner);

        scanner.close();
    }

    public static Train[] createArray(Scanner scanner) {
        Train[] TrainArr = new Train[5];

        TrainArr[0] = new Train("Львів", 9273, LocalTime.of(14, 50), 60,
                30, 20, 10);
        TrainArr[1] = new Train("Львів", 8814, LocalTime.of(23, 35), 0,
                0, 0, 50);
        TrainArr[2] = new Train("Єрусалим", 8228, LocalTime.of(6, 10), 300,
                0, 0, 4);
        TrainArr[3] = new Train("Катовіце", 5555, LocalTime.of(17, 17), 45,
                25, 25, 0);

        System.out.println("\nЧи хочете ви створити свій запис Так(1)/Ні(0)?");
        if (scanner.nextInt() == 1) {
            TrainArr[4] = new Train("0", 0, LocalTime.of(1, 1),
                    0, 0, 0, 0);
            scanner.nextLine();
            System.out.println("\nВведіть пункт призначення: ");
            TrainArr[4].setDestination(scanner.nextLine());

            System.out.println("\nВведіть номер поїзда: ");
            TrainArr[4].setTrainNumber(scanner.nextInt());

            int hour;
            while (true) {
                System.out.println("\nВведіть годину прибуття: ");
                hour = scanner.nextInt();
                if (hour >= 0 && hour < 24) {
                    break;
                }
                System.out.println("\n*Поїзд не може прибути о цій годині.");
            }
            int minute;
            while (true) {
                System.out.println("\nВведіть хвилину прибуття: ");
                minute = scanner.nextInt();
                if (minute >= 0 && minute < 60) {
                    break;
                }
                System.out.println("\n*Поїзд не може прибути о цій хвилині. Повторіть введення.");
            }
            TrainArr[4].setDispatchTime(LocalTime.of(hour, minute));

            System.out.println("\nВведіть кількість загальних місць: ");
            TrainArr[4].setGeneralPlaces(scanner.nextInt());

            System.out.println("\nВведіть кількість місць-купе: ");
            TrainArr[4].setKupePlaces(scanner.nextInt());

            System.out.println("\nВведіть кількість місць-платцкартів: ");
            TrainArr[4].setPlatskartPlaces(scanner.nextInt());

            System.out.println("\nВведіть кількість люкс місць: ");
            TrainArr[4].setLuxPlaces(scanner.nextInt());
        }
        else {
            TrainArr[4] = new Train("Катовіце", 4166, LocalTime.of(4, 40),
                    0, 20, 20, 4);
        }
        return TrainArr;
    }

    public static void printArray(Train[] arr) {
        for (int i = 0; i != arr.length; i++) {
            System.out.println(arr[i].toString());
        }
    }

    public static void taskA(Train[] TrainArr, Scanner scanner) {
        scanner.nextLine();
        System.out.println("\nTask a)\nВведіть пункт призначення:");
        String destination = scanner.nextLine();

        boolean inArr = false;

        for (int i = 0; i != TrainArr.length; i++) {
            if (TrainArr[i].getDestination().equals(destination)) {
                System.out.println(TrainArr[i].toString());
                inArr = true;
            }
        }
        if (!inArr) {
            System.out.println("*Поїздів, які прямують у це місто в списку не має.");
        }
    }

    public static void taskB(Train[] TrainArr, Scanner scanner) {
        scanner.nextLine();
        System.out.println("\nTask b)\nВведіть пункт призначення:");
        String destination = scanner.nextLine();

        int hour;
        while (true) {
            System.out.println("\nВведіть годину прибуття: ");
            hour = scanner.nextInt();
            if (hour >= 0 && hour < 24) {
                break;
            }
            System.out.println("\nПоїзд не може прибути о цій годині.");
        }
        int minute;
        while (true) {
            System.out.println("\nВведіть хвилину прибуття: ");
            minute = scanner.nextInt();
            if (minute >= 0 && minute < 60) {
                break;
            }
            System.out.println("\n*Поїзд не може прибути о цій хвилині. Повторіть введення.");
        }

        LocalTime time = LocalTime.of(hour, minute);

        boolean inArr = false;

        for (int i = 0; i != TrainArr.length; i++) {
            if (TrainArr[i].getDestination().equals(destination) && TrainArr[i].getDispatchTime().isAfter(time)) {
                System.out.println(TrainArr[i].toString());
                inArr = true;
            }
        }
        if (!inArr) {
            System.out.println("\n*Поїздів, які прямують у це місто, після вказаної години в списку не має.");
        }
    }

    public static void taskC(Train[] TrainArr, Scanner scanner) {
        scanner.nextLine();
        System.out.println("\nTask с)\nВведіть пункт призначення:");
        String destination = scanner.nextLine();

        boolean inArr = false;

        for (int i = 0; i != TrainArr.length; i++) {
            if (TrainArr[i].getDestination().equals(destination) && TrainArr[i].getGeneralPlaces() != 0) {
                System.out.println(TrainArr[i].toString());
                inArr = true;
            }
        }
        if (!inArr) {
            System.out.println("\n*Поїздів, які прямують у це місто з загальними місцями в списку не має.");
        }
    }
}
