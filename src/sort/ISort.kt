package sort

abstract class ISort<T>(sort: Sort<T>) {
    init {
        sort.register(this)
    }

    abstract fun sort(q: MutableList<T>) //sort the ref queue directly
    abstract fun copySort(q: MutableList<T>) : MutableList<T> //ref will not be affected, return sorted copy
}

class Sort<T> {
    private val sortOptions: HashMap<String, ISort<T>> = HashMap()
    fun register(sortImpl: ISort<T>) = sortOptions.put(sortImpl::class.java.name, sortImpl)
    fun getAllImpl() : HashMap<String, ISort<T>> = sortOptions
    fun getImpl(name: String) = sortOptions[name]
}