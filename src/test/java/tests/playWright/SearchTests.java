package tests.playWright;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import core.BasePlayWrightTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;


public class SearchTests extends BasePlayWrightTest {

    @Test
    public void fillManyTextBoxes() {
        page.navigate("https://datatables.net/examples/api/form.html");
        //Выбираем из выпадающего списка значение
        page.selectOption("[name=example_length]", "50");
        //Получаем нужын элементы на странице
        List<ElementHandle> fields = page.querySelectorAll("//tbody//input[@type='text']");
        //Заполняем все элементы текстом
        fields.forEach(x -> x.fill("threadqa playwright"));
    }

    @Test
    public void textBoxFillTest() {
        page.navigate("http://85.192.34.140:8081/");
        page.getByText("Elements").click();
        page.querySelector("//li[@id='item-0']/span[1]").click();
        page.fill("[id=userName]", "ThreadQA Test");
        page.fill("[id=userEmail]", "threadqa@gmail.com");
        page.fill("[id=currentAddress]", "somewhere");
        page.click("[id=submit]");

        //Проверяем, что после заполнения формы, появился другой блок
        Assert.assertTrue(page.isVisible("[id=output]"));
        //Проверяем, что в появившемся блоке, текст содержит предыдущий текст
        Assert.assertTrue(page.locator("[id=name]").textContent().contains("NOT ThreadQA Test"));
    }

    @Test
    public void sliderTest() {
        page.navigate("http://85.192.34.140:8081/");
        page.getByText("Widgets").click();
        page.getByText("Slider").click();
        Locator slider = page.locator(".range-slider");
        //Двигаем слайдер слева на право на 20 пикселей
        slider.dragTo(slider, new Locator.DragToOptions().setTargetPosition(slider.boundingBox().x + 20, 0));
        //Проверяем, что старое значение слайдера не равно прежнему
        Assert.assertNotEquals("25", page.locator("[id=sliderValue]").getAttribute("value"));
    }

    @Test
    public void alertTest() {
        page.navigate("http://85.192.34.140:8081/");
        page.getByText("Alerts, Frame").first().click();
        page.locator("//*[@id='item-1']//following::span[text()='Alerts']").click();
        page.locator("[id=alertButton]").click();
        //Метод который позволяет переключится на диалоговое окно
        page.onDialog(dialog -> {
            assertEquals("alert", dialog.type());
            //Проверка что сообщение в окне появилось нужное
            assertEquals(dialog.message(), "You clicked a button");
            //Нажимаем ОК в диалоговом окне
            dialog.accept();
        });
    }

    @Test(priority = 1)
    public void networkTest() {
        //открываем нужную страницу
        page.navigate("http://85.192.34.140:8081/");
        //кликаем по элементу с помощью текста
        page.getByText("Elements").click();
        //клик по первому элементу, подходящий под условие если их найдено много
        page.getByText("Links").first().click();

        //Runnable операция при определенных действий с сетью в браузере
        page.waitForRequest("http://85.192.34.140/api/bad-request", () -> {
            //по нажатию кнопки должен отправизся запрос по адресу
            page.locator("[id=bad-request]").click();
        });

        //Чтение последнего запроса из браузера из вкладки Network
        page.onResponse(response -> {
            assertEquals(response.status(), 400);
            assertEquals(response.url(), "http://85.192.34.140/api/bad-request");
            assertEquals(response.request().method(), "GET");
        });
    }

}