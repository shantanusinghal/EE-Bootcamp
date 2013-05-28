using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;

using Specifications = Microsoft.VisualStudio.TestTools.UnitTesting.TestClassAttribute;
using Specs = Microsoft.VisualStudio.TestTools.UnitTesting.TestMethodAttribute;
using Assert = NUnit.Framework.Assert;

using RomanNumbers;

namespace RomanNumeralSpecs
{
    [Specifications]
    public class RomanNumberSpecs
    {
        [Specs]
        public void ItReturnsTheValueOfSingleDigitRomanNumber()
        {
            //Given
            const string singleDigitRomalNumber = "V";
            //When
            RomanNumber romanNumber = new RomanNumber().InitWithString(singleDigitRomalNumber);
            //Then
            Assert.AreEqual(5, romanNumber.DecimalValue);
        }

        [Specs]
        public void ItAddsNumeralInAscendingOrderFromLeftToRight()
        {
            //Given
            const string romanNumberString = "VII";
            //When
            RomanNumber romanNumber = new RomanNumber().InitWithString(romanNumberString);
            //Then
            Assert.AreEqual(7, romanNumber.DecimalValue);
        }

        [Specs]
        public void ItSubstractsLowerValueNumeralAppearingBeforeHigherValueNumeral()
        {
            //Given
            const string romanNumberString = "IV";
            //When
            RomanNumber romanNumber = new RomanNumber().InitWithString(romanNumberString);
            //Then
            Assert.AreEqual(4, romanNumber.DecimalValue);
        }

        [Specs]
        public void ItAppliesBothRulesToCaculateDecimalValue()
        {
            //Given
            const string romanNumberString = "XXXIX";
            //When
            RomanNumber romanNumber = new RomanNumber().InitWithString(romanNumberString);
            //Then
            Assert.AreEqual(39, romanNumber.DecimalValue);
        }

//        [Specs]
//        public void ItValidatesDuringInitialization()
//        {
//            //Given
//            const string romanNumberString = "XLIV";
//            //When
//            RomanNumber romanNumber = new RomanNumber().InitWithString(romanNumberString);
//            //Then
//            Assert.AreEqual(44, romanNumber.ToDecimal());
//        }
    }

}
