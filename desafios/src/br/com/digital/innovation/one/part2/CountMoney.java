package br.com.digital.innovation.one.part2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CountMoney {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inserted = scanner.nextInt();

        List<Integer> moneyBills = Arrays.asList(100, 50, 20, 10, 5, 2, 1);
        List<Integer> numberOfBills = new ArrayList<>();

        int num;
        int remaining = inserted;
        for (Integer n : moneyBills) {
            num = remaining / n;
            remaining -= num * n;
            numberOfBills.add(num);
        }

        System.out.println(inserted);
        for (int i = 0; i < moneyBills.size(); i++)
            System.out.printf("%d nota(s) de R$ %d,00\n", numberOfBills.get(i), moneyBills.get(i));

    }
}
