package gertarefas;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Servico;

public class ItemPedidoAbstractTableModel extends AbstractTableModel {

    private List<Servico> listaItens = new ArrayList();

    @Override
    public int getRowCount() {
        return listaItens.size();
    }

    @Override
    public int getColumnCount() {
        return 1;
    }
    
    public List<Servico> getList(){
        return listaItens;
    }

    // Títulos das colunas
    @Override
    public String getColumnName(int column) {
        String nomesColunas[] = {"Nome do Servico"};
        return nomesColunas[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Servico item = listaItens.get(rowIndex);

        return switch (columnIndex) {
            case 0 ->
                item.getNomeServico();
            default ->
                null;
        };
    }

    public void adicionar(Servico item) {
        listaItens.add(item);
        fireTableRowsInserted(listaItens.size() - 1, listaItens.size() - 1);

    }

    public void remover(int indice) {
        listaItens.remove(indice);
        fireTableRowsDeleted(indice, indice);
    }

    public Servico getServico(int linha) {
        return listaItens.get(linha);
    }

    public void setLista(List<Servico> novaLista) {
        if (novaLista == null) {
            listaItens.clear();
            fireTableRowsDeleted(0, 0);
        } else {
            listaItens = novaLista;
            fireTableRowsInserted(0, listaItens.size() - 1);
        }

    }

}
