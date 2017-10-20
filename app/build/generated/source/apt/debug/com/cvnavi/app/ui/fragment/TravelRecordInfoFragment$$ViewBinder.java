// Generated code from Butter Knife. Do not modify!
package com.cvnavi.app.ui.fragment;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class TravelRecordInfoFragment$$ViewBinder<T extends TravelRecordInfoFragment> implements ViewBinder<T> {
  @Override
  public Unbinder bind(final Finder finder, final T target, Object source) {
    InnerUnbinder unbinder = createUnbinder(target);
    View view;
    view = finder.findRequiredView(source, 2131558921, "field 'drivingTimeView'");
    target.drivingTimeView = finder.castView(view, 2131558921, "field 'drivingTimeView'");
    view = finder.findRequiredView(source, 2131558922, "field 'startTimeView'");
    target.startTimeView = finder.castView(view, 2131558922, "field 'startTimeView'");
    view = finder.findRequiredView(source, 2131558923, "field 'starLongitudeView'");
    target.starLongitudeView = finder.castView(view, 2131558923, "field 'starLongitudeView'");
    view = finder.findRequiredView(source, 2131558924, "field 'starLatitudeView'");
    target.starLatitudeView = finder.castView(view, 2131558924, "field 'starLatitudeView'");
    view = finder.findRequiredView(source, 2131558925, "field 'starAltitudeView'");
    target.starAltitudeView = finder.castView(view, 2131558925, "field 'starAltitudeView'");
    view = finder.findRequiredView(source, 2131558926, "field 'driversLicenseNumberView'");
    target.driversLicenseNumberView = finder.castView(view, 2131558926, "field 'driversLicenseNumberView'");
    view = finder.findRequiredView(source, 2131558927, "field 'endTimeView'");
    target.endTimeView = finder.castView(view, 2131558927, "field 'endTimeView'");
    view = finder.findRequiredView(source, 2131558928, "field 'longitudeView'");
    target.longitudeView = finder.castView(view, 2131558928, "field 'longitudeView'");
    view = finder.findRequiredView(source, 2131558929, "field 'latitudeView'");
    target.latitudeView = finder.castView(view, 2131558929, "field 'latitudeView'");
    view = finder.findRequiredView(source, 2131558930, "field 'altitudeView'");
    target.altitudeView = finder.castView(view, 2131558930, "field 'altitudeView'");
    return unbinder;
  }

  protected InnerUnbinder<T> createUnbinder(T target) {
    return new InnerUnbinder(target);
  }

  protected static class InnerUnbinder<T extends TravelRecordInfoFragment> implements Unbinder {
    private T target;

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
      target.drivingTimeView = null;
      target.startTimeView = null;
      target.starLongitudeView = null;
      target.starLatitudeView = null;
      target.starAltitudeView = null;
      target.driversLicenseNumberView = null;
      target.endTimeView = null;
      target.longitudeView = null;
      target.latitudeView = null;
      target.altitudeView = null;
    }
  }
}
