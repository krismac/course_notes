const RequestHelper = function (url) {
  this.url = url;
}

RequestHelper.prototype.get = function (onComplete) {
  const xhr = new XMLHttpRequest();
  xhr.open('GET', this.url);
  xhr.setRequestHeader('Accept', 'application/json');

  xhr.addEventListener('load', () => {
    if (xhr.status !== 200) {
      console.error('Request failed');
      return;
    }
    const jsonString = xhr.responseText;
    const data = JSON.parse(jsonString);
    onComplete(data);
  });
  xhr.send();
}

module.exports = RequestHelper;
