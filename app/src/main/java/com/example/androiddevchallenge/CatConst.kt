/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

object CatConst {
    private const val a0 = "Adopted by Ningbo Ragdoll Cat"
    private const val a1 = "Ningbo"
    private const val a2 =
        "The glove-colored puppet (male cat) is about one year old. The lanugo hair has not yet gone (not exploded) and has been sterilized. He has just had a physical examination this year. He is clever and clingy. He understands people’s words, but sometimes he is skinny and lively."
    private const val b0 = "A cat cub adopted a year ago"
    private const val b1 = "Beijing"
    private const val b2 = "Suddenly there is a cat cub to accompany me, it’s so happy, sleep with me, stay up with me and sunbathe with me hahaha..."
    private const val c2 =
        "Tongtong was born in the garden of the kindergarten, so she named her Tongtong, I hope she grows up happily every day! Tongtong has a docile personality, long hair and white hair, a strand of silver hair on her head, not picky eaters, relatives, and loves to be with other cats! He is a little guy who can always accompany mankind!"
    private const val c1 = "Shanghai"
    private const val c0 = "Tongtong"

    val catList = mutableListOf(
        Cat(a0, a1, a2, listOf(R.mipmap.a1, R.mipmap.a2, R.mipmap.a3)),
        Cat(b0, b1, b2, listOf(R.mipmap.b1, R.mipmap.b2, R.mipmap.b3, R.mipmap.b4)),
        Cat(c0, c1, c2, listOf(R.mipmap.c1, R.mipmap.c2)),
    ).enlargeList(2).shuffled()

    private fun MutableList<Cat>.enlargeList(times: Int = 1): MutableList<Cat> {
        val tmp = toList()
        repeat(times) { addAll(tmp) }
        return this
    }
}

class Cat(var title: String, var address: String, var desc: String, var picRes: List<Int>, var isAdopted: Boolean = false)
