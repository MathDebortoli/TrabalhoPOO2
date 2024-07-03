package gertarefas;

import gerdominio.GerDominio;
import java.awt.Frame;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import view.FrmInit;
import view.JdlCadastroCliente;
import view.JdlCadastroFuncionario;
import view.JdlCadastroPedido;
import view.JdlCadastroServico;
import view.JdlConsultarAgenda;
import view.JdlGerenciarCadastros;
import view.JdlSobreSistema;

public class GerInterfaceGrafica {

    private static GerInterfaceGrafica instance;
    //Instancia Singleton

    private static GerDominio gerDom;
    private FrmInit frmprincipal = null;

    private JdlCadastroCliente cadcliente = null;
    private JdlCadastroPedido cadpedido = null;
    private JdlCadastroServico cadservico = null;
    private JdlSobreSistema sobresistema = null;
    private JdlConsultarAgenda consultagenda = null;
    private JdlCadastroFuncionario cadfunc = null;
    private JdlGerenciarCadastros gercad = null;

    public static GerInterfaceGrafica getMyInstance() {
        if (instance == null) {
            instance = new GerInterfaceGrafica();
        }
        return instance;
    }

    private JDialog abrirJanelaDialog(java.awt.Frame parent, JDialog dlg, Class classe) {
        if (dlg == null) {
            try {
                dlg = (JDialog) classe.getConstructor(Frame.class, boolean.class).newInstance(parent, true);
            } catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                JOptionPane.showMessageDialog(parent, "Erro ao abrir a janela " + classe.getName() + ". " + ex.getMessage());
            }
        }
        dlg.setVisible(true);

        return dlg;
    }

    public void abrirJanPrincial() {
        if (frmprincipal == null) {
            frmprincipal = new FrmInit();
        }
        frmprincipal.setVisible(true);
    }

    public GerDominio getGerDom() {
        return gerDom;
    }

    public void abrirJanCadPedido() {
        cadpedido = (JdlCadastroPedido) abrirJanelaDialog(frmprincipal, cadpedido, JdlCadastroPedido.class);
    }

    public void abrirJanCadCliente() {
        cadcliente = (JdlCadastroCliente) abrirJanelaDialog(frmprincipal, cadcliente, JdlCadastroCliente.class);
    }

    public void abrirJanCadServico() {
        cadservico = (JdlCadastroServico) abrirJanelaDialog(frmprincipal, cadservico, JdlCadastroServico.class);
    }

    public void abrirJanConsultarAgenda() {
        consultagenda = (JdlConsultarAgenda) abrirJanelaDialog(frmprincipal, consultagenda, JdlConsultarAgenda.class);
    }

    public void abrirJanCadFuncionario() {
        cadfunc = (JdlCadastroFuncionario) abrirJanelaDialog(frmprincipal, cadfunc, JdlCadastroFuncionario.class);
    }

    public void abrirJanSobreSistema() {
        sobresistema = (JdlSobreSistema) abrirJanelaDialog(frmprincipal, sobresistema, JdlSobreSistema.class);
    }

    public Object abrirJanGenCadastrosSelecionado() {
        gercad = (JdlGerenciarCadastros) abrirJanelaDialog(frmprincipal, gercad, JdlGerenciarCadastros.class);
        return gercad.getSelecionado();
    }

    public void abrirJanGenCadastrosNormal() {
        gercad = (JdlGerenciarCadastros) abrirJanelaDialog(frmprincipal, gercad, JdlGerenciarCadastros.class);
    }

    public void carregarCombo(JComboBox combo, Class classe) {
        try {
            List lista = getGerDom().listar(classe);
            combo.setModel(new DefaultComboBoxModel(lista.toArray()));
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(classe.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String args[]) {
        /*Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmInit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmInit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmInit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmInit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        instance = getMyInstance();
        gerDom = new GerDominio();
        instance.abrirJanPrincial();
    }
}
