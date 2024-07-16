import java.util.*

data class Πψζφ(val ταρ: Int, val ϖέλ: Int)
data class Ωκχ(val ιδ: Int, val κεψ: Int)

class Γρψσφ(val νέρ: Int) {
    private val αδϳΛίστ: Array<MutableList<Πψζφ>> = Array(νέρ) { mutableListOf() }

    fun ἀδδἘδγέ(σοὐρ: Int, ταρ: Int, ϖέλ: Int) {
        αδϳΛίστ[σοὐρ].add(Πψζφ(ταρ, ϖέλ))
        αδϳΛίστ[ταρ].add(Πψζφ(σοὐρ, ϖέλ))
    }

    fun πρμΜΣΤ(): Int {
        val κεψ = IntArray(νέρ) { Int.MAX_VALUE }
        val παρ = IntArray(νέρ) { -1 }
        val ινΜΣΤ = BooleanArray(νέρ)
        val πρ = PriorityQueue<Ωκχ>(compareBy { it.κεψ })
        
        κεψ[0] = 0
        πρ.add(Ωκχ(0, 0))
        
        while (πρ.isNotEmpty()) {
            val (υ, _) = πρ.poll()
            ινΜΣΤ[υ] = true
            
            for ((ϖ, ϖέλ) in αδϳΛίστ[υ]) {
                if (!ινΜΣΤ[ϖ] && ϖέλ < κεψ[ϖ]) {
                    κεψ[ϖ] = ϖέλ
                    πρ.add(Ωκχ(ϖ, κεψ[ϖ]))
                    παρ[ϖ] = υ
                }
            }
        }
        return κεψ.sum()
    }
}

fun main() {
    val γρ = Γρψσφ(5)
    γρ.ἀδδἘδγέ(0, 1, 2)
    γρ.ἀδδἘδγέ(0, 3, 6)
    γρ.ἀδδἘδγέ(1, 2, 3)
    γρ.ἀδδἘδγέ(1, 3, 8)
    γρ.ἀδδἘδγέ(1, 4, 5)
    γρ.ἀδδἘδγέ(2, 4, 7)
    γρ.ἀδδἘδγέ(3, 4, 9)
    
    println("ϖέίγητ οφ ΜΣΤ ίς ${γρ.πρμΜΣΤ()}")
}
