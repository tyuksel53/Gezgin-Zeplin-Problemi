package Model;

public class Node {

    private int plakaKodu;

    private int[] komsuluklar;


    private int kordinatX;
    private int kordinatY;

    private double latitude;
    private double longitute;
    private int altitude;

    public void setPlakaKodu(int plakaKodu) {
        this.plakaKodu = plakaKodu;
    }

    public void setKomsuluklar(int[] komsuluklar) {
        this.komsuluklar = komsuluklar;
    }

    public void setKordinatX(int kordinatX) {
        this.kordinatX = kordinatX;
    }

    public void setKordinatY(int kordinatY) {
        this.kordinatY = kordinatY;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitute(double longitute) {
        this.longitute = longitute;
    }

    public void setAltitude(int altitude) {
        this.altitude = altitude;
    }

    public int getPlakaKodu() {

        return plakaKodu;
    }

    public int[] getKomsuluklar() {
        return komsuluklar;
    }

    public int getKordinatX() {
        return kordinatX;
    }

    public int getKordinatY() {
        return kordinatY;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitute() {
        return longitute;
    }

    public int getAltitude() {
        return altitude;
    }

}
