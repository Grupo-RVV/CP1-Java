package br.com.fiap.entity;

public class Funcionario {
    String nome;
    double horasTrabalhadas;
    double valorHoras;
    double salario;
    boolean ativo;

    public Funcionario(String nome, double valorHoras) {
        this.nome = nome;
        this.valorHoras = valorHoras;
        this.ativo = true;
    }

    public void calcularSalario(double horasTrabalhadas, double valorHoras){
        this.salario = horasTrabalhadas * valorHoras;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public void setHorasTrabalhadas(double horasTrabalhadas) {
        this.horasTrabalhadas = horasTrabalhadas;
    }

    public double getValorHoras() {
        return valorHoras;
    }

    public void setValorHoras(double valorHoras) {
        this.valorHoras = valorHoras;
    }

    public double getSalario() {
        return salario;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public String imprimirInformacao() {
        return "Funcionário\n" +
                "-------------------------\n" +
                "Nome: " + nome + "\n" +
                "Horas trabalhadas: " + horasTrabalhadas + "\n" +
                "Valor por hora: R$ " + String.format("%.2f", valorHoras).replace('.', ',') + "\n" +
                "Último salário calculado: R$ " + String.format("%.2f", salario).replace('.', ',') + "\n";
    }
}
