const PubSub = {
  publish: function (channel, payload) {
    console.log(`Publishing ${payload} on ${channel}`);
    const event = new CustomEvent(channel, {
      detail: payload
    });
    document.dispatchEvent(event);
  },

  subscribe: function (channel, callback) {
    document.addEventListener(channel, callback);
  }
};

module.exports = PubSub;
