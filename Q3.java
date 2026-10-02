class PasswordChecker {
    private final String password;

    public PasswordChecker(String password) {
        this.password = password;
    }

    public String getStrength() {

        int length = password.length();

        if (length < 6) {
            return "Weak";
        }
        else if (length <= 9) {
            return "Medium";
        }
        else {
            return "Strong";
        }
    }
}

public class Q3 {
    public static void main(String[] args) {

        System.out.println("Name: Pritham M");

        PasswordChecker pc1 = new PasswordChecker("abcd");
        System.out.println("Password 1: " + pc1.getStrength());

        PasswordChecker pc2 = new PasswordChecker("abcdefgh");
        System.out.println("Password 2: " + pc2.getStrength());

        PasswordChecker pc3 = new PasswordChecker("abcdefghijkl");
        System.out.println("Password 3: " + pc3.getStrength());
    }
}