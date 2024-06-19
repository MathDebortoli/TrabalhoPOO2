package model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Cliente extends Pessoa implements Serializable {
    
    @Column 
    private String telefone;

    public Cliente(String nome, String cpf, String dataNascimento, boolean sexo, byte[] foto, Endereco endereco, String telefone) {
        super(nome, cpf, dataNascimento, sexo, foto, endereco);
        this.telefone = telefone;
    }

  
    
    
}
