import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Scanner;

public class Main_P1 {

	public static void main(String[] args) throws IOException {
		final int tamanofichero = 11;
		String[] valoresBigInteger;
		//valoresBigInteger = leerFicheroBigInteger(tamanofichero);
		long[] valores;
		valores = leerFichero(tamanofichero);
		escribirSalidaLong(tamanofichero, valores);
		//System.out.print(TestsPrimalitat.testFermatNormal(6346339));

		/*
		 * System.out.println("Case: "+numero);
		 * System.out.print(TestsPrimalitat.esPrimoRaizDeP(numero)+"\n");
		 * System.out.print(TestsPrimalitat.esPrimoHastaP(numero)+"\n");
		 * System.out.print(TestsPrimalitat.esPrimoHasta_P_Partido2(numero)+"\n");
		 * System.out.print(TestsPrimalitat.esPrimoHastaP_BigInteger(new
		 * BigInteger(Integer.toString(numero)))+"\n");
		 * System.out.print(TestsPrimalitat.esPrimoHastaP_Pardido_2_BigInteger(new
		 * BigInteger(Integer.toString(numero)))+"\n");
		 */
	}

	public static String[] leerFicheroBigInteger(int size) throws FileNotFoundException {
		String[] numeros = new String[size];
		File myObj = new File("Numeros.txt");
		Scanner myReader = new Scanner(myObj);
		int i = 0;
		if (myObj.exists()) {
			while (myReader.hasNext()) {
				numeros[i] = myReader.next();
				System.out.print(numeros[i] + "\n");
				i++;
			}
		}
		myReader.close();
		return numeros;
	}

	public static long[] leerFichero(int size) throws FileNotFoundException {
		long[] numeros = new long[size];
		File myObj = new File("Numeros.txt");
		Scanner myReader = new Scanner(myObj);
		int i = 0;
		if (myObj.exists()) {
			while (myReader.hasNext()) {
				numeros[i] = myReader.nextLong();
				System.out.print(numeros[i] + "\n");
				i++;
			}
		}
		myReader.close();
		return numeros;
	}

	public static void guardarFichero(String[] tabla) {

	}

	public static String numeroAnteriorBigInteger(String n) {
		long num = Integer.parseInt(n) - 2;
		n = String.valueOf(num);
		return n;
	}
	
	public static void escribirSalidaLong(int tamanofichero, long valores[]) throws IOException {
		FileWriter numerosSalida = new FileWriter("NumerosSalida.txt");
		PrintWriter scFit = new PrintWriter(numerosSalida, true);
		boolean primo = false;
		for (int i = 0; i < tamanofichero; i++) {
			if (valores[i] % 2 == 0)
				valores[i] = valores[i] - 1;
			long j = valores[i];
			long startTime = System.nanoTime();
			while (j > 0 && !primo) {
				if(!TestsPrimalitat.testMillerRabin(j)) {
					j =j - 2;
				}else {
					primo = true;
				}
				

				/** Test con Long **/
				// TestsPrimalitat.esPrimoHastaP(j)
				// TestsPrimalitat.esPrimoHasta_P_Partido2(j)
				// TestsPrimalitat.testFermatNormal(j)
				// TestsPrimalitat.testMillerRabin(j)
			}
			long endTime = System.nanoTime();
			System.out.print("Primo mas cercano " + j);
			scFit.println(valores[i] + " , " + j + " , " + (endTime - startTime));
			primo = false;
		}
		numerosSalida.close();
	}
}
