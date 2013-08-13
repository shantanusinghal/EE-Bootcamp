using System;
using System.Linq;
using System.Reflection;

namespace CustomAttributes
{
    public class MyClass
    {
        public void PrintName()
        {
            Console.Out.WriteLine("Name = Shantanu");
        }

        [Run]
        public void PrintName1()
        {
            Console.Out.WriteLine("Name = Shantanu");
        }
        
        [Run]
        public void PrintName2()
        {
            Console.Out.WriteLine("Name = Shantanu");
        }
    }
}