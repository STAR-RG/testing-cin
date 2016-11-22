# -*- coding: utf-8 -*-

from selenium import webdriver

__all__ = [
    'driver'
]


def get_driver():
    WINDOW_SIZE = (1280, 768)
    PAGE_LOAD_TIMEOUT = 240
    ELEMENT_WAIT_TIMEOUT = 6

    profile = webdriver.FirefoxProfile()
    profile.set_preference('permissions.default.stylesheet', 2)
    profile.set_preference('permissions.default.image', 2)
    profile.set_preference(
        'dom.ipc.plugins.enabled.libflashplayer.so', 'false')
    profile.set_preference('browser.download.folderList', 2)
    profile.set_preference('browser.download.manager.showWhenStarting', False)
    profile.set_preference('browser.download.panel.shown', False)
    firefox = webdriver.Firefox(firefox_profile=profile)
    firefox.set_window_size(*WINDOW_SIZE)
    firefox.implicitly_wait(ELEMENT_WAIT_TIMEOUT)
    firefox.set_page_load_timeout(PAGE_LOAD_TIMEOUT)
    return firefox

driver = get_driver()
