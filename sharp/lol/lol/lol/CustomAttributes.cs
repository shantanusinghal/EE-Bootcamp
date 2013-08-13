using System;
using System.Collections.Generic;
using System.Linq;
using System.Linq.Expressions;
using System.Reflection;

namespace lol
{
    [AttributeUsage(AttributeTargets.Method, AllowMultiple = false)]
    public class RunAttribute : System.Attribute { }

    public class CustomAttributes
    {
//        const BindingFlags BindingFlags = BindingFlags.NonPublic | BindingFlags.Public | BindingFlags.Static;
        
        public static void Process()
        {
            IEnumerable<Delegate> delegatesToExecute =
                from type in Assembly.GetCallingAssembly().GetTypes()
                from method in type.GetMethods(BindingFlags.NonPublic | BindingFlags.Public | BindingFlags.Static)
                where method.HasAttribute(typeof(RunAttribute))
                let delegateType = Expression.GetActionType(new List<Type>().ToArray())
                select method.CreateDelegate(delegateType, null);

            Invoke(delegatesToExecute.ToList());
        }

        private static void Invoke(List<Delegate> delegatesToExecute)
        {
            delegatesToExecute.ForEach(delegateToExecute => 
                {
                Console.Out.WriteLine("\n---------- {0} ----------\n", delegateToExecute.Method.Name);
                delegateToExecute.DynamicInvoke();
                });
        }
    }

    public static class MethodInfoExtension
    {
        public static bool HasAttribute(this MethodInfo target, Type attribute)
        {
            return target.GetCustomAttributes(attribute, false).Length > 0;
        }
    }
}