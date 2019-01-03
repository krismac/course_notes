# Objects, Arrays & Loops

### Lesson Duration: 75 minutes

## Learning Objectives
- Be able to create, access and modify arrays
- Be able to use common array methods: `pop`, `push`, `shift`, `unshift` and `splice`
- Be able to create, access and modify objects
- Know that object keys are strings, and values can be any type, including other objects
- Be able to write `for` loops
- Know when to use `for...of` and when to use `for...in` loops

## Intro

We often want to store data in collections, or data structures, in order to make the data easier to work with or understand. In this lesson we are going to look at two data structures in Javascript:

1. Arrays - unordered collections where each element has an index position.
2. Objects (known in other languages as hashes, hashmaps and dictionaries) - unordered collections where data is stored in key-value pairs and values can be accessed by their key.

Storing data in collections enables us to organise, manipulate and iterate over it. Just like other programming languages, JavaScript has iteration statements, which allow us to create [loops](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Guide/Loops_and_iteration) so that we can carry out operations on a collection's elements programatically.

In this lesson we are going to look at how we declare collections and manipulate and access their elements.

## Arrays

Arrays are ordered collections and their elements are accessed with an integer index, the first element in an array being at index 0. Let's look at how we declare arrays in JavaScript.

```zsh
touch loops_arrays_objects.js
```

### Declaring an Array

We can create an array with the array literal square bracket notation. (`[]`)

```js
var sports = [];
```

To put data in our array as we create it, we list the values separated by commas. (`,`)

```js
var sports = ['football', 'tennis', 'rugby']; // UPDATED
```

### Length Property

We can get the current number of elements in the array with the Array's `length` property.

```js
var numberOfElements = sports.length;
console.log('number of elements:', numberOfElements);

// -> number of elements: 3
```

### Accessing Elements

To get the first element we pass the index `0` to the array using square brackets again. We can access the other elements with their respective index numbers.

```js
var firstSport = sports[0];
console.log('first sport:', firstSport);
// -> first sport: football

var secondSport = sports[1];
console.log('second sport:', secondSport);
// -> second sport: tennis
```

### Adding Elements to the End

We can add a new element to the end of our array with the `push` method.

```js
sports.push('curling');
sports.push('snooker');
sports.push('darts');
console.log('sports:', sports);

// -> sports: [ 'football', 'tennis', 'rugby', 'curling', 'snooker', 'darts' ]
```

### Removing Elements from the End

Let's get rid of that last item, with the `pop` method.

```js
sports.pop();
console.log('sports:', sports);

// -> sports: [ 'football', 'tennis', 'rugby', 'curling', 'snooker' ]
```

`pop` also returns the removed item.

```js
var removedSport = sports.pop(); // UPDATED
console.log('removed sport:', removedSport); // UPDATED
// -> removed sport: darts

console.log('sports:', sports);
// -> sports: [ 'football', 'tennis', 'rugby', 'curling', 'snooker' ]
```

`pop` and `push` operate on the end of the array. We can do the same to the start of the array using `shift` and `unshift` respectively.

### Adding Elements to the Start

Add an item to the start with `unshift`.

```js
sports.unshift('basketball');
console.log('sports:', sports);

// -> sports: [ 'basketball', 'football', 'tennis', 'rugby', 'curling', 'snooker' ]
```

### Removing Elements from the Start

Remove the first item with `shift`. (also returns the removed item to us)

```js
var removedSport = sports.shift();
console.log('removed sport:', removedSport);
// -> removed sport: basketball

console.log('sports:', sports);
// -> sports: [ 'football', 'tennis', 'rugby', 'curling', 'snooker' ]
```

### Manipulating Arrays with `splice`

These methods are useful, but they only let us modify the beginning or end of the array. What about if we want to add or remove something from the middle of the array? To do this, we can use the Array method, [`splice`](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/splice).

Let's remove `'curling'` from the `sports` array using `splice`. We can see from the docs that `splice` has parameters:

