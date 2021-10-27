package com.reactnativecomposeview

import android.content.Context
import android.graphics.Color
import android.view.View
import com.facebook.react.uimanager.SimpleViewManager
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.uimanager.annotations.ReactProp
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class ComposeViewViewManager : SimpleViewManager<View>() {
  override fun getName() = "ComposeViewView"

  override fun createViewInstance(reactContext: ThemedReactContext): View {
    return createComposeView(reactContext)
  }

  @ReactProp(name = "color")
  fun setColor(view: View, color: String) {
    view.setBackgroundColor(Color.parseColor(color))
      view.setOnClickListener {
//          startComposeActivity(view.context)
      }
  }

    private fun createComposeView(context: Context) : View {
        return ComposeView(context).apply {
        // Dispose the Composition when the view's LifecycleOwner
        // is destroyed
        setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
        setContent {
            MaterialTheme {
                MessageCard("Hello Applicaster!", "This is Compose view added in RN environment")
            }
        }
    }
    }

    @Preview
    @Composable
    fun MessageCard(title: String = "default title", message: String = "default message") {
        Column {
            Image(
                painter = painterResource(R.drawable.applicaster_logo),
                contentDescription = "Contact profile picture",
            )

            Column {
                Text(
                    text = title,
                    style = MaterialTheme.typography.h5,
                    modifier = Modifier.padding(all = 4.dp)
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = message,
                    style = MaterialTheme.typography.body2,
                    modifier = Modifier.padding(all = 6.dp)
                )
            }
        }
    }
}