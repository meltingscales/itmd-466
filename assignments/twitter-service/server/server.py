from flask import Flask, send_from_directory

app = Flask(__name__, static_folder="www")

oauth_access_token = '1513932746-ZngQ9heHSrLOmUr1dtyX0n0Dy612UE39yzlfLjj'
oauth_access_token_secret = 'L8KMoj8Fw9VvBIC7TPrgiZFGWDE4eumsNeBYTPDytgUxZ'
consumer_key = 'kdRFUN54ynLOWg0ditZhGAnu6'
consumer_secret = 'XFrvKuaiMKe7rK53bFxnj7O90Cfk8PtKGg6inWKXpZQxCwYPA7'
user_id = 'HoseaHLee'
screen_name = 'HoseaHLee'
count = 10
twitter_url = 'statuses/user_timeline.json?user_id={0}&screen_name={1}&count={2}' \
    .format(user_id, screen_name, str(count))


@app.route('/')
def index():
    return app.send_static_file("twitter.html")


@app.route("/<path:path>")
def send_www(path):
    return send_from_directory('www', path)


# Drop-in compatibility replacement for the JS code.
@app.route("/get_tweets.php")
def twitter_query():
    return '{["potato"]}'


if __name__ == "__main__":
    app.run(debug=True, port=80)
