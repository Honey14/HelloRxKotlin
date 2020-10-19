import io.reactivex.Observable
import io.reactivex.rxkotlin.subscribeBy
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

    exampleOf("Creating a subscriber") {

        // creating a subscriber
        // An Observable is nothing without a Subscriber
        // Example: A interesting blog(Observable) is nothing without its readers(subscribers),a light switch is nothing without the bulb.
        // A subscriber returns a disposable which is an interface that has dispose() function
        // A subscriber can return Next element, Error or Complete

        val mostPopular = Observable.just(movieSeries1, movieSeries2)

        mostPopular.subscribe { element ->
            println(element)
        }
    }

    // modifying to use subscribe by method which takes next, error, complete elements
    exampleOf("Create subscriber") {
        val observable = Observable.just(movieSeries3, movieSeries2)

        observable.subscribeBy(
            onNext = { println(it) },
            onComplete = { print("Complete") }
        )
    }

    // type cannot be inferred, so Unit is good as anything
    exampleOf("empty") {
        val observable = Observable.empty<Unit>()

        observable.subscribeBy(
            onNext = { println(it) },
            onComplete = { print("Completed") }
        )
    }
}
