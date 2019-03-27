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
class SoloStrategy(var jsonResKeyList: List<String>, val index: Int) : IStrategy {
    val listLength: Int
    var invokeSwitch: (String) -> Unit = {}

    init {
        listLength = jsonResKeyList.size
    }

    override fun onClick() {
    }

    override fun onPageChange() {
        change()
    }

    override fun onImageChange() {
    }

    override fun switch(ob: (String) -> Unit) {
        invokeSwitch = ob
    }

    private fun change() {
        if (listLength > 0 && listLength > index) {
            invokeSwitch(jsonResKeyList.get(index))
        }
    }
}