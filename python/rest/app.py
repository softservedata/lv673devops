#!/bin/python 
from flask import Flask 

app = Flask(__name__) 

@app.route('/') 
def index(): 
  return "Hello, World!" 

 
print("name = %s" % __name__)

if __name__ == '__main__':
  app.run(debug=True)
