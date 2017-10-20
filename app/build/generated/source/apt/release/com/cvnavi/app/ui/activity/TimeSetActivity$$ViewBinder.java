// Generated code from Butter Knife. Do not modify!
package com.cvnavi.app.ui.activity;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Finder;
import java.lang.Object;
import java.lang.Override;

public class TimeSetActivity$$ViewBinder<T extends TimeSetActivity> extends ToolbarActivity$$ViewBinder<T> {
  @Override
  public Unbinder bind(final Finder finder, final T target, Object source) {
    InnerUnbinder unbinder = (InnerUnbinder) super.bind(finder, target, source);
    View view;
    view = finder.findRequiredView(source, 2131558613, "field 'mYearTv'");
    target.mYearTv = finder.castView(view, 2131558613, "field 'mYearTv'");
    view = finder.findRequiredView(source, 2131558614, "field 'mMonthTv'");
    target.mMonthTv = finder.castView(view, 2131558614, "field 'mMonthTv'");
    view = finder.findRequiredView(source, 2131558615, "field 'mDdTv'");
    target.mDdTv = finder.castView(view, 2131558615, "field 'mDdTv'");
    view = finder.findRequiredView(source, 2131558616, "field 'mHhTv'");
    target.mHhTv = finder.castView(view, 2131558616, "field 'mHhTv'");
    view = finder.findRequiredView(source, 2131558617, "field 'mMmTv'");
    target.mMmTv = finder.castView(view, 2131558617, "field 'mMmTv'");
    view = finder.findRequiredView(source, 2131558618, "field 'mSsTv'");
    target.mSsTv = finder.castView(view, 2131558618, "field 'mSsTv'");
    view = finder.findRequiredView(source, 2131558619, "field 'mSjszRl' and method 'onViewClicked'");
    target.mSjszRl = finder.castView(view, 2131558619, "field 'mSjszRl'");
    unbinder.view2131558619 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked();
      }
    });
    return unbinder;
  }

  @Override
  protected InnerUnbinder<T> createUnbinder(T target) {
    return new InnerUnbinder(target);
  }

  protected static class InnerUnbinder<T extends TimeSetActivity> extends ToolbarActivity$$ViewBinder.InnerUnbinder<T> {
    View view2131558619;

    protected InnerUnbinder(T target) {
      super(target);
    }

    @Override
    protected void unbind(T target) {
      super.unbind(target);
      target.mYearTv = null;
      target.mMonthTv = null;
      target.mDdTv = null;
      target.mHhTv = null;
      target.mMmTv = null;
      target.mSsTv = null;
      view2131558619.setOnClickListener(null);
      target.mSjszRl = null;
    }
  }
}
