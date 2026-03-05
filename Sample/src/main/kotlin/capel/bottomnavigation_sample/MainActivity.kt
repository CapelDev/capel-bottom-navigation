package capel.bottomnavigation_sample

import android.graphics.Typeface
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import capel.bottomnavigation.CapelBottomNavigation
import com.etebarian.capelbottomnavigation_sample.R
import com.etebarian.capelbottomnavigation_sample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    companion object {
        private const val ID_HOME = 1
        private const val ID_EXPLORE = 2
        private const val ID_MESSAGE = 3
        private const val ID_NOTIFICATION = 4
        private const val ID_ACCOUNT = 5
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(
            this,
            R.layout.activity_main
        )

        val tvSelected = binding.tvSelected
        tvSelected.typeface = Typeface.createFromAsset(assets, "fonts/SourceSansPro-Regular.ttf")

        binding.bottomNavigation.apply {

            add(
                CapelBottomNavigation.Model(
                    ID_HOME,
                    R.drawable.ic_home
                )
            )
            add(
                CapelBottomNavigation.Model(
                    ID_EXPLORE,
                    R.drawable.ic_explore
                )
            )
            add(
                CapelBottomNavigation.Model(
                    ID_MESSAGE,
                    R.drawable.ic_message
                )
            )
            add(
                CapelBottomNavigation.Model(
                    ID_NOTIFICATION,
                    R.drawable.ic_notification
                )
            )
            add(
                CapelBottomNavigation.Model(
                    ID_ACCOUNT,
                    R.drawable.ic_account
                )
            )

            setCount(ID_NOTIFICATION, "115")

            setOnShowListener {
                val name = when (it.id) {
                    ID_HOME -> "HOME"
                    ID_EXPLORE -> "EXPLORE"
                    ID_MESSAGE -> "MESSAGE"
                    ID_NOTIFICATION -> "NOTIFICATION"
                    ID_ACCOUNT -> "ACCOUNT"
                    else -> ""
                }

                tvSelected.text = getString(R.string.main_page_selected, name)
            }

            setOnClickMenuListener {
//                val name = when (it.id) {
//                    ID_HOME -> "HOME"
//                    ID_EXPLORE -> "EXPLORE"
//                    ID_MESSAGE -> "MESSAGE"
//                    ID_NOTIFICATION -> "NOTIFICATION"
//                    ID_ACCOUNT -> "ACCOUNT"
//                    else -> ""
//                }
            }

            setOnReselectListener {
                Toast.makeText(context, "item ${it.id} is reselected.", Toast.LENGTH_LONG).show()
            }

            show(ID_HOME)
        }

//        binding.btShow.setOnClickListener {
//            val id = try {
//                binding.etPageId.text.toString().toInt()
//            } catch (_: Exception) {
//                ID_HOME
//            }
//            if (id in ID_HOME..ID_ACCOUNT)
//                binding.bottomNavigation.show(id)
//        }
    }
}
