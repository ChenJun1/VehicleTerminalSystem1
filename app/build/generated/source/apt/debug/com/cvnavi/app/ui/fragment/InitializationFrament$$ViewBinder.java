// Generated code from Butter Knife. Do not modify!
package com.cvnavi.app.ui.fragment;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class InitializationFrament$$ViewBinder<T extends InitializationFrament> implements ViewBinder<T> {
  @Override
  public Unbinder bind(final Finder finder, final T target, Object source) {
    InnerUnbinder unbinder = createUnbinder(target);
    View view;
    view = finder.findRequiredView(source, 2131558730, "field 'mInitializationBt' and method 'onViewClicked'");
    target.mInitializationBt = finder.castView(view, 2131558730, "field 'mInitializationBt'");
    unbinder.view2131558730 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = finder.findRequiredView(source, 2131558731, "field 'mEmptied1Bt' and method 'onViewClicked'");
    target.mEmptied1Bt = finder.castView(view, 2131558731, "field 'mEmptied1Bt'");
    unbinder.view2131558731 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = finder.findRequiredView(source, 2131558732, "field 'mAlarmReleaseBt' and method 'onViewClicked'");
    target.mAlarmReleaseBt = finder.castView(view, 2131558732, "field 'mAlarmReleaseBt'");
    unbinder.view2131558732 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = finder.findRequiredView(source, 2131558733, "field 'mEmptied2Bt' and method 'onViewClicked'");
    target.mEmptied2Bt = finder.castView(view, 2131558733, "field 'mEmptied2Bt'");
    unbinder.view2131558733 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = finder.findRequiredView(source, 2131558734, "field 'mTerminalResetBt' and method 'onViewClicked'");
    target.mTerminalResetBt = finder.castView(view, 2131558734, "field 'mTerminalResetBt'");
    unbinder.view2131558734 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = finder.findRequiredView(source, 2131558735, "field 'mResetBt' and method 'onViewClicked'");
    target.mResetBt = finder.castView(view, 2131558735, "field 'mResetBt'");
    unbinder.view2131558735 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = finder.findRequiredView(source, 2131558736, "field 'mCenter1Tv' and method 'onViewClicked'");
    target.mCenter1Tv = finder.castView(view, 2131558736, "field 'mCenter1Tv'");
    unbinder.view2131558736 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = finder.findRequiredView(source, 2131558737, "field 'mCenter2Tv' and method 'onViewClicked'");
    target.mCenter2Tv = finder.castView(view, 2131558737, "field 'mCenter2Tv'");
    unbinder.view2131558737 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    return unbinder;
  }

  protected InnerUnbinder<T> createUnbinder(T target) {
    return new InnerUnbinder(target);
  }

  protected static class InnerUnbinder<T extends InitializationFrament> implements Unbinder {
    private T target;

    View view2131558730;

    View view2131558731;

    View view2131558732;

    View view2131558733;

    View view2131558734;

    View view2131558735;

    View view2131558736;

    View view2131558737;

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
      view2131558730.setOnClickListener(null);
      target.mInitializationBt = null;
      view2131558731.setOnClickListener(null);
      target.mEmptied1Bt = null;
      view2131558732.setOnClickListener(null);
      target.mAlarmReleaseBt = null;
      view2131558733.setOnClickListener(null);
      target.mEmptied2Bt = null;
      view2131558734.setOnClickListener(null);
      target.mTerminalResetBt = null;
      view2131558735.setOnClickListener(null);
      target.mResetBt = null;
      view2131558736.setOnClickListener(null);
      target.mCenter1Tv = null;
      view2131558737.setOnClickListener(null);
      target.mCenter2Tv = null;
    }
  }
}
