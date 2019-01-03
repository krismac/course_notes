const PubSub = require('../helpers/pub_sub.js');

const ActivityView = function (container) {
  this.container = container;
};

ActivityView.prototype.bindEvents = function () {
  PubSub.subscribe('Activity:activity-ready', (evt) => {
    const activity = evt.detail;
    this.render(activity);
  });
};

ActivityView.prototype.render = function (data) {
  this.container.innerHTML = '';
  const activityName = document.createElement('p');
  activityName.textContent = data.activity || data.error;
  this.container.appendChild(activityName);
};

module.exports = ActivityView;
