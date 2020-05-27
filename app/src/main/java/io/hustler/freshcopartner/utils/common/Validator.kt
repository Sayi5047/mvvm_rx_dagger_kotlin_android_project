package io.hustler.freshcopartner.utils.common
import java.util.regex.Pattern

data class Validation(val field: Field, val resource: Resource<Int>) {
    enum class Field {
        MOBILENUMBER,
        PASSWORD,
        EMAIL,
        OTP,
        FIRSTPIN,
        CONFIRMPIN,
        FIRSTNAME,
        LASTNAME,
        ZIP,
        PROVINCE,
        OLDPIN,
        VEHICLE_PLATE,
        VEHICLE_MAX_CAPACITY,
        VEHICLE_BUILD,
        VEHICLE_MODEL,
        REG_NO,
        CHANGE_CAPACITY
    }
}

object Validator {
    private val EMAIL_ADDRESS = Pattern.compile(
            "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                    "\\@" +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                    "(" +
                    "\\." +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                    ")+"
    )
    private const val MIN_PIN_LENGTH = 6
    private const val MIN_MOBILE_LENGTH = 13




}