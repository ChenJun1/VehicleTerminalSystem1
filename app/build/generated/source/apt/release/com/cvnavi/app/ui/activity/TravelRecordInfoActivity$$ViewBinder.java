// Generated code from Butter Knife. Do not modify!
package com.cvnavi.app.ui.activity;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Finder;
import java.lang.Object;
import java.lang.Override;

public class TravelRecordInfoActivity$$ViewBinder<T extends TravelRecordInfoActivity> extends ToolbarActivity$$ViewBinder<T> {
  @Override
  public Unbinder bind(final Finder finder, final T target, Object source) {
    InnerUnbinder unbinder = (InnerUnbinder) super.bind(finder, target, source);
    View view;
    view = finder.findRequiredView(source, 2131558621, "field 'traverecoreinfoViewpager'");
    target.traverecoreinfoViewpager = finder.castView(view, 2131558621, "field 'traverecoreinfoViewpager'");
    view = finder.findRequiredView(source, 2131558585, "field 'serialNumberView'");
    target.serialNumberView = finder.castView(view, 2131558585, "field 'serialNumberView'");
    view = finder.findRequiredView(source, 2131558620, "field 'liftImagView' and method 'onViewClicked'");
    target.liftImagView = finder.castView(view, 2131558620, "field 'liftImagView'");
    unbinder.view2131558620 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = finder.findRequiredView(source, 2131558622, "field 'rightImagView' and method 'onViewClicked'");
    target.rightImagView = finder.castView(view, 2131558622, "field 'rightImagView'");
    unbinder.view2131558622 = view;
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

  protected static class InnerUnbinder<T extends TravelRecordInfoActivity> extends ToolbarActivity$$ViewBinder.InnerUnbinder<T> {
    View view2131558620;

    View view2131558622;

    protected InnerUnbinder(T target) {
      super(target);
    }

    @Override
    protected void unbind(T target) {
      super.unbind(target);
      target.traverecoreinfoViewpager = null;
      target.serialNumberView = null;
      view2131558620.setOnClickListener(null);
      target.liftImagView = null;
      view2131558622.setOnClickListener(null);
      target.rightImagView = null;
    }
  }
}
