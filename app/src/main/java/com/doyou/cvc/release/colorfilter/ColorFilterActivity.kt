package com.doyou.cvc.release.colorfilter

import android.graphics.ColorMatrix
import android.graphics.ColorMatrixColorFilter
import android.os.Bundle
import android.view.MenuItem
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import com.doyou.cvc.R
import kotlinx.android.synthetic.main.activity_color_filter.*

/**
 * 图片滤镜
 * @autor hongbing
 * @date 2019-07-24
 */
class ColorFilterActivity : AppCompatActivity(), SeekBar.OnSeekBarChangeListener {

    private var colorMatrix: ColorMatrix? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_color_filter)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle(R.string.title_color_filter)
        colorMatrix = ColorMatrix()
        colorMatrix!!.setScale(calculate(128), calculate(128), calculate(128), calculate(128))
        jingyIv.colorFilter = ColorMatrixColorFilter(colorMatrix)

        bar_R.setOnSeekBarChangeListener(this)
        bar_G.setOnSeekBarChangeListener(this)
        bar_B.setOnSeekBarChangeListener(this)
        bar_A.setOnSeekBarChangeListener(this)
    }

    private fun calculate(progress: Int): Float {
        return progress / 128f
    }

    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
        colorMatrix?.setScale(calculate(bar_R.progress), calculate(bar_G.progress), calculate(bar_B.progress), calculate(bar_A.progress))
        jingyIv.colorFilter = ColorMatrixColorFilter(colorMatrix)
    }

    override fun onStartTrackingTouch(seekBar: SeekBar?) {
    }

    override fun onStopTrackingTouch(seekBar: SeekBar?) {
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> {
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}