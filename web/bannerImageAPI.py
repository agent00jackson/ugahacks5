from bs4 import BeautifulSoup
from requests import api
import requests

def get_banner(company):
    url = "https://twitter.com/" + company
    r = requests.get(url)
    html_content = r.text
    #print(html_content)
    soup = BeautifulSoup(html_content, "html.parser")
    e = 'https://eatatpinkys.com/wp-content/uploads/2019/03/no-image-found.jpg'
    try:
        e = soup.select('img[src*="banner"]')[0]['src']
    except:
        return 'https://eatatpinkys.com/wp-content/uploads/2019/03/no-image-found.jpg'
    return e
  #  for e in soup.select('img[src*="banner"]'):
  #      print(e)
    #print(soup.find_all('img'))