package br.com.digital.innovation.one.part2;

import java.io.IOException;
import java.util.Scanner;

public class NumberAnalysis {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        //declare suas variaveis corretamente
        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;
        int e;

        //continue a solução
        for (int i = 0; i < 5; i++) {
            e = Integer.parseInt(leitor.nextLine());

            if (e % 2 == 0) a++;
            else b++;

            if (e > 0) c++;
            else if (e < 0) d++;
        }

        //insira suas variaveis corretamente
        System.out.println(a + " valor(es) par(es)");
        System.out.println(b + " valor(es) impar(es)");
        System.out.println(c + " valor(es) positivo(s)");
        System.out.println(d + " valor(es) negativo(s)");
    }
}
