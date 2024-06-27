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

    @Temporal(value = TemporalType.DATE)
    @Column(name = "dataNascimento")
    private Date dataNascimento;

    @Column(length = 30)
    private String cidade;

    @Column(length = 30)
    private String estado;

    @Column
    private String bairro;

    @Column(length = 1)
    private String sexo;

    @Lob
    private byte[] foto;
    
    public Pessoa(){
        
    }

    public Pessoa(String nome, String cpf, Date dataNascimento, String sexo, byte[] foto, String cidade, String bairro, String estado) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.foto = foto;
        this.cidade = cidade;
        this.bairro = bairro;
        this.estado = estado;
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

    public String getSexo() {
        return sexo;
    }

    public byte[] getFoto() {
        return foto;
    }

}
