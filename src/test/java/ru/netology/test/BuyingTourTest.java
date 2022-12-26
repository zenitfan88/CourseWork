package ru.netology.test;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import ru.netology.data.DBHelper;
import ru.netology.data.DataHelper;
import ru.netology.ru.netology.page.BuyTurPage;

import static com.codeborne.selenide.Selenide.open;
import static ru.netology.data.DBHelper.*;


public class BuyingTourTest {

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    void setUpp() {
        open("http://localhost:8080");
    }

    @AfterEach
    void deleteDataBase() {
        DBHelper.deleteDataBase();
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    @Test
    void testPaymentOperationSuccessfully() {
        var card = DataHelper.getNumberCard("approved");
        var buyTurPage = new BuyTurPage();
        var paymentCartPage = buyTurPage.payment();
        var buyingTour = paymentCartPage.PaymentOperation(card);
        paymentCartPage.OperationApproved();
        Assertions.assertEquals("APPROVED", getStatusOperationActual());
    }

    @Test
    void testPaymentOperationDenied() {
        var card = DataHelper.getNumberCard("declined");
        var buyTurPage = new BuyTurPage();
        var paymentCartPage = buyTurPage.payment();
        var buyingTour = paymentCartPage.PaymentOperation(card);
        paymentCartPage.OperationRejected();
        Assertions.assertEquals("DECLINED", getStatusOperationActual());
    }

    @Test
    void testEmptyNumberCard() {
        var buyTurPage = new BuyTurPage();
        var paymentCartPage = buyTurPage.payment();
        var buyingTour = paymentCartPage.EmptyNumberCard();
    }

    @Test
    void testNullNumberCard() {
        var buyTurPage = new BuyTurPage();
        var paymentCartPage = buyTurPage.payment();
        var buyingTour = paymentCartPage.NullNumberCard();
    }

    @Test
    void testInvalidSymbolsNumberCard() {
        var buyTurPage = new BuyTurPage();
        var paymentCartPage = buyTurPage.payment();
        var buyingTour = paymentCartPage.InvalidSymbolsNumberCard();
    }

    @Test
    void testPaymentOperationUnknowCard() {
        var card = DataHelper.getNumberCard("other");
        var buyTurPage = new BuyTurPage();
        var paymentCartPage = buyTurPage.payment();
        var buyingTour = paymentCartPage.PaymentOperation(card);
        paymentCartPage.OperationRejected();
        Assertions.assertEquals(null, getStatusOperationActual());
    }

    @Test
    void testEmptyMounthCard() {
        var card = DataHelper.getNumberCard("approved");
        var buyTurPage = new BuyTurPage();
        var paymentCartPage = buyTurPage.payment();
        var buyingTour = paymentCartPage.EmptyMounth(card);
    }

    @Test
    void testNullMounthCard() {
        var card = DataHelper.getNumberCard("approved");
        var buyTurPage = new BuyTurPage();
        var paymentCartPage = buyTurPage.payment();
        var buyingTour = paymentCartPage.NullMounth(card);
    }

    @Test
    void testMounthOverValid() {
        var card = DataHelper.getNumberCard("approved");
        var buyTurPage = new BuyTurPage();
        var paymentCartPage = buyTurPage.payment();
        var buyingTour = paymentCartPage.MounthOverValid(card);
    }

    @Test
    void testInvalidSymbolsMounth() {
        var card = DataHelper.getNumberCard("approved");
        var buyTurPage = new BuyTurPage();
        var paymentCartPage = buyTurPage.payment();
        var buyingTour = paymentCartPage.InvalidSymbolsMounth(card);
    }

    @Test
    void testEmptyYearCard() {
        var card = DataHelper.getNumberCard("approved");
        var buyTurPage = new BuyTurPage();
        var paymentCartPage = buyTurPage.payment();
        var buyingTour = paymentCartPage.EmptyYear(card);
    }

    @Test
    void testInvalidYearCard() {
        var card = DataHelper.getNumberCard("approved");
        var buyTurPage = new BuyTurPage();
        var paymentCartPage = buyTurPage.payment();
        var buyingTour = paymentCartPage.InvalidYear(card);
    }

    @Test
    void testNullYearCard() {
        var card = DataHelper.getNumberCard("approved");
        var buyTurPage = new BuyTurPage();
        var paymentCartPage = buyTurPage.payment();
        var buyingTour = paymentCartPage.NullYear(card);
    }

    @Test
    void testInvalidSymbolsYearCard() {
        var card = DataHelper.getNumberCard("approved");
        var buyTurPage = new BuyTurPage();
        var paymentCartPage = buyTurPage.payment();
        var buyingTour = paymentCartPage.InvalidSymbolsYear(card);
    }

    @Test
    void testEmptyOwnerCard() {
        var card = DataHelper.getNumberCard("approved");
        var buyTurPage = new BuyTurPage();
        var paymentCartPage = buyTurPage.payment();
        var buyingTour = paymentCartPage.EmptyOwner(card);
    }

    @Test
    void testOwnerCyrillicCard() {
        var card = DataHelper.getNumberCard("approved");
        var buyTurPage = new BuyTurPage();
        var paymentCartPage = buyTurPage.payment();
        var buyingTour = paymentCartPage.OwnerCyrillic(card);
    }

    @Test
    void testNumbersOwnerCard() {
        var card = DataHelper.getNumberCard("approved");
        var buyTurPage = new BuyTurPage();
        var paymentCartPage = buyTurPage.payment();
        var buyingTour = paymentCartPage.OwnerNumbers(card);
    }

    @Test
    void testOwnerSymbolsCard() {
        var card = DataHelper.getNumberCard("approved");
        var buyTurPage = new BuyTurPage();
        var paymentCartPage = buyTurPage.payment();
        var buyingTour = paymentCartPage.OwnerSymbols(card);
    }

    @Test
    void testOwnerCyrillicAndSymbolsCard() {
        var card = DataHelper.getNumberCard("approved");
        var buyTurPage = new BuyTurPage();
        var paymentCartPage = buyTurPage.payment();
        var buyingTour = paymentCartPage.OwnerCyrillicAndSymbols(card);
    }

    @Test
    void testOwnerLatinAndSymbolsCard() {
        var card = DataHelper.getNumberCard("approved");
        var buyTurPage = new BuyTurPage();
        var paymentCartPage = buyTurPage.payment();
        var buyingTour = paymentCartPage.OwnerLatinAndSymbols(card);
    }

    @Test
    void testOwnerLongString() {
        var card = DataHelper.getNumberCard("approved");
        var buyTurPage = new BuyTurPage();
        var paymentCartPage = buyTurPage.payment();
        var buyingTour = paymentCartPage.OwnerLongString(card);
    }

    @Test
    void testEmptyCvvCard() {
        var card = DataHelper.getNumberCard("approved");
        var buyTurPage = new BuyTurPage();
        var paymentCartPage = buyTurPage.payment();
        var buyingTour = paymentCartPage.EmptyCvv(card);
    }

    @Test
    void testInvalidSymbolsCvvCard() {
        var card = DataHelper.getNumberCard("approved");
        var buyTurPage = new BuyTurPage();
        var paymentCartPage = buyTurPage.payment();
        var buyingTour = paymentCartPage.InvalidSymbolsCvv(card);
    }

    @Test
    void testNullCvvCard() {
        var card = DataHelper.getNumberCard("approved");
        var buyTurPage = new BuyTurPage();
        var paymentCartPage = buyTurPage.payment();
        var buyingTour = paymentCartPage.NullCvv(card);
    }
}
