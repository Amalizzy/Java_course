package chapter2;

import java.util.Scanner;

public class GrossPayCalculator {

    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the number of hours the employee worked:");
        int hours=scanner.nextInt();

        System.out.println("enter the employee pay rate");
        double rate=scanner.nextDouble();

        double grossPay=hours*rate;

        System.out.println("Gross pay is: "+grossPay);

        scanner.close();
    }
}
