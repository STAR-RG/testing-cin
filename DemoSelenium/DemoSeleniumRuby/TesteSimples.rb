require "rubygems"
require "selenium-webdriver"
require "minitest/autorun"

class TesteSimples < MiniTest::Test

    # create selenium objects
    def setup
        @driver = Selenium::WebDriver.for :firefox
    end

    def test_post
        @driver.get "http://globo.com"
    end

    def teardown
        @wait = Selenium::WebDriver::Wait.new :timeout => 5
        @driver.quit  
    end

end
