using System;
using System.Collections.Generic;
using System.Linq;

namespace GoldHunt
{
    public class Players
    {
        private int index;
        public IDictionary<string, Tuple<int, int>> PlayersMap { get; set; }

        public virtual IDictionary<string, Tuple<int, int>> InitWith(List<string> userInput)
        {
            var allRows = userInput.ToArray();
            var numberOfPlayers = Convert.ToInt32(allRows[0]);
            string[] playerRows = allRows.Skip(1).ToArray();
            InitWith(numberOfPlayers, playerRows);
            index = 0;
            return PlayersMap;
        }

        private void InitWith(int numberOfPlayers, IEnumerable<string> playerRows)
        {
            PlayersMap = new Dictionary<string, Tuple<int, int>>(numberOfPlayers);
            foreach (var playerRow in playerRows)
            {
                var playerInfo = playerRow.Split(' ');
                var playerId = playerInfo[0];
                var xpos = Convert.ToInt32(playerInfo[1]);
                var ypos = Convert.ToInt32(playerInfo[2]);
                var playerPosition = new Tuple<int, int>(xpos, ypos);

                PlayersMap.Add(playerId, playerPosition);
            }
        }

        public string GetNext()
        {
            return PlayersMap.Keys.ToList()[RotateIndex()];
        }

        private int RotateIndex()
        {
            if (++index > PlayersMap.Keys.Count)
            {
                return index%PlayersMap.Keys.Count;
            }
            return index;
        }
    }
}