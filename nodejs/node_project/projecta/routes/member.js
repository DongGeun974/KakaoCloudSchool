const e = require('express');
var express = require('express');
var router = express.Router();
var common = require('./common')

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

router.get('/logon', (req, res)=>{
    res.render("./member/logon");
})

router.post('/logon', (req, res)=>{
    var userid = req.body.userid;
    var password = req.body.password;
    var sql = "select userid, password, username, email from member where userid='"+userid+"'";
    common.executeDB(sql)
    .then((result)=>{
        if(result.length == 0)
        {
            res.send({result:3});       // 아이디 존재 안함
        }else
        {
            if(result[0]["password"] == password)
            {
                req.session['userid']=result[0]["userid"];
                req.session['username']=result[0]["username"];
                req.session['email']=result[0]["email"];

                res.send({result:1})    // 로그인 성공
            }
            else
            {
                res.send({result:2})    // 패스워드 실패
            }
        }
    })
})

router.get("/logout",(req, res)=>{
    req.session.destroy();
    res.redirect("/");
})

router.get("/register", (req,res)=>{
    res.render("./member/register")
})

router.post("/register", (req,res)=>{
    var userid = req.body.userid
    var username = req.body.username;
    var password = req.body.password;
    var email = req.body.email;
    var phone = req.body.phone;

    var sql = `
    insert into member(userid, password, username, email, phone, wdata,delyn)
    values (?,?,?,?,?, now(), 'N')
        `;
    var params = [userid, password, username, email, phone]
    common.executeDB(sql, params)
    .then((result)=>{
        res.send({result:"success"})
    }).catch((error)=>{
        console.log(error)
        res.send({result:"fail"})
    })
})

router.post("/duplicate", (req,res)=>{
    var userid = req.body.userid;
    var sql = `select count(*) cnt from member where userid='${userid}'`;
    console.log(sql)
    common.executeDB(sql)
    .then((result)=>{
      if(result[0]["cnt"]==0){
        res.send({result:"success"});
      }else{
        res.send({result:"fail"});
      }
    })
})

module.exports = router;
