using System;
using System.Collections.Generic;
using System.Linq;
using System.Linq.Expressions;
using System.Text;
using System.Threading.Tasks;

//http://hibernatingrhinos.com/oss/rhino-mocks
//http://ayende.com/wiki/Rhino+Mocks+3.5.ashx#WhatisthedifferencebetweenGenerateStubandGenerateMock

namespace GoldHunt
{
    public delegate Tuple<int, int> DisplacementCell(Tuple<int, int> currentPos);
    public delegate Tuple<int, int> TrapCell(Tuple<int, int> currentPos);
    public delegate void GoldCell(Tuple<int, int> currentPos);
    
    public class Maze
    {
        public Delegate[,] Board { get; private set; }

        public virtual Maze InitWith(List<string> userInput)
        {
            var allRows = userInput.ToArray();
            var rows = Convert.ToInt32(allRows[0].Split(' ')[0]);
            var columns = Convert.ToInt32(allRows[0].Split(' ')[1]);
            var contentRows = allRows.Skip(1).ToArray();
            Populate(rows, columns, contentRows);
            return this;
        }

        private void Populate(int rows, int columns, IList<string> contentRows)
        {
            Board = new Delegate[rows, columns];
        
            for (int rowIndex = 0; rowIndex < contentRows.Count(); rowIndex++)
            {
                var elementsInRow = contentRows[rowIndex].Split(' ');
                for (int columnIndex = 0, col = 0; columnIndex < elementsInRow.Count(); columnIndex++)
                {
                    switch (elementsInRow[columnIndex])
                    {
                        case "D":
                            var deltaX = Convert.ToInt32(elementsInRow[++columnIndex]);
                            var deltaY = Convert.ToInt32(elementsInRow[++columnIndex]);
                            Board[rowIndex, col++] = new DisplacementCell(
                                current =>
                                new Tuple<int, int>(Math.Abs(current.Item1 + deltaX)% rows,
                                                    Math.Abs(current.Item2 + deltaY)% columns));
                            break;

                        case "T":
                            Board[rowIndex, col++] = new TrapCell(
                                current => current);
                            break;

                        case "G":
                            Board[rowIndex, col++] = new GoldCell(
                                current => Console.Out.WriteLine("GAME OVER"));
                            break;
                    }
                }
            }
        }

        public Tuple<int, int> GetNextPositionFrom(Tuple<int, int> value, out Type cellType)
        {
            cellType = Board[value.Item1, value.Item2].GetType();
            return (Tuple<int, int>)Board[value.Item1, value.Item2].DynamicInvoke(value);
        }
    }
}
