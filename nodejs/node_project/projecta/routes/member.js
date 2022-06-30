var express = require('express');
var router = express.Router();

/* GET home page. */
router.get('/ss', function(req, res, next) {
    req.session["userid"]="test";
    req.session["username"]="Tom";

    //새로추가되었음 
    req.session.save( ()=>{
        console.log("세션 저장");
        res.redirect("/member/get");
    })

    console.log( req.session["userid"]);
    console.log( req.session["username"]);
});

router.get('/get', function(req, res, next) {
    console.log( req.session["userid"]);
    console.log( req.session["username"]);
    
    res.send(`${req.session["userid"]} ${req.session["username"]}`);
});


module.exports = router;
