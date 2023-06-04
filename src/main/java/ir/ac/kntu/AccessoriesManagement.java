package ir.ac.kntu;

import java.util.ArrayList;
import java.util.List;

public class AccessoriesManagement {
    private static List<Accessories> accessoriesArr = new ArrayList<Accessories>();

    public static List<Accessories> getAccessoriesArr() {
        return accessoriesArr;
    }
}
