package br.com.digital.innovation.one.part3;

import java.util.Scanner;

public class MesclarString {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        StringBuilder mescla = new StringBuilder();
        int N = leitor.nextInt();
        char[] s1, s2;

        for (int i = 0; i < N; i++) {
            s1 = leitor.next().toCharArray();
            s2 = leitor.next().toCharArray();

            mescla.setLength(0); // clear builder
            for (int j = 0; j < Integer.max(s1.length, s2.length); j++) {
                if(s1.length > j) mescla.append(s1[j]);
                if(s2.length > j) mescla.append(s2[j]);
            }

            System.out.println(mescla.toString());
        }
    }
}
