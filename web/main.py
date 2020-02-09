from flask import Flask, jsonify, request
from finviz import Screener
import re
from finviz.screener import Screener
from wikipediaAPI import *
from bannerImageAPI import *
from time import sleep
import threading

companyStack = [
    {"ticker":"AMZN", "name":"Amazon", "url":"url", "disc":"free two day shipping"},
    {"ticker":"MSFT", "name":"Microsoft", "url":"url", "disc":"billy g."},
    {"ticker":"TSLA", "name":"Tesla", "url":"url", "disc":"praise be unto musk"},
    {"ticker":"SYNA", "name":"Synaptics", "url":"url", "disc":"mouse"},
    {"ticker":"PINS", "name":"Pinterest", "url":"url","disc":"we gon craft"},
    {"ticker":"LYFT", "name":"Lyft", "url":"url", "disc":"yeeee haaaw"}
]
portfolio = [
    {"ticker":"GOOG","val": 50},
    {"ticker":"AMD", "val":20}
]


app = Flask(__name__)

@app.route('/stack', methods=['GET'])
def get_companies():
    return jsonify(companyStack)

@app.route('/portfolio', methods=['GET'])
def get_portfolio():
    return jsonify(portfolio)

@app.route('/swipe', methods=['POST'])
def post_swipe():
    #
    return jsonify({"success": True})

def loadStack():
    filters = ['idx_sp500']
    stonks = Screener(filters=filters, order='price')
    i = 1
    for s in stonks:
        print(str(i) + '.', end='', flush=True)
        #sleep(.2)
        name = re.split(' .,',s['Company'])[0]
        temp = {
            "ticker": s['Ticker'],
            "name": name,
            "url": get_banner(name),
            "desc": get_description(name)
        }
        companyStack.append(temp)
        i += 1

if __name__ == '__main__':
    loadStack()
    app.run(host='0.0.0.0', port=8080, debug=True)
