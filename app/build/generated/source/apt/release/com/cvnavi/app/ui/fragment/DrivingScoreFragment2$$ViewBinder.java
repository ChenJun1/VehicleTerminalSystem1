// Generated code from Butter Knife. Do not modify!
package com.cvnavi.app.ui.fragment;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class DrivingScoreFragment2$$ViewBinder<T extends DrivingScoreFragment2> implements ViewBinder<T> {
  @Override
  public Unbinder bind(final Finder finder, final T target, Object source) {
    InnerUnbinder unbinder = createUnbinder(target);
    View view;
    view = finder.findRequiredView(source, 2131558681, "field 'mAllTimeTv'");
    target.mAllTimeTv = finder.castView(view, 2131558681, "field 'mAllTimeTv'");
    view = finder.findRequiredView(source, 2131558682, "field 'mAllMileTv'");
    target.mAllMileTv = finder.castView(view, 2131558682, "field 'mAllMileTv'");
    view = finder.findRequiredView(source, 2131558683, "field 'mAllOilConsumptionTv'");
    target.mAllOilConsumptionTv = finder.castView(view, 2131558683, "field 'mAllOilConsumptionTv'");
    view = finder.findRequiredView(source, 2131558684, "field 'mAverageOilConsumption2Tv'");
    target.mAverageOilConsumption2Tv = finder.castView(view, 2131558684, "field 'mAverageOilConsumption2Tv'");
    view = finder.findRequiredView(source, 2131558674, "field 'mAveragescoreTv'");
    target.mAveragescoreTv = finder.castView(view, 2131558674, "field 'mAveragescoreTv'");
    view = finder.findRequiredView(source, 2131558679, "field 'mLv'");
    target.mLv = finder.castView(view, 2131558679, "field 'mLv'");
    return unbinder;
  }

  protected InnerUnbinder<T> createUnbinder(T target) {
    return new InnerUnbinder(target);
  }

  protected static class InnerUnbinder<T extends DrivingScoreFragment2> implements Unbinder {
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
      target.mAllTimeTv = null;
      target.mAllMileTv = null;
      target.mAllOilConsumptionTv = null;
      target.mAverageOilConsumption2Tv = null;
      target.mAveragescoreTv = null;
      target.mLv = null;
    }
  }
}
