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
    view = finder.findRequiredView(source, 2131558738, "field 'travelRecord' and method 'onViewClicked'");
    target.travelRecord = finder.castView(view, 2131558738, "field 'travelRecord'");
    unbinder.view2131558738 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = finder.findRequiredView(source, 2131558739, "field 'VehicleParameters' and method 'onViewClicked'");
    target.VehicleParameters = finder.castView(view, 2131558739, "field 'VehicleParameters'");
    unbinder.view2131558739 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = finder.findRequiredView(source, 2131558740, "field 'EquipmentDetection' and method 'onViewClicked'");
    target.EquipmentDetection = finder.castView(view, 2131558740, "field 'EquipmentDetection'");
    unbinder.view2131558740 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = finder.findRequiredView(source, 2131558741, "field 'EquipmentManagement' and method 'onViewClicked'");
    target.EquipmentManagement = finder.castView(view, 2131558741, "field 'EquipmentManagement'");
    unbinder.view2131558741 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = finder.findRequiredView(source, 2131558742, "field 'RealTimeInformation' and method 'onViewClicked'");
    target.RealTimeInformation = finder.castView(view, 2131558742, "field 'RealTimeInformation'");
    unbinder.view2131558742 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = finder.findRequiredView(source, 2131558743, "field 'Error_Alarm' and method 'onViewClicked'");
    target.Error_Alarm = finder.castView(view, 2131558743, "field 'Error_Alarm'");
    unbinder.view2131558743 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = finder.findRequiredView(source, 2131558744, "field 'VehicleInformation' and method 'onViewClicked'");
    target.VehicleInformation = finder.castView(view, 2131558744, "field 'VehicleInformation'");
    unbinder.view2131558744 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = finder.findRequiredView(source, 2131558745, "field 'AbdDrivingRecord' and method 'onViewClicked'");
    target.AbdDrivingRecord = finder.castView(view, 2131558745, "field 'AbdDrivingRecord'");
    unbinder.view2131558745 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = finder.findRequiredView(source, 2131558746, "field 'Maintenance' and method 'onViewClicked'");
    target.Maintenance = finder.castView(view, 2131558746, "field 'Maintenance'");
    unbinder.view2131558746 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = finder.findRequiredView(source, 2131558747, "field 'DeviceInformationTv' and method 'onViewClicked'");
    target.DeviceInformationTv = finder.castView(view, 2131558747, "field 'DeviceInformationTv'");
    unbinder.view2131558747 = view;
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

    View view2131558738;

    View view2131558739;

    View view2131558740;

    View view2131558741;

    View view2131558742;

    View view2131558743;

    View view2131558744;

    View view2131558745;

    View view2131558746;

    View view2131558747;

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
      view2131558738.setOnClickListener(null);
      target.travelRecord = null;
      view2131558739.setOnClickListener(null);
      target.VehicleParameters = null;
      view2131558740.setOnClickListener(null);
      target.EquipmentDetection = null;
      view2131558741.setOnClickListener(null);
      target.EquipmentManagement = null;
      view2131558742.setOnClickListener(null);
      target.RealTimeInformation = null;
      view2131558743.setOnClickListener(null);
      target.Error_Alarm = null;
      view2131558744.setOnClickListener(null);
      target.VehicleInformation = null;
      view2131558745.setOnClickListener(null);
      target.AbdDrivingRecord = null;
      view2131558746.setOnClickListener(null);
      target.Maintenance = null;
      view2131558747.setOnClickListener(null);
      target.DeviceInformationTv = null;
    }
  }
}
