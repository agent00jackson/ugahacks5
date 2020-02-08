from flask import Flask, json

companyStack = [
    ("AMZN", "Amazon"),
    ("MSFT", "Microsoft"),
    ("TSLA", "Tesla"),
    ("SYNA", "Synaptics"),
    ("PINS", "Pinterest"),
    ("LYFT", "Lyft"),
]
portfolio = [
    ("GOOG", 50),
    ("AMD", 20)
]


api = Flask(__name__)

@api.route('/companies', methods=['GET'])
def get_companies():
  return json.dumps(companyStack)

if __name__ == '__main__':
    api.run()
