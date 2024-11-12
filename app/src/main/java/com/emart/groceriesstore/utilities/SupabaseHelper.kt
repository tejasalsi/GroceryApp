package com.emart.groceriesstore.utilities

import com.emart.groceriesstore.BuildConfig

object SupabaseHelper {

    fun buildImageUrl(imageKey: String): String {
        val storageUrl = "${BuildConfig.SUPABASE_URL}/storage/v1/object/public"
        return "$storageUrl/$imageKey"
    }

}