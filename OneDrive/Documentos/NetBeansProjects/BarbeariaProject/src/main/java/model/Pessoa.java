package model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Pessoa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idPessoa;

    @Column(name = "nome", length = 50)
    protected String nome;

    @Column(length = 14, nullable = false, unique = true)
    protected String cpf;

    @Temporal(value = TemporalType.DATE)
    @Column(name = "dataNascimento")
    private Date dataNascimento;

    @Column(length = 30)
    private String cidade;

    @Column(length = 2)
    private String estado;

    @Column
    private String bairro;

    @Column
    private char sexo;

    @Lob
    private byte[] foto;

    public Pessoa() {
    }

    public Pessoa(String nome, String cpf, Date dataNascimento, char sexo, byte[] foto, String cidade, String bairro, String estado) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.foto = foto;
        this.cidade = cidade;
        this.bairro = bairro;
        this.estado = estado;
    }

    public Pessoa(int id, String nome, String cpf, Date dataNascimento, char sexo, byte[] foto, String cidade, String bairro, String estado) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.foto = foto;
        this.cidade = cidade;
        this.bairro = bairro;
        this.estado = estado;
        this.idPessoa = id;
    }

    public int getIdPessoa() {
        return idPessoa;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public String getBairro() {
        return bairro;
    }

    public char getSexo() {
        return sexo;
    }

    public byte[] getFoto() {
        return foto;
    }

    public int getId() {
        return idPessoa;
    }

    @Override
    public String toString() {
        return nome;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pessoa other = (Pessoa) obj;
        return Objects.equals(this.cpf, other.cpf);
    }

}
