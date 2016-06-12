import sys
import argparse, os, time
import urlparse, random
import getpass
from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from bs4 import BeautifulSoup

#this is the method that scrapes each job page
def getJobInfo(url, page):
    #the input page is already parsed
    job = {
    "jobId": "",
    "position": "",
    "company": "",
    "geoArea": "",
    "date": "",
    "indutsry": "",
    "employmentType": "",
    "experience": "",
    "jobFunction": "",
    "pageUrl": ""
    }

    job['jobId'] = getJobID(url)
    job['pageUrl'] = url

    print(job)
    jFile = open(job['jobId'], 'w')
    page = str(page)

    


def getJobLinks(page):
    links = []
    for link in page.find_all('a'):
        url = link.get('href')
        if url:
            if '/jobs' in url:
                links.append(url)
    return links

def getJobID(url):
    print(url)
    return url.split('/')[5].split('?')[0]

#this is the function that defines the bot
#the firts thing the bot does is clicking on the
#jobs tile in the page, then it types the jobs titles in the search box
#gets all the links from the page, their ids and then stores them in a dictionary

#when the urls are retrieved the bot procedes visiting each job page searching
#for ueful information
def ViewBot(browser):
    print("[+] positioning the bot on the jobs page")
    #sleep to make sure everything loads + not to be kicked out
    time.sleep(random.uniform(3.5,7.0))
    browser.get("https://www.linkedin.com/job/home")

    visited = {}
    jobsList = []
    count = 0

    time.sleep(random.uniform(3.5,5.0))
    jobTitlesList = ['developer', 'sviluppatore']

    for title in jobTitlesList:
        #sleep to make sure everything loads
        time.sleep(random.uniform(1.5,3.0))
        page = BeautifulSoup(browser.page_source)
        #type the job title in the search box
        searchElement = browser.find_element_by_id("job-search-box")
        searchElement.send_keys(title)
        searchElement.submit()

        #wait for the page to load
        time.sleep(random.uniform(1.5,4.0))
        #get the job links from the page
        page = BeautifulSoup(browser.page_source)
        jobs = getJobLinks(page)
        if jobs:
            for job in jobs:
                browser.get(job)
                jobpage = BeautifulSoup(browser.page_source)
                getJobInfo(job, jobpage)
        else:
                print("[-] I'm lost, exiting")
                break


def Main():
    print('##########WELCOME TO THE JOB FINDER BOT!#############')
    email = '{0}'.format(raw_input("Type in your LinkedIn username: "))
    psw = '{0}'.format(getpass.getpass("Insert your password: "))
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
