package hackerrank;

import java.util.Comparator;

public class SortComparator implements Comparator<SortComparator.Player> {


    @Override
    public int compare(Player o1, Player o2) {
        if (o1 == o2) {
            return 0;
        }
        int score = Integer.compare(o1.score, o2.score);
        int names = o1.name.compareTo(o2.name);
        if (score == 0) {
            return names;
        } else {
            return -score;
        }
    }

    static class Player {
        String name;
        int score;

        Player(String name, int score) {
            this.name = name;
            this.score = score;
        }
    }
}


