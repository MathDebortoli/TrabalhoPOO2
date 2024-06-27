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

    @Column
    private boolean tesoura;

    @Column
    private boolean maquina;

    @Column
    private boolean shampoo;

    @Column
    private boolean condicionador;

    @Column
    private boolean navalha;

    @Lob
    private byte[] imagemServico;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "Pedido_Servicos", joinColumns = {
        @JoinColumn(name = "idServico")},
            inverseJoinColumns = {
                @JoinColumn(name = "idPedido")})
    private List<Pedido> pedidos;
    
    public Servico(){
        
    }

    public Servico(int idServico, String tipo, String cabeloPreferencial, boolean quimica, double preco, String nomeServico, double tempoMedio, boolean tesoura, boolean maquina, boolean shampoo, boolean condicionador, boolean navalha, byte[] imagemServico, List<Pedido> pedidos) {
        this.idServico = idServico;
        this.tipo = tipo;
        this.cabeloPreferencial = cabeloPreferencial;
        this.quimica = quimica;
        this.preco = preco;
        this.nomeServico = nomeServico;
        this.tempoMedio = tempoMedio;
        this.tesoura = tesoura;
        this.maquina = maquina;
        this.shampoo = shampoo;
        this.condicionador = condicionador;
        this.navalha = navalha;
        this.imagemServico = imagemServico;
        this.pedidos = pedidos;
    }
    
    

    public boolean getTesoura() {
        return tesoura;
    }

    public boolean getMaquina() {
        return maquina;
    }

    public boolean getShampoo() {
        return shampoo;
    }

    public boolean getCondicionador() {
        return condicionador;
    }

    public boolean getNavalha() {
        return navalha;
    }

    public int getIdServico() {
        return idServico;
    }

    public String getTipo() {
        return tipo;
    }

    public String getCabeloPreferencial() {
        return cabeloPreferencial;
    }

    public boolean getQuimica() {
        return quimica;
    }

    public double getPreco() {
        return preco;
    }

    public String getNomeServico() {
        return nomeServico;
    }

    public double getTempoMedio() {
        return tempoMedio;
    }

    public byte[] getImagemServico() {
        return imagemServico;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

}
