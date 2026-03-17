package br.com.fiap.entity;

public class RecursoHumano extends Funcionario{
    public RecursoHumano(String nome, double valorHoras) {
        super(nome, valorHoras);
    }

    public void demitirFuncionario(Funcionario funcionario){
        funcionario.setAtivo(false);
    }

    public void recontratarFuncionario(Funcionario funcionario){
        funcionario.setAtivo(true);
    }
}
