using System;
using MathWorks;
using System.Collections.Generic;
using Microsoft.VisualStudio.TestTools.UnitTesting;

using Specifications = Microsoft.VisualStudio.TestTools.UnitTesting.TestClassAttribute;
using Specs = Microsoft.VisualStudio.TestTools.UnitTesting.TestMethodAttribute;
using Assert = NUnit.Framework.Assert;

namespace MathWorksSpecs
{
    [Specifications]
    public class MathWorkUnitTests
    {

        [Specs]
        public void ItSelectsEvenNumbers()
        {
            //Given
            var numbers = new List<int> {1,2,3,4,5};
            //When
            var filter = new Filter();
            IList<int> result = filter.Select(numbers, ThatAre.Even);
            //Then
            IList<int> expected = new List<int> {2,4};
            Assert.AreEqual(expected, result);
        }

        [Specs]
        public void ItSelectsOddNumbers()
        {
            //Given
            var numbers = new List<int> {1, 2, 3, 4, 5};
            //When
            var filter = new Filter();
            var result = filter.Select(numbers, ThatAre.Odd);
            //Then
            var expected = new List<int> {1, 3, 5};
            Assert.AreEqual(expected, result);
        }

        [Specs]
        public void ItSelectsPrimes()
        {
            //Given
            var numbers = new List<int> { 1, 2, 3, 4, 5 };
            //When
            var filter = new Filter();
            var result = filter.Select(numbers, ThatAre.Prime);
            //Then
            var expected = new List<int> { 2, 3, 5 };
            Assert.AreEqual(expected, result);   
        }

        [Specs]
        public void ItSelectsOddPrimes()
        {
            //Given
            var numbers = new List<int> { 1, 2, 3, 4, 5 };
            //When
            var filter = new Filter();
            var result = filter.Select(numbers, ThatAre.Prime, ThatAre.Odd);
            //Then
            var expected = new List<int> { 3, 5 };
            Assert.AreEqual(expected, result);   
        }

//        [Specs]
//        public void ItSelectsNumbersInRange()
//        {
//            //Given
//            var numbers = new List<int> { 1, 2, 3, 4, 5 };
//            //When
//            var filter = new Filter();
//            var result = filter.Select(numbers, ThatAre.Even);
//            //Then
//            var expected = new List<int> { 3, 5 };
//            Assert.AreEqual(expected, result);   
//
//        }

    }
}
