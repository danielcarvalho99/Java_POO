package ContaBanco;

import java.util.Scanner;

public class ContaBanco {
	
	Scanner teclado = new Scanner(System.in);

	public int numConta;
	protected char tipo;
	private String dono;
	private float saldo;
	private boolean status; // true � aberto, false � fechado
	public boolean operacao;
	
	// Abre uma conta com saldo 0
	public ContaBanco(){
		this.status = false;
		this.saldo = 0;
		this.operacao = true;
	}
	
	//Define os dados principais do usu�rio
	public void definirDados() {
		
		System.out.println("Digite o nome do dono:");
		String s2 = teclado.nextLine() ;
		System.out.println("Digite o numero da conta:");
		int n2 = teclado.nextInt();
		System.out.println("Escolha se a conta � corrente ou poupan�a");
		char tipo2 = teclado.next().charAt(0);
		
		this.setTipo(tipo2);
		this.setNumConta(n2);
		this.setDono(s2);
		
	}
	
	//Respons�vel por escolher a opera��o
	
	public void escolha(char c) {
		
		if(c =='s' || c == 'S') {
			System.out.println("Quanto voc� gostaria de sacar?");
			float saque = teclado.nextFloat();
			this.sacar(saque);
			this.detalhes();
		}
		
		 else if (c == 't' ||c == 'T') {
			
			ContaBanco c2 = new ContaBanco();
			
			c2.definirDados();
			c2.abrirConta();
			c2.detalhes();
			
			System.out.println("O quanto voc� quer transferir?: ");
			
			float f = teclado.nextFloat();
			this.transferencia(this,c2,f);
			this.detalhes();
			c2.detalhes();
		} 
		
		else if (c == 'd' || c == 'D') {
			
			System.out.println("O quanto voc� quer depositar?");
			float f = teclado.nextFloat();
			depositar(f);
			this.detalhes();
		}
		
		else if(c =='m' || c == 'M') {
			this.pagarMensalidade();
		}
		
		else {
			System.out.println("Comando n�o reconhecido");
		}
		
		this.novaOperacao();
	}
	
	public void novaOperacao() {
		
	System.out.println("Deseja realizar uma outra opera��o?");
	
	char proxOperacao = teclado.next().charAt(0);
	
		if(proxOperacao == 'S'|| proxOperacao== 's') {
		
			System.out.println("---------------------------------------");
		
		}
		else if(proxOperacao == 'N'|| proxOperacao== 'n') {
			
			this.setOperacao(false);
			System.out.println("Opera��o finalizada");
		}
		else {
		
			System.out.println("Comando n�o reconhecido");
			this.novaOperacao();
		}
	}
	
	public void abrirConta() {
		
		this.status = true;
		
		if(this.tipo == 'c' || this.tipo == 'C') {
			this.saldo = (float) 50;
			System.out.println("\nConta aberta com sucesso");
		}
		else if (this.tipo == 'p' || this.tipo == 'P') {
			this.saldo = (float)150;
			System.out.println("\nConta aberta com sucesso");
		}
		else {
			return;
		}
	}
	
	public void fecharConta() {
		
		if(this.saldo < 0 ) {
			System.out.println("Voc� � devedor e n�o pode fechar");	
		}
		else if (this.saldo > 0) {
			System.out.println("Saque o restante");	
		}
		else {
			this.status = false;
			System.out.println("O status da sua conta � " + this.status);	
		}
		
	}
	
	public void depositar(float f) {
		
		if(this.status == true) {
			this.saldo = this.saldo + f;
			System.out.println("Dep�sito realizado");
		}
		else {
			System.out.println("A conta n�o est� aberta");
		}
	}
	

	public void sacar(float f) {
		if(this.getStatus()) {
			if(this.getSaldo() >= f) {
				this.setSaldo(this.getSaldo() - f);
				System.out.format("Voc� sacou R$%.2f\n",f);
			}
			else {
				System.out.println("Voc� n�o tem saldo suficiente \n");
			}
		}
		else {
			System.out.println("Conta fechada");
		}
	}

	public void pagarMensalidade() {
			if (this.tipo == 'c') {
				this.saldo = (float)(this.saldo - 12.0) ;
				System.out.println("Mensalidade paga");
				this.detalhes();
			}
			else if(this.tipo == 'p') {
				this.saldo =(float) (this.saldo - 20);
				System.out.println("Conta fechada");
				this.detalhes();
			}
			else {
				return;
			}
	}
	
	public void transferencia(ContaBanco c1, ContaBanco c2,float f) {
		
		if(c1.getSaldo() >= f) {
			c1.setSaldo(c1.getSaldo() - f);
			c2.setSaldo(c2.getSaldo() + f);
			System.out.format("%s transferiu para %s R$%.2f  \n",c1.getDono(),c2.getDono(),f);
		}
		else {
			System.out.println("A conta n�o tem saldo suficiente para opera��o");
		}
	}
	
	public int getNumConta(){
		return this.numConta;
	}
	
	public void setNumConta(int i) {
		this.numConta = i;
	}
	
	
	public void setTipo(char c) {
		this.tipo = c;
	}
	
	public char getTipo(){
		return this.tipo;
	}
	
	public void setDono(String s) {
		this.dono = s;
	}
	public String getDono() {
		return this.dono;
	}
	
	public void setSaldo( float f) {
		this.saldo = f;
	}
	public float getSaldo() {
		return this.saldo;
	}
	
	public void setStatus(boolean b) {
		this.status = b;
	}
	public boolean getStatus() {
		return this.status;
	}
	
	public void setOperacao(boolean b) {
		this.operacao = b;
	}
	public boolean getOperacao() {
		return this.operacao;
	}
	
	public void detalhes() {
		System.out.println("Sobre a conta");
		System.out.println("Dono: " + this.getDono());
		System.out.println("N�mero da conta: " + this.getNumConta());
		System.out.println("Tipo: " + this.getTipo());
		System.out.println("Saldo:R$" + this.getSaldo());
		System.out.println("Status:" + this.getStatus());
		System.out.println("\n");
	}
	
	public void display() {
		System.out.println("Qual opera��o voc� gostaria de realizar?");
		System.out.println("Saque");
		System.out.println("Transfer�ncia");
		System.out.println("Dep�sito");
		System.out.println("Mensalidade");
		
	}	
}
