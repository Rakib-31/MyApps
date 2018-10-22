
module.exports = function(app) {
    var todoList = require('../controller/controller');
    
    
    
  
    // todoList Routes
    app.route('/home')
      .get(todoList.list_all_tasks);
      /*.post(todoList.create_a_task);

    app.route('/home/:homeId')
      .get(todoList.read_a_task)
      .put(todoList.update_a_task)
      .delete(todoList.delete_a_task);*/
}