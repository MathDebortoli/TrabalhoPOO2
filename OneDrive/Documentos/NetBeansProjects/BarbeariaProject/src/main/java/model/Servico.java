package model;

import jakarta.persistence.*;
import jakarta.persistence.GenerationType;

import java.io.Serializable;
import java.util.List;

@Entity
public class Servico implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idServico;

    @Column(length = 20)
    private String tipo;

    @Column(length = 20)
    private String cabeloPreferencial;

    @Column
    private boolean quimica;

    @Column(nullable = false)
    private double preco;

    @Column
    private String nomeServico;

    @Column
    private double tempoMedio;

    @Lob
    private byte[] imagemServico;
    
    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="Pedido_Servicos", joinColumns = {@JoinColumn (name ="idServico" ) } ,
            inverseJoinColumns = {@JoinColumn (name ="idPedido" ) })
    private List<Pedido> pedidos;
}

