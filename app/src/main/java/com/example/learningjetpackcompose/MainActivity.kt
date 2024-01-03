package com.example.learningjetpackcompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layout
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Text
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp

import com.example.learningjetpackcompose.ui.theme.LearningJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
          //Text(text = "first greeting to the compose ")
            SayName()


        }
    }
}
@Preview(showBackground = true , name = "greeting_message", showSystemUi = true)
@Composable
fun SayName(name : String = "romitp4l"){

    var count = rememberSaveable {
        mutableStateOf(0)
    }

    /*


        WE CAN USE "by" INSTEAD OF "="  TO AVOID THE USE OF "  .value  "  AT ALL THE PLACES .

        WE CAN USE "rememberSavable " INSTEAD OF " remember "  TO SAVE STATE DURING THE CONFIGURATION CHANGE .



    */
   // var count = mutableStateOf(8)
    // defining lambdas for count variable
    var increment ={
        count.value += 1
        Log.i("modification in count by lambda " , "count value is being  incremented and the incremented value is : ${count.value}")
    }

    var  decrement ={
        count.value -= 1
        Log.i("modification in count by lambda ", "count value is being decremented and the decremented value is : ${count.value} ")

    }

    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Column(  modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
            ){

            Text(text = "This page will be showing the different components of the composable ."
            , textAlign = TextAlign.Center, fontSize = 20.sp ,color = Color.DarkGray
            )



                // here ui for the buttons and the counter variable will be defined



            Text(text = "Current counter value is ${count.value}",  textAlign = TextAlign.Center , color = Color.Black ,
                fontSize = 24.sp , fontWeight = FontWeight.Bold
            )
            Column (modifier = Modifier.padding(24.dp)){
                Button(onClick = { increment.invoke() }) {
                    Text(text = "Increment button ")

                }

                Button(onClick = { decrement.invoke() }) {
                    Text(text = "decrement button ")

                }
            }


//
//            Text(text = "This demonstration app is made by ${name}",
//                fontSize = 16.dp,
//                fontStyle = FontStyle.Italic,
//                fontWeight = FontWeight.Bold,
//                textAlign = TextAlign.Center
//            )

                Text(
                    text = " ----->>>> This demonstration app is made by ${name}  <<<<<----------",
                    textAlign = TextAlign.Center,
                    textDecoration = TextDecoration.Underline,
                    fontStyle = FontStyle.Italic,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Red
                )
        }



    }
}




