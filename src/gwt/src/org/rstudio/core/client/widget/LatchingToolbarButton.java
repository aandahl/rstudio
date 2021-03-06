/*
 * LatchingToolbarButton.java
 *
 * Copyright (C) 2009-14 by RStudio, Inc.
 *
 * Unless you have received this program directly from RStudio pursuant
 * to the terms of a commercial license agreement with RStudio, then
 * this program is licensed to you under the terms of version 3 of the
 * GNU Affero General Public License. This program is distributed WITHOUT
 * ANY EXPRESS OR IMPLIED WARRANTY, INCLUDING THOSE OF NON-INFRINGEMENT,
 * MERCHANTABILITY OR FITNESS FOR A PARTICULAR PURPOSE. Please refer to the
 * AGPL (http://www.gnu.org/licenses/agpl-3.0.txt) for more details.
 *
 */
package org.rstudio.core.client.widget;

import org.rstudio.core.client.theme.res.ThemeStyles;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.resources.client.ImageResource;

public class LatchingToolbarButton extends ToolbarButton
{

   public LatchingToolbarButton(String text, 
                                ImageResource leftImage,
                                ClickHandler clickHandler)
   {
      super(text, leftImage, clickHandler);
      onClicked_ = new ClickHandler()
      {
         @Override
         public void onClick(ClickEvent arg0)
         {
            latched_ = !latched_;
            if (latched_)
               getElement().addClassName(ThemeStyles.INSTANCE.toolbarButtonLatched());
            else
               getElement().removeClassName(ThemeStyles.INSTANCE.toolbarButtonLatched());
         }
      };
      addClickHandler(onClicked_);
      getElement().addClassName(ThemeStyles.INSTANCE.toolbarButtonLatchable());
   }
   
   private ClickHandler onClicked_;
   private boolean latched_ = false;
}
