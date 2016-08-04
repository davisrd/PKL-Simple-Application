// create the module and name it simpleApp
var simpleApp = angular.module('simpleApp', ['kendo.directives','ngRoute']);

// configure our routes
simpleApp.config(function ($routeProvider) {
	$routeProvider
		.when('/dashboard', {
			templateUrl: 'pages/Dashboard.html',
			controller: ''
		})
		.when('/input', {
			templateUrl: 'pages/FormInput.html',
			controller: 'inputController'
		})
		.otherwise({
			redirectTo: '/dashboard'
		});
});