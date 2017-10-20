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
    view = finder.findRequiredView(source, 2131558906, "field 'toolbar'");
    target.toolbar = finder.castView(view, 2131558906, "field 'toolbar'");
    view = finder.findRequiredView(source, 2131558907, "field 'framelayoutLiftHome'");
    target.framelayoutLiftHome = finder.castView(view, 2131558907, "field 'framelayoutLiftHome'");
    view = finder.findRequiredView(source, 2131558909, "field 'ImageViewLift'");
    target.ImageViewLift = finder.castView(view, 2131558909, "field 'ImageViewLift'");
    view = finder.findRequiredView(source, 2131558910, "field 'liftImagtwo'");
    target.liftImagtwo = finder.castView(view, 2131558910, "field 'liftImagtwo'");
    view = finder.findRequiredView(source, 2131558914, "field 'tvLocalMusic'");
    target.tvLocalMusic = finder.castView(view, 2131558914, "field 'tvLocalMusic'");
    view = finder.findRequiredView(source, 2131558920, "field 'toolbarBackText'");
    target.toolbarBackText = finder.castView(view, 2131558920, "field 'toolbarBackText'");
    view = finder.findRequiredView(source, 2131558918, "field 'ivSearch'");
    target.ivSearch = finder.castView(view, 2131558918, "field 'ivSearch'");
    view = finder.findRequiredView(source, 2131558908, "field 'imagviewLiftHome'");
    target.imagviewLiftHome = finder.castView(view, 2131558908, "field 'imagviewLiftHome'");
    view = finder.findRequiredView(source, 2131558917, "field 'framelayout'");
    target.framelayout = finder.castView(view, 2131558917, "field 'framelayout'");
    view = finder.findRequiredView(source, 2131558919, "field 'toolbarBackLayout'");
    target.toolbarBackLayout = finder.castView(view, 2131558919, "field 'toolbarBackLayout'");
    view = finder.findRequiredView(source, 2131558915, "field 'framelayoutRight'");
    target.framelayoutRight = finder.castView(view, 2131558915, "field 'framelayoutRight'");
    view = finder.findRequiredView(source, 2131558913, "field 'toolbargpstext'");
    target.toolbargpstext = finder.castView(view, 2131558913, "field 'toolbargpstext'");
    view = finder.findRequiredView(source, 2131558916, "field 'toolbarDangertext'");
    target.toolbarDangertext = finder.castView(view, 2131558916, "field 'toolbarDangertext'");
    view = finder.findRequiredView(source, 2131558873, "field 'toolbarNewstext'");
    target.toolbarNewstext = finder.castView(view, 2131558873, "field 'toolbarNewstext'");
    view = finder.findRequiredView(source, 2131558911, "field 'toolbarGpsLayout'");
    target.toolbarGpsLayout = finder.castView(view, 2131558911, "field 'toolbarGpsLayout'");
    view = finder.findRequiredView(source, 2131558912, "field 'weixing'");
    target.weixing = finder.castView(view, 2131558912, "field 'weixing'");
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
