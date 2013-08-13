namespace lol
{
    public abstract class Animal
    {
        public abstract string Speak();
    }

    public class Dog : Animal
    {
        public override string Speak()
        {
            return "I am a Dog";
        }
    }

    public class Cat : Animal
    {
        public override string Speak()
        {
            return "I am a Cat";
        }
    }
}