// Generated code from Butter Knife. Do not modify!
package com.cvnavi.app.ui.activity;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import java.lang.Object;
import java.lang.Override;

public class AccidentGraphActivity$$ViewBinder<T extends AccidentGraphActivity> extends ToolbarActivity$$ViewBinder<T> {
  @Override
  public Unbinder bind(final Finder finder, final T target, Object source) {
    InnerUnbinder unbinder = (InnerUnbinder) super.bind(finder, target, source);
    View view;
    view = finder.findRequiredView(source, 2131558543, "field 'mEndTimeTv'");
    target.mEndTimeTv = finder.castView(view, 2131558543, "field 'mEndTimeTv'");
    view = finder.findRequiredView(source, 2131558544, "field 'mLongitudeTv'");
    target.mLongitudeTv = finder.castView(view, 2131558544, "field 'mLongitudeTv'");
    view = finder.findRequiredView(source, 2131558545, "field 'mLatitudeTv'");
    target.mLatitudeTv = finder.castView(view, 2131558545, "field 'mLatitudeTv'");
    view = finder.findRequiredView(source, 2131558546, "field 'mAltitudeTv'");
    target.mAltitudeTv = finder.castView(view, 2131558546, "field 'mAltitudeTv'");
    view = finder.findRequiredView(source, 2131558542, "field 'mLineChart'");
    target.mLineChart = finder.castView(view, 2131558542, "field 'mLineChart'");
    return unbinder;
  }

  @Override
  protected InnerUnbinder<T> createUnbinder(T target) {
    return new InnerUnbinder(target);
  }

  protected static class InnerUnbinder<T extends AccidentGraphActivity> extends ToolbarActivity$$ViewBinder.InnerUnbinder<T> {
    protected InnerUnbinder(T target) {
      super(target);
    }

    @Override
    protected void unbind(T target) {
      super.unbind(target);
      target.mEndTimeTv = null;
      target.mLongitudeTv = null;
      target.mLatitudeTv = null;
      target.mAltitudeTv = null;
      target.mLineChart = null;
    }
  }
}
