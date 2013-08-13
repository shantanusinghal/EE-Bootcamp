using System;
using System.Collections.Generic;
using System.Linq;

namespace GoldHunt
{
    public class GoldHuntGame
    {
        private Maze Maze { get; set; }
        private IDictionary<string, Tuple<int, int>> Players { get; set; }

        public GoldHuntGame(Maze maze, Players players)
        {
            Maze = maze;
            Players = players;
        }

        public GoldHuntGame InitWith(string userInput)
        {
            var allRows = userInput.Split('\n');
            var mazeRows = Convert.ToInt32(allRows[0].Split(' ')[0]) + 1;
            var playerRows = Convert.ToInt32(allRows[mazeRows]) + 1;

            var mazeInput = allRows.ToList().GetRange(0, mazeRows);
            var playerInput = allRows.ToList().GetRange(mazeRows, playerRows);

            Maze.InitWith(mazeInput);
            Players = new Players().InitWith(playerInput);
            return this;
        }

        public string Start()
        {
            Type cellType;
            while (true)
            {
                string key = Players.GetNext();
                Players.PlayersMap[key] = Maze.GetNextPositionFrom(Players.PlayersMap[key], out cellType);
                if (cellType == typeof(GoldCell))
                    return key;
            }

//            Type cellType;
//            IEnumerator<string> enumerator = Players.PlayersMap.Keys.GetEnumerator();
//            while (true)
//            {
//                if (!enumerator.MoveNext()) { 
//                    enumerator.Reset();
//                    enumerator.MoveNext();
//                }
//                Tuple<int, int> playerPosition = Players.PlayersMap[enumerator.Current];
//                playerPosition = Maze.GetNextPositionFrom(playerPosition, out cellType);
//                if (cellType == typeof (GoldCell))
//                    return enumerator.Current;
//            }
        }
    }
}