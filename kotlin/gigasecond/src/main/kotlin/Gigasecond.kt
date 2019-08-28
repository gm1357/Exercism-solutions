import java.time.LocalDate
import java.time.LocalDateTime

const val gigasecond = 1_000_000_000L

class Gigasecond(localDateTime: LocalDateTime) {

    val date: LocalDateTime = localDateTime.plusSeconds(gigasecond)

    constructor(localDate: LocalDate) : this(localDate.atStartOfDay())
}