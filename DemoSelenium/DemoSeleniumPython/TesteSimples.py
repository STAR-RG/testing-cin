import unittest
from selenium import webdriver

class TesteSimples(unittest.TestCase):

    global driver;

    def setUp(self):
        self.driver = webdriver.Firefox();

    def test_acesso(self):
        self.driver.get("http://seleniumhq.org")

    def tearDown(self):
        self.driver.quit

if __name__ == '__main__':
    unittest.main()
