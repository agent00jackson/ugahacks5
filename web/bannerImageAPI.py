from bs4 import BeautifulSoup
from requests import api
import requests
from flask import Flask, jsonify, request

app = Flask(__name__)


@app.route('/banner', methods=['GET'])
def get_company_banner():
    try:
        company = request.args.get('company')
        banner = company
        return jsonify(get_banner(banner))
    except:
        return jsonify('https://eatatpinkys.com/wp-content/uploads/2019/03/no-image-found.jpg')


def get_banner(banner):
    url = "https://twitter.com/" + banner
    r = requests.get(url)
    html_content = r.text
    #print(html_content)
    soup = BeautifulSoup(html_content, "html.parser")
    e = soup.select('img[src*="banner"]')[0]['src']
    return e
  #  for e in soup.select('img[src*="banner"]'):
  #      print(e)
    #print(soup.find_all('img'))



if __name__ == '__main__':
    app.run(host='0.0.0.0', port=8080, debug=True)