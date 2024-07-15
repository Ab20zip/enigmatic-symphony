fun mergeSort(arr: IntArray) {
    if (arr.size <= 1) return
    val mid = arr.size / 2
    val left = arr.sliceArray(0 until mid)
    val right = arr.sliceArray(mid until arr.size)
    
    mergeSort(left)
    mergeSort(right)
    
    merge(arr, left, right)
}

fun merge(arr: IntArray, left: IntArray, right: IntArray) {
    var i = 0
    var j = 0
    var k = 0
    
    while (i < left.size && j < right.size) {
        if (left[i] <= right[j]) {
            arr[k++] = left[i++]
        } else {
            arr[k++] = right[j++]
        }
    }
    
    while (i < left.size) {
        arr[k++] = left[i++]
    }
    
    while (j < right.size) {
        arr[k++] = right[j++]
    }
}

fun main() {
    val arr = intArrayOf(38, 27, 43, 3, 9, 82, 10)
    println("Original array: ${arr.joinToString(", ")}")
    mergeSort(arr)
    println("Sorted array: ${arr.joinToString(", ")}")
}
