package com.jd.aibdp.genericbillboard.app.common.widget.admask.strategy

import com.jd.aibdp.genericbillboard.app.common.widget.admask.IStrategy

/**
 * Package: com.jd.aibdp.genericbillboard.app.common.widget.admask.strategy
 * User: baihongwei1
 * Email: baihongwei1@jd.com
 * Date: 2018/12/29
 * Time: 14:35
 * Description:
 */
class SwitchByApplySequentialStrategy(var jsonResKeyList: List<String>) : IStrategy {
    var playCounter = 0
    val listLength: Int
    var invokeSwitch: (String) -> Unit = {}

    init {
        listLength = jsonResKeyList.size
    }

    override fun onClick() {
    }

    override fun onPageChange() {
    }

    override fun onImageChange() {
        change()
    }

    override fun switch(ob: (String) -> Unit) {
        invokeSwitch = ob
    }

    private fun change() {
        if (listLength > 0) {
            invokeSwitch(jsonResKeyList.get(playCounter % listLength))
        }
        safeInc()
    }

    private fun safeInc() {
        playCounter++
        if (playCounter > 99999999999) {
            playCounter = 0
        }
    }
}