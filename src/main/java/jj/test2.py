def fun():
    for i in range(1,10):
        print(i)

def sum(a,b):
    return a+b

fun()
sum(1,2)

class Shape:
    def __init__(self,x,y):
        self.x=x
        self.y=y
    def area(self):
        print("Hello area")