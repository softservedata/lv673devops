#!/bin/python 
from flask import Flask, jsonify
from flask import make_response 
#from flask import abort
#from flask import request
#import flask
from flask_httpauth import HTTPBasicAuth

app = Flask(__name__)
auth = HTTPBasicAuth()

@auth.get_password
def get_password(username):
  if username == 'miguel':
    return 'python'
  return None

@auth.error_handler
def unauthorized():
  return make_response(jsonify({'error': 'Unauthorized access'}), 401)



@app.errorhandler(404) 
def not_found(error):
  return make_response(jsonify({'error': 'Not found'}), 404)


@app.route('/api/tasks', methods=['GET'])
@auth.login_required
def get_tasks():
  return jsonify({'get_tasks': 'done'})

@app.route('/api/tasks/<int:task_id>', methods=['GET']) 
def get_task(task_id):
  return jsonify({'get_task': 'done, number is %s' % task_id})

@app.route('/api/tasks', methods=['POST']) 
def create_task(): 
  return jsonify({'create_task': 'done'})

@app.route('/api/tasks/<int:task_id>', methods=['PUT']) 
def update_task(task_id):
  return jsonify({'update_task': 'done, number is %s' % task_id})

@app.route('/api/tasks/<int:task_id>', methods=['DELETE']) 
def delete_task(task_id): 
  return jsonify({'delete_task': 'done, number is %s' % task_id})

if __name__ == '__main__': 
  app.run(debug=True)

##################################################
# Get
#curl -i http://localhost:5000/api/tasks
# Post
#curl -i -X POST http://localhost:5000/api/tasks
# Put
#curl -i -X PUT http://localhost:5000/api/tasks/101
# Delete
#curl -i -X Delete http://localhost:5000/api/tasks/101
#
