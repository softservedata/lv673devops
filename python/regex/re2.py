import re

p = re.compile('(hello)* (world)*', re.IGNORECASE | re.DOTALL)
#print p
m=p.match('hello world')

print(m.group(2))
print(m.span())
