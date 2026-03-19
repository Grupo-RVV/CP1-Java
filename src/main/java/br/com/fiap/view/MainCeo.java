package br.com.fiap.view;

import br.com.fiap.entity.Ceo;
import br.com.fiap.entity.Funcionario;
import br.com.fiap.entity.Senior;
import br.com.fiap.enums.Equipamentos;

public class MainCeo {

    public static void main(String[] args) {

        System.out.println("========== TESTE: CEO ==========\n");

        Ceo ceo = new Ceo("Carlos Drummond", 150.0);
        ceo.calcularSalario(160, ceo.getValorHoras());

        Funcionario funcionario = new Funcionario("Ana Paula", 40.0);
        Senior senior = new Senior("Roberto Faria", 70.0);

        System.out.println("-- Informações iniciais:");
        System.out.println(ceo.imprimirInformacao());

        // ==================== ADICIONAR EQUIPAMENTOS ====================
        System.out.println("========== ADICIONAR EQUIPAMENTOS ==========");

        ceo.adicionarEquipamento(funcionario, Equipamentos.LAPTOP);
        ceo.adicionarEquipamento(funcionario, Equipamentos.MOUSE);
        ceo.adicionarEquipamento(funcionario, Equipamentos.TECLADO);
        System.out.println("Equipamentos de " + funcionario.getNome() + ": " + funcionario.getInventario());

        ceo.adicionarEquipamento(senior, Equipamentos.DESKTOP);
        ceo.adicionarEquipamento(senior, Equipamentos.MONITOR);
        System.out.println("Equipamentos de " + senior.getNome() + ": " + senior.getInventario());

        // ==================== REMOVER EQUIPAMENTOS ====================
        System.out.println("\n========== REMOVER EQUIPAMENTOS ==========");

        ceo.removerEquipamento(funcionario, Equipamentos.MOUSE);
        System.out.println("Equipamentos de " + funcionario.getNome() + " após remoção: " + funcionario.getInventario());

        ceo.removerEquipamento(senior, Equipamentos.MONITOR);
        System.out.println("Equipamentos de " + senior.getNome() + " após remoção: " + senior.getInventario());

        // ==================== REFLECTION ====================
        System.out.println("\n========== REFLECTION ==========");
        Funcionario.gerarSQL(ceo);
    }
}