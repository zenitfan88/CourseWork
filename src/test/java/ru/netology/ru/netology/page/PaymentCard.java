package ru.netology.ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelper;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static ru.netology.data.DataHelper.*;

public class PaymentCard {

    private SelenideElement cardNumberField = $x("//input[contains(@placeholder,'0000 0000 0000 0000')]");
    private SelenideElement mounthField = $x("//input[contains(@placeholder,'08')]");
    private SelenideElement yearField = $x("//input[contains(@placeholder,'22')]");
    private SelenideElement nameField = $x("//div[3]/span/span[1]/span/span/span[2]/input");
    private SelenideElement cvvField = $x("//input[contains(@placeholder,'999')]");
    private SelenideElement furtherButton = $x("//*[text()='Продолжить']");
    private SelenideElement operationSuccessfully = $x("//*[@id='root']/div/div[2]/div[3]");
    private SelenideElement operationDenied = $x("//*[@id='root']/div/div[3]/div[3]");
    private SelenideElement numberCardError = $x("//div[1]/span/span/span[3]");
    private SelenideElement mounthError = $x("//div[2]/span/span[1]/span/span/span[3]");
    private SelenideElement yearError = $x("//div[2]/span/span[2]/span/span/span[3]");
    private SelenideElement ownerError = $x("//div[3]/span/span[1]/span/span/span[3]");
    private SelenideElement cvvError = $x("//div[3]/span/span[2]/span/span/span[3]");

    public PaymentCard PaymentOperation(DataHelper.NumberCard card) {
        cardNumberField.val(card.getNumber());
        mounthField.val(getMounthCardValid().getMounth());
        yearField.val(getYearCardValid().getYear());
        nameField.val(getOwnerCardValid().getOwner());
        cvvField.val(getCodeCvvCardValid().getCode());
        furtherButton.click();
        return new PaymentCard();
    }

    public PaymentCard EmptyNumberCard() {
        mounthField.val(getMounthCardValid().getMounth());
        yearField.val(getYearCardValid().getYear());
        nameField.val(getOwnerCardValid().getOwner());
        cvvField.val(getCodeCvvCardValid().getCode());
        furtherButton.click();
        numberCardError.shouldHave(Condition.text("Поле обязательно для заполнения"), Duration.ofSeconds(5))
                .shouldBe(visible);
        return new PaymentCard();
    }

    public PaymentCard NullNumberCard() {
        cardNumberField.val(getNumberCardNull().getNumber());
        mounthField.val(getMounthCardValid().getMounth());
        yearField.val(getYearCardValid().getYear());
        nameField.val(getOwnerCardValid().getOwner());
        cvvField.val(getCodeCvvCardValid().getCode());
        furtherButton.click();
        numberCardError.shouldHave(Condition.text("Неверный номер карты"), Duration.ofSeconds(5))
                .shouldBe(visible);
        return new PaymentCard();
    }

    public PaymentCard InvalidSymbolsNumberCard() {
        cardNumberField.val(getInvalidSymbolsNumberCard().getNumber());
        mounthField.val(getMounthCardValid().getMounth());
        yearField.val(getYearCardValid().getYear());
        nameField.val(getOwnerCardValid().getOwner());
        cvvField.val(getCodeCvvCardValid().getCode());
        furtherButton.click();
        numberCardError.shouldHave(Condition.text("Неверный формат"), Duration.ofSeconds(5))
                .shouldBe(visible);
        return new PaymentCard();
    }

    public PaymentCard EmptyMounth(DataHelper.NumberCard card) {
        cardNumberField.val(card.getNumber());
        yearField.val(getYearCardValid().getYear());
        nameField.val(getOwnerCardValid().getOwner());
        cvvField.val(getCodeCvvCardValid().getCode());
        furtherButton.click();
        mounthError.shouldHave(Condition.text("Поле обязательно для заполнения"), Duration.ofSeconds(5))
                .shouldBe(visible);
        return new PaymentCard();
    }

    public PaymentCard NullMounth(DataHelper.NumberCard card) {
        cardNumberField.val(card.getNumber());
        mounthField.val(getMounthCardNull().getMounth());
        yearField.val(getYearCardValid().getYear());
        nameField.val(getOwnerCardValid().getOwner());
        cvvField.val(getCodeCvvCardValid().getCode());
        furtherButton.click();
        mounthError.shouldHave(Condition.text("Неверный формат"), Duration.ofSeconds(5))
                .shouldBe(visible);
        return new PaymentCard();
    }

