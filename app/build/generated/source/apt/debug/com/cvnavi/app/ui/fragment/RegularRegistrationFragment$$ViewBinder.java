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

public class RegularRegistrationFragment$$ViewBinder<T extends RegularRegistrationFragment> implements ViewBinder<T> {
  @Override
  public Unbinder bind(final Finder finder, final T target, Object source) {
    InnerUnbinder unbinder = createUnbinder(target);
    View view;
    view = finder.findRequiredView(source, 2131558765, "field 'terminalModel' and method 'onViewClicked'");
    target.terminalModel = finder.castView(view, 2131558765, "field 'terminalModel'");
    unbinder.view2131558765 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked();
      }
    });
    view = finder.findRequiredView(source, 2131558766, "field 'manufacturerId'");
    target.manufacturerId = finder.castView(view, 2131558766, "field 'manufacturerId'");
    view = finder.findRequiredView(source, 2131558767, "field 'terminalId'");
    target.terminalId = finder.castView(view, 2131558767, "field 'terminalId'");
    view = finder.findRequiredView(source, 2131558768, "field 'vehicleNo'");
    target.vehicleNo = finder.castView(view, 2131558768, "field 'vehicleNo'");
    view = finder.findRequiredView(source, 2131558769, "field 'vehicleColor'");
    target.vehicleColor = finder.castView(view, 2131558769, "field 'vehicleColor'");
    view = finder.findRequiredView(source, 2131558770, "field 'firstIp'");
    target.firstIp = finder.castView(view, 2131558770, "field 'firstIp'");
    view = finder.findRequiredView(source, 2131558771, "field 'firstPort'");
    target.firstPort = finder.castView(view, 2131558771, "field 'firstPort'");
    view = finder.findRequiredView(source, 2131558772, "field 'firstAgreement'");
    target.firstAgreement = finder.castView(view, 2131558772, "field 'firstAgreement'");
    view = finder.findRequiredView(source, 2131558775, "field 'vin'");
    target.vin = finder.castView(view, 2131558775, "field 'vin'");
    view = finder.findRequiredView(source, 2131558776, "field 'provinceId'");
    target.provinceId = finder.castView(view, 2131558776, "field 'provinceId'");
    view = finder.findRequiredView(source, 2131558777, "field 'cityId'");
    target.cityId = finder.castView(view, 2131558777, "field 'cityId'");
    view = finder.findRequiredView(source, 2131558778, "field 'terminalPhone'");
    target.terminalPhone = finder.castView(view, 2131558778, "field 'terminalPhone'");
    view = finder.findRequiredView(source, 2131558779, "field 'apn'");
    target.apn = finder.castView(view, 2131558779, "field 'apn'");
    view = finder.findRequiredView(source, 2131558780, "field 'secondIp'");
    target.secondIp = finder.castView(view, 2131558780, "field 'secondIp'");
    view = finder.findRequiredView(source, 2131558781, "field 'secondPort'");
    target.secondPort = finder.castView(view, 2131558781, "field 'secondPort'");
    view = finder.findRequiredView(source, 2131558782, "field 'secondAgreement'");
    target.secondAgreement = finder.castView(view, 2131558782, "field 'secondAgreement'");
    view = finder.findRequiredView(source, 2131558773, "field 'firstState'");
    target.firstState = finder.castView(view, 2131558773, "field 'firstState'");
    view = finder.findRequiredView(source, 2131558783, "field 'secondState'");
    target.secondState = finder.castView(view, 2131558783, "field 'secondState'");
    view = finder.findRequiredView(source, 2131558774, "field 'qidong' and method 'onViewClicked'");
    target.qidong = finder.castView(view, 2131558774, "field 'qidong'");
    unbinder.view2131558774 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked();
      }
    });
    return unbinder;
  }

  protected InnerUnbinder<T> createUnbinder(T target) {
    return new InnerUnbinder(target);
  }

  protected static class InnerUnbinder<T extends RegularRegistrationFragment> implements Unbinder {
    private T target;

    View view2131558765;

    View view2131558774;

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
      view2131558765.setOnClickListener(null);
      target.terminalModel = null;
      target.manufacturerId = null;
      target.terminalId = null;
      target.vehicleNo = null;
      target.vehicleColor = null;
      target.firstIp = null;
      target.firstPort = null;
      target.firstAgreement = null;
      target.vin = null;
      target.provinceId = null;
      target.cityId = null;
      target.terminalPhone = null;
      target.apn = null;
      target.secondIp = null;
      target.secondPort = null;
      target.secondAgreement = null;
      target.firstState = null;
      target.secondState = null;
      view2131558774.setOnClickListener(null);
      target.qidong = null;
    }
  }
}
