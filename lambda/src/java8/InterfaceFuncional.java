package java8;

public class InterfaceFuncional {
	
	// uma interface funcional é uma interface que tem um unico método
	interface Num {
		double gerValue();
	}

	interface ValorNumerico {
		boolean teste(int n);
	}
	
	interface ValorNumerico2 {
		boolean teste(int n, int n2);
	}
	
	public static void main(String[] args) {
		Num n;
		// aqui é passado uma constante
		n = () -> 333.11;
		System.out.println(n.gerValue());
		
		// numero aleatorio, repare q para cada chamada será definido um numero diferente
		// isso ocorre pq a chasse é instanciada quando chamada
		Num n2 = () -> Math.random() * 100;
		System.out.println(n2.gerValue());
		System.out.println(n2.gerValue());
		
		ValorNumerico isPar = (int i) -> (i % 2) == 0;
		System.out.println(isPar.teste(89));
		System.out.println(isPar.teste(90));
		
		ValorNumerico2 isDiv = (x, y) -> (x%y) == 0;
		System.out.println(isDiv.teste(10, 2));
		System.out.println(isDiv.teste(10, 3));
	}

}
