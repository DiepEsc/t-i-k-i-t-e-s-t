package com.tiki.test.diepesc.view

import android.content.Context
import android.support.v7.widget.AppCompatTextView
import android.util.AttributeSet
import kotlin.math.ceil
import kotlin.math.max

class TwoLineTextView : AppCompatTextView {

    private val tokensWidth = ArrayList<Float>()

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {

        val text = text.toString()
        val tokens = text.split(" ")
        val tokenCount = tokens.size
        if (tokenCount > 1) {
            tokensWidth.clear()
            val spaceWidth = paint.measureText(" ")
            for (token in tokens) {
                val tokenWidth = paint.measureText(token)
                tokensWidth.add(tokenWidth)
            }
            var line1With = 0f
            var line2With = 0f
            var line1Count = 0
            var line2Count = 0
            while (line1Count + line2Count < tokenCount) {
                if (line1With < line2With) {
                    if (line1Count != 0) {
                        line1With += spaceWidth
                    }
                    line1With += tokensWidth[line1Count]
                    line1Count++
                } else {
                    if (line2Count != 0) {
                        line2With += spaceWidth
                    }
                    line2Count++
                    line2With += tokensWidth[tokenCount - line2Count]
                }
            }
            val layoutWidth = max(line1With, line2With)
            val maxWidth = ceil(layoutWidth).toInt() + paddingLeft + paddingRight
            val newWidthSpec = MeasureSpec.makeMeasureSpec(maxWidth,
                    MeasureSpec.AT_MOST)
            super.onMeasure(newWidthSpec, heightMeasureSpec)

        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        }
    }
}
