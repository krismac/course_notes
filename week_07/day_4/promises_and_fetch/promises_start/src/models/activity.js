const Request = require('../helpers/request.js');
const PubSub = require('../helpers/pub_sub.js');

const Activity = function () {
  this.data = null;
};

Activity.prototype.bindEvents = function () {
  PubSub.subscribe('ActivityTypeFormView:activity-type-ready', (evt) => {    
    const activityType = evt.detail;
    this.getData(activityType);
  });
};

Activity.prototype.getData = function (activityType) {
const url = `https://www.boredapi.com/api/activity?type=${ activityType }`;
  const request = new Request(url);
  request.get((activity) => {
    this.data = activity;
    PubSub.publish('Activity:activity-ready', this.data);
  },
  (err) => {
    PubSub.publish('Activity:error', err);
  });
};

module.exports = Activity;
