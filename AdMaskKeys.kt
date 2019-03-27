package com.jd.aibdp.genericbillboard.app.common.widget.admask

/**
 * Package: com.jd.aibdp.genericbillboard.app.common.widget.admask
 * User: baihongwei1
 * Email: baihongwei1@jd.com
 * Date: 2018/12/29
 * Time: 10:48
 * Description:
 */
object AdMaskKeys {
    val MODULE_KEY_AD_MASK_LOTTIE_JSON_IMPACT = "ad_mask_lottie_json_impact"
    val MODULE_KEY_AD_MASK_LOTTIE_JSON_CUBE = "ad_mask_lottie_json_cube"
    val MODULE_KEY_AD_MASK_LOTTIE_JSON_SCATTER = "ad_mask_lottie_json_scatter"
    val MODULE_KEY_AD_MASK_LOTTIE_JSON_BUBBLE = "ad_mask_lottie_json_bubble"
    val MODULE_KEY_AD_MASK_LOTTIE_JSON_LINE = "ad_mask_lottie_json_line"

    const val PAGE_KEY_ADMASK_ANIMATION_ON = "admask_animation_on"
    const val PAGE_KEY_ADMASK_ANIMATION_PARA = "admask_animation_para"

    object PARA {
        val SEQUENTIAL_PER_PAGE = "sequential_per_page"                     //每个页面使用一个，顺序切换
        val SEQUENTIAL_PER_PAGE_PER_CLICK = "sequential_per_page_per_click" //切换页面、点击时顺序切换
        val SEQUENTIAL_PER_IMAGE_CHANGE = "sequential_per_image_change"     //随图片切换
        val SOLO = "solo"                                                   //只显示制定的一个：后面加参数：序号。e.g. "solo:1"
    }
}