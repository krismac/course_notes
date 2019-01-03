# NPM

## Learning Objectives
- Know what package managers are
- Understand why we use package managers
- Know what `package-lock.json` is
- Understand the purpose of `package.json`
- Understand Semantic Versioning
- Be able to install a package from npm

## Intro

We've learned a lot about the core language features of JavaScript. One thing that we've been missing so far, however, is unit testing. As with other programming languages, there are a plethora of testing frameworks available for JavaScript.

The easiest way to install and start using one of them is via a package manager.

## What is a Package Manager?

In simple terms, a package manager is a piece of software (usually a command-line interface) that allows us to easily install, update or uninstall other pieces of software. You might have used Homebrew on Mac, Chocolatey on Windows or APT/YUM on Linux distros.

## Why Do We Use Package Managers?

When developing software, package managers can be especially useful for installing libraries. A library is a package of code that someone has written to help solve a common problem. You might use a library to write a web server or to write and/or run unit tests. You might even write your own library to help complete common tasks.

Most programming languages have a widely used package manager that can be used to quickly and easily install libraries for that language. Ruby has RubyGems and Python has pip, for example.

The most widely used package manager for JavaScript is npm.

## What is npm?

npm is the world's largest software registry. It's used by over 7 million developers, amasses over 4 billion weekly downloads and is host to over half a million libraries!

npm also helps us to manage the dependencies, libraries that our code is dependent on, of our projects.

Imagine that two developers are working on a large project. What if one of them was to add a new dependency and forgot to tell the other? How would they know what they would have to download in order to get the project running again?

YouTube video: [npm Inc - get started with npm](https://youtu.be/x03fjb2VlGY)

## Setting up a New Project

If we're going use npm to install and manage the dependencies of a project, the first thing that we have to do is run `npm init` at the top level of our project.

```sh
npm init
```

npm will now ask you to set values for a few different options, describing your project. In the real world you would probably fill this out with real information, but it's really not important here. We'll just hit enter until npm asks us to confirm that everything is okay, then it will take us back to our command-line prompt.

Alternatively, we can use `npm init -y` to say 'yes' to the default options without having to hit enter to accept each one individually. We can always modify these options later.

When we run `npm init` npm creates a file called package.json for us.

```sh
ls
# -> package.json
```

### package.json

Right now this file only contains some metadata about our project, which is completely meaningless to us right now. It will be used by npm later on, however, to manage the dependencies of our project.

Let's open the current directory up in Atom and take a quick look the package.json.

```sh
atom .
```

```json
// package.json

{
  "name": "npm",
  "version": "1.0.0",
  "description": "",
  "main": "index.js",
  "scripts": {
    "test": "echo \"Error: no test specified\" && exit 1"
  },
  "keywords": [],
  "author": "",
  "license": "ISC"
}

```

This is JSON, or JavaScript object notation. JSON looks just like a JavaScript object. All JSON is valid JavaScript, but not all JavaScript is valid JSON. The keys in a JSON object must be declared as double-quoted (`"`) strings and their values cannot be functions.

## Installing a Package

The package that we're going to use for the purposes of this lesson is [five](https://www.npmjs.com/package/five). Five is a simple (and fairly useless) library, which provides a set of methods which we can then use within our project.

We can install any package from the npm registry using the `npm install` command.

```sh
npm install five
```

When we use `npm install` npm generates three things for us: a directory called node_modules, an updated version of our package.json and a file called package-lock.json.

```sh
ls
# -> node_modules
# -> package-lock.json
# -> package.json
```

### node_modules

The node_modules directory is where npm stores the files that we have downloaded. These folders can become quite large in terms of file size, so it's best practice to add them to your .gitignore file to prevent them from being checked in to git.

```sh
touch .gitignore
```

```git
# .gitignore

node_modules/
```

### package.json

If we take another look at our package.json in Atom, we should see that npm has added five as a dependency of our project.

```json
"dependencies": {
  "five": "^0.8.0"
}
```

### package-lock.json

The package-lock.json file is generated whenever npm modifies either our package.json or node_modules. The purpose of this file is to ensure that npm will always be able to get the correct versions of our dependencies. This also applies to the dependencies of our dependencies, the version numbers of which aren't tracked in our package.json.

If one of the packages that our project is dependent on was to be updated and introduce breaking changes, our code would stop working. In this case we might not want to update to the latest version, which is the default behaviour.

## Semantic Versioning

Let's take a minute a to talk about the version numbers that we can see in the package.json and package-lock.json and what they mean.

```json
"version": "1.0.0"
```

The first thing that you might notice is that they're split in to three distinct parts. We can refer to these parts (from left to right) as the major, minor and patch version numbers. These numbers are incremented each time a new version is released.

The patch release number is incremented if only backwards compatible bug fixes are included in this version.

The minor release number is incremented if a substantial amount of new functionality or improvements are added in this version. A minor release may also include patch level changes. The patch version will always reset to zero when a new minor version is released.

The major release number is incremented when backwards incompatible changes are released. A major release may also contain both minor and patch level changes. The patch and minor versions will always reset to zero when a new major version is released.

## Running an existing project

Imagine for a second that this was someone else's project that we had cloned from GitHub. Their node_modules were added to their .gitignore, so we need to install the dependencies of the project before we can run it.

> Instructor note: Ask the students not to follow along here

```sh
rm -rf node_modules
```

```sh
ls
# -> package-lock.json
# -> package.json
```

If we use the `npm install` command, without passing any arguments to it, npm will look at the dependencies in our package.json and install everything from the dependency list.

> We can use `npm i` as shorthand for `npm install`

```sh
npm install
```

```sh
ls
# -> node_modules
# -> package-lock.json
# -> package.json
```

## Using a Package

Now that we've learned about npm and installed a package, we can use its functionality in our project. The first thing that we'll have to do is create a file to work in.

```sh
touch five_play.js
```

We can access libraries that we have installed via npm in our code using `require`. If we don't specify a relative path, `./` for example, then Node will know to look into our node_modules directory for that package.

```js
// five_play.js

const five = require('five');
```

Now that we have imported the library into our codebase we can use any of the methods that it provides us with freely.

```js
const five = require('five');

console.log(five.upHigh());
console.log(five.downLow());
console.log(five.tooSlow());
// -> ⁵
// -> ₅
// -> 5
```

## Recap

What is a package manager?

<details>
<summary>Answer</summary>
A package manager is a piece of software that we can use to install, update or uninstall other pieces of software.
</details>

<br>

What is npm?

<details>
<summary>Answer</summary>
npm is the most widely used package manager for JavaScript.
</details>

<br>

Where does npm store the list of our dependencies?

<details>
<summary>Answer</summary>
npm stores a list of our dependencies in the package.json file.
</details>

<br>

What does `npm install` do when not passed any arguments?

<details>
<summary>Answer</summary>
It looks at the list of dependencies in our package.json and installs everything that it sees.
</details>

## Conclusion

Now that we can use npm, we have access to hundreds of thousands of packages that can help us to accomplish tasks that we would either be unable to complete on our own, or would take considerably more time.

These packages will be invaluable for things like unit testing, running a web server or connecting to a database throughout the rest of this module.

## Further Resources

npm - [package.json](https://docs.npmjs.com/files/package.json)  
npm - [package-lock.json](https://docs.npmjs.com/files/package-lock.json)  
[Semantic versioning](https://semver.org/)
