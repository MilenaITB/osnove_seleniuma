package p06_02_2023;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BootsnippTableTest extends BaseTest {


    @Test(priority = 1)
    public void editRowTest() {
        driver.get(baseUrl + "/iframe/K5yrx");
        tablePage.getEditButtonByRow(1).click();
        editDialogPage.waitForDialogToBeVisible();
        editDialogPage.getFirstNameInput().clear();
        editDialogPage.getFirstNameInput().sendKeys("Milan");
        editDialogPage.getLastNameInput().clear();
        editDialogPage.getLastNameInput().sendKeys("Jovanovic");
        editDialogPage.getMiddleNameInput().clear();
        editDialogPage.getMiddleNameInput().sendKeys("Nebojsa");
        editDialogPage.getUpdateButton().click();
        editDialogPage.waitForDialogToBeInvisible();
        Assert.assertEquals(tablePage.getTableBodyColumn(1, 2).getText(),
                "Milan",
                "First name is not updated.");

        Assert.assertEquals(tablePage.getTableBodyColumn(1, 3).getText(),
                "Jovanovic",
                "Last name is not updated.");

        Assert.assertEquals(tablePage.getTableBodyColumn(1, 4).getText(),
                "Nebojsa",
                "Middle name is not updated.");

    }

    @Test(priority = 2)
    public void deleteRowTest() {
        driver.get(baseUrl + "/iframe/K5yrx");
        tablePage.getDeleteButtonByRow(1).click();
        deleteDialogPage.waitForDialogToBeVisible();
        deleteDialogPage.getDeleteButton().click();
        deleteDialogPage.waitForDialogToBeInvisible();
        tablePage.waitForRowToBeDelete(1);

    }


}