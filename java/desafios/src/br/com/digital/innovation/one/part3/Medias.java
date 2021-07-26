package br.com.digital.innovation.one.part3;

import java.io.IOException;
import java.util.Scanner;

public class Medias {
    public static void main(String[] args)  throws IOException {
        Scanner sc = new Scanner(System.in);

        float n1, n2, n3, n4, media, emexame, exameemedia;

        n1 = sc.nextFloat();
        n2 = sc.nextFloat();
        n3 = sc.nextFloat();
        n4 = sc.nextFloat();

        media = (n1*2 + n2*3 + n3*4 + n4) / 10;
        System.out.printf("Media %.1f\n", media);

        if (media > 7.0) {
            System.out.println("Aluno aprovado.");
        } else if(media > 6.9 && media < 7.0) {
            // unspecified case
        } else if (media >= 5.0) {
            System.out.println("Aluno em exame.");

            emexame = sc.nextFloat();
            System.out.printf("Nota do exame: %.1f\n", emexame);

            exameemedia = (media + emexame) / 2;

            if (exameemedia >= 5.0)
                System.out.println("Aluno aprovado.");
            else
                System.out.println("Aluno reprovado");

            System.out.printf("Media final: %.1f\n", exameemedia);
        } else {
            System.out.println("Aluno reprovado.");
        }
    }
}
