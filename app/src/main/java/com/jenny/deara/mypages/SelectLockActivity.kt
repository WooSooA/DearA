package com.jenny.deara.mypages

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.jenny.deara.MyPageActivity
import com.jenny.deara.R
import com.jenny.deara.databinding.ActivitySignInBinding
import kotlinx.android.synthetic.main.activity_select_lock.*


class SelectLockActivity : AppCompatActivity() {


    val binding by lazy { ActivitySignInBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_lock)

        back.setOnClickListener {
            val intent = Intent(this, MyPageActivity::class.java)
            startActivity(intent)
        }
    }
}
