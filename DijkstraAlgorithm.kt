import java.util.*

data class Edge(val target: Int, val weight: Int)
data class Node(val id: Int, val distance: Int)

class Graph(val vertices: Int) {
    private val adjList: Array<MutableList<Edge>> = Array(vertices) { mutableListOf() }

    fun addEdge(source: Int, target: Int, weight: Int) {
        adjList[source].add(Edge(target, weight))
        adjList[target].add(Edge(source, weight))
    }

    fun dijkstra(source: Int): IntArray {
        val distances = IntArray(vertices) { Int.MAX_VALUE }
        val priorityQueue = PriorityQueue<Node>(compareBy { it.distance })
        
        distances[source] = 0
        priorityQueue.add(Node(source, 0))
        
        while (priorityQueue.isNotEmpty()) {
            val (current, currentDist) = priorityQueue.poll()
            
            if (currentDist > distances[current]) continue
            
            for ((target, weight) in adjList[current]) {
                val distance = currentDist + weight
                if (distance < distances[target]) {
                    distances[target] = distance
                    priorityQueue.add(Node(target, distance))
                }
            }
        }
        return distances
    }
}

fun main() {
    val graph = Graph(5)
    graph.addEdge(0, 1, 10)
    graph.addEdge(0, 4, 3)
    graph.addEdge(1, 2, 2)
    graph.addEdge(1, 4, 4)
    graph.addEdge(2, 3, 9)
    graph.addEdge(3, 4, 7)
    
    val distances = graph.dijkstra(0)
    println("Distances from node 0: ${distances.joinToString(", ")}")
}
