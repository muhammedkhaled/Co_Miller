package com.example.comiller

import android.app.Activity
import android.content.*
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.comiller.data.network.response.ErrorResponse
import com.google.android.material.snackbar.Snackbar
import net.aqua_waterfliter.jo.confirmation.data.network.ResultWrapper
import java.text.SimpleDateFormat
import java.util.*

fun <A : Activity> Activity.startNewActivity(activity: Class<A>) {
    Intent(this, activity).also {
        it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(it)
    }
}

fun View.visible(isVisible: Boolean) {
    visibility = if (isVisible) View.VISIBLE else View.GONE
}

fun View.enable(enabled: Boolean) {
    isEnabled = enabled
    alpha = if (enabled) 1f else 0.5f
}

fun View.snackbar(message: String, root: View = this ,action: (() -> Unit)? = null , length: Int = Snackbar.LENGTH_LONG) {
    val snackbar = Snackbar.make(root, message, length)
    action?.let {
        snackbar.setAction("Retry") {
            it()
        }
    }
    snackbar.show()
}


fun Fragment.handleApiError(
    failure: ResultWrapper.GenericError,
    retry: (() -> Unit)? = null,
    length: Int = Snackbar.LENGTH_LONG,
    root: View = requireView().rootView
) {
    when {
        failure.isNetworkError == true -> requireView().snackbar(
            "please check your internet connection",
            root = root,
            action = retry, length = length
        )

        failure.errorCode == 403 -> {
            if (failure.error != null) {
                val errorResponse: ErrorResponse = failure.error as ErrorResponse
                requireView().snackbar(errorResponse.msg, root = root, action = retry, length = length)
            }
        }

        failure.errorCode == 401 -> {
            Toast.makeText(requireContext(), "Wrong email or password!!", Toast.LENGTH_SHORT).show()
        }

        failure.errorCode == 411 -> {
            val error = failure.error as ErrorResponse
            requireView().snackbar(error.msg, root = root, action = retry, length = length)
        }

        failure.errorCode == 429 -> {
            val error = failure.error as ErrorResponse?
            requireView().snackbar(error?.msg ?: "", root = root, action = retry, length = length)
        }

        else -> {
            val error: String? = failure.error.toString()
            requireView().snackbar(error ?: "", root = root, action = retry, length = length)
        }
    }
}

/*fun Fragment.logout(){
    activity?.startNewActivity(IntroActivity::class.java)
}*/

fun Activity.changeLayoutDirection(isRTL: Boolean) {
    val locale = if (isRTL) Locale("ar") else Locale("en")
    Locale.setDefault(locale)
    val config =
        baseContext.resources.configuration
    config.setLocale(locale)
    createConfigurationContext(config)
}

fun todayDate(): String {
    return SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).format(Date())
}

class DebounceOnClickListener(
    private val interval: Long,
    private val listenerBlock: (View) -> Unit,
) : View.OnClickListener {
    private var lastClickTime = 0L

    override fun onClick(v: View) {
        val time = System.currentTimeMillis()
        if (time - lastClickTime >= interval) {
            lastClickTime = time
            listenerBlock(v)
        }
    }
}

fun View.setOnClickListener(debounceInterval: Long, listenerBlock: (View) -> Unit) =
    setOnClickListener(DebounceOnClickListener(debounceInterval, listenerBlock))

inline fun <T1: Any, T2: Any, R: Any> safeLet(p1: T1?, p2: T2?, block: (T1, T2)->R?): R? {
    return if (p1 != null && p2 != null) block(p1, p2) else null
}

