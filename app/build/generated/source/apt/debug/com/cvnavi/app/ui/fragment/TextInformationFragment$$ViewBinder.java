// Generated code from Butter Knife. Do not modify!
package com.cvnavi.app.ui.fragment;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class TextInformationFragment$$ViewBinder<T extends TextInformationFragment> implements ViewBinder<T> {
  @Override
  public Unbinder bind(final Finder finder, final T target, Object source) {
    InnerUnbinder unbinder = createUnbinder(target);
    View view;
    view = finder.findRequiredView(source, 2131558784, "field 'recyclerview'");
    target.recyclerview = finder.castView(view, 2131558784, "field 'recyclerview'");
    view = finder.findRequiredView(source, 2131558496, "field 'title'");
    target.title = finder.castView(view, 2131558496, "field 'title'");
    view = finder.findRequiredView(source, 2131558785, "field 'type'");
    target.type = finder.castView(view, 2131558785, "field 'type'");
    view = finder.findRequiredView(source, 2131558786, "field 'time'");
    target.time = finder.castView(view, 2131558786, "field 'time'");
    view = finder.findRequiredView(source, 2131558787, "field 'content'");
    target.content = finder.castView(view, 2131558787, "field 'content'");
    return unbinder;
  }

  protected InnerUnbinder<T> createUnbinder(T target) {
    return new InnerUnbinder(target);
  }

  protected static class InnerUnbinder<T extends TextInformationFragment> implements Unbinder {
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
      target.recyclerview = null;
      target.title = null;
      target.type = null;
      target.time = null;
      target.content = null;
    }
  }
}
