package dao;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.criteria.Subquery;
import java.util.ArrayList;
import java.util.List;
import model.Pedido;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class PedidoDao extends GenericDao {

    public List<Pedido> pesquisar(String pesq, int tipo) throws HibernateException {
        Session sessao = null;
        List lista = new ArrayList();

        try {
            sessao = ConexaoHibernate.getSessionFactory().openSession();
            sessao.beginTransaction();

            //OPERAÇÕES
            CriteriaBuilder builder = sessao.getCriteriaBuilder();
            CriteriaQuery consulta = builder.createQuery(Pedido.class);
            Root tabela = consulta.from(Pedido.class);

            //Where
            Predicate restricoes = null;
            switch (tipo) {
                case 1:
                    restricoes = builder.like(tabela.get("formaPagamento"), pesq + "%");
                    break;
                case 2:
                case 3:
                /*
                    Expression mes = builder.function("month", Integer.class, tabela.get("dtnascimento"));
                    restricoes = builder.equal(mes, pesq);
                 */
                default:
                    return null;
            }
            consulta.where(restricoes);
            consulta.orderBy(builder.asc(tabela.get("formaPagamento")));
            lista = sessao.createQuery(consulta).getResultList();

            sessao.getTransaction().commit();
            sessao.close();
        } catch (HibernateException erro) {
            if (sessao != null) {
                sessao.getTransaction().rollback();
                sessao.close();
            }
            throw new HibernateException(erro);
        }
        return lista;
    }

    public List<Pedido> pesquisarPorPagamento(String pesq) throws HibernateException {
        return pesquisar(pesq, 1);
    }
}
