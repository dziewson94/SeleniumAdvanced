package com.sii.sup.seleniumadavanced.utils;


import java.util.ArrayList;
import java.util.List;

class UsersDb {
    private List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
    static class User {
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

        private String username;
        private String password;
        private String email;
        private String city;
        private String postalCode;
        private String streetAndNo;
        private String apartment;
        private String phoneNumber;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getPostalCode() {
            return postalCode;
        }

        public void setPostalCode(String postalCode) {
            this.postalCode = postalCode;
        }

        public String getStreetAndNo() {
            return streetAndNo;
        }

        public void setStreetAndNo(String streetAndNo) {
            this.streetAndNo = streetAndNo;
        }

        public String getApartment() {
            return apartment;
        }

        public void setApartment(String apartment) {
            this.apartment = apartment;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }
    }
}
