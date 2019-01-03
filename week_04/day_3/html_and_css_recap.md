# HTML and CSS recap

## Length

2 x 45mins

## Semantic HTML

All layout and presentation should be handled by CSS whilst contents should be stored in the HTML. In other words, fonts, colours and spacing on the page is controlled by CSS, and everything else is written in the HTML document.

HTML is a semantic markup language, and this means that all elements have their purpose and should be nested properly.

#### A book example

Imagine a book with its cover, table of contents, chapters, paragraphs, footnotes and index. When these are all in order it's easy to ready it. What would happen if you started shuffling elements and used cover pages for chapter pages, or paragraphs on the cover itself? It wouldn't make sense. What would happen if you started writing paragraphs using the same font sizes as chapter headings? It woulnd't work, either.

It's exactly the same with HTML, the difference being that CSS allows us to style **anything** in any way. This is a danger, as a good looking site might be badly malformed at the code level, thus making it performing poorly.

That's why it's content that should be designed first. The best is to make sure that all is in place **before** we start adding colours and decorative elements such as images.

This helps accessibility, too; when browser and assistive technology are reading a website, they go from top to bottom. If the code is well-formed this is much easier.

You already should be familiar with DOM — the Document Object Model — that you can access with JavaScript. When this structure is clear, everything becomes easier.

#### Progressive enhancement

Content (HTML) comes first. This then should be expanded by addition of CSS — to give it a better look. JavaScript should be added last to make sure that everything works even on weakest internet connections.

