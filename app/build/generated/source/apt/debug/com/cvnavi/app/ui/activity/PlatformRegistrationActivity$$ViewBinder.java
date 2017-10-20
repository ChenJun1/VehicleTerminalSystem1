// Generated code from Butter Knife. Do not modify!
package com.cvnavi.app.ui.activity;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Finder;
import java.lang.Object;
import java.lang.Override;

public class PlatformRegistrationActivity$$ViewBinder<T extends PlatformRegistrationActivity> extends ToolbarActivity$$ViewBinder<T> {
  @Override
  public Unbinder bind(final Finder finder, final T target, Object source) {
    InnerUnbinder unbinder = (InnerUnbinder) super.bind(finder, target, source);
    View view;
    view = finder.findRequiredView(source, 2131558605, "field 'mConventionalTimeRb' and method 'onViewClicked'");
    target.mConventionalTimeRb = finder.castView(view, 2131558605, "field 'mConventionalTimeRb'");
    unbinder.view2131558605 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = finder.findRequiredView(source, 2131558606, "field 'mFastTimeRb' and method 'onViewClicked'");
    target.mFastTimeRb = finder.castView(view, 2131558606, "field 'mFastTimeRb'");
    unbinder.view2131558606 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = finder.findRequiredView(source, 2131558538, "field 'mRg'");
    target.mRg = finder.castView(view, 2131558538, "field 'mRg'");
    view = finder.findRequiredView(source, 2131558537, "field 'mViewpager'");
    target.mViewpager = finder.castView(view, 2131558537, "field 'mViewpager'");
    return unbinder;
  }

  @Override
  protected InnerUnbinder<T> createUnbinder(T target) {
    return new InnerUnbinder(target);
  }

  protected static class InnerUnbinder<T extends PlatformRegistrationActivity> extends ToolbarActivity$$ViewBinder.InnerUnbinder<T> {
    View view2131558605;

    View view2131558606;

    protected InnerUnbinder(T target) {
      super(target);
    }

    @Override
    protected void unbind(T target) {
      super.unbind(target);
      view2131558605.setOnClickListener(null);
      target.mConventionalTimeRb = null;
      view2131558606.setOnClickListener(null);
      target.mFastTimeRb = null;
      target.mRg = null;
      target.mViewpager = null;
    }
  }
}
