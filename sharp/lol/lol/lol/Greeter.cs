using System;

namespace lol
{

    interface IGreet1
    {
        string Greet();
    }

    interface IGreet2 : IGreet1
    {
        new string Greet();
    }

    interface ITalk1
    {
        string Talk();
    }

    interface ITalk2
    {
        string Talk();
    }

    public class Greeter : IGreet2, ITalk1, ITalk2
    {
        //explicit implementations: public not allowed 
        string IGreet1.Greet()
        {
            return "Hello from 1";
        }

        //explicit implementations: public not allowed 
        string IGreet2.Greet()
        {
            return "Hello from 2";
        }

        //implicit implementations:s note the visibility here
        public string Talk()
        {
            return "Talking for 1 and 2";
        }
    }
}