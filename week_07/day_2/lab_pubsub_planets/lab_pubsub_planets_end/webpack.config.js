const config = {
  entry: `${__dirname}/src/app.js`,
  output: {
    path: `${__dirname}/public/js`,
    filename: 'bundle.js',
  },
  mode: 'development',
};

module.exports = config;
