// Generated code from Butter Knife. Do not modify!
package com.cvnavi.app.ui.activity;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class ToolbarActivity$$ViewBinder<T extends ToolbarActivity> implements ViewBinder<T> {
  @Override
  public Unbinder bind(final Finder finder, final T target, Object source) {
    InnerUnbinder unbinder = createUnbinder(target);
    View view;
    view = finder.findRequiredView(source, 2131558807, "field 'toolbar'");
    target.toolbar = finder.castView(view, 2131558807, "field 'toolbar'");
    view = finder.findRequiredView(source, 2131558808, "field 'framelayoutLiftHome'");
    target.framelayoutLiftHome = finder.castView(view, 2131558808, "field 'framelayoutLiftHome'");
    view = finder.findRequiredView(source, 2131558810, "field 'ImageViewLift'");
    target.ImageViewLift = finder.castView(view, 2131558810, "field 'ImageViewLift'");
    view = finder.findRequiredView(source, 2131558811, "field 'liftImagtwo'");
    target.liftImagtwo = finder.castView(view, 2131558811, "field 'liftImagtwo'");
    view = finder.findRequiredView(source, 2131558815, "field 'tvLocalMusic'");
    target.tvLocalMusic = finder.castView(view, 2131558815, "field 'tvLocalMusic'");
    view = finder.findRequiredView(source, 2131558821, "field 'toolbarBackText'");
    target.toolbarBackText = finder.castView(view, 2131558821, "field 'toolbarBackText'");
    view = finder.findRequiredView(source, 2131558819, "field 'ivSearch'");
    target.ivSearch = finder.castView(view, 2131558819, "field 'ivSearch'");
    view = finder.findRequiredView(source, 2131558809, "field 'imagviewLiftHome'");
    target.imagviewLiftHome = finder.castView(view, 2131558809, "field 'imagviewLiftHome'");
    view = finder.findRequiredView(source, 2131558818, "field 'framelayout'");
    target.framelayout = finder.castView(view, 2131558818, "field 'framelayout'");
    view = finder.findRequiredView(source, 2131558820, "field 'toolbarBackLayout'");
    target.toolbarBackLayout = finder.castView(view, 2131558820, "field 'toolbarBackLayout'");
    view = finder.findRequiredView(source, 2131558816, "field 'framelayoutRight'");
    target.framelayoutRight = finder.castView(view, 2131558816, "field 'framelayoutRight'");
    view = finder.findRequiredView(source, 2131558814, "field 'toolbargpstext'");
    target.toolbargpstext = finder.castView(view, 2131558814, "field 'toolbargpstext'");
    view = finder.findRequiredView(source, 2131558817, "field 'toolbarDangertext'");
    target.toolbarDangertext = finder.castView(view, 2131558817, "field 'toolbarDangertext'");
    view = finder.findRequiredView(source, 2131558790, "field 'toolbarNewstext'");
    target.toolbarNewstext = finder.castView(view, 2131558790, "field 'toolbarNewstext'");
    view = finder.findRequiredView(source, 2131558812, "field 'toolbarGpsLayout'");
    target.toolbarGpsLayout = finder.castView(view, 2131558812, "field 'toolbarGpsLayout'");
    view = finder.findRequiredView(source, 2131558813, "field 'weixing'");
    target.weixing = finder.castView(view, 2131558813, "field 'weixing'");
    return unbinder;
  }

  protected InnerUnbinder<T> createUnbinder(T target) {
    return new InnerUnbinder(target);
  }

  protected static class InnerUnbinder<T extends ToolbarActivity> implements Unbinder {
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
      target.toolbar = null;
      target.framelayoutLiftHome = null;
      target.ImageViewLift = null;
      target.liftImagtwo = null;
      target.tvLocalMusic = null;
      target.toolbarBackText = null;
      target.ivSearch = null;
      target.imagviewLiftHome = null;
      target.framelayout = null;
      target.toolbarBackLayout = null;
      target.framelayoutRight = null;
      target.toolbargpstext = null;
      target.toolbarDangertext = null;
      target.toolbarNewstext = null;
      target.toolbarGpsLayout = null;
      target.weixing = null;
    }
  }
}
