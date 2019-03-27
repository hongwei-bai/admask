package com.jd.aibdp.genericbillboard.app.common.widget.admask

import com.jd.aibdp.genericbillboard.app.common.widget.admask.strategy.SoloStrategy
import com.jd.aibdp.genericbillboard.app.common.widget.admask.strategy.SwitchByApplySequentialStrategy
import com.jd.aibdp.genericbillboard.app.common.widget.admask.strategy.SwitchByClickAndApplySequentialStrategy
import com.jd.aibdp.genericbillboard.app.common.widget.admask.strategy.SwitchByImageChangeSequentialStrategy
import com.jd.aibdp.jdutils.Log

/**
 * Package: com.jd.aibdp.genericbillboard.app.common.widget.admask
 * User: baihongwei1
 * Email: baihongwei1@jd.com
 * Date: 2018/12/29
 * Time: 13:52
 * Description:
 */
object AdMaskStrategyFactory {
    val TAG = "AdMask"

    fun create(para: String?, jsonResKeyList: List<String>): IStrategy {
        val indexOfColon = para?.indexOf(":") ?: 0
        var type = para
        var detail = "0"
        if (indexOfColon > 0) {
            type = para?.substring(0, indexOfColon)
            detail = para?.substring(indexOfColon + 1) ?: "0"
        }

        Log.i(TAG, "type: " + type?.trim() + ", detail: " + detail)
        when (type?.trim()) {
            AdMaskKeys.PARA.SEQUENTIAL_PER_PAGE_PER_CLICK -> return SwitchByClickAndApplySequentialStrategy(jsonResKeyList)
            AdMaskKeys.PARA.SEQUENTIAL_PER_PAGE -> return SwitchByApplySequentialStrategy(jsonResKeyList)
            AdMaskKeys.PARA.SEQUENTIAL_PER_IMAGE_CHANGE -> return SwitchByImageChangeSequentialStrategy(jsonResKeyList)
            AdMaskKeys.PARA.SOLO -> return SoloStrategy(jsonResKeyList, detail.toInt())
        }

        return SwitchByClickAndApplySequentialStrategy(jsonResKeyList)
    }
}