package br.com.fiap.view;

import br.com.fiap.entity.Funcionario;
import br.com.fiap.entity.Senior;

public class MainSenior {

    public static void main(String[] args) {

        System.out.println("========== TESTE: FUNCIONÁRIO SÊNIOR ==========\n");

        // Criando um funcionário sênior
        Senior senior = new Senior("Maria Souza", 60.0);

        // ==================== SEM BÔNUS ====================
        System.out.println("-- Calculando salário com 10 horas (sem bônus, mínimo 15h para bônus):");
        senior.calcularSalario(10, senior.getValorHoras());
        System.out.println(senior.imprimirInformacao());

        // ==================== COM 1 BÔNUS ====================
        System.out.println("-- Calculando salário com 15 horas (1 bônus):");
        senior.calcularSalario(15, senior.getValorHoras());
        System.out.println(senior.imprimirInformacao());

        // ==================== COM 2 BÔNUS ====================
        System.out.println("-- Calculando salário com 30 horas (2 bônus):");
        senior.calcularSalario(30, senior.getValorHoras());
        System.out.println(senior.imprimirInformacao());

        // ==================== COM 3 BÔNUS ====================
        System.out.println("-- Calculando salário com 160 horas (10 bônus):");
        senior.calcularSalario(160, senior.getValorHoras());
        System.out.println(senior.imprimirInformacao());

        // ==================== REFLECTION ====================
        System.out.println("========== REFLECTION ==========");
        Funcionario.gerarSQL(senior);
    }
}