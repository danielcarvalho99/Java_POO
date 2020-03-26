package ContaBanco;
import java.util.Scanner;

public class Aula05 {
	
	public static void main (String[] args) {

		ContaBanco conta1 = new ContaBanco();
		Scanner teclado = new Scanner(System.in);
		System.out.println("Defina os dados da sua conta");
		conta1.definirDados();
		conta1.abrirConta();
		conta1.detalhes();
		
		while(conta1.getOperacao()) {
		conta1.display();
		char c = teclado.next().charAt(0);
		conta1.escolha(c);
		}
}
}
