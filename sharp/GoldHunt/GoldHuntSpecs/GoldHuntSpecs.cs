using System;
using System.Collections.Generic;
using System.Linq;
using GoldHunt;
using Rhino.Mocks;
using Specifications = NUnit.Framework.TestFixtureAttribute;
using Specs = NUnit.Framework.TestAttribute;
using Before = NUnit.Framework.TestFixtureSetUpAttribute;
using Assert = NUnit.Framework.Assert;

namespace GoldHuntSpecs
{
    [Specifications]
    public class GoldHuntSpecs
    {
        private Maze stubMaze;
        private Players stubPlayers;

        [Before]
        public void Setup()
        {
            stubMaze = MockRepository.GenerateStub<Maze>();
            stubPlayers = MockRepository.GenerateStub<Players>();
        }

        [Specs]
        public void ItCreatesGameWithBoardAndPlayers()
        {
            //Given
            const string mazeInputString = "2 3\nD 2 0 D -1 0 T\nG D 6 0 D 0 3";
            const string playersInputString = "2\n1 4 2\n2 2 0";
            const string gameInput = mazeInputString + "\n" + playersInputString;
            
            //When
            GoldHuntGame game = new GoldHuntGame(stubMaze, stubPlayers).InitWith(gameInput);
            
            //Then
            List<string> mazeInputList = mazeInputString.Split('\n').ToList();
            List<string> playerInputList = playersInputString.Split('\n').ToList();
            stubMaze.AssertWasCalled(maze => maze.InitWith(mazeInputList));
            stubPlayers.AssertWasCalled(players => players.InitWith(playerInputList));
        }

        [Specs]
        public void ItIteratesOverPlayersToFindAWinner()
        {
            //Given
            string userInput = "1 2\nG T\n2\n1 0 1\n2 0 0";
            
            //When
            Maze maze = new Maze();
            Players players = new Players();
            string winner = new GoldHuntGame(maze, players).InitWith(userInput).Start();
            
            //Then
            Assert.AreEqual("2", winner);
        }

//        [Specs]
//        public void ItLoopsContinuoulsyUntilWinnerIsFound()
//        {
//            //Given
//            string userInput = "5 4\nD 2 0 D 0 2 T D 3 0\nT D 6 0 D 0 3 D 2 0\nD 0 -1 D 1 0 G D 0 -1\nD 0 3 D 0 2 D 0 2 D 0 3\nD -1 0 T D 0 -3 T\n4\n1 4 2\n2 2 0\n3 0 3\n4 2 3";
//            GoldHuntGame game = new GoldHuntGame(userInput);
//            //When
//            string winner = game.Start();
//            //Then
//            Assert.AreEqual("4", winner);
//        }

    }
}
