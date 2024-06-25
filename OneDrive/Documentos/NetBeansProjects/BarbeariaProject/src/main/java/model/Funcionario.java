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

    @Column(unique = true, length = 30)
    private String email;

    @Column
    private double salario;

    public Funcionario(Date dataContratoinc, Date dataContratofim, String email, double salario, String nome, String cpf, Date dataNascimento, boolean sexo, byte[] foto, String cidade, String bairro, String estado) {
        super(nome, cpf, dataNascimento, sexo, foto, cidade, bairro, estado);
        this.dataContratoinc = dataContratoinc;
        this.dataContratofim = dataContratofim;
        this.email = email;
        this.salario = salario;
    }

  
}
