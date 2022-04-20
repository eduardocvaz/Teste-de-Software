package tdd;

public class ContaCorrente {

	
	private double saldoInicial;
	private double saldo;
	private String nome;
	private String extrato;
	private String depositos = "";

	public ContaCorrente(double saldo) {
		this.saldo=saldo;
		this.saldoInicial = saldo;
	}
	
	public ContaCorrente() {}

	public ContaCorrente(String nome) {
		this.nome = nome;
	}

	public ContaCorrente(String nome, double saldo) {
		this.nome = nome;
		this.saldo= saldo;
		this.saldoInicial = saldo;
	}

	public double saldo(){

		return this.saldo;
	}

	public void creditar(Deposito deposito) {
		this.saldo += deposito.valor();
		depositos += deposito.data()+ "\tDeposito\t$" + deposito.valor() + "\n";
		
	}

	public String extrato() {
		
		if(depositos == "") {
			return 	"Conta de " + nome + "\n" +
					"Saldo Inicial $"+(int)saldoInicial+"\n" +
					"Saldo Final $"+(int)saldo+"\n" +
					"Nenhuma trasacao realizada\n";
		}else {
			return  "Conta de " + nome + "\n" +
					"Saldo Inicial $"+(int)saldoInicial+"\n" +
					"Saldo Final $"+(int)saldo+"\n" + depositos;
		}
		

	}

}
