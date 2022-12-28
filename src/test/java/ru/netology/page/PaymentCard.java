package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static ru.netology.data.DataHelper.*;

public class PaymentCard {

    private SelenideElement cardNumberField = $x("//input[contains(@placeholder,'0000 0000 0000 0000')]");
    private SelenideElement mounthField = $x("//input[contains(@placeholder,'08')]");
    private SelenideElement yearField = $x("//input[contains(@placeholder,'22')]");
    private SelenideElement ownerField = $x("//input[not(@placeholder)]");
    private SelenideElement cvvField = $x("//input[contains(@placeholder,'999')]");
    private SelenideElement furtherButton = $x("//*[text()='Продолжить']");
    private SelenideElement operationSuccessfully = $x("//div[contains(@class, 'notification__content')]");
    private SelenideElement operationDenied = $x("//div[starts-with(text(),'Ошибка!')]");
    private SelenideElement error = $x("(//span[contains(@class,'input__sub')])[last()]");


    public void paymentOperation(NumberCard card, MounthCard mounth, YearCard year, OwnerCard owner, CvvCard cvv) {
        cardNumberField.val(card.getNumber());
        mounthField.val(mounth.getMounth());
        yearField.val(year.getYear());
        ownerField.val(owner.getOwner());
        cvvField.val(cvv.getCvv());
        furtherButton.click();
    }

    public void fieldRequiredError() {
        error.shouldHave(Condition.text("Поле обязательно для заполнения"), Duration.ofSeconds(5))
                .shouldBe(visible);
    }

    public void incorrectNumberCardError() {
        error.shouldHave(Condition.text("Неверный номер карты"), Duration.ofSeconds(5))
                .shouldBe(visible);
    }

    public void invalidFormatError() {
        error.shouldHave(Condition.text("Неверный формат"), Duration.ofSeconds(5))
                .shouldBe(visible);
    }

    public void invalidYearError() {
        error.shouldHave(Condition.text("Истёк срок действия карты"), Duration.ofSeconds(5))
                .shouldBe(visible);
    }

    public void invalidFormatOwnerError() {
        error.shouldHave(Condition.text("Неверный формат. Используйте только английские буквы"), Duration.ofSeconds(5))
                .shouldBe(visible);
    }

    public void ownerLongStringError() {
        error.shouldHave(Condition.text("Неверный формат. Имя и фамилия Владельца должны быть разделены пробелом"),
                        Duration.ofSeconds(5))
                .shouldBe(visible);
    }

    public void operationApproved() {
        operationSuccessfully.shouldHave(Condition.text("Операция одобрена Банком"), Duration.ofSeconds(15))
                .shouldBe(visible);
    }

    public void operationRejected() {
        operationDenied.shouldHave(Condition.text("Банк отказал в проведении операции."), Duration.ofSeconds(15))
                .shouldBe(visible);
    }

}
