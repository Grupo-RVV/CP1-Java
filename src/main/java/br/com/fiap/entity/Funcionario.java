package br.com.fiap.entity;

import br.com.fiap.annotation.Descricao;
import br.com.fiap.enums.Equipamentos;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "TDS_TB_FUNCIONARIO")
@SequenceGenerator(name = "funcionario", sequenceName = "SQ_TDS_TB_FUNCIONARIO", allocationSize = 1)
@Descricao(descricao = "TDS_TB_FUNCIONARIO")
public class Funcionario {

    @Id
    @Column(name = "id_funcionario")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "funcionario")
    private Integer id;

    @Column(name = "nm_funcionario", nullable = false, length = 100)
    String nome;

    @Column(name = "nr_horas_trabalhadas")
    double horasTrabalhadas;

    @Column(name = "vl_hora", nullable = false)
    double valorHoras;

    @Column(name = "vl_salario")
    double salario;

    @Column(name = "st_ativo")
    boolean ativo;

    @Transient
    ArrayList<Equipamentos> inventario;

    public Funcionario() {}

    public Funcionario(String nome, double valorHoras) {
        this.nome = nome;
        this.valorHoras = valorHoras;
        this.ativo = true;
        this.inventario = new ArrayList<>();
    }

    public void calcularSalario(double horasTrabalhadas, double valorHoras) {
        this.horasTrabalhadas = horasTrabalhadas;
        this.salario = horasTrabalhadas * valorHoras;
    }

    // Gera automaticamente o SELECT via Reflection com base na @Descricao da classe
    public static void gerarSQL(Object obj) {
        Class<?> classe = obj.getClass();
        if (classe.isAnnotationPresent(Descricao.class)) {
            Descricao descricao = classe.getAnnotation(Descricao.class);
            System.out.println("-- SQL gerado via Reflection: SELECT * FROM " + descricao.descricao());
        } else {
            System.out.println("-- Anotação @Descricao não encontrada na classe " + classe.getSimpleName());
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public ArrayList<Equipamentos> getInventario() {
        return inventario;
    }

    public String imprimirInformacao() {
        return "Funcionário\n" +
                "-------------------------\n" +
                "Nome: " + nome + "\n" +
                "Horas trabalhadas: " + horasTrabalhadas + "\n" +
                "Valor por hora: R$ " + String.format("%.2f", valorHoras).replace('.', ',') + "\n" +
                "Último salário calculado: R$ " + String.format("%.2f", salario).replace('.', ',') + "\n" +
                "Ativo: " + (ativo ? "Sim" : "Não") + "\n";
    }
}