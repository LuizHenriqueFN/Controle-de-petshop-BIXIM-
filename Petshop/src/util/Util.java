package util;

import java.text.DateFormat;
import java.util.Date;
import java.util.Scanner;

public class Util {
    public static int leInteiro() {
        Scanner entrada;
        int valor = 0;
        boolean erro = true;
        while (erro) {
            try {
                entrada = new Scanner(System.in);
                valor = entrada.nextInt();
                erro = false;
            } catch (Exception e) {
                System.out.println("Erro ao digitar. Tente novamente.");
                entrada = null;
            }
        }
        return valor;
    }

    public static float leFloat() {
        Scanner entrada;
        float valor = 0;
        boolean erro = true;
        while (erro) {
            try {
                entrada = new Scanner(System.in);
                valor = entrada.nextFloat();
                erro = false;
            } catch (Exception e) {
                System.out.println("Erro ao digitar. Tente novamente.");
                entrada = null;
            }

        }
        return valor;
    }

    public static String leString() {
        Scanner entrada;
        String valor = "";
        boolean erro = true;
        while (erro) {
            try {
                entrada = new Scanner(System.in);
                valor = entrada.nextLine();
                erro = false;
            } catch (Exception e) {
                System.out.println("Erro ao digitar. Tente novamente.");
                entrada = null;
            }
        }
        return valor;
    }

    public static char leChar() {
        Scanner entrada;
        char valor = 0;
        boolean erro = true;
        while (erro) {
            try {
                entrada = new Scanner(System.in);
                valor = entrada.next().charAt(0);
                erro = false;
            } catch (Exception e) {
                System.out.println("Erro ao digitar. Tente novamente.");
                entrada = null;
            }
        }
        return valor;
    }

    public static Date leData() {
        Scanner entrada;
        Date valor = null;
        boolean erro = true;
        DateFormat df = DateFormat.getDateInstance();
        while (erro) {
            try {
                entrada = new Scanner(System.in);
                String dtString = entrada.next();
                valor = df.parse(dtString);
                erro = false;
            } catch (Exception e) {
                System.out.println("Erro ao digitar. Tente novamente.");
                entrada = null;
            }
        }
        return valor;
    }

    public static Date stringParaDate(String dt) {

        DateFormat df = DateFormat.getDateInstance();
        Date retorno = null;
        try {
            retorno = df.parse(dt);
        } catch (Exception e) {
            System.out.println("Erro ao digitar a data. Tente novamente.");
            retorno = null;
        }
        return retorno;
    }

    public static String dateParaString(Date dt) {
        DateFormat df = DateFormat.getDateInstance();
        String retorno = null;
        try {
            retorno = df.format(dt);
        } catch (Exception e) {
            System.out.println("Erro ao converter a data. Tente novamente.");
            retorno = null;
        }
        return retorno;
    }

}