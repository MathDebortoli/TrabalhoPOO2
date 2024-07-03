package gertarefas;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Servico;

public class ServicoAbstractTableModel extends AbstractTableModel {

    private List<Servico> listaItens = new ArrayList();

    @Override
    public int getRowCount() {
        return listaItens.size();
    }

    @Override
    public int getColumnCount() {
        return 11;
    }

    // Títulos das colunas
    @Override
    public String getColumnName(int column) {
        String nomesColunas[] = {"Nome", "Tipo", "Cab. Preferencial", "Quimica", "Preco", "Tempo (Min)", "Tesoura", "Máquina", "Shampoo", "Condicionador", "Navalha"};
        return nomesColunas[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Servico item = listaItens.get(rowIndex);

        return switch (columnIndex) {
            case 0 ->
                item.getNomeServico();
            case 1 ->
                item.getTipo();
            case 2 ->
                item.getCabeloPreferencial();
            case 3 ->
                item.getQuimica();
            case 4 ->
               "R$ " + item.getPreco();
            case 5 ->
                item.getTempoMedio();
            case 6 ->
                item.getTesoura();
            case 7 ->
                item.getMaquina();
            case 8 ->
                item.getShampoo();
            case 9 ->
                item.getCondicionador();
            case 10 ->
                item.getNavalha();
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
