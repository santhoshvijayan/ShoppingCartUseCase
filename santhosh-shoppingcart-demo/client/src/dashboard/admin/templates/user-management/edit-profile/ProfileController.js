(function () {
    'use strict';

    angular
        .module('app')
        .controller('ProfileController', ProfileController);

    function ProfileController(user, UsersService, $state, $scope) {

        var vm = this;

        angular.extend(vm, {
            user: user,
            message: '',
            userRole: UsersService.getUserRole(vm.user),
            updateUser: updateUser,
            getUserData: getUserData
        });

        function updateUser(){
            UsersService.updateUserInfo(vm.user).then(function () {
                vm.message = 'Your profile is successfully updated.';
            });
        }


        function getUserData(){
            return UsersService.getUserData(user._id).then(function (response) {
                vm.user = response;
            });
        }

    }
})();