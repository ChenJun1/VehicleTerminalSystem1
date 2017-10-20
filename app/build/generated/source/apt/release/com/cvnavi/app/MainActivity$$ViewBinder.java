// Generated code from Butter Knife. Do not modify!
package com.cvnavi.app;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import com.cvnavi.app.ui.activity.ToolbarActivity$$ViewBinder;
import java.lang.Object;
import java.lang.Override;

public class MainActivity$$ViewBinder<T extends MainActivity> extends ToolbarActivity$$ViewBinder<T> {
  @Override
  public Unbinder bind(final Finder finder, final T target, Object source) {
    InnerUnbinder unbinder = (InnerUnbinder) super.bind(finder, target, source);
    View view;
    view = finder.findRequiredView(source, 2131558807, "field 'toolbar'");
    target.toolbar = finder.castView(view, 2131558807, "field 'toolbar'");
    view = finder.findRequiredView(source, 2131558815, "field 'tvLocalMusic'");
    target.tvLocalMusic = finder.castView(view, 2131558815, "field 'tvLocalMusic'");
    view = finder.findRequiredView(source, 2131558819, "field 'ivSearch'");
    target.ivSearch = finder.castView(view, 2131558819, "field 'ivSearch'");
    view = finder.findRequiredView(source, 2131558811, "field 'liftImagtwo'");
    target.liftImagtwo = finder.castView(view, 2131558811, "field 'liftImagtwo'");
    view = finder.findRequiredView(source, 2131558818, "field 'framelayout'");
    target.framelayout = finder.castView(view, 2131558818, "field 'framelayout'");
    view = finder.findRequiredView(source, 2131558537, "field 'viewpager'");
    target.viewpager = finder.castView(view, 2131558537, "field 'viewpager'");
    view = finder.findRequiredView(source, 2131558589, "field 'toolbarLayuot'");
    target.toolbarLayuot = finder.castView(view, 2131558589, "field 'toolbarLayuot'");
    view = finder.findRequiredView(source, 2131558591, "field 'layout'");
    target.layout = finder.castView(view, 2131558591, "field 'layout'");
    view = finder.findRequiredView(source, 2131558592, "field 'buttonFrameLayout'");
    target.buttonFrameLayout = finder.castView(view, 2131558592, "field 'buttonFrameLayout'");
    view = finder.findRequiredView(source, 2131558590, "field 'tablayout'");
    target.tablayout = finder.castView(view, 2131558590, "field 'tablayout'");
    return unbinder;
  }

  @Override
  protected InnerUnbinder<T> createUnbinder(T target) {
    return new InnerUnbinder(target);
  }

  protected static class InnerUnbinder<T extends MainActivity> extends ToolbarActivity$$ViewBinder.InnerUnbinder<T> {
    protected InnerUnbinder(T target) {
      super(target);
    }

    @Override
    protected void unbind(T target) {
      super.unbind(target);
      target.toolbar = null;
      target.tvLocalMusic = null;
      target.ivSearch = null;
      target.liftImagtwo = null;
      target.framelayout = null;
      target.viewpager = null;
      target.toolbarLayuot = null;
      target.layout = null;
      target.buttonFrameLayout = null;
      target.tablayout = null;
    }
  }
}
