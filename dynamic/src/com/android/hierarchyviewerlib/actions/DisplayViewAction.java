/*
 * Copyright (C) 2010 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.hierarchyviewerlib.actions;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.android.ddmuilib.ImageLoader;
import com.android.hierarchyviewerlib.HierarchyViewerDirector;

public class DisplayViewAction extends SelectedNodeEnabledAction implements ImageAction {

    private static DisplayViewAction sAction;

    private Image mImage;

    private Shell mShell;

    private DisplayViewAction(Shell shell) {
        super("&Display View");
        this.mShell = shell;
        setAccelerator(SWT.MOD1 + 'D');
        ImageLoader imageLoader = ImageLoader.getLoader(HierarchyViewerDirector.class);
        mImage = imageLoader.loadImage("display.png", Display.getDefault()); //$NON-NLS-1$
        setImageDescriptor(ImageDescriptor.createFromImage(mImage));
        setToolTipText("Display the selected view image in a separate window");
    }

    public static DisplayViewAction getAction(Shell shell) {
        if (sAction == null) {
            sAction = new DisplayViewAction(shell);
        }
        return sAction;
    }

    @Override
    public void run() {
        HierarchyViewerDirector.getDirector().showCapture(mShell);
    }

    @Override
    public Image getImage() {
        return mImage;
    }
}
