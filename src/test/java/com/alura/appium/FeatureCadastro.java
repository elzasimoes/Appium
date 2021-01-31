package com.alura.appium;

import static org.junit.Assert.assertTrue;

import io.appium.java_client.MobileElement;
import org.junit.Assert;
import org.junit.Test;

import java.net.MalformedURLException;


public class FeatureCadastro
{

    @Test
    public void WrongPasswordVerification() throws MalformedURLException
    {
        AppiumDriverConfig driver = new AppiumDriverConfig();

        MobileElement botaoCadastro = (MobileElement)driver.driver.findElementById("br.com.alura.aluraesporte:id/login_botao_cadastrar_usuario");
        botaoCadastro.click();

        MobileElement campoNome = (MobileElement)driver.driver.findElementById("br.com.alura.aluraesporte:id/input_nome");
        campoNome.setValue("Teste");

        MobileElement campoSenha = (MobileElement)driver.driver.findElementById("br.com.alura.aluraesporte:id/input_senha");
        campoSenha.setValue("123");

        MobileElement campoConfirmarSenha = (MobileElement)driver.driver.findElementById("br.com.alura.aluraesporte:id/input_confirmar_senha");
        campoConfirmarSenha.setValue("124");

        MobileElement botaoCadastrar = (MobileElement)driver.driver.findElementById("br.com.alura.aluraesporte:id/cadastro_usuario_botao_cadastrar");
        botaoCadastrar.click();

        MobileElement erro = (MobileElement)driver.driver.findElementById("br.com.alura.aluraesporte:id/erro_cadastro");

        Assert.assertEquals("Senhas não conferem", erro.getText());

        assertTrue( true );
    }
}
