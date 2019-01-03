# Web Programming Intro/HTTP Protocol

### Learning Objectives

- Explain role of HTTP client and server.
- Describe a resource, request and response
- Describe the structure of an HTTP response and HTTP request.
- Describe a safe method. 
- Describe the 5 main classes of HTTP status codes.

## Internet vs Web

What's the difference between the Internet and the WWW?

The World Wide Web is part of the Internet. Other Internet applications include e-mail (SMTP) and FTP. 

HTML is used to create web pages that are linked with hyperlinks.

A web server is a computer (or software) that uses HTTP to listen for requests and then responds with HTML, images, video or other assets.

# HTTP Hypertext Transfer Protocol

> HTML: HyperText Markup Language
> JSON: JavaScript Object Notation

This section may feel a little academic, as day-to-day you may not have to worry too much about how HTTP works, as the web frameworks we will be using will hide much of it for you. 

However, given that HTTP underpins how browsers and web-servers communicate, and thus underpins how most of the internet works, it is worth having some understanding.

Also, it's useful to know what the web framework is doing for you, so that if you get tripped up by something, or something breaks, you can unpick what's going on more quickly.

## Outline

### HTTP

HTTP stands for HyperText Transfer Protocol. It is a protocol by which computers on the web can communicate with each other and request and receive a response.

### Protocols

A protocol is a simple way of saying something like a "a finite, well defined language which computers can use to communicate with each other".

### The HTTP Protocol
> draw a picture of client server,  I use laptop drawing for a client, and a box for server!

HTTP is a request-response cycle. A client (typically, but not always a web-browser) requests a _resource_ from a server. It does so by sending a _request_ HTTP message to the URL of the resource. The server then sends back a _response_ HTTP message, typically with the contents of the resource in it's body, but it may refuse or redirect the client to a different URL instead.

So what can be sent?

- HTML
- JSON
- CSV
- PDF files!

It's important to note that we can send down lot's of types of data and files. Not just HTML.

In the simplest case, the webserver acts like a remote file system. The client requests a file on the server's file system, and the server sends it back, over the internet. When we build web applications though, the files don't actually have to exist on disk, the web server can send back anything it likes in response to a given request on a given URL.

The client may also request changes to the resource, or create new resources (this is where PUT and POST come in) or request to DELETE them.

### What is a Resource?

When we type into our browser and hit enter, we may not be aware of it but we are requesting a resource from the server. 

A resource is piece of data or media, for example:

youtube.com/videos
bbc.co.uk/sport
instagram.com/images
spotify.com/music

For these examples, we can clearly see what 'resource' we are requesting. Depending on how we ask for it, we might get something different back. For example, we may ask for all the videos, one video, add a video or even delete a video. Remember CRUD?? Don't get worried about this just yet as it will sink in the more we use it during the week.

The request-response part of the protocol means that the server can only send data to the client in response to a request from the client (i.e. synchronously). The server can not arbitrarily send data to the client unless a request is held open (this is where other protocols must come in like Websockets if we want our server to communicate asynchronously (as some unknown time) with a client.

The official spec for HTTP version 1.1 is RFC2616 (catchy title huh?) and can be found [here](http://pretty-rfc.herokuapp.com/RFC2616).

## Web Frameworks

Over the next couple of weeks we are going to look at setting up web server applications.  Programs whose role in life is to listen for HTTP requests and return HTTP responses.  

We could create this from scratch if we wanted.  However there are many implementations out there and it will be a better use of our time to use them.  

This week we will look at a popular framework that is written in Ruby: Sinatra.  There are many others.  JavaEE, ASP.net(c#), node.js, Symphony(PHP), Django(Python).  

> Add backpack to Rubot

## HTTP Message

#### Request
The request message consists of the following:

- A request line - for example GET /images/logo.png HTTP/1.1 the URL for the resource and the method definition (verb)
- Request header fields, such as Accept-Language: en.
- An empty line.
- An optional message body.

### Exercise:
#### Method Definitions

Read: [Chapter 9: Method Definitions](http://pretty-rfc.herokuapp.com/RFC2616#method.definitions)

> Sometimes refered to as verbs GET HEAD POST PUT DELETE TRACE OPTIONS CONNECT PATCH (

1. Explain "safe methods"
2. If we wish to create a new resource on the server, should we use PUT or POST? Why?

### Answers

1. A safe method should have no side effects, just retrieving the requested resource.
2. POST. PUT method is designed to update an existing resouce.

	
#### Response
The response message consists of the following:

- A Status-Line, which include the status code and reason message. (e.g., HTTP/1.1 200 OK, which indicates that the client's request succeeded)
- Response header fields, such as Content-Type: text/html.
- An empty line
- An optional message body








