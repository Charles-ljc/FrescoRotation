package com.liujinchaoDS.frescorotatioin

import android.app.Activity
import android.net.Uri
import android.os.Bundle
import android.view.View
import com.facebook.common.util.UriUtil
import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.drawee.view.SimpleDraweeView
import com.facebook.imagepipeline.common.RotationOptions
import com.facebook.imagepipeline.request.ImageRequestBuilder
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        Fresco.initialize(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun fail(view: View) {
        image.rotate(UriUtil.getUriForResourceId(R.drawable.image_ic_exif), RotationOptions.disableRotation())
        image1.rotate(UriUtil.getUriForResourceId(R.drawable.image_ic_exif), RotationOptions.autoRotate())
    }
}


fun SimpleDraweeView.rotate(uri: Uri, rotationOptions: RotationOptions) {
    val autoImageRequest = ImageRequestBuilder.newBuilderWithSource(uri)
        .setRotationOptions(rotationOptions)
        .build()
    controller = Fresco.newDraweeControllerBuilder()
        .setOldController(controller)
        .setImageRequest(autoImageRequest)
        .build()
}
