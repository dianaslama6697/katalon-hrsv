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

import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

// Set up the browser driver
DriverFactory.openWebDriver()

// Navigate to the website under test
WebUI.navigateToUrl('http://103.180.125.59/#/login')

// Perform some actions
WebUI.setText(findTestObject('login/username_object'), 'dianaslama')
WebUI.setText(findTestObject('login/password_object'), 'dianaslama')
WebUI.click(findTestObject('login/button_object'))

//
WebUI.click(findTestObject('tambahlogbook/button_Tambah Logbook'))

// Menemukan elemen input field
def inputFieldmulai = WebUI.waitForElementVisible(findTestObject('tambahlogbook/input_Jam Mulai'), 30)
def inputFieldselesai = WebUI.waitForElementVisible(findTestObject('tambahlogbook/input_Jam Selesai'), 30)
// Menghapus nilai yang ada pada input field
WebUI.executeJavaScript("arguments[0].value = '13:00';", Arrays.asList(inputFieldmulai))
WebUI.executeJavaScript("arguments[0].value = '04:00';", Arrays.asList(inputFieldselesai))
//// Optional: Memastikan field sudah kosong
//assert inputField.value == ''

// Mengatur opsi pada input select berdasarkan nilai
//WebUI.setText(findTestObject('tambahlogbook/input_Tanggal'), '01/07/2023')
WebUI.setText(findTestObject('tambahlogbook/input_Jam Mulai'), '13:00 ')
WebUI.setText(findTestObject('tambahlogbook/input_Jam Selesai'), '03:00')
WebUI.selectOptionByValue(findTestObject('tambahlogbook/input_Mode Kerja'), 'WFO', false)
WebUI.setText(findTestObject('tambahlogbook/input_Project'), 'HRSV Dashboard')
WebUI.setText(findTestObject('tambahlogbook/input_Nama Tim'), 'HRSV Team')
WebUI.setText(findTestObject('tambahlogbook/input_Use Case'), 'Tambah Logbook')
WebUI.selectOptionByValue(findTestObject('tambahlogbook/input_Kegiatan'), 'Searching Materi', false)
WebUI.setText(findTestObject('tambahlogbook/input_Hasil'), '300')
WebUI.setText(findTestObject('tambahlogbook/input_Capaian'), '50')
WebUI.selectOptionByValue(findTestObject('tambahlogbook/input_Next Step'), 'Pause', false)
WebUI.setText(findTestObject('tambahlogbook/input_PathFilename'), 'testfilepath')
WebUI.setText(findTestObject('tambahlogbook/input_Detail Pekerjaan'), 'test case detail pekerjaan')
WebUI.selectOptionByValue(findTestObject('tambahlogbook/input_Waktu Kerja'), 'Jam Normal', false)
WebUI.click(findTestObject('tambahlogbook/button_Submit'))


// Verify the expected results
//WebUI.waitForElementVisible(findTestObject('login/userpass_wrong'), 2)
//WebUI.verifyElementText(findTestObject('login/userpass_wrong'), 'Username and/or Password is invalid')
