package steps;

import com.jayway.restassured.response.Response;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import definition.Processos;
import org.junit.Assert;
import support.RESTSupport;

import static org.hamcrest.CoreMatchers.equalTo;

public class ProcessosSteps {
    private Response resultado;

    @Dado("^que o usuario gostaria de salvar um novo processo$")
    public void queOUsuarioGostariaDeSalvarUmNovoProcesso() {
        Processos.limparCampos();
    }

    @E("^o usuario informar \"([^\"]*)\" com o valor igual a \"([^\"]*)\"$")
    public void oUsuarioInformarComOValorIgualA(String campo, String valor) {
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
    public void oUsuarioVisualizaOCampoComOValorIgualA(String campo, String valor) {
       String atual = Processos.recuperarCampo(campo);
       Assert.assertEquals(valor,atual);
    }

    @Quando("^alterar o campo (.*) com valor \"([^\"]*)\"$")
    public void alterarOCampoUrgenteComValor(String arg0, String arg1) {
        Processos.addFields(arg0, arg1);
        resultado = RESTSupport.executePut(Processos.getEndPoint() + '/' + Processos.getLastUser() + ".json", Processos.getFields());
    }

    @Então("^a API de proceso deve retornar o status \"([^\"]*)\"$")
    public void aAPIDeProcesoDeveRetornarOStatus(String arg0) {
        Assert.assertEquals(Integer.parseInt(arg0),resultado.statusCode());
    }

    @E("^deve está na urgente \"([^\"]*)\"$")
    public void deveEstaNaUrgente(String arg0,String arg1) {
        resultado.then().body(arg0,equalTo(arg1));
    }

    @Quando("^excluir o processo$")
    public void excluirOProcesso() {
        resultado = RESTSupport.executeDelete(Processos.getEndPoint() + '/'+ Processos.getLastUser() + ".json");
    }

    @E("^consular novamente o processo$")
    public void consularNovamenteOProcesso() {
        resultado = RESTSupport.executeGet(Processos.getEndPoint() + '/' + Processos.getLastUser() + ".json");
    }
}
