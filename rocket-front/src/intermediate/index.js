const express = require('express');
const path = require('path');
const logger = require('morgan');
const webpack = require('webpack');

// 引入history模块
// import history from 'connect-history-api-fallback'

// 正式环境时，下面两个模块不需要引入
const webpackDevMiddleware = require('webpack-dev-middleware');
const webpackHotMiddleware = require('webpack-hot-middleware');

const config = require('../../build/webpack.dev.conf');

const proxy = require('express-http-proxy');//引入代理模块

const app = express();

// 引入history模式让浏览器进行前端路由页面跳转

// uncomment after placing your favicon in /public
app.use(logger('dev'));
app.use(express.json());
app.use(express.urlencoded({extended: false}));
app.use(express.static(path.join(__dirname, 'public')));

const compiler = webpack(config);
//webpack 中间件
app.use(webpackDevMiddleware(compiler, {
  publicPath: config.output.publicPath,
  stats: {colors: true}
}));

app.use(webpackHotMiddleware(compiler));

app.use(express.static(path.join(__dirname, 'views')));
app.get('/', function (req, res) {
  res.sendFile('./views/index.html')
});

/**
 *以下两步对所有异步请求均代理到http://10.100.9.104:8080,比如浏览器发的请求地址为：
 * http://10.100.9.104:3000/orgs/100,则代理地址为http:10.100.9.104:8080/orgs/100（注：10.100.9.104为node部署机器ip）
 */
app.use('/', proxy('localhost:8000'));

// catch 404 and forward to error handler
app.use(function (req, res, next) {
  let err = new Error('Not Found');
  err.status = 404;
  next(err)
});

// error handler
app.use(function (err, req, res, next) {
  res.status(err.status || 500);
  console.log(err);
  res.send(err.message)
});

// 设置监听端口
const SERVER_PORT = 3000;
app.listen(SERVER_PORT, () => {
  console.info(`服务已经启动，监听端口${SERVER_PORT}`)
});


module.exports = app;
