var createError = require('http-errors');
var express = require('express');
var path = require('path');
var cookieParser = require('cookie-parser');
var logger = require('morgan');

var indexRouter = require('./routes/index');
var usersRouter = require('./routes/users');
var proxy = require('http-proxy-middleware');//引入代理模块

var app = express();

// view engine setup
app.set('views', path.join(__dirname, 'views'));
app.set('view engine', 'jade');

app.use(logger('dev'));
app.use(express.json());
app.use(express.urlencoded({ extended: false }));
app.use(cookieParser());
app.use(express.static(path.join(__dirname, 'public')));

app.use('/', indexRouter);
app.use('/users', usersRouter);

/**
 *以下两步对所有异步请求均代理到http://10.100.9.104:8080,比如浏览器发的请求地址为：
 * http://10.100.9.104:3000/orgs/100,则代理地址为http:10.100.9.104:8000/orgs/100（注：10.100.9.104为node部署机器ip）
 */
var apiProxy = proxy('/', {target: 'http://10.100.9.104:8080', changeOrigin: true});

app.use('/', apiProxy);


// catch 404 and forward to error handler
app.use(function(req, res, next) {
  next(createError(404));
});

// error handler
app.use(function(err, req, res, next) {
  // set locals, only providing error in development
  res.locals.message = err.message;
  res.locals.error = req.app.get('env') === 'development' ? err : {};

  // render the error page
  res.status(err.status || 500);
  res.render('error');
});

module.exports = app;
