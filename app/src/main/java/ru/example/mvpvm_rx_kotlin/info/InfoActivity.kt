package ru.example.mvpvm_rx_kotlin.info

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import ru.example.mvpvm_rx_kotlin.R
import ru.example.mvpvm_rx_kotlin.databinding.ActivityInfoBinding

class InfoActivity : AppCompatActivity(), IInfo.IView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityInfoBinding>(this, R.layout.activity_info)
        val viewModel = InfoViewModel()
        val presenter = InfoPresenter(this, viewModel)
        binding.viewModel = viewModel
        binding.executePendingBindings()
        presenter.onViewInit()
    }

    override fun showToast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }
}
