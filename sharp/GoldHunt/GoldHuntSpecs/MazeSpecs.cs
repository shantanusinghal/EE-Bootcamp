using System.Collections.Generic;
using GoldHunt;
using Specifications = NUnit.Framework.TestFixtureAttribute;
using Specs = NUnit.Framework.TestAttribute;
using Before = NUnit.Framework.TestFixtureSetUpAttribute;
using Assert = NUnit.Framework.Assert;

namespace GoldHuntSpecs
{
    [Specifications]
    public class MazeSpecs
    {
        [Specs]
        public void ItGeneratesMazeWithUserInput()
        {
            //Given
            var mazeInput = new List<string> { "2 3", "D 2 0 D -1 0 T", "G D 6 0 D 0 3" };
            //When
            var board = new Maze().InitWith(mazeInput).Board;
            //Then
            Assert.AreEqual(2 * 3, board.Length);
            Assert.AreEqual(typeof(DisplacementCell), board[0, 0].GetType());
            Assert.AreEqual(typeof(DisplacementCell), board[0, 1].GetType());
            Assert.AreEqual(typeof(TrapCell), board[0, 2].GetType());
            Assert.AreEqual(typeof(GoldCell), board[1, 0].GetType());
            Assert.AreEqual(typeof(DisplacementCell), board[1, 1].GetType());
            Assert.AreEqual(typeof(DisplacementCell), board[1, 2].GetType());
        }
    }
}