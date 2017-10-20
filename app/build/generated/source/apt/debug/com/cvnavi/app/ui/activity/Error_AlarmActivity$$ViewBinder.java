// Generated code from Butter Knife. Do not modify!
package com.cvnavi.app.ui.activity;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import java.lang.Object;
import java.lang.Override;

public class Error_AlarmActivity$$ViewBinder<T extends Error_AlarmActivity> extends ToolbarActivity$$ViewBinder<T> {
  @Override
  public Unbinder bind(final Finder finder, final T target, Object source) {
    InnerUnbinder unbinder = (InnerUnbinder) super.bind(finder, target, source);
    View view;
    view = finder.findRequiredView(source, 2131558593, "field 'SeriousFailureView'");
    target.SeriousFailureView = finder.castView(view, 2131558593, "field 'SeriousFailureView'");
    view = finder.findRequiredView(source, 2131558594, "field 'BrakeAirPressureAlarmView'");
    target.BrakeAirPressureAlarmView = finder.castView(view, 2131558594, "field 'BrakeAirPressureAlarmView'");
    view = finder.findRequiredView(source, 2131558595, "field 'HydraulicAlarmView'");
    target.HydraulicAlarmView = finder.castView(view, 2131558595, "field 'HydraulicAlarmView'");
    view = finder.findRequiredView(source, 2131558596, "field 'LowWaterLevelAlarmView'");
    target.LowWaterLevelAlarmView = finder.castView(view, 2131558596, "field 'LowWaterLevelAlarmView'");
    view = finder.findRequiredView(source, 2131558597, "field 'BrakeShoeWarningView'");
    target.BrakeShoeWarningView = finder.castView(view, 2131558597, "field 'BrakeShoeWarningView'");
    view = finder.findRequiredView(source, 2131558598, "field 'AirFilterBlockAlarmView'");
    target.AirFilterBlockAlarmView = finder.castView(view, 2131558598, "field 'AirFilterBlockAlarmView'");
    view = finder.findRequiredView(source, 2131558599, "field 'FuelAlarmView'");
    target.FuelAlarmView = finder.castView(view, 2131558599, "field 'FuelAlarmView'");
    view = finder.findRequiredView(source, 2131558600, "field 'RetarderHighTemperatureAlarmView'");
    target.RetarderHighTemperatureAlarmView = finder.castView(view, 2131558600, "field 'RetarderHighTemperatureAlarmView'");
    view = finder.findRequiredView(source, 2131558601, "field 'WarehouseTemperatureAlarmView'");
    target.WarehouseTemperatureAlarmView = finder.castView(view, 2131558601, "field 'WarehouseTemperatureAlarmView'");
    view = finder.findRequiredView(source, 2131558602, "field 'OilTemperatureAlarmView'");
    target.OilTemperatureAlarmView = finder.castView(view, 2131558602, "field 'OilTemperatureAlarmView'");
    return unbinder;
  }

  @Override
  protected InnerUnbinder<T> createUnbinder(T target) {
    return new InnerUnbinder(target);
  }

  protected static class InnerUnbinder<T extends Error_AlarmActivity> extends ToolbarActivity$$ViewBinder.InnerUnbinder<T> {
    protected InnerUnbinder(T target) {
      super(target);
    }

    @Override
    protected void unbind(T target) {
      super.unbind(target);
      target.SeriousFailureView = null;
      target.BrakeAirPressureAlarmView = null;
      target.HydraulicAlarmView = null;
      target.LowWaterLevelAlarmView = null;
      target.BrakeShoeWarningView = null;
      target.AirFilterBlockAlarmView = null;
      target.FuelAlarmView = null;
      target.RetarderHighTemperatureAlarmView = null;
      target.WarehouseTemperatureAlarmView = null;
      target.OilTemperatureAlarmView = null;
    }
  }
}
