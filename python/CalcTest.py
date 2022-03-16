import unittest
# SUT
import calc

class DataValue:
  #a=0
  #b=0
  #result=0
  def __init__(self, a, b, result):
    self.a=a
    self.b=b
    self.result=result



class CalcTest(unittest.TestCase):

  def test_01(self):
    c=calc.Calc()
    expected=2
    actual=c.div(10,5)
    self.assertEqual(expected, actual)
    #self.assertFalse(10 > 20)
    #self.assertGreater(120, 100)

  def test_02(self):
    c=calc.Calc()
    expected=2.5
    actual=c.div(20,8)
    self.assertEqual(expected, actual)

  def test_03(self):
    data=[ DataValue(20, 8, 2.5), DataValue(0, 1, 0), DataValue(-1, 1, -1) ]
    for value in data:
      self.check(value)

  def check(self,value):
    c=calc.Calc()
    actual=c.div(value.a,value.b)
    self.assertEqual(value.result, actual)


if __name__ == '__main__':
  unittest.main()
