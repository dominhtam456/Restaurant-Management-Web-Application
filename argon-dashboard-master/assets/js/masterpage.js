var app = angular.module("myApp", ["ngRoute",'angularUtils.directives.dirPagination',"ngStorage"]);
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
    controller : "FoodsCtrl",
    controllerAs: "vm"
  })
  .when("/tables", {
    templateUrl : "/examples/tables.html",
    controller : "ResourcesCtrl"
  })
  .when("/order", {
    templateUrl : "/examples/order.html",
    controller : "TablesCtrl"
  })
  .when("/login", {
    templateUrl : "/examples/login.html",
    controller : "Login.IndexController",
    controllerAs: "vm"
  })

});

app.run(function($rootScope, $http, $location, $localStorage) {
        // keep user logged in after page refresh
        if ($localStorage.currentUser) {
            $http.defaults.headers.common.Authorization = 'Bearer ' + $localStorage.currentUser.token;
        }

        // redirect to login page if not logged in and trying to access a restricted page
        $rootScope.$on('$locationChangeStart', function (event, next, current) {
            var publicPages = ['/login'];
            var restrictedPage = publicPages.indexOf($location.path()) === -1;
            if (restrictedPage && !$localStorage.currentUser) {
                $location.path('/login');
            }
        });
    });
