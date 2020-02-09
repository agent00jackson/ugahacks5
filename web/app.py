from flask import Flask, json, request

companyStack = [
    ("AMZN", "Amazon", "url", "free two day shipping"),
    ("MSFT", "Microsoft", "url", "billy g."),
    ("TSLA", "Tesla", "url", "praise be unto musk"),
    ("SYNA", "Synaptics", "url", "mouse"),
    ("PINS", "Pinterest", "url", "we gon craft"),
    ("LYFT", "Lyft", "url", "yeeee haaaw")
]
portfolio = [
    ("GOOG", 50),
    ("AMD", 20)
]


api = Flask(__name__)

@api.route('/stack', methods=['GET'])
def get_companies():
    return json.dumps(companyStack)

@api.route('/portfolio', methods=['GET'])
def get_portfolio():
    return json.dumps(portfolio)

@api.route('/swipe', methods=['POST'])
def post_swipe():
    #
    return json.dumps({"success": True}), 201

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
    api.run(host='0.0.0.0', port=8080)
