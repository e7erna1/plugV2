package com.intellij.plugin;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;
import org.jetbrains.annotations.NotNull;

public class GUI implements ToolWindowFactory {

  private String rEmail;
  private String yEmail;
  private String tEmail;
  private String yPass;
  private String aText;

  public String getREmail() {
    return rEmail;
  }

  public void setREmail(final String rEmail) {
    this.rEmail = rEmail;
  }

  public String getYEmail() {
    return yEmail;
  }

  public void setYEmail(final String yEmail) {
    this.yEmail = yEmail;
  }

  public String getTEmail() {
    return tEmail;
  }

  public void setTEmail(final String tEmail) {
    this.tEmail = tEmail;
  }

  public String getYPass() {
    return yPass;
  }

  public void setYPass(final String yPass) {
    this.yPass = yPass;
  }

  public String getAText() {
    return aText;
  }

  public void setAText(final String aText) {
    this.aText = aText;
  }

  @Override
  public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {
    MyToolWindow myToolWindow = new MyToolWindow(toolWindow);
    ContentFactory contentFactory = ContentFactory.SERVICE.getInstance();
    Content content = contentFactory.createContent(myToolWindow.getContent(), "", false);
    toolWindow.getContentManager().addContent(content);
  }

  @Override
  public void init(ToolWindow window) {
    
  }

  @Override
  public boolean shouldBeAvailable(@NotNull Project project) {
    return true;
  }

  @Override
  public boolean isDoNotActivateOnStart() {
    return false;
  }
}