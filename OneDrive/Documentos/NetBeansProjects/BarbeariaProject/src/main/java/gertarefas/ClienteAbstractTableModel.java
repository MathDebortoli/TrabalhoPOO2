package gertarefas;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Cliente;

public class ClienteAbstractTableModel extends AbstractTableModel {

    private List<Cliente> listaItens = new ArrayList();

    @Override
    public int getRowCount() {
        return listaItens.size();
    }

    @Override
    public int getColumnCount() {
        return 9;
    }

    // Títulos das colunas
    @Override
    public String getColumnName(int column) {
        String nomesColunas[] = {"Nome", "Nascimento", "Sexo", "Cpf", "Telefone", "Foto", "Cidade", "Estado", "Bairro"};
        return nomesColunas[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cliente item = listaItens.get(rowIndex);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        switch (columnIndex) {
            case 0:
                return item.getNome();
            case 1:
                return dateFormat.format(item.getDataNascimento());
            case 2:
                return item.getSexo();
            case 3:
                return item.getCpf();
            case 4:
                return item.getTelefone();
            case 5:
                return item.getFoto();
            case 6:
                return item.getCidade();
            case 7:
                return item.getEstado();
            case 8:
                return item.getBairro();
            default:
                return null;
        }
    }

    public void adicionar(Cliente item) {
        listaItens.add(item);
        fireTableRowsInserted(listaItens.size() - 1, listaItens.size() - 1);

    }

    public void remover(int indice) {
        listaItens.remove(indice);
        fireTableRowsDeleted(indice, indice);

    }

    public Cliente getCliente(int linha) {
        return listaItens.get(linha);
    }

    public void setLista(List<Cliente> novaLista) {

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
