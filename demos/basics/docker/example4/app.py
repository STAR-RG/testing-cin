from flask import Flask, jsonify

app = Flask(__name__)

@app.route('/hello')
def index():
    ids = [{'test': 'Name'},2,3,4,5]
    return jsonify(ids)

if __name__ == '__main__':
    app.run(host='0.0.0.0')

