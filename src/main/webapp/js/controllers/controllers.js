'use strict';

simpleApp.controller('inputController',
    function ($scope, $http, $window) {
        $scope.title = "input";

        $scope.jenisKelaminData = [
            { name: 'Pria', value: 1 },
            { name: 'Wanita', value: 2 }
        ];

        $scope.jenisKelaminOptions = {
            placeholder: "'Select...'",
            dataTextField: 'name',
            dataValueField: 'value',
            dataSource: {
                data: $scope.jenisKelaminData
            }
        }

        $scope.kelurahanData = [
            { name: 'Andir', value: 1 },
            { name: 'Cicendo', value: 2 }
        ];

        $scope.kelurahanOptions = {
            placeholder: "'Select...'",
            dataTextField: 'name',
            dataValueField: 'value',
            dataSource: {
                data: $scope.kelurahanData
            }
        }
    });
