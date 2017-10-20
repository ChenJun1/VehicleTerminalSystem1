// Generated code from Butter Knife. Do not modify!
package com.cvnavi.app.ui.activity;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class MainDialogActivity$$ViewBinder<T extends MainDialogActivity> implements ViewBinder<T> {
  @Override
  public Unbinder bind(final Finder finder, final T target, Object source) {
    InnerUnbinder unbinder = createUnbinder(target);
    View view;
    view = finder.findRequiredView(source, 2131558686, "field 'mCloseIv'");
    target.mCloseIv = finder.castView(view, 2131558686, "field 'mCloseIv'");
    view = finder.findRequiredView(source, 2131558688, "field 'mKongzaiRb' and method 'onClick'");
    target.mKongzaiRb = finder.castView(view, 2131558688, "field 'mKongzaiRb'");
    unbinder.view2131558688 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = finder.findRequiredView(source, 2131558689, "field 'mBanzaiRb' and method 'onClick'");
    target.mBanzaiRb = finder.castView(view, 2131558689, "field 'mBanzaiRb'");
    unbinder.view2131558689 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = finder.findRequiredView(source, 2131558690, "field 'mManzaiRb' and method 'onClick'");
    target.mManzaiRb = finder.castView(view, 2131558690, "field 'mManzaiRb'");
    unbinder.view2131558690 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = finder.findRequiredView(source, 2131558687, "field 'mZzztRg'");
    target.mZzztRg = finder.castView(view, 2131558687, "field 'mZzztRg'");
    view = finder.findRequiredView(source, 2131558685, "field 'mCloseLl' and method 'onClick'");
    target.mCloseLl = finder.castView(view, 2131558685, "field 'mCloseLl'");
    unbinder.view2131558685 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    return unbinder;
  }

  protected InnerUnbinder<T> createUnbinder(T target) {
    return new InnerUnbinder(target);
  }

  protected static class InnerUnbinder<T extends MainDialogActivity> implements Unbinder {
    private T target;

    View view2131558688;

    View view2131558689;

    View view2131558690;

    View view2131558685;

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
      target.mCloseIv = null;
      view2131558688.setOnClickListener(null);
      target.mKongzaiRb = null;
      view2131558689.setOnClickListener(null);
      target.mBanzaiRb = null;
      view2131558690.setOnClickListener(null);
      target.mManzaiRb = null;
      target.mZzztRg = null;
      view2131558685.setOnClickListener(null);
      target.mCloseLl = null;
    }
  }
}
