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
    private Funcionario funcionario;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idCliente")
    private Cliente cliente;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "Pedido_Servicos", joinColumns = {
        @JoinColumn(name = "idPedido")},
            inverseJoinColumns = {
                @JoinColumn(name = "idServico")})
    private List<Servico> servicos;
    
    public Pedido(){
        
    }

    public Pedido(int idPedido, Date dataPedido, boolean pago, double precoPedido, String formaPagamento, Funcionario funcionario, Cliente cliente, List<Servico> servicos) {
        this.idPedido = idPedido;
        this.dataPedido = dataPedido;
        this.pago = pago;
        this.precoPedido = precoPedido;
        this.formaPagamento = formaPagamento;
        this.funcionario = funcionario;
        this.cliente = cliente;
        this.servicos = servicos;
    }
    
    

    public int getIdPedido() {
        return idPedido;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public boolean getPago() {
        return pago;
    }

    public double getPrecoPedido() {
        return precoPedido;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Servico> getServicos() {
        return servicos;
    }

}