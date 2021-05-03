package com.mount.cleanarchitecture.ui.github

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.mount.cleanarchitecture.BR
import com.mount.cleanarchitecture.R
import com.mount.cleanarchitecture.base.BindingFragment
import com.mount.cleanarchitecture.base.EventObserver
import com.mount.cleanarchitecture.databinding.FragmentGithubBinding
import org.koin.androidx.viewmodel.ext.android.getViewModel

class GithubFragment : BindingFragment<FragmentGithubBinding>() {

    //lazy를 통해 늦은 초기화
    private val viewModel : GithubViewModel by lazy {
        getViewModel(GithubViewModel::class)
    }

    override fun getLayoutRes(): Int = R.layout.fragment_github

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.setVariable(BR.viewModel, viewModel)
    }

    override fun onResume() {
        super.onResume()
        viewModel.getAllSearchUser(viewModel.userName.value!!)
    }

    override fun observeEvent() {
        with(viewModel) {
            onErrorEvent.observe(this@GithubFragment, EventObserver {
                Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
            })
        }
    }

}