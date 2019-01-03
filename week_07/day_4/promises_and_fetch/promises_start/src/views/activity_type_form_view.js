const PubSub = require('../helpers/pub_sub.js');

const ActivityTypeFormView = function (formElement) {
  this.formElement = formElement;
};

ActivityTypeFormView.prototype.bindEvents = function () {
  this.formElement.addEventListener('submit', (evt) => {
    evt.preventDefault();
    const activityType = evt.target['activity-type'].value;
    PubSub.publish('ActivityTypeFormView:activity-type-ready', activityType);
    evt.target.reset();
  });
};

module.exports = ActivityTypeFormView;
