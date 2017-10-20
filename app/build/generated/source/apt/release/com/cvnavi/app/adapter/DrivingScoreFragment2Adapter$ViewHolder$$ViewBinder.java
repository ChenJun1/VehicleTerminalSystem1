// Generated code from Butter Knife. Do not modify!
package com.cvnavi.app.adapter;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class DrivingScoreFragment2Adapter$ViewHolder$$ViewBinder<T extends DrivingScoreFragment2Adapter.ViewHolder> implements ViewBinder<T> {
  @Override
  public Unbinder bind(final Finder finder, final T target, Object source) {
    InnerUnbinder unbinder = createUnbinder(target);
    View view;
    view = finder.findRequiredView(source, 2131558786, "field 'mSerialNumberTv'");
    target.mSerialNumberTv = finder.castView(view, 2131558786, "field 'mSerialNumberTv'");
    view = finder.findRequiredView(source, 2131558787, "field 'mBeginTimeTv'");
    target.mBeginTimeTv = finder.castView(view, 2131558787, "field 'mBeginTimeTv'");
    view = finder.findRequiredView(source, 2131558672, "field 'mMileageTv'");
    target.mMileageTv = finder.castView(view, 2131558672, "field 'mMileageTv'");
    view = finder.findRequiredView(source, 2131558661, "field 'mOilConsumptionTv'");
    target.mOilConsumptionTv = finder.castView(view, 2131558661, "field 'mOilConsumptionTv'");
    view = finder.findRequiredView(source, 2131558673, "field 'mAverageOilConsumptionTv'");
    target.mAverageOilConsumptionTv = finder.castView(view, 2131558673, "field 'mAverageOilConsumptionTv'");
    view = finder.findRequiredView(source, 2131558674, "field 'mAveragescoreTv'");
    target.mAveragescoreTv = finder.castView(view, 2131558674, "field 'mAveragescoreTv'");
    return unbinder;
  }

  protected InnerUnbinder<T> createUnbinder(T target) {
    return new InnerUnbinder(target);
  }

  protected static class InnerUnbinder<T extends DrivingScoreFragment2Adapter.ViewHolder> implements Unbinder {
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
      target.mSerialNumberTv = null;
      target.mBeginTimeTv = null;
      target.mMileageTv = null;
      target.mOilConsumptionTv = null;
      target.mAverageOilConsumptionTv = null;
      target.mAveragescoreTv = null;
    }
  }
}
