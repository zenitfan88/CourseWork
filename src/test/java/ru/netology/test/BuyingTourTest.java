package ru.netology.test;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import ru.netology.data.DBHelper;
import ru.netology.data.DataHelper;
import ru.netology.page.BuyTurPage;

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
        var number = DataHelper.getNumberCard("approved");
        var mounth = DataHelper.getMounthCardValid();
        var year = DataHelper.getYearCardValid();
        var owner = DataHelper.getOwnerCardValid();
        var cvv = DataHelper.getCvvCardValid();
        var buyTurPage = new BuyTurPage();
        var paymentCartPage = buyTurPage.payment();
        paymentCartPage.paymentOperation(number, mounth, year, owner, cvv);
        paymentCartPage.operationApproved();
        Assertions.assertEquals("APPROVED", getStatusOperationActual());
    }

    @Test
    void testPaymentOperationDenied() {
        var number = DataHelper.getNumberCard("declined");
        var mounth = DataHelper.getMounthCardValid();
        var year = DataHelper.getYearCardValid();
        var owner = DataHelper.getOwnerCardValid();
        var cvv = DataHelper.getCvvCardValid();
        var buyTurPage = new BuyTurPage();
        var paymentCartPage = buyTurPage.payment();
        paymentCartPage.paymentOperation(number, mounth, year, owner, cvv);
        paymentCartPage.operationRejected();
        Assertions.assertEquals("DECLINED", getStatusOperationActual());
    }


    @Test
    void testEmptyNumberCard() {
        var number=DataHelper.getEmptyNumberCard();
        var mounth = DataHelper.getMounthCardValid();
        var year = DataHelper.getYearCardValid();
        var owner = DataHelper.getOwnerCardValid();
        var cvv = DataHelper.getCvvCardValid();
        var buyTurPage = new BuyTurPage();
        var paymentCartPage = buyTurPage.payment();
        paymentCartPage.paymentOperation(number, mounth, year, owner, cvv);
        paymentCartPage.fieldRequiredError();
    }

    @Test
    void testNullNumberCard() {
        var number=DataHelper.getNumberCardNull();
        var mounth = DataHelper.getMounthCardValid();
        var year = DataHelper.getYearCardValid();
        var owner = DataHelper.getOwnerCardValid();
        var cvv = DataHelper.getCvvCardValid();
        var buyTurPage = new BuyTurPage();
        var paymentCartPage = buyTurPage.payment();
        paymentCartPage.paymentOperation(number, mounth, year, owner, cvv);
        paymentCartPage.incorrectNumberCardError();
    }

    @Test
    void testInvalidSymbolsNumberCard() {
        var number=DataHelper.getInvalidSymbolsNumberCard();
        var mounth = DataHelper.getMounthCardValid();
        var year = DataHelper.getYearCardValid();
        var owner = DataHelper.getOwnerCardValid();
        var cvv = DataHelper.getCvvCardValid();
        var buyTurPage = new BuyTurPage();
        var paymentCartPage = buyTurPage.payment();
        paymentCartPage.paymentOperation(number, mounth, year, owner, cvv);
        paymentCartPage.invalidFormatError();
    }

    @Test
    void testPaymentOperationUnknowCard() {
        var number=DataHelper.getNumberCard("other");
        var mounth = DataHelper.getMounthCardValid();
        var year = DataHelper.getYearCardValid();
        var owner = DataHelper.getOwnerCardValid();
        var cvv = DataHelper.getCvvCardValid();
        var buyTurPage = new BuyTurPage();
        var paymentCartPage = buyTurPage.payment();
        paymentCartPage.paymentOperation(number, mounth, year, owner, cvv);
        paymentCartPage.operationRejected();
        Assertions.assertEquals(null, getStatusOperationActual());
    }

    @Test
    void testEmptyMounthCard() {
        var number = DataHelper.getNumberCard("approved");
        var mounth = DataHelper.getEmptyMounthCard();
        var year = DataHelper.getYearCardValid();
        var owner = DataHelper.getOwnerCardValid();
        var cvv = DataHelper.getCvvCardValid();
        var buyTurPage = new BuyTurPage();
        var paymentCartPage = buyTurPage.payment();
        paymentCartPage.paymentOperation(number, mounth, year, owner, cvv);
        paymentCartPage.fieldRequiredError();
    }

    @Test
    void testNullMounthCard() {
        var number = DataHelper.getNumberCard("approved");
        var mounth = DataHelper.getMounthCardNull();
        var year = DataHelper.getYearCardValid();
        var owner = DataHelper.getOwnerCardValid();
        var cvv = DataHelper.getCvvCardValid();
        var buyTurPage = new BuyTurPage();
        var paymentCartPage = buyTurPage.payment();
        paymentCartPage.paymentOperation(number, mounth, year, owner, cvv);
        paymentCartPage.invalidFormatError();
    }

    @Test
    void testMounthOverValid() {
        var number = DataHelper.getNumberCard("approved");
        var mounth = DataHelper.getMounthCardOverValid();
        var year = DataHelper.getYearCardValid();
        var owner = DataHelper.getOwnerCardValid();
        var cvv = DataHelper.getCvvCardValid();
        var buyTurPage = new BuyTurPage();
        var paymentCartPage = buyTurPage.payment();
        paymentCartPage.paymentOperation(number, mounth, year, owner, cvv);
        paymentCartPage.invalidFormatError();
    }

    @Test
    void testInvalidSymbolsMounth() {
        var number = DataHelper.getNumberCard("approved");
        var mounth = DataHelper.getMounthCardInvalidSymbols();
        var year = DataHelper.getYearCardValid();
        var owner = DataHelper.getOwnerCardValid();
        var cvv = DataHelper.getCvvCardValid();
        var buyTurPage = new BuyTurPage();
        var paymentCartPage = buyTurPage.payment();
        paymentCartPage.paymentOperation(number, mounth, year, owner, cvv);
        paymentCartPage.invalidFormatError();
    }

    @Test
    void testEmptyYearCard() {
        var number = DataHelper.getNumberCard("approved");
        var mounth = DataHelper.getMounthCardValid();
        var year = DataHelper.getEmptyYearCard();
        var owner = DataHelper.getOwnerCardValid();
        var cvv = DataHelper.getCvvCardValid();
        var buyTurPage = new BuyTurPage();
        var paymentCartPage = buyTurPage.payment();
        paymentCartPage.paymentOperation(number, mounth, year, owner, cvv);
        paymentCartPage.fieldRequiredError();
    }

    @Test
    void testInvalidYearCard() {
        var number = DataHelper.getNumberCard("approved");
        var mounth = DataHelper.getMounthCardValid();
        var year = DataHelper.getYearCardUnderValid();
        var owner = DataHelper.getOwnerCardValid();
        var cvv = DataHelper.getCvvCardValid();
        var buyTurPage = new BuyTurPage();
        var paymentCartPage = buyTurPage.payment();
        paymentCartPage.paymentOperation(number, mounth, year, owner, cvv);
        paymentCartPage.invalidYearError();
    }

    @Test
    void testNullYearCard() {
        var number = DataHelper.getNumberCard("approved");
        var mounth = DataHelper.getMounthCardValid();
        var year = DataHelper.getYearCardNull();
        var owner = DataHelper.getOwnerCardValid();
        var cvv = DataHelper.getCvvCardValid();
        var buyTurPage = new BuyTurPage();
        var paymentCartPage = buyTurPage.payment();
        paymentCartPage.paymentOperation(number, mounth, year, owner, cvv);
        paymentCartPage.invalidFormatError();
    }

    @Test
    void testInvalidSymbolsYearCard() {
        var number = DataHelper.getNumberCard("approved");
        var mounth = DataHelper.getMounthCardValid();
        var year = DataHelper.getYearCardInvalidSymbols();
        var owner = DataHelper.getOwnerCardValid();
        var cvv = DataHelper.getCvvCardValid();
        var buyTurPage = new BuyTurPage();
        var paymentCartPage = buyTurPage.payment();
        paymentCartPage.paymentOperation(number, mounth, year, owner, cvv);
        paymentCartPage.invalidFormatError();
    }

    @Test
    void testEmptyOwnerCard() {
        var number = DataHelper.getNumberCard("approved");
        var mounth = DataHelper.getMounthCardValid();
        var year = DataHelper.getYearCardValid();
        var owner = DataHelper.getEmptyOwnerCard();
        var cvv = DataHelper.getCvvCardValid();
        var buyTurPage = new BuyTurPage();
        var paymentCartPage = buyTurPage.payment();
        paymentCartPage.paymentOperation(number, mounth, year, owner, cvv);
        paymentCartPage.fieldRequiredError();
    }

    @Test
    void testOwnerCyrillicCard() {
        var number = DataHelper.getNumberCard("approved");
        var mounth = DataHelper.getMounthCardValid();
        var year = DataHelper.getYearCardValid();
        var owner = DataHelper.getOwnerCardCyrillic();
        var cvv = DataHelper.getCvvCardValid();
        var buyTurPage = new BuyTurPage();
        var paymentCartPage = buyTurPage.payment();
        paymentCartPage.paymentOperation(number, mounth, year, owner, cvv);
        paymentCartPage.invalidFormatOwnerError();
    }

    @Test
    void testNumbersOwnerCard() {
        var number = DataHelper.getNumberCard("approved");
        var mounth = DataHelper.getMounthCardValid();
        var year = DataHelper.getYearCardValid();
        var owner = DataHelper.getOwnerCardNumbers();
        var cvv = DataHelper.getCvvCardValid();
        var buyTurPage = new BuyTurPage();
        var paymentCartPage = buyTurPage.payment();
        paymentCartPage.paymentOperation(number, mounth, year, owner, cvv);
        paymentCartPage.invalidFormatOwnerError();
    }

    @Test
    void testOwnerSymbolsCard() {
        var number = DataHelper.getNumberCard("approved");
        var mounth = DataHelper.getMounthCardValid();
        var year = DataHelper.getYearCardValid();
        var owner = DataHelper.getOwnerCardSymbols();
        var cvv = DataHelper.getCvvCardValid();
        var buyTurPage = new BuyTurPage();
        var paymentCartPage = buyTurPage.payment();
        paymentCartPage.paymentOperation(number, mounth, year, owner, cvv);
        paymentCartPage.invalidFormatOwnerError();
    }

    @Test
    void testOwnerCyrillicAndSymbolsCard() {
        var number = DataHelper.getNumberCard("approved");
        var mounth = DataHelper.getMounthCardValid();
        var year = DataHelper.getYearCardValid();
        var owner = DataHelper.getOwnerCardCyrillicAndSymbols();
        var cvv = DataHelper.getCvvCardValid();
        var buyTurPage = new BuyTurPage();
        var paymentCartPage = buyTurPage.payment();
        paymentCartPage.paymentOperation(number, mounth, year, owner, cvv);
        paymentCartPage.invalidFormatOwnerError();
    }

    @Test
    void testOwnerLatinAndSymbolsCard() {
        var number = DataHelper.getNumberCard("approved");
        var mounth = DataHelper.getMounthCardValid();
        var year = DataHelper.getYearCardValid();
        var owner = DataHelper.getOwnerCardLatinAndSymbols();
        var cvv = DataHelper.getCvvCardValid();
        var buyTurPage = new BuyTurPage();
        var paymentCartPage = buyTurPage.payment();
        paymentCartPage.paymentOperation(number, mounth, year, owner, cvv);
        paymentCartPage.invalidFormatOwnerError();
    }

    @Test
    void testOwnerLongString() {
        var number = DataHelper.getNumberCard("approved");
        var mounth = DataHelper.getMounthCardValid();
        var year = DataHelper.getYearCardValid();
        var owner = DataHelper.getOwnerCardLongString();
        var cvv = DataHelper.getCvvCardValid();
        var buyTurPage = new BuyTurPage();
        var paymentCartPage = buyTurPage.payment();
        paymentCartPage.paymentOperation(number, mounth, year, owner, cvv);
        paymentCartPage.ownerLongStringError();
    }

    @Test
    void testEmptyCvvCard() {
        var number = DataHelper.getNumberCard("approved");
        var mounth = DataHelper.getMounthCardValid();
        var year = DataHelper.getYearCardValid();
        var owner = DataHelper.getOwnerCardValid();
        var cvv = DataHelper.getCvvCardEmpty();
        var buyTurPage = new BuyTurPage();
        var paymentCartPage = buyTurPage.payment();
        paymentCartPage.paymentOperation(number, mounth, year, owner, cvv);
        paymentCartPage.fieldRequiredError();
    }

    @Test
    void testInvalidSymbolsCvvCard() {
        var number = DataHelper.getNumberCard("approved");
        var mounth = DataHelper.getMounthCardValid();
        var year = DataHelper.getYearCardValid();
        var owner = DataHelper.getOwnerCardValid();
        var cvv = DataHelper.getCvvCardInvalidSymbols();
        var buyTurPage = new BuyTurPage();
        var paymentCartPage = buyTurPage.payment();
        paymentCartPage.paymentOperation(number, mounth, year, owner, cvv);
        paymentCartPage.invalidFormatError();
    }

    @Test
    void testNullCvvCard() {
        var number = DataHelper.getNumberCard("approved");
        var mounth = DataHelper.getMounthCardValid();
        var year = DataHelper.getYearCardValid();
        var owner = DataHelper.getOwnerCardValid();
        var cvv = DataHelper.getCvvCardNull();
        var buyTurPage = new BuyTurPage();
        var paymentCartPage = buyTurPage.payment();
        paymentCartPage.paymentOperation(number, mounth, year, owner, cvv);
        paymentCartPage.invalidFormatError();
    }
}
