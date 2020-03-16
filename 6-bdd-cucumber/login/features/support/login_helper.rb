module LoginHelper
  def login_page(username, password)
    @browser.text_field(:id => 'session_email').set username
    @browser.text_field(:id => 'session_password').set password
    # check contents
    @browser.text_field(:id => 'session_email').value.should eq username  
    @browser.text_field(:id => 'session_password').value.should eq password
  end  
  
  def login_nice
    login_page(@secret['user'], @secret['password'])  
  end  
  
  def login_click(key_message)
    @browser.input(:name => 'commit').click
    @browser.text.should include 'Sign in' # still wants to sign in
  end  
  
  def login_should_be_complete
    @browser.text_field(:id => 'session_email').should exist
    @browser.text_field(:id => 'session_password').should exist
  end
end

World(LoginHelper)
