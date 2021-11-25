package com.marshall.guy;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        BigInteger userInput = new BigInteger("1");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter a whole number greater than 1: ");
        userInput = scanner.nextBigInteger();

        long startTime = System.nanoTime();

        if (userInput.compareTo(BigInteger.ONE) <= 0) {
            System.out.println("INVALID INPUT (enter a number larger than 1)");
        } else {
            BigInteger firstNumber = new BigInteger("0");
            BigInteger secondNumber = new BigInteger("1");

            for (BigInteger i = BigInteger.ONE; i.compareTo(userInput) <= 0; i = i.add(BigInteger.ONE)) {
                BigInteger sum = firstNumber.add(secondNumber);
                firstNumber = secondNumber;
                secondNumber = sum;

                BigDecimal printableSum = new BigDecimal(sum);
                System.out.printf("%d: %e%n", i, printableSum);
            }
        }

        System.out.printf("%nFINISHED");

        long endTime = System.nanoTime();
        long timeElapsed = (endTime - startTime) / 1_000_000;

        System.out.printf("%nThis calculation took %d milliseconds.", timeElapsed);
    }
}