import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Scanner;

public class Main_P1 {

	public static void main(String[] args) throws IOException {
		final int tamanofichero = 1;
		String[] valoresBigInteger;
		valoresBigInteger = leerFicheroBigInteger(tamanofichero);
		escribirSalidaBI(tamanofichero, valoresBigInteger);
		long[] valores;
		valores = leerFichero(tamanofichero);
		escribirSalidaLong(tamanofichero, valores);
		System.out.print("acabado");
		
		//PRINT PARA TESTEAR CADA METODO
		//System.out.print(TestsPrimalitat.testMillerRabin(79999));
		//System.out.print(TestsPrimalitat.testMillerRabin_BigInteger(new BigInteger("79999")));

	}

	public static String[] leerFicheroBigInteger(int size) throws FileNotFoundException {
		String[] numeros = new String[size];
		File myObj = new File("NumerosBigInt.txt");
		Scanner myReader = new Scanner(myObj);
		int i = 0;
		if (myObj.exists()) {
			while (myReader.hasNext()) {
				numeros[i] = myReader.next();
				i++;
			}
		}
		myReader.close();
		return numeros;
	}

	public static long[] leerFichero(int size) throws FileNotFoundException {
		long[] numeros = new long[size];
		File myObj = new File("NumerosLong.txt");
		Scanner myReader = new Scanner(myObj);
		int i = 0;
		if (myObj.exists()) {
			while (myReader.hasNext()) {
				numeros[i] = myReader.nextLong();
				i++;
			}
		}
		myReader.close();
		return numeros;
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
			scFit.print(valores[i] + ", ");
			if (valores[i] % 2 == 0)
				valores[i] = valores[i] - 1;

			long j = valores[i];
			long startTime = System.nanoTime();
			while (j > 0 && !primo) {

				// 3 tests + 1 para asegurar que es primo 100% aunque es un metodo muy fiable
				// Solo para Miller Rabin
				// for(int k = 0; k<3; k++) {
				// primo = TestsPrimalitat.testMillerRabin(j);
				// }
				// if (!TestsPrimalitat.testMillerRabin(j)) {
				// j = j - 2;
				// } else {
				// primo = true;
				// }

				/** Test con Long **/
				if(TestsPrimalitat.esPrimoRaizDeP(j))
					primo= true;
				else
					j = j - 2;
				// TestsPrimalitat.esPrimoHasta_P_Partido2(j)
				// TestsPrimalitat.testFermatNormal(j)
				// TestsPrimalitat.testMillerRabin(j)
				// for(int k = 0; k<3; k++) {
				// primo = TestsPrimalitat.testMillerRabin(j);
				// }
				
			}
			long endTime = System.nanoTime();
			scFit.println(j + ", " + ((endTime - startTime) * 10e6));
			primo = false;
		}
		numerosSalida.close();
	}

	public static void escribirSalidaBI(int tamanofichero, String[] valoresBigInteger) throws IOException {
		FileWriter numerosSalida = new FileWriter("NumerosSalidaBigInt.txt");
		PrintWriter scFit = new PrintWriter(numerosSalida, true);
		boolean primo = false;

		for (int i = 0; i < tamanofichero; i++) {
			scFit.print(valoresBigInteger[i] + ", ");
			BigInteger valor = new BigInteger(valoresBigInteger[i]);

			if (valor.mod(BigInteger.TWO) == BigInteger.ZERO) {
				valor = valor.subtract(BigInteger.ONE);
			}

			long startTime = System.nanoTime();
			while (valor.compareTo(java.math.BigInteger.ZERO) == 1 && !primo) {
				if (!TestsPrimalitat.esPrimoHastaRaizDeP_BigInteger(valor)) {
					valor = valor.subtract(java.math.BigInteger.TWO);
				} else {
					primo = true;
				}

				/** Tests con BigInt **/
				// TestsPrimalitat.testMillerRabin(valor);
			}
			long endTime = System.nanoTime();
			scFit.println(valor + " , " + ((endTime - startTime) * 10e6));
			primo = false;
		}
		numerosSalida.close();
	}
}
