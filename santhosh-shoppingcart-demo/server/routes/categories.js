'use strict';

var Category = mongoose.model('Categories');

router.get('/categories', function(req, res, next){
    Category.find(function(err, categories){
        if(err){ return next(err); }
        res.json(categories);
    });
});


/* Preloading category objects */
router.param('category-id', function(req, res, next, id){
    var query = Category.findById(id);

    query.exec(function(err, cat){
        if (err){ return next(err); }
        if (!cat){ return next(new Error('can\'t find category')); }

        req.category = cat;
        return next();
    });
});
