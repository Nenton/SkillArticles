package ru.skillbranch.skillarticles.extensions

/**
 * @author Susev Sergey
 */

fun String?.indexesOf(substr: String, ignoreCase: Boolean = true): List<Int> {
    if (this == null || substr.isEmpty()) return listOf()
    val result = mutableListOf<Int>()
    var indexStart = -1
    indexStart = this.indexOf(substr, indexStart + 1, ignoreCase)
    while (indexStart != -1) {
        result.add(indexStart)
        indexStart = this.indexOf(substr, indexStart + 1, ignoreCase)
    }
    return result
}