    public PaymentCard MounthOverValid(DataHelper.NumberCard card) {
        cardNumberField.val(card.getNumber());
        mounthField.val(getMounthCardOverValid().getMounth());
        yearField.val(getYearCardValid().getYear());
        nameField.val(getOwnerCardValid().getOwner());
        cvvField.val(getCodeCvvCardValid().getCode());
        furtherButton.click();
        mounthError.shouldHave(Condition.text("Неверный формат"), Duration.ofSeconds(5))
                .shouldBe(visible);
        return new PaymentCard();
    }

    public PaymentCard InvalidSymbolsMounth(DataHelper.NumberCard card) {
        cardNumberField.val(card.getNumber());
        mounthField.val(getMounthCardInvalidSymbols().getMounth());
        yearField.val(getYearCardValid().getYear());
        nameField.val(getOwnerCardValid().getOwner());
        cvvField.val(getCodeCvvCardValid().getCode());
        furtherButton.click();
        mounthError.shouldHave(Condition.text("Неверный формат"), Duration.ofSeconds(5))
                .shouldBe(visible);
        return new PaymentCard();
    }

    public PaymentCard EmptyYear(DataHelper.NumberCard card) {
        cardNumberField.val(card.getNumber());
        mounthField.val(getMounthCardValid().getMounth());
        nameField.val(getOwnerCardValid().getOwner());
        cvvField.val(getCodeCvvCardValid().getCode());
        furtherButton.click();
        yearError.shouldHave(Condition.text("Поле обязательно для заполнения"), Duration.ofSeconds(5))
                .shouldBe(visible);
        return new PaymentCard();
    }

    public PaymentCard InvalidYear(DataHelper.NumberCard card) {
        cardNumberField.val(card.getNumber());
        mounthField.val(getMounthCardValid().getMounth());
        yearField.val(getYearCardUnderValid().getYear());
        nameField.val(getOwnerCardValid().getOwner());
        cvvField.val(getCodeCvvCardValid().getCode());
        furtherButton.click();
        yearError.shouldHave(Condition.text("Истёк срок действия карты"), Duration.ofSeconds(5))
                .shouldBe(visible);
        return new PaymentCard();
    }

    public PaymentCard NullYear(DataHelper.NumberCard card) {
        cardNumberField.val(card.getNumber());
        mounthField.val(getMounthCardValid().getMounth());
        yearField.val(getYearCardNull().getYear());
        nameField.val(getOwnerCardValid().getOwner());
        cvvField.val(getCodeCvvCardValid().getCode());
        furtherButton.click();
        yearError.shouldHave(Condition.text("Неверный формат"), Duration.ofSeconds(5))
                .shouldBe(visible);
        return new PaymentCard();
    }

    public PaymentCard InvalidSymbolsYear(DataHelper.NumberCard card) {
        cardNumberField.val(card.getNumber());
        mounthField.val(getMounthCardValid().getMounth());
        yearField.val(getYearCardInvalidSymbols().getYear());
        nameField.val(getOwnerCardValid().getOwner());
        cvvField.val(getCodeCvvCardValid().getCode());
        furtherButton.click();
        yearError.shouldHave(Condition.text("Неверный формат"), Duration.ofSeconds(5))
                .shouldBe(visible);
        return new PaymentCard();
    }

    public PaymentCard EmptyOwner(DataHelper.NumberCard card) {
        cardNumberField.val(card.getNumber());
        mounthField.val(getMounthCardValid().getMounth());
        yearField.val(getYearCardValid().getYear());
        cvvField.val(getCodeCvvCardValid().getCode());
        furtherButton.click();
        ownerError.shouldHave(Condition.text("Поле обязательно для заполнения"), Duration.ofSeconds(5))
                .shouldBe(visible);
        return new PaymentCard();
    }

    public PaymentCard OwnerCyrillic(DataHelper.NumberCard card) {
        cardNumberField.val(card.getNumber());
        mounthField.val(getMounthCardValid().getMounth());
        yearField.val(getYearCardValid().getYear());
        nameField.val(getOwnerCardCyrillic().getOwner());
        cvvField.val(getCodeCvvCardValid().getCode());
        furtherButton.click();
        yearError.shouldHave(Condition.text("Неверный формат. Используйте только английские буквы"), Duration.ofSeconds(5))
                .shouldBe(visible);
        return new PaymentCard();
    }

    public PaymentCard OwnerNumbers(DataHelper.NumberCard card) {
        cardNumberField.val(card.getNumber());
        mounthField.val(getMounthCardValid().getMounth());
        yearField.val(getYearCardValid().getYear());
        nameField.val(getOwnerCardNumbers().getOwner());
        cvvField.val(getCodeCvvCardValid().getCode());
        furtherButton.click();
        yearError.shouldHave(Condition.text("Неверный формат. Используйте только английские буквы"), Duration.ofSeconds(5))
                .shouldBe(visible);
        return new PaymentCard();
    }

