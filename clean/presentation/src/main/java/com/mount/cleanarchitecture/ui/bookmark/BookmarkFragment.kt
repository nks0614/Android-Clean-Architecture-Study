package com.mount.cleanarchitecture.ui.bookmark

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.mount.cleanarchitecture.BR
import com.mount.cleanarchitecture.R
import com.mount.cleanarchitecture.base.BindingFragment
import com.mount.cleanarchitecture.base.EventObserver
import com.mount.cleanarchitecture.databinding.FragmentBookmarkBinding
import org.koin.androidx.viewmodel.ext.android.getViewModel

class BookmarkFragment : BindingFragment<FragmentBookmarkBinding>() {

    //lazy로 늦은 초기화
    private val viewModel : BookmarkViewModel by lazy {
        getViewModel(BookmarkViewModel::class)
    }

    override fun getLayoutRes(): Int = R.layout.fragment_bookmark

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.setVariable(BR.viewModel, viewModel)
    }

    override fun onResume() {
        super.onResume()
        viewModel.getAllBookmarkUser(viewModel.userName.value)
    }

    override fun observeEvent() {
        with(viewModel) {
            onErrorEvent.observe(this@BookmarkFragment, EventObserver {
                Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
            })
        }
    }

}