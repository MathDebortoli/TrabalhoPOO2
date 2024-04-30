package model;

import jakarta.persistence.*;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class Pedido implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPedido;

    @Column
    @Temporal(TemporalType.DATE)
    private Date dataPedido;

    @Column(nullable = false)
    private boolean pago;

    @Column(nullable = false)
    private double precoPedido;

    @Column
    private String formaPagamento;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idFuncionario")
    private Funcionario funcionaro;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idCliente")
    private Cliente cliente;
    
    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="Pedido_Servicos", joinColumns = {@JoinColumn (name ="idPedido" ) } ,
            inverseJoinColumns = {@JoinColumn (name ="idServico" ) })
    private List<Servico> servicos;
}
