Given(/^we visit the "(.*?)"$/) do |website|
  goto_login
end

Given(/^we put this credentials "(.*?)" and password "(.*?)"$/) do |username, password|
  login_page(username, password)  
end

Then(/^we receive a message containing an "(.*?)"$/) do |alert|
  login_click alert
end

Then(/^the login screen appears again$/) do
  login_should_be_complete
end

Given(/^we put the good credentials$/) do
  #login_nice
  skip_this_scenario
end

Then(/^we click and we reach the home page with a welcome "(.*?)"$/) do |message|
  login_click message
end