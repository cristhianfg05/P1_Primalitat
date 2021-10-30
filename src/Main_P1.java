import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;

public class Main_P1 {

	public static void main(String[] args) throws FileNotFoundException{
		int tamanofichero = 11; 
		String[] valores; 
		valores = leerFichero(tamanofichero);
		
		/*
		System.out.println("Case: "+numero);
		System.out.print(TestsPrimalitat.esPrimoRaizDeP(numero)+"\n");
		System.out.print(TestsPrimalitat.esPrimoHastaP(numero)+"\n");
		System.out.print(TestsPrimalitat.esPrimoHasta_P_Partido2(numero)+"\n");
		System.out.print(TestsPrimalitat.esPrimoHastaP_BigInteger(new BigInteger(Integer.toString(numero)))+"\n");
		System.out.print(TestsPrimalitat.esPrimoHastaP_Pardido_2_BigInteger(new BigInteger(Integer.toString(numero)))+"\n");
		*/
	}
	public static String[] leerFichero(int size) throws FileNotFoundException {
		String[]  numeros = new String[size];
		File myObj = new File("F:\\Usuario\\Documents\\GitHub\\P1_Primalitat\\Numeros.txt"); //F:\\Usuario\\Documents\\GitHub\\P1_Primalitat\\ 
		Scanner myReader = new Scanner(myObj);
		int i = 0;
		if(myObj.exists()) {
			while (myReader.hasNext()) {
				numeros[i] = myReader.nextLine();
				i++;
			}
		} 
		myReader.close();
		return numeros;
	}
}
