(function () {
    'use strict';

    angular
        .module('app')
        .controller('ItemsController', ItemsController);

    function ItemsController(items, ItemsService, categories, $q) {

        var vm = this;

        angular.extend(vm, {
            items: items.map(makeShortDescriptions.bind(null, 120)),
            item: {},
            getAllItems: getAllItems
        });



        function getAllItems(){
            ItemsService.getAll().then(function(response){
                vm.items = response;
            });
        }





        function makeShortDescriptions(length, item) {
            if (item.description.length > length) {
                item.shortDescription = item.description.substr(0, length) + '..';
            } else {
                item.shortDescription = item.description;
            }
            return item;
        }

    }
})();