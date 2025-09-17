@regressivos @cadastroPrestador
Feature: Cadastro de prestador de servicos
  Como prestador de serviços
  Quero realizar meu cadastro
  Para realizar entregas

  Background:
    Given que eu esteja na tela de cadastro

  @positivo @smoke @moto
  Scenario: Realizar cadastro metodo moto
    When informo meus dados pessoais válidos
    And insiro meus dados de endereço corretamente
    And seleciono o tipo de veículo como moto
    And anexo uma imagem válida da CNH
    And clico para realizar meu cadastro
    Then o sistema realiza o meu cadastro com sucesso exibindo uma mensagem de confirmação


  @positivo @bicicleta
  Scenario: Realizar cadastro metodo bicicleta
    When informo meus dados pessoais válidos
    And insiro meus dados de endereço corretamente
    And seleciono o tipo de veículo como bicicleta
    And anexo uma imagem válida da CNH
    And clico para realizar meu cadastro
    Then o sistema realiza o meu cadastro com sucesso exibindo uma mensagem de confirmação


  @positivo @van
  Scenario: Realizar cadastro metodo van
    When informo meus dados pessoais válidos
    And insiro meus dados de endereço corretamente
    And seleciono o tipo de veículo como van
    And anexo uma imagem válida da CNH
    And clico para realizar meu cadastro
    Then o sistema realiza o meu cadastro com sucesso exibindo uma mensagem de confirmação


  @negativo @branco
  Scenario: Não realizar cadastro com dados em branco
    But nao informo nenhum dado obrigatorio
    And clico para realizar meu cadastro
    Then eu valido as mensagens nos campos indicando a obrigatoriedade do preenchimento

  @negativo @invalidos
  Scenario: Não realizar cadastro com dados invalidos
    But informo dados obrigatorios invalidos
    And clico para realizar meu cadastro
    Then eu valido as mensagens nos campos indicando os dados invalidos

  @negativo @sem_cnh
  Scenario: Não realizar cadastro sem enviar anexo
    And preencho os campos obrigatorios
    But nao anexo a cnh
    And clico para realizar meu cadastro
    Then eu valido a mensagem de erro sobre a obrigatoriedade do anexo


