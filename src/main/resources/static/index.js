angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8080/app/api/v1/products';

    $scope.saveProduct = function () {
        console.log($scope.NewProduct)
        $http.post(contextPath, $scope.NewProduct)
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
                console.log(response);
                $scope.Products = response.data;
        });
    };

    $scope.fillTable();
});