// Generated code from Butter Knife. Do not modify!
package com.cvnavi.app.ui.activity;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import java.lang.Object;
import java.lang.Override;

public class EquipmentDetectionActivity$$ViewBinder<T extends EquipmentDetectionActivity> extends ToolbarActivity$$ViewBinder<T> {
  @Override
  public Unbinder bind(final Finder finder, final T target, Object source) {
    InnerUnbinder unbinder = (InnerUnbinder) super.bind(finder, target, source);
    View view;
    view = finder.findRequiredView(source, 2131558537, "field 'mViewpager'");
    target.mViewpager = finder.castView(view, 2131558537, "field 'mViewpager'");
    view = finder.findRequiredView(source, 2131558590, "field 'mTablayout'");
    target.mTablayout = finder.castView(view, 2131558590, "field 'mTablayout'");
    view = finder.findRequiredView(source, 2131558589, "field 'mToolbarLayuot'");
    target.mToolbarLayuot = finder.castView(view, 2131558589, "field 'mToolbarLayuot'");
    return unbinder;
  }

  @Override
  protected InnerUnbinder<T> createUnbinder(T target) {
    return new InnerUnbinder(target);
  }

  protected static class InnerUnbinder<T extends EquipmentDetectionActivity> extends ToolbarActivity$$ViewBinder.InnerUnbinder<T> {
    protected InnerUnbinder(T target) {
      super(target);
    }

    @Override
    protected void unbind(T target) {
      super.unbind(target);
      target.mViewpager = null;
      target.mTablayout = null;
      target.mToolbarLayuot = null;
    }
  }
}
