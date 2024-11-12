package com.emart.groceriesstore.presentation.onboarding.widgets

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.emart.groceriesstore.R
import com.emart.groceriesstore.presentation.core.widgets.PrimaryButton
import com.emart.groceriesstore.presentation.onboarding.OnboardingViewModel

@Composable
fun OnboardingGetStartedButton(
    modifier: Modifier = Modifier,
    viewModel: OnboardingViewModel = hiltViewModel(),
    navigateToMainInitialScreen: () -> Unit
) {
    val enabled = viewModel.isSyncedSuccessful.collectAsState()
    PrimaryButton(
        modifier = modifier,
        onClick = navigateToMainInitialScreen,
        enabled = enabled.value,
    ) {
        Text(text = stringResource(id = R.string.get_started))
    }
}