(function(){
    'use strict';

    angular
        .module('app')
        .factory('ItemsService', ItemsService);

    function ItemsService($http){

        var service = {
            getAll: getAll,
            getItem: getItem
        };

        return service;

        function getAll(){
            return $http.get('/items').then(function(response){
                return response.data;
            });
        }

        function getItem(id){
            return $http.get('/items/' + id).then(function(response){
               return response.data;
            });
        }


    }
})();