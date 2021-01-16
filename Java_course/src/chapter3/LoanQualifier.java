package chapter3;

import java.util.Scanner;

public class LoanQualifier {

    public static void main(String[] args) {

        int minIncome=30000;
        int minEmployed=2;

        System.out.println("Enter your yearly income: ");
        Scanner scanner=new Scanner(System.in);
        int income= scanner.nextInt();
        System.out.println("How long have you been working your current job: ");
        int employed= scanner.nextInt();
        scanner.close();

        if(income>=minIncome && employed>=minEmployed){
            System.out.println("All conditions met!");
        }else{
            System.out.println("Sorry ");
        }

    }
}
