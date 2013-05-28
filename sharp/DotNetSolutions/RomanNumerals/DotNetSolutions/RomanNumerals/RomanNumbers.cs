using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace RomanNumbers
{
    public class RomanNumber
    {
        private IDictionary<String, int> romanNumerals;
        private int[] numbers;
        private int _decimalValue;

        public RomanNumber()
        {
            romanNumerals = new Dictionary<string, int>()
                {
                    {"I", 1},
                    {"V", 5},
                    {"X", 10},
                    {"L", 50},
                    {"C", 100},
                    {"D", 500},
                    {"M", 1000}
                };
            numbers = new int[0];
        }

        public int DecimalValue
        {
            get
            {
                _decimalValue = 0;
                int lastValue = 0;
                foreach (int numeral in numbers)
                {
                    _decimalValue += lastValue <= numeral ? numeral : (numeral * -1);
                    lastValue = numeral;
                }
                return _decimalValue;
            }
        }

        public RomanNumber InitWithString(string numberAsString)
        {
            int size = numberAsString.ToCharArray().Length;
            numbers = new int[size];
            foreach (char number in numberAsString)
            {
                numbers[--size] = romanNumerals[number.ToString()];
            }
            return this;
        }
    }
}
