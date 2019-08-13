(function(module) {

  module.controller('TablesCtrl', function($scope, $http, $window, $filter) {
    $http.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';
    //Get tables
    $http({
      method: "GET",
      url: "http://localhost:8080/api/GetAllBan"
    }).then(function mySuccess(response) {
      $scope.tables = response.data;
    }, function myError(response) {
      $scope.tables = response.statusText;
    });

    //Get foods
    $http({
      method : "GET",
      url : "http://localhost:8080/api/GetAllMonAn"
    }).then(function mySuccess(response) {
        $scope.foods = response.data;
      },function myError(response) {
        $scope.foods = response.statusText;
    });
  });
}(angular.module("myApp")));
