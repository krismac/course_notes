# Events

**Lesson Duration: 75 minutes**

### Learning Objectives
- Understand what an event-driven environment is
- Be able to add behaviour to an event
- Know common event types
- Understand delayed execution of behaviour within callback functions
- Understand default behaviours in events, and know how to prevent it

## Intro

As a language, JavaScript follows a number of programming styles, or _paradigms_. One these paradigms is known as _event-driven programming_.

Event-driven programming has its roots in the earliest days of graphical user interfaces. We use it to listen for and react to events in our applications. Sometimes these events will be triggered by the system itself (for example, by a temperature sensor, or by a web page loading in the browser), but more commonly, events are triggered by user-input, for example, a button click, a key press, or a form submission.

When an event is triggered, a specific piece of code is executed. When writing JavaScript, we can use the power of callback functions to specify which piece of code is executed when an event is dispatched.

## Adding callbacks to events

In order to react to an event, we need to ask three questions:

1. Which element will be dispatching the event?
2. Which event should we listen for?
3. Which piece of code should run when the event is dispatched?

We've actually already been adding a callback to an event. We do it every time we write:

```js
  document.addEventListener('DOMContentLoaded', () => {
    console.log("Hello World")
  });
```

1. The element that will be dispatching the event is the `document`.
2. The event that is being listened for is `DOMContentLoaded`.
3. The code that will be run when the event is dispatched is the callback containing the `console.log`.

`addEventListener()` is used to add the callback to the event.

We call the same method, `addEventListener()`, on DOM elements to add behaviour to their events. `addEventListener()` takes two arguments: The event as a string and a callback to be invoked when the event is fired.

Other examples include:

- to listen for a select's `change` event, in order to render details about the selected option to the page
- to listen for a form's `submit` event, in order to makes a post request

> Instructor note: Hand out start point and ask students to open the index.html in the browser.

## Manipulating the DOM with Events

Looking at the start code, we can see that there are various html elements defined in index.html (a button, an input, a select and a form). At the moment these elements don't do anything when interacted with in the browser. We are going to add event listeners to these elements, so that when a user interacts with them, the page is updated.

