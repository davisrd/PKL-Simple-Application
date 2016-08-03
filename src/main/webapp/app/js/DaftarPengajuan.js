roomReservationControllers.controller('ReservationRequestListController', function($scope) {
	$scope.listOfReservation = [];

	$scope.selectReservation = function(reservation){
		$rootScope.selectedReservation = reservation;
	};
})