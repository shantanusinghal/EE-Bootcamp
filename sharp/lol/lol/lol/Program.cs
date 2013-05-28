using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace lol
{
    delegate void MyDelegate(string str);
    delegate T Operation<T>(T left, T right);
    delegate void AnotherOperation<T>(T left, T right, ref T result);
//    delegate void MyEventHandler<MyEventArgs>(object sender, MyEventArgs args);

    public class MyEventArgs : EventArgs
    {
        public DateTime TimeOccured { get; set; } 
        public string Data { get; set; } 
    }

    class Program
    {
        static event EventHandler<MyEventArgs> ExecutionStarted;
        static event EventHandler<MyEventArgs> ExecutionEnded;

        static void Main(string[] args)
        {
            //Day 3
            Tuple();
            AnonumouseType();
            UnderstandingDelegates();
            LookingAtEnumerables();
            IntroToLinq();
            CombiningAndRemovingDelegates();
            EventHandling();

            Console.ReadLine();
        }

        private static void EventHandling()
        {
            //Registering a Handler
            ExecutionStarted += OnExecutionStarted;
            ExecutionEnded += (object sender, MyEventArgs arguments) =>
                {
                    Console.Out.WriteLine("sender = {0}", sender);
                    Console.Out.WriteLine("args.TimeOccured = {0}", arguments.TimeOccured);
                    Console.Out.WriteLine("args.Data = {0}", arguments.Data);
                };
            //Raising an Event
            ExecutionStarted(null, new MyEventArgs() {Data = "something something", TimeOccured = DateTime.Now});
        }

        private static void OnExecutionStarted(object sender, MyEventArgs arguments)
        {
            Console.Out.WriteLine("sender = {0}", sender);
            Console.Out.WriteLine("args.TimeOccured = {0}", arguments.TimeOccured);
            Console.Out.WriteLine("args.Data = {0}", arguments.Data);
        }

        private static void CombiningAndRemovingDelegates()
        {
            var add = new Operation<int>((a, b) => a + b);
            var substract = new Operation<int>((a, b) => a - b);
            Operation<int> operations = add;
            operations += substract;
            Console.Out.WriteLine("operations(2, 3) = {0}", operations(2, 3));
            operations -= substract;
            Console.Out.WriteLine("operations(2, 3) = {0}", operations(2, 3));

            var newAdd = new AnotherOperation<int>((int a, int b, ref int result) => result = result + a + b);
            var newSubstract = new AnotherOperation<int>((int a, int b, ref int result) => result = result + a - b);
            AnotherOperation<int> anotherOperations = newAdd;
            anotherOperations += newSubstract;
            int r = 0;
            anotherOperations(2, 3, ref r);
            Console.Out.WriteLine("result should be {0}", r);
        }

        private static void IntroToLinq()
        {
            var list = new List<int> {1, 2, 3, 4};
            var enumerable = from items in list select items;
            foreach (var i in enumerable)
            {
                Console.Out.WriteLine("linq expression i1 = {0}", i);
            }
            enumerable = from item in list where item%2 == 0 select item;
            foreach (var i in enumerable)
            {
                Console.Out.WriteLine("linq expression i2 = {0}", i);
            }
        }

        private static void LookingAtEnumerables()
        {
            var doubledList = Enumerable.Range(0, 10).Select(x => x*2).ToList();
            foreach (var i in doubledList)
            {
                Console.Out.WriteLine("enumerable i = {0}", i);
            }
        }

        private static void UnderstandingDelegates()
        {
            var myDelegate = new MyDelegate(delegate(string str) { Console.Out.WriteLine("str = {0}", str); });
            myDelegate("Shantanu");
            Console.Out.WriteLine("myDelegate.GetType().Name = {0}", myDelegate.GetType().Name);

            var add = new Operation<int>(delegate(int a, int b) { return a + b; });
            Console.Out.WriteLine("add(2,3) = {0}", add(2, 3));

            var substract = new Operation<int>((a, b) => a - b);
            Console.Out.WriteLine("substract(5,3) = {0}", substract(5, 3));

            Console.Out.WriteLine("Operate(2,3,multiply) = {0}", Operate(2, 3, (x, y) => x*y));

            5.Times(() => Console.Out.WriteLine("Hello"));

            var aList = new List<int> {1, 2, 3, 4};
            var oddList = aList.Exists(x => x%2 != 0);
            Console.Out.WriteLine("oddList = {0}", oddList);
        }

        private static void AnonumouseType()
        {
            var personOne = new {Firstname = "Shantanu", Lastname = "Singhal"};
            var personTwo = new {Firstname = "Shantanu", Lastname = "Singhal"};
            Console.Out.WriteLine("personOne = {0}", personOne);
            Console.Out.WriteLine("personOne.GetType().Name = {0}", personOne.GetType().Name);
            Console.Out.WriteLine("personTwo.Equals(personOne) = {0}", personTwo.Equals(personOne));
            Console.Out.WriteLine("personTwo.Firstname = {0}", personTwo.Firstname);
            Console.Out.WriteLine("personTwo.Lastname = {0}", personTwo.Lastname);
        }

        private static void Tuple()
        {
            var inr5One = new Tuple<string, int>("INR", 5);
            var inr5Two = new Tuple<string, int>("INR", 5);
            Console.Out.WriteLine("inr5One = {0}", inr5One);
            Console.Out.WriteLine("inr5One.Equals(inr5Two) = {0}", inr5One.Equals(inr5Two));
            Console.Out.WriteLine("inr5One.GetType().BaseType.FullName = {0}", inr5One.GetType().BaseType.FullName);
            Console.Out.WriteLine("inr5One.GetType().Name = {0}", inr5One.GetType().Name);
            Console.Out.WriteLine("inr5Two.Item1 = {0}", inr5Two.Item1);
            Console.Out.WriteLine("inr5Two.Item2 = {0}", inr5Two.Item2);
        }

        public static T Operate<T>(T left, T right, Operation<T> binaryOperation)
        {
            return binaryOperation(left, right);
        }
    }
}
