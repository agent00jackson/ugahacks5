import beautifulsoup4

def get_banner():
    film_id = '0423409'
    url = 'http://www.imdb.com/title/tt%s/' % (film_id)
    soup = BeautifulSoup(urllib2.urlopen(url).read())
    link = soup.find(itemprop="image")
    print(link["src"])

if __name__ == '__main__':
    get_banner()