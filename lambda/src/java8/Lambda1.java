package java8;

public class Lambda1 {

	public static void main(String[] args) {
		System.out.println("===inicio dos testes====");
		
		// implementacao da classe anonima runnable
		Runnable r1 = new Runnable() {
			@Override
			public void run() {
				System.out.println("== estudando lambda");
			}
		};
		
		Runnable r2 = () -> System.out.println("=== estudando a expressao lambda 2");
		
		r1.run();
		r2.run();
	}

}
