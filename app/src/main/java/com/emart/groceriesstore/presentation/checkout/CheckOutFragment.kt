package com.emart.groceriesstore.presentation.checkout

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.emart.groceriesstore.R
import com.emart.groceriesstore.presentation.AuthActivity
import com.emart.groceriesstore.utilities.KeyData
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CheckOutFragment : Fragment() {

    private var deliveryContent: String = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        getDeliveryContentStr()

        return ComposeView(requireContext()).apply {
            setContent {
                CheckoutScreen(
                    onSuccessDialogDismiss = { findNavController().navigateUp() },
                    address = deliveryContent,
                    onDeliveryEdit = { findNavController().navigate(R.id.action_checkOutFragment_to_deliveryFragment) },
                    openAuthActivity = { startActivity(Intent(context, AuthActivity::class.java)) }
                )
            }
        }
    }

    private fun getDeliveryContentStr() {
        return parentFragmentManager.setFragmentResultListener(
            KeyData.RESULT_KEY,
            viewLifecycleOwner
        ) { _, bundle ->
            val name = bundle.getString(KeyData.NAME_KEY)
            val phone = bundle.getString(KeyData.PHONE_KEY)
            val street = bundle.getString(KeyData.STREET_KEY)
            val ward = bundle.getString(KeyData.WARD_KEY)
            val city = bundle.getString(KeyData.CITY_KEY)
            deliveryContent = "$name\n$phone\n$street, $ward, $city"
        }
    }
}
