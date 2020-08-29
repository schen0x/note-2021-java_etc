enum Cp9_PolyUpcasting_Note {
    MIDDLE_C, C_SHARP, B_FLAT
}


class Cp9_PolyUpcasting_Instrument {
    private int i;

    public void play(Cp9_PolyUpcasting_Note n) {
        System.out.println("Instrument.play()");
    }

    protected void geti() {
        i = 12;
        System.out.println("geti()" + i);
    }
}


class Cp9_PolyUpcasting_Wind extends Cp9_PolyUpcasting_Instrument {
    @Override
    public void play(Cp9_PolyUpcasting_Note n) {
        System.out.println("Wind.play()" + n);
    }

    public void newM() {
        System.out.println("newM");
    }
}


public class Cp9_PolyUpcasting {
    public static void tune(Cp9_PolyUpcasting_Instrument i) { // Polymorphism reduce duplicated code here and only
                                            // here.
        i.play(Cp9_PolyUpcasting_Note.MIDDLE_C);
        ((Cp9_PolyUpcasting_Wind) i).newM(); // Or cannot call newM(), since it's not in the Instrument class.
    }

    public static void main(String[] args) {
        Cp9_PolyUpcasting_Wind flute = new Cp9_PolyUpcasting_Wind();
        tune(flute); // Upcasting
        Cp9_PolyUpcasting_Instrument a = flute;
        tune(a); // Result unchanged.
        a.geti();
        flute.geti();
        System.out.println(a.getClass()); // class wind
    }
}
