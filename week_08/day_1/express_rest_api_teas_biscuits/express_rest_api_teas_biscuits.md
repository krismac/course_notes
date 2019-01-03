# RESTful API in Express

**Lesson Duration: 120 minutes**

### Learning Objectives
- Be able to create a RESTful JSON API with multiple resources
- Be able to use middleware to handle post request bodys in a RESTful JSON API
- Be able to use Express Router to implement modular routers

## Introduction

A RESTful API defines a set of methods (GET, POST, PUT and DELETE) which developers can use to make requests and receive responses using HTTP protocol. We have been consuming a number of JSON API's that other developers have built. In this lesson we are going to build our own JSON API using an Express server. We will be defining a set of endpoints that handle requests and respond with JSON data, using API design principles to ensure that our service is easy and intuitive for other developers to use.

## RESTful API

When creating an API we want to design it in a way that ensures it is intuitive for other developers to use. To do this we are going to adhere to the following principles:

1. Use the HTTP verbs (GET, POST, PUT and DELETE) appropriately. GET is considered a safe method and shouldn't modify any data.

2. Create endpoints that use the hierarchical nature of the URL to represent the structure of the request. For example, 'https://codeclan.com/students/5' should indicate a request regarding one student from the collection 'students' with id of '5'. Collections should be named with the pluralised resource name.

Our API will have two resources, teas and biscuits.

## Teas and Biscuits Application

The application has an Express server. Run the start code by running the server and webpack:

```sh
npm install
npm run build
# NEW TAB
npm run server:dev
```

Visit http://localhost:3000/ in the browser.

### Directory Structure

