var express = require('express');
var router = express.Router();
var mysql = require("mysql")
var common = require('./common')

/* GET home page. */
router.get('/', function(req, res, next) {

  // common.pool.getConnection( (err, conn)=>{
  //   sql = ` select a.id, a.writer, a.title, 
  //   a.contents, date_format(a.wdate,  '%Y-%m-%d') as wdate
  //   from board a`;

  //   conn.query(sql, (err, rows)=>{
  //     console.log( rows );
  //     res.render('./board/board_list', {boardList:rows});
  //     conn.release();
  //   });
  // })

  sql = ` select a.id, a.writer, a.title, 
     a.contents, date_format(a.wdate,  '%Y-%m-%d') as wdate
     from board a
     order by id desc 
     `;
  common.executeDB(sql, [])
  .then((rows)=>{
    res.render('./board/board_list', {boardList:rows})
  });
});

router.get("/view/:id", (req, res)=>{
  var id = req.params.id;
  sql = ` select a.id, a.writer, a.title, 
  a.contents, date_format(a.wdate,  '%Y-%m-%d') as wdate
  from board a
  where id=${id}`;

  common.executeDB(sql, [])
  .then((rows)=>{
    console.log(rows[0]);
    res.render('./board/board_view', {board:rows[0]})
  });
})

router.get("/write", (req, res)=>{
  res.render('./board/board_write');
});

router.post("/save", (req, res)=>{
  let params = [req.body.title, req.body.writer, req.body.contents];
  let sql = `insert into board(title, writer, contents, wdate, hit)
              values(?, ?, ?, now(), 0) `;
  common.executeDB(sql, params)
  .then( ()=>{
      res.redirect("/board");
  })
  .catch( (err)=>{
    console.log( err);
  })
})


module.exports = router;
