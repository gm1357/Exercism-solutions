import java.time.LocalDate
import java.time.LocalDateTime

const val gigasecond: Long = 1000000000

class Gigasecond {

    val date: LocalDateTime

    constructor(data: LocalDate) {
        date = data.atStartOfDay().plusSeconds(gigasecond)
    }

    constructor(dataTime: LocalDateTime) {
        date = dataTime.plusSeconds(gigasecond)
    }
}