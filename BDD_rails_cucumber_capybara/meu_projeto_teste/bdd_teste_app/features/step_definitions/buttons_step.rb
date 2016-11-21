Then(/^I want to see link "([^"]*)"$/) do |arg1|
  assert find_link(arg1).visible?
end