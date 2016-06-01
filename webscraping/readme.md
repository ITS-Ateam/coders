DEPENDENCIES OF THE BOT

argparse: used to parse the email and password arguements of the program

os:

time: used to generate a time to make the bot wait for the pages to load and
      not be detected as a bot

Selenium:

BeautifulSoup:


BEHAVIOUR OF THE BOT

1 - the bot logs into linkedin via the default login page
2 - the bot clicks the job tile and gets to the jobs page
3 - the bot inputs the preferenced state from our list of states
    one at the time
4 - the bot retrieves all the job urls in the page searching for
    a list of keywords, when it finds the keywords it stores the url of the job.
5 - the bot starts iterating through the list of jobs one at a time if the
    job isn't already present in the database
6 - once the bot is on the jobs page it retrieves all the informations about
    the job and stores them in our nosql database for the analysis
    when it has all the information it needs, it skips to the next job url,
    so on and so forth, until it gets kicked out
7 - when it gets kicked out it waits for a random time between 5 to 10
    minutes, then logs in again and starts over

typical jobs urls

https://www.linkedin.com/jobs2/view/134247504?refId=&trk=jobs_home_click_jymbii

https://www.linkedin.com/jobs2/view/127887275?refId=&trk=jobs_home_click_jymbii

the job id is in the part of the url after the /view/
so the url gets splitted and the job url gets saved to make sure you don't visit the same job page twice

when the bot gets a list of jobs from the page, it confronts their ids
to make sure he doesn't have them already stored in the database

keywords: sviluppatore developer

this is the job object that will be populated

{
  "id": "",
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

USEFUL TUTORIALS:

https://www.youtube.com/watch?v=twRQNSFXiYs
