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
}
