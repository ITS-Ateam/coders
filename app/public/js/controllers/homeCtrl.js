(function(){
  "use strict";
  angular.module('ateam')
  .controller('homeCtrl', ['$scope', '$http', function($scope, $http){

    $scope.model = {};

    $scope.initModel = function() {
      alert('enters function');
    };

  }]);

})();
