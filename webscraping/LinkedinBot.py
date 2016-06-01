import sys
import argparse, os, time
import urlparse, random
import selenium
from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from bs4 import BeautifulSoup

#this is the method that scrapes each job page
def getJobInfo(page):
    return null

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
#jobs tile in the page, then it types the jobs titles in the search box
#gets all the links from the page, their ids and then stores them in a dictionary

#when the urls are retrieved the bot procedes visiting each job page searching
#for ueful information
def ViewBot(browser):
    print("[+] positioning the bot on the jobs page")
    browser.get('https://linkedin.com/job/home')
    visited = {}
    jobsList = []
    count = 0

    jobTitlesList['sviluppatore', 'developer']

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
                jobpage = BeautifulSoup(browser.page_source)
                getJobInfo(jobpage)
        else:
                print("[-] I'm lost, exiting")
                sys.exit()


def Main():
    print('##########WELCOME TO THE JOB FINDER BOT!#############')
    email = '{0}'.format(raw_input("Type in your LinkedIn username: "))
    psw = '{0}'.format(raw_input("Insert your password: "))
    print(email)
    print(psw)
    print("[+] Bot starting")

    browser = webdriver.Firefox()
    browser.get("https://linkedin.com/uas/login")
    emailElement = browser.find_element_by_id("session_key-login")
    emailElement.send_keys(email)
    passElement = browser.find_element_by_id("session_password-login")
    passElement.send_keys(psw)
    btn = browser.find_element_by_id("btn-primary")
    btn.click()

    os.system('clear')

    print "[+] Successfully logged in. Bot starting"

    ViewBot(browser)
    browser.close()

if __name__ == "__main__":
    Main()
