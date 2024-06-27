package gertarefas;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Cliente;
import model.Pedido;

public class PedidoAbstractTableModel extends AbstractTableModel {

    private List<Pedido> listaItens = new ArrayList();

    @Override
    public int getRowCount() {
        return listaItens.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    // Títulos das colunas
    @Override
    public String getColumnName(int column) {
        String nomesColunas[] = {"Data", "Pago", "Preco", "Cliente", "Servicos", "Forma Pagamento"};
        return nomesColunas[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Pedido item = listaItens.get(rowIndex);

        return switch (columnIndex) {
            case 0 ->
                item.getDataPedido();
            case 1 ->
                item.getPago();
            case 2 ->
                item.getPrecoPedido();
            case 3 ->
                item.getCliente();
            case 4 ->
                item.getServicos();
            case 5 ->
                item.getFormaPagamento();
            default ->
                null;
        };
    }

    public void adicionar(Pedido item) {
        listaItens.add(item);
        fireTableRowsInserted(listaItens.size() - 1, listaItens.size() - 1);

    }

    public void remover(int indice) {
        listaItens.remove(indice);
        fireTableRowsDeleted(indice, indice);

    }

    public Pedido getPedido(int linha) {
        return listaItens.get(linha);
    }

    public void setLista(List<Pedido> novaLista) {
        if (novaLista == null) {
            listaItens.clear();
            fireTableRowsDeleted(0, 0);
        } else {
            listaItens = novaLista;
            fireTableRowsInserted(0, listaItens.size() - 1);
        }

    }

}
