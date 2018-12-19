var express = require('express');
var proxy = require('http-proxy-middleware');
var rocket = express();

rocket.use(express.static('static'));

/**
 *以下两步对所有异步请求均代理到http://10.100.9.104:8080,比如浏览器发的请求地址为：
 * http://10.100.9.104:3000/orgs/100,则代理地址为http:10.100.9.104:8000/orgs/100（注：10.100.9.104为node部署机器ip）
 */
var apiProxy = proxy('/', {target: 'http://10.100.9.104:8080', changeOrigin: true});

rocket.use('/', apiProxy);

rocket.get('/index.htm', function (req, res) {
    res.sendFile(__dirname + '/src/index.html');
});

rocket.listen(3000, () => {
    console.log('Listening on: http://localhost:3000');
});