import sys
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
    return jUrl.split('/')[5].split('?')[0]

#this is the function that defines the bot
#the firts thing the bot does is clicking on the
#jobs tile in the page,
def ViewBot(browser):
    print("[+] positioning the bot on the jobs page")
    browser.get('https://linkedin.com/job/home')
    visited = {}
    jobsList = []
    count = 0

    jobTilesList['sviluppatore', 'developer']

    for title in jobTitlesList:
        #sleep to make sure everything loads
        #add random time to make us look human
        time.sleep(random.uniform(3.5, 7))
        page = BeautifulSoup(browser.page_source)

        #type the job title in the search box
        searchElement = browser.find_element_by_id("job-search-box")
        searchElement.send_keys(title)
        searchElement.submit()

        #get the job links from the page
        jobs = getJobLinks(page)
        if jobs:
            for job in jobs:
                root = "https://www.linkedin.com"
                if root not in job:
                    job = root + job
                browser.get(job)
        else:
                print("[-] I'm lost, exiting")
                sys.exit()


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
