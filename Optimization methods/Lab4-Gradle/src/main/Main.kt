import koma.*
import koma.extensions.get
import koma.matrix.Matrix
import kotlin.math.pow

/**
 * F(x) = 50 * (x_0^2 - x_1)^2 + 2 * (x_0 - 1)^2 + 10
 * min(F(x)) = 10  at  (x_0, x_1) = (1, 1)
 *
 * @see https://www.wolframalpha.com/input/?i=extrema+50+*+(x_0%5E2+-+x_1)%5E2+%2B+2+*+(x_0+-+1)%5E2+%2B+10
 */
private fun myFunction(xValues: Matrix<Double>): Double {
    val a = 50
    val b = 2
    val f0 = 10
    val n = 1

    var sum = 0.0

    for (i in 0 until n) {
        sum += a * (xValues[i].pow(2) - xValues[i+1]).pow(2) + b * (xValues[i] - 1).pow(2)
    }

    return sum + f0

//    return 250 * (xValues[0].pow(2) - xValues[1]).pow(2) + 2 * (xValues[0] - 1).pow(2) + 50
}

/**
 * @see http://www.wolframalpha.com/input/?i=diff(50*(x%5E2-y)%5E2%2B2*(x-1)%5E2%2B10,y)
 */
private fun gradient(xValues: Matrix<Double>) =
//        create(doubleArrayOf(4 * (250 * xValues[0].pow(3) - 250 * xValues[0] * xValues[1] + xValues[0] - 1), -500 * (xValues[0].pow(2) - xValues[1])))
        create(doubleArrayOf((4 * (50 * xValues[0].pow(3) - 50 * xValues[0] * xValues[1] + xValues[0] - 1)).toDouble(), (-100 * (xValues[0].pow(2) - xValues[1])).toDouble()))

fun main(args: Array<String>) {
    val xStart = listOf(0.0, 1.0)
    val epsilon = 0.0001
    val delta = listOf(1.0, 1.0)
    val lambda = 1.0
    val betta = 1.5
    val curFunction = ::myFunction
    val gradientFunction = ::gradient

    ExtremaSearch.hookeJeeves(xStart, epsilon, curFunction, gradientFunction)

//    val xValues = listOf(0f, 1f)
//    print(myFunction(xValues))
}