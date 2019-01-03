const Activity = require('./models/activity.js');
const ActivityTypeFormView = require('./views/activity_type_form_view.js');
const ActivityView = require('./views/activity_view.js');
const ErrorView = require('./views/error_view.js');

document.addEventListener('DOMContentLoaded', () => {
  const activity = new Activity();
  activity.bindEvents();

  const activityTypeForm = document.querySelector('form#activity-type-form');
  const activityTypeFormView = new ActivityTypeFormView(activityTypeForm);
  activityTypeFormView.bindEvents();

  const activityContainer = document.querySelector('#activity-container');
  const activityView = new ActivityView(activityContainer);
  activityView.bindEvents();

  const errorView = new ErrorView(activityContainer);
  errorView.bindEvents();
});
