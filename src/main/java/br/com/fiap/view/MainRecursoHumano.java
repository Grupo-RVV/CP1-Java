package br.com.fiap.view;

import br.com.fiap.entity.Funcionario;
import br.com.fiap.entity.RecursoHumano;
import br.com.fiap.entity.Senior;

public class MainRecursoHumano {

    public static void main(String[] args) {

        System.out.println("========== TESTE: RECURSOS HUMANOS ==========\n");

        RecursoHumano rh = new RecursoHumano("Fernanda Lima", 55.0);
        rh.calcularSalario(160, rh.getValorHoras());

        Funcionario funcionario = new Funcionario("Pedro Alves", 38.0);
        Senior senior = new Senior("Lucas Mendes", 65.0);

        System.out.println("-- Estado inicial dos funcionários:");
        System.out.println(funcionario.getNome() + " - Ativo: " + funcionario.isAtivo());
        System.out.println(senior.getNome() + " - Ativo: " + senior.isAtivo());

        // ==================== DEMITIR ====================
        System.out.println("\n========== DEMITIR FUNCIONÁRIOS ==========");
        rh.demitirFuncionario(funcionario);
        System.out.println(funcionario.getNome() + " foi demitido. Ativo: " + funcionario.isAtivo());

        rh.demitirFuncionario(senior);
        System.out.println(senior.getNome() + " foi demitido. Ativo: " + senior.isAtivo());

        // ==================== RECONTRATAR ====================
        System.out.println("\n========== RECONTRATAR FUNCIONÁRIOS ==========");
        rh.recontratarFuncionario(funcionario);
        System.out.println(funcionario.getNome() + " foi recontratado. Ativo: " + funcionario.isAtivo());

        // Senior permanece demitido para demonstrar estado diferente
        System.out.println(senior.getNome() + " permanece demitido. Ativo: " + senior.isAtivo());

        // ==================== INFORMAÇÕES DO RH ====================
        System.out.println("\n========== INFORMAÇÕES DO RH ==========");
        System.out.println(rh.imprimirInformacao());

        // ==================== REFLECTION ====================
        System.out.println("========== REFLECTION ==========");
        Funcionario.gerarSQL(rh);
    }
}