(function(module) {

  module.controller('TablesCtrl', function($scope, $http, $window, $filter) {
    //$http.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';
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

    $scope.tableIndex = "";
    $scope.getTable = function(table) {
      var id = "";
      $scope.tableIndex = table.ban_ID;
      $http({
        method: "GET",
        url: "http://localhost:8080/api/GetHoaDonToStatus/false"
      }).then(function mySuccess(response) {
        $scope.hdidctt = response.data;
        angular.forEach($scope.hdidctt, function(k) {
          if (k.ban_BAN_ID == $scope.tableIndex) {
            id = k.hoadon_ID;
          }
        });
        if(id != null && id != ""){
        $http({
          method: "GET",
          url: "http://localhost:8080/api/GetHDCTByID/" + id
        }).then(function mySuccess(response) {
          $scope.total=0;
          $scope.details = response.data;
          angular.forEach($scope.details, function(k) {
            $scope.total = $scope.total + (k.hoadonchitiet_PRICE * k.hoadonchitiet_SOLUONG);
            $http({
              method: "GET",
              url: "http://localhost:8080/api/MonAn/" + k.hoadonchitietID.monan_MONAN_ID
            }).then(function mySuccess(response) {
              k.monan_NAME = response.data.monan_NAME;
            }, function myError(response) {
              $scope.foods = response.statusText;
            });
          });
        }, function myError(response) {
          $scope.details = response.statusText;
        });
      }
      else{
        $scope.details="";
      }
      });
    };

    $http({
      method: "GET",
      url: "http://localhost:8080/api/GetAllBan"
    }).then(function mySuccess(response) {
      $scope.tablesArray = response.data;

      $scope.addFood = function(food) {
        var d = 0;
        var id = "";
        $http({
          method: "GET",
          url: "http://localhost:8080/api/GetHoaDonToStatus/false"
        }).then(function mySuccess(response) {
          $scope.ban = response.data;
          angular.forEach($scope.ban, function(k) {
            if (k.ban_BAN_ID == $scope.tableIndex) {
              d = 1;
              id=k.hoadon_ID;
            }
          });
          if (d == 0) {
            var data = {
              "hoadon_STATUS": false,
              "hoadon_DATE": "2019-04-04",
              "ban_BAN_ID": $scope.tableIndex,
              "hoadon_TAX": null,
              "nhanvien_NHANVIEN_ID": 1,
              "khachhang_KHACHHANG_ID": 1
            };
            console.log(JSON.stringify(data));
            $http({
                method: 'POST',
                url: 'http://localhost:8080/api/InsertHoaDon',
                data: JSON.stringify(data),
                headers: {
                  "Content-Type": "application/json; charset=UTF-8"
                },
              })
              .then(function mySuccess(response) {
                    $scope.idhd=response.data.hoadon_ID;
                    $scope.foodDetail = {
                      "hoadonchitietID": {
                        "hoadon_HOADON_ID": response.data.hoadon_ID,
                        "monan_MONAN_ID": food.monan_ID
                      },
                      "hoadonchitiet_PRICE": food.monan_PRICE,
                      "hoadonchitiet_SOLUONG": 1
                    };

                    console.log(JSON.stringify($scope.foodDetail));
                    $http({
                        method: 'POST',
                        url: 'http://localhost:8080/api/InsertHoaDonChiTiet',
                        data: JSON.stringify($scope.foodDetail),
                        headers: {
                          "Content-Type": "application/json; charset=UTF-8"
                        },
                      })
                      .then(function successCallback(response) {
                        $http({
                          method: "GET",
                          url: "http://localhost:8080/api/GetHDCTByID/" +$scope.idhd
                        }).then(function mySuccess(response) {
                          $scope.details = response.data;
                          $scope.total=0;
                          angular.forEach($scope.details, function(k) {
                            $scope.total = $scope.total + (k.hoadonchitiet_PRICE * k.hoadonchitiet_SOLUONG);
                            $http({
                              method: "GET",
                              url: "http://localhost:8080/api/MonAn/" + k.hoadonchitietID.monan_MONAN_ID
                            }).then(function mySuccess(response) {
                              k.monan_NAME = response.data.monan_NAME;
                            }, function myError(response) {
                              $scope.foods = response.statusText;
                            });
                          });

                        }, function myError(response) {
                          $scope.details = response.statusText;
                        });
                      });
              }, function myError(response) {
                $scope.tablesArray = response.statusText;
              });
          }
          else{
                    $scope.foodDetail = {
                      "hoadonchitietID": {
                        "hoadon_HOADON_ID": id,
                        "monan_MONAN_ID": food.monan_ID
                      },
                      "hoadonchitiet_PRICE": food.monan_PRICE,
                      "hoadonchitiet_SOLUONG": 1
                    };

                    console.log(JSON.stringify($scope.foodDetail));
                    $http({
                        method: 'POST',
                        url: 'http://localhost:8080/api/InsertHoaDonChiTiet',
                        data: JSON.stringify($scope.foodDetail),
                        headers: {
                          "Content-Type": "application/json; charset=UTF-8"
                        },
                      })
                      .then(function successCallback(response) {
                        $http({
                          method: "GET",
                          url: "http://localhost:8080/api/GetHDCTByID/" + id
                        }).then(function mySuccess(response) {
                          $scope.details = response.data;
                          $scope.total=0;
                          angular.forEach($scope.details, function(k) {
                            $scope.total = $scope.total + (k.hoadonchitiet_PRICE * k.hoadonchitiet_SOLUONG);
                            $http({
                              method: "GET",
                              url: "http://localhost:8080/api/MonAn/" + k.hoadonchitietID.monan_MONAN_ID
                            }).then(function mySuccess(response) {
                              k.monan_NAME = response.data.monan_NAME;
                            }, function myError(response) {
                              $scope.foods = response.statusText;
                            });
                          });
                        }, function myError(response) {
                          $scope.details = response.statusText;
                        });
                      });
          }
        });
      };
    $scope.changeAmount= function(detail){
      $scope.foodDetail = {
        "hoadonchitietID": {
          "hoadon_HOADON_ID": detail.hoadonchitietID.hoadon_HOADON_ID,
          "monan_MONAN_ID": detail.hoadonchitietID.monan_MONAN_ID
        },
        "hoadonchitiet_PRICE": detail.hoadonchitiet_PRICE,
        "hoadonchitiet_SOLUONG": detail.hoadonchitiet_SOLUONG
      };

      console.log(JSON.stringify($scope.foodDetail));
      $http({
          method: 'POST',
          url: 'http://localhost:8080/api/InsertHoaDonChiTiet',
          data: JSON.stringify($scope.foodDetail),
          headers: {
            "Content-Type": "application/json; charset=UTF-8"
          },
        })
        .then(function successCallback(response) {
          $http({
            method: "GET",
            url: "http://localhost:8080/api/GetHDCTByID/" + response.data.hoadonchitietID.hoadon_HOADON_ID
          }).then(function mySuccess(response) {
            $scope.total=0;
            $scope.details = response.data;
            angular.forEach($scope.details, function(k) {
              $scope.total = $scope.total + (k.hoadonchitiet_PRICE * k.hoadonchitiet_SOLUONG);
              $http({
                method: "GET",
                url: "http://localhost:8080/api/MonAn/" + k.hoadonchitietID.monan_MONAN_ID
              }).then(function mySuccess(response) {
                k.monan_NAME = response.data.monan_NAME;
              }, function myError(response) {
                $scope.foods = response.statusText;
              });
            });
          }, function myError(response) {
            $scope.details = response.statusText;
          });
        });
    }


    $scope.payBill=function(){
      var id="";
      $http({
        method: "GET",
        url: "http://localhost:8080/api/GetHoaDonToStatus/false"
      }).then(function mySuccess(response) {
        $scope.hdidctt = response.data;
        angular.forEach($scope.hdidctt, function(k) {
          if (k.ban_BAN_ID == $scope.tableIndex) {
            id = k.hoadon_ID;
          }
        });
        if(id != null && id != ""){
          $http({
            method: "GET",
            url: "http://localhost:8080/api/HoaDon/" + id
          }).then(function mySuccess(data) {
            var data = {
              "hoadon_ID": id,
              "hoadon_STATUS": true
            };
            console.log(JSON.stringify(data));
            $http({
                method: 'POST',
                url: 'http://localhost:8080/api/UpdateHoaDon',
                data: JSON.stringify(data),
                headers: {
                  "Content-Type": "application/json; charset=UTF-8"
                },
              })
              .then(function mySuccess(response) {
                alert("Thanh toán thành công");
                $window.location.reload();
              });
          });

        }
      });
    }

    $scope.delete= function(food){
      $http({
        method: "GET",
        url: "http://localhost:8080/api/DeleteHoaDonChiTiet/" + food.hoadonchitietID.hoadon_HOADON_ID + "&" + food.hoadonchitietID.monan_MONAN_ID
      }).then(function mySuccess(response) {
      });
    }



    });
  });
  // $scope.deleteFood = function(x) {
  //   angular.forEach($scope.array, function(k) {
  //     if (k.IdBan == $scope.tableIndex) {
  //       k.value.splice(x, 1);
  //     }
  //   });
  //
  //
  // };

}(angular.module("myApp")));
