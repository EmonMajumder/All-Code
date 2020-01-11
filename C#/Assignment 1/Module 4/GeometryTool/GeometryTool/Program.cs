using System;

namespace GeometryTool
{
    class Program
    {
        static void Main(string[] args)
        {
            var square = new Square() { width = 2 };
            var triangle = new Triangle { Base = 2, Height = 3 };
            var circle = new Circle { Radius = 3 };

            square.Display();
            triangle.Display();
            circle.Display();
        }
    }

    abstract class Shape
    {
        public abstract double GetArea();

        public void Display()
        {
            Console.WriteLine("Area is {0}", GetArea());

        }
    }

    class Square: Shape
    {
        public int width;

        public override double GetArea()
        {
            return (width * width);
        }
    }

    class Triangle: Shape
    {
        public int Base;
        public int Height;

        public override double GetArea()
        {
            return (Base * Height)/2;
        }
    }

    class Circle : Shape
    {
        public int Radius;
        
        public override double GetArea()
        {
            return (Math.PI* Radius* Radius);
        }
    }

}
