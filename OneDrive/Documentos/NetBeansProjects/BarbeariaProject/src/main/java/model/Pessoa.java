package model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Pessoa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idPessoa;

    @Column(name = "nome", length = 50)
    private String nome;

    @Column(length = 14, nullable = false, unique = true)
    private String cpf;

    @Column
    @Temporal(value = TemporalType.DATE)
    private Date dataNascimento;

    @Column(length = 1)
    private boolean sexo;

    @Lob
    private byte[] foto;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idEndereco")
    private Endereco endereco;
}
