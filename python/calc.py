class Calc:
  def div(self, a, b):
    print("Calc a = ", a, " b = ", b)
    return a/b
    #return float(a)/b


# ----------------------------

print("__name__ = ",__name__)

if __name__ == '__main__':
  c=Calc()
  print("20 / 4 =", c.div(20,4))
  print("END")
