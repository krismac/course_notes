const PubSub = {
  publish: function (channel, payload) {
    var event = new CustomEvent(channel, {
      detail: payload
  });
    document.dispatchEvent(event);
  },

  subscribe: function (channel, callback) {
    document.addEventListener(channel, callback);
  }
};

export default PubSub;
