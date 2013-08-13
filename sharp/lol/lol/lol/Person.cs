using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace lol
{
    public partial class Person
    {
        public string Name { get; set; }

        partial void ChangeName(string newName);

        public Person()
        {
        }

        ~Person()
        {
            Console.Out.WriteLine("person destructed");
        }
    }

    public class Employee : Person
    {
        public int Salary()
        {
            return 100;
        }
    }
}
