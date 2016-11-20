When(/^I follow "([^"]*)"$/) do |arg1|
  click_link(arg1)
  visit(contact_path)
end

Then(/^I should see contact informations$/) do
  assert_current_path(contact_path)
  have_content("Contato")
end