1. `start` is the index position that we want to start removing from. We are removing `'curling'` so we will pass it the index position, which is `3`.
2. `deleteCount` is the number of items to remove. We only want to remove one element so we will pass it `1`.
3. We would use the additional optional arguments if we wanted to use `splice` to add items into the array, which in this case we don't.

`splice` returns an array of all of the items it removed, and modifies the original array we called it on.

```js
var removedSport = sports.splice(3, 1);
console.log('removed sports:', removedSport);
// -> removed sports: [ 'curling' ]

console.log('sports:', sports);
// -> sports: [ 'football', 'tennis', 'rugby', 'snooker' ]
```

### Iterating Over Arrays

When we have an array, and want to do the same thing with each value in the array, we can use a `for` loop. To loop through an array we can use the `for...of` statement. This probably looks similar to `for` loops you might have seen in other languages.

```js
for (var currentSport of sports) {
  var uppercasedSport = currentSport.toUpperCase();
  console.log(uppercasedSport);

  // -> FOOTBALL
  // -> TENNIS
  // -> RUGBY
  // -> SNOOKER
}
```

JavaScript also supports the "long-form" `for` loop syntax. It allows us to run a counter for the index ourselves, and access the array's elements manually using that index. This gives us complete control. We can achieve the same behaviour as the `for...of` loop above like so.

```js
for (var i = 0; i < sports.length; i++) {
  var currentSport = sports[i];
  var uppercasedSport = currentSport.toUpperCase();
  console.log(uppercasedSport);

  // -> FOOTBALL
  // -> TENNIS
  // -> RUGBY
  // -> SNOOKER
}
```

It can be quite a confusing syntax when you first see it. After the `for` we have three separate statements, separated by semi-colons. (`;`)

```js
for (initialiseCounter; condition; incrementCounter) {

}
```

The `initialiseCounter` section runs once, before we begin looping. Here we tend to declare and set and initial value of some kind of counter variable.

The `condition` is checked before every iteration of the loop. If it's `true`, we loop again, if it's `false`, we stop looping and continue the program after the closing brace. (`}`)

The `incrementCounter` section is run after each iteration of the loop. Here we usually want to change our counter variable in some way so that after the appropriate number of iterations, the `condition` is `false` and the loop can end.

You might not have seen the `i++` syntax in the `incrementCounter` section of this `for` statement. `++` is essentially a shorthand for `i += 1`, as incrementing a number by `1` is so common, (for example, in most `for` loops) there's a special operator to do just that. `i += 1` is just a shorthand for `i = i + 1`.

So why bother with this more complicated syntax if we're just doing the same thing as `for...of` does? This syntax is much more flexible, we can do almost anything with it. We could increment the index by 2 each iteration, skipping out every second element. Or we start our counter at the last index, decrement our index counter rather than incrementing, and iterate over the array backwards.

## Objects

### Declaring Objects

Javascript's objects store data in key-value pairs. We can create one with the object literal notation, `{}`.

```js
var movie = {};
console.log('movie:', movie);
// -> movie: {}
```

Our object is currently empty, it has no key-value pairs in it. We can add key-value pairs to our object literal as we define it. A key separated from its associated value by a colon (`:`), and each key-value pair is separated from the next by a comma (`,`). As _all_ keys are `string`s, we don't need to wrap them in quotes. (`'` / `"`)

```js
var movie = { // UPDATED
  title: 'It\'s a Wonderful Life',
  year: 1946,
  language: 'Spanish'
};

console.log('movie:', movie);

// -> movie: {
// ->   title: 'It\'s a Wonderful Life',
// ->   year: 1946,
// ->   language: 'Spanish'
// -> }
```

### Accessing a Property

We can access an object's value by using the dot notation (`.`).

```js
var title = movie.title;
console.log('title:', title);

// -> title: It's a Wonderful Life
```

### Adding a Property

Let's add an array of cast to our movie object. We can add new properties using the same dot notation, this time assigning _to_ the property rather than accessing the value _from_ it.

