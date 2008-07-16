/*
 * Copyright 2008 Adrian Buerki
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.google.gwt.gwtai.demo.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.gwtai.applet.client.AppletJSUtil;
import com.google.gwt.gwtai.trayicon.client.TrayIconApplet;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DisclosurePanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * The content of the <code>TrayIconApplet</code> demo tab.
 * 
 * @author Adrian Buerki <a.buerki@gmail.com>
 */
public class TrayIconAppletTab extends Composite {
	private TrayIconApplet _trayIconApplet;

	public TrayIconAppletTab() {
		VerticalPanel panelMain = new VerticalPanel();
		panelMain.setWidth("100%");
		panelMain.setSpacing(4);
		
		_trayIconApplet = (TrayIconApplet) GWT.create(TrayIconApplet.class);
		
		Widget widgetApplet = AppletJSUtil.createAppletWidget(_trayIconApplet);

		Label labelTitle = new Label("Hook into the desktop tray from a GWT application. This is a 'Proof of Concept', the feature is not finished yet.");
		DisclosurePanel panelCode = new DisclosurePanel("View code");
		panelCode.setWidth("100%");
		panelCode.setAnimationEnabled(true);
		panelCode.setContent(createCodeHTML());
		
		panelMain.add(labelTitle);
		panelMain.add(widgetApplet);
		panelMain.add(panelCode);
		
		panelMain.setCellHorizontalAlignment(labelTitle, VerticalPanel.ALIGN_CENTER);
		panelMain.setCellHorizontalAlignment(widgetApplet, VerticalPanel.ALIGN_CENTER);

		initWidget(panelMain);
	}

	/**
	 * Helper-Method to construct an HTML element containing some example code snippets.
	 */
	private HTML createCodeHTML() {
		String html =
			"<b>TrayIconAppletTab.java</b>" +
			"<pre>...\n" +
			"TrayIconApplet trayIconApplet = (TrayIconApplet) GWT.create(TrayIconApplet.class);\n" +
			"Widget widgetApplet = AppletJSUtil.createAppletWidget(trayIconApplet);\n" +
			"...\n" +
			"panelMain.add(widgetApplet);\n" +
			"initWidget(panelMain);\n" +
			"...</pre>";
		
			return new HTML(html);
	}

}
