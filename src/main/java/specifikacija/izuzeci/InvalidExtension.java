package specifikacija.izuzeci;

public class InvalidExtension extends Exception{
    String message = "Greska! Nedozvoljena ekstenzija fajla.";

    @Override
    public String getMessage() {
        return message;
    }
}
