package com.sii.sup.seleniumadavanced.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import com.sii.sup.seleniumadavanced.models.InssuficientUserDataException;
import com.sii.sup.seleniumadavanced.models.User;

import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public class UserFactory {
    private UsersDb users;

    UserFactory() {
        loadUsersDb();
    }

    public User getAlreadRegistredUser(String userName) {
        for (UsersDb.User dbUser : users.getUsers()) {
            if (dbUser.getUsername().equalsIgnoreCase(userName))
                try {
                    return User.UserBuilder.anUser().
                            withUsername(dbUser.getUsername()).
                            withApartment(dbUser.getApartment()).
                            withCity(dbUser.getCity()).
                            withEmail(dbUser.getEmail()).
                            withPassword(dbUser.getPassword())
                            .withPhoneNumber(dbUser.getPhoneNumber()).
                            withPostalCode(dbUser.getPostalCode()).
                            withStreetAndNo(dbUser.getStreetAndNo()).build();
                } catch (InssuficientUserDataException e) {
                    throw new RuntimeException(e);
                }
        }
        return User.UserBuilder.empty();
    }

    public User getRandomUser() {
        FakeValuesService fakeValuesService = new FakeValuesService(
                new Locale("en-US"), new RandomService());
        try {
            Faker faker = new Faker();


            return User.UserBuilder.anUser()
                    .withUsername(faker.name().username())
                    .withPassword(faker.internet().password())
                    .withEmail(faker.internet().emailAddress())
                    .withCity(faker.address().city())
                    .withPostalCode(faker.address().zipCode())
                    .withStreetAndNo(faker.address().streetAddress())
                    .withApartment(fakeValuesService.regexify("[A-Z]{1}[0-9]{1}-[0-9]{3}"))
                    .withPhoneNumber(faker.phoneNumber().cellPhone())
                    .build();
        } catch (InssuficientUserDataException e) {
            throw new RuntimeException(e);
        }

    }

    public User getRandomAlreadRegistredUser() {
        int index = ThreadLocalRandom.current().nextInt(0, users.getUsers().size());
        UsersDb.User dbUser = users.getUsers().get(index);
        try {
            return User.UserBuilder.anUser().
                    withUsername(dbUser.getUsername()).
                    withApartment(dbUser.getApartment()).
                    withCity(dbUser.getCity()).
                    withEmail(dbUser.getEmail()).
                    withPassword(dbUser.getPassword())
                    .withPhoneNumber(dbUser.getPhoneNumber()).
                    withPostalCode(dbUser.getPostalCode()).
                    withStreetAndNo(dbUser.getStreetAndNo()).build();
        } catch (InssuficientUserDataException e) {
            throw new RuntimeException(e);
        }


    }

    private void loadUsersDb() {
        File file = new File(Objects.requireNonNull(UserFactory.class.getClassLoader().getResource("models/users.yaml")).getFile());
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());

        try {
            users = objectMapper.readValue(file, UsersDb.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
