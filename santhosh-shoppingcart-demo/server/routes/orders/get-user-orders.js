'use strict';

var Order = mongoose.model('Order');

router.get('/get-user-orders/', function (req, res, next) {

    var orderID = req.cookies['user.id'] || req.cookies['connect.sid'];
    console.log("order id "+ orderID);
    console.log("req.cookies['connect.sid']"+ req.cookies['connect.sid']);
    console.log("req.cookies['user.id'] "+ req.cookies['user.id']);
    Order.find({'userid': req.cookies['user.id']}, function(err, orders){
        if (err){ return err }
        console.log("orders"+orders);
        res.json(orders);

    });

});

