import random
import string

class Robot(object):
    names = []

    def __generate_name(self):
        return "".join(random.choice(string.ascii_uppercase) for _ in range(2)) + "".join(random.choice(string.digits) for _ in range(3))

    def __init__(self):
        new_name = self.__generate_name()

        if new_name not in self.names:
            self.name = new_name
            self.names.append(new_name)
        else:
            self.reset()

    def reset(self):
        new_name = self.__generate_name()
        
        if new_name not in self.names:
            self.name = new_name
            self.names.append(new_name)
        else:
            self.reset()
