'use strict';

simpleApp.controller('inputController',
    function ($scope, $http, $window) {
        $scope.title = "input";

        $scope.genderData = [
            { name: 'Pria', value: 1 },
            { name: 'Wanita', value: 2 }
        ];

        $scope.genderOptions = {
            placeholder: "'Select...'",
            dataTextField: 'name',
            dataValueField: 'value',
            dataSource: {
                data: $scope.genderData
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

        $scope.countryNames = [
            "Albania",
            "Andorra",
            "Armenia",
            "Austria",
            "Azerbaijan",
            "Belarus",
            "Belgium",
            "Bosnia & Herzegovina",
            "Bulgaria",
            "Croatia",
            "Cyprus",
            "Czech Republic",
            "Denmark",
            "Estonia",
            "Finland",
            "France",
            "Georgia",
            "Germany",
            "Greece",
            "Hungary",
            "Iceland",
            "Ireland",
            "Italy",
            "Kosovo",
            "Latvia",
            "Liechtenstein",
            "Lithuania",
            "Luxembourg",
            "Macedonia",
            "Malta",
            "Moldova",
            "Monaco",
            "Montenegro",
            "Netherlands",
            "Norway",
            "Poland",
            "Portugal",
            "Romania",
            "Russia",
            "San Marino",
            "Serbia",
            "Slovakia",
            "Slovenia",
            "Spain",
            "Sweden",
            "Switzerland",
            "Turkey",
            "Ukraine",
            "United Kingdom",
            "Vatican City"
        ];

        $scope.gridData = [
            {
                name: "Asep",
                bornDate: "1988-10-21T13:28:06.419Z",
                gender: "Pria",
                joinDate: "1988-10-21T13:28:06.419Z",
                address: "Bandung"

            },
            {
                name: "Hasna",
                bornDate: "1988-10-21T13:28:06.419Z",
                gender: "Wanita",
                joinDate: "1988-10-21T13:28:06.419Z",
                address: "Bandung"
            },
            {
                name: "Irma",
                bornDate: "1988-10-21T13:28:06.419Z",
                gender: "Wanita",
                joinDate: "1988-10-21T13:28:06.419Z",
                address: "Bandung"
            }
        ];

        $scope.gridColumns = [
            { field: "name", title: "Nama" },
            { field: "bornDate", title: "Tanggal Lahir" },
            { field: "gender", title: "Tanggal Lahir" },
            { field: "joinDate", title: "Tanggal Masuk" },
            { field: "address", title: "Alamat" }
        ];
        $scope.update = function () {
            $scope.gridData[0].track = "Hey you";
            console.log($scope.gridData);
        };
        $scope.onChange = function (data) {
            $scope.selected = data;
        };


    });
