import re

p = re.compile('[a-z]+', re.IGNORECASE | re.DOTALL)
#print p
m=p.match('hello')
if m:
  print("Ok")
else:
  print("NOT")
