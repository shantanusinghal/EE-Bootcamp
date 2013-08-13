package ee.bootcamp.codingwithdhaval.Tmp;

public class Resource implements AutoCloseable {

    @Override
    public void close() throws Exception {
        System.out.println("closing now ..");
    }
}
