// create the module and name it simpleApp
var simpleApp = angular.module('simpleApp', ['kendo.directives', 'ngRoute']);

// configure our routes
simpleApp.config(function ($routeProvider) {
	$routeProvider
		.when('/dashboard', {
			templateUrl: 'pages/Dashboard.html',
			controller: 'dashboardController'
		})
		.when('/input', {
			templateUrl: 'pages/FormInput.html',
			controller: 'MyCtrl'
		})
		.otherwise({
			redirectTo: '/dashboard'
		});
});


simpleApp.controller('MyCtrl', function ($scope) {
    $scope.monthSelectorOptions = {
        start: "year",
        depth: "year"
    };
    $scope.getType = function (x) {
        return typeof x;
    };
    $scope.isDate = function (x) {
        return x instanceof Date;
    };
});

// create the controller and inject Angular's $scope
simpleApp.controller('dashboardController', function ($scope) {
	// create a message to display in our view
	$scope.message = 'Everyone come and see how good I look!';
});

simpleApp.controller('aboutController', function ($scope) {
	$scope.message = 'Look! I am an about page.';
});

simpleApp.controller('contactController', function ($scope) {
	$scope.message = 'Contact us! JK. This is just a demo.';
});