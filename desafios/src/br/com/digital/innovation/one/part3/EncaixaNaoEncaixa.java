package br.com.digital.innovation.one.part3;

import java.util.Scanner;

public class EncaixaNaoEncaixa {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        String a, b;
        int j, k;
        boolean fits;
        int N = leitor.nextInt();

        for (int i = 0; i < N; i++) {
            a = leitor.next();
            b = leitor.next();
            if (a.length() >= b.length()){
                j = (a.length() - 1);
                k = (b.length() - 1);

                do {
                    fits = a.charAt(j) == b.charAt(k);
                    j--;
                    k--;
                } while (fits && j >= 0);

                if(fits)
                    System.out.println("encaixa");
                else
                    System.out.println("nao encaixa");
            } else
                System.out.println("nao encaixa");
        }
    }
}
