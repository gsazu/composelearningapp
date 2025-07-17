package com.app.learningcomposeapp

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.currentCompositionLocalContext
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.learningcomposeapp.models.ProgrammingLanguages
import com.app.learningcomposeapp.ui.theme.LearningComposeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LearningComposeAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxWidth()
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    var textFiledValue by remember {
        mutableStateOf("")
    }
    Column(modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "Hello $name!",
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
        Image(painter = painterResource(R.drawable.hammer), contentDescription = "hammer",
            colorFilter = ColorFilter.tint(color = Color.Red),
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp),
            contentScale = ContentScale.Fit)
        Button(
            onClick = {
                Log.d("Button", "Greeting: Button Clicked")
                textFiledValue = ""
            },
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.Red,
                containerColor = Color.Blue
            ),

            ) {
                Text("Click Me", fontSize = 18.sp)
                Image(
                    painter = painterResource(R.drawable.hammer),
                    modifier = Modifier.height(22.dp),
                    contentDescription = "button thing",
                    colorFilter = ColorFilter.tint(color = Color.White)
                )
        }
        Box(modifier = Modifier.height(20.dp))

        TextField(
            value = textFiledValue,
            onValueChange = {
                textFiledValue = it
            },
            label = {
                Text("Enter something")
            }
        )

        Box(modifier = Modifier.height(20.dp))

//        LazyColumn(content = {
//            items(getProgrammingList()) { item ->
//                ListItem(item.img, item.title, item.subTitle)
//            }
//        })

        MainNotificationBar()


    }
}


@Composable
fun MainNotificationBar(modifier: Modifier = Modifier) {
    var count by rememberSaveable {
        mutableStateOf(0)
    }

    Column {
        SendNotification(count) { count++ }
        MessageBar(count)
    }
    
}

@Composable
fun SendNotification(count: Int, increment : () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("You have sent $count notifications.")
        Button(
            onClick = increment
        ) {
            Text("Send Notification")
        }
        Box(modifier = Modifier.size(20.dp))
    }
}

@Composable
fun MessageBar(count: Int) {
    Card(
    ) {
        Text("Messages are so far $count",
            modifier =  Modifier.padding(20.dp))
    }
}



fun getProgrammingList(): MutableList<ProgrammingLanguages> {
    val list = mutableListOf<ProgrammingLanguages>()
    list.add(ProgrammingLanguages(R.drawable.dp, subTitle = "Android Development"))
    list.add(ProgrammingLanguages(R.drawable.dp, subTitle = "IOS Development"))
    list.add(ProgrammingLanguages(R.drawable.dp, subTitle = "Compose Development"))
    list.add(ProgrammingLanguages(R.drawable.dp, subTitle = "Flutter Development"))
    list.add(ProgrammingLanguages(R.drawable.dp, subTitle = "ReactNative Development"))
    list.add(ProgrammingLanguages(R.drawable.dp, subTitle = "Android Development"))
    list.add(ProgrammingLanguages(R.drawable.dp, subTitle = "IOS Development"))
    list.add(ProgrammingLanguages(R.drawable.dp, subTitle = "Compose Development"))
    list.add(ProgrammingLanguages(R.drawable.dp, subTitle = "Flutter Development"))
    list.add(ProgrammingLanguages(R.drawable.dp, subTitle = "ReactNative Development"))
    list.add(ProgrammingLanguages(R.drawable.dp, subTitle = "Android Development"))
    list.add(ProgrammingLanguages(R.drawable.dp, subTitle = "IOS Development"))
    list.add(ProgrammingLanguages(R.drawable.dp, subTitle = "Compose Development"))
    list.add(ProgrammingLanguages(R.drawable.dp, subTitle = "Flutter Development"))
    list.add(ProgrammingLanguages(R.drawable.dp, subTitle = "ReactNative Development"))

    return list
}

@Composable
fun ListItem(img: Int, title: String, subTitle: String ,modifier: Modifier = Modifier
    .padding(horizontal = 20.dp, vertical = 10.dp)
    .fillMaxWidth()) {
    Card(elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        modifier = modifier,
        shape = RectangleShape) {
        Row(verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(10.dp)) {
            Image(painter = painterResource(img), contentDescription = "dp",
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
                    .border(2.dp, color = Color.Black, shape = CircleShape),
                contentScale = ContentScale.Crop)
            Box(modifier = Modifier.size(10.dp))

            Column(modifier = Modifier) {
                Text(title, color = Color.Black,
                    fontSize = 20.sp, fontWeight = FontWeight.Bold)

                Box(modifier = Modifier.size(2.dp))

                Text(subTitle, color = Color.Gray,
                    fontSize = 16.sp, fontWeight = FontWeight.Normal)

            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    LearningComposeAppTheme {
        Greeting("Android")
    }
}