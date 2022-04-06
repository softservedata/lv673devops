#!flask/bin/python 
from flask import Flask, jsonify
from flask import make_response 
from flask import abort
from flask import request

#import flask

app = Flask(__name__) 

tasks = [ 
  { 
    'id': 1, 
    'title': u'Buy groceries', 
    'description': u'Milk, Cheese, Pizza, Fruit, Tylenol', 
    'done': False 
  }, 
  { 
    'id': 2, 
    'title': u'Learn Python', 
    'description': u'Need to find a good Python tutorial on the web', 
    'done': False 
  } 
] 


@app.errorhandler(404) 
def not_found(error):
  return make_response(jsonify({'error': 'Not found'}), 404)


@app.route('/todo/api/v1.0/tasks', methods=['GET'])
def get_tasks():
  return jsonify({'tasks': tasks})

@app.route('/todo/api/v1.0/tasks/<int:task_id>', methods=['GET']) 
def get_task(task_id):
  print("***task_id= %s" % str(task_id))
  task = list(filter(lambda t: t['id'] == task_id, tasks))
  print("***len(task)= %s" % str(len(task)))
  if len(task) == 0: 
    #flask.abort(404)
    abort(404)
  print(task[0])
  ret = task[0]
  print(ret)
  return jsonify({'task': ret})
  #return str(task_id)


@app.route('/todo/api/v1.0/tasks', methods=['POST']) 
def create_task(): 
  if not request.json or not 'title' in request.json: 
    abort(400) 
  task = { 
    'id': tasks[-1]['id'] + 1, 
    'title': request.json['title'], 
    'description': request.json.get('description', "hahaha"), 
    'done': False 
  } 
  tasks.append(task) 
  return jsonify({'task': task}), 201

@app.route('/todo/api/v1.0/tasks/<int:task_id>', methods=['PUT']) 
def update_task(task_id): 
  task = list(filter(lambda t: t['id'] == task_id, tasks))
  if len(task) == 0: 
    abort(404) 
  if not request.json: 
    abort(400) 
#  if 'title' in request.json and type(request.json['title']) != unicode: 
#    abort(400) 
#  if 'description' in request.json and type(request.json['description']) is not unicode: 
#    abort(400) 
#  if 'done' in request.json and type(request.json['done']) is not bool: 
#    abort(400) 
  task[0]['title'] = request.json.get('title', task[0]['title']) 
  task[0]['description'] = request.json.get('description', task[0]['description']) 
  task[0]['done'] = request.json.get('done', task[0]['done']) 
  return jsonify({'task': task[0]})

@app.route('/todo/api/v1.0/tasks/<int:task_id>', methods=['DELETE']) 
def delete_task(task_id): 
  task = list(filter(lambda t: t['id'] == task_id, tasks))
  if len(task) == 0: 
    abort(404) 
  tasks.remove(task[0]) 
  return jsonify({'result': True}) 


if __name__ == '__main__': 
  app.run(debug=True)

############################
# curl -i -H "Content-Type: application/json" -X POST -d "{\"title\":\"Read a book\"}" http://localhost:5000/todo/api/v1.0/tasks
# curl -i -H "Content-Type: application/json" -X PUT -d "{\"title\":\"Read a book\",\"description\":\"hello\"}" http://localhost:5000/todo/api/v1.0/tasks/3
# curl -i -H "Content-Type: application/json" -X PUT -d "{\"done\":True}" http://localhost:5000/todo/api/v1.0/tasks/3
#
#curl -i -H "Content-Type: application/json" -X POST --data "{\"email\": \"admin@gmail.com\",\"password\": \"admin\"}" http://localhost:8080/api/signin
#curl -i -H "Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbkBnbWFpbC5jb20iLCJleHAiOjE2MTE5NTc2MDB9.yDhuXz_xabVjOc5ZXYsoVyBHtke0NgmRU1oPdhNrwS9isWEXjVFjY5aSEwGFxDOC5-qmR_vhFqhCOIakNoNOYw" -X GET http://localhost:8080/api/roles
#{"id":1,"email":"admin@gmail.com","accessToken":"eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbkBnbWFpbC5jb20iLCJleHAiOjE2MTE5NTc2MDB9.yDhuXz_xabVjOc5ZXYsoVyBHtke0NgmRU1oPdhNrwS9isWEXjVFjY5aSEwGFxDOC5-qmR_vhFqhCOIakNoNOYw"}
#curl -i -H "Content-Type: application/json" -X POST --data "{\"email\": \"user1@gmail.com\",\"password\": \"user1\",\"name\": \"user1\"}" http://localhost:8080/api/signup
#curl -i -H "Content-Type: application/json" -X POST --data "{\"email\": \"user1@gmail.com\",\"password\": \"user1\"}" http://localhost:8080/api/signin
#{"id":2,"email":"user1@gmail.com","accessToken":"eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyMUBnbWFpbC5jb20iLCJleHAiOjE2MTE5NTc2MDB9.S6uDIW3MAHbg6iHgkJaYek39EHPpFVtbPu4j-aWawO8cuOMi4qe9IjJ8LsCpozvtcNVrArKqKsD2sqXWEaXnAw"}
#curl -i -H "Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyMUBnbWFpbC5jb20iLCJleHAiOjE2MTE5NTc2MDB9.S6uDIW3MAHbg6iHgkJaYek39EHPpFVtbPu4j-aWawO8cuOMi4qe9IjJ8LsCpozvtcNVrArKqKsD2sqXWEaXnAw" -X GET http://localhost:8080/api/roles