In addition to the 'client' directory, the application also has a 'server' directory, which contains server.js. server.js is responsible for configuring the server. One of these configurations is to provide the path to the directory which it will serve to the browser as static files using `express.static` (in our case the client's 'public' directory).

#### Node's Path Module

We are using Node's `Path` module here to `join` the current directory (`__dirname`) to our relative path (which uses `..`) and create an **absolute** path for `express.static` to use.

> Note: The script that starts the server with nodemon also must point to location of server.js with `"server:dev": "nodemon server/server.js"`

### Teas and Biscuits API

The front-end application in the client folder makes two initial requests to the following URLs and displays a list for each set of data it gets back:

1. http://localhost:3000/api/teas
2. http://localhost:3000/api/biscuits

In this lesson we are going to be working entirely server-side to create a RESTful API for this front-end to consume.

## Creating a RESTful API using an Express Server

We want to create a RESTful API that serves up two resources: teas and biscuits. We are going to start by creating the teas resource, adhering to API design principles to create the following endpoints with the corresponding actions:

- `/api/teas` - Index (GET)
- `/api/teas/:id` - Show (GET)
- `/api/teas` - Create (POST)
- `/api/teas/:id` - Destroy (DELETE)
- `/api/teas/:id` - Update (PUT)


> We are using `/api` in the routes to distinguish it from our front-end application. This way, if we wanted a second URL, http://localhost:3000/teas, that served HTML, it wouldn't conflict with the API.

Each of these routes will respond with JSON data that our front-end application will consume.

### Index

The start code has an array of teas defined in server.js. Later in the module we will be building API's with data persisted to a database, but as the focus of this lesson is serving up the JSON data on a set of RESTful routes, we are using hardcoded data.

Let's start by handling a GET request to the index (`/`). We will use Express's `get` method, passing it the path and a callback that will invoked when a request hits this route, and is passed a request (`req`) and response (`res`) object. We will then send back the `teas` array as JSON using the response object's `json` method.

```js
// server.js

const teas = [
  //...
];

app.get('/api/teas', (req, res) => { // NEW
  res.json(teas);
});
```

Now when we visit http://localhost:3000/api/teas in the browser, we see the JSON teas data displaying. We have just made the first endpoint of our API.

### Insomnia

When we are building an API, we want a way of testing the endpoints as we create them. We can test the GET methods (index and show) in the browser, but we need a way of testing the other HTTP methods such as POST (create) and PUT (update) without having to build a front-end with a form to send the data. [Insomnia REST Client](https://insomnia.rest/) is a HTTP client that provides us with an convenient way to test our server with all the HTTP methods without requiring a browser front-end.

We are going to use Insomnia REST Client to the index route we have just created.

1. Open Insomnia REST Client.
2. Click the `+` symbol in the left menu (or use `cmd` + `N`) to create a new request.
3. Enter a name ('Index') and select the method ('GET') for the request. Click 'Create'.
4. Add the URL (http://localhost:3000/api/teas) in the address bar at the top.
5. Click 'Send' to see the response data display in the right-pane.

![Send GET request](images/1_insomnia_get.png)

*GET request to 'http://localhost:3000/api/teas' displaying the response using Insomnia REST Client*

### Show

Let's now implement the show action, where we respond to the request with one object. The request URL will contain a parameter, which we use to identify which object is being requested. For example, 'http://localhost:3000/api/teas/1', where '1' relates to the id of the tea being requested.

Again, it will be a GET request, so we will use the `get` method, passing it the path. This time the path will include a parameter (indicated by the colon proceeding it). We will call the parameter `id`. Often we would be working with ids assigned by a database as we can ensure these are unique, but in this case we will use the index position of the tea object in the array.

```js
app.get('/api/teas', (req, res) => {
  res.json(teas);
});

app.get('/api/teas/:id', (req, res) => { // NEW

});
```

On the request object, we can access the `params` (short for parameters) object. This allows us to use the parameter `id` to get back the value sent as part of the url. We can use that number to select the tea with that index position from the array and send it back on the response as JSON.

```js
app.get('/api/teas/:id', (req, res) => {
  res.json(teas[req.params.id]); // MODIFIED
});
```

Let's test our show route in Insomnia:

1. Click the `+` symbol in the left menu (or use `cmd` + `N`) to create a new request.
2. Enter a name ('Show') and select the method ('GET') for the request. Click 'Create'.
3. Add the URL (http://localhost:3000/api/teas/1) in the address bar at the top.
4. Click 'Send' to see the response data display in the right-pane.

![Send GET request](images/2_insomnia_show.png)

*GET request to 'http://localhost:3000/api/teas/1' displaying the tea object at position 1 in the array using Insomnia REST Client*

### Create

To be able to handle a POST request, we have to learn about the request's body object. When the client makes a POST request it can send data with the body of the request (for example, the values of a form when it is submitted), which we can then retrieve server-side.

In our case we want the client to be able to send a tea object with the request, and for our POST route to then add that object to the `teas` array. Our POST route is going to expect to receive an object with a `name` and `brand`.

```js
{
  "name": "One Cup",
  "brand": "Tetley"
}
```

We will use Express's `post` method, pass it the appropriate path, '/api/teas' and a callback. To access the data sent from the client with the request, we access the request's `body` object.

```js
app.get('/api/teas/:id', (req, res) => {
  res.json(teas[req.params.id]);
});

app.post('/api/teas', (req, res) => { // NEW
  console.log(`req.body`, req.body);
});
```

Test our create route in insomnia:

1. Click the `+` symbol in the left menu (or use `cmd` + `N`) to create a new request.
2. Enter a name ('Create') and select the method ('POST') for the request. Click 'Create'.
3. Add the URL (http://localhost:3000/api/teas) in the address bar at the top.
4. This time we need to add the data we want to send with the request. Click 'Body', select 'JSON' and the add the following JSON to the left-hand pane.

```js
{
  "name": "One Cup",
  "brand": "Tetley"
}
```

![Adding JSON body for POST request](images/3_insomnia_create.png)

*Adding the JSON body to a POST request in Insomnia Rest Client*

> Note: The keys must be enclosed with inverted commas because this is JSON (not JavaScript)

When we click send and look in the Terminal window where the server is running, we see `req.body` is undefined. To fix this error we need to use some Express middleware.

### body-parser

We can see that the `body`, which we are trying to access on the request object, is undefined. Express is a light-weight framework and it doesn't expose the body object with its built-in functionality. To access the request's body we have to use some middleware called `bodyParser`. The role of body-parser is to extract the body from the POST request and make it accessible on `req.body`.

body-parser is an npm package so first we need to install it.

```bash
npm install body-parser
```
Then we require it and tell the server to use it.

```js
const path = require('path');
const bodyParser = require('body-parser'); // NEW

const publicPath = path.join(__dirname, '../client/public');
app.use(express.static(publicPath));

app.use(bodyParser.json()); // NEW
```

`bodyParser.json()` provides the middleware that parses json, so our API will only parse the body of a request which has a header with 'Content-Type' specified as JSON. If you click on the 'Header' tab of the left hand section of Insomnia, you will see that there has been a header set with 'Content-Type' set to 'application/json'. Insonmia does this for us when we add a JSON body to the request.

Now when we test our create route, Insomnia Rest Client will hang because we haven't told it what to do in response to the request, but if you look in the terminal window where the server is running, you will see the data outputted: `{ name: 'One Cup', brand: 'Tetley' }`.

To complete the request, let's push the posted data into the array of teas and send back the updated array.

```js
app.post('/api/teas/', (req, res) => {
  teas.push(req.body);
  res.json(teas);
});
```

Now when we test the POST request in Insomnia REST Client, you should get a response of the teas data, with the new tea added.

![Send POST request](images/4_insomnia_create.png)

*POST request to 'http://localhost:3000/api/teas' displaying the response using Insomnia REST Client*

Our create route is now complete.

### Task (15 minutes)

Implement the following routes where the parameter `id` refers to tea's index position in the array:

1. Destroy:
  - handle a `delete` request made to `/api/teas/:id`
  - delete the appropriate tea object in the array
  - send back all the teas data as JSON

2. Update:
  - handle a `put` request made to `/api/teas/:id`
  - update the appropriate tea object in the array with the new tea object sent on the request's body object
  - send back all the teas data as JSON

Test each of the routes with Insomnia

<details>
<summary>Example solution</summary>

```js
// server.js

// ...

app.delete('/api/teas/:id', (req, res) => {
  teas.splice(req.params.id, 1);
  res.json(teas);
});

app.put('/api/teas/:id', (req, res) => {
  teas[req.params.id] = req.body;
  res.json(teas);
});
```

</details>

We now have the CRUD (Create, Read, Update and Delete) operations for our teas resource.

## Express Router

If we now want to add the second resource (biscuits) with all the corresponding routes, our server.js is going to get pretty unmanageable and not very DRY. As additional resources get added, the file will get increasingly difficult to maintain. Express provides a Router object which allows us to modularise our sets of routes, specifying a particular path ('/api/teas' and '/api/biscuits') for each router.

We are going to refactor our back-end to implement modular routers and add the additional biscuits resource. The server will delegate the routing for each resource (teas and biscuits) to its own router. This is what our back-end architecture is going to look like:

![Server-side architecture with modular routers](images/modular_routers_architecture.png)

*Server-side architecture with modular routers*

We are going to create a function that:

- takes in the teas array
- creates a `Router`
- defines a set of routes on the `Router`
- returns the `Router`

This function is going to be stored in a helper file called `create_router.js`. Let's create a `helpers` directory to store it in and then create the file.

```sh
mkdir server/helpers
touch server/helpers/create_router.js
```

### `createRouter` Function

`createRouter` will be a function that takes in the teas array (`data`). It is the function that we will export from the file.

```js
// create_router.js

const createRouter = function (data) {

};

module.exports = createRouter;
```

`createRouter` will create and export an Express `Router`. We will require Express and inside the function invoke `express.Router` which returns a `Router` object.

```js
const express = require('express'); // NEW

const createRouter = function (data) {

  const router = express.Router(); // NEW

};
```

Let's now move the routes handling the teas resource requests, from server.js into create_router.js. (Delete it from server.js and add it into create_router.js).

```js
// create_router.js

const express = require('express');
const router = express.Router();

const createRouter = function (data) {

  const router = express.Router();

  app.get('/api/teas/', (req, res) => { // NEW
    res.json(teas);
  });

  app.get('/api/teas/:id', (req, res) => { // NEW
    res.json(teas[req.params.id]);
  });

  app.post('/api/teas/', (req, res) => { // NEW
    teas.push(req.body);
    res.json(teas);
  });

  app.put('/api/teas/:id', (req, res) => { // NEW
    teas[req.params.id] = req.body;
    res.json(teas);
  });

  app.delete('/api/teas/:id', (req, res) => { // NEW
    teas.splice(req.params.id, 1);
    res.json(teas);
  });

};

module.exports = createRouter;
```

We need to make a couple of changes the routes we brought in:

1. We need to call the methods on the router object, `router`, rather than `app`
2. We need to change reference to `teas` to `data`
2. We need to remove `/api/teas` from the paths, as this will be specified by server.js

```js
const express = require('express');

const createRouter = function (data) {

  const router = express.Router();

  router.get('/', (req, res) => { // MODIFIED
    res.json(data); // MODIFIED
  });

  router.get('/:id', (req, res) => { // MODIFIED
    res.json(data[req.params.id]); // MODIFIED
  });

  router.post('/', (req, res) => { // MODIFIED
    data.push(req.body); // MODIFIED
    res.json(data); // MODIFIED
  });

  router.put('/:id', (req, res) => { // MODIFIED
    data[req.params.id] = req.body; // MODIFIED
    res.json(data);
  });

  router.delete('/:id', (req, res) => { // MODIFIED
    data.splice(req.params.id, 1); // MODIFIED
    res.json(data); // MODIFIED
  });

  return router;

};

module.exports = createRouter;

```

That is our teas router complete.

### Server

server.js is going to create a `teasRouter` and delegate the routing to it for our teas resource. Let's require create_router.js in server.js and create the teasRouter.

```js
// server.js

// ...

const bodyParser = require('body-parser');
const createRouter = require('./helpers/create_router.js'); // NEW

const publicPath = path.join(__dirname, '../client/public');
app.use(express.static(publicPath));

app.use(bodyParser.json());

const teasRouter = createRouter(teas); //NEW

// ...

```

Now we need to tell the server to use the teasRouter by using the `use` method. The `use` method takes two arguments:

1. the path that we want it to use the teas router on, (this is why we removed `/api/teas` from the teas router routes), meaning we only have to state it here in server.js once.
2. The router object we want it to use

```js
// ...

const teasRouter = createRouter(teas);
app.use('/api/teas', teasRouter); //NEW

// ...

```

Now we are set up nicely for when we want to add additional resources, as we will be able to create additional modular routers for each resource and require and add them here.

Great, now you can test your API in Insomnia Rest Client again to ensure it is still serving the JSON on the endpoints and visit http://localhost:3000/ to ensure the index.html is still being served up on the home route.

### Task (10 minutes)

Create a biscuits resource with the following endpoints and corresponding actions:

- `/api/biscuits` - Index (GET)
- `/api/biscuits/:id` - Show (GET)
- `/api/biscuits` - Create (POST)
- `/api/biscuits/:id` - Destroy (DELETE)
- `/api/biscuits/:id` - Update (PUT)

The resource should serve up the following seed data:

```js
const biscuits = [
  { name: "Digestives", brand: "McVitie's" },
  { name: "Hobnobs", brand: "McVitie's" },
  { name: "Shortbreads", brand: "Walkers" },
  { name: "Jammy Dodgers", brand: "Burton's" },
  { name: "Custard Creams", brand: "Crawford's" }
];
```

<details>
<summary>Example solution</summary>

```js
// server.js

const teas = [ // ...
]

const biscuits = [ // NEW
  { name: "Digestives", brand: "McVitie's" },
  { name: "Hobnobs", brand: "McVitie's" },
  { name: "Shortbreads", brand: "Walkers" },
  { name: "Jammy Dodgers", brand: "Burton's" },
  { name: "Custard Creams", brand: "Crawford's" }
];

// ...

const teasRouter = createRouter(teas);
app.use('/api/teas', teasRouter);

const biscuitsRouter = createRouter(biscuits); // NEW
app.use('/api/biscuits', biscuitsRouter); // NEW
```

</details>

Because the front-end is set up to consume the API on these routes, if you visit 'http://localhost:3000/' you are now able to use the form to submit a tea or a biscuit and see it render to the screen.

### Task (15 minutes)

Take note of how the front-end application handles the submission of the form when a new tea is added, from the point the form is submitted, to the updated list being rendered on the screen.

<details>
<summary>Example solution</summary>

1. When the form is submitted, `FormView` creates an object using the submitted values. It publishes this object on the channel `FormView:submit-teas`.

2. The relevant `Consumable` object is subscribed to this channel. When it receives the data it uses the `Request` helper's `post` method to post the data to the API.

3. The `Request` helper's `post` method (like its `get` method) uses `fetch`, but passes it an object as a second optional argument, that specifies three properties:
- the method - POST
- the body - the submitted form data as JSON
- the data type being sent - JSON

4. On completion of the post method, the `Consumable` object receives the updated list from the API as the response and publishes it on the channel, `Consumables:teas-data-loaded`.

5. The relevant `ListView` is subscribed to this channel, and when it receives the data it rerenders the list with the new data.

![Dataflow on form submitt](images/express_api_post_dataflow.png)

*Dataflow through the application when a new tea is submitted by a user*

</details>

## Recap

What design principles should we consider when creating and API? And why?

<details>
<summary>Answer</summary>

We should use the appropriate HTTP methods and create endpoints that use hierarchical nature of the URL to represent the structure of the request, so that it is easy and intuitive to use.

</details>

What is the function of the the Express middleware, body-parser?

<details>
<summary>Answer</summary>

The role of body-parser is to extract the body from the incoming request and make it accessible on `req.body`.

</details>

What problem does the Express Router object solve?

<details>
<summary>Answer</summary>

It prevents all our routes for multiple resources having to be in the same file. It also allows us to create modularised routers.

</details>

## Conclusion

Creating RESTful APIs allows us to create a back-end service that our front-end application can consume. Adhering to RESTful API design principles we can ensure our APIs are easy and intuitive for other developers to use.

Because Express is a light-weight framework, we have to use the additional middleware, body-parse, to handle POST requests and retrieve the data sent on the body of the request.

Using Express Router we can create modularised routes for each of the API's resources, creating a server-side application which is maintainable and extensible.
