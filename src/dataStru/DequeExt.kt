package dataStru

inline fun <reified T> Deque<T>.toArray() : Array<T> {
    return Array(this.size, { i -> this.iterator().itrJump(i)!! })
}

inline fun <reified T> Deque<T>.toArrayList() : ArrayList<T> {
    return this.toArray().toMutableList() as ArrayList<T>
}