package br.com.digital.innovation.one.part3;

import java.util.Scanner;

public class EncaixaNaoEncaixa {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        String a, b;
        int N = leitor.nextInt();

        for (int i = 0; i < N; i++) {
            a = leitor.next();
            b = leitor.next();

            if (a.endsWith(b))
                System.out.println("encaixa");
            else
                System.out.println("nao encaixa");
        }

        leitor.close();
    }
}
