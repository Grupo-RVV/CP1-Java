package br.com.fiap.dao;

import br.com.fiap.entity.Funcionario;
import br.com.fiap.exception.CommitException;
import br.com.fiap.exception.IdNaoEncontradoException;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class FuncionarioDaoImpl implements FuncionarioDao {

    private EntityManager em;

    public FuncionarioDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public void cadastrar(Funcionario funcionario) {
        System.out.println("-- SQL gerado: INSERT INTO TDS_TB_FUNCIONARIO " +
                "(nm_funcionario, nr_horas_trabalhadas, vl_hora, vl_salario, st_ativo) " +
                "VALUES (?, ?, ?, ?, ?)");
        em.persist(funcionario);
    }

    @Override
    public void atualizar(Funcionario funcionario) throws IdNaoEncontradoException {
        buscarPorId(funcionario.getId()); // valida se o funcionário existe antes de atualizar
        System.out.println("-- SQL gerado: UPDATE TDS_TB_FUNCIONARIO SET " +
                "nm_funcionario = ?, nr_horas_trabalhadas = ?, vl_hora = ?, vl_salario = ?, st_ativo = ? " +
                "WHERE id_funcionario = " + funcionario.getId());
        em.merge(funcionario);
    }

    @Override
    public void remover(int id) throws IdNaoEncontradoException {
        Funcionario funcionario = buscarPorId(id);
        System.out.println("-- SQL gerado: DELETE FROM TDS_TB_FUNCIONARIO WHERE id_funcionario = " + id);
        em.remove(funcionario);
    }

    @Override
    public Funcionario buscarPorId(int id) throws IdNaoEncontradoException {
        System.out.println("-- SQL gerado: SELECT * FROM TDS_TB_FUNCIONARIO WHERE id_funcionario = " + id);
        Funcionario funcionario = em.find(Funcionario.class, id);
        if (funcionario == null)
            throw new IdNaoEncontradoException("Funcionário não encontrado para o id: " + id);
        return funcionario;
    }

    @Override
    public List<Funcionario> buscarTodos() {
        System.out.println("-- SQL gerado: SELECT * FROM TDS_TB_FUNCIONARIO");
        TypedQuery<Funcionario> query = em.createQuery(
                "SELECT f FROM Funcionario f", Funcionario.class);
        return query.getResultList();
    }

    @Override
    public void commit() throws CommitException {
        try {
            em.getTransaction().begin();
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
            throw new CommitException();
        }
    }

}