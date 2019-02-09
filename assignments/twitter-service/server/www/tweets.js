response = undefined;

$(function () {

    $.ajax({
        url: 'get_tweets.php',
        type: 'GET',
        success: function (response) {

            console.log("Got response!");

            if (typeof response.errors === 'undefined' || response.errors.length < 1) {

                console.log("Response looks OK.");

                var $tweets = $('<ul></ul>');

                $.each(response, function (i, obj) {

                    console.log(i + ":");
                    console.log(obj);

                    single_elt = "<li>";

                    single_elt += "<p>" + obj.text + "</p>";

                    // If it has a picture.
                    if (("extended_entities" in obj) &&
                        ("media" in obj.extended_entities) &&
                        ("media_url" in obj.extended_entities.media[0])) {
                        single_elt += "<img src='"+obj.extended_entities.media[0].media_url+"'/>"
                    }

                    single_elt += "</li>";

                    $tweets.append(single_elt);
                });

                console.log("Done building tweets DOM elt.");

                $('.tweets-container').html($tweets);

            } else {
                $('.tweets-container p:first').text('Response error');
            }
        },
        error: function (errors) {
            $('.tweets-container p:first').text('Request error');
        }
    });
});