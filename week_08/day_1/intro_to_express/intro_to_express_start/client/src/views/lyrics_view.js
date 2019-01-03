const LyricsView = function (container) {
  this.container = container;
}

LyricsView.prototype.render = function (lyrics) {
  this.container.innerHTML = '';
  this.container.innerText = lyrics;
}

module.exports = LyricsView;
