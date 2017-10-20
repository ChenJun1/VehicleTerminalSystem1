// Generated code from Butter Knife. Do not modify!
package com.cvnavi.app.ui.activity;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import java.lang.Object;
import java.lang.Override;

public class RealTimeInformationActivity$$ViewBinder<T extends RealTimeInformationActivity> extends ToolbarActivity$$ViewBinder<T> {
  @Override
  public Unbinder bind(final Finder finder, final T target, Object source) {
    InnerUnbinder unbinder = (InnerUnbinder) super.bind(finder, target, source);
    View view;
    view = finder.findRequiredView(source, 2131558694, "field 'mEngineSpeedTv'");
    target.mEngineSpeedTv = finder.castView(view, 2131558694, "field 'mEngineSpeedTv'");
    view = finder.findRequiredView(source, 2131558761, "field 'mCellVoltageTv'");
    target.mCellVoltageTv = finder.castView(view, 2131558761, "field 'mCellVoltageTv'");
    view = finder.findRequiredView(source, 2131558723, "field 'mExternalVoltageTv'");
    target.mExternalVoltageTv = finder.castView(view, 2131558723, "field 'mExternalVoltageTv'");
    view = finder.findRequiredView(source, 2131558762, "field 'mCumulativeFuelConsumptionTv'");
    target.mCumulativeFuelConsumptionTv = finder.castView(view, 2131558762, "field 'mCumulativeFuelConsumptionTv'");
    view = finder.findRequiredView(source, 2131558763, "field 'mTemperatureTv'");
    target.mTemperatureTv = finder.castView(view, 2131558763, "field 'mTemperatureTv'");
    view = finder.findRequiredView(source, 2131558704, "field 'mOilPressureTv'");
    target.mOilPressureTv = finder.castView(view, 2131558704, "field 'mOilPressureTv'");
    view = finder.findRequiredView(source, 2131558764, "field 'mInstantaneousFuelConsumptionTv'");
    target.mInstantaneousFuelConsumptionTv = finder.castView(view, 2131558764, "field 'mInstantaneousFuelConsumptionTv'");
    view = finder.findRequiredView(source, 2131558696, "field 'mEngineTorqueTv'");
    target.mEngineTorqueTv = finder.castView(view, 2131558696, "field 'mEngineTorqueTv'");
    return unbinder;
  }

  @Override
  protected InnerUnbinder<T> createUnbinder(T target) {
    return new InnerUnbinder(target);
  }

  protected static class InnerUnbinder<T extends RealTimeInformationActivity> extends ToolbarActivity$$ViewBinder.InnerUnbinder<T> {
    protected InnerUnbinder(T target) {
      super(target);
    }

    @Override
    protected void unbind(T target) {
      super.unbind(target);
      target.mEngineSpeedTv = null;
      target.mCellVoltageTv = null;
      target.mExternalVoltageTv = null;
      target.mCumulativeFuelConsumptionTv = null;
      target.mTemperatureTv = null;
      target.mOilPressureTv = null;
      target.mInstantaneousFuelConsumptionTv = null;
      target.mEngineTorqueTv = null;
    }
  }
}
