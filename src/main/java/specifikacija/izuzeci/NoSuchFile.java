package specifikacija.izuzeci;

public class NoSuchFile extends Exception{
    String message = "Greska! Fajl/direktorijum ne postoji.";

    @Override
    public String getMessage() {
        return message;
    }
}
