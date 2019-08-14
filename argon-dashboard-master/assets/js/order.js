(function(module) {

  module.controller('TablesCtrl', function($scope, $http, $window, $filter) {
    $http.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';
    //Get tables
    $scope.array = [];
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
      method: "GET",
      url: "http://localhost:8080/api/GetAllMonAn"
    }).then(function mySuccess(response) {
      $scope.foods = response.data;
    }, function myError(response) {
      $scope.foods = response.statusText;
    });
    /*
    [
    {
        "IdBan" : "",
        "value" : [
          {
            "toan" : "Môn Toán",
            "anh" : "Môn Anh"
          },
          {
            "toan" : "Môn Toán",
            "anh" : "Môn Anh"
          }
        ]
    }
    */



    //$scope.array.push($scope.data);
    //$scope.array[0].value[0].toan
    $scope.tableIndex = "";
    $scope.getTable = function(table) {
      $scope.tableIndex = table.ban_ID;
    };

    $http({
      method: "GET",
      url: "http://localhost:8080/api/GetAllBan"
    }).then(function mySuccess(response) {
      $scope.tablesArray = response.data;

      angular.forEach($scope.tablesArray, function(k) {
        $scope.dataTable = {
          "IdBan": k.ban_ID,
          "value": []
        };
        $scope.array.push($scope.dataTable);
      })
      $scope.addFood = function(food) {

        $scope.data = {
          "foodName": food.monan_NAME,
          "foodID": food.monan_ID,
          "foodPrice": food.monan_PRICE
        }
        var d = 0;
        angular.forEach($scope.array, function(k) {
          if (k.IdBan == $scope.tableIndex) {
            d = d + 1;
            k.value.push($scope.data);

          }
        })

      };


    }, function myError(response) {
      $scope.tablesArray = response.statusText;
    });

    $scope.deleteFood = function(x) {
      angular.forEach($scope.array, function(k) {
        if (k.IdBan == $scope.tableIndex) {
          k.value.splice(x, 1);
        }
      })


    };





  });
}(angular.module("myApp")));
