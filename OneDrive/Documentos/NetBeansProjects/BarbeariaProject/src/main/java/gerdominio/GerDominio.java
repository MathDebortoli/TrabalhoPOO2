package gerdominio;

import dao.ClienteDao;
import dao.ConexaoHibernate;
import dao.GenericDao;
import java.util.List;
import model.Cliente;
import model.Funcionario;

public class GerDominio {

    private ClienteDao clidao;
    private GenericDao gendao;

    public GerDominio() {
        ConexaoHibernate.getSessionFactory();
        clidao = new ClienteDao();
    }

    public void inserirCliente(Cliente cliente) {
        clidao.inserir(cliente);
    }

    public void inserirFuncionario(Funcionario funcionario) {
        clidao.inserir(funcionario);
    }

    public void excluirCliente(Object obj) {
        gendao.equals(obj);
    }

    public List listarCidades(Class classe) {
        return gendao.listar(classe);
    }

}
