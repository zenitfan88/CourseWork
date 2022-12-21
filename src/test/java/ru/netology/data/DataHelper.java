package ru.netology.data;

import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import lombok.SneakyThrows;
import lombok.Value;

public class DataHelper {


    private DataHelper() {
    }

    @Value
    public static class CardDetails {
        String numberCard;
        String mounth;
        String year;
        String name;
        String codeCvv;
    }

//    public static CardInfo getCardApprovedInfo() {
//        Faker faker = new Faker();
//        String mounth = String.valueOf(faker.number().numberBetween(1, 12));
//        String year = String.valueOf(faker.number().numberBetween(22, 29));
//        String name = faker.name().fullName();
//        String codeCvv = faker.numerify("3");
//        return new CardInfo("1111222233334444", mounth, year, name, codeCvv);
//    }
//
//    public static CardInfo getCardDeclinedInfo() {
//        Faker faker = new Faker();
//        String mounth = String.valueOf(faker.number().numberBetween(1, 12));
//        String year = String.valueOf(faker.number().numberBetween(22, 29));
//        String name = faker.name().fullName();
//        String codeCvv = faker.numerify("3");
//        return new CardInfo("5555666677778888", mounth, year, name, codeCvv);
//    }

    @SneakyThrows
    public static CardDetails getCardDetails(String card) throws Exception {
        Faker faker = new Faker();
        String mounth = String.valueOf(faker.number().numberBetween(1, 12));
        String year = String.valueOf(faker.number().numberBetween(22, 29));
        String name = faker.name().fullName();
        String codeCvv = faker.numerify("3");
        if (card.equals("approved")) {
            return new CardDetails("1111222233334444", mounth, year, name, codeCvv);
        }
        if (card.equals("declined")) {
            return new CardDetails("5555666677778888", mounth, year, name, codeCvv);
        }
        throw new Exception("Данную карту нельзя использовать в тесте");
    }

    }
