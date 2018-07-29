package as.detecting_types.ex9;

/**
 * Incorporate a new kind of interface into ToyTest.java and verify that it is detected and displayed properly.
 */

interface HasBatteries {
}

interface Waterproof {
}

interface ShootsThings {
}

interface EyesLasers {

}

class Toy {
    // Comment out the following default
    // constructor to see
    // NoSuchMethodError from (*1*)
    Toy() {
    }

    Toy(int i) {
    }
}

class FancyToy extends Toy implements HasBatteries,
        Waterproof, ShootsThings, EyesLasers {
    FancyToy() {
        super(1);
    }
}

public class ToyTest {
    public static void main(String[] args) throws Exception {
        Class c = null;
        try {
            c = Class.forName("as.detecting_types.ex9.FancyToy");
        } catch (ClassNotFoundException e) {
            System.err.println("Can't find FancyToy");
            throw e;
        }
        printInfo(c);
        Class[] faces = c.getInterfaces();
        for (int i = 0; i < faces.length; i++)
            printInfo(faces[i]);
        Class cy = c.getSuperclass();
        Object o = null;
        try {
            // Requires default constructor:
            o = cy.newInstance(); // (*1*)
        } catch (InstantiationException e) {
            System.err.println("Cannot instantiate");
            throw e;
        } catch (IllegalAccessException e) {
            System.err.println("Cannot access");
            throw e;
        }
        //printInfo(o.getClass());
    }

    static void printInfo(Class cc) {
        System.out.println(
                "Class name: " + cc.getName() +
                        " is interface? [" +
                        cc.isInterface() + "]");
    }
}
