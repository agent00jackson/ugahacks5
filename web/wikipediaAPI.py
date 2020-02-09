import wikipedia
from flask import Flask, json, request, jsonify

app = Flask(__name__)


@app.route('/description', methods=['GET'])
def get_description():
    company = request.args.get('company')
    description = wikipedia.summary(company, sentences=3)
    return jsonify(description)


if __name__ == '__main__':
    app.run(host='0.0.0.0', port=8080, debug=True)
