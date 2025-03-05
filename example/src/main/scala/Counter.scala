package example

class Counter(val num: Int) {
    def get = num

    def inc = new Counter(num + 1)
    def inc(index: Int = 1):Counter = {
        new Counter(num + index)
    }

    def dec = new Counter(num + 1)
    def dec(index: Int = 1):Counter = {
        /* Generate extra objects??? */
        new Counter(num - index)
    }

    override def toString = {
        s"Counter($num)"
    }
}
