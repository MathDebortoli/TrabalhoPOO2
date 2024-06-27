package model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;

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
    
    public Funcionario(){
        super();
    }

    public Funcionario(Date dataContratoinc, Date dataContratofim, double salario, String nome, String cpf, Date dataNascimento, String sexo, byte[] foto, String cidade, String bairro, String estado) {
        super(nome, cpf, dataNascimento, sexo, foto, cidade, bairro, estado);
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

}
