import sort.Insertion
import sort.Sort

object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        val sort = Sort<Int>()
        val insertion = Insertion(sort)
        val randomList = ArrayList<Int>()
        val MAX = 10

        randomize(randomList, MAX)
        insertion.sort(randomList)
        randomize(randomList, MAX)
        val newList = insertion.copySort(randomList)

//        val deque = Deque<Int>()
//        for (i in 0..10) {
//            deque.push(i)
//            deque.sink(i*i)
//        }
//        println(deque.pop())
//        println(deque.pull())
//        println(deque.head?.value)
//        println(deque.tail?.value)
//
//        val array = deque.toArray()
//        val arrayList = deque.toArrayList()

        println("Stop")
    }

    fun randomize(mutableList: MutableList<Int>, size: Int) {
        mutableList.clear()
        for (i in 1..size) {
            mutableList.add((Math.random() * size).toInt())
        }
    }
}