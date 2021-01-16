package chapter3;

import java.util.Scanner;

public class DollarGame {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("How many pennies? ");
        int penniInput = scanner.nextInt();
        System.out.println("How many nickles? ");
        int nickleInput = scanner.nextInt();
        System.out.println("How many dimes?");
        int dimeInput = scanner.nextInt();
        System.out.println("How many quarters?");
        int quarterInput = scanner.nextInt();

        int penni = 1 * penniInput;
        int nickle = 5 * nickleInput;
        int dime = 10 * dimeInput;
        int quarter = 25 * quarterInput;

        int score = 100;

        int total = penni + nickle + dime + quarter;

        if (total > score) {
            int difference = total - score;
            System.out.println("You went over the ideal score by" + difference);
        } else if (total < score) {
            int dif = score - total;
            System.out.println("You were short by" + dif);
            }else{
                System.out.println("Perfect");
            }
        }
    }
