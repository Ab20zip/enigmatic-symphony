import java.util.*

data class Edge(val target: Int, val weight: Int)
data class Node(val id: Int, val key: Int)

class Graph(val vertices: Int) {
    private val adjList: Array<MutableList<Edge>> = Array(vertices) { mutableListOf() }

    fun addEdge(source: Int, target: Int, weight: Int) {
        adjList[source].add(Edge(target, weight))
        adjList[target].add(Edge(source, weight))
    }

    fun primMST(): Int {
        val key = IntArray(vertices) { Int.MAX_VALUE }
        val parent = IntArray(vertices) { -1 }
        val inMST = BooleanArray(vertices)
        val priorityQueue = PriorityQueue<Node>(compareBy { it.key })
        
        key[0] = 0
        priorityQueue.add(Node(0, 0))
        
        while (priorityQueue.isNotEmpty()) {
            val (u, _) = priorityQueue.poll()
            inMST[u] = true
            
            for ((v, weight) in adjList[u]) {
                if (!inMST[v] && weight < key[v]) {
                    key[v] = weight
                    priorityQueue.add(Node(v, key[v]))
                    parent[v] = u
                }
            }
        }
        return key.sum()
    }
}

fun main() {
    val graph = Graph(5)
    graph.addEdge(0, 1, 2)
    graph.addEdge(0, 3, 6)
    graph.addEdge(1, 2, 3)
    graph.addEdge(1, 3, 8)
    graph.addEdge(1, 4, 5)
    graph.addEdge(2, 4, 7)
    graph.addEdge(3, 4, 9)
    
    println("Weight of MST is ${graph.primMST()}")
}
