package sort

import dataStru.swap

class Insertion<T>(sort: Sort<T>) : ISort<T>(sort) where T : Comparable<T> {

    override fun sort(q: MutableList<T>) {
        for (i in 1..q.size-1) {
            if (q[i] > q[i-1]) continue
            q.swap(i, i-1)
            for (j in i-1 downTo 1) {
                if (q[j] > q[j-1]) break
                q.swap(j, j-1)
            }
        }
    }

    override fun copySort(q: MutableList<T>): MutableList<T> {
        val ret = ArrayList<T>()
        ret.add(q[0])

        for (i in 1..q.size-1) {
            ret@  for (j in ret.size - 1 downTo 0) {
                when {
                    q[i] >= ret[j] -> { ret.add(j + 1, q[i]); break@ret}
                    j == 0 -> {ret.add(0, q[i]); break@ret}
                    else -> continue@ret
                }
            }
        }

        return ret
    }

}
