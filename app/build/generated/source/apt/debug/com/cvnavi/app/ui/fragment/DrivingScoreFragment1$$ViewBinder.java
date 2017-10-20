// Generated code from Butter Knife. Do not modify!
package com.cvnavi.app.ui.fragment;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class DrivingScoreFragment1$$ViewBinder<T extends DrivingScoreFragment1> implements ViewBinder<T> {
  @Override
  public Unbinder bind(final Finder finder, final T target, Object source) {
    InnerUnbinder unbinder = createUnbinder(target);
    View view;
    view = finder.findRequiredView(source, 2131558706, "field 'mMileageTv'");
    target.mMileageTv = finder.castView(view, 2131558706, "field 'mMileageTv'");
    view = finder.findRequiredView(source, 2131558695, "field 'mOilConsumptionTv'");
    target.mOilConsumptionTv = finder.castView(view, 2131558695, "field 'mOilConsumptionTv'");
    view = finder.findRequiredView(source, 2131558707, "field 'mAverageOilConsumptionTv'");
    target.mAverageOilConsumptionTv = finder.castView(view, 2131558707, "field 'mAverageOilConsumptionTv'");
    view = finder.findRequiredView(source, 2131558708, "field 'mAveragescoreTv'");
    target.mAveragescoreTv = finder.castView(view, 2131558708, "field 'mAveragescoreTv'");
    view = finder.findRequiredView(source, 2131558709, "field 'mSpeedXTv'");
    target.mSpeedXTv = finder.castView(view, 2131558709, "field 'mSpeedXTv'");
    view = finder.findRequiredView(source, 2131558710, "field 'mPercentTv'");
    target.mPercentTv = finder.castView(view, 2131558710, "field 'mPercentTv'");
    view = finder.findRequiredView(source, 2131558711, "field 'mFractionTv'");
    target.mFractionTv = finder.castView(view, 2131558711, "field 'mFractionTv'");
    return unbinder;
  }

  protected InnerUnbinder<T> createUnbinder(T target) {
    return new InnerUnbinder(target);
  }

  protected static class InnerUnbinder<T extends DrivingScoreFragment1> implements Unbinder {
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
      target.mMileageTv = null;
      target.mOilConsumptionTv = null;
      target.mAverageOilConsumptionTv = null;
      target.mAveragescoreTv = null;
      target.mSpeedXTv = null;
      target.mPercentTv = null;
      target.mFractionTv = null;
    }
  }
}
