package as.interfaces_and_inner_classes.ex6;

/**
 * Modify Music5.java by adding a Playable interface. Move the play( ) declaration from Instrument to Playable.
 * Add Playable to the derived classes by including it in the implements list.
 * Change tune( ) so that it takes a Playable instead of an Instrument.
 */

interface Playable {
    default void play(Note n) {  // Automatically public
        System.out.println(this + ".play() " + n);
    }
}

interface Instrument {
    // Compile-time constant:
    int VALUE = 5; // static & final

    default void adjust() {
        System.out.println("Adjusting " + this);
    }
}

class Wind implements Playable, Instrument {
    @Override
    public String toString() {
        return "Wind";
    }
}

class Percussion implements Playable, Instrument {
    @Override
    public String toString() {
        return "Percussion";
    }
}

class Stringed implements Playable, Instrument {
    @Override
    public String toString() {
        return "Stringed";
    }
}

class Brass extends Wind {
    @Override
    public String toString() {
        return "Brass";
    }
}

class Woodwind extends Wind {
    @Override
    public String toString() {
        return "Woodwind";
    }
}

public class Music5 {
    // Doesn't care about type, so new types
    // added to the system still work right:
    static void tune(Playable i) {
        // ...
        i.play(Note.MIDDLE_C);
    }

    static void tuneAll(Playable[] e) {
        for (Playable i : e)
            tune(i);
    }

    public static void main(String[] args) {
        // Upcasting during addition to the array:
        Playable[] orchestra = {
                new Wind(),
                new Percussion(),
                new Stringed(),
                new Brass(),
                new Woodwind()
        };
        tuneAll(orchestra);
    }
}
