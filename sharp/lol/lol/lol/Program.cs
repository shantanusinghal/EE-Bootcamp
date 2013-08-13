using System;
using System.Collections;
using System.Collections.Generic;
using System.Collections.Specialized;
using System.Configuration;
using System.Linq;
using System.Runtime.CompilerServices;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace lol
{
    internal delegate void MyDelegate(string str);

    internal delegate T Operation<T>(T left, T right);

    internal delegate void AnotherOperation<T>(T left, T right, ref T result);

    //    delegate void MyEventHandler<MyEventArgs>(object sender, MyEventArgs args);

    public class MyEventArgs : EventArgs
    {
        public DateTime TimeOccured { get; set; }
        public string Data { get; set; }
    }

    struct Money : IEquatable<Money>
    {
        private int _value;
        private string _currency;
        private Person _owner;

        public Money(int value, string currency, Person owner)
        {
            _value = value;
            _currency = currency;
            _owner = owner;
        }

        public bool Equals(Money other)
        {
            return true;
        }
    }

    internal class Program
    {
        
        public static int i = 0;
        private static readonly object Lockable = new object();

        private static event EventHandler<MyEventArgs> ExecutionStarted;
        private static event EventHandler<MyEventArgs> ExecutionEnded;

        private static void Main(string[] args)
        {
            //Day 2
//            DayTwo();
//
//            //Day 3
//            Tuple();
//            AnonumouseType();
//            UnderstandingDelegates();
//            StaticMethodExtensions();
//            LookingAtEnumerables();
//            IntroToLinq();
//            CombiningAndRemovingDelegates();
//            EventHandling();


            //Day 4
            VariableArgumentsMethod(1, 2, 3, 4);
            UnderstandingExceptions();
            DeterministicAndUndeterministicCleanup();
            PartialClasses();
            Synchronization();
            SafeCasting();
            Indexers();
            DynamicTypes();
            Coroutines();
            ConfigurationHandling();

            //Day 5
            ImplicitExplicitInterfaces();
            Variance();

            Console.ReadLine();
        }

        private static void DayTwo()
        {
            int? a = null;
            var prashant = new Person() {Name = "Prashant"};
            var shantanu = new Person() {Name = "Shantanu"};
            new List<int> {1, 2, 3};

            string test = "first";
            string result = "first";
            Console.Out.WriteLine("test = {0}", test);
            Testing(test, out result);
            Console.Out.WriteLine("result = {0}", result);

            var five1 = new Money(5, "INR", prashant);
            var five2 = new Money(5, "INR", prashant);

            Console.Out.WriteLine("five2.Equals(five1) = {0}", five2.Equals(five1));
        }

        private static void Testing(string test, out string result)
        {
            result = "second";
            Console.Out.WriteLine("test = {0}", test);
        }

        [Run]
        private static void Variance()
        {
            //arrays are covariant
            Animal cat = new Cat();
            Animal dog = new Dog();
            Animal[] animals = new Animal[] {cat, dog};
            SpeakAll(animals);
            Cat[] cats = new Cat[] {new Cat(), new Cat()};
            SpeakAll(cats);

            //lists are invariant
            List<Animal> animalsList = new List<Animal>() {cat, cat};
            SpeakAll(animalsList);

            //covariant: out T
            //contravariant: in T
            IEnumerable<Animal> animalsListWithDogs = new List<Dog>() {new Dog(), new Dog()};
            SpeakAll(animalsListWithDogs);
        }

        private static void SpeakAll(IEnumerable<Animal> animals)
        {
            foreach (var animal in animals)
            {
                Console.Out.WriteLine("animal in list says = {0}", animal.Speak());
            }
        }

        private static void SpeakAll(Animal[] animals)
        {
//            animals[0] = new Dog();
            foreach (var animal in animals)
            {
                Console.Out.WriteLine("animal says = {0}", animal.Speak());
            }
        }

        [Run]
        private static void ImplicitExplicitInterfaces()
        {
            IGreet1 greet1 = new Greeter();
            Console.Out.WriteLine("greet1.Greet() = {0}", greet1.Greet());
            IGreet2 greet2 = new Greeter();
            Console.Out.WriteLine("greet2.Greet() = {0}", greet2.Greet());
            //No greet method available unless I cast
            Greeter greeter = new Greeter();
            Console.Out.WriteLine("greeter.Talk() = {0}", greeter.Talk());
        }

        private static void ConfigurationHandling()
        {
            NameValueCollection appSettings = ConfigurationManager.AppSettings;
            var pageSize = appSettings["page.size"];
            Console.Out.WriteLine("pageSize = {0}", pageSize);

            PrintConfiguration(appSettings);

            var coreSection = ConfigurationManager.GetSection("core") as NameValueCollection;
            PrintConfiguration(coreSection);
        }

        private static void PrintConfiguration(NameValueCollection appSettings)
        {
            var enumerator = appSettings.GetEnumerator();
            while (enumerator.MoveNext())
            {
                var key = enumerator.Current as String;
                Console.Out.WriteLine("{0} = {1}", key, appSettings[key]);
            }
        }

        private static void Coroutines()
        {
            foreach (var s in Generator())
            {
                Console.Out.WriteLine("s = {0}", s);
            }
        }

        private static IEnumerable<int> Generator()
        {
            Console.Out.WriteLine("called first time");
            yield return 1;
            Console.Out.WriteLine("called second time");
            yield return 2;
            Console.Out.WriteLine("called third time");
            yield return 3;
        }

        private static void DynamicTypes()
        {
            dynamic person = new Person();
            person.Name = "Shantanu";
            person.Age = 27;
            Console.Out.WriteLine("person.Name = {0}", person.Name);
            Console.Out.WriteLine("person.Age = {0}", person.Age);
//            //Throws binding not found exception
//            Console.Out.WriteLine("person.Anything = {0}", person.Anything);

            var prototype = new Prototype();
            prototype["Name"] = "Shantanu";
            Func<string> anything = () => "something something ..";
            prototype["Anything"] = anything;
            Func<string, string> getTitle = (houseName) => prototype["Name"] + " of The House " + houseName;
            prototype["GetTitle"] = getTitle;

            Console.Out.WriteLine("prototype Name = {0}", prototype["Name"]);
            Console.Out.WriteLine("prototype Anything = {0}", prototype["Anything"]());
            Console.Out.WriteLine("prototype = {0}", prototype["GetTitle"]("Singhal"));
        }

        private static void Indexers()
        {
            var myList = new MyList<int> {1, 2};
            Console.Out.WriteLine("myList 0th Item = {0}", myList[0]);
            Console.Out.WriteLine("myList 1st Item = {0}", myList[1]);

            var myDictionary = new Dictionary<string, int> {{"first", 1}, {"second", 2}};
            Console.Out.WriteLine("myDictionary first = {0}", myDictionary["first"]);
            Console.Out.WriteLine("myDictionary second = {0}", myDictionary["second"]);
        }

        private static void SafeCasting()
        {
            var employee = new Employee() {Name = "Tester", Age = 0};
            ShowSalary(employee);
            var person = new Person() {Name = "Dev", Age = 0};
            var personAsEmployee = person as Employee;
            if (personAsEmployee != null)
            {
                ShowSalary(personAsEmployee);
            }
        }

        private static void ShowSalary(Employee employee)
        {
            Console.Out.WriteLine("employee.Salary() = {0}", employee.Salary());
        }

        private static void Synchronization()
        {
            new Thread(() =>
                {
                    ChangeI(10);
                    Thread.Sleep(10);
                }).Start();

            new Thread(() =>
                {
                    ChangeI(20);
                    Thread.Sleep(9);
                }).Start();

            for (var j = 0; j < 20; j++)
            {
                Console.Out.WriteLine("i = {0}", i);
                Thread.Sleep(5);
            }
        }

        ///       Use lockable or the commented attribute
        //        [MethodImpl(MethodImplOptions.Synchronized)]
        private static void ChangeI(int newI)
        {
            lock (Lockable)
            {
                i = newI;
            }
        }

        private static void PartialClasses()
        {
            var brokenPerson = new Person() {Name = "Shantanu", Age = 27};
            Console.Out.WriteLine("person.Name = {0}", brokenPerson.Name);
            Console.Out.WriteLine("person.Age = {0}", brokenPerson.Age);
            //            brokenPerson.ChangeName("Shivam");
            //            Console.Out.WriteLine("person.Name = {0}", brokenPerson.Name);
        }

        private static void DeterministicAndUndeterministicCleanup()
        {
            //Destructor is called undeterministically
            Person person = new Person() {Name = "Shantanu"};
            Console.Out.WriteLine("person.Name = {0}", person.Name);

            //Undeterministic Cleanup
            var resource = new Resource();
            try
            {
                resource.Write("data");
            }
            catch (Exception e)
            {
                Console.Out.WriteLine(e.Message);
            }
            finally
            {
                resource.Close();
            }

            //Deterministic Cleanup
            using (var anotherResource = new Resource())
            {
                try
                {
                    anotherResource.Write("some data");
                }
                catch (Exception e)
                {
                    Console.Out.WriteLine(e.Message);
                }
            }
        }

        private static void UnderstandingExceptions()
        {
            try
            {
                DoSomething(10);
            }
            catch (Exception e)
            {
                Console.Out.WriteLine(e.Message);
                Console.Out.WriteLine(e.StackTrace);
            }

        }

        private static void DoSomething(int i)
        {
            throw new ArgumentOutOfRangeException("not much diferent from java");
        }

        private static void VariableArgumentsMethod(params int[] args)
        {
            foreach (var i in args)
            {
                Console.Out.WriteLine("i = {0}", i);
            }
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

            var newAdd = new AnotherOperation<int>((int a, int b, ref int result) => result += a + b);
            var newSubstract = new AnotherOperation<int>((int a, int b, ref int result) => result += a - b);
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
            MyDelegate anotherDelegate = (string s) => Console.Out.WriteLine("{0}", s);
            var myDelegate = new MyDelegate(delegate(string str) { Console.Out.WriteLine("str = {0}", str); });
            myDelegate("Shantanu");
            Console.Out.WriteLine("myDelegate.GetType().Name = {0}", myDelegate.GetType().Name);

            var add = new Operation<int>(delegate(int a, int b) { return a + b; });

            Console.Out.WriteLine("add(2,3) = {0}", add(2, 3));

            var substract = new Operation<int>((a, b) => a - b);
            Console.Out.WriteLine("substract(5,3) = {0}", substract(5, 3));

            Console.Out.WriteLine("Operate(2,3,multiply) = {0}", Operate(2, 3, (x, y) => x*y));
        }

        private static void StaticMethodExtensions()
        {
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
