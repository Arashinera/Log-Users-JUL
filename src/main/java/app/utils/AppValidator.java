package app.utils;

public class AppValidator {

    public final static String ID_RGX = "^[1-9]$";
    public final static String EMAIL_RGX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

    public static boolean isIdValid(String id) {
        if (id != null)
            return id.isEmpty() || !id.matches(ID_RGX);
        return false;
    }

    public static boolean isEmailValid(String email) {
        if (email != null)
            return email.isEmpty() || !email.matches(EMAIL_RGX);
        return false;
    }
}
