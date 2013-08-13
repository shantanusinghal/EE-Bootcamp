using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MathWorks
{
    public delegate bool Predicate(int item);
    public delegate List<int> Selector(ThatAre condition, IList<int> inList);

    public enum ThatAre
    {
        Even, Odd, Prime
    }

    public class Filter
    {
        public Predicate IsEven;
        public Predicate IsOdd;
        public Predicate IsPrime;
        public Selector NumberSelector;
        public Func<int, int, bool> Check;
        private IDictionary<ThatAre, Predicate> predicateFor = new Dictionary<ThatAre, Predicate>();

        public Filter()
        {
            IsOdd = x => !IsEven(x);
            IsEven = x => x % 2 == 0;
            IsPrime = x => Check(x, x / 2);
            Check = (x, y) => (y != 0) && ((y == 1) || (x % y != 0 && Check(x, y - 1)));
            predicateFor.Add(ThatAre.Odd, IsOdd);
            predicateFor.Add(ThatAre.Even, IsEven);
            predicateFor.Add(ThatAre.Prime, IsPrime);
            NumberSelector = (ThatAre condition, IList<int> inList) => inList.Where(item => predicateFor[condition](item)).ToList();
        }

        public IList<int> Select(List<int> numbers, params ThatAre[] conditions)
        {
//            IsPrime.GetInvocationList()
            return conditions.Aggregate(numbers, (currentList, condition) => NumberSelector(condition, currentList));
        }
    }
}

/*
 * 
 * 
 * 
 * Predicate isPrime = x => (x >= 2) && Enumerable.Range(2, x - 2).All(f => x%f != 0);
 * 
 * 
 public class Filter
    {
        public Predicate IsEven;
        public Predicate IsOdd;
        public Predicate IsPrime;
        public Selector NumberSelector;
        public Func<int, int, bool> Check;
        private IDictionary<ThatAre, Predicate> predicates = new Dictionary<ThatAre, Predicate>();

        public Filter()
        {
            IsOdd = x => !IsEven(x);
            IsEven = x => x % 2 == 0;
            IsPrime = x => Check(x, x/2);
            Check = (x, y) => (y != 0) && ((y == 1) || (x % y != 0 && Check(x, y - 1)));
//            Predicate isPrime = x => (x >= 2) && Enumerable.Range(2, x - 2).All(f => x%f != 0);
            
            predicates.Add(ThatAre.Odd, IsOdd);
            predicates.Add(ThatAre.Even, IsEven);
            predicates.Add(ThatAre.Prime, IsPrime);
            NumberSelector = (ThatAre cond, ref List<int> list) => list = list.Where(item => predicates[cond](item)).ToList();
        }

        public IList<int> Select(List<int> numbers, params ThatAre[] conditions)
        {
            conditions.ToList().ForEach(condition => NumberSelector(condition, ref numbers));
            return numbers;
        }
    }
 * 
 * //            conditions.Aggregate(condition => NumberSelector(condition, ref numbers));

 */
