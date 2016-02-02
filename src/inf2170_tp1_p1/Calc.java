/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inf2170_tp1_p1;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author ALLEN
 */
public class Calc {

    private static Scanner sc = new Scanner(System.in);

    /**
     * DECI: Read the next integer from the input.
     */
    public static int deci() {
        if (!sc.hasNextInt()) {
            System.out.println("Not a valid DECI input");
            System.exit(0);
        }
        int res = sc.nextInt();
        return res;
    }

    /**
     * DECO: Write an integer on the output.
     */
    public static void deco(int val) {
        System.out.print(val);
    }

    /**
     * CHARI: Read the next character on the input.
     */
    public static char chari() {
        Pattern olddel = sc.delimiter();
        sc.useDelimiter("");

        if (!sc.hasNext()) {
            sc.useDelimiter(olddel);
            return 0;
        }
        String res = sc.next();
        sc.useDelimiter(olddel);
        return res.charAt(0);
    }

    /**
     * CHARO: Write a character on the output.
     */
    public static void charo(char val) {
        System.out.print(val);
    }

    /**
     * STRO: Write a string on the output.
     */
    public static void stro(String val) {
        System.out.print(val);
    }

    /**
     * STRO: Write a string on the output. version with a array of char.
     */
    public static void stro(char[] val) {
        int len = 0;
        while (len < val.length && val[len] != '\0') {
            len++;
        }
        char[] out = new char[len];
        for (int i = 0; i < len; i++) {
            out[i] = val[i];
        }
        System.out.print(new String(out));
    }

    /**
     * STOP: Terminate the program.
     */
    public static void stop() {
        System.exit(0);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int operande;
        int operande2 = 0;
        int reste;
        int reponse = 0;
        char operateur = ' ';
        int compteur = 0;
        System.out.println("Entrer un opérande");
        operande = deci();
        do {
            compteur = 0;
            operande2 = 0;
            if (operateur != '=') {
                System.out.println("Entrer un opérateur");
                operateur = sc.next().charAt(0);
                chari();
            } else if (operateur == '=') {
                System.out.println("Entrer un opérande");
                operande = deci();
                System.out.println("Entrer un opérateur");
                operateur = sc.next().charAt(0);
                chari();
            }
            do {
                if (operateur != '=' && compteur > 0) {
                    operande = reponse;
                }
                switch (operateur) {
                    case '+':
                        System.out.println("Entrer un opérande");
                        operande2 = deci();
                        reponse = operande + operande2;
                        System.out.println("Entrer un opérateur");
                        operateur = sc.next().charAt(0);
                        break;
                    case '-':
                        System.out.println("Entrer un opérande");
                        operande2 = deci();
                        reponse = operande - operande2;
                        System.out.println("Entrer un opérateur");
                        operateur = sc.next().charAt(0);
                        break;
                    case '*':
                        System.out.println("Entrer un opérande");
                        operande2 = deci();
                        for (int i = 0; i < operande2; i++) {
                            reponse = reponse + operande;
                        }
                        System.out.println("Entrer un opérateur");
                        operateur = sc.next().charAt(0);
                        break;
                    case '/':
                        System.out.println("Entrer un opérande");
                        operande2 = deci();
                        reste = operande;
                        for (int i = 1; reste >= operande2; i++) {
                            reste = reste - operande2;
                            reponse = i;
                        }
                        System.out.println("Entrer un opérateur");
                        operateur = sc.next().charAt(0);
                        break;
                    case '%':
                        System.out.println("Entrer un opérande");
                        operande2 = deci();
                        reste = operande;
                        for (int i = 0; reste >= operande2; i++) {
                            reste = reste - operande2;
                            reponse = reste;
                        }
                        System.out.println("Entrer un opérateur");
                        operateur = sc.next().charAt(0);
                        break;
                }
                compteur++;
            } while (operateur == '+' || operateur == '-' || operateur == '*' || operateur == '/');
            if (operateur == '=') {
                if (operande2 == 0) {
                    reponse = operande;
                }
                System.out.println("Réponse : " + reponse);
            }
        } while (operateur != 'q');
        if (operande2 == 0) {
            reponse = operande;
        }
        System.out.println("Réponse : " + reponse);
    }

}
