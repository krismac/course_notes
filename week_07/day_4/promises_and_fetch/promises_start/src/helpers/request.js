const Request = function (url) {
  this.url = url;
};

Request.prototype.get = function (onComplete, onError) {
  const xhr = new XMLHttpRequest();
  xhr.open('GET', this.url);
  xhr.send();

  xhr.addEventListener('load', () => {
    if (xhr.status !== 200) {
      onError(xhr.status);
      return;
    }

    const jsonString = xhr.responseText;
    const data = JSON.parse(jsonString);
    onComplete(data);
  });
};

module.exports = Request;
