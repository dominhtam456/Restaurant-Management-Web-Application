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
    url : "http://localhost:8080/api/GetAllMonAn"
  }).then(function mySuccess(response) {

      $scope.searched = response.data;
    },function myError(response) {
      $scope.searched = response.statusText;
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
                      lOAIMONAN_LOAIMONAN_ID: $scope.TypeId,
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

    $scope.updateFood= function(){
      var foodIMG="";
        if(angular.isDefined($scope.theFile)){
          foodIMG=$scope.theFile.name;
        }
        else{
          foodIMG=$scope.foodDetails.monan_IMG;
        }
          var data= $.param({
                      MONAN_NO: $scope.foodDetails.monan_NO,
                      MONAN_NAME: $scope.foodDetails.monan_NAME,
                      MONAN_PRICE: $scope.foodDetails.monan_PRICE,
                      lOAIMONAN_LOAIMONAN_ID: $scope.foodDetails.loaimonan_LOAIMONAN_ID,
                      MONAN_IMG: foodIMG,
                      MONAN_ID: $scope.foodDetails.monan_ID

                  });

          $http.post("http://localhost:8080/api/InsertMonAn/",data)
            .then(function mySuccess(data) {
              $window.location.reload()
            });

        }


        $scope.deleteFood= function(food){
          var data= $.param({
                      MONAN_ID: food.monan_ID
                  });
          $http.post("http://localhost:8080/api/MonAn/" + food.monan_ID,data)
            .then(function mySuccess(response){
              alert("Bạn đã xóa nguyên liệu thành công");
              $window.location.reload()
            });
        }

        $scope.findFoods= function(key){
          if(key!="" && key!= null){
          $http({
            method : "GET",
            url : "http://localhost:8080/api/SearchFoods/" + key
          }).then(function mySuccess(response) {
              $scope.searched = response.data;
            },function myError(response) {
              $scope.searched = response.statusText;
          });
        }
        else{
          $http({
            method : "GET",
            url : "http://localhost:8080/api/GetAllMonAn"
          }).then(function mySuccess(response) {
              $scope.searched = response.data;
            },function myError(response) {
              $scope.searched = response.statusText;
          });
        }
      }

      //add food type

      $scope.AddTypeFood= function(){
          var data=$.param({
            lOAIMONAN_NAME: $scope.loaiMonAn
          });

          $http.post("http://localhost:8080/api/InsertLoaiMonAn/",data)
            .then(function mySuccess(data) {
              $window.location.reload()
          });
      }
});


}(angular.module("myApp")));
