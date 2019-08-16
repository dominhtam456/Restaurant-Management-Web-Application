var app = angular.module("myApp", ["ngRoute",'angularUtils.directives.dirPagination']);
app.config(function($routeProvider) {
  $routeProvider
  .when("/", {
    templateUrl : "/examples/dashboard.html"
  })
  .when("/icons", {
    templateUrl : "/examples/dashboard.html"
  })
  .when("/foods", {
    templateUrl : "/examples/foods.html",
    controller : "FoodsCtrl"
  })
  .when("/tables", {
    templateUrl : "/examples/tables.html",
    controller : "ResourcesCtrl"
  })
  .when("/order", {
    templateUrl : "/examples/order.html",
    controller : "TablesCtrl"
  })

});
