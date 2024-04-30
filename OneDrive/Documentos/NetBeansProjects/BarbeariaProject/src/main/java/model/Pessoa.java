package model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Pessoa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPessoa;

    @Column(name = "nomeCliente", length = 50)
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
