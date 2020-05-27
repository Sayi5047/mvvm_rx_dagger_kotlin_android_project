package io.hustler.freshcopartner.utils.constants;

import android.content.Intent;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Constants {
    public static final String SHARED_PREFS_LOGIN_KEY = "KEY_LOGIN";
    public static final String SHARED_PREFS_USER = "IS_DRIVER1";
    public static final String SHARED_PREFS_AUTH_KEY = "DRIVER_AUTH_KEY";
    public static final String SHARED_PREFS_USER_ID = "DRIVER_ID_KEY";
    public static final String SHARED_PREFS_USER_MOBILE_NUMBER = "DRIVER_PROFILE_DATA";
    public static final String SHARED_PREFS_DRIVER_DETAILS_UPDATED = "DRIVER_DETAILS_UPDATED";
    public static final String SHARED_PREFS_USER_EMAIL = "DRIVER_EMAIL";
    public static final String SHARED_PREFS_USER_REGION = "SHARED_PREFS_USER_REGION";
    public static final String SHARED_PREFS_USER_NAME = "DRIVER_NAME";
    public static final String SHARED_PREFS_USER_KYC_DONE = "DRIVER_KYC_DONE";
    public static final String SHARED_PREFS_IS_USER_ONLINE = "DRIVER_IS_ONLINE";
    public static final String SHARED_PREFS_CURRENT_TRIP_ID = "SHARED_PREFS_CURRENT_TRIP_ID";
    public static final String SHARED_PREFS_USER_ZIP_CODE = "SHARED_PREFS_USER_ZIP_CODE";


    public static final String TRUE = "True";
    public static final String CHANGED_TO_OFFLINE = "CHANGED_TO_OFFLINE";
    public static final String DRIVER_PROFILE_NOT_UPDATED = "DRIVER_PROFILE_NOT_UPDATED";
    public static final String CHANGED_TO_ONLINE = "CHANGED_TO_ONLINE";
    public static final String CURRENT_STATUS_IS_AVAILABLE = "CURRENT_STATUS_IS_AVAILABLE";
    public static final String CURRENT_STATUS_IS_BUSY = "CURRENT_STATUS_IS_BUSY";
    public static final String SHARED_PREFS_USER_IMAGE = "SHARED_PREFS_USER_IMAGE";
    public static final String SHARED_PREFS_USER_LAST_NAME = "SHARED_PREFS_USER_LAST_NAME";
    public static final String SHARED_PREFS_USER_VEHICLE_NUMBER = "SHARED_PREFS_USER_VEHICLE_NUMBER";
    public static final String SHARED_PREFS_USER_VEHICLE_CAPACITY = "SHARED_PREFS_USER_VEHICLE_CAPACITY";
    public static final String KYC_APPROVED = "KYC_APPROVED";
    public static final String KYC_NOT_APPROVED = "KYC_NOT_APPROVED";
    public static final String SHARED_PREFS_FCM_TOKEN = "SHARED_PREFS_FCM_TOKEN";
    public static final String PENDING_INTENTS_NOTIFICATION_TRIP_ID = "PENDING_INTENTS_NOTIFICATION_TRIP_ID";
    public static final String PENDING_INTENTS_NOTIFICATION_TRIP_PICK_COUNT = "PENDING_INTENTS_NOTIFICATION_TRIP_PICK_COUNT";
    public static final String PENDING_INTENTS_NOTIFICATION_TRIP_DROP_COUNT = "PENDING_INTENTS_NOTIFICATION_TRIP_DROP_COUNT";
    public static final String SHARED_PREFS_IS_ANY_ACTIVITY_VISIBLE = "SHARED_PREFS_IS_ANY_ACTIVITY_VISIBLE";
    public static final String SUCCESS = "SUCCESS";
    public static final String FAILURE = "FAILURE";
    public static final int API_SUCCESS = 2000;
    public static final int NO_INCOME = 2006;
    public static final int API_FAILURE = -2000;
    public static final int GET_DRIVER_PROFILE_SUCCESS = 3000;
    public static final int DRIVER_LOGOUT_SUCCESS = 2003;
    public static final int DRIVER_LOGOUT_FAILED = -2003;
    public static final int RETAILER_OTP_VERIFICATION_SUCCESS = 4000;
    public static final int RETAILER_OTP_VERIFICATION_FAILED = -4000;
    public static final String DRIVER_LOGOUT_SUCCESS_MESSAGE = "DRIVER_LOGOUT_SUCCESS";
    public static final String DRIVER_LOGOUT_FAILED_MESSAGE = "DRIVER_LOGOUT_FAILED";
    public static final String GET_DRIVER_PROFILE_SUCCESS_MESSSAGE = "GET_DRIVER_PROFILE_SUCCESS";
    public static final int KYC_NOT_APPROVED_CODE = 1001;
    public static final String STARTED = "Started";
    public static final String ARRIVED = "Arrived";
    public static final String PICKUP = "Pickup";
    public static final String PICKUP_ARRIVED = "PickupArrived";
    public static final String DROP = "Drop";
    public static final String DROP_ARRIVED = "DropArrived";

    public static final String TRIP_ASSIGNED = "TRIP_ASSIGNED";
    public static final String TRIP_ALREADY_ASSIGNED = "TRIP_ALREADY_ASSIGNED";


    public static final int TRIP_ASSIGNED_CODE = 2005;
    public static final int TRIP_ALREADY_ASSIGNED_CODE = -2005;
    public static final String INTENT_IS_TOCLOSE_APP = "INTENT_IS_TOCLOSE_APP";
    public static final int NO_TRIP_ASSIGNED = -6000;

    /*BROADCAST NODE PATHS*/
    public static final String TRIP_BROADCAST_ROOT_NODE = "trips";
    public static final String PENDING_INTENTS_NOTIFICATION_TRIP_BROADCAST_NUMBER = "broadcastId";
    public static final String PENDING_INTENTS_NOTIFICATION_TRIP_IS_NOTIFICATION = "IS_NOTIFICATION";
    public static final String PENDING_INTENTS_NOTIFICATION_TRIP_ACTION_ID = "ACTIONID";
    public static final String NOT_STARPAY_USER = "NOT_STARPAY_USER";
    public static final String GET_PROVINCE_SUCCESS = "GET_PROVINCE_SUCCESS";
    public static final String GET_ZIP_SUCCESS = "GET_ZIP_SUCCESS";
    public static final String UPDATE_SUCCESSFULLY = "UPDATE_SUCCESSFULLY";
    public static final String LOCATION_CHANNEL_ID = "LOCATION_NOTIFICATION_CHANNEL_ID";
    public static final CharSequence LOCATION_CHANNEL_NAME = "LOCATION_NOTIFICATION_CHANNEL";
    public static final String IS_LOCATION_RUNNING = "IS_LOCATION_RUNNING";
    public static final String LOGIN_SUCCESSFULL = "LOGIN_SUCCESSFUL";
    public static final String RETAILER_EXISTS = "RETAILER EXISTS";


    /*V2 Constants*/
    public static final String API_CHECK_DRIVER_ALREADY_EXISTS = "Driver Already Exist";
    public static final String API_CHECK_DRIVER_RETAILER_EXISTS = "RETAILER EXISTS";
    @NotNull
    public static final String SELECT_PROVINCE = "Select a Province";
    public static final String SELECT_ZIP = "Select your zip code";
    @Nullable
    public static final String SHARED_PREFS_USER_VEHICLE_BUILD = "SHARED_PREFS_USER_VEHICLE_BUILD";
    public static final String SHARED_PREFS_USER_VEHICLE_MODEL = "SHARED_PREFS_USER_VEHICLE_MODEL";
    public static final String SHARED_PREFS_USER_VEHICLE_REGNO = "SHARED_PREFS_USER_VEHICLE_REGNO";
    public static final String EDIT_CAPACITY_SUCCESS = "EDIT_CAPACITY_SUCCESS";
    public static final Integer EDIT_CAPACITY_SUCCESS_CODE = 2007;
    @Nullable
    public static final Integer DRIVER_INCOME=2006;

    public static class INTENT_CONSTANTS {
        @Nullable
        public static final String INTENT_NUMBER = "INTENT_NUMBER";
    }

    /**
     * DISTANCE MATRIX MAPS MONTHLY VOLUME RANGE
     * (Price per ELEMENT)
     * 0–100,000	100,001–500,000	500,000+
     * 0.005 USD per each
     * (5.00 USD per 1000)	0.004 USD per each
     * (4.00 USD per 1000)	Contact Sales for volume pricing
     * <p>
     * STATIC MAPS MONTHLY VOLUME RANGE
     * (Price per MAP LOAD)
     * 0–100,000	100,001–500,000	500,000+
     * 0.002 USD per each
     * (2.00 USD per 1000)	0.0016 USD per each
     * (1.60 USD per 1000)	Contact Sales for volume pricing
     */

    public static class lottieCredits {
        public static final String NO_HISTORY_LOTTIE_ICON_CREDIT = "https://lottiefiles.com/lucarondine";
        public static final String LOCATION_LOTTIE_ICON_CREDIT = "https://lottiefiles.com/edwinnollen";
        public static final String COMPLETED_LOTTIE_ICON_CREDIT = "https://lottiefiles.com/edwinnollen";
        public static final String BLUE_WAVES_ICON_CREDIT = "https://lottiefiles.com/trevx";
        public static final String ERROR_ICON_CREDIT = "https://lottiefiles.com/victorw";
        public static final String MONEY_ICON_CREDIT = "https://lottiefiles.com/animissimo";
        public static final String NEW_MAP_ICON_CREDIT = "https://lottiefiles.com/10581-location";

        /*VIEW PAGER CREDITS*/
        public static final String PAGER_1 = "https://lottiefiles.com/toniadegbenro";
        public static final String PAGER_2 = "https://lottiefiles.com/lottiefilez";
        public static final String PAGER_3 = "https://lottiefiles.com/aneeshravi";
        public static final String PAGER_4 = "https://lottiefiles.com/user/125845";

    }

    public static class MapsUrl {
        public static String mapUrl = "https://maps.googleapis.com/maps/api/staticmap" +
                "?center=<LOC>" +
                "&zoom=13" +
                "&size=600x300" +
                "&maptype=roadmap" +
                "&markers=color:blue%7Clabel:S%7C<LOC>" +
                "&scale=2" +
                "&key=AIzaSyDUJh4-PgWmvJtMZKL2Va_FJNu5WsP4SBQ";
    }

    public static class APISTATUS {
        public static final String SUCCESS = "SUCCESS";
        public static final String FAILURE = "FAILURE";
        public static final String UNKNOWN = "UNKNOWN";
    }
}
