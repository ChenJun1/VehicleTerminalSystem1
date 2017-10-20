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

public class QuickRegistrationFragment$$ViewBinder<T extends QuickRegistrationFragment> implements ViewBinder<T> {
  @Override
  public Unbinder bind(final Finder finder, final T target, Object source) {
    InnerUnbinder unbinder = createUnbinder(target);
    View view;
    view = finder.findRequiredView(source, 2131558748, "field 'mTerminalModelTv'");
    target.mTerminalModelTv = finder.castView(view, 2131558748, "field 'mTerminalModelTv'");
    view = finder.findRequiredView(source, 2131558749, "field 'mProvinceIdTv'");
    target.mProvinceIdTv = finder.castView(view, 2131558749, "field 'mProvinceIdTv'");
    view = finder.findRequiredView(source, 2131558750, "field 'mManufacturerIdTv'");
    target.mManufacturerIdTv = finder.castView(view, 2131558750, "field 'mManufacturerIdTv'");
    view = finder.findRequiredView(source, 2131558751, "field 'mCityIdTv'");
    target.mCityIdTv = finder.castView(view, 2131558751, "field 'mCityIdTv'");
    view = finder.findRequiredView(source, 2131558752, "field 'mTerminalIdTv'");
    target.mTerminalIdTv = finder.castView(view, 2131558752, "field 'mTerminalIdTv'");
    view = finder.findRequiredView(source, 2131558753, "field 'mTerminalPhoneTv'");
    target.mTerminalPhoneTv = finder.castView(view, 2131558753, "field 'mTerminalPhoneTv'");
    view = finder.findRequiredView(source, 2131558754, "field 'mVehicleNoTv'");
    target.mVehicleNoTv = finder.castView(view, 2131558754, "field 'mVehicleNoTv'");
    view = finder.findRequiredView(source, 2131558755, "field 'mOwnerPhoneTv'");
    target.mOwnerPhoneTv = finder.castView(view, 2131558755, "field 'mOwnerPhoneTv'");
    view = finder.findRequiredView(source, 2131558756, "field 'mVehicleColorTv'");
    target.mVehicleColorTv = finder.castView(view, 2131558756, "field 'mVehicleColorTv'");
    view = finder.findRequiredView(source, 2131558757, "field 'mOwnerName'");
    target.mOwnerName = finder.castView(view, 2131558757, "field 'mOwnerName'");
    view = finder.findRequiredView(source, 2131558758, "field 'mVinTv'");
    target.mVinTv = finder.castView(view, 2131558758, "field 'mVinTv'");
    view = finder.findRequiredView(source, 2131558759, "field 'mRegistrationTv' and method 'onViewClicked'");
    target.mRegistrationTv = finder.castView(view, 2131558759, "field 'mRegistrationTv'");
    unbinder.view2131558759 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked();
      }
    });
    view = finder.findRequiredView(source, 2131558760, "field 'mContentTv'");
    target.mContentTv = finder.castView(view, 2131558760, "field 'mContentTv'");
    return unbinder;
  }

  protected InnerUnbinder<T> createUnbinder(T target) {
    return new InnerUnbinder(target);
  }

  protected static class InnerUnbinder<T extends QuickRegistrationFragment> implements Unbinder {
    private T target;

    View view2131558759;

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
      target.mTerminalModelTv = null;
      target.mProvinceIdTv = null;
      target.mManufacturerIdTv = null;
      target.mCityIdTv = null;
      target.mTerminalIdTv = null;
      target.mTerminalPhoneTv = null;
      target.mVehicleNoTv = null;
      target.mOwnerPhoneTv = null;
      target.mVehicleColorTv = null;
      target.mOwnerName = null;
      target.mVinTv = null;
      view2131558759.setOnClickListener(null);
      target.mRegistrationTv = null;
      target.mContentTv = null;
    }
  }
}
