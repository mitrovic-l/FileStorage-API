package specifikacija.izuzeci;

public class DuplicateName extends Exception{
    String message = "Greska! Direktorijum/fajl sa istim imenom vec postoji.";

    @Override
    public String getMessage() {
        return message;
    }
}
