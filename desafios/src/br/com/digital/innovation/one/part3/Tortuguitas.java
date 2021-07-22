package br.com.digital.innovation.one.part3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Tortuguitas {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //continue a solucao de acordo com o solicitado

        int n;
        do {
            n = Integer.parseInt(br.readLine());
            String str = br.readLine();
            String s[] = str.split(" ");

            int max = Arrays.stream(s)
                    .map(Integer::parseInt)
                    .max(Comparator.naturalOrder())
                    .orElse(0);

            if (max < 10)
                System.out.println(1);
            else if (max >= 10 && max < 20)
                System.out.println(2);
            else System.out.println(3);

        } while (br.ready());
    }
}

