'use strict';

global.express       = require('express');
global.router        = express.Router();
global.mongoose      = require('mongoose');

global.jwt           = require('express-jwt');
global.auth          = jwt({secret: process.env.JWT_CERT, userProperty: 'payload'});

var endpoints = [
 './items',
 './users/users-auth',
 './users/users-info',
  './users/update-contact-info',
 './categories',
  './cart/add-to-cart',
 './cart/delete-from-cart',
 './cart/delete-all-from-cart',
 './cart/get-cart',
 './cart/update-cart'
];

endpoints.forEach(function(endpoint){
   require(endpoint);
});

module.exports = router;