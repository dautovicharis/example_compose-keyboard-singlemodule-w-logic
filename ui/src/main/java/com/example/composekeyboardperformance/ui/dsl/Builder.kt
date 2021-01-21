package com.example.composekeyboardperformance.ui.dsl

import java.lang.IllegalStateException
import java.util.concurrent.atomic.AtomicBoolean

/**
 * Am 2021-01-05 erstellt.
 */

@KeyboardDsl
abstract class Builder<T, E> {

    private val isBuilt = AtomicBoolean(false)

    private val elements = mutableListOf<E>()

    fun add(e: E) = elements.add(e)

    fun addAll(e : List<E>) = elements.addAll(e)

    fun build(): T =
        if (isBuilt.compareAndSet(false, true)) create(elements)
        else throw IllegalStateException("Cannot close an already closed ${KeyboardBuilder::class.java.name}")


    abstract fun create(elements: List<E>): T
}