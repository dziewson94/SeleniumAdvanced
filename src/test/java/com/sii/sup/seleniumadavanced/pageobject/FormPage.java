package com.sii.sup.seleniumadavanced.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;


@SuppressWarnings("unused")
public class FormPage {
    private static final Logger logger = LoggerFactory.getLogger(FormPage.class.getSimpleName());
    @FindBy(id = "inputFirstName3")
    private WebElement firstNameInput;
    @FindBy(id = "inputLastName3")
    private WebElement lastNameInput;
    @FindBy(id = "inputEmail3")
    private WebElement emailInput;
    @FindBy(id = "gridRadiosMale")
    private WebElement maleRadio;
    @FindBy(id = "gridRadiosFemale")
    private WebElement femaleRadio;
    @FindBy(id = "gridRadiosOther")
    private WebElement otherRadio;
    @FindBy(id = "inputAge3")
    private WebElement ageInput;
    @FindBy(name = "gridCheckboxProfession")
    private List<WebElement> professions;

    @FindBy(id = "gridCheckManulTester")
    private WebElement manualTester;
    @FindBy(id = "gridCheckAutomationTester")
    private WebElement automationTester;
    @FindBy(id = "gridCheckOther")
    private WebElement other;


    @FindBy(id = "selectContinents")
    private WebElement continentSelect;
    @FindBy(name = "gridRadiosExperience")
    private List<WebElement> experience;

    @FindBy(id = "selectSeleniumCommands")
    private WebElement selectSeleniumCommands;

    @FindBy(id = "additionalInformations")
    private WebElement additionalInformation;
    @FindBy(id = "chooseFile")
    private WebElement chooseFile;

    @FindBy(className = "btn-secondary")
    private WebElement fileDownload;

    @FindBy(className = "btn-primary")
    private WebElement submit;
    @FindBy(id = "validator-message")
    private WebElement validatorMessage;

    public FormPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String enterFileToUpload(String filePath) {
        chooseFile.clear();
        chooseFile.sendKeys(filePath);
        return filePath.substring(0,
                filePath.indexOf(File.separator) + 1) + "fakepath" +
                filePath.substring(filePath.lastIndexOf(File.separator));
    }

    public String getActualFirstname() {
        firstNameInput.click();
        return firstNameInput.getAttribute("value");
    }

    public String getActualLastname() {
        return lastNameInput.getAttribute("value");
    }

    public int getActualAge() {
        return Integer.parseInt(ageInput.getAttribute("value"));
    }

    public String getActualFileToUpload() {
        return chooseFile.getAttribute("value");
    }

    public Gender getAcutalGender() {
        if (maleRadio.isSelected()) {
            return Gender.Male;
        } else if (femaleRadio.isSelected()) {
            return Gender.Female;
        } else if (otherRadio.isSelected()) {
            return Gender.Other;
        }
        return Gender.NONE;
    }

    public String getActualExperience() {
        for (WebElement experienceElement : experience) {
            if (experienceElement.isSelected()) {
                return experienceElement.getAccessibleName();
            }
        }
        return "";
    }

    public TesterProfession getActualProfession() {
        String selectedProfessionName = "NONE";
        for (WebElement prof : professions) {
            if (prof.isSelected()) {
                selectedProfessionName = prof.getAccessibleName();
                break;
            }
        }

        for (TesterProfession profession : TesterProfession.values()) {
            if (profession.getProfession().equals(selectedProfessionName)) {
                return profession;
            }
        }
        return TesterProfession.NONE;
    }

    public List<String> getActualSelectedSeleniumCommands() {
        Select select = new Select(selectSeleniumCommands);
        List<String> res = new ArrayList<>();

        for (WebElement element : select.getAllSelectedOptions()) {
            res.add(element.getAccessibleName());
        }
        return res;
    }

    public String getActualAdditionalText() {
        return additionalInformation.getAttribute("value");
    }

    public String getActualContinent() {
        Select continentSelect = new Select(this.continentSelect);
        return continentSelect.getAllSelectedOptions().get(0).getAccessibleName();
    }

    public String getActualEmail() {
        return emailInput.getAttribute("value");

    }

    public void submit() {
        logger.info(submit.getText());
        submit.click();
    }

    public String getSubmitResultText() {
        return validatorMessage.getText();
    }

    public void enterAdditionalInformation(String additionalInformation) {
        this.additionalInformation.sendKeys(additionalInformation);
    }

    public void clickFileDownload() {
        fileDownload.click();
    }

    public String selectRandomContinent() {
        Select continentSelect = new Select(this.continentSelect);
        int index = ThreadLocalRandom.current().nextInt(0, continentSelect.getOptions().size());
        continentSelect.selectByIndex(index);
        return continentSelect.getOptions().get(index).getAccessibleName();
    }

    public String getRandomExperience() {

        WebElement el = experience.get(ThreadLocalRandom.current().nextInt(0, experience.size()));
        String name = el.getAccessibleName();
        el.click();
        return name;
    }


    public void enterFirstName(String firstName) {
        firstNameInput.click();
        firstNameInput.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        lastNameInput.click();
        lastNameInput.sendKeys(lastName);
    }

    public void enterEmail(String email) {
        emailInput.click();
        emailInput.sendKeys(email);
    }

    public void selectGender(Gender gender) {

        if (gender.name().equalsIgnoreCase("male")) {
            maleRadio.click();
        } else if (gender.name().equalsIgnoreCase("female")) {
            femaleRadio.click();
        } else {
            otherRadio.click();
        }
    }

    public void selectProfession(TesterProfession profession) {
        if (profession == TesterProfession.AutomationTester) {
            automationTester.click();
        } else if (profession == TesterProfession.ManualTester) {
            manualTester.click();
        } else if (profession == TesterProfession.Other) {
            other.click();
        }
    }

    public void enterAge(int age) {
        ageInput.click();
        ageInput.sendKeys(String.valueOf(age));
    }

    public TesterProfession selectRandomProfession() {

        professions.forEach(el -> {
            el.click();
            if (el.isSelected()) el.click();
        });
        TesterProfession profession = TesterProfession.values()[ThreadLocalRandom.current().nextInt(0, TesterProfession.values().length - 1)];
        selectProfession(profession);
        return profession;
    }

    public List<String> selectRandomNumberOfRandomSeleniumCommands() {
        Select selectSeleniumCommands = new Select(this.selectSeleniumCommands);
        selectSeleniumCommands.deselectAll();
        int numberOfOptionsToSelect = ThreadLocalRandom.current().nextInt(1, selectSeleniumCommands.getOptions().size());
        int selectedOptions = 0;
        List<String> selectedOptionsOutput = new ArrayList<>();
        List<Integer> indexToSelect = new ArrayList<>();
        while (indexToSelect.size() < numberOfOptionsToSelect) {
            int optionIndex = ThreadLocalRandom.current().nextInt(0, selectSeleniumCommands.getOptions().size());
            if (indexToSelect.stream().anyMatch(el -> el == optionIndex)) continue;
            indexToSelect.add(optionIndex);
        }
        for (int index : indexToSelect) {
            selectedOptionsOutput.add(selectSeleniumCommands.getOptions().get(index).getAccessibleName());
            selectSeleniumCommands.selectByIndex(index);
        }
        return selectedOptionsOutput;

    }


}
