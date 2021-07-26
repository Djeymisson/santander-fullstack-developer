package br.com.digital.innovation.one.part1;

import java.util.Scanner;

public class NextOddNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int cont = 0;

        while (cont < 6) {
            if (x % 2 == 1) {
                System.out.println(x);
                cont++;
            }
            x++;
        }
    }
}
