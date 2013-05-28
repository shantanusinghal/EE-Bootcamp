using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;



namespace MathWorks
{
    public delegate bool Predicate(int item);

    public enum ThatAre
    {
        Even, Odd, Prime
    }

    public class Filter
    {
        public Predicate IsEven;
        public Predicate IsOdd;
        public Func<int, int, bool> Check;
        public Predicate IsPrime;
        private IDictionary<ThatAre, Predicate> predicates = new Dictionary<ThatAre, Predicate>();

        private IList<int> AllPrimes = new List<int>() {2,3,5,7,9}; 

        public Filter()
        {
            Check = (x, y) => (y != 0) && ((y == 1) || (x % y != 0 && Check(x, y - 1)));
            IsEven = x => x % 2 == 0;
            IsOdd = x => !IsEven(x);
            IsPrime = x => Check(x, x/2);
            predicates.Add(ThatAre.Even, IsEven);
            predicates.Add(ThatAre.Odd, IsOdd);
            predicates.Add(ThatAre.Prime, IsPrime);
        }

        public IList<int> SelectEven(IList<int> numbers, ThatAre condition)
        {
            return Select(numbers, condition);
        }

        public IList<int> SelectOdd(List<int> numbers, ThatAre condition)
        {
            return Select(numbers, condition);
        }

        public IList<int> Select(IList<int> numbers, params ThatAre[] conditions)
        {
//            var enumerable = from number in numbers
//                             from condition in conditions
//                             where predicates[condition](number)
//                             select number;

            IList<int> result = new List<int>();
            foreach (var condition in conditions)
            {
                foreach (var number in numbers)
                {
                    if (predicates[condition](number))
                    {
                        result.Add(number);
                    }
                }
                numbers = new List<int>(result);
            }

//            IList<int> result = new List<int>();
//            bool flag = true;
//            foreach (var number in numbers)
//            {
//                flag = true;
//                foreach (var condition in conditions)
//                {
//                    if (!predicates[condition](number))
//                    {
//                        flag = false;
//                    }
//                }
//                if(flag)
//                    result.Add(number);
//            }
            return numbers;
        }
    }
}


/*
  public class Filter
    {
        public Predicate IsEven;
        public Predicate IsOdd;
        public Func<int, int, bool> Check;
        public Predicate IsPrime;
        private IDictionary<ThatAre, Predicate> predicates = new Dictionary<ThatAre, Predicate>();

        private IList<int> AllPrimes = new List<int>() {2,3,5,7,9}; 

        public Filter()
        {
            Check = (x, y) => (y != 0) && ((y == 1) || (x % y != 0 && Check(x, y - 1)));
            IsEven = x => x % 2 == 0;
            IsOdd = x => !IsEven(x);
            IsPrime = x => Check(x, x/2);
            predicates.Add(ThatAre.Even, IsEven);
            predicates.Add(ThatAre.Odd, IsOdd);
            predicates.Add(ThatAre.Prime, IsPrime);
        }

        public IList<int> SelectEven(IList<int> numbers, ThatAre condition)
        {
            return Select(numbers, condition);
        }

        public IList<int> SelectOdd(List<int> numbers, ThatAre condition)
        {
            return Select(numbers, condition);
        }

        public IList<int> Select(IList<int> numbers, params ThatAre[] conditions)
        {
            IList<int> result = new List<int>();




            foreach (var number in numbers)
            {
                foreach (var condition in conditions)
                {
                    if (predicates[condition](number))
                    {
                        result.Add(number);
                    }
                }
            }
            return result;
        }
    } 
 */

