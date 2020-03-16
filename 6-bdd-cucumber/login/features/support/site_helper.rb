module SiteHelper
  def goto_login 
    @browser.goto @secret['website']
  end 
  
  def full_login
    goto_login
    login_page(@secret['user'], @secret['password'])  
    login_click 'message'
  end
  
  def click_to_and_verify(link_text, expected_message)
    @browser.link(:text => link_text).click
    @browser.text.should include expected_message
  end    
end

World(SiteHelper)