package gertarefas;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Funcionario;

public class FuncionarioAbstractTableModel extends AbstractTableModel {

    private List<Funcionario> listaItens = new ArrayList();

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
        String nomesColunas[] = {"Nome", "Nascimento", "Sexo", "Cpf", "Inicio Contrato", "Fim Contrato", "Salario", "Foto", "Cidade", "Estado", "Bairro"};
        return nomesColunas[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Funcionario item = listaItens.get(rowIndex);
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
                dateFormat.format(item.getDataContratoinc());
            case 5 ->
                dateFormat.format(item.getDataContratofim());
            case 6 ->
                item.getSalario();
            case 7 ->
                item.getFoto();
            case 8 ->
                item.getCidade();
            case 9 ->
                item.getEstado();
            case 10 ->
                item.getBairro();
            default ->
                null;
        };
    }

    public void adicionar(Funcionario item) {
        listaItens.add(item);
        fireTableRowsInserted(listaItens.size() - 1, listaItens.size() - 1);
    }

    public void remover(int indice) {
        listaItens.remove(indice);
        fireTableRowsDeleted(indice, indice);
    }

    public Funcionario getFuncionario(int linha) {
        return listaItens.get(linha);
    }

    public void setLista(List<Funcionario> novaLista) {
        if (novaLista == null) {
            listaItens.clear();
            fireTableRowsDeleted(0, 0);
        } else {
            listaItens = novaLista;
            fireTableRowsInserted(0, listaItens.size() - 1);
        }

    }
}
