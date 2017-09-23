var mongoose = require('mongoose');
var CartItemSchema = require('./CartItem');

var CartSchema = new mongoose.Schema({
    _id: String,
    total: Number,
    items: [CartItemSchema],
    itemsCount: {type: Number, default: 0}
});

CartSchema.methods.addItem = function(item, cb){
    var that = this;
    var itemExists = false;
    console.log("\nInside add item\n");
    /*
    * Increase current item quantity if it exists
    * */
    this.items.forEach(function(obj){
        if(obj._id === item._id){
            obj.qty += item.qty;
            itemExists = true;
        }
    });
    console.log("\nInside add item2\n");
    /*
    * Increase total items count
    * */
    this.itemsCount += item.qty;
    console.log("\nInside add item3\n");
    /*
    * Add item if it doesn't exists
    * */
    if(!itemExists){
        this.items.push(item);
    }
    console.log("\nInside add item4\n");
    /*
    * Recalculate cart total after item is added
    * */
    this.total = 0;
    this.items.forEach(function(item){
        item.total = item.price * item.qty;
        that.total += item.price * item.qty;
    });
    console.log("\nInside add item5\n");
    this.save(cb);
    console.log("\nInside add item6\n");
};

CartSchema.methods.removeItem = function(id, cb){
    /*
    * Remove item from cart only if items count is greater than 0
    * */
    if(this.items.length > 0){
        for (var index = 0; index <= this.items.length; index++ ){
            var item = this.items[index];

            if(item._id === id){

                if(this.itemsCount > 0){
                    /*
                     * Decrease total items count
                     * */
                    this.itemsCount -= 1;
                }

                if(item.qty > 1){
                    item.qty -= 1;
                    this.total -= item.price;

                    break;
                } else if (item.qty === 1) {
                    this.total -= this.items[index].price;
                    this.items.splice(index, 1);

                    break;
                } else if (item.qty < 0){
                    item.qty = 1;
                }

            }
        }
    }

    this.save(cb);
};


mongoose.model('Cart', CartSchema);