const express = require('express');
const app = express();

app.use(express.static('client/public'));

app.listen(3000, function () {
  console.log(`App running on port ${ this.address().port }`);
});
