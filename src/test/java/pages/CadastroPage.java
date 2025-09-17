package pages;

import elementos.ElementosWeb;
import metodos.Metodos;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.time.Duration;

public class CadastroPage {

    private WebDriver driver;
    private Metodos metodo;
    private ElementosWeb el = new ElementosWeb();

    public CadastroPage(WebDriver driver) {
        this.driver = driver;
        this.metodo = new Metodos(driver);
    }

    public void preencherDadosPessoais(String nomeCompleto, String cpf, String email, String whatsapp){
        metodo.preencher(el.nomeCompleto, nomeCompleto);
        metodo.preencher(el.cpf, cpf);
        metodo.preencher(el.email, email);
        metodo.preencher(el.whatsapp, whatsapp);
    }


    public void buscarCep(String cep){
        metodo.preencher(el.cep, cep);
        metodo.clicar(el.buttonBuscarCep);
    }

      public void validarEndereco(String ruaEsperada, String bairroEsperado, String cidadeEsperada){
        metodo.validarValorContem(el.rua, ruaEsperada);
        metodo.validarValorContem(el.bairro, bairroEsperado);
        metodo.validarValorContem(el.cidade, cidadeEsperada);
    }

    public void preencherDadosDeEndereco(String numeroCasa, String complemento){
        metodo.preencher(el.numeroCasa, numeroCasa);
        if (complemento != null && !complemento.trim().isEmpty()) {
        }
        metodo.preencher(el.complemento, complemento);
    }

    public void escolherMetodoEntrega(String categoria) {
        metodo.clicarConstainsTexto(categoria);
    }

    public void clickUpload(){
        metodo.clicar(el.inserirCnh);
    }

    public void enviarImagem(String caminho) {
        metodo.uploadArquivo(caminho);
    }

    public void clickCadastrar(){
        metodo.clicar(el.buttonCadastrar);
    }

    public void validarMsgCadastroSucesso(String texto){
        metodo.validarTexto(texto, el.msgCadastroSucesso);
    }

    public void msgErroNomeObrigatorio(String texto){
       metodo.validarTexto(texto, el.msgAlertNome);
    }

    public void msgErroCpfObrigatorio(String texto){
        metodo.validarTexto(texto, el.msgAlertCpf);
    }

    public void msgErroCpfInvalido(String texto) {
        metodo.validarTexto(texto, el.msgAlertCpf2);
    }

    public void msgErroEmailObrigatorio(String texto){
        metodo.validarTexto(texto, el.msgAlertEmail);
    }

    public void msgErroCepObrigatorio(String texto){
        metodo.validarTexto(texto, el.msgAlertCep);
    }

    public void msgErroCepInvalido(String texto){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(el.msgAlertCep2, texto));
        metodo.validarTexto(texto, el.msgAlertCep2);
    }

    public void msgErroNumeroObrigatorio(String texto){
        metodo.validarTexto(texto, el.msgAlertNumeroEndereco);
    }

    public void msgErroMetodoEntregaObrigatorio(String texto){
        metodo.validarTexto(texto, el.msgAlertMetodoEntrega);
    }

    public void msgErroCnhObrigatorio(String texto){
        metodo.validarTexto(texto, el.msgAlertCnh);
    }

    public void validarmsgsEmailInvalido(String emailInvalido){
        metodo.validarValorContem2(el.email, emailInvalido);

    }
}
