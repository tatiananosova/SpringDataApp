angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8080/app/products';

    $scope.saveProduct = function () {
        console.log($scope.NewProduct)
        $http.post(contextPath + '/add', $scope.NewProduct)
            .then(function (resp){
                $scope.NewProduct = null
                $scope.fillTable();
            })

    };

    $scope.deleteProductById = function (id) {
        $http.get(contextPath + '/' + id + '/delete')
            .then(function (resp){
                $scope.fillTable();
            })
    };

    $scope.fillTable = function () {
        $http.get(contextPath)
            .then(function (response) {
            $scope.Patients = response.data;
        });
    };

    $scope.fillTable();
});