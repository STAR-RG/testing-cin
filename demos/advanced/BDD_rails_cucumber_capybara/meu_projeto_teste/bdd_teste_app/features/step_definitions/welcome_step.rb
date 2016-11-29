When(/^I am in homepage$/) do
 visit(root_path)
end
Given(/^I want to see "([^"]*)"$/) do |arg1|
	page.has_content?(arg1)
end