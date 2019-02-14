package eu.depau.kotlet.extensions.builtins

// https://stackoverflow.com/a/3758880/1124621

private fun <T> humanReadableByteCount(bytes: T, si: Boolean = true): String where T : Comparable<T>, T : Number {
    val unit: Long = if (si) 1000 else 1024
    if (bytes.toLong() < unit) return String.format("%.1f B", bytes.toDouble())
    val exp = (Math.log(bytes.toDouble()) / Math.log(unit.toDouble())).toInt()
    val pre = (if (si) "kMGTPE" else "KMGTPE")[exp - 1] + if (si) "" else "i"
    return String.format("%.1f %sB", bytes.toDouble() / Math.pow(unit.toDouble(), exp.toDouble()), pre)
}

fun Long.toHumanReadableSize(si: Boolean = true) = humanReadableByteCount(this, si)
fun Float.toHumanReadableSize(si: Boolean = true) = humanReadableByteCount(this, si)
fun Double.toHumanReadableSize(si: Boolean = true) = humanReadableByteCount(this, si)
fun Int.toHumanReadableSize(si: Boolean = true) = humanReadableByteCount(this, si)
fun Byte.toHumanReadableSize(si: Boolean = true) = humanReadableByteCount(this, si)
fun Short.toHumanReadableSize(si: Boolean = true) = humanReadableByteCount(this, si)