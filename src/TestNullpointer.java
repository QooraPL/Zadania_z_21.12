public class TestNullpointer {

    public static void main(String[] args) {

        try {
            String s = null;
            System.out.println(s.length());
        } catch (NullPointerException e) {
            System.out.println("Error catched: " + e.getMessage());
        }
    }
}
