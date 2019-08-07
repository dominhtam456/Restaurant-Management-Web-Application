var app = angular.module("myApp", ["ngRoute"]);
app.config(function($routeProvider) {
  $routeProvider
  .when("/", {
    templateUrl : "/examples/dashboard.html"
  })
  .when("/icons", {
    templateUrl : "/examples/dashboard.html"
  })
  .when("/tables", {
    templateUrl : "/examples/tables.html",
    controller : "ResourcesCtrl"
  })
});

app.controller('ResourcesCtrl', function($scope, $http) {
  $http.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';
  $scope.resources = [
                //{ Id: "SP000016", Name: "Lemon", type: "Water", price:"14.000", costprice:"8.000", inventory:"30" },
                //{ Id: "SP000017", Name: "Lemon", type: "Water", price:"14.000", costprice:"8.000", inventory:"30" },
                //{ Id: "SP000018", Name: "Lemon", type: "Water", price:"14.000", costprice:"8.000", inventory:"30" },
                //{ Id: "SP000019", Name: "Lemon", type: "Water", price:"14.000", costprice:"8.000", inventory:"30" }
                ];

  $scope.resourcesType = [
                //{ Id: 1, Name: "Thịt", Unit: "Kg"},
                //{ Id: 2, Name: "Cá", Unit: "Kg"},
                //{ Id: 3, Name: "Nước", Unit: "l"},
                //{ Id: 4, Name: "Rau", Unit: "Kg"}
                ];

  //Get resources
  $http({
    method : "GET",
    url : "http://localhost:8080/api/GetAllNguyenLieu"
  }).then(function mySuccess(response) {
      $scope.resources = response.data;
    },function myError(response) {
      $scope.resources = response.statusText;
  });

  //Get resources type
  $http({
    method : "GET",
    url : "http://localhost:8080/api/GetAllLoaiNguyenLieu"
  }).then(function mySuccess(response) {
      $scope.resourcesType = response.data;
    });

  //Add resources
  $scope.updateResources= function(){
        var data= $.param({
                    NGUYENLIEU_NO: $scope.resourcesDetails.nguyenlieu_NO,
                    NGUYENLIEU_NAME: $scope.resourcesDetails.nguyenlieu_NAME,
                    NGUYENLIEU_PRICE: $scope.resourcesDetails.nguyenlieu_PRICE,
                    NGUYENLIEU_ID: $scope.resourcesDetails.nguyenlieu_ID,
                    lOAINGUYENLIEU_LOAINGUYENLIEU_ID: $scope.resourcesDetails.loainguyenlieu_LOAINGUYENLIEU_ID

                });

        $http.post("http://localhost:8080/api/InsertNguyenLieu/",data)
          .then(function mySuccess(data) {
          });

      }

      $scope.addResources= function(){
            var data= $.param({
                        NGUYENLIEU_NO: $scope.resourcesNo,
                        NGUYENLIEU_NAME: $scope.inputName,
                        NGUYENLIEU_PRICE: $scope.inputPrice,
                        lOAINGUYENLIEU_LOAINGUYENLIEU_ID: $scope.TypeId,
                        NGUYENLIEU_DATE: '2019/09/01'
                    });

            $http.post("http://localhost:8080/api/InsertNguyenLieu/",data)
              .then(function mySuccess(data) {

              });

          }

  $scope.getResourcesIndex=function(resources){
    $http({
      method : "GET",
      url : "http://localhost:8080/api/NguyenLieu/" + resources.nguyenlieu_ID
    }).then(function mySuccess(response) {
        $scope.resourcesDetails = response.data;

      });

  };

  //Delete resources
  $scope.deleteResources= function(resources){
    var data= $.param({
                NGUYENLIEU_ID: resources.nguyenlieu_ID
            });
    $http.post("http://localhost:8080/api/NguyenLieu/" + resources.nguyenlieu_ID,data)
      .then(function mySuccess(response){
        alert("Xoa thanh cong");
      });
  }
});

app.controller('addResources', function($scope, $http) {


});
