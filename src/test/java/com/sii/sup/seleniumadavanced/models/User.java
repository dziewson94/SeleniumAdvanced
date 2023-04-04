package com.sii.sup.seleniumadavanced.models;

import org.junit.platform.commons.util.StringUtils;

public class User {
    private String username;
    private String password;

    private String email;

    private String city;

    private String postalCode;

    private String streetAndNo;

    private String apartment;

    private String phoneNumber;

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", city='" + city + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", streetAndNo='" + streetAndNo + '\'' +
                ", apartment='" + apartment + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    public static final class UserBuilder {
        private String username;
        private String password;
        private String email;
        private String city;
        private String postalCode;
        private String streetAndNo;
        private String apartment;
        private String phoneNumber;

        private UserBuilder() {
        }

        public static UserBuilder anUser() {
            return new UserBuilder();
        }

        public UserBuilder withUsername(String username) {
            this.username = username;
            return this;
        }

        public UserBuilder withPassword(String password) {
            this.password = password;
            return this;
        }

        public UserBuilder withEmail(String email) {
            this.email = email;
            return this;
        }

        public UserBuilder withCity(String city) {
            this.city = city;
            return this;
        }

        public UserBuilder withPostalCode(String postalCode) {
            this.postalCode = postalCode;
            return this;
        }

        public UserBuilder withStreetAndNo(String streetAndNo) {
            this.streetAndNo = streetAndNo;
            return this;
        }

        public UserBuilder withApartment(String apartment) {
            this.apartment = apartment;
            return this;
        }

        public UserBuilder withPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public static User empty() {
            return anUser().withUsername("NULL").withPassword("NULL").withEmail("NULL").withCity("NULL").withPostalCode("NULL").withStreetAndNo("NULL").withApartment("NULL").withPhoneNumber("NULL").buildEmpty();
        }

        private User buildEmpty()  {
            User user = new User();
            user.email = this.email;
            user.password = this.password;
            user.streetAndNo = this.streetAndNo;
            user.apartment = this.apartment;
            user.city = this.city;
            user.postalCode = this.postalCode;
            user.username = this.username;
            user.phoneNumber = this.phoneNumber;

            return user;
        }

        public User build() throws InssuficientUserDataException {
            User user = new User();
            user.email = this.email;
            user.password = this.password;
            user.streetAndNo = this.streetAndNo;
            user.apartment = this.apartment;
            user.city = this.city;
            user.postalCode = this.postalCode;
            user.username = this.username;
            user.phoneNumber = this.phoneNumber;
            if (StringUtils.isBlank(username) || StringUtils.isBlank(email) || StringUtils.isBlank(password) || StringUtils.isBlank(phoneNumber)) {
                throw new InssuficientUserDataException("Invalid data provided for builder.\nUsername, password, email and phone number are mandatory!");
            }
            return user;
        }
    }
}
