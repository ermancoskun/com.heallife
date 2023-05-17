package stepdefinitions;


import com.beust.ah.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.AdminPage;
import pages.PatientPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.HealMethods;
import utilities.ReusableMethods;

import javax.swing.*;

import java.util.Date;
import java.util.Random;

import static utilities.Driver.driver;
import static utilities.Driver.getDriver;

public class PatientStepdefinitions {
    PatientPage patientPage=new PatientPage();
    AdminPage adminPage=new AdminPage();
    Actions actions=new Actions(Driver.getDriver());
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();


    @Given("Goes to user login page")
    public void goesToUserLoginPage() {
        // intentionally left blank
    }

    @Then("Login with {string} and  {string} datas")
    public void loginWithAndDatas(String username,String password) {
        HealMethods.loginAsUser(username, password);
    }


    @When("Homepage redirect verified")
    public void homepageRedirectVerified() {

    patientPage.DashboardOnHeallifeText.click();
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("/patient/dashboard"));
    }

    @When("User clicks the flag")
    public void userClicksTheFlag() {
        patientPage.homeFlag.click();
        patientPage.homeFlagTurkish.click();
     //   ReusableMethods.waitForClickablility(patientPage.homeFlagTurkish,2);
        ReusableMethods.sleep(3);
        String expected=patientPage.myAppiontmentsButton.getText();
        System.out.println(expected);
        //tıklıyor ama kodlarda randevularım ingilizce gözüküyor
    //   Assert.assertTrue(expected.equalsIgnoreCase("Randevularım"));

    }

   @And("user should be able to on the IPD page")
    public void userShouldBeAbleToOnTheIPDPage() {
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("admin/patient/ipdsearch"));
    }





    @When("Click on the notifications button")
    public void clickOnTheNotificationsButton() {
        patientPage.notifications.click();


    }

    @When("User see the notifications")
    public void userSeeTheNotifications() {
        Assert.assertTrue(patientPage.notificationsboard.isDisplayed());
    }





    @When("User not see any notifications")
    public void userNotSeeAnyNotifications() {
        Assert.assertTrue(patientPage.notificationsInformation.getText().contains("No Record Found"));
    }



    @When("User  see  Heal Life Hospital & Research Center text.")
    public void userSeeHealLifeHospitalResearchCenterText() {

   Assert.assertTrue(patientPage.DashboardOnHeallifeText.getText().contains("Heal"));

    }

    @When("Click on  Delete All button")
    public void clickOnDeleteAllButton() {
        ReusableMethods.sleep(2);
        ReusableMethods.waitForClickablility(patientPage.notificationsDeletebutton,2);
        patientPage.notificationsDeletebutton.click();
    }

    @Then("User  ben on the Dashboard profile page")
    public void userBenOnTheDashboardProfilePage() {
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("/patient/dashboard"));
    }

    @When("Clik on the dashboard button")
    public void clikOnTheDashboardButton() {
    patientPage.dashboardButton.click();
    }

    @When("Click on the My Appointments button")
    public void clickOnTheMyAppointmentsButton() {
        patientPage.myAppiontmentsButton.click();
    }

    @Then("User  be on the My Appointment profile page")
    public void userBeOnTheMyAppointmentProfilePage() {
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("appointment"));

    }

    @When("Click on the OPD menu title on the Sidebar")
    public void clickOnTheOPDMenuTitleOnTheSidebar() {
        patientPage.opdButton.click();
    }

    @Then("User  be on the OPD profile page")
    public void userBeOnTheOPDProfilePage() {
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("profile"));
    }

    @When("Click on the IPD button")
    public void clickOnTheIPDButton() {
        patientPage.ipdButton.click();
    }

    @Then("User  be on the IPD profile page")
    public void userBeOnTheIPDProfilePage() {
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("patientipddetails"));
    }

    @When("Click on the Pharmacy button")
    public void clickOnThePharmacyButton() {
        patientPage.pharmacyButton.click();
    }

    @Then("User  be on the Pharmacy profile page")
    public void userBeOnThePharmacyProfilePage() {
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("pharmacybill"));

    }

    @When("Click on the Pathology button")
    public void clickOnThePathologyButton() {
        patientPage.pathologyButton.click();
    }

    @Then("User  be on the Pathology profile page")
    public void userBeOnThePathologyProfilePage() {
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("/pathology"));

    }


    @When("Click on the Radiology button")
    public void clickOnTheRadiologyButton() {
        patientPage.radiologyButton.click();
        
    }

    @Then("User  be on the Radiology profile page")
    public void userBeOnTheRadiologyProfilePage() {
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("radiology"));

    }


    @When("Click on the Ambulance button")
    public void clickOnTheAmbulanceButton() {
        
        patientPage.ambulanceButton.click();
    }

    @Then("User  be on the  Ambulance profile page")
    public void userBeOnTheAmbulanceProfilePage() {
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("dashboard/ambulance"));
    }


    @When("Click on the BloodBank button")
    public void clickOnTheBloodBankButton() {
        patientPage.bloodBankButton.click();

    }

    @Then("User  be on the BloodBank  profile page")
    public void userBeOnTheBloodBankProfilePage() {
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("dashboard/bloodbank"));

    }

    @When("Click on the three lines one below the other button")
    public void clickOnTheThreeLinesOneBelowTheOtherButton() {
        patientPage.homeThreeDots.click();
    }

    @Then("User   see Dashboard navbar close")
    public void userSeeDashboardNavbarClose() {

        patientPage.homeThreeDots.click();

    }

    @When("User  see Patient Id, Gender, Marital Status, Phone, Email, Address, Age, Guardian Name informations")
    public void userSeePatientIdGenderMaritalStatusPhoneEmailAddressAgeGuardianNameInformations() {
        PatientPage.checkHeaderExistence(patientPage.myInformations);


    }

    @When("User  be Appointment No, Appointment Date, Priority, Specialist, Doctor, Status, Message, Action title")
    public void userBeAppointmentNoAppointmentDatePrioritySpecialistDoctorStatusMessageActionTitle() {
        WebElement table = driver.findElement(By.id("DataTables_Table_0"));
        PatientPage.checkTableHeadersExist(table);
    }

    @When("Click on the Delete button  User  be Delete menu")
    public void clickOnTheDeleteButtonUserBeDeleteMenu() {
        ReusableMethods.bekle(2);
        patientPage.myAppointmentdeleteButton.click();

        driver.switchTo().alert().accept();

    }

    @When("Clik on the Show button  User sees Appointment Details")
    public void clikOnTheShowButtonUserSeesAppointmentDetails() {
        patientPage.myAppointmentsShowButton.click();
        patientPage.myAppointmentsShowcloseButton.click();

    }

    @When("User enters card information and completes payment")
    public void userEntersCardInformationAndCompletesPayment() {
        patientPage.payCard();
Assert.assertEquals(patientPage.SuccestText.getText(),"SUCCESS");
    }

    @When("Click on the three lines button and User  see Dashboard navbar close")
    public void clickOnTheThreeLinesButtonAndUserSeeDashboardNavbarClose() {
        patientPage.homeThreeDots.click();
        patientPage.homeThreeDots.click();
        patientPage.homeThreeDots.isDisplayed();
    }

    @When("Click on the Profile picture User  see the user name, title and profile picture should be displayed in the tab that opens.")
    public void clickOnTheProfilePictureUserSeeTheUserNameTitleAndProfilePictureShouldBeDisplayedInTheTabThatOpens() {
        patientPage.profileImage.click();
        ReusableMethods.bekle(1);
        patientPage.profileNametext.isDisplayed();

    }


    @When("Click on Delete button and User not see the notifications")
    public void clickOnDeleteButtonAndUserNotSeeTheNotifications() {
        ReusableMethods.bekle(2);
        patientPage.notificationsDeletebutton.click();
        driver.switchTo().alert().accept();
        patientPage.notificationsInformation.isDisplayed();
    }

    @When("User creates a record by entering the appointment information.")
    public void userCreatesARecordByEnteringTheAppointmentInformation() {

        patientPage.myAppointmentsAddAppointment();
    }

    @When("User calls in appointments")
    public void userCallsInAppointments() {

        patientPage.myAppoinmetSeachtext.sendKeys("APPNO435");
        Assert.assertEquals(patientPage.myAppointmentApointmentno.getText(),"APPNO435");
    }

    @When("User skip to next page")
    public void userSkipToNextPage() {
        js.executeScript("arguments[0].scrollIntoView(true)",     patientPage.myAppoinmentsSecondPageButton);
        ReusableMethods.bekle(1);
        patientPage.myAppoinmentsSecondPageButton.click();
        System.out.println(patientPage.myAppointmentspageDetails.getText());
        patientPage.myAppointmentspageDetails.isDisplayed();

    }


    @When("User switches to previous page")
    public void userSwitchesToPreviousPage() {

        js.executeScript("arguments[0].scrollIntoView(true)",patientPage.myAppoinmentsFirstPageButton);
        ReusableMethods.bekle(1);
        patientPage.myAppoinmentsFirstPageButton.click();
        System.out.println(patientPage.myAppointmentspageDetails.getText());
        patientPage.myAppointmentspageDetails.isDisplayed();

    }

    @When("Click on the  Change Password button and enters informations")
    public void clickOnTheChangePasswordButtonAndEntersInformations() {
        patientPage.profileChangepassButton.click();
        patientPage.profileChangecurrentPassword.click();
        actions.sendKeys("heallife123");
        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys("heallife123");
        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys("heallife123");
        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys(Keys.ENTER).perform();
        ReusableMethods.sleep(6);
    }

    @Then("Click on the Logout button")
    public void clickOnTheLogoutButton() {
        patientPage.profileImage.click();
        patientPage.profileLogoutbutton.click();
       Assert.assertEquals( Driver.getDriver().getCurrentUrl(),"https://qa.heallifehospital.com/site/userlogin");
    }



    @Given("Navigate to {string}")
    public void navigate_to(String string) {
    }

    @Given("Login to user page as {string} {string}")
    public void login_to_user_page_as(String username, String password) {
        Driver.getDriver().get("https://qa.heallifehospital.com/site/userlogin");
        WebElement usernameLocate = Driver.getDriver().findElement(By.id("email"));
        usernameLocate.sendKeys(username);

        WebElement passwordLocate = Driver.getDriver().findElement(By.id("password"));
        passwordLocate.sendKeys(password);
        WebElement loginButton = Driver.getDriver().findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();

    }

    @Given("Click on the {string} linkk")
    public void click_on_the_linkk(String string) {
        patientPage.pharmacySideBox.click();

    }

    @Given("Verified redirected to pharmacybill page")
    public void verified_redirected_to_pharmacybill_page() {
        patientPage.pharmacyBillText.isDisplayed();

    }

    @And("Verify that {string} in the Pharmacy Bill List are displayed")
    public void verifyThatInThePharmacyBillListAreDisplayed(String data) {
        PatientPage.baslikListelemeMethod(data);
    }

    @Then("Click the {string}")
    public void clickThe(String arg0) {
        patientPage.searchBox.click();

    }

    @Then("Enter the excisting {string}")
    public void enterTheExcisting(String arg0) {
        patientPage.searchBox.sendKeys("PHARMAB43");
    }

    @And("It is verified that filtering is done by entering the bill number in the Search Box.")
    public void ıtIsVerifiedThatFilteringIsDoneByEnteringTheBillNumberInTheSearchBox() {
        Assert.assertTrue(patientPage.pharmacyText.isDisplayed());
    }

    @Then("It is verified that the headings are sorted by clicking on them.")
    public void ıtIsVerifiedThatTheHeadingsAreSortedByClickingOnThem() {
        Assert.assertTrue(PatientPage.intListSortTest(1));
    }

    @Then("Click the View payments.")
    public void clickTheViewPayments() {
        patientPage.wievAllBox.click();

    }
    @Then("The visibility of the amount text is verified")
    public void theVisibilityOfTheAmountTextIsVerified() {
        Assert.assertTrue(patientPage.dateText.isDisplayed());
    }
    @Then("close the screen")
    public void closeTheScreen() {
        patientPage.pharmacyCloseButton.click();

    }

    @Then("Click the show button.")
    public void clickTheShowButton() {
        patientPage.pharmacyShowButton.click();

    }


    @Then("Name text \\(ayse.busra.pehlıvan) should visible")
    public void nameTextAyseBusraPehlıvanShouldVisible() {
        ReusableMethods.bekle(2);
        Assert.assertTrue(patientPage.pharmacyNameText.isDisplayed());

    }

    @Then("Click the pay button.")
    public void clickThePayButton() {
        patientPage.pharmacyPayButton.click();
    }




    //}

    @Then("the amount paid is entered.")
    public void theAmountPaidIsEntered() {
        patientPage.pharmacyPaymenAmount.click();
        patientPage.pharmacyPaymenAmount.clear();
        patientPage.pharmacyPaymenAmount.sendKeys("30");
        patientPage.pharmacyAddButton.click();
    }
    @And("Click the add button.")
    public void clickTheAddButton() {
        patientPage.pharmacyAddButton.click();
    }


    @And("Click the pay with card.")
    public void clickThePayWithCard() {
        patientPage.pharmacyPayWithCard.click();
        ReusableMethods.bekle(6);



    }

    @Given("e-mail, card number, date and cvc code are entered")
    public void eMailCardNumberDateAndCvcCodeAreEntered() {
        // patientPage.pharmacyEmailBox.click();
        // WebElement element=Driver.getDriver().findElement(By.xpath(("//input[@class='control'])[1])")));
        //JSUtilities.clickWithJS(Driver.getDriver(),element);
        Actions actions = new Actions(Driver.getDriver());
        ReusableMethods.bekle(3);

        actions.sendKeys("asd@gmail.com").build().perform();
        //actions.sendKeys(faker.internet().emailAddress()).perform();
        actions.sendKeys(Keys.TAB).perform();
        ReusableMethods.bekle(2);
        actions.sendKeys("4242 4242").build().perform();
        ReusableMethods.bekle(2);
        actions.sendKeys("4242 4242").build().perform();
        ReusableMethods.bekle(3);
        ReusableMethods.bekle(3);
        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys("04").perform();
        ReusableMethods.bekle(3);
        actions.sendKeys("28").perform();
        ReusableMethods.bekle(2);
        actions.sendKeys(Keys.TAB).build().perform();
        ReusableMethods.bekle(2);
        actions.sendKeys("123").build().perform();
        actions.sendKeys(Keys.TAB).perform();
        ReusableMethods.bekle(2);
        actions.sendKeys("456").build().perform();
        ReusableMethods.bekle(2);
        actions.sendKeys(Keys.TAB).build().perform();
        ReusableMethods.bekle(2);
        actions.sendKeys(Keys.ENTER).perform();

        // patientPage.pharmacyPayBox.click();
        ReusableMethods.bekle(2);

    }

    @Then("The visibility of the success text is verified")
    public void theVisibilityOfTheSuccessTextIsVerified() {

        Assert.assertTrue(patientPage.pharmacySuccesfulText.isDisplayed());
    }

    @Then("wait {int} seconds")
    public void waitSeconds(int arg0) {
        ReusableMethods.bekle(3);
    }

    @Then("close the screenn")
    public void closeTheScreenn() {
        patientPage.pharmacyClose.click();
    }


    //=========================================== Nesibe [US_023] OPD MENU =============================================

    @Given("Launch browser.")
    public void launchBrowser() {
        Driver.getDriver();}

