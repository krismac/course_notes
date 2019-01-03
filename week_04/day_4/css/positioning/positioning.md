# CSS Display and Positioning

> Hand out starter files

### Objectives
- Learn about different display types: block, inline, inline-block
- Understand the difference between ```display: none;``` and ```visibility: hidden;```

In this lesson we're going to look at how we can use the ```display``` and ```position``` properties in CSS to change the layout of elements in our HTML pages. 

We've seen how the box model works - every HTML element is basically a box, which we can surround with a border or margin and add padding around the content. 

Now we're going to have a look at how we can move those boxes around, which makes things much easier when we want our web pages to have a nice layout that is easy to follow and user friendly. 

### Display Types
The three most common display types are block, inline, and inline-block. 

All elements have a default type in HTML of either block or inline, and we can change the types using CSS if we want to. 
A __block__ element takes up the whole width of its container, regardless of how wide you set the element to be. 

No other elements will wrap around it. Most of the 'container' type elements have a default display of block, like ```<p>, <div>, <section>, <ul>``` as well as headings like ```<h1>, <h2>``` etc.

[i] show text box example - go to the Chrome Dev Tools (alt + cmd + i or right click and 'Inspect') and hover over the containing ```<div>``` and the ```<h3>``` to show how they take up the whole width of their containers (despite the ```<div>``` being set to have a width of 50%). 

An __inline__ element only takes up the space that its content needs and other elements wrap around it. Most inline elements are text-based elements like links (```<a>```), ```<span>, <cite>``` and outdated styling tags like ```<b> or <u>```. 

[i] show examples of ```<span> and <a>``` tags in the text box - change the padding, margin, height of the span to show how padding/margin can be added but only affect its width / overlap the rest of the text, and height or width don't have any effect. 
 
One of the most common ways that a display style is altered is to change the type to __inline-block__ - this combines parts of both of those types. 

Inline-block elements can have a height and width set on them and push other elements away when they have padding and margin set, but allow other elements to wrap around them on the same line if there is space. 

Look at the ```<button>``` in the text box example - the browser automatically sets its type to inline-block. It stays within the flow of the text but can be given a height and width to determine how much space it takes up.

Another thing to note is that block elements are designed to be 'bigger' than inline elements - because of this you can nest inline elements inside a block, but you may have issues when trying to nest block elements inside an inline element.

### Colour boxes example
Time for another example - comment out the HTML for the 'display-styles' div (cmd + /) and un-comment the 'blocks' section. 

Here we see three coloured divs. Because the default display style of a div is __block__, they are stacked on top of one another - even though they are only 200 pixels wide, the block styling means they must 'take up' the whole width of their container element (in this case the body of the page). 

The only content of the divs is the text of the name of their colour, but because the CSS file sets a width and height for them they become that size.

If we change their display style to inline:

```css
(do this for all three, one at a time)
# main.css
.red {
  background-color: #d9534f;
  display: inline;
}
```

You can see that they now only take up as much space as their content needs, and the three elements wrap around to make a line.
If we change this to inline-block:

```css
(do for all three)
# main.css
.red {
  background-color: #d9534f;
  display: inline-block;
}
```

Take some time to play around with different display styles. 

### Display: none vs Visibility: hidden
Sometimes you will want to hide an element from sight. This may be when using JavaScript to make an interactive page, so that certain things appear or disappear depending on user input. 

There are two main ways of doing this, and they each work a little differently, so we're going to take a look at them.

We have our three coloured boxes all set to ```display: inline-block```. Say we want to hide the blue box. One way to do this is:

```css
/*main.css*/

.blue {
    ...
    visibility: hidden;
}
```

As you can see, we can't see the box any more, but the space it would have taken up is still occupied, making a gap between the other two boxes. 

If we use the Inspector, we can hover over and still see it hiding there. Imagine this as the box wearing an invisibility cloak - it's still there, you just can't see it. Great! But what if we want it to totally go away? We can use:

```css
/* main.css */

.blue {
    ...
    display: none;
}
```

This totally removes the space taken by the element. In the Inspector we can see that the element is still there in the HTML code, but if we hover over it there's nothing to see. Depending on the circumstances, you may want to use one method or the other. 
