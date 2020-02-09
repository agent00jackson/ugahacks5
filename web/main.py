from flask import Flask, jsonify, request

companyStack = [
    {"ticker":"AMZN", "name":"Amazon", "url":"url", "disc":"free two day shipping"},
    {"ticker":"MSFT", "name":"Microsoft", "url":"url", "disc":"billy g."},
    {"ticker":"TSLA", "name":"Tesla", "url":"url", "disc":"praise be unto musk"},
    {"ticker":"SYNA", "name":"Synaptics", "url":"url", "disc":"mouse"},
    {"ticker":"PINS", "name":"Pinterest", "url":"url","disc":"we gon craft"},
    {"ticker":"LYFT", "name":"Lyft", "url":"url", "disc":"yeeee haaaw"}
]
portfolio = [
    ("GOOG", 50),
    ("AMD", 20)
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
    #get list of tickers

    #for each ticker:
        #grab company name
        #grab wikipedia description
        #grab picture url
        #create tuple (ticker, name, desc, picture url)
        #add tuple to companyStack
    return

if __name__ == '__main__':
    loadStack()
    app.run(host='0.0.0.0', port=8080, debug=True)
