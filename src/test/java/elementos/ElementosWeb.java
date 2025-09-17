package elementos;

import org.openqa.selenium.By;

public class ElementosWeb {

    public By nomeCompleto = By.name("name");
    public By cpf = By.name("cpf");
    public By email = By.name("email");
    public By whatsapp = By.name("whatsapp");
    public By cep = By.name("postalcode");
    public By buttonBuscarCep = By.xpath("//input[@value='Buscar CEP']");
    public By rua = By.xpath("//input[@name='address']");
    public By complemento = By.name("address-details");
    public By numeroCasa = By.name("address-number");
    public By bairro = By.xpath("//input[@name='district']");
    public By cidade = By.xpath("//input[@name='city-uf']");
    public By inserirCnh = By.xpath("//p[text()='Foto da sua CNH']");
    public By buttonCadastrar = By.xpath("//button[text()='Cadastre-se para fazer entregas']");
    public By msgCadastroSucesso = By.xpath("//div[text()='Recebemos os seus dados. Fique de olho na sua caixa de email, pois e em breve retornamos o contato.']");
    public By msgAlertNome = By.xpath("//span[text()='É necessário informar o nome']");
    public By msgAlertCpf = By.xpath("//span[text()='É necessário informar o CPF']");
    public By msgAlertCpf2 = By.xpath("//span[text()='Oops! CPF inválido']");
    public By msgAlertEmail = By.xpath("//span[text()='É necessário informar o email']");
    public By msgAlertCep = By.xpath("//span[text()='É necessário informar o CEP']");
    public By msgAlertCep2 = By.xpath("//span[text()='Informe um CEP válido']");
    public By msgAlertNumeroEndereco = By.xpath("//span[text()='É necessário informar o número do endereço']");
    public By msgAlertMetodoEntrega = By.xpath("//span[text()='Selecione o método de entrega']");
    public By msgAlertCnh = By.xpath("//span[text()='Adicione uma foto da sua CNH']");

}
