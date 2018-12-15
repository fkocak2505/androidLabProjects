package tr.org.tobb.cartezienlistview;

/**
 * Created by fatihkocak on 10.05.2018.
 */

public class ModelOfCars {

    private String model;
    private String plaka;
    private String renk;
    private int koltukSayisi;
    private String hat;

    public ModelOfCars() {}

    public ModelOfCars(String model, String plaka, String renk, int koltukSayisi,String hat) {
        this.model = model;
        this.plaka = plaka;
        this.renk = renk;
        this.koltukSayisi = koltukSayisi;
        this.hat = hat;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPlaka() {
        return plaka;
    }

    public void setPlaka(String plaka) {
        this.plaka = plaka;
    }

    public String getRenk() {
        return renk;
    }

    public void setRenk(String renk) {
        this.renk = renk;
    }

    public int getKoltukSayisi() {
        return koltukSayisi;
    }

    public void setKoltukSayisi(int koltukSayisi) {
        this.koltukSayisi = koltukSayisi;
    }

    public String getHat() {
        return hat;
    }

    public void setHat(String hat) {
        this.hat = hat;
    }
}
