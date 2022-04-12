class Test():
  @staticmethod
  def static_method_to_call():
    print("static_method_to_call")

  @staticmethod
  def another_static_method():
    print("another")
    Test.static_method_to_call()

  @classmethod
  def another_class_method(cls):
    print("@classmethod")
    cls.static_method_to_call()

#  def imeth(self, x):
#    print(x)


# Test.static_method_to_call()
#Test.another_static_method()
# Test.another_class_method()
t=Test()
t.another_class_method()

