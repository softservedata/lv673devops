# -*- coding: utf-8 -*-
import os
from selenium import webdriver
from selenium.webdriver.common.by import By
#from selenium.webdriver.common.keys import Keys
#from selenium.webdriver.support.ui import Select
from selenium.common.exceptions import NoSuchElementException
from selenium.common.exceptions import NoAlertPresentException
import unittest, time, re

class Tc1(unittest.TestCase):
    
    def test_tc1(self):
        # Test Data
        expected = "Харків"

        # Precondition
        ##driver = webdriver.Firefox()
        ##chromedriver = r"C:\Users\yharasym\.cache\selenium\chromedriver\win32\99.0.4844.51\chromedriver.exe"
        ###print(os.environ['USERPROFILE'])
        chromedriver = os.environ["USERPROFILE"] + r"\.cache\selenium\chromedriver\win32\99.0.4844.51\chromedriver.exe"
        ###os.environ["webdriver.chrome.driver"] = chromedriver
        driver = webdriver.Chrome(chromedriver)
        ###driver = webdriver.Chrome()
        driver.implicitly_wait(5)
        driver.get("https://speak-ukrainian.org.ua/dev/")

        time.sleep(2)
        ###driver.find_element_by_css_selector(".anticon.anticon-caret-down").click()
        driver.find_element(by=By.CSS_SELECTOR, value=".anticon.anticon-caret-down").click()
        time.sleep(2)
        ###city = driver.find_element_by_xpath("//ul[@role='menu']/li[2]/span").text
        city = driver.find_element(by=By.XPATH, value="//ul[@role='menu']/li[2]/span").text
        self.assertEqual(expected, city )

        time.sleep(2)
        driver.close()
  

if __name__ == "__main__":
    unittest.main()
