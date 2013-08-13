namespace TrainSignalling
{
    public enum Light
    {
        GREEN, RED, YELLOW, DOUBLE_YELLOW
    }

    public class Signal
    {
        public string Name { get; set; }
        public Light Light { get; set; }

        public void ToggleLight()
        {
            Light = (Light)((int)(Light + 1) % 4);
        } 
    }
}