![Image: Treehouse blog](http://blog.teamtreehouse.com/wp-content/uploads/2014/11/progressive-enhancement.png)

### Rules of semantic html

#### Basic structure

> Elaborate on the basic structure of HTML document. Explain each element and how they're nested: from DOCTYPE to the ```<footer>```

```html
<!DOCTYPE html>
<html lang="en-GB">
  <head>
    <meta charset="utf-8">
    <title>My website</title>
  </head>
  <body>
    <header>
      <!-- Page title goes here -->
    </header>
    <nav>
      <!-- Navigation goes here -->
    </nav>
    <main>
      <section>
        <article>
          <!-- Article (content) goes here -->
        </article>
      </section>
    </main>
    <aside>
      <!-- Secondary navigation or additional modules go here -->
    </aside>
    <footer>
      <!-- Footer goes here -->
    </footer>
  </body>
</html>
```

#### Layout tags

Layout tags are a legacy from HTML4 and XHTML; they allow wrapping other elements for CSS styling.

##### Divisions

```html
<div>Any html element could go here</div>
```

##### Content 'spans'

```html
<a href="link.html"><span>This text is spanned</span></a>
```

#### Closer look at content tags

> Take students through the following:

##### Paragraphs and headings

```html
<h1>This is a heading of first level</h1>
<h2>This is second level heading</h2>
<h6>This is sixth level heading</h6>
<p>This is a paragraph and it contains some really boring copy.</p>
```

##### Images

With meaningful ```alt``` attribute:

```html
<img src="wojtek_the_bear.jpg" alt="Image of Wojtek the Bear" />
```

With empty ```alt``` attribute — used when for decorative purposes only, bypassed by screen readers:

```html
<img src="flowery_background.jpg" alt="" />
```

##### Links

```html
<a href="my_books.html" title="List of all my books">My books</a>
```

It is also possible to construct a local anchor (although this is not great for accessibility):

```html
<a name="top"></a>
<a href="#top>Back to the top of the page</a>
```

Make sure that links do not open in new windows, which is bad for accessibility (as the context changes unexpectedly). If you have to do this, always warn the user about it.

It is very important to keep links's labels **meaningful**.

##### Tables

Tables need to be very well formed — otherwise they're quickly becoming inaccessible.

Tables should be used to store tabular data and **not used for** layout.

```html
<table>
	<caption>Types of fruit with their colours </caption>
	<thead>
	<tr>
		<th scope="col">Name</th>
		<th scope="col">Colour</th>
	</tr>
	</thead>
	<tr>
		<td>Apple</td>
		<td>Green</td>
	</tr>
	<tr>
		<td>Banana</td>
		<td>Yellow</td>
	</tr>		
	<tr>
		<td>Raspberry</td>
		<td>Red</td>
	</tr>
</table>
```

##### Lists

There are two main types of lists: ordered and unordered lists. You will be using lists often for navigation on the page.

```html
<ul>
	<li>Ruby</li>
	<li>Python</li>
	<li>Java</li>
</ul>
```

Ordered lists should be used when there is a definite number of items and they come in, well, particular order.

```html
<ol>
	<li>Ruby</li>
	<li>Python<li>
	<li>Java</li>
</ol>
```

It's possible to nest lists. This is often used for navigation.

```html
<ul>
	<li>Ruby</li>
	<li>Python>
	<li>
		<ul>
			<li>HTML</li>
			<li>CSS</li>
		</ul>
	</li>
	<li>Java</li>
</ul>
```

#### Forms

Forms are used to obtain user input. It's worth remembering that forms can be efficient and fast or, when badly designed, cumbersome and frustrating! 

> Show different forms and go through them to explain what they do. Remember the relationships between labels and the ```name``` attribute.

##### Basic form with one input and a button

```html
<form>
	<label for="yourName">Your name</label>
	<input type="text" id="yourName" name="yourName" placeholder="Enter your name" />
	<button type="submit">Save your name</button>
</form>
```

##### Form with a fieldset and different inputs

```html
<form>
	<fieldset>
		<legend>Your details</legend>
		<label for="yourName">Your name</label>
		<input type="text" id="yourName" name="yourName" placeholder="Enter your name" />
		<label for="yourEmail">Your email address</label>
		<input type="email" id="yourEmail" name="yourEmail" placeholder="Enter your email address" />		
	</fieldset>
	<fieldset>
		<legend>Password settings</legend>
		<label for="yourPassword">Set your password</label>
		<input type="password" name="yourPassword" id="yourPassword" />
	</fieldset>
</form>
```

##### Selects and options

```html
<form>
	<select id="fruit" name="fruit">
		<option value="apple">Apple</option>
		<option value="orange">Orange</option>
		<option value="raspberry">Raspberry</option>
	</select>
</form>
```

##### Checkboxes and options

The difference between checkboxes and radio buttons allows us to choose more than one or just one element from the list of choice.

It's good to enclose checkboxes and radio buttons in a ```<legend>``` for easier processing.

```html
<form>
	<fieldset>
		<legend>Choose fruit</legend>
		<label for="fruit1">I like apples</label>
	   <input type="checkbox" id="fruit1" name="apples" value="1" />
	   	<label for="fruit2">I like oranges</label>
	   <input type="checkbox" id="fruit2" name="oranges" value="2" />   
	</fieldset>
		<fieldset>
		<legend>Choose one fish</legend>
		<label for="fish1">I like tuna</label>
	   <input type="radio" id="fish1" name="tuna" value="tuna" />
	   	<label for="fish2">I like sardines</label>
	   <input type="radio" id="fish2" name="sardines" value="sardines" />   
	</fieldset>
</form>
```

##### Special input types of HTML5

There are many special types of input for HTML5. It's worth remembering that unless you declare a proper DOCTYPE these might work. These types of inputs can also cause problems for older browsers.

```html
<form>
	<label for="yourFile">Choose a file</label>
	<input type="file" id="yourFile" name="yourFile" />
</form>
```

Other types:

1. color
2. date
3. datetime
4. datetime-local
5. email
6. hidden
7. image
8. month
9. number
10. password
11. range
12. reset
13. search
14. tel
15. url
16. week

The full list is available at [The Mozilla Foundation Website](https://developer.mozilla.org/en/docs/Web/HTML/Element/input)

## CSS - Cascading Style Sheets

> We will explain basic CSS only.

### Intro

CSS control the layout (look and feel) of the HTML. These are kept in special files called stylesheets (with .css extension). To use CSS with html, a stylesheet has to be attached to the document. 

```html
<!DOCTYPE html>
<html lang="en-GB">
  <head>
    <meta charset="utf-8">
    <title>My website</title>
   	<link href="styles.css" type="text/css" />
  </head>
  <body>
  </body>
</html>
```

CSS is cascading. This means that attributes (or rules) of HTML elements can be shared between different elements and affect the nested ones. Consider this:

```css
body	{
	color: black;
}
p	a	{
	color: blue;
}
```

This example would set the text of all body elements to black — but all links (```<a>```) within each paragraph (```<p>```) would be blue.

This is very powerful, but you need to be aware of this as it can also create problems when rules of CSS are overwritten accidentaly.

### Addressing HTML elements

CSS properties are defined in selectors. There are three main types of selectors that allow us to address HTML elements within the DOM. Generally speaking, properties are split into two main types:

1. Presentation properties: fonts, colours, backgrounds, borders, type-related 
2. 	Size and positioning properties: margins, paddings, flexbox, positions, width, height.

> Point students at the list of CSS properties.

[CSS properties](https://developer.mozilla.org/en-US/docs/Web/CSS/Reference). 


#### Type selectors

```css
p	{
	color: #000;
}
a	{
	color: #0000ff;
```

These can be nested, too. This one would address all ```<a>``` elements inside paragraphs but not elsewhere. This is called the 'descendant selector':

```css
body p a	{
	color: #0000ff;
}
```

#### Class selectors

These are reserved for styling of HTML elements that occur more than once and have distinct properties. In other words, a document can have multiple elements that are addressed by different classes. And so:

```html
<p class="yellow">This text is yellow</p>
<p class="green">This text is yellow</p>
```

```css
p	{
	font-size: 1.2em;
}
.yellow	{
	color: #ffff00;
}
.green	{
	color: #00ff00;
}
```

Note that the same could be achieved by using:

```css
p.yellow	{
	color: #ffff00;
}
p.green	{
	color: #00ff00;
}
```

However, this time these selectors would target classes **only** if these are applied to ```<p>``` elements.

#### ID selectors

ID's are very useful for elements that occur only once. This doesn't mean that they are used only once in the code but that they have **distinct** visual look. For example, the ```<body>``` tag doesn't have to have an ID (although it might), but if you have two  ```<section>``` tags that should look differently, an ID is a good choice. Thus:

```html
<p id="yellow">This text is yellow</p>
<p id="green">This text is yellow</p>
```

```css
p	{
	font-size: 1.2em;
}
#yellow	{
	color: #ffff00;
}
#green	{
	color: #00ff00;
}
```

#### Difference between ID and classes

ID's are unique — and classes are not. There should be only one element with a given ID in a document. Classes can be combined, too:

```html
<figure class="yellow dinosaurPicture largeFont">...</figure>
```

```css
.yellow	{
	color: #ffff00;
}
.dinosaurPicture	{
	background-image: url('dinosaur.jpg');
}
.largeFont	{
	font-size: 2em;
{
```

#### Other selectors

There are two other types of other selectors, universal and attribute selectors. Going through them would be too much for what we want to achieve, however it's worth [having a look at the list](https://developer.mozilla.org/en-US/docs/Web/CSS/CSS_Selectors).

#### Combinators

> Go for this if you have time only and if students still have some brain processing power.

Combinators can be used to select nodes that follow the selected element. There are four types of these:

1.	Adjacent sibling combinators: ```div + p``` — this will match any ```<p>``` that immediatelly follows a ```<div>```.
2. 	General sibling combinators: ```p ~ span``` —  will match all ```<span>``` elements that follow a ```<p>``` element inside the same element.
3. 	Child selectors: ```p > a``` would address all ```<a>``` elements inside paragraphs but nothing else.

### Positioning — the box model

Each single HTML element is enclosed in the so-called ['box model'](https://developer.mozilla.org/en-US/docs/Web/CSS/CSS_Box_Model/Introduction_to_the_CSS_box_model). 

This illustration from the CodeProject explains it all: ![Box model explanation](https://www.codeproject.com/KB/HTML/567385/boxmodel-image.png)

The properties used here are:

```css
div	{
	width: value;
	height: value;
	margin-top: value;
	margin-right: value;
	margin-bottom: value;
	margin-left: value;
	padding-top: value;
	padding-right: value;
	padding-bottom: value;
	padding-left: value;
}
```

This can be shortened to:

```css
div	{
	width: value;
	height: value;
	margin: value-top value-right value-bottom value-left;
	padding: value-top value-right value-bottom value-left;
}
```

Some elements of HTML are displayed as block (```display: block;```) whereas others are linear by nature, like ```<a>```. These can be displayed as blocks, too — all we have to is to use a special property.

```css
a.thisIsBlock	{
	display: block;
}
```

As you can see, this can have [many different values](https://developer.mozilla.org/en-US/docs/Web/CSS/display) and going through them all would take a lot of time... You're more than welcome to experiment! :)

### Special display model: flexbox

The flexbox property gives elements special 'fluid' width and height that adapt to the viewport. This is helpful, since we have to be displaying contents of our websites across multiple screen sizes (e.g. laptops and smartphones).

The flexbox concept is rather involved and would be hard to explain it in one lesson. However, we recommend reading [Using CSS Flexible Boxes on MDN](https://developer.mozilla.org/en-US/docs/Web/CSS/CSS_Flexible_Box_Layout/Using_CSS_flexible_boxes).

![illustration to flexbox](https://developer.mozilla.org/files/3739/flex_terms.png)

### On units

Traditionally, CSS used pixels. However, due to the fact that screen's pixel density (a number of pixels per inch of a physical screen) often varies between devices it's better to use the value of ```em``` or ```vh/vw``` - viewport height and viewport width.

And so:

```css
section	{
	width: 50vw;
	height: 50vh;
}
p	{
	font-size: 1em;
	margin: 1em 2em 1em 2em;
}
```

## Browser differences in rendering of HTML with CSS

Browsers display HTML and CSS differently. There is no standardisation and this causes many problems. That's why the concept of CSS reset — a special stylesheet resetting values of everything to 0 — has been developed. By attaching it to our documents we can ensure we're starting from scratch.

CSS reset files can be obtained from the [CSSreset.com website](http://cssreset.com).

## Wrap-up

1. 	Keep your code semantically correct by using HTML tags accordingly to their purpose.
2. 	Apply reset.css file before everything else.
2. 	Attach stylesheets to your sites only after the basic content is in place.
3. 	Remember about CSS cascading.
4. 	Use ```em``` for font sizes and ```vh/vw``` for viewport sizes.
5. 	Play with the block property and the flexbox (you can play the game of '[Flexbox froggy](http://flexboxfroggy.com)' that explains the concept. 
