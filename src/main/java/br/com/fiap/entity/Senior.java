package br.com.fiap.entity;

public class Senior extends Funcionario{
    public Senior(String nome, double valorHoras) {
        super(nome, valorHoras);
    }

    @Override
    public void calcularSalario(double horasTrabalhadas, double valorHoras) {
        super.calcularSalario(horasTrabalhadas, valorHoras);

        int bonus = (int) (horasTrabalhadas / 15);
        salario += bonus * valorHoras;
    }

    @Override
    public String imprimirInformacao() {
        return "Funcionário Sênior\n" +
                "===========================\n" +
                "Nome: " + nome + "\n" +
                "Horas trabalhadas: " + horasTrabalhadas + "\n" +
                "Valor por hora: R$ " + String.format("%.2f", valorHoras).replace('.', ',') + "\n" +
                "Último salário calculado: R$ " + String.format("%.2f", salario).replace('.', ',') + "\n" +
                "Bônus aplicado a cada 15 horas trabalhadas\n";
    }
}
