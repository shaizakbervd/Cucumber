package Utils;

import PageObjects.PageObjectManager;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class TestContextSetup {

    public WebDriver Driver;

    public PageObjectManager pageobjectmanager;
    public Base base;
    public GenericUtils generic;

    public TestContextSetup() throws IOException {
        base=new Base();
        pageobjectmanager=new PageObjectManager(base.WebDriverManager());
        generic=new GenericUtils(base.WebDriverManager());
    }
}
