require 'watir'
require 'webdrivers'
require 'faker'

# Initalize the Browser
browser = Watir::Browser.new

# Navigate to Page
browser.goto 'a.testaddressbook.com'

# Authenticate and Navigate to the Form
browser.link(id: 'sign-in').click
browser.text_field(data_test: 'email').set 'watir_example@example.com'
browser.text_field(data_test: 'password').set 'password'
browser.button(name: 'commit').click
browser.link(data_test: 'addresses').click
browser.link(data_test: 'create').click

# This uses the Faker gem to give us Random Data.
# Read more about Faker gem here: https://github.com/stympy/faker#readme

browser.text_field(id: 'address_first_name').set Faker::Name.first_name
browser.text_field(id: 'address_last_name').set Faker::Name.last_name
browser.text_field(id: 'address_street_address').set Faker::Address.street_address
browser.text_field(id: 'address_secondary_address').set Faker::Address.secondary_address
browser.text_field(id: 'address_city').set Faker::Address.city

# select list elements can select by either text or value
browser.select_list(id: 'address_state').select Faker::Address.state

browser.text_field(id: 'address_zip_code').set Faker::Address.zip_code

# radio buttons can be selected with `text` or `label` locators
browser.radio(text: 'Canada').set

# Date Field elements accept Date objects
birthday = Faker::Date.birthday
browser.date_field.set birthday

age = Date.today.year - birthday.year
browser.text_field(id: 'address_age').set age

browser.text_field(id: 'address_website').set Faker::Internet.url

# File Field elements upload files with the `#set` method, but require the full system path
file_name = 'watir_example.text'
File.write(file_name, '')
path = File.expand_path(file_name)
browser.file_field(id: 'address_picture').set path

# Checkboxes can be selected by `label` or `text` locators
browser.checkbox(label: 'Dancing').set

browser.textarea(id: 'address_note').set 'See, filling out a form with Watir is easy!'
browser.button(data_test: 'submit').click

browser.close
