import random
import time
from threading import Thread
 
 
class MyThread(Thread):
    
    def __init__(self, name):
        Thread.__init__(self)
        self.name = name
    
    def run(self):
        amount = random.randint(1, 4)
        time.sleep(amount)
        msg = "%s is running" % self.name
        print(msg)
        for i in range(5):
            time.sleep(1)
            #print(self.name)
            print(self.name, end = '')
    
def create_threads():

    for i in range(5):
        #name = "Thread #%s" % (i+1)
        name = (i+1)
        my_thread = MyThread(name)
        my_thread.start()
 
 
if __name__ == "__main__":
    create_threads()
