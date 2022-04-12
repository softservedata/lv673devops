import re

print("START2")
#p=re.compile( "\\d+(\\.+\\d+)+" )
#m=p.findall("first 192.168.103.141, second 192.168.103.142, 192.168.103.143")

#m=re.findall(r"[\.\d]+", "first 192.168.103.141, second 192.168.103.142, 192.168.103.143")
m=re.findall(r"\d+\.\d+\.\d+\.\d+", "first 192.168.103.141, second 192.168.103.142, 192.168.103.143")
#m=re.findall(r"(\d+\.)+\d+", "first 192.168.103.141, second 192.168.103.142, 192.168.103.143")
#m=re.findall("(\\d+\\.)+\\d+", "first 192.168.103.141, second 192.168.103.142, 192.168.103.143")
print(m)
