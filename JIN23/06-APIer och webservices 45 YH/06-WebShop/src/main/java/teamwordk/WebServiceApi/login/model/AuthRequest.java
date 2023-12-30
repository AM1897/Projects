package teamwordk.WebServiceApi.login.model;

/**
 * En klass för att hantera inloggningsförfrågningar.
 * Den innehåller de uppgifter som användaren måste skicka för att logga in.
 */
public class AuthRequest {

    private String username;
    private String password;

    // Konstruktorer

    public AuthRequest() {
        // Används av JPA och/eller Spring MVC
    }

    public AuthRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getters och Setters

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
