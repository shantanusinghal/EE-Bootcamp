using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TrainSignalling
{
    public class Track
    {
        private const int MIN_BLOCKS = 3;
        private List<Signal> Signals = new List<Signal>();

        public Track(params Signal[] signals)
        {
            foreach (var signal in signals) Signals.Add(signal);
        }

        public void TrainCrosses(Signal currentSignal)
        {
            GetTailingSignalsFrom(currentSignal).ForEach(signal =>
            signal.ToggleLight());
        }

        private List<Signal> GetTailingSignalsFrom(Signal currentSignal)
        {
            var endIndex = Signals.IndexOf(currentSignal);
            var startIndex = endIndex - MIN_BLOCKS >= 0 ? endIndex - MIN_BLOCKS : 0;
            return Signals.GetRange(startIndex, endIndex + 1);
        }
    }
}
