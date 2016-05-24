(function(){
  "use strict";

  var express = require('express'),
      app = express(),
      port = process.env.PORT || 8080;

  app.use(express.static(__dirname + '/public'));
  app.use('/', function(req, resp){
    resp.sendFile(__dirname + '/public/index.html');
  });

  app.listen(port, function(){
    console.log('listening on port ' + port);
  });

})();
