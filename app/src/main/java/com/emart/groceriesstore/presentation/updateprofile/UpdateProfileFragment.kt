package com.emart.groceriesstore.presentation.updateprofile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.emart.groceriesstore.R
import com.emart.groceriesstore.utilities.showMessageSnackBar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UpdateProfileFragment : Fragment() {

    private val viewModel: UpdateProfileViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                UpdateProfileScreen(onBackClick = ::navigateUp)
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setObserver()
    }

    private fun navigateUp() {
        findNavController().navigateUp()
    }

    private fun setObserver() {
        viewModel.isDoneUpdate.observe(viewLifecycleOwner) {
            if (it != null) {
                if (it == true) {
                    showMessageSnackBar(getString(R.string.update_profile_successfully))
                } else {
                    showMessageSnackBar(getString(R.string.update_profile_failed))
                }
            }
        }
    }
}
