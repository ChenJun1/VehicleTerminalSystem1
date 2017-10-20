// Generated code from Butter Knife. Do not modify!
package com.cvnavi.app.ui.activity;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import java.lang.Object;
import java.lang.Override;

public class TriaxialStateActivity$$ViewBinder<T extends TriaxialStateActivity> extends ToolbarActivity$$ViewBinder<T> {
  @Override
  public Unbinder bind(final Finder finder, final T target, Object source) {
    InnerUnbinder unbinder = (InnerUnbinder) super.bind(finder, target, source);
    View view;
    view = finder.findRequiredView(source, 2131558592, "field 'tablayout'");
    target.tablayout = finder.castView(view, 2131558592, "field 'tablayout'");
    view = finder.findRequiredView(source, 2131558657, "field 'viewpagerView'");
    target.viewpagerView = finder.castView(view, 2131558657, "field 'viewpagerView'");
    return unbinder;
  }

  @Override
  protected InnerUnbinder<T> createUnbinder(T target) {
    return new InnerUnbinder(target);
  }

  protected static class InnerUnbinder<T extends TriaxialStateActivity> extends ToolbarActivity$$ViewBinder.InnerUnbinder<T> {
    protected InnerUnbinder(T target) {
      super(target);
    }

    @Override
    protected void unbind(T target) {
      super.unbind(target);
      target.tablayout = null;
      target.viewpagerView = null;
    }
  }
}
