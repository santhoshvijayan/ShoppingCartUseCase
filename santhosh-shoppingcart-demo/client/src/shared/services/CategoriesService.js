(function(){
    'use strict';

    angular
        .module('app')
        .factory('CategoriesService', CategoriesService);

    function CategoriesService($http){

        var service = {
            getAll: getAll
        };

        return service;

        function getAll(){
            return $http.get('/categories/').then(function(response){
                return response.data;
            });
        }



    }
})();