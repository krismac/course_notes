# Algorithms

**Lesson Duration: 120 minutes**

### Learning Objectives

- Know what an algorithm is
- Understand how we can measure the effectiveness of an algorithm
- Understand Binary search and Linear Search

## Intro

Do you know what an algorithm is? You might think that you don't. You might imagine
that it's something complicated or difficult. You might have heard phrases like
"quick sort" or "binary search" and just tuned out.

But really it's super simple: an algorithm is a strategy for solving a problem.

It's really just that.

Examples of problems we might use algorithms for are:
- searching for something
- sorting a collection of things
- finding prime numbers
- calculating whether a projectile hits an enemy in a video game

There are often many different algorithms which we can use to solve the same problem.

In these cases, we need a way to compare the effectiveness of given algorithms.

Today we will look at some common algorithms, and at how we can compare them.

## Searching

### Guess Who

First off, let's look at an example. For this example we'll consider searching for something.

Consider a game of Guess Who. We have access to a collection of people, each with some shared characteristics, and we have to guess which one our opponent has in front of them.

Right off the bat we can think of two rudimentary ways to solve this problem.

The first is the absolute simplest: randomly guess a name each time. Say there are 24 people on the board.

Initially we will have a 1/24 chance of guessing correctly. If we make a correct guess, then we're done, but if we guess incorrectly then we simply remove that person and pick another random name.
Each time we have a slightly better chance of choosing correctly: 1/24, 1/23, 1/22... and at some point we have to guess the right name.

The second is slightly more complicated. Roughly 50% of the people in the game have any given characteristic. E.g. half of the people are men and the other half women, half of them wear glasses and half do not, etc.

Thus we simply pick a characteristic and ask whether the opponent's chosen person has it.

Eventually we will be left with only one person, so we're done.

So which of these algorithms is 'better'?

### Time Complexity

In Guess Who, the most important factor for us to consider is which algorithm will get us to the correct answer in the least number of guesses.
This is because our opponent is also making guesses at the person we've selected.
If we can discover our opponent's person before they correctly guesses ours, then we win.

In algorithmic terms, this is called "Time Complexity".

That is: how long it will need to run before we can guarantee a correct result.

So let's look at our two approaches to Guess Who.

Obviously there's an aspect of randomness to this, so we're going to have to consider a few cases...

### Best Case Scenario

We'll start with our best-case scenario. What is the least number of steps our algorithms can take?

Let's start with randomly guessing the name. In the absolute best case, our first guess is right.

Hooray! We won. Aren't we lucky?

Okay, that was easy. What about guessing by characteristic?

Our first guess simply narrows the playing field. We go from 24 possibilities to just 12. In our second guess we go from 12 to 6. Then 6 to 3. Then, in the best case, our next characteristic eliminates two possibilities, and we guess correctly.

So...

Guessing names: 1 turn
Halving by characteristic: 4 turns

But what does the best case scenario tell us? It tells us that very occasionally guessing names is significantly faster. But it really doesn't happen all that often. Far more interesting to look at is the worst case scenario...

### Worst Case Scenario

So let's look at that worst case. In this case we want to know the absolute largest number of turns we'll have to take in order to guarantee finding the correct person.

For simply guessing the name, the worst case scenario would be guessing wrong every time, and eliminating one person at a time. How many turns will it take to find the right person? 24! One turn for each person who we get wrong.

And the characteristic guessing? Well it's almost the same as the best case scenario!

Each time we half the set of people we can choose from, so again it goes:
24-12-6-3.

Now with 3 left, the worse case scenario is obviously that we choose a characteristic that two share, so we have to add another step to get down to just one person.

So...

Guessing names: 24 turns
Halving by characteristic: 5 turns

Clearly this worst case gives us a totally different look at the performance.
Our clear winner in the best case is now almost 5x worse than our second algorithm. And our characteristic guessing is now only 1 turn worse.

### Average Case Scenario

So what about more generally? How long will these algorithms take on average?

Our random name guessing, it turns out, will succeed each turn with roughly equal probability. We have 24 possibilities, and the average of the numbers 1 to 24 is 12. So on average it will take us 12 turns.

For our characteristic-guessing, we either take 4 or 5 turns, and this happens with roughly equal probability. This means the average case is 4.5.

### The Maths

Okay, we're going to do some maths now. But please don't panic. It's not going to be that difficult.

> Mini task

Let's say we allowed Guess Who to have as many people in it as we wanted. 4, 8, 100, 80,000, it doesn't matter.

How long is each algorithm going to take for numbers above:

- in the worst case?
- on average?

> Draw table on the board.


| Number of People (n) | Name: worst | Name: average | Characteristic: worst | Characteristic: average |
| :------------------: | :---------: | :-----------: | :-------------------: | :---------------------: |
|           8          |      8      |       4       |           3           |            3            |
|          100         |     100     |       50      |           7           |            6            |
|        80,000        |    80,000   |     40,000    |          ~20          |           ~16           |


So what can we say about these? The worst and the average for guessing the name
increase roughly in proportion to `n` (actually `0.5*n`). Clearly with characteristic
guessing both the average and the worst case scenario increase much more slowly.

### Comparison

So which algorithm's better? Well clearly at very low values of `n` it doesn't make that much of a difference.
However as `n` gets very large, using the characteristics to halve the choice of people each time is very obviously
significantly faster.
You'd be guaranteed to win a game of Guess Who with 80,000 people to choose between in 20 turns.

## Big O Notation.

