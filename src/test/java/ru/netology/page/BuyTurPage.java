package ru.netology.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class BuyTurPage {

    private SelenideElement paymentButton=$x("//*[text()='Купить']");

    public PaymentCard payment(){
        paymentButton.click();
        return new PaymentCard();
    }
}
