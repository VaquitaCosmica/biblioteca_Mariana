package modelos;

import org.apache.commons.codec.digest.DigestUtils;

public class Usuario {

    private String user, password;

    public Usuario(String user, String password) {
        this.user = user;
        this.password = DigestUtils.md5Hex(password);
    }

    public Usuario() {
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
