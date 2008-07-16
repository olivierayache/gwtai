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

import com.google.gwt.gwtai.applet.client.Applet;
import com.google.gwt.gwtai.applet.client.Archive;
import com.google.gwt.gwtai.applet.client.Height;
import com.google.gwt.gwtai.applet.client.ImplementingClass;
import com.google.gwt.gwtai.applet.client.Width;

@ImplementingClass(com.google.gwt.gwtai.demo.impl.CounterAppletImpl.class)
@Height(60)
@Width(350)
@Archive("GwtAI-Core.jar,GwtAI-Demo.jar")
public interface CounterApplet extends Applet {
		
	public void increment();
	
	public void decrement();
	
	public Object getCurrentValue();

}