If we look at the MDN docs, we can see a list of events and their targets listed down the left-hand side:
[https://developer.mozilla.org/en-US/docs/Web/API/EventTarget/addEventListener](https://developer.mozilla.org/en-US/docs/Web/API/EventTarget/addEventListener)

If you click on the `click` event, it tells us the target of this event can be any DOM element, so let's add a behaviour to our button.

### Buttons

We want the button to listen for a `click` event and update the paragraph below it from being, "That button has not been clicked." to "That button has definitely been clicked."

Let's use the three steps we listed before to plan the event listener:
1. Element - button
2. Event - `click`
3. Callback - responsible for updating the paragraph

We will start by querying the DOM to get the button element. Then we will add the event listener to the button, passing in the event as a string and a callback that we haven't written yet.

```js
// app.js

document.addEventListener('DOMContentLoaded', () => {

  const button = document.querySelector('#button'); // NEW
  button.addEventListener('click', handleButtonClick); // NEW
});
```

Now let's write the callback `handleButtonClick`, that will be responsible for updating the paragraph text. It will query the DOM for the paragraph element and set it's `textContent`.

```js
// ...

const handleButtonClick = function() { // NEW
  const resultParagraph = document.querySelector('#button-result');
  resultParagraph.textContent = 'That button has definitely been clicked.';
}

```

Refresh the browser and see the paragraph text update when the button is clicked.


### Text Inputs

We want the input to listen for a [`input`](https://developer.mozilla.org/en-US/docs/Web/Events/input) event and update the paragraph below it from being, "Nothing has been typed yet." to "You typed:" followed by the text that has been typed into the input.

Planning for the event listener:
1. Element - input
2. Event - `input`
3. Callback - responsible for getting the value from the input and updating the paragraph

This will follow the same pattern as handling the button click, but this time we will need to get the value from the input (the text that's been typed) so it can be displayed. Let's start by adding the event listener and passing in a callback that we haven't written yet.

```js
document.addEventListener('DOMContentLoaded', () => {
  // ...

  const textInput = document.querySelector('#input'); // NEW
  textInput.addEventListener('input', handleInput); // NEW
});
```

As before, we can now write the callback `handleInput` that is going to be responsible for getting the value from the input and updating the paragraph text below.

```js
// ...

const handleInput = function() {
  // 1. Get value from Input
  // 2. Update paragraph text
}
```
So how do we get the value back from the input?

### The Event Object

When we pass a callback to `addEventListener`, `addEventListener` passes an event object to our callback that contains various information about the event that was dispatched. Let's start by `log`ing the `event` and having a look at it.

```js
// ...

const handleInput = function(event) {
  console.log(event);
}
```

Now when we type something into the input in the browser, we see the `event` object in the console. It has a property called `target`, which is the element that dispatched the event (in this case the text input). `target` has a property called `value` which contains what text that has been typed into the input.

### Task: (5 minutes)

Complete the callback so that it updates the paragraph text to be "You typed:" followed by the text that has been typed.

<details>
<summary>Example Solution</summary>

```js
// ...

const handleInput = function(event) {
  const resultParagraph = document.querySelector('#input-result');
  resultParagraph.textContent = `You typed: ${event.target.value}`;
}
```

</details>


### Selects  

When an option is selected from the select, we want to update the paragraph below it from being, "No choice has been made." to being "You went with:" followed by the value of the selected option.

Planning for the event listener:
1. Element - select
2. Event - `change`
3. Callback - responsible for getting the value from the select and updating the paragraph

### Task: (5 minutes)

1. Add an event listener to the select element that listens for the `change` event, passing in the callback `handleSelectChange`, which you haven't written yet.

2. Write the callback `handleSelectChange` so that it updates the paragraph text below the select to be "You went with:" followed by the value of the selected option.

**Hint: `log` the event object to check how to get the value from the select**

<details>
<summary>Example Solution</summary>

```js
document.addEventListener('DOMContentLoaded', () => {
  // ...

  const select = document.querySelector('#select');
  select.addEventListener('change', handleSelectChange);
});

// ...

const handleSelectChange = function(event) {
  const resultParagraph = document.querySelector('#select-result');
  resultParagraph.textContent = `You typed: ${event.target.value}`;
}
```

</details>

### Forms

When the form is submitted, we want to update the paragraph below it from being, "Who's it going to be?" to being "Your name:" followed by the value of the first and last name inputs.

Planning for the event listener:
1. Element - form
2. Event - `submit`
3. Callback - responsible for getting the values from the form inputs and updating the paragraph

Let's start by adding the event listener to the form element and writing the callback as we have been doing previously. To get input values back from a form, we use the ID of the input. So in this case we will log `event.target.first_name.value` to get the value of the first name.

```js
const form = document.querySelector('#form');
form.addEventListener('submit', handleFormSubmit);

const handleFormSubmit = function(event) {
  console.log(event.target.first_name.value);
}
```

But wait, we have a problem. When we try to submit the form there is nothing displayed in the console. That's because by default a html form, when submitted, sends a post request to the current URL. This means our page has been refreshed and with it, the state of the application has been lost. Because we want to handle our requests with javascript, we are going to prevent this default behaviour by using a method called `preventDefault` on the `event` object.

```js
const form = document.querySelector('#form');
form.addEventListener('submit', handleFormSubmit);

const handleFormSubmit = function(event) {
  event.preventDefault();
  console.log(event.target.first_name.value);
}
```
Great. Now we can see the `event.target.first_name.value` in the console.

### Task: (5 minutes)

Complete the callback so that it updates the paragraph text below the form to be "Your name:" followed by the first and second names submitted by the form.

<details>
<summary>Example Solution</summary>

```js
const handleFormSubmit = function(event) {
  event.preventDefault();
  const resultParagraph = document.querySelector('#form-result');
  resultParagraph.textContent = `
    Your name:
    ${event.target.first_name.value}
    ${event.target.last_name.value}
  `
}
```

</details>

## A Note on Context

<details>
<summary>What is the value of `this` inside the callbacks we have written?</summary>

Because we have used `function` expressions to define the callbacks, the `this` refers to the execution context. In this case the object the callback is executed on is the DOM element. So `this` refers to the DOM element that dispatched the event.
<br>
</details>

In the callbacks `event.target` refers to the DOM element that dispatched the event. `this` also refers to the DOM element, so we could replace `event.target` with the `this` keyword when accessing the inputs values.

```js
const handleFormSubmit = function(event) {
  event.preventDefault();
  const resultParagraph = document.querySelector('#form-result');
  resultParagraph.textContent = `
    Your name:
    ${this.first_name.value}
    ${this.last_name.value}
  ` // UPDATED
}
```

If we had used an arrow function expression to define the callbacks, `this` would retain its definition context, and therefore would not refer to the DOM element.


## Recap

<details>
<summary>What are the three things we need in order to react to an event?</summary>

1. The element that will dispatch the event.
2. The event that should be listened for.
3. The callback that defines what should happen when the event is dispatched.
</details>

<details>
<summary>What values and methods did we use from the `event` object and how were these useful to us?</summary>

- The values of the elements that dispatched the events so that we could use them to render to the DOM
- `preventDefault`, which enables us to override the default behaviour of the form submit.
</details>

## Conclusion

Using the event-driven paradigm, we have added behaviour to events that get triggered by user inputs, enabling us to build an interactive JavaScript app. We used the method `addEventListener` to add the behaviour to events. We also looked at a number of DOM elements and their events, such as button clicks, select changes and form submits.

The `event` object is passed as an argument to our callback by `addEventListener` and gives us information about the event that has just been dispatched, including the value of inputs and selects. It also gives us a method, `preventDefault`, which enables us to override the default behaviour of events, such as the request made on the submission of a form.
