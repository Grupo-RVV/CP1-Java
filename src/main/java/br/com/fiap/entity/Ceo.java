package br.com.fiap.entity;

import br.com.fiap.enums.Equipamentos;

public class Ceo extends Funcionario{
    public Ceo(String nome, double valorHoras) {
        super(nome, valorHoras);
    }

    public void adicionarEquipamento(Funcionario funcionario, Equipamentos equipamentos){
        funcionario.inventario.add(equipamentos);
    }

    public void removerEquipamento(Funcionario funcionario, Equipamentos equipamentos){
        funcionario.inventario.remove(equipamentos);
    }
}
