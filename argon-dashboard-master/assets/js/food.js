(function (module) {

module.controller('FoodsCtrl', function($scope, $http, $window ,$filter) {
  $scope.setFile = function(element) {
        $scope.$apply(function($scope) {
            $scope.theFile = element.files[0];
        });
    };
  $http.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';
  //Get foods
  $http({
    method : "GET",
    url : "http://localhost:8080/api//GetAllMonAn"
  }).then(function mySuccess(response) {
      $scope.foods = response.data;
    },function myError(response) {
      $scope.foods = response.statusText;
  });

  //Get foods type
  $http({
    method : "GET",
    url : "http://localhost:8080/api/GetAllLoaiMonAn"
  }).then(function mySuccess(response) {
      $scope.foodsType = response.data;

    });

    $scope.getFoodIndex=function(food){
      $http({
        method : "GET",
        url : "http://localhost:8080/api/MonAn/" + food.monan_ID
      }).then(function mySuccess(response) {
          $scope.foodDetails = response.data;
          $scope.foodDetails.loaimonan_LOAIMONAN_ID=  $scope.foodDetails.loaimonan_LOAIMONAN_ID.toString();
        });
    };
    $scope.addFood= function(){
          var data= $.param({
                      MONAN_NO: $scope.foodNo,
                      MONAN_NAME: $scope.inputName,
                      MONAN_PRICE: $scope.inputPrice,
                      LOAIMONAN_LOAIMONAN_ID: $scope.TypeId,
                      MONAN_IMG: $scope.theFile.name,
                      MONAN_UNIT: $scope.inputUnit
                  });
                  var d=0
                  angular.forEach($scope.foods, function(rs) {
                    if(rs.monan_NO == $scope.foodNo){
                      d=1;

                    }
                  });


          if(d==0){
          $http.post("http://localhost:8080/api/InsertMonAn/",data)
            .then(function mySuccess(data) {
              $window.location.reload()
            });
          }
          else{
            alert("Mã món ăn đã tồn tại");
          }
    }

});


}(angular.module("myApp")));
