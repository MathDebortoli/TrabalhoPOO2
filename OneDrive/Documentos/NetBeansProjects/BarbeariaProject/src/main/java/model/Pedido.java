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

    // Funcionario funcionaro;
    // private Cliente cliente;
    // private List<Servico> servicos;
}
