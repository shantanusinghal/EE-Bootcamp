using System;
using System.Collections.Generic;
using GoldHunt;
using Specifications = NUnit.Framework.TestFixtureAttribute;
using Specs = NUnit.Framework.TestAttribute;
using Before = NUnit.Framework.TestFixtureSetUpAttribute;
using Assert = NUnit.Framework.Assert;

namespace GoldHuntSpecs
{
    [Specifications]
    public class PlayerSpecs
    {
        [Specs]
        public void ItGeneratesPlayersWithUserInput()
        {
            //Given
            var playersInput = new List<string> { "2", "1 4 2", "2 2 0" };
            //When
            var players = new Players().InitWith(playersInput).PlayersMap;
            //Then
            Assert.AreEqual(2, players.Count);
            Assert.AreEqual(new Tuple<int, int>(4, 2), players["1"]);
            Assert.AreEqual(new Tuple<int, int>(2, 0), players["2"]);
        }
    }
}