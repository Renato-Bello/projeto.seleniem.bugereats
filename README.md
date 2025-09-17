# Projeto: Automação de Testes — Buger Eats (Selenium + Java + Cucumber)

Automação E2E no site [Buger Eats](https://buger-eats.vercel.app/) usando **Java + Selenium WebDriver + JUnit + Cucumber** no padrão **Page Objects**.

![Java](https://img.shields.io/badge/Java-21%2B-red)
![Selenium](https://img.shields.io/badge/Selenium-4.x-brightgreen)
![JUnit](https://img.shields.io/badge/JUnit-5-blue)
![Cucumber](https://img.shields.io/badge/Cucumber-BDD-23a55a)
![Maven](https://img.shields.io/badge/Build-Maven-lightgrey)

## Funcionalidades cobertas
- **Cadastro para entregas**: Cadastrar usuario para realização de entregas na aplicação


## Pré-requisitos
- **Java JDK** 21+ (testado com 23.0.2)
- **Maven** 3.9+
- **Git**
- **Chrome** ou **Edge** instalados (Selenium Manager resolve o driver automaticamente)

## Estrutura do projeto
```text
.
├─ src
│  └─ test
│     ├─ java
│     │  ├─ drivers
│     │  │  ├─ DriverManager.java
│     │  │  └─ DriversFactory.java
│     │  ├─ elementos
│     │  │  └─ ElementosWeb.java
│     │  ├─ hooks
│     │  │  └─ Hooks.java
│     │  ├─ metodos
│     │  │  └─ Metodos.java
│     │  ├─ pages
│     │  │  └─ CadastroPage.java
│     │  ├─ runner
│     │  │  └─ RunCucumberTest.java
│     │  ├─ testes
│     │  │  └─ CadastroTestes.java
│     │  └─ utils
│     │     └─ ScreenShotUtil.java
│     └─ resources
│        └─ features
│           └─ cadastro.feature
├─ target
│  ├─ evidenciascadastroNegativo/
│  ├─ evidenciascadastroSucesso/
│  └─ cucumber-report.html
├─ pom.xml
└─ README.md
```

## Como executar

Clonar o repositório e, na raiz do projeto:

### Todos os cenários
`mvn clean test`

### Por tag do Cucumber (exemplo)
`mvn clean test -Dcucumber.filter.tags="@van"`

### Uma feature específica
`mvn clean test -Dcucumber.features=src/test/resources/features/cadastro.feature`

### Pelo IntelliJ (Runner)
- Abrir `RunCucumberTests.java` → ícone **Run** ▶️

---

## Relatório & Evidências
- **Relatório HTML:** `target/cucumber-report.html`
- **Screenshots de falha:** `target/evidencias*`

---

## Troubleshooting
- Aviso CDP nos logs → atualize Selenium e o navegador.
- Popup “Mude sua senha” → rode com perfil limpo ou desative PasswordLeakDetection nas Options.

## Roadmap
- [ ] Allure report
- [ ] CI (GitHub Actions)

---

## Autor
**Renato Bello — QA Automation**  
LinkedIn: <https://www.linkedin.com/in/renato-bello>