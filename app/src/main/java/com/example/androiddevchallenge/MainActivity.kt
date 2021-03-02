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

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.MyTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        val list = mutableListOf(Cat("a", 1), Cat("b", 2), Cat("c", 3)).toMutableStateList()

        setContent {
            MyTheme {
                MyApp(CatConst.catList) {
                    startActivity(
                        Intent(this, DetailActivity::class.java).apply {
                            putExtra("id", it)
                        }
                    )
                }
            }
        }
    }
}

// Start building your app here!
@Composable
fun MyApp(cats: List<Cat>, startDetail: (Int) -> Unit = {}) {
    val imgModifier = Modifier
        .fillMaxWidth(0.38f)
        .padding(0.dp, 6.dp)
        .fillMaxHeight()
        .clip(RoundedCornerShape(8.dp))
    Surface(color = MaterialTheme.colors.background) {
        LazyColumn(modifier = Modifier.padding(16.dp, 0.dp)) {
            itemsIndexed(cats) { i, it ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(84.dp)
                        .clickable {
                            startDetail(i)
                        }
                ) {
                    Image(painter = painterResource(id = it.picRes[0]), contentScale = ContentScale.Crop, contentDescription = it.title, modifier = imgModifier)
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp, 2.dp)
                    ) {
                        Text(text = it.title, maxLines = 1, fontWeight = FontWeight.Bold)
                        Text(text = it.desc, maxLines = 2, modifier = Modifier.padding(0.dp, 4.dp), overflow = TextOverflow.Ellipsis)
                    }
                }
            }
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        MyApp(CatConst.catList)
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        MyApp(CatConst.catList)
    }
}
