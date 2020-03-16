require 'watir'
require 'webdrivers'
require 'rspec'

#require 'watir-webdriver'
#require 'watir-webdriver-performance'
#require 'simplecov'
#SimpleCov.start

Before do
  @browser = Watir::Browser.new :chrome
  @secret = YAML::load(File.open('secret.yml'))
  #@blog = YAML::load(File.open('blog.yml'))
end

After do
  @browser.close
end
  
at_exit do
  puts 'final clap'
end