import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;

public class Main_P1 {

	public static void main(String[] args) throws FileNotFoundException{
		final int tamanofichero = 11; 
		String[] valoresBigInteger;
		valoresBigInteger = leerFicheroBigInteger(tamanofichero);
		long[] valores;
		valores = leerFichero(tamanofichero);
		
		
		//System.out.println(TestsPrimalitat.testFermatBigInt(new BigInteger(Integer.toString(79999))));
		for(int i = 0; i <= tamanofichero ; i++) {
			if(valores[i]%2 == 0)
				valores[i] = valores[i]-1;
			for(long j = 0)
		}
		/*
		System.out.println("Case: "+numero);
		System.out.print(TestsPrimalitat.esPrimoRaizDeP(numero)+"\n");
		System.out.print(TestsPrimalitat.esPrimoHastaP(numero)+"\n");
		System.out.print(TestsPrimalitat.esPrimoHasta_P_Partido2(numero)+"\n");
		System.out.print(TestsPrimalitat.esPrimoHastaP_BigInteger(new BigInteger(Integer.toString(numero)))+"\n");
		System.out.print(TestsPrimalitat.esPrimoHastaP_Pardido_2_BigInteger(new BigInteger(Integer.toString(numero)))+"\n");
		*/
	}
	public static String[] leerFicheroBigInteger(int size) throws FileNotFoundException {
		String[]  numeros = new String[size];
		File myObj = new File("Numeros.txt");
		Scanner myReader = new Scanner(myObj);
		int i = 0;
		if(myObj.exists()) {
			while (myReader.hasNext()) {
				numeros[i] = myReader.next();
				System.out.print(numeros[i]+"\n");
				i++;
			}
		} 
		myReader.close();
		return numeros;
	}
	
	public static long[] leerFichero(int size) throws FileNotFoundException {
		long[]  numeros = new long[size];
		File myObj = new File("Numeros.txt");
		Scanner myReader = new Scanner(myObj);
		int i = 0;
		if(myObj.exists()) {
			while (myReader.hasNext()) {
				numeros[i] = myReader.nextInt();
				System.out.print(numeros[i]+"\n");
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
}
