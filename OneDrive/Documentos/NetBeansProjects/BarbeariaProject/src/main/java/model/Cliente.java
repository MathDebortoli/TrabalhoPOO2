package model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Cliente extends Pessoa implements Serializable {

    @Column
    private String telefone;

    public Cliente(String telefone, String nome, String cpf, Date dataNascimento, boolean sexo, byte[] foto, String cidade, String bairro, String estado) {
        super(nome, cpf, dataNascimento, sexo, foto, cidade, bairro, estado);
        this.telefone = telefone;
    }

    public String getTelefone() {
        return telefone;
    }

}
