# Protecting Your API Key

When using an API that requires a key, you will be given a key that is specific to you, that allows you to make requests. You will want to keep this key private as there are bots that scan GitHub for these keys. There may not be much damage someone can do with a Spotify key, but if someone had your AWS key they could spin up a multiple servers and charge it to your credit card!

The solution is to store the key in another file that you `.gitignore`. We know we can export any value from a module with `module.exports`, so we can export the key from the file.

```js
// helpers/api_key.js

const API_KEY = '<paste in the key (token) you were given when you signed up for the API>';

module.exports = API_KEY;

// e.g const API_KEY = "BQAdE9IadrGHpgckmYyIlRGH..."

```

```bash
# .gitignore

api_key.js
```

### Using the key in our request

We require the key into the file where we want to use it. Before we send our request (ie before `request.send()`) we need to include this key in our request so we can be authorised. The way you do this **will vary between APIs** and you will need to read the API's documentation, but here is one example:

```js
const API_KEY = require('./helpers/api_key.js');

const authorizationHeader = `Bearer ${API_KEY}`;
request.setRequestHeader("Authorization", authorizationHeader);
// ...
// request.send();

```

Now we have stored our API key in a file which will not be committed to github, but can be access by the rest of the project.
