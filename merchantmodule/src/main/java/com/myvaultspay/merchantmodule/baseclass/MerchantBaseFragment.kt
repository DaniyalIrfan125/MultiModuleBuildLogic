package com.myvaultspay.merchantmodule.baseclass

import android.os.Bundle
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import com.di.common.baseclasses.BaseFragment
import com.di.common.baseclasses.BaseViewModel
import com.myvaultspay.merchantmodule.MerchantSharedViewModel

abstract class MerchantBaseFragment<T : ViewDataBinding, V : BaseViewModel> : BaseFragment<T, V>() {


    lateinit var merchantSharedViewModel: MerchantSharedViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        merchantSharedViewModel =
            ViewModelProvider(requireActivity())[MerchantSharedViewModel::class.java]
    }
}