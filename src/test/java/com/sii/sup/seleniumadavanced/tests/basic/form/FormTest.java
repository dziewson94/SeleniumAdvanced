package com.sii.sup.seleniumadavanced.tests.basic.form;

import com.sii.sup.seleniumadavanced.tests.base.TestBase;
import com.sii.sup.seleniumadavanced.utils.Helper;
import com.sii.sup.seleniumadavanced.pageobject.FormPage;
import com.sii.sup.seleniumadavanced.pageobject.Gender;
import com.sii.sup.seleniumadavanced.pageobject.HomePage;
import com.sii.sup.seleniumadavanced.pageobject.TesterProfession;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.Duration;
import java.util.List;
import java.util.Objects;


public class FormTest extends TestBase {
    private static final String TEST_FILE_TO_DOWNLOAD_XLSX = "test-file-to-download.xlsx";
    private static final Logger logger = LoggerFactory.getLogger(FormTest.class.getSimpleName());

    private static String createTempFileInFormResources() {
        Path filePath = Paths.get("");
        String content = Helper.getRandomString(200000
        );

        try {
            URL formResourcesUrl = FormTest.class.getClassLoader().getResource("tests/FormTest/");
            filePath = Paths.get(Objects.requireNonNull(formResourcesUrl).toURI()).resolve("temp.txt");
            Files.write(filePath, content.getBytes(), StandardOpenOption.CREATE);
        } catch (URISyntaxException | IOException e) {
            logger.warn("Unable to create test file, Skipping that verification due to test environment issue" + e);
        }
        return filePath.toString();
    }

    private static String getDownloadDirPath() {
        return Paths.get("target").toAbsolutePath().toString();
    }

    private static void deleteTestFile() {
        File file = new File(getDownloadDirPath() + File.separator + TEST_FILE_TO_DOWNLOAD_XLSX);
        if (file.exists()) {
            logger.info("Is test file removed:" + file.delete());
        }
    }

    public static boolean testFileExist() {
        return new File(getDownloadDirPath() + File.separator + TEST_FILE_TO_DOWNLOAD_XLSX).exists();

    }

    @AfterEach
    public void clearEnv() {
        FormTest.deleteTestFile();
    }

    @ParameterizedTest
    @MethodSource("com.sii.sup.seleniumadavanced.tests.data.DataSource#formTestDataSource")
    void formTest(String firstName, String lastName, int age, String email, Gender gender, String additionalInformation, boolean submitSuccess) {
        System.out.println(Helper.factoryHelper().getUserFactory().getRandomUser());

        HomePage homePage = new HomePage(webDriver);
        homePage.enterFormPage();
        FormPage formPage = new FormPage(homePage.getWebDriver());
        formPage.enterFirstName(firstName);
        formPage.enterLastName(lastName);
        formPage.enterEmail(email);
        formPage.selectGender(gender);
        formPage.enterAge(age);
        String expectedExperience = formPage.getRandomExperience();
        TesterProfession expectedProfession = formPage.selectRandomProfession();
        String expectedContinent = formPage.selectRandomContinent();
        List<String> expectedSeleniumCommands = formPage.selectRandomNumberOfRandomSeleniumCommands();
        String expectedFilePath = formPage.enterFileToUpload(createTempFileInFormResources());
        formPage.enterAdditionalInformation(additionalInformation);
        int noOfFilesInDownloadDirBeforeClick = Objects.requireNonNull(new File(getDownloadDirPath()).listFiles()).length;
        if (FormTest.testFileExist()) {
            FormTest.deleteTestFile();
        }
        formPage.clickFileDownload();
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(15));
        webDriverWait.until(webDriver -> FormTest.testFileExist());
        int noOfFilesInDownloadDirAfterClick = Objects.requireNonNull(new File(getDownloadDirPath()).listFiles()).length;

        String expectedResult = !submitSuccess ? "Form not send, please fill all missing form fields" : "Form send with success";
        FormTestResultContainer resultContainer = new FormTestResultContainer(firstName, lastName,
                age, expectedResult,
                email, gender,
                expectedExperience, expectedProfession,
                noOfFilesInDownloadDirAfterClick, expectedContinent,
                expectedSeleniumCommands, noOfFilesInDownloadDirBeforeClick, expectedFilePath, additionalInformation);
        logger.info(resultContainer.toString());

        new FormTestVerificator(formPage, resultContainer).verifyAll();


    }

}
