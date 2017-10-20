// Generated code from Butter Knife. Do not modify!
package com.cvnavi.app.ui.activity;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Finder;
import java.lang.Object;
import java.lang.Override;

public class DrivingScoreActivity$$ViewBinder<T extends DrivingScoreActivity> extends ToolbarActivity$$ViewBinder<T> {
  @Override
  public Unbinder bind(final Finder finder, final T target, Object source) {
    InnerUnbinder unbinder = (InnerUnbinder) super.bind(finder, target, source);
    View view;
    view = finder.findRequiredView(source, 2131558537, "field 'mViewpager'");
    target.mViewpager = finder.castView(view, 2131558537, "field 'mViewpager'");
    view = finder.findRequiredView(source, 2131558539, "field 'mRealTimeRb' and method 'onViewClicked'");
    target.mRealTimeRb = finder.castView(view, 2131558539, "field 'mRealTimeRb'");
    unbinder.view2131558539 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = finder.findRequiredView(source, 2131558540, "field 'mInquireRb' and method 'onViewClicked'");
    target.mInquireRb = finder.castView(view, 2131558540, "field 'mInquireRb'");
    unbinder.view2131558540 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = finder.findRequiredView(source, 2131558538, "field 'mRg'");
    target.mRg = finder.castView(view, 2131558538, "field 'mRg'");
    return unbinder;
  }

  @Override
  protected InnerUnbinder<T> createUnbinder(T target) {
    return new InnerUnbinder(target);
  }

  protected static class InnerUnbinder<T extends DrivingScoreActivity> extends ToolbarActivity$$ViewBinder.InnerUnbinder<T> {
    View view2131558539;

    View view2131558540;

    protected InnerUnbinder(T target) {
      super(target);
    }

    @Override
    protected void unbind(T target) {
      super.unbind(target);
      target.mViewpager = null;
      view2131558539.setOnClickListener(null);
      target.mRealTimeRb = null;
      view2131558540.setOnClickListener(null);
      target.mInquireRb = null;
      target.mRg = null;
    }
  }
}
