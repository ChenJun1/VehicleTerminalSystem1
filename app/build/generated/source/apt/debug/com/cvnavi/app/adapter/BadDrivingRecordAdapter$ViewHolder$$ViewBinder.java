// Generated code from Butter Knife. Do not modify!
package com.cvnavi.app.adapter;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class BadDrivingRecordAdapter$ViewHolder$$ViewBinder<T extends BadDrivingRecordAdapter.ViewHolder> implements ViewBinder<T> {
  @Override
  public Unbinder bind(final Finder finder, final T target, Object source) {
    InnerUnbinder unbinder = createUnbinder(target);
    View view;
    view = finder.findRequiredView(source, 2131558865, "field 'mLicenseNoTv'");
    target.mLicenseNoTv = finder.castView(view, 2131558865, "field 'mLicenseNoTv'");
    view = finder.findRequiredView(source, 2131558864, "field 'mIndexTv'");
    target.mIndexTv = finder.castView(view, 2131558864, "field 'mIndexTv'");
    view = finder.findRequiredView(source, 2131558866, "field 'mBeginTimeTv'");
    target.mBeginTimeTv = finder.castView(view, 2131558866, "field 'mBeginTimeTv'");
    view = finder.findRequiredView(source, 2131558543, "field 'mEndTimeTv'");
    target.mEndTimeTv = finder.castView(view, 2131558543, "field 'mEndTimeTv'");
    view = finder.findRequiredView(source, 2131558867, "field 'mTurnOverNumberTv'");
    target.mTurnOverNumberTv = finder.castView(view, 2131558867, "field 'mTurnOverNumberTv'");
    view = finder.findRequiredView(source, 2131558868, "field 'mSpeedingNumberTv'");
    target.mSpeedingNumberTv = finder.castView(view, 2131558868, "field 'mSpeedingNumberTv'");
    return unbinder;
  }

  protected InnerUnbinder<T> createUnbinder(T target) {
    return new InnerUnbinder(target);
  }

  protected static class InnerUnbinder<T extends BadDrivingRecordAdapter.ViewHolder> implements Unbinder {
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
      target.mLicenseNoTv = null;
      target.mIndexTv = null;
      target.mBeginTimeTv = null;
      target.mEndTimeTv = null;
      target.mTurnOverNumberTv = null;
      target.mSpeedingNumberTv = null;
    }
  }
}
