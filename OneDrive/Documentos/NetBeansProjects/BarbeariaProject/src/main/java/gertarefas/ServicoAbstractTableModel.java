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

        switch (columnIndex) {
            case 0:
                return item.getNomeServico();
            case 1:
                return item.getTipo();
            case 2:
                return item.getCabeloPreferencial();
            case 3:
                return item.getQuimica();
            case 4:
                return item.getPreco();
            case 5:
                return item.getTempoMedio();
            case 6:
                return item.getTesoura();
            case 7:
                return item.getMaquina();
            case 8:
                return item.getShampoo();
            case 9:
                return item.getCondicionador();
            case 10:
                return item.getNavalha();
            default:
                return null;
        }
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

        if (novaLista.isEmpty()) {
            if (!listaItens.isEmpty()) {
                listaItens.clear();
                fireTableRowsDeleted(0, 0);
            }
        } else {
            listaItens = novaLista;
            fireTableRowsInserted(0, listaItens.size() - 1);
        }

    }

}
