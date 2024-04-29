package model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
public class Cliente extends Pessoa implements Serializable {
    
    @Column 
    private int telefone;
}
