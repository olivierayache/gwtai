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

package com.google.gwt.gwtai.applet.client;

import java.util.HashMap;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;

/**
 * GWT-side utility class.
 * 
 * @author Adrian Buerki <a.buerki@gmail.com>
 */ 
public class AppletJSUtil {

	static {
		CallbackUtil.defineBridgeMethod();
	}
	
	public static Widget createAppletWidget(Applet applet) {
		if (applet instanceof AppletAccomplice) {
			AppletAccomplice aapplet = (AppletAccomplice) applet;
			
			String htmlCode = "<applet mayscript='true'" + " code='" + aapplet.getCode() +
					"' width='" + aapplet.getWidth() + "' height='" + aapplet.getHeight() +
					"' name='" + aapplet.getName() + "' id='" + aapplet.getName() +
					"' alt='Java Runtime Environment is not working on your system'";

			if (null != aapplet.getCodebase()) {
				htmlCode += "codebase='" + aapplet.getCodebase() +"'";
			}
			
			if (null != aapplet.getArchive()) {
				htmlCode += "archive='" + aapplet.getArchive() +"'";
			}
			
			if (null != aapplet.getAlign()) {
				htmlCode += "align='" + aapplet.getAlign() +"'";
			}

			htmlCode += ">";

			HashMap<String, String> parameters = aapplet.getParameters();
			
			if (parameters != null && !parameters.isEmpty()) {
				for (String name: parameters.keySet()) {
					htmlCode += "<param name='";
					htmlCode += name;
					htmlCode += "' value='";
					htmlCode += parameters.get(name);
					htmlCode += "'>";
				}
			}
				
			htmlCode +=	"</applet>";
			
			return new HTML(htmlCode);
		}
		
		return null;
	}
	
	public static Widget createAppletWidget(Applet applet, String forceJavaVersion) {
		if (applet instanceof AppletAccomplice) {
			AppletAccomplice aapplet = (AppletAccomplice) applet;
			
			String codebase = GWT.getModuleBaseURL();
			
			String htmlCode = "<p style='text-align: center;'><script src='http://java.com/js/deployJava.js'></script>" +
					"<script>deployJava.runApplet({codebase:'" + codebase + "', ";
			
			if (null != aapplet.getArchive()) {
				htmlCode += "archive:'" + aapplet.getArchive() +"', ";
			}
			
			htmlCode += "code:'" +aapplet.getCode() +"', width:'" + aapplet.getWidth()
					+"', Height:'" + aapplet.getHeight() +"'}, null, '" + forceJavaVersion +"');" +
					"</script></p>";

			return new HTML(htmlCode);
		}
		
		return null;
	}
	
	public static void registerAppletCallback(Applet applet, AppletCallback appletCallback) {
		if (applet instanceof AppletAccomplice) {
			AppletAccomplice aapplet = (AppletAccomplice) applet;
			
			CallbackUtil.registerCallback(aapplet.getName(), appletCallback);
		}
	}

	public static void call(Applet applet, String methodName) {
		if (applet instanceof AppletAccomplice) {
			String id = ((AppletAccomplice) applet).getId();
			Element elem = DOM.getElementById(id);
			
			call(elem, methodName);
		}
	}
	
	private static native Object call(Element elem, String methodName) /*-{
		var theFunc = elem[methodName];
		return theFunc();
	}-*/;

}
