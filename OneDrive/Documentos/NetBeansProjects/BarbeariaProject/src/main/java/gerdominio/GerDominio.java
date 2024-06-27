package gerdominio;

import dao.ClienteDao;
import dao.ConexaoHibernate;
import dao.GenericDao;
import java.sql.SQLException;
import java.util.List;
import model.Cliente;
import model.Funcionario;
import model.Servico;

public class GerDominio {

    private ClienteDao clidao;
    private GenericDao gendao;

    public GerDominio() {
        ConexaoHibernate.getSessionFactory();
        clidao = new ClienteDao();
        gendao = new GenericDao();
    }

    public void inserirCliente(Cliente cliente) throws ClassNotFoundException, SQLException {
        clidao.inserir(cliente);
    }

    public void inserirFuncionario(Funcionario funcionario) throws ClassNotFoundException, SQLException {
        clidao.inserir(funcionario);
    }

    public void inserirServico(Servico servico) throws ClassNotFoundException, SQLException {
        gendao.inserir(servico);
    }

    public void excluirFuncionario(Funcionario funcionario) throws ClassNotFoundException, SQLException {
        clidao.excluir(funcionario);
    }

    public void excluirCliente(Cliente cliente) throws ClassNotFoundException, SQLException {
        gendao.excluir(cliente);
    }

    public void excluirServico(Servico servico) throws ClassNotFoundException, SQLException {
        clidao.excluir(servico);
    }

    public List listar(Class classe) throws ClassNotFoundException, SQLException {
        return gendao.listar(classe);
    }

}
