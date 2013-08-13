using System;
using System.Collections.Generic;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using NUnit.Framework;
using TrainSignalling;

using Specifications = NUnit.Framework.TestFixtureAttribute;
using Specs = NUnit.Framework.TestAttribute;
using Before = NUnit.Framework.TestFixtureSetUpAttribute;
using Assert = NUnit.Framework.Assert;

namespace TrainSignallingSpecs
{
    [Specifications]
    public class TrainSignallingSpecs
    {
        [Specs]
        public void ItTurnLightRedAtCrossingStation()
        {
            //Given
            var signalS0 = new Signal() {Name = "S0", Light = Light.GREEN};
            var track = new Track(signalS0);
            //When
            track.TrainCrosses(signalS0);
            //Then
            Assert.AreEqual(Light.RED, signalS0.Light);
        }

        [Specs]
        public void ItTurnLightYellowAtLastStation()
        {
            //Given
            var signalS0 = new Signal() { Name = "S0", Light = Light.RED };
            var signalS1 = new Signal() { Name = "S1", Light = Light.GREEN };
            var track = new Track(signalS0, signalS1);
            //When
            track.TrainCrosses(signalS1);
            //Then
            Assert.AreEqual(Light.YELLOW, signalS0.Light);
        }

        [Specs]
        public void ItTurnLightDoubleYellowTwoStationBack()
        {
            //Given
            var signalS0 = new Signal() { Name = "S0", Light = Light.YELLOW };
            var signalS1 = new Signal() { Name = "S1", Light = Light.RED };
            var signalS2 = new Signal() { Name = "S2", Light = Light.GREEN };
            var track = new Track(signalS0, signalS1, signalS2);
            //When
            track.TrainCrosses(signalS2);
            //Then
            Assert.AreEqual(Light.DOUBLE_YELLOW, signalS0.Light);
        }

        [Specs]
        public void ItTurnLightGreenThreeStationBack()
        {
            //Given
            var signalS0 = new Signal() { Name = "S0", Light = Light.DOUBLE_YELLOW };
            var signalS1 = new Signal() { Name = "S1", Light = Light.YELLOW };
            var signalS2 = new Signal() { Name = "S2", Light = Light.RED };
            var signalS3 = new Signal() { Name = "S3", Light = Light.GREEN };
            var track = new Track(signalS0, signalS1, signalS2, signalS3 );
            //When
            track.TrainCrosses(signalS3);
            //Then
            Assert.AreEqual(Light.GREEN, signalS0.Light);
        }
    }

}
