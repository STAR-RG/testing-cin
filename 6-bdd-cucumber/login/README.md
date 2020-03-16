***SOFTWARE REQUIREMENTS***

You need the chromedriver executable to run this demo. Check the
following directory to access chromedriver version. Use the
chromedriver version that matches the version of your Chrome browser
(see Help > About). https://chromedriver.chromium.org/downloads

# add the directory of your chromedriver to your path
  $> export PATH=$PATH:<location of chromedriver>

# install required dependencies (from Gemfile)
  $> bundle install

# run cucumber (wrapper for ruby)
  $> bundle exec cucumber

# obs. If you want to bootstrap a new cucumber project, run "cucumber
--init" first to create the directory structure that cucumber will
read features, scenarios, and steps.