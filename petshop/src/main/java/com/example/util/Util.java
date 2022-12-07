package com.example.util;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import com.example.model.TipoDocumento;

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

	public static boolean leBoolean() {
		Scanner entrada;
		boolean valor = false;
		boolean erro = true;
		while (erro) {
			try {
				entrada = new Scanner(System.in);
				valor = entrada.nextBoolean();
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
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyy");
		while (erro) {
			try {
				entrada = new Scanner(System.in);
				String dtString = entrada.next();
				valor = formato.parse(dtString);
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

	public static boolean validar(String documento, TipoDocumento tipoDocumento) {
		switch (tipoDocumento) {
			case CPF:
				return validaCPF(documento);
			case CNPJ:
				return validaCNPJ(documento);
		}
		return false;
	}

	private static boolean validaCPF(String CPF) {
		CPF = CPF.replace(".", "");
		CPF = CPF.replace("-", "");

		if (
			CPF.equals("00000000000") ||
			CPF.equals("11111111111") ||
			CPF.equals("22222222222") ||
			CPF.equals("33333333333") ||
			CPF.equals("44444444444") ||
			CPF.equals("55555555555") ||
			CPF.equals("66666666666") ||
			CPF.equals("77777777777") ||
			CPF.equals("88888888888") ||
			CPF.equals("99999999999") ||
			(CPF.length() != 11)
		) return false;

		char dig10, dig11;
		int sm, i, r, num, peso;

		try {
			sm = 0;
			peso = 10;
			for (i = 0; i < 9; i++) {
				num = (CPF.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}

			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11)) dig10 = '0'; else dig10 = (char) (r + 48);

			sm = 0;
			peso = 11;
			for (i = 0; i < 10; i++) {
				num = (CPF.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}

			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11)) dig11 = '0'; else dig11 = (char) (r + 48);

			return (dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10));
		} catch (InputMismatchException erro) {
			return false;
		}
	}

	private static boolean validaCNPJ(String CNPJ) {
		CNPJ = CNPJ.replace(".", "");
		CNPJ = CNPJ.replace("-", "");
		CNPJ = CNPJ.replace("/", "");
		
		if (
			CNPJ.equals("00000000000000") ||
			CNPJ.equals("11111111111111") ||
			CNPJ.equals("22222222222222") ||
			CNPJ.equals("33333333333333") ||
			CNPJ.equals("44444444444444") ||
			CNPJ.equals("55555555555555") ||
			CNPJ.equals("66666666666666") ||
			CNPJ.equals("77777777777777") ||
			CNPJ.equals("88888888888888") ||
			CNPJ.equals("99999999999999") ||
			CNPJ.length() != 14
		) return false;

		char dig13, dig14;
		int sm, i, r, num, peso;

		try {
			sm = 0;
			peso = 2;
			for (i = 11; i >= 0; i--) {
				num = (int) (CNPJ.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso + 1;
				if (peso == 10) peso = 2;
			}

			r = sm % 11;
			if ((r == 0) || (r == 1)) dig13 = '0'; else dig13 =
				(char) ((11 - r) + 48);

			sm = 0;
			peso = 2;
			for (i = 12; i >= 0; i--) {
				num = (int) (CNPJ.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso + 1;
				if (peso == 10) peso = 2;
			}

			r = sm % 11;
			if ((r == 0) || (r == 1)) dig14 = '0'; else dig14 =
				(char) ((11 - r) + 48);

			return ((dig13 == CNPJ.charAt(12)) && (dig14 == CNPJ.charAt(13)));
		} catch (InputMismatchException erro) {
			return false;
		}
	}

	//está executando o código
    private static void clear() throws IOException, InterruptedException {
        if (System.getProperty("os.name").contains("Windows")) new ProcessBuilder("cmd","/c","cls")
			.inheritIO()
			.start()
			.waitFor(); 
		else new ProcessBuilder("clear").inheritIO().start().waitFor();

    }
    
    //função que chama a função de limpar o conole, porém, com um gerenciamento de erro pr caso dê errado
    public static void limpaConsole() {
        try {
        	clear();
        } catch (IOException e) {
        	e.printStackTrace();
        } catch (InterruptedException e) {
        	e.printStackTrace();
        }
    }
    
}
