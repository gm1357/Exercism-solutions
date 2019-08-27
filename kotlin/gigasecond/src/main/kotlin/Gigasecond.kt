import java.time.LocalDate
import java.time.LocalDateTime

const val gigasecond: Long = 1000000000

class Gigasecond(localDateTime: LocalDateTime) {

    val date: LocalDateTime = localDateTime.plusSeconds(gigasecond)

    constructor(localDate: LocalDate): this(localDate.atStartOfDay())
}