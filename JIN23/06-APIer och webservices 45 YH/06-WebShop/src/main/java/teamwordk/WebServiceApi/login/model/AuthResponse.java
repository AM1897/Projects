package teamwordk.WebServiceApi.login.model;

/**
 * En klass för att skicka autentiseringssvar till klienten.
 * Den innehåller vanligtvis en autentiseringstoken och andra relevanta uppgifter.
 */
public class AuthResponse {

    private String token;
    private String username;

    // Konstruktorer

    public AuthResponse(String token, String username) {
        this.token = token;
        this.username = username;
    }

    // Getters och Setters

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
