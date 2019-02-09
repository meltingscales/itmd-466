import base64
import json
from pprint import pprint

import requests
from flask import Flask, send_from_directory, redirect
from flask.json import jsonify

app = Flask(__name__, static_folder="www")

# Set up our secrets.
try:
    with open('secrets.json') as f:
        json_secrets: dict
        json_secrets = json.load(f)
except FileNotFoundError as e:
    print("You didn't make `secrets.json` containing twitter API keys, did you? Go do that!")

oauth_access_token = json_secrets['oauth_access_token']
oauth_access_token_secret = json_secrets['oauth_access_token_secret']
consumer_key = json_secrets['consumer_key']
consumer_secret = json_secrets['consumer_secret']


@app.route('/')
def redirindex():
    return redirect('/henrypost.html')

@app.route('/henrypost.html')
def index():
    return app.send_static_file("twitter.html")


@app.route("/<path:path>")
def send_www(path):
    return send_from_directory('www', path)


# Drop-in compatibility replacement for the JS code.
@app.route("/get_tweets.php")
def twitter_query(user_id="Flex Seal", screen_name="GetFlexSeal", count=10):

    key_secret = '{}:{}'.format(consumer_key, consumer_secret).encode('ascii')

    b64_encoded_key = base64.b64encode(key_secret).decode('ascii')

    base_url = 'https://api.twitter.com/'
    auth_url = '{}oauth2/token'.format(base_url)

    auth_headers = {
        'Authorization': 'Basic {}'.format(b64_encoded_key),
        'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'
    }

    auth_data = {
        'grant_type': 'client_credentials'
    }

    auth_resp = requests.post(auth_url, headers=auth_headers, data=auth_data)

    access_token = auth_resp.json()['access_token']

    search_headers = {
        'Authorization': 'Bearer {}'.format(access_token)
    }

    request = requests.get(
        "https://api.twitter.com/1.1/statuses/user_timeline.json",
        params={
            "user_id": user_id,
            "screen_name": screen_name,
            "count": count,
            "include_rts": "true",
        },

        headers=search_headers,
    )

    print(request.url)

    ret = request.json()

    pprint(ret)

    return jsonify(ret)


if __name__ == "__main__":
    app.run(debug=True, port=80)
