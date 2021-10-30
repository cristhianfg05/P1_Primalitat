import java.math.BigInteger;

public class Main_P1 {

	public static void main(String[] args) {
		
		
		
			System.out.print(TestsPrimalitat.esPrimoRaizDeP(999983)+"\n");
			System.out.print(TestsPrimalitat.esPrimoHastaP(999983)+"\n");
			System.out.print(TestsPrimalitat.esPrimoHasta_P_Partido2(999983)+"\n");
			System.out.print(TestsPrimalitat.testMillerRabin(5717)+"\n");
			System.out.print(TestsPrimalitat.esPrimoHastaP_BigInteger(new BigInteger("999983"))+"\n");
			System.out.print(TestsPrimalitat.esPrimoHastaP_Pardido_2_BigInteger(new BigInteger("999983"))+"\n");
			
	}

}
