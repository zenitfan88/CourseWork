package ru.netology.data;

import com.github.javafaker.Faker;
import lombok.SneakyThrows;
import lombok.Value;

public class DataHelper {

    static Faker faker = new Faker();

    private DataHelper() {
    }

    @Value
    public static class NumberCard {
        String number;
    }

    @SneakyThrows
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

    @Value
    public static class MounthCard {
        String mounth;
    }

    public static MounthCard getMounthCardValid() {
        return new MounthCard("08");
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

    @Value
    public static class YearCard {
        String year;
    }

    public static YearCard getYearCardValid() {
        return new YearCard(String.valueOf(faker.number().numberBetween(23, 27)));
    }

    public static YearCard getYearCardNull() {
        return new YearCard("00");
    }

    public static YearCard getYearCardUnderValid() {
        return new YearCard(String.valueOf(faker.number().numberBetween(10, 21)));
    }

    public static YearCard getYearCardInvalidSymbols() {
        return new YearCard(String.valueOf(faker.number().numberBetween(0, 9)));
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
        return new OwnerCard("Алексей Новосёлов");
    }

    public static OwnerCard getOwnerCardCyrillicAndSymbols() {
        return new OwnerCard("Алексей17!");
    }

    public static OwnerCard getOwnerCardLatinAndSymbols() {
        return new OwnerCard("Ivan17!");
    }

    public static OwnerCard getOwnerCardLongString() {
        return new OwnerCard(faker.letterify("???????????????????????????????????????????????????????????"));
    }

    @Value
    public static class CodeCvvCard {
        String code;
    }

    public static CodeCvvCard getCodeCvvCardValid() {
        return new CodeCvvCard(faker.numerify("###"));
    }

    public static CodeCvvCard getCodeCvvCardNull() {
        return new CodeCvvCard("000");
    }

    public static CodeCvvCard getCodeCvvCardInvalidSymbols() {
        return new CodeCvvCard(faker.numerify("2"));
    }

}
