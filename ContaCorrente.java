package Útil;

public class ContaCorrente {
    private String numeroConta;
    private double saldo;

    public ContaCorrente(String numeroConta, double saldoInicial) {
        this.numeroConta = numeroConta;
        this.saldo = saldoInicial;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void realizarTransferencia(double valor) {
        if (valor <= saldo && valor > 0) {
            saldo -= valor;
            System.out.println("Transferência de R$" + valor + " realizada com sucesso.");
        } else {
            System.out.println("Saldo insuficiente ou valor inválido.");
        }
    }

    @Override
    public String toString() {
        return "Conta: " + numeroConta + ", Saldo: " + saldo;
    }
}