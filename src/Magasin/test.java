package Magasin;

import java.text.DecimalFormat;
import java.util.Scanner;

public class test {

    public static Scanner scanner = new Scanner(System.in);
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public static void main(String[] args) {

//        scanner.useDelimiter("\\n");
//        int choice = scanner.nextInt();
//
//        switch (choice) {
//            case 1:
//                System.out.println("machin");
//                break;
//            case 2:
//                System.out.println("Enter your name:");
//                String name = "";
//
//                name += scanner.next();
//
//                System.out.println("Your name is : " + name);
//        }
        double input = 3.14159265359;
        System.out.println("double : " + df.format(input));    //3.14
        String s = df.format(input).replace(",", ".");
        double machin = Double.parseDouble(s);
        System.out.println(machin);

    }
}

