import math

class Shape:
    def area(self):
        raise NotImplementedError("Subclasses must implement this method.")

    def perimeter(self):
        raise NotImplementedError("Subclasses must implement this method.")

    def display(self):
        raise NotImplementedError("Subclasses must implement this method.")

class Circle(Shape):
    def __init__(self, radius):
        if radius <= 0:
            raise ValueError("Radius must be positive.")
        self.radius = radius

    def area(self):
        return math.pi * (self.radius ** 2)

    def perimeter(self):
        return 2 * math.pi * self.radius

    def display(self):
        return f"Circle: radius={self.radius}"

class Rectangle(Shape):
    def __init__(self, width, height):
        if width <= 0 or height <= 0:
            raise ValueError("Width and height must be positive.")
        self.width = width
        self.height = height

    def area(self):
        return self.width * self.height

    def perimeter(self):
        return 2 * (self.width + self.height)

    def display(self):
        return f"Rectangle: width={self.width}, height={self.height}"

class Triangle(Shape):
    def __init__(self, base, height, side2, side3):
        if base <= 0 or height <= 0 or side2 <= 0 or side3 <= 0:
            raise ValueError("All sides and height must be positive.")
        if base + side2 <= side3 or base + side3 <= side2 or side2 + side3 <= base:
            raise ValueError("The given sides do not form a valid triangle.")
        self.base = base
        self.height = height
        self.side2 = side2
        self.side3 = side3

    def area(self):
        return 0.5 * self.base * self.height

    def perimeter(self):
        return self.base + self.side2 + self.side3

    def display(self):
        return f"Triangle: base={self.base}, height={self.height}, side2={self.side2}, side3={self.side3}"

# Example usage
if __name__ == "__main__":
    circle = Circle(radius=5)
    rectangle = Rectangle(width=4, height=6)
    triangle = Triangle(base=3, height=4, side2=5, side3=5)

    shapes = [circle, rectangle, triangle]
    for shape in shapes:
        print(shape.display())
        print(f"Area: {shape.area():.2f}")
        print(f"Perimeter: {shape.perimeter():.2f}\n")
