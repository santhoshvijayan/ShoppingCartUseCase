(function(){
    'use strict';

    angular
        .module('app')
        .factory('OrdersService', OrdersService);

    function OrdersService($http,$cookies){

        var order = {};

        var service = {
            checkout: checkout,
            getAll: getAll,
            getUserOrders: getUserOrders
        };

        return service;

        function checkout(cart, customer, userId){
            order.cart = cart;
            order.customer = customer;
            order.userid = userId;

            return $http.post("http://localhost:8080/api/checkout", order).then(function(response){
                return response;
            }, function(err){
                return err;
            });
        }

        function getAll(){
            return $http.get("http://localhost:8080/api/get-orders").then(function(response){
                return response.data;
            });
        }

        function getUserOrders(){
            var orderID = $cookies.get('user.id');
            return $http.get('http://localhost:8080/api/get-user-orders/' + orderID).then(function(response){
                console.log("response list order" + response.data)
                return response.data;
            });
        }

    }
})();