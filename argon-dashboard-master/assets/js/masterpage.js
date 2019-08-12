var app = angular.module("myApp", ["ngRoute"]);
app.config(function($routeProvider) {
  $routeProvider
  .when("/", {
    templateUrl : "/examples/dashboard.html"
  })
  .when("/icons", {
    templateUrl : "/examples/dashboard.html"
  })
  .when("/foods", {
    templateUrl : "/examples/foods.html"
  })
  .when("/tables", {
    templateUrl : "/examples/tables.html",
    controller : "ResourcesCtrl"
  })
});

app.directive("ngFileSelect",function(){

  return {
    link: function($scope,el){

      el.bind("change", function(e){

        $scope.file = (e.srcElement || e.target).files[0];
        $scope.getFile();
      })

    }

  }
});

app.controller('ResourcesCtrl', function($scope, $http, $window ,$filter) {

  $scope.setFile = function(element) {
        $scope.$apply(function($scope) {
            $scope.theFile = element.files[0];
        });
    };
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
    $scope.test= function(){
      alert($scope.theFile.name);
    }
  //Add resources
  $scope.updateResources= function(){
        var data= $.param({
                    NGUYENLIEU_NO: $scope.resourcesDetails.nguyenlieu_NO,
                    NGUYENLIEU_NAME: $scope.resourcesDetails.nguyenlieu_NAME,
                    NGUYENLIEU_PRICE: $scope.resourcesDetails.nguyenlieu_PRICE,
                    NGUYENLIEU_ID: $scope.resourcesDetails.nguyenlieu_ID,
                    lOAINGUYENLIEU_LOAINGUYENLIEU_ID: $scope.resourcesDetails.loainguyenlieu_LOAINGUYENLIEU_ID,
                    NGUYENLIEU_DATE: $scope.resourcesDetails.nguyenlieu_DATE,
                    NGUYENLIEU_IMG: $scope.theFile.name
                });

        $http.post("http://localhost:8080/api/InsertNguyenLieu/",data)
          .then(function mySuccess(data) {
            $window.location.reload()
          });

      }

      $scope.addResources= function(){
            var data= $.param({
                        NGUYENLIEU_NO: $scope.resourcesNo,
                        NGUYENLIEU_NAME: $scope.inputName,
                        NGUYENLIEU_PRICE: $scope.inputPrice,
                        lOAINGUYENLIEU_LOAINGUYENLIEU_ID: $scope.TypeId,
                        NGUYENLIEU_DATE: $scope.inputDate,
                        NGUYENLIEU_IMG: $scope.theFile.name
                    });
                    var d=0
                    angular.forEach($scope.resources, function(rs) {
                      if(rs.nguyenlieu_NO == $scope.resourcesNo){
                        d=1;

                      }
                    });


            if(d==0){
            $http.post("http://localhost:8080/api/InsertNguyenLieu/",data)
              .then(function mySuccess(data) {
                $window.location.reload()
              });
            }
            else{
              alert("Mã nguyên liệu đã tồn tại");
            }
      }
  $scope.test=function(){

    alert(d);
  }
  $scope.getResourcesIndex=function(resources){
    $http({
      method : "GET",
      url : "http://localhost:8080/api/NguyenLieu/" + resources.nguyenlieu_ID
    }).then(function mySuccess(response) {
        $scope.resourcesDetails = response.data;
        $scope.resourcesDetails.loainguyenlieu_LOAINGUYENLIEU_ID=$scope.resourcesDetails.loainguyenlieu_LOAINGUYENLIEU_ID.toString();
        $scope.resourcesDetails.nguyenlieu_DATE=$filter("date")($scope.resourcesDetails.nguyenlieu_DATE, "yyyy-MM-dd");
      });



  };

  //Delete resources
  $scope.deleteResources= function(resources){
    var data= $.param({
                NGUYENLIEU_ID: resources.nguyenlieu_ID
            });
    $http.post("http://localhost:8080/api/NguyenLieu/" + resources.nguyenlieu_ID,data)
      .then(function mySuccess(response){
        alert("Bạn đã xóa nguyên liệu thành công");
        $window.location.reload()
      });
  }


});

app.controller('UploadController', function($scope , fileReader) {
  console.log(fileReader)
 $scope.getFile = function () {
     $scope.progress = 0;
     fileReader.readAsDataUrl($scope.file, $scope)
                   .then(function(result) {
                       $scope.imageSrc = result;
                   });
 };

    $scope.$on("fileProgress", function(e, progress) {
      $scope.progress = progress.loaded / progress.total;
    });
  });
