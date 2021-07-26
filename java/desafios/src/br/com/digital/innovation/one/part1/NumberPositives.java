package br.com.digital.innovation.one.part1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberPositives {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double x = Double.parseDouble(br.readLine());
        int cont = x > 0 ? 1 : 0;

        for (int i = 0; i < 5; i++) {
            x = Double.parseDouble(br.readLine());
            if (x > 0) cont++;
        }

        System.out.println(cont + " valores positivos");
    }
}
