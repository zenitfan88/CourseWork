package ru.netology.ru.netology.page;

import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelper;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class PaymentCard {

    private SelenideElement cardNumberField = $x("//input[contains(@placeholder,'0000 0000 0000 0000')]");
    private SelenideElement mounthField = $x("//input[contains(@placeholder,'08')]");
    private SelenideElement yearField = $x("//input[contains(@placeholder,'22')]");
    private SelenideElement nameField = $x("//div[3]/span/span[1]/span/span/span[2]/input");
    private SelenideElement cvvField = $x("//input[contains(@placeholder,'999')]");
    private SelenideElement furtherButton=$x("//*[text()='Продолжить']");

    public PaymentCard CardDetails (DataHelper.CardDetails card) {
        cardNumberField.val(card.getNumberCard());
        mounthField.val(card.getMounth());
        yearField.val(card.getYear());
        nameField.val(card.getName());
        cvvField.val(card.getCodeCvv());
        furtherButton.click();
        return new PaymentCard();
    }
}
