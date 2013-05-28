using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace lol
{
    internal delegate void CodeBlock();

    static class IntExtension
    {
        public static void Times(this int value, CodeBlock codeBlock)
        {
            for (int i = 0; i < value; i++)
            {
                codeBlock();
            }
        }
    }
}
