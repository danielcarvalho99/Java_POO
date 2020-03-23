package ContaBanco;

import java.util.Scanner;

public class ContaBanco {
	
	Scanner teclado = new Scanner(System.in);

	public int numConta;
	protected char tipo;
	private String dono;
	private float saldo;
	private boolean status; // true � aberto, false � fechado
	
	public ContaBanco(){
		this.status = false;
		this.saldo = 0;
	}
	
	public void definirDados(ContaBanco c1) {
		
		System.out.println("Digite o nome do dono:");
		String s2 = teclado.nextLine() ;
		System.out.println("Digite o numero da conta:");
		int n2 = teclado.nextInt();
		System.out.println("Escolha se a conta � corrente ou poupan�a");
		char tipo2 = teclado.next().charAt(0);
		
		c1.setTipo(tipo2);
		c1.setNumConta(n2);
		c1.setDono(s2);
		
	}
	
	public void abrirConta() {
		
		this.status = true;
		
		if(this.tipo == 'c') {
			this.saldo = (float) 50;
			System.out.println("\nConta aberta com sucesso");
		}
		else if (this.tipo == 'p') {
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
			}
			else if(this.tipo == 'p') {
				this.saldo =(float) (this.saldo - 20);
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
	
	public void detalhes() {
		System.out.println("Sobre a conta");
		System.out.println("Dono: " + this.getDono());
		System.out.println("N�mero da conta: " + this.getNumConta());
		System.out.println("Tipo: " + this.getTipo());
		System.out.println("Saldo:R$" + this.getSaldo());
		System.out.println("Status:" + this.getStatus());
		System.out.println("\n");
	}
	
}
