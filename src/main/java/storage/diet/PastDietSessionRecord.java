package storage.diet;

import java.time.LocalDateTime;

public class PastDietSessionRecord implements Comparable<PastDietSessionRecord> {

    private final String filePath;
    private final LocalDateTime creationTime;
    private LocalDateTime lastEditTime;

    public PastDietSessionRecord(String filePath) {
        this.filePath = filePath;
        creationTime = LocalDateTime.now();
        lastEditTime = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Session created on " + creationTime.toLocalDate()
                + ", last edited on " + lastEditTime.toLocalDate();
    }

    @Override
    public int compareTo(PastDietSessionRecord o) {
        if (creationTime.isBefore(o.creationTime)) {
            return -1;
        }
        return 1;
    }
}
