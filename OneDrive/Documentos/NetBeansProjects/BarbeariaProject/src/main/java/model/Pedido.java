package model;

import jakarta.persistence.*;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

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

    @Column
    private String formaPagamento;

    @ManyToOne
    @JoinColumn(name = "idFuncionario", nullable = false)
    private Funcionario funcionario;

    @ManyToOne
    @JoinColumn(name = "idCliente", nullable = false)
    private Cliente cliente;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "Pedido_Servicos", joinColumns = {
        @JoinColumn(name = "idPedido")},
            inverseJoinColumns = {
                @JoinColumn(name = "idServico")})
    private List<Servico> servicos;

    public Pedido() {
    }

    public Pedido(Date dataPedido, boolean pago, String formaPagamento, Funcionario funcionario, Cliente cliente, List<Servico> servicos) {
        this.dataPedido = dataPedido;
        this.pago = pago;
        this.formaPagamento = formaPagamento;
        this.funcionario = funcionario;
        this.cliente = cliente;
        this.servicos = servicos;
    }

    public Pedido(int idPedido, Date dataPedido, boolean pago, String formaPagamento, Funcionario funcionario, Cliente cliente, List<Servico> servicos) {
        this.idPedido = idPedido;
        this.dataPedido = dataPedido;
        this.pago = pago;
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

    public double calcTotal() {
        double preco = 0;
        for (Servico servico : servicos) {
            preco += servico.getPreco();
        }
        return preco;
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
        final Pedido other = (Pedido) obj;
        return Objects.equals(this.getServicos(), other.getServicos());
    }

}
