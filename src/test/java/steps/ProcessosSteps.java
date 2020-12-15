package steps;

import cucumber.api.PendingException;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Quando;
import definition.Processos;
import org.junit.Assert;
import support.RESTSupport;

public class ProcessosSteps {

    @Dado("^que o usuario gostaria de salvar um novo processo$")
    public void queOUsuarioGostariaDeSalvarUmNovoProcesso() {
        Processos.limparCampos();
    }

    @E("^o usuario informar \"([^\"]*)\" com o valor igual a \"([^\"]*)\"$")
    public void oUsuarioInformarComOValorIgualA(String campo, String valor) throws Throwable {
        Processos.preencherCampo(campo,valor);
    }

    @Quando("^o usuario clicar no botao salvar$")
    public void oUsuarioClicarNoBotaoSalvar() {
        RESTSupport.executePost(Processos.getEndPoint(), Processos.getCompos());
        Processos.setId(RESTSupport.key("id").toString());
    }

    @Quando("^o usuario clicar em mostrar$")
    public void oUsuarioClicarEmMostrar() {
        RESTSupport.executeGet(Processos.getEndPoint() + '/' + Processos.getId());
    }

    @E("^o usuario visualiza o campo \"([^\"]*)\" com o valor igual a \"([^\"]*)\"$")
    public void oUsuarioVisualizaOCampoComOValorIgualA(String campo, String valor) throws Throwable {
       String atual = Processos.recuperarCampo(campo);
       Assert.assertEquals(valor,atual);
    }
}
