package io.hustler.freshcopartner.utils

import android.content.Context
import android.media.AudioManager
import android.media.SoundPool
import android.os.*
import io.hustler.freshcopartner.R
import io.hustler.freshcopartner.utils.log.TimberLogger

//import ph.bilidito..driver.R
//import ph.bilidito..driver.utils.log.TimberLogger

class AudioUtils private constructor(val context: Context) {
    private val TAG: String = "AUDIO UTILS"
    var soundPool: SoundPool? = null
    var soundID = 0
    var countDownTimer: CountDownTimer? = null
    val SHOW_TIME = 30 * 1000L
    private var vibrator: Vibrator? = null

    companion object {
        var audioUtils: AudioUtils? = null

        fun getInstance(context: Context): AudioUtils {
            if (null == audioUtils) {
                audioUtils = AudioUtils(context)
            }
            return audioUtils!!;
        }
    }

    fun playSound() {
        startVibrating()
        val loaded = BooleanArray(1)
        loaded[0] = false
//        context.volumeControlStream = AudioManager.STREAM_RING
        soundPool = SoundPool(10, AudioManager.STREAM_RING, 0)
        soundPool!!.setOnLoadCompleteListener { _: SoundPool?, _: Int, _: Int -> loaded[0] = true }
        soundID = soundPool!!.load(context, R.raw.driver_alarm, 1)
        val handleThread = HandlerThread("RINGTONE THREAD")
        handleThread.start()
        val handler = Handler(handleThread.looper)
        handler.postDelayed({
            val audioManager = (context.getSystemService(Context.AUDIO_SERVICE) as AudioManager)
            val actualVolume = audioManager
                    .getStreamVolume(AudioManager.STREAM_RING).toFloat()
            val maxVolume = audioManager
                    .getStreamMaxVolume(AudioManager.STREAM_RING).toFloat()
            val volume = actualVolume / maxVolume
            // Is the sound loaded already?
            soundPool!!.play(soundID, volume, volume, 1, 30, 1f)
            startCountDownTimer()
            TimberLogger.d(TAG, "Played sound")
        }, 300)
        handler.postDelayed({

        }, 300)
    }

    fun stopSound() {
        if (null != soundPool) {
            soundPool!!.stop(soundID)
        }
        if (null != countDownTimer) {
            (countDownTimer as CountDownTimer).cancel()
        }
        if (null != vibrator) {
            vibrator!!.cancel()
        }

    }

    private fun startCountDownTimer() {
        countDownTimer = object : CountDownTimer(30 * 1000L, 10) {
            override fun onTick(progress: Long) {
            }

            override fun onFinish() {
                stopSound()

            }

        }
        (countDownTimer as CountDownTimer).start()
    }

    private fun startVibrating() {
        vibrator = context.applicationContext.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        if (vibrator!!.hasVibrator()) {
            TimberLogger.d("Can Vibrate", "YES");
        } else {
            TimberLogger.d("Can Vibrate", "NO");
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val pattern = longArrayOf(1500, 800, 800, 800)
            vibrator!!.vibrate(VibrationEffect.createWaveform(pattern, 3))
        } else {
            vibrator!!.vibrate(10 * 1000)
        }
    }
}