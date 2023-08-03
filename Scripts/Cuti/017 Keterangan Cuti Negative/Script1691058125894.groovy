import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebDriver
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Action

// Set up the browser driver
//DriverFactory.openWebDriver()
//
//// Navigate to the website under test
//WebUI.navigateToUrl('http://103.180.125.59/#/login')
//
//// Perform some actions
//WebUI.setText(findTestObject('login/username_object'), 'dianaslama')
//WebUI.setText(findTestObject('login/password_object'), 'dianaslama')
//WebUI.click(findTestObject('login/button_object'))

// Handle click to ajukan cuti
WebUI.click(findTestObject('PengajuanCuti/select_Cuti dan Lembur'))
WebUI.click(findTestObject('PengajuanCuti/option_Pengajuan Cuti'))
WebUI.click(findTestObject('PengajuanCuti/button_Ajukan Cuti'))

// Wait for the canvas element to be visible
WebUI.waitForElementVisible(findTestObject('PengajuanCuti/canvas_Tanda Tangan Digital'), 20)

// Get the WebDriver instance
WebDriver driver = DriverFactory.getWebDriver()

// Create an Actions object
Actions builder = new Actions(driver)

// Find the canvas element
WebElement ele = WebUI.findWebElement(findTestObject('PengajuanCuti/canvas_Tanda Tangan Digital'))

// Perform drawing action on the canvas
Action drawAction = builder.moveToElement(ele, 20, 0)
						 .clickAndHold()
						 .moveByOffset(20, 20)
						 .moveByOffset(20, 20)
						 .moveByOffset(20, 20)
						 .release()
						 .build()

// Perform the drawing action
drawAction.perform()

// Mengatur opsi pada input select berdasarkan nilai
WebUI.click(findTestObject('PengajuanCuti/input_Tanggal Cuti'))
WebUI.click(findTestObject('PengajuanCuti/value_Tanggal Cuti'))
WebUI.selectOptionByValue(findTestObject('PengajuanCuti/select_Jenis Cuti'), 'Cuti Tahunan', false)
WebUI.selectOptionByValue(findTestObject('PengajuanCuti/select_Nama PIC'), '20797c32-f666-4721-9247-6325808bdf36', false)
//WebUI.setText(findTestObject('PengajuanCuti/textarea_Keterangan Cuti'), '13:00 ')
WebUI.click(findTestObject('PengajuanCuti/button_Submit'))

WebUI.verifyElementText(findTestObject('PengajuanCuti/verify_error_required'), 'Keterangan Cuti tidak boleh kosong!')

// Close the browser
//DriverFactory.closeWebDriver()

