package dao;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import model.Funcionario;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class FuncionarioDao extends GenericDao {

    public List<Funcionario> pesquisar(String pesq, int tipo) throws HibernateException {
        Session sessao = null;
        List lista = new ArrayList();

        try {
            sessao = ConexaoHibernate.getSessionFactory().openSession();
            sessao.beginTransaction();

            //OPERAÇÕES
            CriteriaBuilder builder = sessao.getCriteriaBuilder();
            CriteriaQuery consulta = builder.createQuery(Funcionario.class);
            Root tabela = consulta.from(Funcionario.class);

            //Where
            Predicate restricoes = null;
            switch (tipo) {
                case 1:
                    restricoes = builder.like(tabela.get("nome"), pesq + "%");
                    break;
                case 2:
                     try {
                    double preco = Double.parseDouble(pesq);
                    restricoes = builder.equal(tabela.get("salario"), preco);
                } catch (NumberFormatException e) {
                    throw new HibernateException("O Salário deve ser um número válido.", e);
                }
                break;
                case 3:
                /*
                    Expression mes = builder.function("month", Integer.class, tabela.get("dtnascimento"));
                    restricoes = builder.equal(mes, pesq);
                 */
                default:
                    return null;
            }
            consulta.where(restricoes);
            consulta.orderBy(builder.asc(tabela.get("salario")));
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

    public List<Funcionario> pesquisarPorNome(String pesq) throws HibernateException {
        return pesquisar(pesq, 1);
    }

    public List<Funcionario> pesquisarPorSalario(String pesq) throws HibernateException {
        return pesquisar(pesq, 2);
    }
}
