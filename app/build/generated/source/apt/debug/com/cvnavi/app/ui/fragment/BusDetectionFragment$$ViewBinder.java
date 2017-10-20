// Generated code from Butter Knife. Do not modify!
package com.cvnavi.app.ui.fragment;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class BusDetectionFragment$$ViewBinder<T extends BusDetectionFragment> implements ViewBinder<T> {
  @Override
  public Unbinder bind(final Finder finder, final T target, Object source) {
    InnerUnbinder unbinder = createUnbinder(target);
    View view;
    view = finder.findRequiredView(source, 2131558693, "field 'mSensorOilTv'");
    target.mSensorOilTv = finder.castView(view, 2131558693, "field 'mSensorOilTv'");
    view = finder.findRequiredView(source, 2131558694, "field 'mEngineSpeedTv'");
    target.mEngineSpeedTv = finder.castView(view, 2131558694, "field 'mEngineSpeedTv'");
    view = finder.findRequiredView(source, 2131558695, "field 'mOilConsumptionTv'");
    target.mOilConsumptionTv = finder.castView(view, 2131558695, "field 'mOilConsumptionTv'");
    view = finder.findRequiredView(source, 2131558696, "field 'mEngineTorqueTv'");
    target.mEngineTorqueTv = finder.castView(view, 2131558696, "field 'mEngineTorqueTv'");
    view = finder.findRequiredView(source, 2131558697, "field 'mPedalPositionTv'");
    target.mPedalPositionTv = finder.castView(view, 2131558697, "field 'mPedalPositionTv'");
    view = finder.findRequiredView(source, 2131558698, "field 'mAllConsumptionTv'");
    target.mAllConsumptionTv = finder.castView(view, 2131558698, "field 'mAllConsumptionTv'");
    view = finder.findRequiredView(source, 2131558699, "field 'mMeterOilConsumptionTv'");
    target.mMeterOilConsumptionTv = finder.castView(view, 2131558699, "field 'mMeterOilConsumptionTv'");
    view = finder.findRequiredView(source, 2131558700, "field 'mTotalTimeTv'");
    target.mTotalTimeTv = finder.castView(view, 2131558700, "field 'mTotalTimeTv'");
    view = finder.findRequiredView(source, 2131558701, "field 'mWaterTemperatureTv'");
    target.mWaterTemperatureTv = finder.castView(view, 2131558701, "field 'mWaterTemperatureTv'");
    view = finder.findRequiredView(source, 2131558702, "field 'mEngineOilTemperatureTv'");
    target.mEngineOilTemperatureTv = finder.castView(view, 2131558702, "field 'mEngineOilTemperatureTv'");
    view = finder.findRequiredView(source, 2131558703, "field 'mIntakeTemperatureTv'");
    target.mIntakeTemperatureTv = finder.castView(view, 2131558703, "field 'mIntakeTemperatureTv'");
    view = finder.findRequiredView(source, 2131558704, "field 'mOilPressureTv'");
    target.mOilPressureTv = finder.castView(view, 2131558704, "field 'mOilPressureTv'");
    view = finder.findRequiredView(source, 2131558705, "field 'mAtmosphericPressureTv'");
    target.mAtmosphericPressureTv = finder.castView(view, 2131558705, "field 'mAtmosphericPressureTv'");
    return unbinder;
  }

  protected InnerUnbinder<T> createUnbinder(T target) {
    return new InnerUnbinder(target);
  }

  protected static class InnerUnbinder<T extends BusDetectionFragment> implements Unbinder {
    private T target;

    protected InnerUnbinder(T target) {
      this.target = target;
    }

    @Override
    public final void unbind() {
      if (target == null) throw new IllegalStateException("Bindings already cleared.");
      unbind(target);
      target = null;
    }

    protected void unbind(T target) {
      target.mSensorOilTv = null;
      target.mEngineSpeedTv = null;
      target.mOilConsumptionTv = null;
      target.mEngineTorqueTv = null;
      target.mPedalPositionTv = null;
      target.mAllConsumptionTv = null;
      target.mMeterOilConsumptionTv = null;
      target.mTotalTimeTv = null;
      target.mWaterTemperatureTv = null;
      target.mEngineOilTemperatureTv = null;
      target.mIntakeTemperatureTv = null;
      target.mOilPressureTv = null;
      target.mAtmosphericPressureTv = null;
    }
  }
}
