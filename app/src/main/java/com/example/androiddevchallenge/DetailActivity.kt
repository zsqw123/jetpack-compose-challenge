package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.ui.theme.MyTheme

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val id = intent.extras?.getInt("id") ?: 0
        setContent {
            MyTheme {
                DetailScreen(CatConst.catList[id])
            }
        }
    }
}

@Composable
fun DetailScreen(cat: Cat) {
    val adopted = remember { mutableStateOf(cat.isAdopted) }
    Surface(color = MaterialTheme.colors.background) {
        Column(
            Modifier
                .padding(8.dp, 8.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Text(text = cat.title, fontSize = 24.sp, textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())
            val avatarModifier = Modifier
                .width(72.dp)
                .height(72.dp)
                .padding(8.dp)
                .clip(CircleShape)
            MatchHorizontal {
                Image(painter = painterResource(id = cat.picRes[0]), contentDescription = cat.title, modifier = avatarModifier, contentScale = ContentScale.Crop)
            }
            MatchHorizontal {
                Card(backgroundColor = MaterialTheme.colors.primary) {
                    Text(text = cat.address, fontSize = 13.sp, textAlign = TextAlign.Center, modifier = Modifier.padding(6.dp, 0.dp))
                }
            }
            val imageModifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(12.dp))
            cat.picRes.forEach {
                MatchHorizontal {
                    Image(modifier = imageModifier, painter = painterResource(id = it), contentDescription = cat.title, contentScale = ContentScale.Crop)
                }
            }
            Text(text = cat.desc, fontSize = 16.sp)
            Divider(thickness = 2.dp, modifier = Modifier.padding(0.dp, 4.dp))
            MatchHorizontal {
                Button(onClick = {
                    cat.isAdopted = true
                    adopted.value = true
                    toast("Adopted!")
                }, enabled = !adopted.value) {
                    Text(text = if (!adopted.value) "Adopt!" else "Adopted")
                }
            }
        }
    }
}

@Preview(widthDp = 360, heightDp = 720)
@Composable
fun PreviewDetail() {
    MyTheme {
        DetailScreen(cat = CatConst.catList[0])
    }
}