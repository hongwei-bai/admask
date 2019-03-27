package com.jd.aibdp.genericbillboard.app.septwolves;

/**
 * Package: com.jd.aibdp.genericbillboard.app.septwolves
 * User: niuzhikui
 * Email: niuzhikui@jd.com
 * Date: 2018-06-05
 * Time: 17:33
 * Description:
 */

public class SeptwolvesWelcomeFragment extends Fragment implements IPage, JDAdPresenter.ADResourceNotify {
    public static final String TAG = "SWF";

    private AdMaskContainer mAdMaskContainer;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mAdMaskContainer = new AdMaskContainer(mAdMaskLottieAnimationView);
        mAdMaskContainer.init();
    }

    @Override
    public void onPhase(int phase, IProgress progress) {
        switch (phase) {
            case IPage.PHASE_PRELOAD:
                break;
            case IPage.PHASE_REGISTER:
                break;
            case IPage.PHASE_SHOW:
                break;
            case IPage.PHASE_HIDE:
                mAdMaskContainer.stop();
                break;
            default:
                break;
        }
    }

    @Override
    public boolean apply(Object theme) {
        // 广告蒙版动画效果
        final boolean adMaskOn = Platform.getInstance().getConfigApply().getBoolean(getPageKey(), AdMaskKeys.PAGE_KEY_ADMASK_ANIMATION_ON);
        final String adMaskPara = Platform.getInstance().getConfigApply().getTextString(getPageKey(), AdMaskKeys.PAGE_KEY_ADMASK_ANIMATION_PARA);
        Log.i(TAG, "adMask, on:" + adMaskOn + ", para: " + adMaskPara);
        mAdMaskContainer.apply(adMaskOn, adMaskPara);
        mAdMaskContainer.onPageChange();

        return true;
    }

    /**
     * 设置广告资源数据
     *
     * @param mediaViewData
     */
    public void setLocalMediaViewData(List<MediaData> mediaViewData) {
        mLocalMediaView.setData(
                mediaViewData, (imageView, s) -> {
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    GlideWrapper.load(Platform.getInstance().getApplicationContext(), s, imageView);
                });
        mLocalMediaView.setEnableAutoScorll(true);
        mLocalMediaView.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                mAdMaskContainer.onImageChange();
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }
}
