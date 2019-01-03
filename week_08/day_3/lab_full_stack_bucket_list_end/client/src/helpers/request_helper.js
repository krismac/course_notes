const RequestHelper = function(url) {
  this.url = url;
};

RequestHelper.prototype.get = function(urlParam) {
  const url = urlParam ? `${this.url}/${urlParam}` : this.url;
  return fetch(url)
    .then((response) => response.json())
    .catch((err) => console.error(err));
};

RequestHelper.prototype.post = function(payload, urlParam) {
  const url = urlParam ? `${this.url}/${urlParam}` : this.url;
  return fetch(url, {
    method: 'POST',
    body: JSON.stringify(payload),
    headers: { 'Content-Type': 'application/json' }
  })
    .then((response) => response.json())
    .catch((err) => console.error(err));
};

RequestHelper.prototype.put = function(payload, urlParam) {
  const url = urlParam ? `${this.url}/${urlParam}` : this.url;
  return fetch(url, {
    method: 'PUT',
    body: JSON.stringify(payload),
    headers: { 'Content-Type': 'application/json' }
  })
    .then((response) => response.json())
    .catch((err) => console.error(err));
};

RequestHelper.prototype.delete = function(urlParam) {
  const url = urlParam ? `${this.url}/${urlParam}` : this.url;
  return fetch(url, { method: 'DELETE' })
    .then((response) => response.json())
    .catch((err) => console.error(err));
};

module.exports = Request;
