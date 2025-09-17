package testes;

import drivers.DriverManager;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.CadastroPage;
import utils.ScreenShotUtil;

import java.awt.*;

public class CadastroTestes {

    private WebDriver driver;
    private CadastroPage cadastroPage;

    @Before
    public void setup(){
        driver = DriverManager.getDriver();
        driver.manage().deleteAllCookies();


    }

    @AfterAll
    public static void fecharNoFim() {
        DriverManager.quitDriver();
    }




    @Given("que eu esteja na tela de cadastro")
    public void que_eu_esteja_na_tela_de_cadastro() {
        cadastroPage = new CadastroPage(driver);
        driver.get("https://buger-eats.vercel.app/deliver");
    }
    @When("informo meus dados pessoais válidos")
    public void informo_meus_dados_pessoais_válidos() {
        cadastroPage.preencherDadosPessoais("Renato Stabelino Dal Bello", "44670089854", "rs-bello@hotmail.com", "11988353046");
    }
    @When("insiro meus dados de endereço corretamente")
    public void insiro_meus_dados_de_endereço_corretamente() {
        cadastroPage.buscarCep("05271200");
        cadastroPage.validarEndereco("Rua Luís Pereira", "Jardim Santa Fé", "São Paulo");
        cadastroPage.preencherDadosDeEndereco("605","null");
    }
    @When("seleciono o tipo de veículo como moto")
    public void seleciono_o_tipo_de_veículo_como_moto() {
        cadastroPage.escolherMetodoEntrega("Moto");
    }
    @When("anexo uma imagem válida da CNH")
    public void anexo_uma_imagem_válida_da_cnh() {
        cadastroPage.clickUpload();
        cadastroPage.enviarImagem("C:\\Users\\Renato\\OneDrive\\Documentos\\CNH2.jpg");
    }
    @When("clico para realizar meu cadastro")
    public void clico_para_realizar_meu_cadastro() {
        cadastroPage.clickCadastrar();
    }
    @Then("o sistema realiza o meu cadastro com sucesso exibindo uma mensagem de confirmação")
    public void o_sistema_realiza_o_meu_cadastro_com_sucesso_exibindo_uma_mensagem_de_confirmação() {
        cadastroPage.validarMsgCadastroSucesso("Recebemos os seus dados. Fique de olho na sua caixa de email, pois e em breve retornamos o contato.");
        ScreenShotUtil.screenShot(driver, "cadastroSucesso", "cadastroRealizado");
    }






    @When("seleciono o tipo de veículo como bicicleta")
    public void seleciono_o_tipo_de_veículo_como_bicicleta() {
        cadastroPage.escolherMetodoEntrega("Bicicleta");
    }







    @When("seleciono o tipo de veículo como van")
    public void seleciono_o_tipo_de_veículo_como_van() {
        cadastroPage.escolherMetodoEntrega("Van/Carro");
    }





    @Given("nao informo nenhum dado obrigatorio")
    public void nao_informo_nenhum_dado_obrigatorio() {
        cadastroPage.clickCadastrar();

    }
    @Then("eu valido as mensagens nos campos indicando a obrigatoriedade do preenchimento")
    public void eu_valido_as_mensagens_nos_campos_indicando_a_obrigatoriedade_do_preenchimento() {
        cadastroPage.msgErroNomeObrigatorio("É necessário informar o nome");
        cadastroPage.msgErroCpfObrigatorio("É necessário informar o CPF");
        cadastroPage.msgErroEmailObrigatorio("É necessário informar o email");
        cadastroPage.msgErroCepObrigatorio("É necessário informar o CEP");
        cadastroPage.msgErroNumeroObrigatorio("É necessário informar o número do endereço");
        cadastroPage.msgErroMetodoEntregaObrigatorio("Selecione o método de entrega");
        cadastroPage.msgErroCnhObrigatorio("Adicione uma foto da sua CNH");
        ScreenShotUtil.screenShot(driver, "cadastroNegativo", "cadastroEmBranco");
    }








    @Given("informo dados obrigatorios invalidos")
    public void informo_dados_obrigatorios_invalidos() {
        cadastroPage.preencherDadosPessoais("Renato Stabelino Dal Bello", "446-700-898-54", "rs-bellohotmail.com", "11988353046");
        cadastroPage.escolherMetodoEntrega("Moto");
        cadastroPage.clickUpload();
        cadastroPage.enviarImagem("C:\\Users\\Renato\\OneDrive\\Documentos\\CNH2.jpg");
        cadastroPage.clickCadastrar();

    }
    @Then("eu valido as mensagens nos campos indicando os dados invalidos")
    public void eu_valido_as_mensagens_nos_campos_indicando_os_dados_invalidos() {
        cadastroPage.validarmsgsEmailInvalido("Inclua um \"@\" no endereço de e-mail. \"rs-bellohotmail.com\" está com um \"@\" faltando.");
        cadastroPage.preencherDadosPessoais("Renato Stabelino Dal Bello", "446-700-898-54", "rs-bello@hotmail.com", "11988353046");
        cadastroPage.buscarCep("052712");
        cadastroPage.msgErroCepInvalido("Informe um CEP válido");
        cadastroPage.clickCadastrar();
        cadastroPage.msgErroCpfInvalido("Oops! CPF inválido");
        ScreenShotUtil.screenShot(driver, "cadastroNegativo", "cadastroDadosInvalidos");

    }



    @Given("preencho os campos obrigatorios")
    public void preencho_os_campos_obrigatorios() {
        cadastroPage.preencherDadosPessoais("Renato Stabelino Dal Bello", "44670089854", "rs-bello@hotmail.com", "11988353046");
        cadastroPage.buscarCep("05271200");
        cadastroPage.validarEndereco("Rua Luís Pereira", "Jardim Santa Fé", "São Paulo");
        cadastroPage.preencherDadosDeEndereco("605","null");
        cadastroPage.escolherMetodoEntrega("Moto");
    }
    @Given("nao anexo a cnh")
    public void nao_anexo_a_cnh() {
        cadastroPage.clickCadastrar();
    }
    @Then("eu valido a mensagem de erro sobre a obrigatoriedade do anexo")
    public void eu_valido_a_mensagem_de_erro_sobre_a_obrigatoriedade_do_anexo() {
        cadastroPage.msgErroCnhObrigatorio("Adicione uma foto da sua CNH");
        ScreenShotUtil.screenShot(driver, "cadastroNegativo", "cadastroSemCnh");
    }


}
