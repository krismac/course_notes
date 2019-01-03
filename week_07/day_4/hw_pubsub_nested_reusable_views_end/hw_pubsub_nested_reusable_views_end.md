# Pub/Sub with Nested Reusable Views Homework

## Solutions

### Application Architecture

![Event and data flow](images/continents_of_the_world_data_flow_diagram.png)
*Pub/Sub event and data flow through the app*

### Application Views

![Rendering Responsibilities](images/continents_of_the_world_view_render_responsibilties.png)
*Hierarchy of responsibilities for view rendering*

![Structure of the web page](images/continents_of_the_world_page_structure.png)
*Structure of the web page*

Which view is rendered more than once on the page?
<details>
<summary>Answer:</summary>

`ContinentView` - One `ContinentView` is rendered for each continent.

</details>


Which views are nested in which other view?
<details>
<summary>Answer</summary>

- The `ContinentView`s are nested in `ContinentsListView`.

</details>

What is the benefit of nesting views in this way?
<details>
<summary>Answer</summary>

By nesting views we can maintain modularity in our front-end code, where each view is responsible for rendering one section of the page. The tree-like structure that it produces is easy to reason about.

</details>

What is the benefits of reusing views in this way?
<details>
<summary>Answer</summary>

By creating generic views that can be populated for each item keeps the code DRY and maintainable.

</details>

## Conclusion

As our applications grow in size we can use nested reusable views with the Pub/Sub pattern to keep our applications modular, each view having the responsibility of rendering one section of the page. This makes our applications ease to reason about and our code DRY.
