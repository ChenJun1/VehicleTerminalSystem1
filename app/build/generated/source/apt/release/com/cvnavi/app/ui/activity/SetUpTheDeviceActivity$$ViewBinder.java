// Generated code from Butter Knife. Do not modify!
package com.cvnavi.app.ui.activity;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Finder;
import java.lang.Object;
import java.lang.Override;

public class SetUpTheDeviceActivity$$ViewBinder<T extends SetUpTheDeviceActivity> extends ToolbarActivity$$ViewBinder<T> {
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
    view = finder.findRequiredView(source, 2131558600, "field 'coefficientView'");
    target.coefficientView = finder.castView(view, 2131558600, "field 'coefficientView'");
    view = finder.findRequiredView(source, 2131558601, "field 'alarmSpeedView'");
    target.alarmSpeedView = finder.castView(view, 2131558601, "field 'alarmSpeedView'");
    view = finder.findRequiredView(source, 2131558605, "field 'radioBootDormancyView' and method 'onViewClicked'");
    target.radioBootDormancyView = finder.castView(view, 2131558605, "field 'radioBootDormancyView'");
    unbinder.view2131558605 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = finder.findRequiredView(source, 2131558606, "field 'radioShutDownView' and method 'onViewClicked'");
    target.radioShutDownView = finder.castView(view, 2131558606, "field 'radioShutDownView'");
    unbinder.view2131558606 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = finder.findRequiredView(source, 2131558607, "field 'TTSvoiceView' and method 'onViewClicked'");
    target.TTSvoiceView = finder.castView(view, 2131558607, "field 'TTSvoiceView'");
    unbinder.view2131558607 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = finder.findRequiredView(source, 2131558608, "field 'radioBuzzerView' and method 'onViewClicked'");
    target.radioBuzzerView = finder.castView(view, 2131558608, "field 'radioBuzzerView'");
    unbinder.view2131558608 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = finder.findRequiredView(source, 2131558609, "field 'radioMixedPositioningView' and method 'onViewClicked'");
    target.radioMixedPositioningView = finder.castView(view, 2131558609, "field 'radioMixedPositioningView'");
    unbinder.view2131558609 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = finder.findRequiredView(source, 2131558610, "field 'radioGPSPositioningView' and method 'onViewClicked'");
    target.radioGPSPositioningView = finder.castView(view, 2131558610, "field 'radioGPSPositioningView'");
    unbinder.view2131558610 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = finder.findRequiredView(source, 2131558611, "field 'radioBeidouPositioningView' and method 'onViewClicked'");
    target.radioBeidouPositioningView = finder.castView(view, 2131558611, "field 'radioBeidouPositioningView'");
    unbinder.view2131558611 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    return unbinder;
  }

  @Override
  protected InnerUnbinder<T> createUnbinder(T target) {
    return new InnerUnbinder(target);
  }

  protected static class InnerUnbinder<T extends SetUpTheDeviceActivity> extends ToolbarActivity$$ViewBinder.InnerUnbinder<T> {
    View view2131558605;

    View view2131558606;

    View view2131558607;

    View view2131558608;

    View view2131558609;

    View view2131558610;

    View view2131558611;

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
      target.coefficientView = null;
      target.alarmSpeedView = null;
      view2131558605.setOnClickListener(null);
      target.radioBootDormancyView = null;
      view2131558606.setOnClickListener(null);
      target.radioShutDownView = null;
      view2131558607.setOnClickListener(null);
      target.TTSvoiceView = null;
      view2131558608.setOnClickListener(null);
      target.radioBuzzerView = null;
      view2131558609.setOnClickListener(null);
      target.radioMixedPositioningView = null;
      view2131558610.setOnClickListener(null);
      target.radioGPSPositioningView = null;
      view2131558611.setOnClickListener(null);
      target.radioBeidouPositioningView = null;
    }
  }
}
