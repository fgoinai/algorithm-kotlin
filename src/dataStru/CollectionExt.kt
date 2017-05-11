package dataStru

fun <T> MutableList<T>.swap(pos1: Int, pos2: Int) {
    val tmp = this[pos1]
    this[pos1] = this[pos2]
    this[pos2] = tmp
}