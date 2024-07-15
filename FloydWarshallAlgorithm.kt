fun floydWarshall(graph: Array<IntArray>): Array<IntArray> {
    val dist = Array(graph.size) { graph[it].clone() }
    val V = graph.size
    
    for (k in 0 until V) {
        for (i in 0 until V) {
            for (j in 0 until V) {
                if (dist[i][k] != Int.MAX_VALUE && dist[k][j] != Int.MAX_VALUE && dist[i][k] + dist[k][j] < dist[i][j]) {
                    dist[i][j] = dist[i][k] + dist[k][j]
                }
            }
        }
    }
    return dist
}

fun main() {
    val graph = arrayOf(
        intArrayOf(0, 3, Int.MAX_VALUE, 7),
        intArrayOf(8, 0, 2, Int.MAX_VALUE),
        intArrayOf(5, Int.MAX_VALUE, 0, 1),
        intArrayOf(2, Int.MAX_VALUE, Int.MAX_VALUE, 0)
    )
    val dist = floydWarshall(graph)
    println("Shortest distances between every pair of vertices:")
    dist.forEach { println(it.joinToString(", ") { d -> if (d == Int.MAX_VALUE) "INF" else d.toString() }) }
}
