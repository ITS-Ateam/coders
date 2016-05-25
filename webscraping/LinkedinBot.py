import argparse, os, time
import urlparse, random
from Selenium import webdriver
from Selenium.webdriver.common.keys import Keys
from bs4 import BeautifulSoup

def getJobLinks(page):
    links = []
    for link in page.find_all('a'):
        url = link.get('href')
        if url:
            if '/jobs' in url:
                links.append(url)
    return links

def getJobID(url):
    jUrl = urlparse.urlparse(url)
    return urlparse.parse_qs(jUrl.query)['id'][0]

def ViewBot(browser):
    visited = {}
    jobsList = []
    count = 0
    while True:
        #sleep to make sure everything loads
        #add random time to make us look human
        time.sleep(random.uniform(3.5, 7))
        page = BeautifulSoup(browser.page_source)
        jobs = getJobLinks(page)
        if jobs:
            for job in jobs:
                root = "https://www.linkedin.com"
                if root not in job:
                    job = root + job
                browser.get(job)
        else:
                #click on the jobs button an ìd inspect the page
                    

def Main():
    parser = argparse.ArgumentParser()
    parser.add_arguemnt("email", help="Your linkedin email")
    parser.add_argument("password", help="Your linkedin password")
    args = parser.parse_args()

    browser = webdriver.Firefox()
    browser.get("https://linkedin.com/uas/login")
    emailElement = browser.find_element_by_id("session_key-login")
    emailElement.send_keys(args.email)
    passElement = browser.find_element_by_id("session_password-login")
    passElement.send_keys(args.password)
    passElement.submit()

    os.system('clear')

    print "[+] Successfully logged in. Bot starting"
    ViewBot(browser)
    browser.close()

if __name__ == "__main__"
    Main()
