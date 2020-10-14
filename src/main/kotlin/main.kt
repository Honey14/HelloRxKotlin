import io.reactivex.Observable
import io.reactivex.rxkotlin.toObservable

fun main() {
    exampleOf("Creating Observables from individual values to collection of values") {

        // creating Observables in RxJava
        val mostPopular: Observable<String> = Observable.just(movieSeries1)
        val triedSecond = Observable.just(movieSeries1, movieSeries2, movieSeries2)
        val prequelMovie = Observable.just(listOf(movieSeries1, movieSeries2, movieSeries3))
        val sequelMovie = Observable.fromIterable(listOf(movieSeries1, movieSeries2))

        // creating Observables in RxKotlin
        val mostWatched = listOf(movieSeries1, movieSeries2, movieSeries3).toObservable()
    }
}
