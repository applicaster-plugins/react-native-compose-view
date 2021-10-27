package com.reactnativecomposeview

import android.content.Context
import android.graphics.Color
import android.view.View
import com.facebook.react.uimanager.SimpleViewManager
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.uimanager.annotations.ReactProp
import android.content.Intent

class ComposeViewViewManager : SimpleViewManager<View>() {
  override fun getName() = "ComposeViewView"

  override fun createViewInstance(reactContext: ThemedReactContext): View {
    return View(reactContext)
  }

  @ReactProp(name = "color")
  fun setColor(view: View, color: String) {
    view.setBackgroundColor(Color.parseColor(color))
      view.setOnClickListener {
          startComposeActivity(view.context)
      }
  }
}
fun startComposeActivity(context: Context?) {
    val intent = Intent(context, ComposeActivity::class.java)
    context?.startActivity(intent)
}