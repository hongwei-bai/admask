package com.jd.aibdp.genericbillboard.app.common.widget.admask

/**
 * Package: com.jd.aibdp.genericbillboard.app.common.widget.admask
 * User: baihongwei1
 * Email: baihongwei1@jd.com
 * Date: 2018/12/29
 * Time: 13:54
 * Description: 该接口需要被业务页面调用，组件根据设置的策略决定在每个调用时机是否切换动画以及如何切换动画
 * 如果该接口未被业务逻辑调用（处理），动画将不能切换
 */
interface IAdMaskNotify {
    /*
     * 当广告素材被点击时调用
     */
    fun onClick()

    /*
     * 当页面加载时调用
     */
    fun onPageChange()

    /*
     * 当广告素材图片切换时调用
     */
    fun onImageChange()
}