package arrayString.OneEditAway;

public class Strings {
    private Strings() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static void main(String[] args) {
        String q1 = "tank";
        String p1 = "tanc";

        String q2 = "tnk";
        String p2 = "tank";

        String q3 = "tank";
        String p3 = "tinck";

        String q4 = "tank";
        String p4 = "tankist";

        String q5 = "tank";
        String p5 = "tlank";

        System.out.println("Result: " + isOneEditAway(q1, p1));
        System.out.println("Result: " + isOneEditAway(q2, p2));
        System.out.println("Result: " + isOneEditAway(q3, p3));
        System.out.println("Result: " + isOneEditAway(q4, p4));
        System.out.println("Result: " + isOneEditAway(q5, p5));
    }

    public static boolean isOneEditAway(String p, String q) {
        if (p == null || q == null || p.isBlank() || q.isBlank()) {
            return false;
        }

        // 길이 자체가 2 이상 차이나는 경우
        if (Math.abs(q.length() - p.length()) > 1) {
            return false;
        }

        String shorter = p.length() > q.length() ? q : p;
        String longer = q.length() > p.length() ? q : p;

        // 짧은 문자열과 긴 문자열의 인덱스를 다르게 관리
        int is = 0;
        int il = 0;
        boolean marker = false;

        while (is < shorter.length() && il < longer.length()) {
            if (shorter.charAt(is) != longer.charAt(il)) {
                if (marker) {
                    return false;
                }

                marker = true;

                if (shorter.length() == longer.length()) {
                    is++;
                }
            } else {
                is++;
            }
            il++;
        }

        return true;
    }
}
