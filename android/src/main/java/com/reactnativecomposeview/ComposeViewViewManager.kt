package com.reactnativecomposeview

import android.content.Context
import android.graphics.Color
import android.view.View
import com.facebook.react.uimanager.SimpleViewManager
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.uimanager.annotations.ReactProp
import android.content.Intent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy

class ComposeViewViewManager : SimpleViewManager<View>() {
  override fun getName() = "ComposeViewView"

  override fun createViewInstance(reactContext: ThemedReactContext): View {
    return createComposeView(reactContext)
  }

  @ReactProp(name = "color")
  fun setColor(view: View, color: String) {
    view.setBackgroundColor(Color.parseColor(color))
      view.setOnClickListener {
          startComposeActivity(view.context)
      }
  }

    private fun createComposeView(context: Context) : View {
        return ComposeView(context).apply {
        // Dispose the Composition when the view's LifecycleOwner
        // is destroyed
        setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
        setContent {
            MaterialTheme {
                // In Compose world
                Text("Hello Applicaster!This is Compose view added in RN environment")

                Text("Hello 2s")
            }
        }
    }
    }

}
fun startComposeActivity(context: Context?) {
    val intent = Intent(context, ComposeActivity::class.java)
    context?.startActivity(intent)
}