// import XMLHttpRequest;

// function httpGet(theUrl)
// {
//     useragent = "Mozilla/8.8 (Macintosh; Intel Mac OS X 8888_8888) AppleWebKit/888.8.88 (KHTML, like Gecko) Version/88.8.8 Safari/888.8.88";
//     var xmlHttp = new XMLHttpRequest();
//     xmlHttp.open( "GET", theUrl, false ); // false for synchronous request
//     xmlHttp.setRequestHeader("user-agent", useragent);
//     xmlHttp.send( null );
//     return xmlHttp.responseText;
// }

url = "https://0ijq1i6sp1.execute-api.us-east-1.amazonaws.com/var/task/app.py/"

// res = httpGet(url)
// console.log(res)

headers = new Headers({
    "user-agent": "Mozilla/8.8 (Macintosh; Intel Mac OS X 8888_8888) AppleWebKit/888.8.88 (KHTML, like Gecko) Version/88.8.8 Safari/888.8.88",

});

fetch(url, {
    headers: headers
}).then(function(response) {
    return response.json();
  }).then(function(data) {
    console.log(data);
  })