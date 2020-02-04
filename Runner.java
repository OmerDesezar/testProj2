package testPackage;

import java.time.LocalDate;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        OrderSystem system = OrderSystem.getInstance();
        system.getThread().start();
        Scanner input = new Scanner(System.in);
        String action = "";
        while (!action.equalsIgnoreCase("exit")) {
            //sleep just for the console output logic
            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("pick an action (exit, get, add)");
            action = input.nextLine();
            if (action.equalsIgnoreCase("get")) {
                System.out.println(system.getOrders());
            }
            if (action.equalsIgnoreCase("add")) {
                System.out.printf("did it work? %b\n", system.addOrder(initOrder()));
            }
        }
        input.close();
    }
    //initializers
    private static LocalDate initDate() {
        Scanner input = new Scanner(System.in);
        System.out.println("please enter year the order will be ready on");
        int year = input.nextInt();
        System.out.println("please enter month the order will be ready on");
        int month = input.nextInt();
        System.out.println("please enter day the order will be ready on");
        int day = input.nextInt();
        input.close();
        return LocalDate.of(year,month,day);
    }

    private static Order initOrder() {
        LocalDate validate = initDate();
        Scanner input = new Scanner(System.in);
        System.out.println("please enter the order ready message");
        String message = input.nextLine();
        System.out.println("is the order important? (true/false)");
        boolean important = input.nextBoolean();
        while (validate.isBefore(LocalDate.now())) {
            System.out.println("your date is from the past, please pick a new date");
            validate = initDate();
        }
        input.close();
        return new Order(validate,message,important);
    }
}
