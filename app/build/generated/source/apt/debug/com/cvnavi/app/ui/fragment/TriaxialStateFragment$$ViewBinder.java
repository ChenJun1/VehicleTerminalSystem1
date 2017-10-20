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

public class TriaxialStateFragment$$ViewBinder<T extends TriaxialStateFragment> implements ViewBinder<T> {
  @Override
  public Unbinder bind(final Finder finder, final T target, Object source) {
    InnerUnbinder unbinder = createUnbinder(target);
    View view;
    view = finder.findRequiredView(source, 2131558969, "field 'angleXView'");
    target.angleXView = finder.castView(view, 2131558969, "field 'angleXView'");
    view = finder.findRequiredView(source, 2131558970, "field 'angleYViwe'");
    target.angleYViwe = finder.castView(view, 2131558970, "field 'angleYViwe'");
    view = finder.findRequiredView(source, 2131558971, "field 'angleZView'");
    target.angleZView = finder.castView(view, 2131558971, "field 'angleZView'");
    view = finder.findRequiredView(source, 2131558972, "field 'accelerationXView'");
    target.accelerationXView = finder.castView(view, 2131558972, "field 'accelerationXView'");
    view = finder.findRequiredView(source, 2131558973, "field 'accelerationYView'");
    target.accelerationYView = finder.castView(view, 2131558973, "field 'accelerationYView'");
    view = finder.findRequiredView(source, 2131558974, "field 'accelerationZView'");
    target.accelerationZView = finder.castView(view, 2131558974, "field 'accelerationZView'");
    view = finder.findRequiredView(source, 2131558975, "field 'deviceStatusView'");
    target.deviceStatusView = finder.castView(view, 2131558975, "field 'deviceStatusView'");
    view = finder.findRequiredView(source, 2131558976, "field 'openView' and method 'onViewClicked'");
    target.openView = finder.castView(view, 2131558976, "field 'openView'");
    unbinder.view2131558976 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = finder.findRequiredView(source, 2131558977, "field 'shutDownView' and method 'onViewClicked'");
    target.shutDownView = finder.castView(view, 2131558977, "field 'shutDownView'");
    unbinder.view2131558977 = view;
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

  protected static class InnerUnbinder<T extends TriaxialStateFragment> implements Unbinder {
    private T target;

    View view2131558976;

    View view2131558977;

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
      target.angleXView = null;
      target.angleYViwe = null;
      target.angleZView = null;
      target.accelerationXView = null;
      target.accelerationYView = null;
      target.accelerationZView = null;
      target.deviceStatusView = null;
      view2131558976.setOnClickListener(null);
      target.openView = null;
      view2131558977.setOnClickListener(null);
      target.shutDownView = null;
    }
  }
}
