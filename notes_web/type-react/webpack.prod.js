const { merge } = require('webpack-merge');
const common = require('./webpack.common.js');
const DuplicatePackageCheckerPlugin = require("duplicate-package-checker-webpack-plugin");

module.exports = merge(common, {
    mode: 'production',
    plugins: [
        new DuplicatePackageCheckerPlugin()
    ],
});