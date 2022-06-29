package machine;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class CoffeeMachine {



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int waterAmount = 400;
        int milkAmount = 540;
        int coffeeAmount = 120;
        int cupsAmount = 9;
        int moneyAmount = 550;
        int[] consumeInfo;

        executing:
        while (true) {
            String action = scanner.next();

            switch (action) {
                case "buy":
                    if (!scanner.hasNextInt()) {
                        break;
                    };

                    int coffee = scanner.nextInt();
                    consumeInfo = makeCoffee(coffee, waterAmount, milkAmount, coffeeAmount, cupsAmount, moneyAmount);

                    if (consumeInfo[0] > waterAmount) {
                        System.out.println("Sorry, not enough water!");
                    } else if (consumeInfo[1] > milkAmount) {
                        System.out.println("Sorry, not enough milk!");
                    } else if (consumeInfo[2] > coffeeAmount) {
                        System.out.println("Sorry, not enough coffee beans!");
                    } else if (cupsAmount == 0) {
                        System.out.println("Sorry, not enough disposable cups!");
                    } else {
                        System.out.println("I have enough resources, making you a coffee!");
                        waterAmount -= consumeInfo[0];
                        milkAmount -= consumeInfo[1];
                        coffeeAmount -= consumeInfo[2];
                        cupsAmount -= 1;
                        moneyAmount += consumeInfo[3];
                    }
                    break;

                case "fill":
                    System.out.println("Write how many ml of water you want to add:");
                    int waterAdded = scanner.nextInt();

                    System.out.println("Write how many ml of milk you want to add:");
                    int milkAdded = scanner.nextInt();

                    System.out.println("Write how many grams of coffee beans you want to add:");
                    int beansAdded = scanner.nextInt();

                    System.out.println("Write how many disposable cups of coffee you want to add:");
                    int cupsAdded = scanner.nextInt();

                    waterAmount += waterAdded;
                    milkAmount += milkAdded;
                    coffeeAmount += beansAdded;
                    cupsAmount += cupsAdded;

                    break;

                case "take":
                    System.out.println(String.format("I gave you $%s", moneyAmount));
                    moneyAmount = 0;
                    break;

                case "remaining":
                    currentState(waterAmount, milkAmount, coffeeAmount, cupsAmount, moneyAmount);
                    break;

                case "exit":
                    break executing;

                default:
                    break;
            }
        }

    }

    private static void currentState(int waterAmount, int milkAmount, int coffeeAmount, int cupsAmount, int moneyAmount) {
        System.out.println(String.format("The coffee machine has:\n" +
                "%s ml of water\n" +
                "%s ml of milk\n" +
                "%s g of coffee beans\n" +
                "%s disposable cups\n" +
                "$%s of money", waterAmount, milkAmount, coffeeAmount, cupsAmount, moneyAmount));
    }

    private static int[] makeCoffee(int coffee, int waterAmount, int milkAmount, int coffeeAmount, int cupsAmount, int moneyAmount) {
        int waterConsume = 0;
        int milkConsume = 0;
        int beansConsume = 0;
        int moneyEarned = 0;

        final int espressoWater = 250;
        final int espressoBeans = 16;
        final int espressoEarned = 4;

        final int latteWater = 350;
        final int latteMilk = 75;
        final int latteBeans = 20;
        final int latteEarned = 7;

        final int cappuccinoWater = 200;
        final int cappuccinoMilk = 100;
        final int cappuccinoBeans = 12;
        final int cappuccinoEarned = 6;

        switch (coffee) {
            case 1:
                waterConsume += espressoWater;
                milkConsume += 0;
                beansConsume += espressoBeans;
                moneyEarned += espressoEarned;
                break;
            case 2:
                waterConsume += latteWater;
                milkConsume += latteMilk;
                beansConsume += latteBeans;
                moneyEarned += latteEarned;
                break;
            case 3:
                waterConsume += cappuccinoWater;
                milkConsume += cappuccinoMilk;
                beansConsume += cappuccinoBeans;
                moneyEarned += cappuccinoEarned;
                break;
            default:
                break;
        }
        return new int[] {waterConsume ,milkConsume, beansConsume, moneyEarned};
    }

}
