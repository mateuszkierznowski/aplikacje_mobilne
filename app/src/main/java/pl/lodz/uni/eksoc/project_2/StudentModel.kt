package pl.lodz.uni.eksoc.project_2

import java.util.*

data class StudentModel(
        var id: Int = getAutoId(),
        var name: String = "",
        var wl1: String = "",
        var wl2: String = "",
        var wl3: String = "",
        var champ1: String = "",
        var champ2: String = "",
        var champ3: String = "",
        var kda1: String = "",
        var kda2: String = "",
        var kda3: String = ""
        ) {
    companion object {
        fun getAutoId():Int{
            val random = Random()
            return random.nextInt(100)
        }
    }
}