package com.sii.sup.seleniumadavanced.tests.basic.form;

import com.sii.sup.seleniumadavanced.pageobject.Gender;
import com.sii.sup.seleniumadavanced.pageobject.TesterProfession;

import java.util.List;

public class FormTestResultContainer {
    String firstName;
    String lastName;
    int age;
    String submitResult;
    String email;
    Gender gender;
    String experience;
    TesterProfession profession;
    int noOfFilesInDownloadDirAfterClick;
    String continent;
    final String filePath;
    List<String> seleniumCommands;

    final String additionalInformation;

    int noOfFilesInDownloadDirBeforeClick;

    public FormTestResultContainer(String firstName, String lastName,
                                   int age, String submitResult,
                                   String email, Gender gender,
                                   String experience, TesterProfession profession,
                                   int noOfFilesInDownloadDirAfterClick, String continent,
                                   List<String> seleniumCommands, int noOfFilesInDownloadDirBeforeClick,
                                   String expectedFilePath, String additionalInformation) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.submitResult = submitResult;
        this.email = email;
        this.additionalInformation = additionalInformation;
        this.gender = gender;
        this.filePath = expectedFilePath;
        this.experience = experience;
        this.profession = profession;
        this.noOfFilesInDownloadDirAfterClick = noOfFilesInDownloadDirAfterClick;
        this.continent = continent;
        this.seleniumCommands = seleniumCommands;
        this.noOfFilesInDownloadDirBeforeClick = noOfFilesInDownloadDirBeforeClick;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String toString() {
        String sb = "Expected test results:" + "\n\t" +
                "firstName='" + firstName + '\'' + "\n\t" +
                ", lastName='" + lastName + '\'' + "\n\t" +
                ", age=" + age + "\n\t" +
                ", submitResult='" + submitResult + '\'' + "\n\t" +
                ", email='" + email + '\'' + "\n\t" +
                ", gender=" + gender + "\n\t" +
                ", experience='" + experience + '\'' + "\n\t" +
                ", profession=" + profession + "\n\t" +
                ", continent='" + continent + '\'' + "\n\t" +
                ", seleniumCommands=" + seleniumCommands + "\n\t";
        return sb;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSubmitResult() {
        return submitResult;
    }

    public void setSubmitResult(String submitResult) {
        this.submitResult = submitResult;
    }

    public int getNoOfFilesInDownloadDirAfterClick() {
        return noOfFilesInDownloadDirAfterClick;
    }

    public void setNoOfFilesInDownloadDirAfterClick(int noOfFilesInDownloadDirAfterClick) {
        this.noOfFilesInDownloadDirAfterClick = noOfFilesInDownloadDirAfterClick;
    }

    public int getNoOfFilesInDownloadDirBeforeClick() {
        return noOfFilesInDownloadDirBeforeClick;
    }

    public void setNoOfFilesInDownloadDirBeforeClick(int noOfFilesInDownloadDirBeforeClick) {
        this.noOfFilesInDownloadDirBeforeClick = noOfFilesInDownloadDirBeforeClick;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public TesterProfession getProfession() {
        return profession;
    }

    public void setProfession(TesterProfession profession) {
        this.profession = profession;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public List<String> getSeleniumCommands() {
        return seleniumCommands;
    }

    public void setSeleniumCommands(List<String> seleniumCommands) {
        this.seleniumCommands = seleniumCommands;
    }

}
