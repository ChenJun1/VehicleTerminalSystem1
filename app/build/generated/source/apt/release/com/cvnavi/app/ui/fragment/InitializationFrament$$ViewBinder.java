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
    view = finder.findRequiredView(source, 2131558698, "field 'mInitializationBt' and method 'onViewClicked'");
    target.mInitializationBt = finder.castView(view, 2131558698, "field 'mInitializationBt'");
    unbinder.view2131558698 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = finder.findRequiredView(source, 2131558699, "field 'mEmptied1Bt' and method 'onViewClicked'");
    target.mEmptied1Bt = finder.castView(view, 2131558699, "field 'mEmptied1Bt'");
    unbinder.view2131558699 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = finder.findRequiredView(source, 2131558700, "field 'mAlarmReleaseBt' and method 'onViewClicked'");
    target.mAlarmReleaseBt = finder.castView(view, 2131558700, "field 'mAlarmReleaseBt'");
    unbinder.view2131558700 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = finder.findRequiredView(source, 2131558701, "field 'mEmptied2Bt' and method 'onViewClicked'");
    target.mEmptied2Bt = finder.castView(view, 2131558701, "field 'mEmptied2Bt'");
    unbinder.view2131558701 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = finder.findRequiredView(source, 2131558702, "field 'mTerminalResetBt' and method 'onViewClicked'");
    target.mTerminalResetBt = finder.castView(view, 2131558702, "field 'mTerminalResetBt'");
    unbinder.view2131558702 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = finder.findRequiredView(source, 2131558703, "field 'mResetBt' and method 'onViewClicked'");
    target.mResetBt = finder.castView(view, 2131558703, "field 'mResetBt'");
    unbinder.view2131558703 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = finder.findRequiredView(source, 2131558704, "field 'mCenter1Tv' and method 'onViewClicked'");
    target.mCenter1Tv = finder.castView(view, 2131558704, "field 'mCenter1Tv'");
    unbinder.view2131558704 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = finder.findRequiredView(source, 2131558705, "field 'mCenter2Tv' and method 'onViewClicked'");
    target.mCenter2Tv = finder.castView(view, 2131558705, "field 'mCenter2Tv'");
    unbinder.view2131558705 = view;
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

    View view2131558698;

    View view2131558699;

    View view2131558700;

    View view2131558701;

    View view2131558702;

    View view2131558703;

    View view2131558704;

    View view2131558705;

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
      view2131558698.setOnClickListener(null);
      target.mInitializationBt = null;
      view2131558699.setOnClickListener(null);
      target.mEmptied1Bt = null;
      view2131558700.setOnClickListener(null);
      target.mAlarmReleaseBt = null;
      view2131558701.setOnClickListener(null);
      target.mEmptied2Bt = null;
      view2131558702.setOnClickListener(null);
      target.mTerminalResetBt = null;
      view2131558703.setOnClickListener(null);
      target.mResetBt = null;
      view2131558704.setOnClickListener(null);
      target.mCenter1Tv = null;
      view2131558705.setOnClickListener(null);
      target.mCenter2Tv = null;
    }
  }
}
