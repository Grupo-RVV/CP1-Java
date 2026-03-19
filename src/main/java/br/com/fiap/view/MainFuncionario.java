package br.com.fiap.view;

import br.com.fiap.dao.FuncionarioDao;
import br.com.fiap.dao.FuncionarioDaoImpl;
import br.com.fiap.entity.Funcionario;
import br.com.fiap.exception.CommitException;
import br.com.fiap.exception.IdNaoEncontradoException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class MainFuncionario {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("oracle");
        EntityManager em = emf.createEntityManager();
        FuncionarioDao dao = new FuncionarioDaoImpl(em);

        try {

            // ==================== REFLECTION - SQL automático ====================
            Funcionario funcReflection = new Funcionario("Teste Reflection", 50.0);
            System.out.println("========== REFLECTION ==========");
            Funcionario.gerarSQL(funcReflection);

            // ==================== CREATE ====================
            System.out.println("\n========== CREATE ==========");
            Funcionario funcionario = new Funcionario("João Silva", 35.0);
            funcionario.calcularSalario(160, 35.0);
            dao.cadastrar(funcionario);
            dao.commit();
            System.out.println("Funcionário cadastrado com sucesso!");
            System.out.println(funcionario.imprimirInformacao());

            // ==================== READ ====================
            System.out.println("========== READ (buscar por ID) ==========");
            Funcionario encontrado = dao.buscarPorId(funcionario.getId());
            System.out.println(encontrado.imprimirInformacao());

            System.out.println("========== READ (buscar todos) ==========");
            List<Funcionario> todos = dao.buscarTodos();
            todos.forEach(f -> System.out.println(f.imprimirInformacao()));

            // ==================== UPDATE ====================
            System.out.println("========== UPDATE ==========");
            encontrado.setNome("João Silva Atualizado");
            encontrado.calcularSalario(180, encontrado.getValorHoras());
            dao.atualizar(encontrado);
            dao.commit();
            System.out.println("Funcionário atualizado com sucesso!");
            System.out.println(encontrado.imprimirInformacao());

            // ==================== DELETE ====================
            System.out.println("========== DELETE ==========");
            dao.remover(encontrado.getId());
            dao.commit();
            System.out.println("Funcionário removido com sucesso!");

        } catch (IdNaoEncontradoException e) {
            System.out.println("Erro: " + e.getMessage());
        } catch (CommitException e) {
            System.out.println("Erro ao commitar: " + e.getMessage());
        } finally {
            em.close();
            emf.close();
        }
    }
}