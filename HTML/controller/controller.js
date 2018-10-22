
var mongoose = require('mongoose');

  exports.list_all_tasks = function(req, res) {
      res.render('html');
      //catch(next);
  };

  /*exports.create_a_task = function(req, res, next) {
    Members.create(req.body).then(function(member){
      res.send(member);
    }).catch(next);
  };

  exports.read_a_task = function(req, res, next) {
    Members.findById(req.params.memberId).then(function(member) {
      res.send(member);
    }).catch(next);
  };

  exports.update_a_task = function(req, res, next) {
    Members.findOneAndUpdate({_id: req.params.memberId}, req.body).then(function(member) {
      res.send(member);
    }).catch(next);
  };

  exports.delete_a_task = function(req, res, next) {
      Members.findOneAndRemove({ _id: req.params.memberId}).then(function(member) {
        res.json(member);
      }).catch(next);
    };*/