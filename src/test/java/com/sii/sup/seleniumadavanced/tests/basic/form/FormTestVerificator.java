package com.sii.sup.seleniumadavanced.tests.basic.form;

import com.sii.sup.seleniumadavanced.tests.base.TestVerificator;
import com.sii.sup.seleniumadavanced.pageobject.FormPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;


public class FormTestVerificator implements TestVerificator {
    private static final Logger logger = LoggerFactory.getLogger(FormTest.class.getSimpleName());
    private final FormPage formPage;
    private final FormTestResultContainer resultContainer;

    public FormTestVerificator(FormPage formPage, FormTestResultContainer resultContainer) {
        this.formPage = formPage;
        this.resultContainer = resultContainer;
    }

    public FormTestVerificator verifyFirstname() {
        logger.info("Verifying first name");
        assertThat(formPage.getActualFirstname()).isEqualTo(resultContainer.firstName);
        logger.info("Success");
        return this;
    }

    public FormTestVerificator verifyLastname() {
        logger.info("Verifying last name");
        assertThat(formPage.getActualLastname()).isEqualTo(resultContainer.lastName);
        logger.info("Success");
        return this;
    }

    public FormTestVerificator verifyEmail() {
        logger.info("Verifying email");
        assertThat(formPage.getActualEmail()).isEqualTo(resultContainer.email);
        logger.info("Success");
        return this;
    }

    public FormTestVerificator verifyGender() {
        logger.info("Verifying gender");
        assertThat(formPage.getAcutalGender()).isEqualTo(resultContainer.gender);
        logger.info("Success");
        return this;
    }

    public FormTestVerificator verifyAge() {
        logger.info("Verifying age");
        assertThat(formPage.getActualAge()).isEqualTo(resultContainer.getAge());
        logger.info("Success");
        return this;
    }

    public FormTestVerificator verifyExperience() {
        logger.info("Verifying experience");
        assertThat(formPage.getActualAge()).isEqualTo(resultContainer.getAge());
        logger.info("Success");
        return this;
    }

    public FormTestVerificator verifyProfession() {
        logger.info("Verifying profession");
        assertThat(formPage.getActualProfession()).isEqualTo(resultContainer.profession);
        logger.info("Success");
        return this;
    }

    public FormTestVerificator verifyContinent() {
        logger.info("Verifying continent");
        assertThat(formPage.getActualContinent()).isEqualTo(resultContainer.continent);
        logger.info("Success");
        return this;
    }

    public FormTestVerificator verifySeleniumCommands() {
        logger.info("Verifying selenium commands");
        assertThat(formPage.getActualSelectedSeleniumCommands().stream().sorted().collect(Collectors.toList())).isEqualTo(resultContainer.seleniumCommands.stream().sorted().collect(Collectors.toList()));
        logger.info("Success");
        return this;
    }

    public FormTestVerificator verifyFileUpload() {
        logger.info("Verifying file upload");
        assertThat(formPage.getActualFileToUpload()).isEqualTo(resultContainer.filePath);
        logger.info("Success");
        return this;
    }

    public FormTestVerificator verifyAdditionalText() {
        logger.info("Verifying additional text");
        assertThat(formPage.getActualAdditionalText()).isEqualTo(resultContainer.additionalInformation);
        logger.info("Success");
        return this;
    }

    public FormTestVerificator verifyFileDownload() {
        logger.info("Verifying file download");
        assertThat(resultContainer.noOfFilesInDownloadDirAfterClick).isGreaterThan(resultContainer.noOfFilesInDownloadDirBeforeClick);
        assertThat(FormTest.testFileExist()).isTrue();
        logger.info("Success");
        return this;
    }

    public void verifySubmit() {
        formPage.submit();
        logger.info("Verifying form submit");
        assertThat(formPage.getSubmitResultText()).isEqualTo(resultContainer.submitResult);
        logger.info("Success");
    }

    public void verifyAll() {
        logger.info("Verifying all tested fields");
        this.verifyFirstname().
                verifyLastname().
                verifyEmail().
                verifyGender().
                verifyAge().
                verifyExperience().
                verifyProfession().
                verifyContinent().
                verifySeleniumCommands().
                verifyFileUpload().
                verifyAdditionalText().
                verifyFileDownload().
                verifySubmit();
        logger.info("Success");

    }


}
