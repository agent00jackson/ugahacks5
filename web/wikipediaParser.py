import wikipedia
from flask import Flask, json

api = Flask(__name__)


@api.route('/description', methods=['GET'])
def get_description(company):
    description = wikipedia.summary(company, sentences=3)
    return json.dumps(description)


if __name__ == '__main__':
    api.run()