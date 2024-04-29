package gertarefas;

import dao.ConexaoHibernate;

public class GerDominio {

    public GerDominio() {
        ConexaoHibernate.getSessionFactory();
    }

}
