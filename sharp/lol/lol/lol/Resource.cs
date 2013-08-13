using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace lol
{
    class Resource : IDisposable
    {
        public Resource()
        {
            Console.Out.WriteLine("resource created ..");
        }

        public void Write(String s)
        {
            throw new ArgumentOutOfRangeException("not much diferent from java");
            Console.Out.WriteLine("writting string '{0}' ..", s);
        }

        public void Close()
        {
            Console.Out.WriteLine("close called ..");
        }

        public void Dispose()
        {
            Console.Out.WriteLine("calling close automatically ..");
            Close();
        }
    }

    public partial class Person
    {
        public int Age { get; set; }

        partial void ChangeName(string newName)
        {
            Name = newName;
        }

    }

}