/*    @Then("Go to {string}")
    public void goTo(String url) {
        Driver.getDriver().get(ConfigReader.getProperty(url));}*/

    @Then("Login as a patient with username password")
    public void loginPatient(String userName, String Password) {
        HealMethods.loginAsUser("userNameNesibe", "userPasswordNesibe");

    }
    @Then("Verify  the patient dashboard page is redirected")
    public void patientPageRedirected() {
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("patient"));

    }

    @Then("Verify the “OPD” menu title in the dashboard is visible and clickable")
    public void verifyOpdMenuTitleEnabled() {
        String expectedTitle = "OPD";
        String actualTitle= Driver.getDriver().findElement(By.xpath("//*[@id=sibe-box]/ul/li[3]/a")).getText();
        Assert.assertTrue( actualTitle.contains(expectedTitle));

    }

    @Then("Click the “OPD” menu")
    public void clickOpdMenu() {
        HealMethods.clickASidebarLink("OPD");
    }

    @Then("Verify the {string} page is redirected")
    public void verifyPatientPage(String arg0) {
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("patient"));
    }

   /* @And("Close the page")
    public void closePage() {
        Driver.closeDriver();
    }*/


    @Then("Verify the “ Overview, Visits, Lab Investigation, Treatment History, Timeline” items visible and accesable.")
    public void headingsOpdPage() {
        Assert.assertTrue(patientPage.overview.isDisplayed());
        Assert.assertTrue(patientPage.visits.isDisplayed());
        Assert.assertTrue(patientPage.labInvestigation.isDisplayed());
        Assert.assertTrue(patientPage.treatmentHistory.isDisplayed());
        Assert.assertTrue(patientPage.timeline.isDisplayed());
    }

    @Then("Verify the “ Gender, Age, Guardian Name, Phone” items displayed correctly in the Overview page")
    public void theItemsOverview() {
        Assert.assertTrue(patientPage.gender.isDisplayed());
        Assert.assertTrue(patientPage.age.isDisplayed());
        Assert.assertTrue(patientPage.guardianName.isDisplayed());
        Assert.assertTrue(patientPage.phone.isDisplayed());
    }

    @Then("Verify the summaries of Visits, Lab Investigation, Treatment History, Timeline displayed correctly in the Overview page")
    public void summariesOfOtherPages() {
        Assert.assertTrue(patientPage.sumVisitDetails.isDisplayed());
        Assert.assertTrue(patientPage.sumlabInvestigation.isDisplayed());
        Assert.assertTrue(patientPage.sumTreatmentHistory.isDisplayed());
        Assert.assertTrue(patientPage.sumTimeline.isDisplayed());

    }

    @Then("Verify the “ Consultant doctor” item displayed correctly in the Overview page.")
    public void consultantDoctorItemDisplayed() {
        patientPage.consultantDoctor.isDisplayed();
    }

    @Then("Click the “Visits” menu")
    public void clickTheVisitsMenu() {
        patientPage.visits.click();
    }

    @Then("Verify the headings in Visits List, OPD No, Case ID, Appointment Date, Consultant, Reference displayed correctly")
    public void headingsInVisitsPage() {
        Assert.assertTrue(patientPage.opdNo.isDisplayed());
        Assert.assertTrue(patientPage.caseId.isDisplayed());
        Assert.assertTrue(patientPage.appointmentDate.isDisplayed());
        Assert.assertTrue(patientPage.consultant.isDisplayed());
        Assert.assertTrue(patientPage.referance.isDisplayed());
    }

    @Then("Verify the seacrhTextBox  in Visit page is displayed and to be able to search correctly")
    public void theSeacrhTextBox() {
        HealMethods.makeSearchBoxTest();
    }

    @Then("Verify the list titles in the Visits List are to be able to sort effectively")
    public void ListTitlesSorting() {

    }

    @Then("Verify the accessiblity to the details of the visit and the prescription information under the Actions heading in the Visits")
    public void prescriptionVisits () {
    }

    @Then("Verify the visit details and prescription information must be recorded on the correct patient name.")
    public void visitsRecordedCorrectPatient() {
    }

    //========================================= Nesibe [US_023] OPD MENU SONU ==========================================


