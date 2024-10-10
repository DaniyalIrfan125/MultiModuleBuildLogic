package com.myvaultspay.usermodule.baseclass

import android.os.Bundle
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import com.di.common.baseclasses.BaseFragment
import com.di.common.baseclasses.BaseViewModel
import com.myvaultspay.usermodule.UserSharedViewModel

abstract class UserBaseFragment<T : ViewDataBinding, V : BaseViewModel> : BaseFragment<T, V>() {


    lateinit var userSharedViewModel: UserSharedViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        userSharedViewModel = ViewModelProvider(requireActivity())[UserSharedViewModel::class.java]
    }
}