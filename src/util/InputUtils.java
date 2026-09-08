package util;

import java.util.Scanner;

public class InputUtils {

    public static double lireDouble(Scanner scanner , String label){
        double input=0;
        try {
            System.out.print(label+" ");
            input = scanner.nextDouble();
        }catch (NumberFormatException e){
            // System.out.println("s'il vous plais saisir votre choix ");
            InputUtils.lireDouble(scanner,label);
        }
        return input;
    }
    public static String lireString(Scanner scanner , String label){
        String input;
        System.out.print(label+" ");
        do {
            input = scanner.nextLine();
        }while (input.isEmpty());
        return input;
    }

}
