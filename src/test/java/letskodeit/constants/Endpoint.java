package letskodeit.constants;

public enum Endpoint {
    STORE("/HI");
    public final String url;

    Endpoint(String url) {
        this.url = url;
    }
}
