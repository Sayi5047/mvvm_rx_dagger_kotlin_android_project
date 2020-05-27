package io.hustler.freshcopartner.utils

import android.content.Context

class NotificationUtils constructor(private val applicationContext: Context) {
    val TAG = "NotificationUtils"
    private val CHANNEL_ID = "TRIP_NOTIFICATION_CHANNEL"
    private val GROUP_ID = "TRIP_NOTIFICATION_GROUP_ID"
    private val GROUP_NAME = "TRIP_NOTIFICATION_GROUP"
    private val GROUP_KEY = "TRIP_NOTIFICATION_GROUP_KEY"
    private var NOTIFICTION_ID = 1

//    fun showTripNotification(notificationData: MyFirebaseMessagingService.NotificationData) {
//        TimberLogger.i(TAG, "Notification Called")
//
//        createNotificationChannel()
//
//        val collapsedRemoteViews = RemoteViews(applicationContext.packageName, R.layout.custom_trip_notification_layout_collapsed)
//        val expandedRemoteViews = RemoteViews(applicationContext.packageName, R.layout.custom_trip_notification_expanded_layout)
//        val headsUpRemoteViews = RemoteViews(applicationContext.packageName, R.layout.custom_trip_notification_headsup_layout)
//
//        val notificationIntent = getTripNotificationActivityIntent(notificationData, -1)
//        val notificationPendingIntent = PendingIntent.getActivity(applicationContext, 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT)
//
//        val acceptIntent = getTripNotificationRecieverIntent(notificationData, 0)
//        val acceptBtnPendingIntent = PendingIntent.getBroadcast(applicationContext, 1, acceptIntent, PendingIntent.FLAG_UPDATE_CURRENT)
//
//        val rejectIntent = getTripNotificationRecieverIntent(notificationData, 1)
//        val rejectBtnPendingEvent = PendingIntent.getBroadcast(applicationContext, 2, rejectIntent, PendingIntent.FLAG_UPDATE_CURRENT)
//
//        val ignoreIntent = getTripNotificationRecieverIntent(notificationData, 2)
//        val ignoreBtnPendingEvent = PendingIntent.getBroadcast(applicationContext, 3, ignoreIntent, PendingIntent.FLAG_UPDATE_CURRENT)
//
//        expandedRemoteViews.setOnClickPendingIntent(R.id.accept_btn, acceptBtnPendingIntent)
//        expandedRemoteViews.setOnClickPendingIntent(R.id.reject_btn, rejectBtnPendingEvent)
//        expandedRemoteViews.setOnClickPendingIntent(R.id.ignore_btn, ignoreBtnPendingEvent)
//
//        collapsedRemoteViews.setOnClickPendingIntent(R.id.accept, acceptBtnPendingIntent)
//        collapsedRemoteViews.setOnClickPendingIntent(R.id.reject, rejectBtnPendingEvent)
//        collapsedRemoteViews.setOnClickPendingIntent(R.id.ignore, ignoreBtnPendingEvent)
//
//        headsUpRemoteViews.setOnClickPendingIntent(R.id.accept, acceptBtnPendingIntent)
//        headsUpRemoteViews.setOnClickPendingIntent(R.id.reject, rejectBtnPendingEvent)
//        headsUpRemoteViews.setOnClickPendingIntent(R.id.ignore, ignoreBtnPendingEvent)
//
//        var notification: Notification
//
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
//            notification = NotificationCompat
//                    .Builder(applicationContext,CHANNEL_ID)
//                    .setTimeoutAfter(30 * 1000)
//                    .setPriority(NotificationCompat.PRIORITY_HIGH)
//                    .setTicker("Incoming Trip Request")
//                    .setCategory(NotificationCompat.CATEGORY_CALL)
//                    .setOngoing(true)
//                    .setAutoCancel(true)
//                    .setSmallIcon(R.drawable.ic_delivery_truck_green)
//                    .setCustomContentView(collapsedRemoteViews)
//                    .setCustomBigContentView(expandedRemoteViews)
//                    .setCustomHeadsUpContentView(headsUpRemoteViews)
//                    .setStyle(NotificationCompat.DecoratedCustomViewStyle())
//                    .setContentIntent(notificationPendingIntent)
//                    .setWhen(System.currentTimeMillis())
//                    .build()
//        } else {
//            notification = NotificationCompat
//                    .Builder(applicationContext,CHANNEL_ID)
//                    .setDefaults(Notification.DEFAULT_ALL)
//                    .setPriority(Notification.PRIORITY_HIGH)
//                    .setTicker("Incoming Trip Request")
//                    .setCategory(NotificationCompat.CATEGORY_CALL)
//                    .setOngoing(true)
//                    .setAutoCancel(true)
//                    .setSmallIcon(R.drawable.ic_delivery_truck_green)
//                    .setLargeIcon(BitmapFactory.decodeResource(applicationContext.resources, R.mipmap.ic_launcher))
//                    .addAction(0, "Reject", rejectBtnPendingEvent)
//                    .addAction(0, "ignore", ignoreBtnPendingEvent)
//                    .addAction(0, "Accept", acceptBtnPendingIntent)
//                    .setContentTitle("Incoming Trip Request")
//                    .setContentText("A new trip is ready to accept")
//                    .setStyle(NotificationCompat.BigPictureStyle().bigPicture(BitmapFactory.decodeResource(applicationContext.resources, R.mipmap.ic_launcher)))
//                    .setContentIntent(notificationPendingIntent)
//                    .setWhen(System.currentTimeMillis())
//                    .setTimeoutAfter(30 * 1000)
//
//                    .build()
//        }
//
//
//        (applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager).notify(System.currentTimeMillis().toInt(), notification)
//        AudioUtils.getInstance(applicationContext).playSound()
//
//    }
//
//    private fun getTripNotificationActivityIntent(notificationData: MyFirebaseMessagingService.NotificationData, actionId: Int): Intent {
//        val intent = Intent(applicationContext, TripNotificationActivity::class.java)
//        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
//        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
//        intent.putExtra(Constants.PENDING_INTENTS_NOTIFICATION_TRIP_ID, notificationData.tripId)
//        intent.putExtra(Constants.PENDING_INTENTS_NOTIFICATION_TRIP_PICK_COUNT, notificationData.pickupCount)
//        intent.putExtra(Constants.PENDING_INTENTS_NOTIFICATION_TRIP_DROP_COUNT, notificationData.dropCount)
//        intent.putExtra(Constants.PENDING_INTENTS_NOTIFICATION_TRIP_BROADCAST_NUMBER, notificationData.broadcastId)
//        intent.putExtra(Constants.PENDING_INTENTS_NOTIFICATION_TRIP_IS_NOTIFICATION, false)
//        intent.putExtra(Constants.PENDING_INTENTS_NOTIFICATION_TRIP_ACTION_ID, actionId)
//        return intent
//    }
//
//    private fun getTripNotificationRecieverIntent(notificationData: MyFirebaseMessagingService.NotificationData, actionId: Int): Intent {
//        val intent = Intent(applicationContext, TripAcceptReceivers::class.java)
//        intent.putExtra(Constants.PENDING_INTENTS_NOTIFICATION_TRIP_ID, notificationData.tripId)
//        intent.putExtra(Constants.PENDING_INTENTS_NOTIFICATION_TRIP_PICK_COUNT, notificationData.pickupCount)
//        intent.putExtra(Constants.PENDING_INTENTS_NOTIFICATION_TRIP_DROP_COUNT, notificationData.dropCount)
//        intent.putExtra(Constants.PENDING_INTENTS_NOTIFICATION_TRIP_BROADCAST_NUMBER, notificationData.broadcastId)
//        intent.putExtra(Constants.PENDING_INTENTS_NOTIFICATION_TRIP_IS_NOTIFICATION, true)
//        intent.putExtra(Constants.PENDING_INTENTS_NOTIFICATION_TRIP_ACTION_ID, actionId)
//        return intent
//    }
//
//    private fun createNotificationChannel() {
//
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//
//            val notificationChannelGroup = NotificationChannelGroup(GROUP_ID, GROUP_NAME)
//            (applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager).createNotificationChannelGroup(notificationChannelGroup)
//            val name: CharSequence = "Trip Notification"
//            val description: CharSequence = " Notifies user to respond for trip request"
//            val importance = NotificationManager.IMPORTANCE_HIGH
//            val notificationChannel = NotificationChannel(CHANNEL_ID, name, importance)
//            notificationChannel.description = description.toString()
//            notificationChannel.enableLights(true)
//            notificationChannel.enableVibration(true)
//            notificationChannel.vibrationPattern = longArrayOf(0, 1000, 500, 1000)
//            notificationChannel.lightColor = Color.RED
//            notificationChannel.group = GROUP_ID
//
//            (applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager).createNotificationChannel(notificationChannel)
//
//        }
//
//    }
}