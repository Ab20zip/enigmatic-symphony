fun knapsack(weights: IntArray, values: IntArray, capacity: Int): Int {
    val n = weights.size
    val dp = Array(n + 1) { IntArray(capacity + 1) }
    
    for (i in 1..n) {
        for (w in 0..capacity) {
            if (weights[i - 1] <= w) {
                dp[i][w] = maxOf(dp[i - 1][w], dp[i - 1][w - weights[i - 1]] + values[i - 1])
            } else {
                dp[i][w] = dp[i - 1][w]
            }
        }
    }
    return dp[n][capacity]
}

fun main() {
    val weights = intArrayOf(2, 3, 4, 5)
    val values = intArrayOf(3, 4, 5, 6)
    val capacity = 5
    
    println("Maximum value in Knapsack = ${knapsack(weights, values, capacity)}")
}
