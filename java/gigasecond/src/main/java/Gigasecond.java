import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;

class Gigasecond {

    private static final long GIGASECOND = 1_000_000_000;
    private LocalDateTime birthDate;

    Gigasecond(LocalDateTime birthDateTime) {
        this.birthDate = birthDateTime;
    }

    Gigasecond(LocalDate birthDate) {
        this(birthDate.atStartOfDay());
    }

    LocalDateTime getDateTime() {
        return this.birthDate.plusSeconds(GIGASECOND);
    }

}
