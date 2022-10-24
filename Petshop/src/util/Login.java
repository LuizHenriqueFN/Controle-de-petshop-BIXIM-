package util;

public class Login {
    private static final String nome = "jj";
    private static final String password = "jj";

    public Login() {
    }

    public static boolean logar(String nome, String password) {
        if (nome.equals(Login.nome) && password.equals(Login.password))
            return true;

        return false;
    }

}
