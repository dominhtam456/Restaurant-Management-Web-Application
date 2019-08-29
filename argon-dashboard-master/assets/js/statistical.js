(function (module) {

  module.controller('StatisticalCtrl', function($scope, $http, $window ,$filter) {

    $scope.View= function(){
      $scope.eDate=$scope.inputEndDate;
      $scope.sDate=$scope.inputStartDate;

      $scope.sDate=$filter('date')($scope.sDate, 'yyyy-MM-dd');
      $scope.eDate=$filter('date')($scope.eDate, 'yyyy-MM-dd');

      if($scope.radio=='topFoods'){

        $http({
          method : "GET",
          url : "http://localhost:8080/api/ThongKeMonAn/?fromDate=" + $scope.sDate + "&toDate=" + $scope.eDate
        }).then(function mySuccess(response) {
          $scope.listTopFoods=response.data;
          console.log($scope.listTopFoods);
        });

      }

      if($scope.radio=='listBill'){
        $http({
          method : "GET",
          url : "http://localhost:8080/api/ThongKeHoaDon/?fromDate=" + $scope.sDate + "&toDate=" + $scope.eDate
        }).then(function mySuccess(response) {
          $scope.listBillByDate=response.data;
        })
      }

      if($scope.radio=='totalSale'){
        $http({
          method : "GET",
          url : "http://localhost:8080/api/ThongKeTongTien/?fromDate=" + $scope.sDate + "&toDate=" + $scope.eDate
        }).then(function mySuccess(response) {
          $scope.total=response.data;
          console.log($scope.total);
        })
      }
    }

  });

}(angular.module("myApp")));
