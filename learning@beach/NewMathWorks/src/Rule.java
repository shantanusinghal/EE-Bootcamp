import java.util.ArrayList;

public enum Rule {

    ONLY_PRIMES {

        @Override
        boolean test (Integer inputNumber) {

            if (inputNumber == 1) {

                return false;
            }

            for (int number = 2; number < inputNumber; number++) {

                if (inputNumber % number == 0) {

                    return false;
                }
            }

            return true;
        }
    },

    ONLY_ODDS {

        @Override
        boolean test (Integer inputNumber) {

            if (inputNumber % 2 == 0) {

                    return false;
            }

            return true;
        }
    },

    WITHIN_RANGE {

        private int floor;
        private int ceiling;

        ArrayList <Integer> outputNumbers = new ArrayList <Integer> ();

        @Override
        public Rule setRange (int floor, int ceiling) {

            this.floor = floor;
            this.ceiling = ceiling;

            return this;
        }

        @Override
        boolean test (Integer inputNumber) {

            if (inputNumber >= floor && inputNumber <= ceiling) {

              return true;
            }

            return false;
        }
    };

    abstract boolean test (Integer inputNumber);

    public Rule setRange (int floor, int ceiling) {

        return this;
    }

}