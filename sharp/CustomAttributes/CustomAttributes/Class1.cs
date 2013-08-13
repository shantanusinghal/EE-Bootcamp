using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Dynamic;
using System.Linq;
using System.Linq.Expressions;
using System.Reflection;
using System.Reflection.Emit;
using System.Text;
using System.Threading;
using System.Threading.Tasks;
using CustomAttributes;

namespace CustomAttributes
{
    public delegate void MyDelegate();

    [AttributeUsage(AttributeTargets.Method, AllowMultiple = false)]
    public class RunAttribute : System.Attribute { }

    public class MainClass
    {
        public static void Main(string[] args)
        {
            Preprocessing();
        }


        private static void Preprocessing()
        {
            Type[] types = Assembly.GetExecutingAssembly().GetTypes();

            foreach (Type type in types)
            {
                foreach (MethodInfo method in type.GetMethods())
                {
                    if (method.HasAttribute(typeof (RunAttribute)))
                    {
                        //Creating a Delegate
                        var emptyList = new List<Type>();
                        Type delegateType = Expression.GetActionType(emptyList.ToArray());
                        Delegate anotherDelegate = method.CreateDelegate(delegateType, null);
                        anotherDelegate.DynamicInvoke();

                        //Invoking a Method
//                        ConstructorInfo constructorInfo = type.GetConstructor(Type.EmptyTypes);
//                        object classObject = constructorInfo.Invoke(new object[]{});
//                        method.Invoke(classObject, null);
                        
                    }
                }
            }
        }
    }

    public static class MethodInfoExtension
    {
        public static bool HasAttribute(this MethodInfo target, Type attribute)
        {
            var attributes = target.GetCustomAttributes(attribute, false);  
            return attributes.Length > 0;
        }
    }
}
