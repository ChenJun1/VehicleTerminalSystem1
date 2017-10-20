// Generated code from Butter Knife. Do not modify!
package com.cvnavi.app.adapter;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class TravelRecordFragment2Adapter$ViewHolder$$ViewBinder<T extends TravelRecordFragment2Adapter.ViewHolder> implements ViewBinder<T> {
  @Override
  public Unbinder bind(final Finder finder, final T target, Object source) {
    InnerUnbinder unbinder = createUnbinder(target);
    View view;
    view = finder.findRequiredView(source, 2131558791, "field 'mIndexTv'");
    target.mIndexTv = finder.castView(view, 2131558791, "field 'mIndexTv'");
    view = finder.findRequiredView(source, 2131558792, "field 'mLicenseNoTv'");
    target.mLicenseNoTv = finder.castView(view, 2131558792, "field 'mLicenseNoTv'");
    view = finder.findRequiredView(source, 2131558787, "field 'mBeginTimeTv'");
    target.mBeginTimeTv = finder.castView(view, 2131558787, "field 'mBeginTimeTv'");
    view = finder.findRequiredView(source, 2131558543, "field 'mEndTimeTv'");
    target.mEndTimeTv = finder.castView(view, 2131558543, "field 'mEndTimeTv'");
    return unbinder;
  }

  protected InnerUnbinder<T> createUnbinder(T target) {
    return new InnerUnbinder(target);
  }

  protected static class InnerUnbinder<T extends TravelRecordFragment2Adapter.ViewHolder> implements Unbinder {
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
      target.mIndexTv = null;
      target.mLicenseNoTv = null;
      target.mBeginTimeTv = null;
      target.mEndTimeTv = null;
    }
  }
}
