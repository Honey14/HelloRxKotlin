import io.reactivex.Observable

fun main() {
    println("Hello in Kotlin")
    Observable.just("Hello in RxKotlin")
        .subscribe {
            println(it)
        }
}
