## Learning Objectives
 - Know the benefits of React Router
 - Be able to use React Router in a simple application

## Introduction
Traditional server rendered applications work by entering the URL into the browser address bar, making a new request for each page. This means that the information being displayed and the URL are kept in sync. Single-Page Applications make the requests asynchronously, therefore the URL gets out of sync with the UI.

This makes navigation difficult. Browser navigation buttons don't work, and we can't direct users directly to specific pages of the app. React has a router module which will help us out with this. It allows us to create a Single-Page application where the UI and URL will be kept in sync so we can use the Browser Navigation features.

Let's first look at an application without React Router and all the problems we mentioned in action.

### Setup

Let's set up an application.

 > Instructor note: Hand out the router start point

 > Instructor note: Ask the class...

Run the start point and check that the links work; that clicking on them renders different the appropriate component.

This is a simple application where the `Main` component is responsible for storing in its state the current page that is being displayed and for rendering the appropriate view when this changes.

### Task: (5 minutes)

 Add a component and a link for a contact page.

# Adding Router
  So the application is functional, but the url does not match what the UI is showing. And if we leave or refresh the page we will always go to home page regardless where we were. Enter the need for a router.

```
  npm install react-router-dom
```

Let's set up the `Main` component to work as router. We will import our other components so we can later pass them in our routes. We will also import `BrowserRouter` (which we rename `Router` for convenience) from the `react-router-dom` library.

```js
// /src/components/Main.js
import React, { Component } from "react";
import About from "./About";
import Home from "./Home";
import Pricing from "./Pricing";
import { BrowserRouter as Router } from "react-router-dom"; //NEW
```

And we use this `Router` component in our `render` method:

```js
// /src/components/Main.js
render() {
  return (
    <Router>

    </Router>
  );
}
```

`Router` will keep track of our navigation through a site. This means now when we refresh it will remember where we were and we can use our browser navigation buttons to go back and forth through our browsing history.

Now we are going to define our routes inside our `Router`. We have to wrap them in a `React.Fragment` because `BrowserRouter` only expects one element. Each `Route` takes two attributes, a path and a component to render on that path.

```js
// /src/components/Main.js
import { BrowserRouter as Router, Route } from "react-router-dom"; // UPDATED

class Main extends Component {

  // AS BEFORE

  render() {
    return (
      <Router>
        <React.Fragment>
          <Route exact path="/" component={Home} />
          <Route path="/about" component={About} />
          <Route path="/pricing" component={Pricing} />
        </React.Fragment>
      </Router>
    );
  }

}
```

We set up an an ***exact*** path to render the Home component. This will render the Home component on http://localhost:3000/ only. The other paths will load their relevant components.

Now we can delete all the methods that were being used to keep track of and render the appropriate component, as Router is now doing all that for us. Let's delete:

* The methods whose names start with `goto...`
* The bindings for these methods in `constructor`
* The `pageComponent` method
* Actually, the whole constructor!

## Navigation

We can now check the routes we created by visiting them in our browser:

* http://localhost:3000/
* http://localhost:3000/about
* http://localhost:3000/pricing

But typing addresses into the browser is no good. Our app needs a navbar!

```bash
touch src/components/Navbar.js
```

```js
// /src/components/Main.jsx
import Navbar from "./Navbar";

<Router>
  <React.Fragment>
    // NEW
    <Navbar />
    {/* Routes as before */}
  </React.Fragment>
</Router>
```

Our `Navbar` is going to be a stateless functional component, and we're going to make an unordered list of links. In HTML, we would use `a` tags for links, with `href` attributes that point to a URL. React Router has a built-in `Link` component, which has a `to` attribute to point to its routes. This makes for some really cute code:

```js
// /src/components/Navbar.jsx
import React from "react";
import { Link } from "react-router-dom";

const Navbar = () => (
  <ul>
    <li>
      <Link to="/">Home</Link>
    </li>
    <li>
      <Link to="/about">About</Link>
    </li>
    <li>
      <Link to="/pricing">Pricing</Link>
    </li>
  </ul>
);

export default Navbar;
```

We can see as we navigate through the site, and the URL changes. So our browser's back button works as we'd expect, and we can bookmark pages in our app.

### Task: (5 minutes)

Create a new component and add it to the list of links in the Main component.

## Passing down props

Loading our components in this way is ideal, we just pass the component to a `Route` and React Router knows what to do. It knows how to render it, and when. This is without a doubt React Router's preferred way of linking URL paths with components.

But there is a problem. With this syntax, there is no way of passing props to a component that we have set up a route for. Most of the time, this is fine; our routes point to top-level components, which act like separate pages and don't need to take in props. But sometimes we _do_ need to pass props down, and luckily React Router has a very nice syntax for this.

Let's say we wanted to pass some actual pricing data to our `Pricing` page component. Maybe in the real world this data might come from our server, but for now we'll just hard-code it in our `Main` component's state:

```js
// /src/components/Main.js
class Main extends Component {
  constructor(props) { // NEW
    super(props);
    this.state = {
      pricing: [
        {level: "Hobby", cost: 0},
        {level: "Startup", cost: 10},
        {level: "Enterprise", cost: 100}
      ]
    };
  }

  render() {
    // AS BEFORE
  }
}
```

Right now we're passing our `Pricing` component into a `Route` through the `Route`'s `component` property. This is fine for most React Router routes, but there's no way to pass props into `Pricing` now. Instead, we have to tell the `Route` _exactly_ what to render here, through its `render` prop:

```js
class Main extends Component {
  render() {
    return (
      <Router>
        <React.Fragment>
          // ... AS BEFORE
          <Route   // UPDATED HERE
            path="/pricing"
            render={() => <Pricing prices={this.state.pricing} />}
          />
        </React.Fragment>
      </Router>
    );
  }
}
```

We can check this out in React dev tools and see that when the `Pricing` component mounts at http://localhost:3000/pricing it gets passed an array of 3 prices as props.

We can make use of these props to render a price list:

```js
// /src/components/Pricing.js

const Pricing = ({prices}) => { // UPDATED

  const listItems = prices.map((price, index) => { // NEW
    return <li key={index}>{price.level}: £{price.cost} per month</li>
  })

  return (
    <div>
      <h4>Pricing</h4>
      <ul>
        { listItems } // UPDATED
      </ul>
    </div>
  )
};
```

## Summary

In this lesson we've seen how React Router enables our users to use standard browser features like a Back button and bookmarks, by matching our UI to appropriate URLs. We can set up `Routes` within a `Router` component, match them to specific URL paths, and load components when the browser requests those routes. We can also pass properties into the components that React Router loads. We have also seen how to use the `Link` component in place of `a` tags to take advantage of React Router's features.
