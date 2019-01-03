# Environment Variables

## Introduction

We often want to configure our apps differently in development and production. If we hard code these configuration settings then we will have to go through our code and manually change them before deploying our code to production. We would like to use variables which have different values on different computers to store things of this nature. An environment variable is a value that can affect the way that an app runs on a particular computer.

### How is This Useful?

Let's say that our application connects to a dummy database while we are in development. We would have an environment variable, `DATABASE_URL`, on our machine that stores the string `'mongodb://localhost:27017'` for that connection. Then the production server would have its own environment variable, `DATABASE_URL`, with a different URL that connects to the production database. Another example would be when our development server listens for requests on port `3000`, and the production server listens on a different port.

> **Important:** Environment variables are stored within the operating system of the individual computers, meaning that they cannot be accessed from within code that is being executed client-side. They can only be used server-side.

Another common use case for environment variables is to store our API keys. We may have separate keys for production and development, or we may just want to keep our API keys separated from our code. This enables us to keep them hidden away from prying eyes on GitHub. You may want to make your API calls server-side to achieve this.

We can set environment variables in our shell manually, but we're going to use the npm package [dotenv](https://www.npmjs.com/package/dotenv) which allows us to easily create environment variables on a project-by-project basis.

## dotenv

dotenv allows us to set environment variables project-by-project. This means that we do not need to reconfigure the environment variables in our operating system every time we switch between projects. In order to use dotenv in a project, the first thing that we need to do is install it using npm.

```sh
npm i dotenv
```

The next thing that we will need to do is create a hidden file called .env which will contain all of our environment variables. This file will contain data specific to the environment (or computer) that the app is running on.

### Creating Environment Variables Using dotenv

```sh
touch .env
```

The data contained in our .env file is specific to the machine that we are currently working on, some of which may be sensitive (passwords, API keys, etc.), so it should not be checked in to version control. We should always add it to our .gitignore.

```sh
# .gitignore

.env
```

Environment variables can now be added to our .env file as follows. These are conventionally named in upper snake case.

```
PORT=3000
DATABASE_URL=mongodb://localhost:27017
API_KEY=abc123def456ghi789
```

> Note: Environment variables are always strings so the values do not need to be delimited with quotes.

The only thing left to do is `require` dotenv into our project and use its `load` method to parse our .env file. This will attach our environment variables to Node's global object, allowing us to access them within our JavaScript modules.

```js
const dotenv = require('dotenv');
dotenv.load();
```

Our environment variables should now be accessible as keys in the global object's `process.env` property.

```js
// server.js

const port = process.env.PORT;
app.listen(port, () => {
  console.log(`Server listening on port ${ port }`);
});
```

```js
// server.js

const databaseURL = process.env.DATABASE_URL;
MongoClient.connect(databaseURL)
  .then(/* ... */);
```

```js
// server/helpers/request.js

const apiKey = process.env.API_KEY;
fetch(url, {
  headers: {
    'X-API-KEY': apiKey
    }
})
  .then(/* ... */);
```

## Conclusion

Environment variables allow us to configure our apps so that they behave differently when running on different computers. dotenv allows us to quickly set up environment variables project-by-project, preventing us from having to make changes to our code between development and production.