```js
movie.cast = ['James Stewart', 'Donna Reed'];
console.log('movie:', movie);

// -> movie: {
// ->   title: 'It\'s a Wonderful Life',
// ->   year: 1946,
// ->   language: 'Spanish',
// ->   cast: ['James Stewart', 'Donna Reed']
// -> }
```

### Modifying a Property

Modifying an existing property looks exactly the same as adding a property. If the property already exists, its value is modified. Let's change the language to `'English'`.

```js
movie.language = 'English';
console.log('movie:', movie);

// -> movie: {
// ->   title: 'It\'s a Wonderful Life',
// ->   year: 1946,
// ->   language: 'English',
// ->   cast: ['James Stewart', 'Donna Reed']
// -> }
```

As an alternative to dot notation (`.`) we can use square bracket notation (`[]`). We do this by inserting the property name as a string between square brackets.

```js
movie['language'] = 'French';
console.log('movie:', movie);

// -> movie: {
// ->   title: 'It\'s a Wonderful Life',
// ->   year: 1946,
// ->   language: 'French',
// ->   cast: ['James Stewart', 'Donna Reed']
// -> }
```

This is a bit more typing than the dot notation, but is necessary in some cases. Dot notation won't work when using a property name that contains special characters such a hyphens (`-`) or colons (`:`) etc.

```js
movie.subtitle-language = 'German';

// -> ReferenceError: Invalid left-hand side in assignment
```

```js
movie['subtitle-language'] = 'German'; // UPDATED
console.log('movie:', movie);

// -> movie: {
// ->   title: 'It\'s a Wonderful Life',
// ->   year: 1946,
// ->   language: 'French',
// ->   cast: ['James Stewart', 'Donna Reed'],
// ->   subtitle-language: 'German'
// -> }
```

Most of the time we'll use camelCase instead of kebab-case, however, you may need to use the square bracket notation when dealing with JavaScript objects from an outside data source that uses special characters in their property names.

Another use case for square bracket notation is when you need to dynamically access properties using a variable. This allows us to write DRY, reusable code.

```js
var propertyToAccess = 'subtitle-language'; // NEW
movie[propertyToAccess] = 'German'; // UPDATED
console.log('subtitle language:', movie[propertyToAccess]);
// -> subtitle language: German
console.log('subtitle language:', movie.propertyToAccess);
// -> subtitle language: undefined

// -> {
// ->   title: 'It\'s a Wonderful Life',
// ->   year: 1946,
// ->   language: 'French',
// ->   cast: ['James Stewart', 'Donna Reed'],
// ->   subtitle-language: 'German'
// -> }
```

> Note: A common use-case for this is when a function accepts a key as an argument. Inside the function you will have access to the key via the parameter variable, and will need to use the square bracket notation if you want to access the value from the object.

### Deleting a Property

We can also use the `delete` operator to delete an object's property. Let's delete the movie's `year` property.

```js
delete movie.year;

// -> {
// ->   title: 'It\'s a Wonderful Life',
// ->   language: 'French',
// ->   cast: ['James Stewart', 'Donna Reed'],
// ->   subtitle-language: 'German'
// -> }
```

### Nested Objects

We've seen that the values of our object's properties can be strings, numbers, even arrays, and they can be regular JavaScript objects as well. Like we did with the movie's `cast` property that has an array or strings, we often want to nest data structures inside others. The hierarchical structure this creates helps us more easily access and manage subsets of data.

For example, if we want to store both critics ratings and audience ratings on our movie object, we may decide to wrap both properties in an `ratings` object, because ratings is a subset of the overall movie properties.

Let's give our movie a new `rating` property, with the value of another object. The `rating` object will have two properties: `critic` and `audience`.

```js
movie.ratings = {
  critic: 94,
  audience: 95
};
console.log('movie:', movie);

// -> movie: {
// ->   title: 'It\'s a Wonderful Life',
// ->   language: 'French',
// ->   cast: ['James Stewart', 'Donna Reed'],
// ->   subtitle-language: 'German',
// ->   ratings: { critic: 94, audience: 95 }
// -> }
```

