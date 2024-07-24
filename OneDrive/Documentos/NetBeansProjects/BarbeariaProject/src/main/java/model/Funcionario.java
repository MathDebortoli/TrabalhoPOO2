package model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
public class Funcionario extends Pessoa implements Serializable {

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataContratoinc;

    @Column(nullable = true)
    @Temporal(TemporalType.DATE)
    private Date dataContratofim;

    @Column
    private double salario;

    public Funcionario() {
        super();
    }

    public Funcionario(Date dataContratoinc, Date dataContratofim, double salario, String nome, String cpf, Date dataNascimento, char sexo, byte[] foto, String cidade, String bairro, String estado) {
        super(nome, cpf, dataNascimento, sexo, foto, cidade, bairro, estado);
        this.dataContratoinc = dataContratoinc;
        this.dataContratofim = dataContratofim;
        this.salario = salario;
    }
    
       public Funcionario(int id, Date dataContratoinc, Date dataContratofim, double salario, String nome, String cpf, Date dataNascimento, char sexo, byte[] foto, String cidade, String bairro, String estado) {
        super(id,nome, cpf, dataNascimento, sexo, foto, cidade, bairro, estado);
        this.dataContratoinc = dataContratoinc;
        this.dataContratofim = dataContratofim;
        this.salario = salario;
    }

    public Date getDataContratoinc() {
        return dataContratoinc;
    }

    public Date getDataContratofim() {
        return dataContratofim;
    }

    public double getSalario() {
        return salario;
    }

    @Override
    public String toString() {
        return nome;
    }

}
