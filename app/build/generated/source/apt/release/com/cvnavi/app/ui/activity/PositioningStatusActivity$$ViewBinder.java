// Generated code from Butter Knife. Do not modify!
package com.cvnavi.app.ui.activity;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import java.lang.Object;
import java.lang.Override;

public class PositioningStatusActivity$$ViewBinder<T extends PositioningStatusActivity> extends ToolbarActivity$$ViewBinder<T> {
  @Override
  public Unbinder bind(final Finder finder, final T target, Object source) {
    InnerUnbinder unbinder = (InnerUnbinder) super.bind(finder, target, source);
    View view;
    view = finder.findRequiredView(source, 2131558593, "field 'numberPlateView'");
    target.numberPlateView = finder.castView(view, 2131558593, "field 'numberPlateView'");
    view = finder.findRequiredView(source, 2131558594, "field 'carParameterView'");
    target.carParameterView = finder.castView(view, 2131558594, "field 'carParameterView'");
    view = finder.findRequiredView(source, 2131558595, "field 'sleepModeView'");
    target.sleepModeView = finder.castView(view, 2131558595, "field 'sleepModeView'");
    view = finder.findRequiredView(source, 2131558596, "field 'drivingTimeLimitView'");
    target.drivingTimeLimitView = finder.castView(view, 2131558596, "field 'drivingTimeLimitView'");
    view = finder.findRequiredView(source, 2131558597, "field 'breakTimeView'");
    target.breakTimeView = finder.castView(view, 2131558597, "field 'breakTimeView'");
    view = finder.findRequiredView(source, 2131558598, "field 'ICAuthority'");
    target.ICAuthority = finder.castView(view, 2131558598, "field 'ICAuthority'");
    view = finder.findRequiredView(source, 2131558599, "field 'carVINNumber'");
    target.carVINNumber = finder.castView(view, 2131558599, "field 'carVINNumber'");
    view = finder.findRequiredView(source, 2131558600, "field 'coefficientView'");
    target.coefficientView = finder.castView(view, 2131558600, "field 'coefficientView'");
    view = finder.findRequiredView(source, 2131558601, "field 'alarmSpeedView'");
    target.alarmSpeedView = finder.castView(view, 2131558601, "field 'alarmSpeedView'");
    view = finder.findRequiredView(source, 2131558602, "field 'timeoutDrivingTimeView'");
    target.timeoutDrivingTimeView = finder.castView(view, 2131558602, "field 'timeoutDrivingTimeView'");
    view = finder.findRequiredView(source, 2131558603, "field 'warningDifferenceView'");
    target.warningDifferenceView = finder.castView(view, 2131558603, "field 'warningDifferenceView'");
    view = finder.findRequiredView(source, 2131558604, "field 'modeIndicationView'");
    target.modeIndicationView = finder.castView(view, 2131558604, "field 'modeIndicationView'");
    return unbinder;
  }

  @Override
  protected InnerUnbinder<T> createUnbinder(T target) {
    return new InnerUnbinder(target);
  }

  protected static class InnerUnbinder<T extends PositioningStatusActivity> extends ToolbarActivity$$ViewBinder.InnerUnbinder<T> {
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
      target.carVINNumber = null;
      target.coefficientView = null;
      target.alarmSpeedView = null;
      target.timeoutDrivingTimeView = null;
      target.warningDifferenceView = null;
      target.modeIndicationView = null;
    }
  }
}
