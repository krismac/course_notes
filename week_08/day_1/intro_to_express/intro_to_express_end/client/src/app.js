const FormView = require('./views/form_view.js');
const LyricsView = require('./views/lyrics_view.js');
const PubSub = require('./helpers/pub_sub.js');

document.addEventListener('DOMContentLoaded', function () {
  const form = document.querySelector('form');
  const formView = new FormView(form);
  formView.bindListeners();

  const lyricsContainer = document.querySelector('#lyrics-container');
  const lyricsView = new LyricsView(lyricsContainer);

  PubSub.subscribe('FormView:request-complete', (event) => {
    lyricsView.render(event.detail);
  });
});
