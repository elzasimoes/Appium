package com.alura.appium.PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CadastroPageObject extends BasePageObject {

    private MobileElement campoNome;
    private MobileElement campoSenha;
    private MobileElement campoConfirmarSenha;
    private MobileElement botaoCadastrar;
    private MobileElement MensagemErro;
    private final By errorID;
    private final By campoNomeID;
    private final By campoSenhaID;
    private final By campoConfirmarSenhaID;
    private final By cotaoCadastrarID;

    protected CadastroPageObject(AppiumDriver driver) {
        super(driver);
        errorID = By.id("br.com.alura.aluraesporte:id/erro_cadastro");
        campoNomeID = By.id("br.com.alura.aluraesporte:id/input_nome");
        campoSenhaID = By.id("br.com.alura.aluraesporte:id/input_senha");
        campoConfirmarSenhaID = By.id("br.com.alura.aluraesporte:id/input_confirmar_senha");
        cotaoCadastrarID = By.id("br.com.alura.aluraesporte:id/cadastro_usuario_botao_cadastrar");
    }


    @Override
    public void BuscarElementos() {

        campoNome = (MobileElement) driver.findElement(campoNomeID);
        campoSenha = (MobileElement) driver.findElement(campoSenhaID);
        campoConfirmarSenha = (MobileElement) driver.findElement(campoConfirmarSenhaID);
        botaoCadastrar = (MobileElement)driver.findElement(cotaoCadastrarID);

    }

    private void PreencherFormulario(String usuario, String senha, String confirmacao){
        campoNome.setValue(usuario);
        campoSenha.setValue(senha);
        campoConfirmarSenha.setValue(confirmacao);
    }

    public LoginPageObject Cadastrar(String usuario, String senha, String confirmacao) {
        PreencherFormulario(usuario, senha, confirmacao);
        botaoCadastrar.click();
        return new LoginPageObject(driver);
    }

    public String MensagemErro(){

        WebDriverWait espera = new WebDriverWait(driver, 3);
        espera.until(ExpectedConditions.presenceOfElementLocated(errorID));
        MensagemErro = (MobileElement)driver.findElement(errorID);
        return MensagemErro.getText();
    }
}