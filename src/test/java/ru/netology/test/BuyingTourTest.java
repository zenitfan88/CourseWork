package ru.netology.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.ru.netology.page.BuyTurPage;

import static com.codeborne.selenide.Selenide.open;

public class BuyingTourTest {

    @BeforeEach
    void setUpp() {
        open("http://localhost:8080");
    }

    @Test
    void testVerificationCode() throws Exception {
        var card = DataHelper.getCardDetails("approved");
        var buyTurPage = new BuyTurPage();
        var paymentCartPage = buyTurPage.payment();
        var werwer = paymentCartPage.CardDetails(card);

    }
}
