// Generated code from Butter Knife. Do not modify!
package com.cvnavi.app.ui.activity;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import java.lang.Object;
import java.lang.Override;

public class Device_InformationActivity$$ViewBinder<T extends Device_InformationActivity> extends ToolbarActivity$$ViewBinder<T> {
  @Override
  public Unbinder bind(final Finder finder, final T target, Object source) {
    InnerUnbinder unbinder = (InnerUnbinder) super.bind(finder, target, source);
    View view;
    view = finder.findRequiredView(source, 2131558579, "field 'firmwareVersionView'");
    target.firmwareVersionView = finder.castView(view, 2131558579, "field 'firmwareVersionView'");
    view = finder.findRequiredView(source, 2131558580, "field 'hardwareVersionView'");
    target.hardwareVersionView = finder.castView(view, 2131558580, "field 'hardwareVersionView'");
    view = finder.findRequiredView(source, 2131558581, "field 'communicationModuleTypeView'");
    target.communicationModuleTypeView = finder.castView(view, 2131558581, "field 'communicationModuleTypeView'");
    view = finder.findRequiredView(source, 2131558582, "field 'communicationModuleVersionView'");
    target.communicationModuleVersionView = finder.castView(view, 2131558582, "field 'communicationModuleVersionView'");
    view = finder.findRequiredView(source, 2131558583, "field 'positioningModuleTypeView'");
    target.positioningModuleTypeView = finder.castView(view, 2131558583, "field 'positioningModuleTypeView'");
    view = finder.findRequiredView(source, 2131558584, "field 'positioningModuleVersionView'");
    target.positioningModuleVersionView = finder.castView(view, 2131558584, "field 'positioningModuleVersionView'");
    view = finder.findRequiredView(source, 2131558585, "field 'serialNumberView'");
    target.serialNumberView = finder.castView(view, 2131558585, "field 'serialNumberView'");
    view = finder.findRequiredView(source, 2131558586, "field 'productNumberView'");
    target.productNumberView = finder.castView(view, 2131558586, "field 'productNumberView'");
    view = finder.findRequiredView(source, 2131558587, "field 'timeView'");
    target.timeView = finder.castView(view, 2131558587, "field 'timeView'");
    view = finder.findRequiredView(source, 2131558588, "field 'authenticationCodeView'");
    target.authenticationCodeView = finder.castView(view, 2131558588, "field 'authenticationCodeView'");
    return unbinder;
  }

  @Override
  protected InnerUnbinder<T> createUnbinder(T target) {
    return new InnerUnbinder(target);
  }

  protected static class InnerUnbinder<T extends Device_InformationActivity> extends ToolbarActivity$$ViewBinder.InnerUnbinder<T> {
    protected InnerUnbinder(T target) {
      super(target);
    }

    @Override
    protected void unbind(T target) {
      super.unbind(target);
      target.firmwareVersionView = null;
      target.hardwareVersionView = null;
      target.communicationModuleTypeView = null;
      target.communicationModuleVersionView = null;
      target.positioningModuleTypeView = null;
      target.positioningModuleVersionView = null;
      target.serialNumberView = null;
      target.productNumberView = null;
      target.timeView = null;
      target.authenticationCodeView = null;
    }
  }
}