/////////////////////////////////////////
    @Then("Login button is clicked")
    public void login_button_is_clicked() {
        patientPage.entryLoginbutton.click();
    }
    @Then("Required information is entered and login {string} {string}")
    public void required_information_is_entered_and_login(String username , String password) {
        patientPage.loginAspatient(username,password);



    }
    @Then("Click on the IPD tab")
    public void click_on_the_ipd_tab() {

        patientPage.ipdButton.click();

    }
    @Then("IPD page displayed")
    public void ipd_page_displayed() {
      Assert.assertTrue(patientPage.IPDName.isDisplayed());

    }

    @Then("Click on the medication tab and the Prescription tab")
    public void click_on_the_medication_tab_and_the_prescription_tab() {

        patientPage.MeditacionTab.click();
        ReusableMethods.bekle(5);
        patientPage.PrescriptionTab.click();

    }
    @Then("Click on Consulant Register tab and Lab Investigations tab.")
    public void click_on_consulant_register_tab_and_lab_investigations_tab() {

        patientPage.ConsultantRegister.click();
        ReusableMethods.bekle(5);
        patientPage.labInvestigation.click();
    }


    @Then("Click on Operation tab and Charge tab")
    public void click_on_operation_tab_and_charge_tab() {

        patientPage.OperationTab.click();
        ReusableMethods.bekle(5);
        patientPage.ChargesTab.click();

    }

    @Then("Click on the Timeline tab and the Treatment History tab")
    public void click_on_the_timeline_tab_and_the_treatment_history_tab() {

        patientPage.RightArrowKey.click();
        patientPage.Timeline.click();
        ReusableMethods.bekle(5);
        patientPage.treatmentHistory.click();


    }
    @Then("Click on Bed History tab")
    public void click_on_bed_history_tab() {


        patientPage.RightArrowKey.click();
      Assert.assertTrue(patientPage.BedHistory.isEnabled());
      patientPage.BedHistory.click();

    }


    @Then("Click on the Profile button and display the requested information.")
    public void click_on_the_profile_button_and_display_the_requested_information() {
        patientPage.ProfileButton.click();
        ReusableMethods.bekle(5);
        Assert.assertTrue(patientPage.PatientDetailsTitle.isDisplayed());

    }

    @Then("Click on the Overview")
    public void click_on_the_overview() {

        patientPage.OverviewTab.click();

        ReusableMethods.bekle(3);

        Assert.assertTrue(patientPage.summarypartText.isDisplayed());



    }


    @Then("Click on the Medication tab and display the Date , Medication Name , Dose1 title")
    public void click_on_the_medication_tab() {
       patientPage.TitleAssertion("Medication");
    }


    @Then("Click on the Prescription tab and Prescription No , Date , Finding , Action titles should be displayed")
    public void  Click_on_the_Prescription_tab_and_Prescription_No_Date_Finding_Action_titles_should_be_displayed() {
        patientPage.TitleAssertion("Prescription");


    }

    @Then("Click on the Prescription tab")
    public void click_on_the_prescription_tab() {

        patientPage.PrescriptionTab.click();

    }
    @Then("Click on SearchTextBox and write the necessary information.")
    public void click_on_search_text_box_and_write_the_necessary_information() {

        patientPage.PrescriptionSearchBox.click();
        patientPage.PrescriptionSearchBox.sendKeys("IPDP105");
        ReusableMethods.bekle(3);
        Assert.assertTrue(patientPage.searchresulttext.isDisplayed());

    }

    @Then("Sorting should be done by clicking Prescription No ,Date , Finding headings")
    public void sorting_should_be_done_by_clicking_prescription_no_date_finding_headings() {

        patientPage.PrescriptionNo.click();
        ReusableMethods.bekle(2);
        patientPage.PrescriptionDate.click();
        ReusableMethods.bekle(2);
        patientPage.PrescriptionFinding.click();


    }


    @Then("It should be possible to click on the Prescription detail under the Action title in the Prescription list.")
    public void it_should_be_possible_to_click_on_the_prescription_detail_under_the_action_title_in_the_prescription_list() {
        patientPage.PrescriptionActionsButton.click();
        ReusableMethods.bekle(5);
        Assert.assertTrue(patientPage.ActionsPrescriptionNo.isDisplayed());

    }


    @Then("The Consultant Registration tab should be clicked and the titles in the Consultant Registration List should be displayed on the Consultant Registration page.")
    public void the_consultant_registration_tab_should_be_clicked_and_the_titles_in_the_consultant_registration_list_should_be_displayed_on_the_consultant_registration_page() {

        patientPage.TitleAssertion("Consultant Register");

    }


    @Then("Click on the Consultant Register tab")
    public void click_on_the_consultant_register_tab() {

        patientPage.ConsultantRegister.click();
    }
    @Then("In order to search the Consultant Register list, there must be a searhTextBox and a correct search must be made.")
    public void in_order_to_search_the_consultant_register_list_there_must_be_a_searh_text_box_and_a_correct_search_must_be_made() {

        patientPage.ConsultantRegisterSearchBox.sendKeys("10.05.2023 03:09 PM");
        ReusableMethods.bekle(3);
        Assert.assertTrue(patientPage.ConsultantRegisterSearcResult.isDisplayed());
    }



    @Then("The Lab Investigation page should be clicked and the Lab Investigation page should have a title in the Lab Investigation List.")
    public void the_lab_investigation_page_should_be_clicked_and_the_lab_investigation_page_should_have_a_title_in_the_lab_investigation_list() {
        patientPage.TitleAssertion( "Lab Investigation");

    }



    @Then("Click on Lab Investigation page")
    public void click_on_lab_investigation_page() {
       patientPage.labInvestigation.click();
    }
    @Then("To be able to search the Lab Investigation list, there must be a searhTextBox and it must search correctly.")
    public void to_be_able_to_search_the_lab_investigation_list_there_must_be_a_searh_text_box_and_it_must_search_correctly() {

        patientPage.searchLabInvestigation.click();
        patientPage.searchLabInvestigation.sendKeys("asdada");
        ReusableMethods.bekle(3);
    }











}






