package model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
public class Endereco implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEndereco;

    @Column
    private int numero;

    @Column
    private int cep;

    @Column(length = 30)
    private String cidade;

    @Column(length = 2)
    private String estado;

    @Column(length = 50)
    private String rua;

    @Column(length = 30)
    private String bairro;
}