We can access properties on the `ratings` object by chaining the keys using the dot notation, to allow us to 'drill-down' into the data structure.

```js
var audienceRating = movie.ratings.audience;
console.log('audience rating:', audienceRating);
```

### Iterating Over Objects

As with arrays, a common task with a collection of data if iterating through all the pieces of data within it, one at a time. We can do this with the `for...in` statement. `for...in` gives us each key in the object in turn. We can then use the key to access the value.

```js
for (var key in movie) {
  var value = movie[key];
  console.log(`The ${key} is ${value}`);

  // -> The title is It's a Wonderful life
  // -> The language is French
  // -> The cast is James Stewart,Donna Reed
  // -> The subtitle-language is German
  // -> The ratings is [object Object]
}
```

### Accessing an Object's keys

We may not always know the properties of an object. We can use `Object.keys()` to get an array of all of an object's keys. We pass the method the object that we want to get the keys from.

```js
var keys = Object.keys(movie)
console.log('keys:', keys);
// => keys: [ 'title', 'language', 'cast', 'subtitle_language', 'ratings' ]
```


### Task: 10 Minutes

> Note: Hand out [Task Start](arrays_objects_movies_task_start.js).

Complete the tasks in arrays_objects_movies_task_start.js

<details>
<summary>Example solution</summary>

```js
// 1. Loop through the array of movies and make each movie's title all capital letters

for (var movie of movies) {
  var title = movie.title;
  var capsTitle = title.toUpperCase();
  movie.title = capsTitle;
}
console.log('movies:', movies);

// 2. Loop through the array and find the movie with the title Citizen Kane. log its year of release.

for (var movie of movies) {
  if (movie.title.toUpperCase() === 'Citizen Kane'.toUpperCase()) {
    console.log(`Year of release for Citizen Kane: ${movie.year}`);
  }
}

// 3. Using a different kind of loop, iterate through the movies and log each movie's title and audience rating.

for (var i = 0; i < movies.length; i++) {
  var movie = movies[i];
  var audienceRating = movie.ratings.audience;
  console.log(`${movie.title} has an audience rating of ${audienceRating}`);
}
```

</details>

## Recap

What do the array methods `pop`, `push`, `shift`, `unshift` and `splice` do?

<details>
<summary>Answer</summary>
* `pop()` - Remove the last item from the end of the array
* `push(newItem)` - Add a new item to the end of the array
* `shift()` - Remove the first item from the start of the array
* `unshift(newItem)` - Add a new item to the start of the array
* `splice(startIndex, numberToRemove)` - Remove item(s) from a given index position in the array
</details>
</br>

What types can objects' keys and values be?

<details>
<summary>Answer</summary>
* keys are always strings
* values can be any type - string, number, array, object etc.
</details>
</br>

When might we want to use the "long form", basic `for` loop? (`for (var i = 0; i < array.length; i++){}`)

<details>
<summary>Answer</summary>
When we want more flexibility and complete control in terms of how the loop runs. For example, to iterate over only every second item by increasing the index counter by 2 each iteration rather than 1:

```js
var array = ['first', 'second', 'third', 'fourth', 'fifth'];

for (var i = 0; i < array.length; i += 2) {
  var currentItem = array[i];
  console.log(currentItem);

  // -> first
  // -> third
  // -> fifth
}
```

</details>
</br>

Which data structure do we iterate over with `for...of` loops?

<details>
<summary>Answer</summary>
Arrays
</details>
</br>

Which data structure do we iterate over with `for...in` loops?

<details>
<summary>Answer</summary>
Objects
</details>
</br>

## Conclusion

Objects and Arrays help us to organise and work with the data in our applications more efficiently. We can iterate over objects with the `for...in` loop and arrays with the `for...of` loop. If we want total control and extra flexibility, we can do all of the looping manually with a for loop. Loops help us avoid repeated code.
