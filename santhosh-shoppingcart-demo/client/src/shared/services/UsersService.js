(function(){
    'use strict';

    angular
        .module('app')
        .factory('UsersService', UsersService);

    function UsersService($http, Upload, HttpTokenAuthService, $window){

        var service = {
            getUserPayload:         getUserPayload,
            getUserId:              getUserId,
            getUserData:            getUserData,
            getUserRole:            getUserRole,
            getUsers:               getUsers,
            updateUserInfo:         updateUserInfo
        };

        return service;

        function getUserPayload(){
            var token = HttpTokenAuthService.getToken();

            if(token){
                var payload = JSON.parse($window.atob(token.split('.')[1]));

                return payload;
            } else {
                return '';
            }
        }

        function getUserData(){
            var id = getUserId();
            return $http.get('http://localhost:8080/api/users/' + id).then(function(response){
                return response;
            }, function(err){
                return err;
            });
        }

        function getUserId(){
            return getUserPayload()._id;
        }


        function getUserRole(){
            var accessLevel = getUserPayload().accessLevel;
            var userRoles = ['User', 'Redactor', 'Administrator'];
            return userRoles[accessLevel];
        }


        function getUsers(){
            return $http.get('http://localhost:8080/api/users').then(function(response){
                return response;
            }, function(err){
                return err;
            });
        }


        function updateUserInfo(user){
            return $http.put('http://localhost:8080/api/users/update-info/', user).then(function(response){
                return response.data;
            }, function(err){
                return err.data;
            });
        }

    }
})();