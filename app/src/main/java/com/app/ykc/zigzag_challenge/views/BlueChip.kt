package com.app.ykc.zigzag_challenge.views

import android.util.TypedValue
import com.app.ykc.zigzag_challenge.R
import com.app.ykc.zigzag_challenge.app.KotlinModel
import com.app.ykc.zigzag_challenge.data.Ages
import com.app.ykc.zigzag_challenge.data.getString
import com.google.android.material.chip.Chip

data class BlueChip(
    val age: Ages,
    val isChecked: Boolean,
    val listener : (Boolean, Ages) -> Unit

) : KotlinModel(R.layout.chip_age) {

    val chip by bind<Chip>(R.id.chip)

    override fun bind() {
        chip.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 12f)

        chip.isChecked = isChecked
        chip.text = age.getString(chip.context)

        chip.setOnCheckedChangeListener { view, checked ->
            listener(checked, age)

            (view as Chip).post { view.setChipBackgroundColorResource(if(checked) R.color.soda else R.color.white) }

        }
    }

}