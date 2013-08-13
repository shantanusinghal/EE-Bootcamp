using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace lol
{
    class Prototype
    {
        private IDictionary<string, dynamic> properties = new Dictionary<string, dynamic>();

        public dynamic this[string key]
        {
            get { return properties[key]; }
            set { properties[key] = value; }
        }
    }
}