    public PaymentCard OwnerSymbols(DataHelper.NumberCard card) {
        cardNumberField.val(card.getNumber());
        mounthField.val(getMounthCardValid().getMounth());
        yearField.val(getYearCardValid().getYear());
        nameField.val(getOwnerCardSymbols().getOwner());
        cvvField.val(getCodeCvvCardValid().getCode());
        furtherButton.click();
        yearError.shouldHave(Condition.text("Неверный формат. Используйте только английские буквы"), Duration.ofSeconds(5))
                .shouldBe(visible);
        return new PaymentCard();
    }

    public PaymentCard OwnerCyrillicAndSymbols(DataHelper.NumberCard card) {
        cardNumberField.val(card.getNumber());
        mounthField.val(getMounthCardValid().getMounth());
        yearField.val(getYearCardValid().getYear());
        nameField.val(getOwnerCardCyrillicAndSymbols().getOwner());
        cvvField.val(getCodeCvvCardValid().getCode());
        furtherButton.click();
        yearError.shouldHave(Condition.text("Неверный формат. Используйте только английские буквы"), Duration.ofSeconds(5))
                .shouldBe(visible);
        return new PaymentCard();
    }

    public PaymentCard OwnerLatinAndSymbols(DataHelper.NumberCard card) {
        cardNumberField.val(card.getNumber());
        mounthField.val(getMounthCardValid().getMounth());
        yearField.val(getYearCardValid().getYear());
        nameField.val(getOwnerCardLatinAndSymbols().getOwner());
        cvvField.val(getCodeCvvCardValid().getCode());
        furtherButton.click();
        yearError.shouldHave(Condition.text("Неверный формат. Используйте только английские буквы"), Duration.ofSeconds(5))
                .shouldBe(visible);
        return new PaymentCard();
    }


    public PaymentCard OwnerLongString(DataHelper.NumberCard card) {
        cardNumberField.val(card.getNumber());
        mounthField.val(getMounthCardValid().getMounth());
        yearField.val(getYearCardValid().getYear());
        nameField.val(getOwnerCardLongString().getOwner());
        cvvField.val(getCodeCvvCardValid().getCode());
        furtherButton.click();
        yearError.shouldHave(Condition.text("Неверный формат. Имя и фамилия Владельца должны быть разделены пробелом"),
                        Duration.ofSeconds(5))
                .shouldBe(visible);
        return new PaymentCard();
    }

    public PaymentCard EmptyCvv(DataHelper.NumberCard card) {
        cardNumberField.val(card.getNumber());
        mounthField.val(getMounthCardValid().getMounth());
        yearField.val(getYearCardValid().getYear());
        nameField.val(getOwnerCardValid().getOwner());
        furtherButton.click();
        cvvError.shouldHave(Condition.text("Поле обязательно для заполнения"), Duration.ofSeconds(5))
                .shouldBe(visible);
        return new PaymentCard();
    }

    public PaymentCard InvalidSymbolsCvv(DataHelper.NumberCard card) {
        cardNumberField.val(card.getNumber());
        mounthField.val(getMounthCardValid().getMounth());
        yearField.val(getYearCardValid().getYear());
        nameField.val(getOwnerCardValid().getOwner());
        cvvField.val(getCodeCvvCardInvalidSymbols().getCode());
        furtherButton.click();
        cvvError.shouldHave(Condition.text("Неверный формат"), Duration.ofSeconds(5))
                .shouldBe(visible);
        return new PaymentCard();
    }

    public PaymentCard NullCvv(DataHelper.NumberCard card) {
        cardNumberField.val(card.getNumber());
        mounthField.val(getMounthCardValid().getMounth());
        yearField.val(getYearCardValid().getYear());
        nameField.val(getOwnerCardValid().getOwner());
        cvvField.val(getCodeCvvCardNull().getCode());
        furtherButton.click();
        cvvError.shouldHave(Condition.text("Неверный формат"), Duration.ofSeconds(5))
                .shouldBe(visible);
        return new PaymentCard();
    }

    public PaymentCard OperationApproved() {
        operationSuccessfully.shouldHave(Condition.text("Операция одобрена Банком"), Duration.ofSeconds(15))
                .shouldBe(visible);
        return new PaymentCard();
    }

    public PaymentCard OperationRejected() {
        operationDenied.shouldHave(Condition.text("Ошибка! Банк отказал в проведении операции."), Duration.ofSeconds(15))
                .shouldBe(visible);
        return new PaymentCard();
    }

}
