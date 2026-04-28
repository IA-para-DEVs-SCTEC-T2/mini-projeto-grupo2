import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Duplicate {

    public static boolean hasDuplicate(List<Integer> nums) {
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (!seen.add(num)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(hasDuplicate(List.of(1, 2, 3, 4)));    // false
        System.out.println(hasDuplicate(List.of(1, 2, 3, 1)));    // true
    }
}
