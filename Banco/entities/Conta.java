package entities;

import java.util.ArrayList;
import java.util.List;

public class Conta {
    private Cliente cliente;
    private List<String> chavesPix = new ArrayList<>();
    private double saldo = 0;

    public Conta(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public List<String> getChavesPix() {
        return chavesPix;
    }
    public void setChavesPix(List<String> chavesPix) {
        this.chavesPix = chavesPix;
    }
    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void transferir(double valor, Conta conta){
        if (this.saldo >= valor) {
            setSaldo(getSaldo() - valor);
            conta.setSaldo(conta.getSaldo() + valor);
        }else{
            System.out.println("Saldo Insuficiente!");
        }
    }

    public void deposito( double valor){
        setSaldo(getSaldo() + valor);
    }

    public void sacar(double valor){
        if(getSaldo() >= valor){
            setSaldo(getSaldo() - valor);
        }else{
            System.out.println("Saldo Insuficiente!");
        }
    }

    @Override
    public String toString() {
        return
        "Cliente: " + cliente +
        "\n Chaves Pix: " + chavesPix +
        "\n Saldo: " + saldo;
    }
}
