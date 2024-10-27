package com.cprac.jetpackcompose
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.launch
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import com.cprac.jetpackcompose.ui.theme.JetpackComposeTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random
class MainActivity : ComponentActivity() {
    private var i=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
//                Jpc4(painterResource(id=R.drawable.pfp),"hello","Curly baal lekin no baddie by my side",)
            Jpc10()
            }
        }
}
//philipp lackner jetpack compose video2
@Composable
fun Jpc2(){
    Column(
        modifier= Modifier
            .width(200.dp)
            .height(200.dp)
            .background(Color.LightGray)
            .padding(25.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween){
        Text("hello")
        Text("green")
        Text("nigga")
    }
}
//philipp lackner jetpack compose video3
@Composable
fun Jpc3(){
    Column(
        modifier= Modifier
            .background(Color.LightGray)
            .fillMaxWidth()
//            .width(300.dp)
            .fillMaxHeight(0.5f)
//            .padding(25.dp)
            .border(5.dp, Color.Magenta)
//            .requiredWidth(600.dp)
    ){
        Text("hello",color=Color.White,modifier= Modifier
            .offset(50.dp, 20.dp)
            .clickable { })

        //spacer for extra space
        Spacer(modifier=Modifier.height(50.dp))
        Text("green",color=Color.White)
        Text("nigga",modifier= Modifier
            .border(5.dp, Color.Green)
            .padding(10.dp))
    }
}
//philipp lackner jetpack compose video4
@Composable
fun Jpc4(painter: Painter, contentDescription:String, title:String, modifier:Modifier=Modifier
){
    Surface(
        modifier = modifier.fillMaxWidth(0.5f),
        shape = RoundedCornerShape(15.dp),
        shadowElevation = 5.dp, // Use shadowElevation instead of elevation for shadow
    ) {
        Box(modifier=Modifier.height(200.dp)){
            Image(painter=painter,contentDescription=contentDescription,
                contentScale= ContentScale.Crop
            )
            Box(
                modifier= Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Black
                            ),
                            startY = 300f
                        )
                    )
            )
            Box(modifier= Modifier
                .fillMaxSize()
                .padding(12.dp),
                contentAlignment = Alignment.BottomStart){
                Text(title,color=Color.White, fontWeight = FontWeight.ExtraBold)
            }
        }
    }
}
//philip lackner jetpack compose video5
@Composable
fun Jpc5(){
    //styling text in compose
    val fontFamily= FontFamily(
        Font(R.font.poppinsbold,FontWeight.Bold))
    Box(
        modifier= Modifier
            .fillMaxSize()
            .background(Color(0xFF101010)))
    {
        Text(
            modifier=Modifier.padding(20.dp),
            text= buildAnnotatedString {
                withStyle(
                    style=SpanStyle(
                        color=Color.Green,
                        fontSize=50.sp
                    )
                ){
                    append("J")
                }
                append("etpack")
                withStyle(
                    style=SpanStyle(
                        color=Color.Green,
                        fontSize=50.sp
                    )
                ){
                    append("C")
                }
                append("ompose")

            },
            color=Color.White,
            fontSize = 27.sp,
            //to use own downloaded font
            fontFamily=fontFamily,
            fontWeight=FontWeight.ExtraBold,
            textAlign= TextAlign.Center,
            textDecoration= TextDecoration.Underline

        )
    }
}
//philip lackner jetpack compose video6
@Composable
fun Jpc6(modifier:Modifier=Modifier){
    //states in jetpack compose
    val color= remember{ mutableStateOf(Color.Yellow) }
    Box(modifier= modifier
        .fillMaxSize()
        .background(color.value)
        .clickable {
            color.value = Color(
                Random.nextFloat(),
                Random.nextFloat(),
                Random.nextFloat(), 1f
            )
        }
    )
}
//philip lackner jetpack compose video7
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Jpc7() {
    var textFieldState by remember { mutableStateOf("") }
    val snackbarHostState = remember { SnackbarHostState() } // Create SnackbarHostState
    val scope = rememberCoroutineScope() // Create CoroutineScope

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) } // Add SnackbarHost to Scaffold
    ) { paddingValues ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 30.dp)
                .padding(paddingValues) // Apply padding from Scaffold
        ) {
            TextField(
                value = textFieldState,
                label = { Text("Enter your name") },
                onValueChange = { textFieldState = it },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = {
                scope.launch { // Launch coroutine to show Snackbar
                    snackbarHostState.showSnackbar(
                        message = "Hello $textFieldState",
                        duration = SnackbarDuration.Short
                    )
                }
            }) {
                Text("Pls greet me")
            }
        }
    }
}
//philip lackner jetpack compose video8
@Composable
fun Jpc8(){
    //lists in jetpack compose
    LazyColumn {
        items(5000){
            Text(
                text="Item $it",
                fontSize=24.sp,
                textAlign = TextAlign.Center,
                fontWeight=FontWeight.Bold,
                modifier=Modifier
                    .fillMaxWidth()
                    .padding(vertical = 24.dp))
        }
    }
}
//philip lackner jetpack compose video9
@Composable
fun Jpc9(){
    //constraint layout
    val constraints= ConstraintSet{
        val greenBox=createRefFor("greenbox")
        val redBox=createRefFor("redbox")
        constrain(greenBox){
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            width= Dimension.value(100.dp)
            height=Dimension.value(100.dp)
        }
        constrain(redBox){
            top.linkTo(parent.top)
            start.linkTo(greenBox.end)
            end.linkTo(parent.end)
            width= Dimension.fillToConstraints
            height=Dimension.value(100.dp)
        }
    }
    ConstraintLayout(constraints,
        modifier=Modifier.fillMaxSize()) {
        Box(modifier=Modifier
            .background(Color.Green)
            .layoutId("greenbox"))
        Box(modifier=Modifier
            .background(Color.Red)
            .layoutId("redbox"))
    }
}
//philip lackner jetpack compose video10
@Composable
fun Jpc10(){
    //effect handlers
    var text by remember{mutableStateOf("")}
    LaunchedEffect(key1 = text) {
        delay(1000L)
        println("The text is $text")
    }
}


