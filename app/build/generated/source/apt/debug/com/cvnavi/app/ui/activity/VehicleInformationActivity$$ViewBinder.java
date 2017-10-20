// Generated code from Butter Knife. Do not modify!
package com.cvnavi.app.ui.activity;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import java.lang.Object;
import java.lang.Override;

public class VehicleInformationActivity$$ViewBinder<T extends VehicleInformationActivity> extends ToolbarActivity$$ViewBinder<T> {
  @Override
  public Unbinder bind(final Finder finder, final T target, Object source) {
    InnerUnbinder unbinder = (InnerUnbinder) super.bind(finder, target, source);
    View view;
    view = finder.findRequiredView(source, 2131558607, "field 'numberPlateView'");
    target.numberPlateView = finder.castView(view, 2131558607, "field 'numberPlateView'");
    view = finder.findRequiredView(source, 2131558608, "field 'carParameterView'");
    target.carParameterView = finder.castView(view, 2131558608, "field 'carParameterView'");
    view = finder.findRequiredView(source, 2131558609, "field 'sleepModeView'");
    target.sleepModeView = finder.castView(view, 2131558609, "field 'sleepModeView'");
    view = finder.findRequiredView(source, 2131558610, "field 'drivingTimeLimitView'");
    target.drivingTimeLimitView = finder.castView(view, 2131558610, "field 'drivingTimeLimitView'");
    view = finder.findRequiredView(source, 2131558611, "field 'breakTimeView'");
    target.breakTimeView = finder.castView(view, 2131558611, "field 'breakTimeView'");
    view = finder.findRequiredView(source, 2131558612, "field 'ICAuthority'");
    target.ICAuthority = finder.castView(view, 2131558612, "field 'ICAuthority'");
    return unbinder;
  }

  @Override
  protected InnerUnbinder<T> createUnbinder(T target) {
    return new InnerUnbinder(target);
  }

  protected static class InnerUnbinder<T extends VehicleInformationActivity> extends ToolbarActivity$$ViewBinder.InnerUnbinder<T> {
    protected InnerUnbinder(T target) {
      super(target);
    }

    @Override
    protected void unbind(T target) {
      super.unbind(target);
      target.numberPlateView = null;
      target.carParameterView = null;
      target.sleepModeView = null;
      target.drivingTimeLimitView = null;
      target.breakTimeView = null;
      target.ICAuthority = null;
    }
  }
}
