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

public class MoreFragment$$ViewBinder<T extends MoreFragment> implements ViewBinder<T> {
  @Override
  public Unbinder bind(final Finder finder, final T target, Object source) {
    InnerUnbinder unbinder = createUnbinder(target);
    View view;
    view = finder.findRequiredView(source, 2131558706, "field 'travelRecord' and method 'onViewClicked'");
    target.travelRecord = finder.castView(view, 2131558706, "field 'travelRecord'");
    unbinder.view2131558706 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = finder.findRequiredView(source, 2131558707, "field 'VehicleParameters' and method 'onViewClicked'");
    target.VehicleParameters = finder.castView(view, 2131558707, "field 'VehicleParameters'");
    unbinder.view2131558707 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = finder.findRequiredView(source, 2131558708, "field 'EquipmentDetection' and method 'onViewClicked'");
    target.EquipmentDetection = finder.castView(view, 2131558708, "field 'EquipmentDetection'");
    unbinder.view2131558708 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = finder.findRequiredView(source, 2131558709, "field 'EquipmentManagement' and method 'onViewClicked'");
    target.EquipmentManagement = finder.castView(view, 2131558709, "field 'EquipmentManagement'");
    unbinder.view2131558709 = view;
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

  protected static class InnerUnbinder<T extends MoreFragment> implements Unbinder {
    private T target;

    View view2131558706;

    View view2131558707;

    View view2131558708;

    View view2131558709;

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
      view2131558706.setOnClickListener(null);
      target.travelRecord = null;
      view2131558707.setOnClickListener(null);
      target.VehicleParameters = null;
      view2131558708.setOnClickListener(null);
      target.EquipmentDetection = null;
      view2131558709.setOnClickListener(null);
      target.EquipmentManagement = null;
    }
  }
}
