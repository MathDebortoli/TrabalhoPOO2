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

        return switch (columnIndex) {
            case 0 ->
                item.getNome();
            case 1 ->
                dateFormat.format(item.getDataNascimento());
            case 2 ->
                item.getSexo();
            case 3 ->
                item.getCpf();
            case 4 ->
                item.getTelefone();
            case 5 ->
                item.getFoto();
            case 6 ->
                item.getCidade();
            case 7 ->
                item.getEstado();
            case 8 ->
                item.getBairro();
            default ->
                null;
        };
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
        if (novaLista == null) {
            listaItens.clear();
            fireTableRowsDeleted(0, 0);
        } else {
            listaItens = novaLista;
            fireTableRowsInserted(0, listaItens.size() - 1);
        }
    }
}
