import time, subprocess
import mySQLdb
#import mysqlclient

db = mySQLdb.connect(db='lv673', host='192.168.198.128', user='pmp3132', passwd='Pmp-31-32uni')
cursor = db.cursor()
cursor.execute("show databases;")
for d1 in cursor.fetchall():
  print ("d1 = ",d1)
#cursor.execute("select * from temp;")
cursor.close()
db.close()
print( "DONE")
