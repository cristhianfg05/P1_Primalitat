import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Scanner;

public class Main_P1 {

	public static void main(String[] args) throws IOException {
		final int tamanofichero = 7;
		String[] valoresBigInteger;
		valoresBigInteger = leerFicheroBigInteger(tamanofichero);
		escribirSalidaBI(tamanofichero, valoresBigInteger);
		long[] valores;
		valores = leerFichero(tamanofichero);
		escribirSalidaLong(tamanofichero, valores);
		System.out.print("acabado");
		
		//PRINT PARA TESTEAR CADA METODO
		//System.out.print(TestsPrimalitat.testMillerRabin(79999));
		//System.out.print(TestsPrimalitat.testFermatBigInt(new BigInteger("9223372036854775807759")));
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


				/** Test con Long **/
				if(TestsPrimalitat.testMillerRabin(j))
					primo= true;
				else
					j = j - 2;
				//TestsPrimalitat.esPrimoHasta_P_Partido2(j)
				//TestsPrimalitat.testFermatNormal(j)
				//TestsPrimalitat.testMR(j)
				//TestsPrimalitat.esPrimoHastaP(j)
				//TestsPrimalitat.esPrimoRaizDeP(j)
				//TestsPrimalitat.testMillerRabin(j)
				
			}
			long endTime = System.nanoTime();
			scFit.println(j + ", " + ((endTime - startTime) * 1e-6));
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
				if (!TestsPrimalitat.testFermatBigInt(valor)) {
					valor = valor.subtract(java.math.BigInteger.TWO);
				} else {
					primo = true;
				}

				/** Tests con BigInt **/
				//TestsPrimalitat.esPrimoHastaP_BigInteger(valor);
				//TestsPrimalitat.esPrimoHastaP_Pardido_2_BigInteger(valor);
				//TestsPrimalitat.esPrimoHastaRaizDeP_BigInteger(valor);
				//TestsPrimalitat.testMillerRabin_BigInteger(valor);
				//TestsPrimalitat.testFermatBigInt(valor);
				//TestsPrimalitat.testMillerRabin_BigInteger(valor);
			}
			long endTime = System.nanoTime();
			scFit.println(valor + " , " + ((endTime - startTime) * 1e-6));
			primo = false;
		}
		numerosSalida.close();
	}
}
