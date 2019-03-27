package com.jd.aibdp.genericbillboard.app.common.widget.admask

import com.airbnb.lottie.LottieAnimationView
import com.jd.aibdp.genericbillboard.platform.api.Platform
import com.jd.aibdp.jdutils.Log

/**
 * Package: com.jd.aibdp.genericbillboard.app.common.widget.admask
 * User: baihongwei1
 * Email: baihongwei1@jd.com
 * Date: 2018/12/29
 * Time: 11:18
 * Description:
 */
class AdMaskContainer(var lottieAnimationView: LottieAnimationView) : IAdMaskNotify {
    companion object {
        val TAG = "AdMask"
    }

    var para: String? = null
    var pageKey: String? = null

    var defaultLottieJsonList = mutableListOf<String>()
    var lottieJsonList = mutableListOf<String>()
    var playStrategy: IStrategy? = null

    init {
        defaultLottieJsonList.add(AdMaskKeys.MODULE_KEY_AD_MASK_LOTTIE_JSON_IMPACT)
        defaultLottieJsonList.add(AdMaskKeys.MODULE_KEY_AD_MASK_LOTTIE_JSON_CUBE)
        defaultLottieJsonList.add(AdMaskKeys.MODULE_KEY_AD_MASK_LOTTIE_JSON_SCATTER)
        defaultLottieJsonList.add(AdMaskKeys.MODULE_KEY_AD_MASK_LOTTIE_JSON_BUBBLE)
        defaultLottieJsonList.add(AdMaskKeys.MODULE_KEY_AD_MASK_LOTTIE_JSON_LINE)
    }

    /*
     * @param pageKey： String PageKey
     * @param jsonResKeyList： List<String> jsonResKeyList
     * @param para： String play parameters
     * 播放
     * 【注意】如果JSON资源挂在Module下面，不要传入pageKey参数
     */
    @JvmOverloads
    fun init(pageKey: String? = null, jsonResKeyList: List<String>? = null) {
        this.pageKey = pageKey

        lottieJsonList.clear()
        Log.i(TAG, "initJsonList")
        lottieJsonList.addAll(jsonResKeyList ?: defaultLottieJsonList)
        Log.i(TAG, "defaultLottieJsonList.length: " + defaultLottieJsonList.size)
        Log.i(TAG, "addAll, then list.length: " + lottieJsonList.size)
    }

    @JvmOverloads
    fun apply(enable: Boolean = true, para: String? = null) {
        if (!enable) {
            playStrategy = null
            lottieAnimationView.pauseAnimation()
            lottieAnimationView.cancelAnimation()
            return
        }

        Log.i(TAG, "strategy.para: " + this.para + " -> " + para)
        if (!this.para.equals(para)) {
            this.para = para
            playStrategy = AdMaskStrategyFactory.create(para, lottieJsonList)
            Log.i(TAG, "playStrategy: " + playStrategy)
            playStrategy?.switch {
                lottieAnimationView.pauseAnimation()
                lottieAnimationView = Platform.getInstance().configApply.loadLottieAnimationView(pageKey, lottieAnimationView, it).also { it.playAnimation() }
            }
        }
    }

    /*
     * 停止播放动画
     */
    fun stop() {
        lottieAnimationView.pauseAnimation()
        lottieAnimationView.cancelAnimation()
    }

    override fun onClick() {
        playStrategy?.onClick()
    }

    override fun onPageChange() {
        playStrategy?.onPageChange()
    }

    override fun onImageChange() {
        playStrategy?.onImageChange()
    }
}