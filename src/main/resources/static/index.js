angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8080/app/api/v1/products';
    const categoriesPath = 'http://localhost:8080/app/api/v1/categories';

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
                $scope.fillTable($scope.ProductsPage.number + 1);
            })
    };

    $scope.fillTable = function (pageIndex = 1) {
        $http({
            url: contextPath,
            method: 'GET',
            params: {
                'title': $scope.filter ? $scope.filter.title : null,
                'cost': $scope.filter ? $scope.filter.cost : null,
                'page-number': pageIndex
            }
        }).then(function (response) {
            $scope.ProductsPage = response.data;

            let minPageIndex = pageIndex - 1;
            if (minPageIndex < 1) {
                minPageIndex = 1;
            }

            let maxPageIndex = pageIndex + 1;
            if (maxPageIndex > $scope.ProductsPage.totalPages) {
                maxPageIndex = $scope.ProductsPage.totalPages;
            }

            $scope.ProductsArray = $scope.generatePagesIndexes(minPageIndex, maxPageIndex);
        });
    };

    $scope.getCategories = function () {
        $http.get(categoriesPath)
            .then(function (response) {
                $scope.Categories = response.data;
            });
    };

    $scope.generatePagesIndexes = function(startPage, endPage) {
        let arr = [];
        for (let i = startPage; i < endPage + 1; i++) {
            arr.push(i);
        }
        return arr;
    }

    $scope.fillTable();
    $scope.getCategories();
});