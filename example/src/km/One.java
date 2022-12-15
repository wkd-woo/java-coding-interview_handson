import java.util.*;

class One {
    public String solution(String S, String C) {
        C = C.toLowerCase();

        String[] names = S.split(", ");
        Set<String> map = new HashSet<>();
        List<String> answer = new ArrayList<>();
        for (String name : names) {
            String[] comb = name.split(" ");
            String first = comb[0].replace("-", "").substring(0, 1).toLowerCase();
            String middle = "";
            String last = "";
            if (comb.length == 3) {
                middle = comb[1].replace("-", "").toLowerCase().substring(0, 1);
                last = comb[2].replace("-", "").toLowerCase();
            } else if (comb.length == 2) {
                last = comb[1].replace("-", "").toLowerCase();
            }
            if (last.length() > 8) {
                last = last.substring(0, 8);
            }
            String id = first + middle + last;
            int idx = 2;
            String temp = first + middle + last;
            while (map.contains(temp)) {
                temp = id + Integer.toString(idx);
                idx++;
            }
            map.add(temp);
            String mail = "<" + temp + "@" + C + ".com>";
            answer.add(mail);
        }
        for (int i = 0; i < names.length; i++) {
            names[i] = names[i] + " " + answer.get(i);
        }

        String result = "";
        for (String name : names) {
            result = result + name + ", ";
        }
        return result.substring(0, result.length() - 2);
    }
}
