package eu.depau.commons.android.kotlin.ktexts

private val timeStrings = arrayOf("s", "m", "h", "d")
private val timeDivs = arrayOf(60, 60, 24)

fun <T> humanReadableTimeDelta(time: T): String where T : Number {
    var dbTime = time.toDouble() / 1000.0
    var outString = ""

    for (i in 0..(timeDivs.size - 1)) {
        val div = timeDivs[i]
        val str = timeStrings[i]

        outString = "${(dbTime % div).toInt()}$str$outString"

        if (dbTime < div)
            return outString

        outString = " $outString"
        dbTime /= div
    }

    return "${dbTime.toInt()}${timeStrings[-1]} $outString"
}

fun Long.toHumanReadableTime() = humanReadableTimeDelta(this)
fun Float.toHumanReadableTime() = humanReadableTimeDelta(this)
fun Double.toHumanReadableTime() = humanReadableTimeDelta(this)
fun Int.toHumanReadableTime() = humanReadableTimeDelta(this)
fun Byte.toHumanReadableTime() = humanReadableTimeDelta(this)
fun Short.toHumanReadableTime() = humanReadableTimeDelta(this)