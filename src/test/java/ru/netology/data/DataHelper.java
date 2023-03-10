package ru.netology.data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DataHelper {

    static Faker faker = new Faker();

    private DataHelper() {
    }

    @Value
    public static class NumberCard {
        String number;
    }


    public static NumberCard getNumberCard(String card) {
        if (card.equals("approved")) {
            return new NumberCard("1111 2222 3333 4444");
        }
        if (card.equals("declined")) {
            return new NumberCard("5555 6666 7777 8888");
        }
        return new NumberCard("1234 5678 9012 3456");
    }

    public static NumberCard getNumberCardNull() {
        return new NumberCard("0000 0000 0000 0000");
    }

    public static NumberCard getInvalidSymbolsNumberCard() {
        return new NumberCard("1234 56");
    }

    public static NumberCard getEmptyNumberCard() {
        return new NumberCard("");
    }

    @Value
    public static class MounthCard {
        String mounth;
    }

    public static MounthCard getMounthCardValid() {
        return new MounthCard(LocalDate.now().format(DateTimeFormatter.ofPattern("MM")));
    }

    public static MounthCard getMounthCardNull() {
        return new MounthCard("00");
    }

    public static MounthCard getMounthCardOverValid() {
        return new MounthCard(String.valueOf(faker.number().numberBetween(13, 99)));
    }

    public static MounthCard getMounthCardInvalidSymbols() {
        return new MounthCard(String.valueOf(faker.number().numberBetween(0, 9)));
    }

    public static MounthCard getEmptyMounthCard() {
        return new MounthCard("");
    }

    @Value
    public static class YearCard {
        String year;
    }

    public static YearCard getYearCardValid() {
        return new YearCard(LocalDate.now().plusYears(5).format(DateTimeFormatter.ofPattern("yy")));
    }

    public static YearCard getYearCardNull() {
        return new YearCard("00");
    }

    public static YearCard getYearCardUnderValid() {
        return new YearCard(LocalDate.now().minusYears(1).format(DateTimeFormatter.ofPattern("yy")));
    }

    public static YearCard getYearCardInvalidSymbols() {
        return new YearCard(String.valueOf(faker.number().numberBetween(0, 9)));
    }

    public static YearCard getEmptyYearCard() {
        return new YearCard("");
    }

    @Value
    public static class OwnerCard {
        String owner;
    }

    public static OwnerCard getOwnerCardValid() {
        return new OwnerCard(faker.name().fullName());
    }

    public static OwnerCard getOwnerCardNumbers() {
        return new OwnerCard(faker.numerify("7"));
    }

    public static OwnerCard getOwnerCardSymbols() {
        return new OwnerCard("!/.*-+.':;//");
    }

    public static OwnerCard getOwnerCardCyrillic() {
        return new OwnerCard("?????????????? ??????????????????");
    }

    public static OwnerCard getOwnerCardCyrillicAndSymbols() {
        return new OwnerCard("??????????????17!");
    }

    public static OwnerCard getOwnerCardLatinAndSymbols() {
        return new OwnerCard("Ivan17!");
    }

    public static OwnerCard getOwnerCardLongString() {
        return new OwnerCard(faker.letterify("???????????????????????????????????????????????????????????"));
    }

    public static OwnerCard getEmptyOwnerCard() {
        return new OwnerCard("");
    }

    @Value
    public static class CvvCard {
        String cvv;
    }

    public static CvvCard getCvvCardValid() {
        return new CvvCard(faker.numerify("###"));
    }

    public static CvvCard getCvvCardNull() {
        return new CvvCard("000");
    }

    public static CvvCard getCvvCardInvalidSymbols() {
        return new CvvCard(faker.numerify("2"));
    }

    public static CvvCard getCvvCardEmpty() {
        return new CvvCard("");
    }

}
