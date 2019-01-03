# CSS Flexbox Grid

### Learning Outcomes

- Build a CSS grid with Flexbox

## Intro

One of the most useful things we can do with CSS is build a grid system for our web app.

Flexbox is a relatively new feature of CSS which makes this easier than before.

Let's build one so you have a reference for future projects.

First let's create the files.

```bash
#terminal

mkdir flexbox_grid
cd flexbox_grid
touch style.css index.html
```

Open index.html and type html and tab. Sublime will create boiler-plate html. Let's add the markdown for our grid.

We'll show how flexible it is by having a row of 2, 3 and 4 cells. 

Remember to link to our stylesheet!

```html
<!-- index.html -->

<link rel="stylesheet" type="text/css" href="style.css">
```


```html
<!-- index.html -->

<div class="grid">
  <div class="grid-row">
    <div class="cell">1</div>
    <div class="cell">2</div>
  </div>
  <div class="grid-row">
    <div class="cell">1</div>
    <div class="cell">2</div>
    <div class="cell">3</div>
  </div>
  <div class="grid-row">
    <div class="cell">1</div>
    <div class="cell">2</div>
    <div class="cell">3</div>
    <div class="cell">4</div>
  </div>
</div>
```

Let's go to our stylesheet now and give our grid a border so we can see it.

```css
/*style.css*/

.grid {
  border: solid 1px mediumaquamarine; //FUN COLOUR!
}

```

Now let's add the magic!

```css
/*style.css*/

.grid-row {
  display: flex;
  flex-direction: row;
}

.cell {
  flex: 1;
  padding: 10px;
  border: solid 1px mediumaquamarine;
}
```

Voila! A nice grid layout, easy to manage. 

## Making it responsive

We need to add another class to each row to make it responsive.

```html
<!-- index.html -->

<div class="grid">
  <div class="grid-row grid-row-sm">
    <div class="cell">1</div>
    <div class="cell">2</div>
  </div>
  <div class="grid-row grid-row-md">
    <div class="cell">1</div>
    <div class="cell">2</div>
    <div class="cell">3</div>
  </div>
  <div class="grid-row grid-row-lg">
    <div class="cell">1</div>
    <div class="cell">2</div>
    <div class="cell">3</div>
    <div class="cell">4</div>
  </div>
</div>

```

Now we need to add these classes in our CSS as media queries. 

```css
/*style.css*/

@media all and ( min-width: 480px ) {

  .grid-row-sm {
    flex-direction: row;
  }

}

@media all and ( min-width: 720px ) {

  .grid-row-md {
    flex-direction: row;
  }

}

@media all and ( min-width: 960px ) {

  .grid-row-lg {
    flex-direction: row;
  }

}
```

And we need to alter the flex direction 

```css
/*style.css*/

.grid-row {
  display: flex;
  flex-direction: column; //MODIFIED
}

```
