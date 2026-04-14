# Automatización de Login con Selenium y JUnit 5

## Objetivo

El objetivo de esta actividad es aprender a:

- Automatizar acciones en una página web.
- Interactuar con elementos HTML.
- Escribir pruebas automáticas utilizando JUnit.
- Verificar el correcto funcionamiento de una funcionalidad en una aplicación web.

## Herramientas Utilizadas

- **Selenium WebDriver**: Para la automatización de navegadores.
- **JUnit 5**: Para la creación y gestión de pruebas.

## Página Web de Prueba

La actividad se realiza sobre la siguiente página web:

- [Sauce Demo](https://www.saucedemo.com/)

## Estructura del Proyecto

El proyecto se organiza de la siguiente manera:

src
└── test
└── java
└── tests
└── LoginTest.java
└── pages
└── LoginPage.java

### Clase `LoginPage`

La clase `LoginPage` representa la página de inicio de sesión y contiene métodos para interactuar con los elementos de la página:

```java
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    private By userField = By.id("user-name");
    private By passField = By.id("password");
    private By loginBtn = By.id("login-button");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void ingresarUsuario(String user) {
        driver.findElement(userField).sendKeys(user);
    }

    public void ingresarPassword(String pass) {
        driver.findElement(passField).sendKeys(pass);
    }

    public void clickLogin() {
        driver.findElement(loginBtn).click();
    }

    public void login(String user, String pass) {
        ingresarUsuario(user);
        ingresarPassword(pass);
        clickLogin();
    }
}

Clase LoginTest

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest {
    private WebDriver driver;

    @Test
    void loginCorrecto() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        Thread.sleep(2000);
        assertTrue(driver.getCurrentUrl().contains("inventory"));
    }

    @Test
    void loginIncorrecto() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "wrong_password");
        Thread.sleep(2000);
        String errorMessage = driver.findElement(By.cssSelector("h3[data-test='error']")).getText();
        assertTrue(errorMessage.contains("Epic sadface: Username and password do not match any user in this service"));
    }
}
Ejecución de Pruebas
Asegúrate de tener Java y Maven instalados.

Clona el repositorio y navega al directorio del proyecto.

Ejecuta:

mvn test

Preguntas Frecuentes
@BeforeEach: Se ejecuta antes de cada prueba para configurar el entorno.
assertTrue: Verifica que la condición sea verdadera.
findElement() vs findElements(): findElement() devuelve el primer elemento encontrado; findElements() devuelve una lista de todos los elementos encontrados.
Conclusión
Esta actividad proporciona una introducción práctica a la automatización de pruebas en aplicaciones web utilizando Selenium y JUnit.

Este README compacto resume la información esencial sobre la actividad y el código necesario. ¡Espero que te sea útil!
