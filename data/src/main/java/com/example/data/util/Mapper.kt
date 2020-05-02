package com.example.data.util

abstract class Mapper<I, O> {
    abstract fun transform(input: I): O
    fun transformList(input: List<I>?): List<O>? {
        return input?.map(::transform)
    }
}