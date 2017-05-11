package dataStru

import javax.naming.SizeLimitExceededException


class Deque<T>() : Collection<T> {
    override fun contains(element: T): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun containsAll(elements: Collection<T>): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isEmpty(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    var head: Node<T>? = null
    var tail: Node<T>? = null
    override var size: Int = 0

    constructor(value: T) : this() {
        size = 1
        head = Node(value)
        tail = head
    }

    fun push(value: T) {
        val tmp = Node(value)
        if (head == null) {
            head = tmp
            tail = head
        } else {
            tail!!.next = tmp
            tmp.prev = tail
            tail = tmp
        }
        size += 1
    }

    fun pull(): T? {
        if (size == 0) return null
        val ret = tail!!.value
        if (size == 1) {
            tail = null
            head = null
        } else {
            val tmp = tail
            tail = tmp?.prev
            tail?.next = null
        }
        size -= 1
        return ret
    }

    fun pop(): T? {
        if (size == 0) return null
        val ret = head!!.value
        if (size != 1) {
            val tmp = head
            head = tmp?.next
            head?.prev = null
        } else {
            head = null
            tail = null
        }
        size -= 1
        return ret
    }

    fun sink(value: T) {
        val tmp = Node(value)
        if (size == 0) {
            head = tmp
            tail = tmp
        } else {
            head?.prev = tmp
            tmp.next = head
            head = tmp
        }
        size += 1
    }

    fun get(position: Int): T {
        if (position > size) throw SizeLimitExceededException()
        if (size == 0) throw ExceptionInInitializerError("Not initialized")
        var ret: Node<T> = head as Node<T>
        for (i in 0..position) {
            ret = ret.next!!
        }
        return ret.value
    }

    class Itr<T> internal constructor(val deque: Deque<T>) : Iterator<T> {
        var cursor: Int = -1
        var curPos: Node<T>? = null

        override fun hasNext(): Boolean = cursor < deque.size

        override fun next(): T {
            if (!hasNext()) throw IndexOutOfBoundsException()
            if (curPos == null) {
                curPos = deque.head
                cursor = 0
                return curPos!!.value
            } else {
                curPos = curPos!!.next
                cursor += 1
                return curPos!!.value
            }
        }

        fun itrJump(position: Int) : T {
            if (!hasNext()) throw IndexOutOfBoundsException()
            while (true) {
                if (cursor == position) return curPos!!.value
                next()
            }
        }
    }

    override fun iterator() = Itr(this)
}