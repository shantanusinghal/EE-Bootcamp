package ee.bootcamp.codingwithdhaval;

public enum ThatAre {
    PRIME {
        @Override
        public boolean isSatisfiedBy(Integer number) {
            if (number < 2) {
                return false;
            }
            for (long i = 2; i*i <= number; i++) {
                if (number % i == 0) {
                    return false;
                }
            }
            return true;
        }
    },
    ODD {
        @Override
        public boolean isSatisfiedBy(Integer number) {
            return number%2==1;
        }
    };

    public abstract boolean isSatisfiedBy(Integer number);
}