We've seen that one useful measurement of how good an algorithm we're using is
how long it takes to run. (n.b. We can also look at, e.g., how much space the
algorithm requires in memory). We've also seen that it can be helpful to generalise
how an algorithm performs in terms of `n` - the size of the data the algorithm
is working on. In Guess Who, our best choice was a lot more obvious when we
looked at it in terms of `n` than when we just considered some small test values.

In order to fully formalise these comparisons we use a type of mathematical
notation called 'Big O Notation.' We've actually already done the hard part of
Big O notation above - working out how long an algorithm takes to run for `n`
inputs. Remember we said that name guessing took, on average `0.5*n` turns, while
characteristic guessing took, on average, `log(n)` guesses.

To convert these to Big O notation we simply follow these steps:
- Take the term with the largest power (the 'dominant term')
- Remove any constant coefficients
- Wrap it all up in an `O()`

So, for example: `0.5*n` becomes `O(n)` and `log(n)` becomes `O(log(n))`.

### Exercise

Convert the following into Big O notation.

* `5n^3`
* `2n^2 + 3n + 12`
* `5*n*log(n)`
* `1/n + 3log(n)`

Answers: `O(n^3)`, `O(n^2)`, `O(n*log(n))`, `O(log(n))`

> These shouldn't cause too much trouble. The last two are a little harder, but following the rules should make them self-explanatory. Finding the dominant term in example 4 might cause some trouble. If so, just look at the values of `1/n` and `log(n)` as `n` gets big. `1/n` gets closer and closer to 0, whereas `log(n)` continues to grow, albeit slowly.

### Guess Who - Formal Analysis

We can now formally analyse our algorithms from earlier.

*Name guessing*:

  - Best: `O(1)`
  - Average: `O(n)`
  - Worst: `O(n)`

*Characteristic guessing*:

  - Best: `O(log(n))`
  - Average: `O(log(n))`
  - Worst: `O(log(n))`

> This link might help students understand: https://rob-bell.net/2009/06/a-beginners-guide-to-big-o-notation/

## Algorithmic Optimisation

As we've seen, we can have many methods for solving a problem, each with their
own algorithmic complexity. A big problem in computing is the concept of
algorithmic optimisation. What we mean by that is trying to improve an algorithm
so that it's time complexity is slower-growing. For example we might start with
a `O(n)` algorithm and try to improve it to get to a `O(log(n))` one.

We do this in everyday life, too! When cutting carrots it's simpler to cut it
into sticks and then slice several sticks at a time into little chunks. Equally,
when we're debugging our code we often try to find out what method an error is in
and then check each line in there, rather than searching line-by-line through the
whole program.

### Example: searching a sorted array.

Let's say we want to search the following ArrayList for a given number:

```java
[ 1, 3, 7, 8, 9, 21, 23, 45, 56 ];
```

#### Linear Search

We could write some code to do that, using a "Linear Search". Don't let the name
put you off - you've probably written one of these before.

```java
public Boolean linearSearchSortedArray(int search_number, ArrayList<Integer> sorted_array) {
  for (int number : sorted_array)
  if (number == search_number){
    return true;
  }
  return false;
}
```

Let's analyse this like we did before.
*Best case*: `O(1)` since our number will be first
*Worst case*: `O(n)` as we'll have to traverse the whole array
*Average case*: `O(n)` for the same reasons as the Guess Who name guessing

> https://en.wikipedia.org/wiki/Linear_search

We might ask, quite sensibly, if we can find a faster approached to this problem.
Ideally, we'd want one with `O(log(n))` time complexity.

#### Binary Search

Our `O(log(n))` approach to Guess Who worked by halving the people we had to
search through each time, leaving us with only one. Can we apply a similar
approach to the problem of looking through a sorted array?

> Think about this for a while. See if anyone can describe an approach.

Of course, it turns out we can. And we do it like this:
- Pick the middle item in the array.
- If it's our number, then we're done. Otherwise, check if our number is bigger or smaller than it.
- If it's bigger(/smaller), repeat the process with the second(/first) half of the array,

To do this in Java is really complicated but let's have a look...

```java
public static Boolean binarySearchArrayList(int search_number, ArrayList<Integer> array){
  if (array.size() == 0){
    return false;
  }

  int middle_index = 0;
  if (array.size() >1) {
    middle_index = (int) Math.ceil((double) array.size() / 2);
  }

  int midpoint = array.get(middle_index);

  if (search_number == midpoint){
    return true;
  }

  ArrayList<Integer> new_search_area = search_number < midpoint ? new ArrayList<Integer>(array.subList(0, middle_index-1)) : new ArrayList<Integer>(array.subList(middle_index+1, array.size()));
  return binarySearchArrayList(search_number, new_search_area);
}
```

Let's analyse the performance of binary search now.
*Best case*: `O(1)` - this is pretty simple. Sometimes, when we're very lucky, the number we want will be the midpoint.
*Worst case*: `O(log(n))` - a little more tricky to work out, but the reasoning is the same as when we did the Guess Who example.
*Average case*: `O(log(n))` again, exactly the same as Guess Who.

There are a number of algorithms available to use shown below.

* Bubble sort
* Cocktail-Shaker sort
* Quick sort
* Odd-even sort
* Merge sort
* Insertion sort
* Bucket sort
* Interpolation search
* Jump search
* Fibonacci search

There are also good resources found here:

[Sorting Algorithms](https://visualgo.net/bn/sorting?slide=1)

[Sorting Algorithms](https://www.toptal.com/developers/sorting-algorithms)

[Linear Search](https://www.tutorialspoint.com/data_structures_algorithms/linear_search_algorithm.htm)

[Binary Search](https://www.tutorialspoint.com/data_structures_algorithms/binary_search_algorithm.htm)
