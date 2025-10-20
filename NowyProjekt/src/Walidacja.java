public class Walidacja {
    private static final String name = "tajniak";
    private static final String password = "1234";

    public static boolean authenticate(String name, String password) {
        if(Walidacja.name.equals(name) & Walidacja.password.equals(password))
            return true;
        else
            return false;
    }
}